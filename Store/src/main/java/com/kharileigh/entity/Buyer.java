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
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
@Table(name = "Buyer")
public class Buyer {
    
    
    @Id
    @Column(name = "BUYER_ID")
    private int buyerId;
    
    
    @Column(name = "BUYER_NAME")
    private String buyerName;
    
    
    @Column(name = "BUYER_PASSWORD")
    private String buyerPassword;
    
    
    @Column(name = "BUYER_BALANCE")
    private double buyerBalance;
}
