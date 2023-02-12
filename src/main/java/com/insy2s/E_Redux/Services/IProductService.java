package com.insy2s.E_Redux.Services;
import java.util.List;
import java.util.Optional;

import com.insy2s.E_Redux.Entites.Product;

public interface IProductService {
    public List<Product> findAll();
    public Product save(Product product);
    public void delete(Integer id);
    public  Optional<Product> getProductById(Integer id);
    public boolean getProductByName(String name );

    public Product updateProduct(Product product);

}

