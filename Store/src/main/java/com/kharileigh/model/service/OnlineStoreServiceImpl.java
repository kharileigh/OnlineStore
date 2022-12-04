/**
 *
 * @author kharileigh
 */

package com.kharileigh.model.service;

import com.kharileigh.entity.Buyer;
import com.kharileigh.model.persistence.BuyerDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("service")
public class OnlineStoreServiceImpl  implements OnlineStoreService {
    
    // Automatically configures DAO dependency to be used by Service
    @Autowired
    private BuyerDao dao;

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
    
    
    
}
