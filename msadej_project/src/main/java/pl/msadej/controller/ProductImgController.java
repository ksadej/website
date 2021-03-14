package pl.msadej.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import pl.msadej.model.ProductImg;
import pl.msadej.repository.ProductImgRepository;
@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api")
public class ProductImgController {
	
	@Autowired
	private ProductImgRepository productImgRepository;
	
	@GetMapping("/Img")
	public List<ProductImg> getAllProductImgs(){
		return productImgRepository.findAll();
	}
	
//	@GetMapping("/Img/{id}")
//	public Optional<ProductImg> getAllProductImgId(@PathVariable("id")Long id){
//		return productImgRepository.findById(id);
//	}
	
	@GetMapping("/Img/{prodId}")
	public List<ProductImg> getByProductId(@PathVariable("prodId")Long prodId){
		return productImgRepository.findByProduct_Id(prodId);
	}
	
//	@GetMapping("/Img/{prodId}")
//	public List<ProductImg> getById(@PathVariable("prodId")Long prodId){
//		return productImgRepository.findByProdId(prodId);
//	}
		
}
