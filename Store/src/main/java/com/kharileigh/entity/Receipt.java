/**
 *
 * @author kharileigh
 */

package com.kharileigh.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Receipt {
    
    private Buyer buyer;
    private Product product;
    private int totalProducts;
    private double totalCost;
}
