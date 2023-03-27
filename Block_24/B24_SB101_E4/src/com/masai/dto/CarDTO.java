package com.masai.dto;

public interface CarDTO {
	
	public String getCar_Id();
	public void setCar_Id(String car_Id);
	
	public String getModel_name();
	public void setModel_name(String model_name);
	
	public int getPrice();
	public void setPrice(int price) ;
	
	public int getSeats() ;
	public void setSeats(int seats);
	
	public CompanyDTO getCom_dto() ;
	public void setCom_dto(CompanyDTO com_dto) ;

}
