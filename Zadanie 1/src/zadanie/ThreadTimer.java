/**
 *
 * @author Patryk
 * 
 */

package zadanie;

public class ThreadTimer implements Runnable
{
    private volatile boolean isTime;
    private volatile long numberOfTact;
    private Thread handleThread;
            
    public ThreadTimer()
    {
        isTime = false;
        numberOfTact = 0;
        handleThread = null;
    }
    
    public void Start()
    {
        if(!isTime)
        {
            handleThread = new Thread(this);
            numberOfTact = 0;
            isTime = true;
            
            handleThread.start();
        }
    }
    
    public void Stop()
    {
        isTime = false;
    }
    
    public double TimeInSec()
    {
        while(isTime);
            
        return (2 * 0.01 * ((double)numberOfTact));
    }
    
    private synchronized void Wait()
    {
        try
        {
            Thread.sleep(10);
        }
        catch(Exception exception)
        {
            System.out.println(exception);
        }
    }
    
    @Override
    public void run()
    {
        do
        {
            this.Wait();
            numberOfTact++;
        } while(isTime);
    }
}
