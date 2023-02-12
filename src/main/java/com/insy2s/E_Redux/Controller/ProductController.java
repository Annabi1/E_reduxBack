package com.insy2s.E_Redux.Controller;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Optional;


import com.insy2s.E_Redux.Entites.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import com.insy2s.E_Redux.Entites.Product;
import com.insy2s.E_Redux.Services.ProductServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@RestController
@RequestMapping("/api/product")
@CrossOrigin(origins = "*")


public class ProductController {
    private final Logger log = LoggerFactory.getLogger(Product.class);


    @Autowired
    private ProductServiceImpl productServiceImpl;

    @GetMapping("/")
    public List<Product> getAllProducts( )  {
        log.debug("REST request to get all  Products : {}");
        return productServiceImpl.findAll();
    }
    @PostMapping(path = "/")
    public ResponseEntity<Product> createProduct( @RequestBody Product product) throws IOException {
        boolean result = productServiceImpl.getProductByName(product.getName());

        if(result== false )
        {
            Product resultSaved = productServiceImpl.save(product);

            return ResponseEntity.status(201)
                    .body(resultSaved);
        }
        else{
            return ResponseEntity.status(302)
                    .body(null);
        }

    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProduct( @PathVariable Integer id)  {
        productServiceImpl.delete(id);
        return ResponseEntity.status(200).build();
    }

}
