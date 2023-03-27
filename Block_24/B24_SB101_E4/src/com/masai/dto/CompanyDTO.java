package com.masai.dto;

import java.math.BigInteger;
import java.time.LocalDate;

public interface CompanyDTO {
	
	public String getCompany_Id();
	public void setCompany_Id(String company_Id);
	
	public String getCompany_name();
	public void setCompany_name(String company_name);
	
	public Integer getTurnover() ;
	public void setTurnover(Integer turnover);
	
	public LocalDate getRegistration_date();
	public void setRegistration_date(LocalDate registration_date) ;	

}
