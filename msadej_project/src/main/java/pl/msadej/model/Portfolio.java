package pl.msadej.model;

import java.util.List;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(name="pl_msadej_portfolio")
public class Portfolio {

	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private Long id;
	private String portfolioName;
	private String type;
	private String imgName;
	@Lob
    @Column(name = "Image")
    private byte[] image;
	
	@OneToMany(mappedBy = "portfolio", targetEntity = Product.class, cascade = CascadeType.ALL)
	@JsonBackReference
	private List<Product> product;
	
	public Portfolio() {
	}
	
	public Portfolio(String type, String imgName, byte[] image) {
		super();
		this.type = type;
		this.imgName = imgName;
		this.image = image;
	}



	public Portfolio(String portfolioName, String type, String imgName, byte[] image, List<Product> product) {
		super();
		this.portfolioName = portfolioName;
		this.type = type;
		this.imgName = imgName;
		this.image = image;
		this.product = product;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public List<Product> getProduct() {
		return product;
	}

	public void setProduct(List<Product> product) {
		this.product = product;
	}

	public String getPortfolioName() {
		return portfolioName;
	}

	public void setPortfolioName(String portfolioName) {
		this.portfolioName = portfolioName;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public byte[] getImage() {
		return image;
	}

	public void setImage(byte[] image) {
		this.image = image;
	}

	public String getImgName() {
		return imgName;
	}

	public void setImgName(String imgName) {
		this.imgName = imgName;
	}

}
