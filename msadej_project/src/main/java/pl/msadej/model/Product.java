package pl.msadej.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "pl_msadej_product")
public class Product {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String description;
    private String mainImg;
   
    @OneToMany(mappedBy = "product", targetEntity = ProductImg.class, cascade = CascadeType.ALL)
	@JsonBackReference
	private List<ProductImg> productsImg;
    
    @ManyToOne
	//@JsonManagedReference
	@JsonIgnore
	@JoinColumn(name="portfolio_id", referencedColumnName = "id")
    private Portfolio portfolio;
    
    @Transient
    private Long portfId;
    
    
	public Long getPortfId() {
		return getPortfolio().getId();
	}

	public void setPortfId(Long portfId) {
		this.portfId = portfId;
	}

	public Portfolio getPortfolio() {
		return portfolio;
	}

	public void setPortfolio(Portfolio portfolio) {
		this.portfolio = portfolio;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getMainImg() {
		return mainImg;
	}

	public void setMainImg(String mainImg) {
		this.mainImg = mainImg;
	}

	public List<ProductImg> getProductsImg() {
		return productsImg;
	}

	public void setProductsImg(List<ProductImg> productsImg) {
		this.productsImg = productsImg;
	}
}
