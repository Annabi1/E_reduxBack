package com.insy2s.E_Redux.Repository;

import com.insy2s.E_Redux.Entites.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ProductRepository extends JpaRepository<Product,Integer> {
    @Query("SELECT u FROM Product u WHERE u.category.categoryId = :id")
    List<Product> findProductByCategory(Integer id);

    @Query("SELECT u FROM Product u WHERE u.name = :name")
    Optional<Product> findProductByName(String name);

}

