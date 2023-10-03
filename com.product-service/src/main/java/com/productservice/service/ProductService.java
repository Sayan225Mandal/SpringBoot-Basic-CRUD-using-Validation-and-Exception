package com.productservice.service;

import java.util.List;

import com.productservice.model.Product;

public interface ProductService {

	Product addProduct(Product product);

	List<Product> getAllProducts();

	Product getProductById(long id);

	Product updateProduct(long id, Product updatedproduct);

	String deleteProduct(long id);

}
