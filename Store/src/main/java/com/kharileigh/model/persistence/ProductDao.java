/**
 *
 * @author kharileigh
 */

package com.kharileigh.model.persistence;

import com.kharileigh.entity.Product;
import javax.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductDao extends JpaRepository<Product, Integer> {
    
    // UPDATES BUYER'S BALANCE BY DEDUCTING THE PRICE OF PRODUCTS PURCHASED
    @Modifying
    @Transactional
    @Query("UPDATE Product SET STOCK = STOCK - :quantity WHERE PRODUCT_ID = :id")
    int updateProductStock(@Param("quantity") int quantity, @Param("id") int id);
}
