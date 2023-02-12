package com.insy2s.E_Redux.Repository;

import com.insy2s.E_Redux.Entites.Panier;
import com.insy2s.E_Redux.Entites.Product;
import com.insy2s.E_Redux.Entites.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface RoleRepository extends JpaRepository<Panier, Integer> {
    @Query("SELECT u FROM Role u WHERE u.name = :name")
    Optional<Role>findProductByName(String name);
}
