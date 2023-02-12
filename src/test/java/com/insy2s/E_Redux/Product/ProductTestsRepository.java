package com.insy2s.E_Redux.Product;

import com.insy2s.E_Redux.Entites.*;
import com.insy2s.E_Redux.Repository.CategoryRepository;
import com.insy2s.E_Redux.Repository.ProductRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;

import java.util.Optional;

@DataJpaTest(showSql = true)
@AutoConfigureTestDatabase(replace = Replace.NONE)
@Rollback(false)

public class ProductTestsRepository {
	@Autowired
	private ProductRepository repo;
	@Autowired
	private CategoryRepository categoryRepository;
	
	  @Test 
	  public void testCreateProduct() 
	  { boolean isexiste=false;
		  Optional<Category> category=categoryRepository.findById(1);
	  Product product=new Product();
	  product.setCategory(category.get());
	  product.setName("Cerise");
	  product.setPrice(6);
	  if(repo.findProductByName(product.getName()).isEmpty())
	  {
		  isexiste=true;
		  Product resultProduct=repo.save(product);

	  }
	  else isexiste=false;
	  Assertions.assertTrue(isexiste);

	  
	  }
	 
}
