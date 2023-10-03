package com.productservice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.productservice.model.Product;
import com.productservice.service.ProductService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/product")
public class ProductController {

	@Autowired
	private ProductService productService;

	@PostMapping("/addproduct")
	public ResponseEntity<Product> addProduct(@Valid @RequestBody Product product) {
		Product product1 = productService.addProduct(product);
		return ResponseEntity.status(HttpStatus.CREATED).body(product1);
	}

	@GetMapping("/getallproduct")
	public ResponseEntity<List<Product>> getAllProducts() {
		List<Product> products = productService.getAllProducts();
		return ResponseEntity.status(HttpStatus.OK).body(products);
	}

	@GetMapping("/getproductbyid/{id}")
	public ResponseEntity<Product> getProductById(@PathVariable long id) {
		Product product = productService.getProductById(id);
		return ResponseEntity.status(HttpStatus.OK).body(product);
	}

	@PutMapping("/updateproductbyid/{id}")
	public ResponseEntity<Product> updateProduct(@PathVariable long id,@Valid @RequestBody Product updatedproduct) {
		Product product = productService.updateProduct(id, updatedproduct);
		return ResponseEntity.status(HttpStatus.OK).body(product);
	}
	
	@DeleteMapping("/deleteproductbyid/{id}")
	public ResponseEntity<String> deleteProduct(@PathVariable long id) {
		String message = productService.deleteProduct(id);
		return ResponseEntity.status(HttpStatus.OK).body(message);
	}
}
