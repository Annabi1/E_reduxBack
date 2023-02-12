package com.insy2s.E_Redux.Controller;

import com.insy2s.E_Redux.Entites.Category;
import com.insy2s.E_Redux.Entites.Product;
import com.insy2s.E_Redux.Services.CategoryServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URISyntaxException;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/category")
//open for all ports
@CrossOrigin(origins = "*")
public class CategoryController {
	 private final Logger log = LoggerFactory.getLogger(Product.class);


		@Autowired
		private CategoryServiceImpl categoryServiceImpl;
		@GetMapping("/")
		   public List<Category> getAllCategory( )  {
		        log.debug("REST request to get all  Category : {}");
		           return categoryServiceImpl.findAll();
		    }
		@GetMapping("/products/{id}")
		   public List<Product> getAllProducOfCategory( @PathVariable Integer id)  {
		        log.debug("REST request to get all  Category : {}");
		           return categoryServiceImpl.findAllProduct(id);
		    }
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteCategory( @PathVariable Integer id)  {
		categoryServiceImpl.delete(id);
		return ResponseEntity.status(200).build();
	}





	@PostMapping("/")
		   public ResponseEntity<Category> createCategory( @RequestBody Category category) throws URISyntaxException {
		        log.debug("REST request to save category : {}", category);
		        
		        Category result = categoryServiceImpl.save(category);
				if(result== null )
				{

					return ResponseEntity.status(201)
							.body(category);
				}
				else{
					return ResponseEntity.status(302)
							.body(category);
				}

		    }
		@GetMapping("/categoryId/{id}")
		   public ResponseEntity<Category> getCategoryById( @PathVariable Integer id) throws URISyntaxException {
		        log.debug("REST request to find category by id : {}", id);
		        
		        Optional<Category> result = categoryServiceImpl.getCategoryById(id);
		        return ResponseEntity.status(200)
		                .body(result.get());
		    }
}
