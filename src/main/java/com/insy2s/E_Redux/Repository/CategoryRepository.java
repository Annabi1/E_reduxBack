package com.insy2s.E_Redux.Repository;

import com.insy2s.E_Redux.Entites.Category;
import com.insy2s.E_Redux.Entites.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface CategoryRepository extends JpaRepository<Category, Integer> {
    @Query("SELECT u FROM Category u WHERE u.name = :name")
    Optional<Category> finCategoryByName(String name);
}
