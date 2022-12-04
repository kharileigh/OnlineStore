/**
 *
 * @author kharileigh
 */

package com.kharileigh.model.persistence;

import com.kharileigh.entity.Buyer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository("dao")
public interface BuyerDao extends JpaRepository<Buyer, Integer> {
    
    public Buyer findByBuyerIdAndBuyerPassword(int login, String password);
    
}
