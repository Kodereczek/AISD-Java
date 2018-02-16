/**
 *
 * @author Patryk
 * 
 */

package zadanie;

public class Sort 
{
    public void Insertion(int[] tab)
    {
        int temp = 0, j = 0;
 
        for(int i = 1; i < tab.length; ++i)
        {
            j = i;
            temp = tab[i];

            while(j > 0 && tab[j - 1] > temp)
            {
                tab[j] = tab[j - 1];
                j--;
            }
            
            tab[j] = temp;
        }
    }
    
    public void Bubble(int[] tab)
    {
        int 
            n = tab.length,
            indeks1 = 0,
            indeks2 = 0,
            maxIndeks = n - 1,
            poprzedni = 0;
    
        while(indeks2 <= maxIndeks)
        {
            while(indeks1 < maxIndeks)
            {
                if(tab[indeks1] > tab[indeks1 + 1])
                {
                    poprzedni = tab[indeks1];
                    tab[indeks1] = tab[indeks1 + 1];
                    tab[indeks1 + 1] = poprzedni;
                }

                indeks1++;
            }

            indeks1 = 0;
            indeks2++;
        }
    }
    
    public void BubbleImproved(int[] tab)
    {
        int 
            n = tab.length,
            indeks1 = 0,
            indeks2 = 0,
            maxIndeks = n - 1,
            poprzedni = 0,
            wynik = 0;
    
        for(int i = 0; i < n; ++i)
        {
            if(tab[i] > tab[i + 1])
            {
                wynik = 1;
                break;
            }
        }
        
        if(wynik == 1)
        {
            while(indeks2 <= maxIndeks)
            {
                while(indeks1 < maxIndeks)
                {
                    if(tab[indeks1] > tab[indeks1 + 1])
                    {
                        poprzedni = tab[indeks1];
                        tab[indeks1] = tab[indeks1 + 1];
                        tab[indeks1 + 1] = poprzedni;
                    }

                    indeks1++;
                }

                indeks1 = 0;
                indeks2++;
            }
        }
    }
}
