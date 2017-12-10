package arraysAndString;

public class Pow {

	
	public double pow(double x, int n) {
        if(n == 0)
            return 1;
        if( n < 0 ) {
            if( n == Integer.MIN_VALUE ) { // to prevent overflow
                ++n;
                n = -n;
                x = 1/x;
                return x * x * pow( x * x, n / 2 );
            }
            n = -n;
            x = 1 / x;
        }
        return (n%2 == 0) ? pow(x*x, n/2) : x*pow(x*x, n/2);
    }
}
