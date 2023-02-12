package com.insy2s.E_Redux.Services;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.insy2s.E_Redux.Entites.Product;
import com.insy2s.E_Redux.Repository.ProductRepository;

import jakarta.transaction.Transactional;
@Service
@Transactional

public class ProductServiceImpl implements IProductService {
    @Autowired
    private ProductRepository productRepo;
    @Override
    public List<Product> findAll() {
        // TODO Auto-generated method stub
        return productRepo.findAll();
    }

    @Override
    public Product save(Product product) {
        // TODO Auto-generated method stub
        return productRepo.save(product);

    }

    @Override
    public void delete(Integer id) {
        // TODO Auto-generated method stub
        productRepo.deleteById(id);
    }

    @Override
    public Optional<Product> getProductById(Integer id) {
        // TODO Auto-generated method stub
        return productRepo.findById(id);
    }

    @Override
    public boolean getProductByName(String name) {
        boolean existe=false;
        Optional <Product> productSerched= productRepo.findProductByName(name);
        if( productSerched.isEmpty())
        {
            return  existe ;

        }
        else 		return existe=true;
    }

    @Override
    public Product updateProduct(Product product) {
        // TODO Auto-generated method stub
        return null;
    }

}

