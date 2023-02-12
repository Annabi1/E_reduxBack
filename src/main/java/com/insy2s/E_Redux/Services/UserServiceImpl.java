package com.insy2s.E_Redux.Services;

import com.insy2s.E_Redux.Entites.AES256;
import com.insy2s.E_Redux.Entites.Product;
import com.insy2s.E_Redux.Entites.Userr;
import com.insy2s.E_Redux.Repository.UserRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
@Transactional

public class UserServiceImpl implements IUserService {
@Autowired
private UserRepository userRepo;

	@Override
	public Userr registerNewUser(Userr user) {
		Optional<Userr> userSerched=userRepo.findUserrByUserName(user.getUserName());
		if(userSerched.isEmpty())
		{
			return userRepo.save(user);

		}
		return null;
	}

	@Override
	public List<Userr> findAllUsers() {
		return userRepo.findAll();
	}

	@Override
	public boolean authentification(String username, String password) {
		Optional<Userr> userSerched=userRepo.findUserrByUserName(username);
		 String passwordUser=(userSerched.get()).getPassword();
		String userSerchedPassword = AES256.decrypt(passwordUser);
		if(userSerched.isEmpty())
		{
			return false;
		}
		else
		{
			if( userSerchedPassword.compareTo(password)==0)
			{
					  return true ;
			}
                   else return false;
		}


	}

}
