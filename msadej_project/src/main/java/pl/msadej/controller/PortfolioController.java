package pl.msadej.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

}
