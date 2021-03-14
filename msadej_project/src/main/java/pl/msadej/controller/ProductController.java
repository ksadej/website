package pl.msadej.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import pl.msadej.model.Product;
import pl.msadej.model.product_1;
import pl.msadej.repository.ProductRepository;
import pl.msadej.repository.Product_1Repository;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api")
public class ProductController {

	@Autowired
	private Product_1Repository product_1Repository;
	
	@Autowired
	private ProductRepository productRepository;
	
//	@GetMapping("/products")
//	public List<product_1> getAllProducts(){
//		return product_1Repository.findAll();
//	}
	
//	@PostMapping("/products")
//	public product_1 addProduct(@RequestBody product_1 prd) {
//		return product_1Repository.save(prd);
//	}
	
	@GetMapping("/products")
	public List<Product> getAllProduct(){
		return productRepository.findAll();
	}
	
	@GetMapping("/products/{id}")
	public Optional<Product> getById(@PathVariable("id") Long id){
		return productRepository.findById(id);
	}
	
	@GetMapping("/products/portfolio/{portfId}")
	public List<Product> getProductByPortfobioId(@PathVariable("portfId")Long portfId){
		return productRepository.findByPortfolio_Id(portfId);
	}
}
