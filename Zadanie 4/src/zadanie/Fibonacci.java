/**
 *
 * @author Patryk
 * 
 */

package zadanie;

public class Fibonacci 
{    
    public long CountRec(int n)
    {
        
        if(n < 2) return n;
	else
	{
            return CountRec(n - 1) + CountRec(n - 2);
	}
    }
    
    public long CountIte(int n)
    {
        if(n < 2) return n;
        else
        {
            long
                n1 = 1,
                n2 = 0,
                result = 0;

            for(int i = 2; i <= n; ++i)
            {
                result = n1 + n2;
                n2 = n1;
                n1 = result;
            }

            return result;
        }
    }
    
    public long CountBineta(int n)
    {
        return (long)((1 / Math.sqrt(5)) * Math.pow(((1 + Math.sqrt(5)) / 2), n)
                - (1 / Math.sqrt(5)) * Math.pow(((1 - Math.sqrt(5)) / 2), n));
    }
}
