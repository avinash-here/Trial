package com.problem5;

public class Loan {
	
	private double principalAmount;
	private double timePeriod;    // in years
	private double interestRate;  // per annum
		
	public Loan() {}

	public Loan(double principalAmount, double timePeriod, double interestRate) {
		super();
		this.principalAmount = principalAmount;
		this.timePeriod = timePeriod;
		this.interestRate = interestRate;
	}

	public double getPrincipalAmount() {
		return principalAmount;
	}

	public void setPrincipalAmount(double principalAmount) {
		this.principalAmount = principalAmount;
	}

	public double getTimePeriod() {
		return timePeriod;
	}

	public void setTimePeriod(double timePeriod) {
		this.timePeriod = timePeriod;
	}

	public double getInterestRate() {
		return interestRate;
	}

	public void setInterestRate(double interestRate) {
		this.interestRate = interestRate;
	}

	@Override
	public String toString() {
		return "Loan [principalAmount=" + principalAmount + ", timePeriod=" + timePeriod + ", interestRate=" + interestRate + "]";
	}
	
}
