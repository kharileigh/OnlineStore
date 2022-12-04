/**
 *
 * @author kharileigh
 */

package com.kharileigh.model.service;

import com.kharileigh.entity.Buyer;
import com.kharileigh.entity.Product;
import java.util.Collection;
import java.util.List;


public interface OnlineStoreService {
    
    // GET BUYER OBJECT - to validate login credentials
    Buyer login(int buyerId, String password);
    
    
    // SHOW PRODUCTS TO BUYER
    Collection<Product> showAllProducts();
}
