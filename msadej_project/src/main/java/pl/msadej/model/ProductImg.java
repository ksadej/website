package pl.msadej.model;

import java.util.List;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.PostLoad;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;


@Entity
@Table(name="pl_msadej_product_img")
public class ProductImg {

	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private Long id;
	private String path;

	@ManyToOne
	//@JsonManagedReference
	@JsonIgnore
	@JoinColumn(name="product_id", referencedColumnName = "id")
	private Product product;

	public ProductImg() {
		super();
	}

	public ProductImg(Long id, String path, Product product) {
		super();
		this.id = id;
		this.path = path;
		this.product = product;
	}

 	@Transient
 	private Long prodId;
	
 	public Long getProdId() {
 		return getProduct().getId();
 	}

 	public void setProdId(Long prodId) {
 		this.prodId = prodId;
 	}
 	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}
	
}

