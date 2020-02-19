package main.Class;

public class CompoundInterest {
	 public double calculateCompoundInterest(double principle, double time, double rate) {
	        double amount = principle * (Math.pow((1 + rate / 100), time));
	        double compoundinterest = amount - principle;
	        return compoundinterest;
	    }
}
