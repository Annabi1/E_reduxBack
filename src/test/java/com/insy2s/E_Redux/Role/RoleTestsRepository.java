package com.insy2s.E_Redux.Role;

import com.insy2s.E_Redux.Entites.Category;
import com.insy2s.E_Redux.Entites.Product;
import com.insy2s.E_Redux.Entites.Role;
import com.insy2s.E_Redux.Repository.RoleRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;

import java.util.Optional;

@DataJpaTest(showSql = true)
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@Rollback(false)

public class RoleTestsRepository {
    @Autowired
    private RoleRepository roleRepo;
    @Test
    public void testCreateRole()
    { boolean isexiste=false;
Role admin=new Role("ADMIN","");
        Role user=new Role("User","");
        if(roleRepo.findProductByName(admin.getName()  ).isEmpty()   ||roleRepo.findProductByName(admin.getName()  ).isEmpty() )
        {
            isexiste=true;
        }
        else isexiste=false;

        Assertions.assertTrue(isexiste);


    }
}