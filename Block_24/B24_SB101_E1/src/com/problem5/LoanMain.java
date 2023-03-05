package com.problem5;

public class LoanMain {
	
	public static void main(String[] args) {
		
		MyLoanIntr myLoan = Loan::new;
		Loan l = myLoan.getLoanObject(150000, 3, 8.5);
		
		LoanOperation lo = new LoanOperation();
		
		GetEMIAmount getFlatRateEMI = lo::getEMIByFlatRate; 		
		GetEMIAmount getFloatingRateEMI = LoanOperation::getEMIByFloatingRate;
		
		System.out.println("EMI by Flat rate: ₹ " + Math.round(getFlatRateEMI.getEMI(l)));
		System.out.println("EMI by Floating rate: ₹ " + Math.round(getFloatingRateEMI.getEMI(l)));
		
	}

}
