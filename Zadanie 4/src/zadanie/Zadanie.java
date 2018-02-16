/**
 *
 * @author Patryk
 * 
 */

package zadanie;

public class Zadanie
{    
    public static void main(String[] args) 
    {
        int n = 45;
        
        Fibonacci fb = new Fibonacci();
        
        System.out.println(fb.CountRec(n));
        
        System.out.println(fb.CountBineta(n));
        
        System.out.println(fb.CountIte(n));
    }
}
