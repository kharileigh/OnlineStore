/**
 *
 * @author kharileigh
 */

package com.kharileigh.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;


@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
@Table(name = "Product")
public class Product {
    
    @Id
    @Column(name = "PRODUCT_ID")
    private int productId;
    
    
    @Column(name = "PRODUCT_NAME")
    private String productName;
    
    
    @Column(name = "COST_PER_UNIT")
    private double price;
    
    
    @Column(name = "STOCK")
    private int stock;
    
}
