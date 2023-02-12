package com.insy2s.E_Redux.Entites;

import jakarta.persistence.*;
import lombok.Data;

import java.beans.Transient;



@Data
@Entity
public class Product {

	@Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int productId;
    private String name;
  
    private double price;
    private String image;
    @ManyToOne(optional = false)
	 @JoinColumn(name="category_id") private Category category;
    


    @Transient
    public String getPhotosImagePath() {
        if (image == null || productId == 0) return null;
         
        return "/products-photos/" + productId + "/" + image;
    }
    
}
