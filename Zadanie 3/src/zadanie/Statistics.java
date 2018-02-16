/**
 *
 * @author Patryk
 * 
 */

package zadanie;

import java.lang.Math;

public class Statistics
{
    public double Average(double []tab)
    {
        double sum = 0;
        
        for(int i = 0; i < tab.length; ++i)
        {
            sum += tab[i];
        }
        
        return (sum / tab.length);
    }
    
    public double Variance(double []tab)
    {
        double var = 0.0;
        double sum = Average(tab);
        
        for(int i = 0; i < tab.length; ++i)
        {
            var += Math.pow(tab[i] - sum, 2);
        }
        
        return (var / tab.length);
    }
    
    public double Deviation(double []tab)
    {
        return Math.sqrt(Variance(tab));
    }
    
    public double RelativeError(double []tab)
    {
        return ((Deviation(tab) / Average(tab)) * 100);
    }
    
    public double Min(double []tab)
    {
        double min = tab[0];

        for (int i = 1; i < tab.length; ++i) 
        {
            if(tab[i] < min) min = tab[i];
        }
        
        return min;
    }
    
    public double Max(double []tab)
    {
        double max = tab[0];

        for (int i = 1; i < tab.length; ++i) 
        {
            if(tab[i] > max) max = tab[i];
        }
        
        return max;
    }
}
