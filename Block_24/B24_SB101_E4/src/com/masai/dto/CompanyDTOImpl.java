package com.masai.dto;

import java.math.BigInteger;
import java.time.LocalDate;

public class CompanyDTOImpl implements CompanyDTO{
	private String company_Id;
	private String company_name;
	private Long turnover;  // in crores
	private LocalDate registration_date;
	
	public CompanyDTOImpl(String company_Id, String company_name, Long turnover, LocalDate registration_date) {
		super();
		this.company_Id = company_Id;
		this.company_name = company_name;
		this.turnover = turnover;
		this.registration_date = registration_date;
	}
	
	@Override
	public String getCompany_Id() {
		return company_Id;
	}
	@Override
	public void setCompany_Id(String company_Id) {
		this.company_Id = company_Id;
	}
	
	@Override
	public String getCompany_name() {
		return company_name;
	}
	@Override
	public void setCompany_name(String company_name) {
		this.company_name = company_name;
	}
	
	@Override
	public Long getTurnover() {
		return turnover;
	}
	@Override
	public void setTurnover(Long turnover) {
		this.turnover = turnover;
	}
	
	@Override
	public LocalDate getRegistration_date() {
		return registration_date;
	}
	@Override
	public void setRegistration_date(LocalDate registration_date) {
		this.registration_date = registration_date;
	}
	
	@Override
	public String toString() {
		return "CompanyDTOImpl [company_Id=" + company_Id + ", company_name=" + company_name + ", turnover=" + turnover
				+ ", registration_date=" + registration_date + "]";
	}	

}
