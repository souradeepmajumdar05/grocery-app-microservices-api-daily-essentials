package com.daily.essentials.itemservice.model;

import com.daily.essentials.itemservice.itemconstants.Currency;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Pattern;

import java.io.Serializable;
import java.sql.Timestamp;

@Entity
@Table(name = "itemcatalog", uniqueConstraints = {
        @UniqueConstraint(columnNames = "id") })
@Data
public class Itemcatalog implements Serializable
{
	
    public Itemcatalog() {
		//super();
	}
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true, nullable = false)
    Integer id ;

	@Column(name = "item_id", unique = true, nullable = false)
	Integer itemId;

	@Column(name = "price", unique = true, nullable = false, length = 100)
    @DecimalMin(value="1")
    Integer price ;
    @Column(name = "currency_short", unique = true, nullable = false, length = 100)
    @Pattern(regexp = "INR")
    String currencyShort;
    @Column(name = "qty", unique = true, nullable = false, length = 100)
    @DecimalMin(value="1")
    Integer qty;
    @Pattern(regexp = "kg|gm|l|kl|psc")
    @Column(name = "qty_type", unique = true, nullable = false, length = 3)
    String qtyType;
    @Column(name = "time_of_entry", unique = true, nullable = false, length = 100)
    Timestamp timeOfEntry;
    @Column(name = "time_of_expire", unique = true, nullable = false, length = 100)
    Timestamp timeOfExpire ;


}
