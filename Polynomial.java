import java.util.*;
import java.io.*;

public class Polynomial {
  double[] coefficients;
  int[] exponents;

  public Polynomial() {
    this.coefficients = null;
    this.exponents = null;
  }

  public Polynomial(double[] coef, int[] exp) {
    this.coefficients = coef;
    this.exponents = exp;
  }
  
  public Polynomial(File f) throws FileNotFoundException {
	   

      Scanner s = new Scanner(f);
      while (s.hasNextLine()) {
    	String str = s.nextLine();
	    String[] coef = str.split("(x\\d+\\+?)");
	    str = str.replace("-", "+-");
	    String[] parts = str.split("(\\+)");
	    
	    this.coefficients = new double[coef.length];
	    this.exponents = new int[coef.length];
	    int i = 0;
	    for(String part : parts) {
	    	String[] t = part.split("x");
	    	if (t[0] =="") {
	    		continue;
	    	}
	    	else if (t.length > 1) {
	    		  this.exponents[i] = Integer.parseInt(t[1]);
	    	}
	    	else {
	    		  this.exponents[i] = 0;
	    	}
	    	this.coefficients[i] = Double.parseDouble(t[0]);
	    	i++;	    	
	    }
	    
	    }
      s.close();
}
  
  public void saveToFile(String f) throws IOException {
  	
  	String temp = "";
	FileWriter w = new FileWriter(f);
  	this.coefficients = new double[this.coefficients.length]; 
  	this.exponents = new int[this.exponents.length];

  	for (int i = 0; i < 	this.exponents.length; i++) {
  		
  		if (i == 0 && 	this.exponents[i] != 0) {
  			temp = temp + this.coefficients[i];	 			
  		}
  		else if (i != 0  && this.coefficients[i] > 0 && 	this.exponents[i] != 0) { 
                temp = temp + "+"; 
                temp = temp + this.coefficients[i];    
  		}       
        else if (i != 0  && this.coefficients[i] < 0 && 	this.exponents[i] != 0) {                     
                    temp = temp + this.coefficients[i];                        
        }        
  		else if (	this.exponents[i] == 0) {
        	temp = temp + this.coefficients[i];
            continue;
        }
  		temp = temp + "x" + 	this.exponents[i];      

    }
  
  	w.write(temp);
	w.close();

  }

  public Polynomial add(Polynomial p2) {
  
  double[] c1 = this.convert(this);
  double[] c2 = p2.convert(p2);
 
  int len = Math.max(c1.length, c2.length);
	double[] sum = new double[len];
	
	for (int i = 0; i < c1.length; i++){
			sum[i] = sum[i] + c1[i];
		}
	for (int i = 0; i < c2.length; i++){
		sum[i] = sum[i] + c2[i];
	}
	Polynomial p = new Polynomial();
	return p.convert2(sum); 
  }
  
  public double[] convert(Polynomial p) {
	  int x = Arrays.stream(p.exponents).max().getAsInt();
	  double [] c = new double[x+1];
	  for (int i = 0; i < p.exponents.length; i++) {
		  c[this.exponents[i]] = p.coefficients[i];
	  }
	  return c;
  }
  
  public Polynomial convert2(double[] coef) {
	  int len = 0;
	    for (int i = 0; i < coef.length; i++) {
	      if (coef[i] != 0) {
	      len++; 
	      }
	    }	   
	    double[] c = new double[len];
	    int[] e = new int[len];
	    int count = 0;
	    for (int i = 0; i < coef.length; i++) {
	      if (coef[i] != 0) {
	      c[count] = coef[i];
	      e[count] = i;
	      count++;
	      }
	    }
	    Polynomial p = new Polynomial(c,e);
	    return p;
  }

  public double evaluate(double x) {
    if (this.coefficients == null) {
    	return 0.0;
    }
    double sum = 0;
    for (int i = 0; i < this.coefficients.length; i++) {
      sum += this.coefficients[i] * Math.pow(x, this.exponents[i]);
    }
    return sum;
  }
  
  public boolean hasRoot(double value) {
	  return evaluate(value) == 0.0;
	  }
  
  public Polynomial multiply(Polynomial p2) {
	  double[] c1 = this.convert(this);
	  double[] c2 = p2.convert(p2);
	  int m = c1.length;
	  int n = c2.length;
	  
	  double[] prod = new double[m + n - 1];
	  
      for (int i = 0; i < m + n - 1; i++) 
      {
          prod[i] = 0;
      }
      for (int i = 0; i < m; i++) 
      {
          for (int j = 0; j < n; j++) 
          {
              prod[i + j] += c1[i] * c2[j];
          }
      }
      Polynomial p = new Polynomial();
  	  return p.convert2(prod); 
  }
  
 
  
}


