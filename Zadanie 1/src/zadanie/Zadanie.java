/**
 *
 * @author Patryk Połeć
 * 
 */

package zadanie;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class Zadanie
{
    public static int countWord = 0;
    public static int countMeasurement = 0;
    public static int intervalWord = 5;
    public static int countIntervalWord = 4;
    public static long resultTab[][];
    public static String resultText = "";
    
    public static void main(String[] args)
    {
        Statistics Survey = new Statistics();
        SimpleTimer Timer = new SimpleTimer();
        Fibonacci ObjectFibonacci = new Fibonacci();

        countWord = GetCountWord();
        countMeasurement = GetCountMeasurement();
        
        resultTab = new long[countIntervalWord][countMeasurement];
                
        for(int i = 0; i < countIntervalWord; ++i)
        {
            for(int j = 0; j < countMeasurement; ++j)
            {
                Timer.Start();
                ObjectFibonacci.CountRec(countWord);
                Timer.Stop();

                System.out.println(Timer.Time() + "ns");

                resultTab[i][j] = Timer.Time();
            }
        }
        
        resultText += "Dokonano pomiaru czasu działania metody obliczającej kolejne wyrazy ciągu Fibonacciego, uzyskano następujące rezultaty:\n";
        resultText += "Wyrazy\t";
        for(int i = 0; i < countIntervalWord; ++i)
        {
            resultText += countWord + "\t";
            countWord -= intervalWord;
        }
        
        resultText += "\nCzas średni [ns]\t";
        for(int i = 0; i < countIntervalWord; ++i)
        {
            resultText += (long)Survey.Average(resultTab[i]) + "\t";
        }
        
        resultText += "\nOdchylenie δ [ns]\t";
        for(int i = 0; i < countIntervalWord; ++i)
        {
            resultText += Survey.Deviation(resultTab[i]) + "\t";
        }
        
        resultText += "\nBłąd pomiarowy [%]\t";
        for(int i = 0; i < countIntervalWord; ++i)
        {
            resultText += Survey.RelativeError(resultTab[i]) + "%\t";
        }
        
        resultText += "\nMin czas [ns]\t";
        for(int i = 0; i < countIntervalWord; ++i)
        {
            resultText += Survey.Min(resultTab[i]) + "\t";
        }
        
        resultText += "\nMax czas [ns]\t";
        for(int i = 0; i < countIntervalWord; ++i)
        {
            resultText += Survey.Max(resultTab[i]) + "\t";
        }
        
        SaveResult(resultText.replace(".", ","));
    }
    
    public static void SaveResult(String text)
    {
        try
        {
            PrintWriter Writer = new PrintWriter("wyniki.txt");
            Writer.println(text);
            Writer.close();
        }
        catch (FileNotFoundException exception)
        {
            System.out.println("Nie można utworzyć pliku!");
        }
    }
    
    public static int GetCountWord()
    {
        Scanner ObjectScanner;
        
        ObjectScanner = new Scanner(System.in);
        
        System.out.print("Podaj do którego wyrazu ciągu Fibonacciego obliczyć: ");
                
        return Integer.parseInt(ObjectScanner.nextLine());
    }
    
    public static int GetCountMeasurement()
    {
        Scanner ObjectScanner;
        
        ObjectScanner = new Scanner(System.in);
        
        System.out.print("Ile pomiarów dokonać: ");
                
        return Integer.parseInt(ObjectScanner.nextLine());
    }
}
