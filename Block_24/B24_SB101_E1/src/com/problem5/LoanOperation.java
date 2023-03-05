package com.problem5;

public class LoanOperation {
	
	double getEMIByFlatRate(Loan l) {		
		double amount = l.getPrincipalAmount() + l.getPrincipalAmount()*l.getTimePeriod()*l.getInterestRate()/100;		
		return amount/(12*l.getTimePeriod());
	}
	
	static double getEMIByFloatingRate(Loan l) {
		/*
			EMI = p * ((r * (1 + r)^n) / ((1 + r)^n - 1)) [Here ^ is for power not for XOR operation]
			Here p is principle amount
			r = interestRate / 1200
			n = no of payment term in months (i.e. for payment term of 3 year it will be 36 month)
		*/
		
		double p = l.getPrincipalAmount();
		double r = l.getInterestRate()/1200;
		double n = l.getTimePeriod()*12;
		
		double EMI = p * (r * Math.pow((1 + r), n)) / (Math.pow((1 + r), n) - 1);		
		return EMI;
	}
		
}

