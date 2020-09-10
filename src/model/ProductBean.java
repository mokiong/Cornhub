package model;



public class ProductBean implements Product {

	private String prodId;
	private String prodName;
	private Double prodPrice;
	private Integer stocks;
	private String imagePath;
	
	public ProductBean() {
		
	}

	public ProductBean(String prodId, String prodName, Double prodPrice,  Integer stocks,
			String imagePath) {
		super();
		this.prodId = prodId;
		this.prodName = prodName;
		this.prodPrice = prodPrice;
		this.stocks = stocks;
		this.imagePath = imagePath;
	}



	public String getProdId() {
		return prodId;
	}



	public void setProdId(String prodId) {
		this.prodId = prodId;
	}



	public String getProdName() {
		return prodName;
	}



	public void setProdName(String prodName) {
		this.prodName = prodName;
	}

	public Double getProdPrice() {
		return prodPrice;
	}

	public void setProdPrice(Double prodPrice) {
		this.prodPrice = prodPrice;
	}


	public Integer getStocks() {
		return stocks;
	}

	public void setStocks(Integer stocks) {
		this.stocks = stocks;
	}

	public String getImagePath() {
		return imagePath;
	}



	public void setImagePath(String imagePath) {
		this.imagePath = imagePath;
	}



	@Override
	public void process() {
		
	}

}
