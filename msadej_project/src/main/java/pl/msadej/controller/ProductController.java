package pl.msadej.controller;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import pl.msadej.model.Product;
import pl.msadej.repository.ProductRepository;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api")
public class ProductController {

	@Autowired
	private ProductRepository productRepository;
	
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
	
	@PostMapping("/uploadProduct")
	public ResponseEntity upload(@RequestParam("file") MultipartFile file) throws IOException {
		Product prd = new Product(file.getOriginalFilename(), file.getContentType(), file.getBytes());
		productRepository.save(prd);
		String message="Działa";
		return ResponseEntity.status(HttpStatus.OK).body(message);
	}
}
