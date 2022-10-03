import java.io.*;
import java.util.Arrays;

public class Driver {
  public static void main(String [] args) throws Exception { 
    
	Polynomial p = new Polynomial(); 
    System.out.println(p.evaluate(3));
   
    double [] c1 = {6,5}; 
    int [] ex1 = {0,3};
    double [] c2 = {-2,-9}; 
    int [] ex2 = {1,4};
    Polynomial p1 = new Polynomial(c1,ex1); 
    Polynomial p2 = new Polynomial(c2,ex2); 
    Polynomial s = p1.add(p2);
    System.out.println("s(0.1) = " + s.evaluate(0.1)); 
    
    if(s.hasRoot(1)) System.out.println("1 is a root of s"); 
    else System.out.println("1 is not a root of s");
    System.out.println("");
    
    double[] c3 = {7, 8, 2};
    int[] ex3 = {2, 1, 0};
    double[] c4 = {8, 6, 5};
    int[] ex4 = {2, 1, 0};
    Polynomial p3 = new Polynomial(c3, ex3);
    Polynomial p4 = new Polynomial(c4, ex4);
    Polynomial t = p3.multiply(p4);
    System.out.println("t(1) = " + t.evaluate(1));
    //56x^4+106x^3+99x^2+52x+10
    
    //File f =  new File("C:\\Users\\Brian\\Desktop\\eclipse-workspace\\lab2\\test1.txt");
   //Polynomial p5 = new Polynomial(f);
    //System.out.println(Arrays.toString(p5.coefficients));
    //System.out.println(Arrays.toString(p5.exponents));

   
    
    
   
  } 
} 