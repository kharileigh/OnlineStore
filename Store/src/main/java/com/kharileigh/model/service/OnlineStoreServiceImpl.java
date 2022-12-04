/**
 *
 * @author kharileigh
 */

package com.kharileigh.model.service;

import com.kharileigh.entity.Buyer;
import com.kharileigh.entity.Product;
import com.kharileigh.entity.Receipt;
import com.kharileigh.model.persistence.BuyerDao;
import com.kharileigh.model.persistence.ProductDao;
import java.util.Collection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("service")
public class OnlineStoreServiceImpl  implements OnlineStoreService {
    
    //=== Automatically configures DAO dependency to be used by Service
    @Autowired
    private BuyerDao dao;
    private ProductDao productDao;

    @Override
    public Buyer login(int buyerId, String password) {
        
        // TRY - to get Customer by fetching their ID & Password
        try {
        
            Buyer buyer = dao.findByBuyerIdAndBuyerPassword(buyerId, password);
            return buyer;
            
        } catch (Exception exception) {
        
            return null;
        }
    }

    // ===== GETS ALL PRODUCTS FROM DATABASE
    @Override
    public Collection<Product> showAllProducts() {
        
        return productDao.findAll();
    }
    
    
    
    // ==== PRODUCE RECEIPT

    @Override
    public Receipt buyerReceipt(int buyerId, int productId, int quantity) {
        
        // GET ID FOR BOTH BUYER & PRODUCT
        Buyer buyer = dao.findById(buyerId).orElse(null);
        Product product = productDao.findById(productId).orElse(null);
        
        
        // CHECK IF BUYER & PRODUCT EXIST, AND IF QUANTITY OF PRODUCT IS LESS THAN ITS STOCK
        if((buyer != null && product != null) && (quantity < product.getStock())) {
        
            // convert int data type of quantity to double data type to match price
            double newQuantity = quantity;
            
            // if exists calculate cost for buyer
            double cost = newQuantity * (product.getPrice());
            
            // update buyer balance
            double updatedBalance = dao.updateBuyerBalance(cost, buyerId);
            
            // update stock
            int updatedStock = productDao.updateProductStock(quantity, productId);
            
        
            // return receipt if successful purchase, null if not
            if(cost < (buyer.getBuyerBalance()) && (updatedStock != 0)) {
            
                return new Receipt();
                
            } else {
            
                return null;
            }
            
        } else {
            
            return null;
        }
    }
    
    
    
    
}
