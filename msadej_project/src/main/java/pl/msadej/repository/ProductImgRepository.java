package pl.msadej.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import pl.msadej.model.Product;
import pl.msadej.model.ProductImg;

@Repository
public interface ProductImgRepository extends JpaRepository<ProductImg, Long>{	
	
	List<ProductImg> findByProduct_Id(Long prodId);
	
	//List<ProductImg> findByProdId(Long prodId);
	
		
}
