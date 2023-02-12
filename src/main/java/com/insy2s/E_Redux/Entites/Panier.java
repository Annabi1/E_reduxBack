package com.insy2s.E_Redux.Entites;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Set;

@Data
@Entity
public class Panier {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int panierId;
	private String imageProduct;
	private String reference;
	private int qty;
	private double price;


}
