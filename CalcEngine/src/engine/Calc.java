package engine;

public class Calc {

	public static double compute(double invest, double years, double rate){
		
		double futureValue;
		
		futureValue = invest * (Math.pow(1 + (rate/12), 12 * years));
		
		return futureValue;
	}
}
