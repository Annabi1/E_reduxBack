package com.insy2s.E_Redux.User;

import com.insy2s.E_Redux.Entites.Role;
import com.insy2s.E_Redux.Entites.Userr;
import com.insy2s.E_Redux.Repository.RoleRepository;
import com.insy2s.E_Redux.Repository.UserRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@DataJpaTest(showSql = true)
@AutoConfigureTestDatabase(replace = Replace.NONE)
@Rollback(false)
public class UserTestsRepository {
	
	@Autowired
	private RoleRepository roleRepository;
	@Autowired
	private UserRepository userRepository;
	/*
	@Test
	public void testCreateUserWithRoledmin() {
		boolean isexiste=false;
	Optional<Role> roleAdminRole=	roleRepository.findRoleByName("ADMIN");
	Optional<Role> roleUserRole=	roleRepository.findRoleByName("User");

	Set<Role>roles=new HashSet<>();
	roles.add(roleAdminRole.get());
	roles.add(roleUserRole.get());
	Userr mabroukaUserr=new Userr();
	mabroukaUserr.setUserName("annabi.mabrouka9kkk6tt@gmail.com");
	mabroukaUserr.setFirstName("annabi");	
	mabroukaUserr.setLastName("mabrouka");
	mabroukaUserr.setPassword("mabrouka1234569");
	mabroukaUserr.setRole(roles);
if(userRepository.findUserrByUserName(mabroukaUserr.getUserName()).isEmpty())
{     
	isexiste=true;
	
}
else 
{
	isexiste=false;
}
  Userr resultUserr= userRepository.save(mabroukaUserr);
  Assertions.assertTrue(isexiste);

	
} */
		
		
		
	}


