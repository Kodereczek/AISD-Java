/**
 *
 * @author Patryk
 *
 */

package zadanie;

import java.util.Random;

public class Zadanie 
{
    public static void main(String[] args) 
    {
        // Deklaracja i inicjalizacja zmiennych
        Statistics Statystyka = new Statistics();
        SimpleTimer timer = new SimpleTimer();
        Random generator = new Random();
        Sort sortuj = new Sort();
        
        int 
            i = 0, j = 0,
            ileElementów = 10000,
            ilePomiarów  = 10;
            
        int[][] tabElementów  = new int[6][];
        double[][] tabPomiarów   = new double[6][ilePomiarów];
        
        
        for(i = 0; i < tabElementów.length; ++i) 
        {
            tabElementów[i] = new int[ileElementów];
            ileElementów += 1000;
        }
        
        // Pomiar sortowania metodą bąbelkową
        for(i = 0; i < tabElementów.length; ++i)
        {   
            for(j = 0; j < ilePomiarów; ++j)
            {
                // Wypełnienie tablicy do sortowania losowymi wartościami z zakresu od 0 do 9999999
                Losuj(tabElementów[i], generator);
                
                // Rozpoczęcie pomiaru czasu sortowania metodą bąbelkową
                timer.Start();
                sortuj.Bubble(tabElementów[i]);
                timer.Stop();
                
                tabPomiarów[i][j] = timer.TimeInSec();
            }
        }
        
        // Wyświetlenie wyników
        for(i = 0; i < tabPomiarów.length; ++i)                                        
        {
            System.out.print(tabElementów[i].length + "\t");
            
            for(j = 0; j < ilePomiarów; ++j)
            {
                System.out.printf("%.3f\t", tabPomiarów[i][j]);
            }
            
            System.out.printf("%.3f\t%.3f\t%.3f\n", Statystyka.Average(tabPomiarów[i]), Statystyka.Deviation(tabPomiarów[i]), Statystyka.RelativeError(tabPomiarów[i]));
        }
        System.out.print("\n\n");
        
        // Pomiar sortowania metodą bąbelkową ulepszoną
        for(i = 0; i < tabElementów.length; ++i)
        {   
            for(j = 0; j < ilePomiarów; ++j)
            {
                // Wypełnienie tablicy do sortowania losowymi wartościami z zakresu od 0 do 9999999
                Losuj(tabElementów[i], generator);
                
                // Rozpoczęcie pomiaru czasu sortowania metodą bąbelkową ulepszoną
                timer.Start();
                sortuj.BubbleImproved(tabElementów[i]);
                timer.Stop();
                
                tabPomiarów[i][j] = timer.TimeInSec();
            }
        }
        
        // Wyświetlenie wyników
        for(i = 0; i < tabPomiarów.length; ++i)                                        
        {
            System.out.print(tabElementów[i].length + "\t");
            
            for(j = 0; j < ilePomiarów; ++j)
            {
                System.out.printf("%.3f\t", tabPomiarów[i][j]);
            }
            
            System.out.printf("%.3f\t%.3f\t%.3f\n", Statystyka.Average(tabPomiarów[i]), Statystyka.Deviation(tabPomiarów[i]), Statystyka.RelativeError(tabPomiarów[i]));
        }
        System.out.print("\n\n");
        
        // Pomiar sortowania metodą przez wybieranie
        for(i = 0; i < tabElementów.length; ++i)
        {   
            for(j = 0; j < ilePomiarów; ++j)
            {
                // Wypełnienie tablicy do sortowania losowymi wartościami z zakresu od 0 do 9999999
                Losuj(tabElementów[i], generator);
                
                // Rozpoczęcie pomiaru czasu sortowania metodą przez wybieranie
                timer.Start();
                sortuj.Insertion(tabElementów[i]);
                timer.Stop();
                
                tabPomiarów[i][j] = timer.TimeInSec();
            }
        }
        
        // Wyświetlenie wyników
        for(i = 0; i < tabPomiarów.length; ++i)                                        
        {
            System.out.print(tabElementów[i].length + "\t");
            
            for(j = 0; j < ilePomiarów; ++j)
            {
                System.out.printf("%.3f\t", tabPomiarów[i][j]);
            }
            
            System.out.printf("%.3f\t%.3f\t%.3f\n", Statystyka.Average(tabPomiarów[i]), Statystyka.Deviation(tabPomiarów[i]), Statystyka.RelativeError(tabPomiarów[i]));
        }
    }
    
    public static void Losuj(int[] tab, Random generator)    
    {
        for(int i = 0; i < tab.length; ++i)                                        
        {                                                          
            tab[i] = generator.nextInt(9999999 + 1);                                
        }
    }
}