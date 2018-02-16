/**
 *
 * @author Patryk
 * 
 */

package zadanie;

public class SimpleTimer 
{
    private long timeBegin;
    private long timeEnd;
    
    public SimpleTimer()
    {
        timeBegin = 0;
        timeEnd = 0;
    }
    
    public void Start()
    {
        timeBegin = System.nanoTime();
    }
    
    public void Stop()
    {
        timeEnd = System.nanoTime();
    }
    
    public long Time()
    {
        return (timeEnd - timeBegin);
    }
    
    public double TimeInSec()
    {
        return ((double)(timeEnd - timeBegin))/1e9;
    }
}