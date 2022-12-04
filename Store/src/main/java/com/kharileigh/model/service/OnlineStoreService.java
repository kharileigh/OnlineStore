/**
 *
 * @author kharileigh
 */

package com.kharileigh.model.service;

import com.kharileigh.entity.Buyer;


public interface OnlineStoreService {
    
    // GET BUYER OBJECT - to validate login credentials
    Buyer login(int buyerId, String password);
}
