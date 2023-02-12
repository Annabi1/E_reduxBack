package com.insy2s.E_Redux.Services;

import com.insy2s.E_Redux.Entites.Category;
import com.insy2s.E_Redux.Entites.Product;
import com.insy2s.E_Redux.Repository.CategoryRepository;
import com.insy2s.E_Redux.Repository.ProductRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
@Transactional

public class CategoryServiceImpl implements ICategoryService {
@Autowired
private CategoryRepository categoryRepository;
@Autowired
private ProductRepository productRepository;
	@Override
	public List<Category> findAll() {
		// TODO Auto-generated method stub
		return categoryRepository.findAll();
	}

	@Override
	public Category save(Category category) {
			if( categoryRepository.finCategoryByName(category.getName()).isEmpty())
			{
				return categoryRepository.save(category);

			}
			else 		return null;


	}

	@Override
	public void delete(Integer id) {
		// TODO Auto-generated method stub
		categoryRepository.deleteById(id);
	}

	@Override
	public Optional<Category> getCategoryById(Integer id) {
		// TODO Auto-generated method stub
		return categoryRepository.findById(id);
	}

	@Override
	public Category updateCategory(Category category) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<Product> findAllProduct(Integer id) {
		List<Product> products=productRepository.findProductByCategory(id);
		
		
		
		return products;
	}

}
