/**
 *
 * @author kharileigh
 */


package com.kharileigh.controller;

import com.kharileigh.entity.Buyer;
import com.kharileigh.entity.Product;
import com.kharileigh.entity.Receipt;
import com.kharileigh.model.service.OnlineStoreService;
import java.util.Collection;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class OnlineStoreController {
    
    
    @Autowired
    private OnlineStoreService service;
    
    
    @RequestMapping("/")
    public ModelAndView loginPageController() {
    
        return new ModelAndView("index");
    }
    
    
    //====================== LOGIN
    // ModelAttribute - used when taking the full object / record from database
    // RequestParam - used when taking partial data from object / record from database
    @RequestMapping("/login")
    public ModelAndView loginController(@RequestParam("buyerId") int id, @RequestParam("buyerPassword") String password, HttpSession session) {
    
        ModelAndView modelAndView = new ModelAndView();
        Buyer buyer = service.login(id, password);
        
        if (buyer != null) {
        
            // setting logged in customer object to the session
            // attribute name must match label in view
            session.setAttribute("buyer", buyer);
            modelAndView.setViewName("ProductPage");
            
        } else {
        
            // if unsuccessful login, prompt user to try again
            modelAndView.addObject("message", "Invalid login, Please try again");
            modelAndView.setViewName("index");
        }
        
        return modelAndView;
    }
    
    
    //================ SHOW PRODUCTS TO BUYER
    // After Buyer logs in, shown all products that are available
    @RequestMapping("/productPage")
    public ModelAndView productPageController() {
    
        ModelAndView modelAndView = new ModelAndView();
        
        // calls Service to return all products in a Collection
        Collection<Product> products = service.showAllProducts();
        
        modelAndView.addObject("products", products);
        
        modelAndView.setViewName("ProductPage");
        
        return modelAndView;
    }
    
    // Shows buyer product lists, and form to purchase then displays receipt
    //================ COMPLETE PURCHASE
    @RequestMapping("/purchase")
    public ModelAndView checkoutController(@RequestParam("productId") int id, @RequestParam("quantity") int quantity, HttpServlet request, HttpSession session) {
    
        ModelAndView modelAndView = new ModelAndView();
        
        // FIRST DISPLAYS PRODUCTS FOR BUYER TO CHOOSE FROM
        Collection<Product> products = service.showAllProducts();
        modelAndView.addObject("products", products);
        
        // GET CURRENT BUYER OF SESSION, then grab their id
        Buyer currentBuyer = (Buyer)session.getAttribute("buyer");
        int currentBuyerId = currentBuyer.getBuyerId();
        
        // NEW MAV FOR PROCESSING PURCHASE
        ModelAndView mav = new ModelAndView();
        int product = Integer.parseInt("productId");
        int quantityOfProduct = Integer.parseInt("quantity");
        
        
        // GET RECEIPT OBJECT - ADD DETAILS FROM PURCHASE - PRINT TO BUYER
        Receipt currentBuyerReceipt = service.buyerReceipt(currentBuyerId, product, quantityOfProduct);
        
        if (currentBuyerReceipt != null) {
        
            mav.addObject("receipt", currentBuyerReceipt);
            mav.setViewName("Receipt");
            
        } else {
        
            mav.addObject("message", "Purchase failed, please check you have enough money to make purchas.");
            mav.setViewName("Output");
        }
        
        
        
        return mav;
   
    }
    
}
