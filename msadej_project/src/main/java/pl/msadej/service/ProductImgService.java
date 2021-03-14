package pl.msadej.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pl.msadej.model.ProductImg;
import pl.msadej.repository.ProductImgRepository;

@Service
public class ProductImgService {

	@Autowired
	private ProductImgRepository productImgRepository;
	
	
}
