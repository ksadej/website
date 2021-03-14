package pl.msadej.model;

import javax.persistence.*;

@Entity
@Table(name="Product")
public class product_1 {

	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private Integer productID;
	
	@Column(name="name")
	private String name;
	
	@Column(name="description")
	private String description;
	
	@Column(name="path")
	private String path;
	
	public product_1() {
	}
	
	public product_1(int productID, String name, String description, String path) {
		this.productID = productID;
		this.name = name;
		this.description = description;
		this.path = path;
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
	public String getPath() {
		return path;
	}
	public void setPath(String path) {
		this.path = path;
	}
	
	
}
