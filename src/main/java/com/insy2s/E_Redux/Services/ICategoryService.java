package com.insy2s.E_Redux.Services;

import com.insy2s.E_Redux.Entites.Category;

import java.util.List;
import java.util.Optional;

public interface ICategoryService {
	public List<Category> findAll();
	public Category save(Category product);
	public void delete(Integer id);
	public Optional<Category> getCategoryById(Integer id);
    public Category updateCategory(Category category);

}
