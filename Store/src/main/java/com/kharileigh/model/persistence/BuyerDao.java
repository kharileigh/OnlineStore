/**
 *
 * @author kharileigh
 */

package com.kharileigh.model.persistence;

import com.kharileigh.entity.Buyer;
import javax.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

// <Entity, Data Type>
@Repository("dao")
public interface BuyerDao extends JpaRepository<Buyer, Integer> {
    
    public Buyer findByBuyerIdAndBuyerPassword(int login, String password);
    
    
    // UPDATES BUYER'S BALANCE BY DEDUCTING THE PRICE OF PRODUCTS PURCHASED
    @Modifying
    @Transactional
    @Query("UPDATE Buyer SET BUYER_BALANCE = BUYER_BALANCE-:price WHERE BUYER_ID = :id")
    double updateBuyerBalance(@Param("price") double price, @Param("id") int id);
}
