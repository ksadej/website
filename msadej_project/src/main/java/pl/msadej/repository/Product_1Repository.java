package pl.msadej.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import pl.msadej.model.product_1;

@Repository
public interface Product_1Repository extends JpaRepository<product_1, Integer>{

}
