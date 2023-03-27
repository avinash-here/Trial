package com.masai.dto;

public class CarDTOImpl implements CarDTO{
	private String car_Id;
	private String model_name;
	private int price;
	private int seats;
	private CompanyDTO com_dto;
	
	public CarDTOImpl(String car_Id, String model_name, int price, int seats, CompanyDTO com_dto) {
		super();
		this.car_Id = car_Id;
		this.model_name = model_name;
		this.price = price;
		this.seats = seats;
		this.com_dto = com_dto;
	}
	
	@Override
	public String getCar_Id() {
		return car_Id;
	}
	@Override
	public void setCar_Id(String car_Id) {
		this.car_Id = car_Id;
	}
	
	@Override
	public String getModel_name() {
		return model_name;
	}
	@Override
	public void setModel_name(String model_name) {
		this.model_name = model_name;
	}
	
	@Override
	public int getPrice() {
		return price;
	}
	@Override
	public void setPrice(int price) {
		this.price = price;
	}
	
	@Override
	public int getSeats() {
		return seats;
	}
	@Override
	public void setSeats(int seats) {
		this.seats = seats;
	}
	
	@Override
	public CompanyDTO getCom_dto() {
		return com_dto;
	}
	@Override
	public void setCom_dto(CompanyDTO com_dto) {
		this.com_dto = com_dto;
	}

	@Override
	public String toString() {
		return "CarDTOImpl [car_Id=" + car_Id + ", model_name=" + model_name + ", price=" + price + ", seats=" + seats
				+ ", com_dto=" + com_dto + "]";
	}	

}
