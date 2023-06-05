package com.crud.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.crud.entities.Product;
import com.crud.repository.ProductRepository;

@Service
public class ProductService {

	@Autowired
	private ProductRepository productRepository;

	public Product saveProduct(Product product) {
		System.out.println(product);
		return productRepository.save(product);
	}

	public List<Product> saveAllProducts(List<Product> products) {
		return productRepository.saveAll(products);
	}

	public List<Product> getProducts() {
		return productRepository.findAll();
	}

	public Optional<Product> getProductById(int id) {
		return productRepository.findById(id);
	}

	public Product getProductByName(String name) {
		return productRepository.findByName(name);
	}

	public String deleteProduct(int id) {
		productRepository.deleteById(id);
		return id + " Product id deleted ";
	}

	public Product updateProduct(Product product) {
		Product existingProduct = productRepository.findById(product.getId()).orElse(null);
		existingProduct.setName(product.getName());
		existingProduct.setQuantity(product.getQuantity());
		existingProduct.setPrice(product.getPrice());
		return productRepository.save(existingProduct);
	}
}
