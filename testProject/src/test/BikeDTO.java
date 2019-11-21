package test;

public class BikeDTO {
	String p_number, company, product;
	int year, mileage, price;
	public String getP_number() {
		return p_number;
	}
	public void setP_number(String p_number) {
		this.p_number = p_number;
	}
	public String getCompany() {
		return company;
	}
	public void setCompany(String company) {
		this.company = company;
	}
	public String getProduct() {
		return product;
	}
	public void setProduct(String product) {
		this.product = product;
	}
	public int getYear() {
		return year;
	}
	public void setYear(int year) {
		this.year = year;
	}
	public int getMileage() {
		return mileage;
	}
	public void setMileage(int mileage) {
		this.mileage = mileage;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public BikeDTO() {
		
	}
	public BikeDTO(String p_number, String company, String product, int year, int mileage, int price) {
		super();
		this.p_number = p_number;
		this.company = company;
		this.product = product;
		this.year = year;
		this.mileage = mileage;
		this.price = price;
	}
	@Override
	public String toString() {
		return "BikeDTO [p_number=" + p_number + ", company=" + company + ", product=" + product + ", year=" + year
				+ ", mileage=" + mileage + ", price=" + price + "]";
	}
	

}
