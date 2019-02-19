package audit.server.loadsimulation;
import audit.server.loadsimulation.Math;
import java.util.Random;


public class lognormaldelay {
   /* public static double mu;
    public static double sigma;*/
    
    public static double delay(double mu, double sigma) {
    	Random r = new Random();
	double logdelay=mu+ (r.nextDouble()*sigma);
	//System.out.println(logdelay);
	return Math.exp(logdelay)/100000;
    }
    
public static void main(String[]args) {
	
	System.out.println(delay(25,100));
}
}
