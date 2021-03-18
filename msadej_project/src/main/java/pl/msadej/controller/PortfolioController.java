package pl.msadej.controller;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import pl.msadej.model.Portfolio;
import pl.msadej.repository.PortfolioRepository;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api")
public class PortfolioController {
	
	@Autowired
	private PortfolioRepository portfolioRepository;
	
	@GetMapping("/portfolio")
	public List<Portfolio> getAllPortfolio(){
		return portfolioRepository.findAll();
	}

	@PostMapping("/upload")
	public ResponseEntity uploadImagev3(@RequestParam("file") MultipartFile file) throws IOException {
		Portfolio prd = new Portfolio(file.getOriginalFilename(), file.getContentType(), file.getBytes());
		portfolioRepository.save(prd);
		String message="Działa";
		return ResponseEntity.status(HttpStatus.OK).body(message);
	}
	
}
