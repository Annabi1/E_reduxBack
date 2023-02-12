package com.insy2s.E_Redux.Services;

import com.insy2s.E_Redux.Entites.Product;
import com.insy2s.E_Redux.Entites.Userr;

import java.util.List;
import java.util.Optional;

public interface IUserService {
	public Userr registerNewUser(Userr user);
	public List<Userr> findAllUsers();
	boolean authentification (String username, String password );



}
