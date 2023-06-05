package com.crud.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.crud.entities.Product;
import com.crud.service.ProductService;

@RestController
public class ProductController {

	@Autowired
	private ProductService productService;

	// Post methods

	@PostMapping("/addProduct")
	public Product addProduct(@RequestBody Product product) {
		return productService.saveProduct(product);
	}

	@PostMapping("/addAllProducts")
	public List<Product> addProducts(@RequestBody List<Product> products) {
		return productService.saveAllProducts(products);
	}

	// Get methods

	@GetMapping("/getProducts")
	public List<Product> getAllProducts() {
		return productService.getProducts();
	}

	@GetMapping("/getProduct/{id}")
	public Optional<Product> getProductById(@PathVariable int id) {
		return productService.getProductById(id);
	}

	@GetMapping("/getProductByName/{name}")
	public Product getProductByName(@PathVariable String name) {
		return productService.getProductByName(name);
	}

	// Delete method

	@DeleteMapping("/deleteProduct/{id}")
	public String deleteProduct(@PathVariable int id) {
		return productService.deleteProduct(id);
	}

	// Update method

	@PutMapping("/update")
	public Product updateProduct(@RequestBody Product product) {
		return productService.updateProduct(product);
	}

}
