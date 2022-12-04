/**
 *
 * @author kharileigh
 */


package com.kharileigh.controller;

import com.kharileigh.entity.Buyer;
import com.kharileigh.model.service.OnlineStoreService;
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
    
}
