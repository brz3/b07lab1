public class Polynomial{
	
	double[] coefficients;
	
	public Polynomial() {
        coefficients = new double[] {0};
    }
	
	
	public Polynomial(double coefficients[]) {
    	this.coefficients = coefficients;
    }
	public Polynomial add(Polynomial p2) {
		
		int len = Math.max(this.coefficients.length, p2.coefficients.length);
		double[] sum = new double[len];
		
		for (int i = 0; i < this.coefficients.length; i++){
				sum[i] = sum[i] + coefficients[i];
			}
		
		for (int i = 0; i < p2.coefficients.length; i++){
			sum[i] = sum[i] + p2.coefficients[i];
		}
		{
		return new Polynomial(sum); 
		}
	}
	public double evaluate(double x) {
		double result = 0;
		for (int i = 0; i < this.coefficients.length; i++) {
			result = result + coefficients[i] * Math.pow(x, i);
		}
		return result;
	}
	
	public boolean hasRoot(double x) {
        if (this.evaluate(x) == 0) {
            return true;
        }
        return false;
    }


		
	} 
