package com.insy2s.E_Redux.Controller;

import com.insy2s.E_Redux.Entites.AES256;
import com.insy2s.E_Redux.Entites.Category;
import com.insy2s.E_Redux.Entites.UserAuth;
import com.insy2s.E_Redux.Entites.Userr;
import com.insy2s.E_Redux.Repository.UserRepository;
import com.insy2s.E_Redux.Services.UserServiceImpl;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URISyntaxException;
import java.util.List;
import java.util.Optional;

@RestController

@RequestMapping("/api/auth")

public class UserController {
	@Autowired
	private UserServiceImpl userServiceImpl;
	@Autowired
	private UserRepository userRepo;

	@GetMapping("/")
	public List<Userr> getAllUsers( )  {
		return userServiceImpl.findAllUsers();
	}
	@PostMapping("/")
	public ResponseEntity<Userr> register(@Valid @RequestBody Userr user) throws URISyntaxException {
		String encryptedString = AES256.encrypt(user.getPassword());
		user.setPassword(encryptedString);
		Userr result = userServiceImpl.registerNewUser(user);

		if(result== null )
		{

			return ResponseEntity.status(201)
					.body(user);
		}
		else{
			return ResponseEntity.status(302)
					.body(user);
		}

	}
	@PostMapping("/authentificate/")
	public ResponseEntity<Userr> authentificate(@Valid @RequestBody UserAuth userAuth) throws URISyntaxException {
		boolean result = userServiceImpl.authentification(userAuth.getUsername(),userAuth.getPassword());
		Optional<Userr> userSearch=userRepo.findUserrByUserName(userAuth.getUsername());

		if(result )
		{

			return ResponseEntity.status(200)
					.body(userSearch.get());
		}
		else{
			return ResponseEntity.status(404)
					.body(userSearch.get());
		}

	}

}
