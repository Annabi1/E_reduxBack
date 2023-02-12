package com.insy2s.E_Redux.Repository;

import com.insy2s.E_Redux.Entites.Userr;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository

public interface UserRepository extends JpaRepository<Userr,String>{
	  Optional<Userr> findUserrByUserName(String email);

}
