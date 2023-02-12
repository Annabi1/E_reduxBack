package com.insy2s.E_Redux.Entites;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Set;
@Data
@Entity
public class Category {
	 @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
 private int categoryId;
 private String name;

	
	  @OneToMany
	  private Set<Product> products;
	 
 
}
