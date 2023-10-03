package com.productservice.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.productservice.exceptions.ProductNotFoundException;
import com.productservice.model.Product;
import com.productservice.repository.ProductRepository;

@Service
public class ProductServiceImpl implements ProductService {

	@Autowired
	private ProductRepository productrepository;

	@Override
	public Product addProduct(Product product) {
		Product product1 = productrepository.save(product);
		return product1;
	}

	@Override
	public List<Product> getAllProducts() {
		List<Product> productList = productrepository.findAll();
		return productList;
	}

	@Override
	public Product getProductById(long id) {
		Product product = productrepository.findById(id)
				.orElseThrow(() -> new ProductNotFoundException("Product ID " + id + " is not found in the database."));
		return product;
	}

	@Override
	public Product updateProduct(long id, Product updatedproduct) {
		Product existingProduct = productrepository.findById(id)
				.orElseThrow(() -> new ProductNotFoundException("Product ID " + id + " is not found the the databse."));
		existingProduct.setName(updatedproduct.getName());
		existingProduct.setDescription(updatedproduct.getDescription());
		existingProduct.setPrice(updatedproduct.getPrice());
		Product product = productrepository.save(existingProduct);
		return product;
	}

	@Override
	public String deleteProduct(long id) {
		Optional<Product> existingproduct = productrepository.findById(id);
		if (existingproduct.isPresent()) {
			productrepository.delete(existingproduct.get());
			return "Product ID " + id + " is deleted from the database successfully.";
		} else {
			throw new ProductNotFoundException("Product ID " + id + " is not found in the database.");
		}
	}

}
