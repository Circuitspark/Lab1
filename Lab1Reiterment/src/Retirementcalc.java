import java.util.Scanner;

public class Retirementcalc {

	//pv and pmt were poorly explained and therefore difficult to implement properly as it was hard to figure
	//out what variable went in each slot for the methods, code was written assuming pv and pmt were properly applied..
	 public static double pv(double r, double n, double y, double f, boolean t) {
	        double retval = 0;
	        if (r == 0) {
	            retval = -1*((n*y)+f);
	        }
	        else {
	            double r1 = r + 1;
	            retval =(( ( 1 - Math.pow(r1, n) ) / r ) * (t ? r1 : 1)  * y - f)
	                     /
	                    Math.pow(r1, n);
	        }
	        return retval;
	    }
	 
	 public static double pmt(double r, double n, double p, double f, boolean t) {
	        double retval = 0;
	        if (r == 0) {
	            retval = -1*(f+p)/n;
	        }
	        else {
	        double r1 = r + 1;
	        retval = ( f + p * Math.pow(r1, n) ) * r
	                  /
	               ((t ? r1 : 1) * (1 - Math.pow(r1, n)));
	        }
	        return retval;
	    }

	public static void main(String args[]) {

		Scanner input = new Scanner(System.in);

		double AnnualReturnSavings;
		double AnnualReturnRetirement;
		double YearsToWork;
		double YearsRetired;
		double RequiredIncome;
		double MonthlySSI;
		double NeedToSave;
		double SaveEachMonth;
		boolean trashforwhile = true;

		while (trashforwhile == true) {
			System.out.print("Please Enter Years Retired: ");
			YearsRetired = input.nextDouble();
			System.out.print("Please Enter Retirement Annual Return: ");
			AnnualReturnRetirement = input.nextDouble();
			System.out.print("Please Enter Required Income: ");
			RequiredIncome = input.nextDouble();
			System.out.print("Please Enter Monthly SSI: ");
			MonthlySSI = input.nextDouble();
			
			NeedToSave = pv((12 * YearsRetired), (AnnualReturnRetirement * 12), RequiredIncome, MonthlySSI, false);
			
			System.out.print("The Amount You Need To Save Is: " + NeedToSave + "\n");
			System.out.print("Please Enter The Number Of Years To Work: ");
			YearsToWork = input.nextDouble();
			System.out.print("Please Enter Savings Annual Return: ");
			AnnualReturnSavings = input.nextDouble();
			
			SaveEachMonth = pmt((12 * YearsToWork), (AnnualReturnSavings * 12), RequiredIncome, MonthlySSI, false);
			
			System.out.print("Each Month You Need To Save " + SaveEachMonth);
			break;
		}
		input.close();

	}

}
