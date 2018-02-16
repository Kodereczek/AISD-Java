/**
 *
 * @author Patryk
 *
 */

package zadanie;

import java.util.Scanner;
import java.util.Random;
import java.util.Arrays;

public class Zadanie 
{
    public static void main(String[] args)
    {
        SimpleTimer timer;                                                          //
        Random generator;                                                           //
        int zakresLosowań;                                                          //
        int szukana;                                                                //   Blok deklaracji zmiennych
        int rozmiarWektor;                                                          //
        int wektor[];                                                               //
        int i;                                                                      //
        int wynik;                                                                  //
        long czas;                                                                  //
        
        timer = new SimpleTimer();                                                  //
        generator = new Random();                                                   //
        zakresLosowań = PobierzDane("Podaj zakres liczb losowych:\n") + 1;          //
        szukana = PobierzDane("Jaką wartość znaleźć?\n");                           //   Blok inicjalizacji zmiennych
        rozmiarWektor = PobierzDane("Z ilu elementów ma się składać tablica?\n");   //
        wektor = new int[rozmiarWektor];                                            //
        i = 0;                                                                      //
        wynik = -1;                                                                 //
        czas = 0;                                                                   //
        
        for(i = 0; i < wektor.length; ++i)                                          //
        {                                                                           //   Generowanie zmiennych losowych typu int
            wektor[i] = generator.nextInt(zakresLosowań);                           //   oraz zapisanie ich kolejno w tablicy
            System.out.print(wektor[i] + "  ");                                     //   o nazwe wektor
        }                                                                           //
        
        Arrays.sort(wektor);                                                        //   Sortowanie rosnące elementów tablicy "wektor"
        
        timer.Start();                                                              //   Początek pomiaru czasu wykonywania metody wyszukującej
        wynik = Wyszukaj(wektor, szukana);                                          //   Wykonanie metody wyszukującej
        timer.Stop();                                                               //   Koniec pomiaru czasu wykonywania metody wyszukującej
        
        czas = timer.Time();
        
        timer.Start();                                                              //   Początek pomiaru czasu wykonywania metody wyszukującej
        wynik = WyszukajBinarnie(wektor, szukana);                                  //   Wykonanie metody wyszukującej binarnie
        timer.Stop();                                                               //   Koniec pomiaru czasu wykonywania metody wyszukującej
        
        if(wynik > -1)                                                              //
        {                                                                           //     
            System.out.print("\nZnaleziono podaną wartość.\n");                     //   Jeżeli metoda wyszukująca znalazła zadaną wartość to
        }                                                                           //   wynik będzie większy od -1
        else                                                                        //      
        {                                                                           //   Jeżeli nie znajdzie to
            System.out.print("\nNie znaleziono podanej wartości.\n");               //   wynik będzie równy -1
        }                                                                           //
                                                        
        System.out.print("Czas wyszukiwania: " + czas + "ns\n");
        System.out.print("Czas wyszukiwania binarnie: " + timer.Time() + "ns\n");   //   Wyświetla czas wykonywania metody wyszukującej
    }
    
    public static int PobierzDane(String tekst)                                     //   METODA "PobierzDane"
    {
        Scanner skaner;                                                             //   Deklaracja zmiennych
        int wynik;                                                                  //
        
        skaner = new Scanner(System.in);                                            //   Inicjalizacja zmiennych
        wynik = 0;                                                                  //
        
        System.out.print(tekst);                                                    //   Wyświetli wartość zmiennej tekst
        
        wynik = Integer.parseInt(skaner.nextLine());                                //   Pobierze z wejścia wartość typu int wprowadzoną przez użytkownika
        
        if(wynik < 1) return 1;                                                     //   Jeżeli wynik będzie mniejszy od 1 to metoda zwróci 1
        else          return wynik;                                                 //   Jeżeli nie to zwróci wynik
    }
    
    public static int Wyszukaj(int wektor[], int szukana)                           //   METODA "Wyszukaj"
    {
        int wynik;                                                                  //   Deklaracja zmiennych
        int i;                                                                      //
        
        wynik = -1;                                                                 //   Inicjalizacja zmiennych 
        i = 0;                                                                      //
        
        for(i = 0; i < wektor.length; ++i)                                          //   Pętla for będzie działąć dopóki zmienna "i" będzie
        {                                                                           //   mniejsza od największego indeksu tablicy "wektor"
            if(wektor[i] == szukana) wynik = i;                                     //   Jeżeli wartość "wektor[i]" będzie równa wartości "szukana"
        }                                                                           //   to przypisz do zmiennej "wynik" wartość "i"
        
        return wynik;                                                               //   Zwraca nr indeksu w tablicy "wektor" lub "-1" jeśli zadana wartość nie została znaleziona
    }
    
    public static int WyszukajBinarnie(int wektor[], int szukana)                   //   METODA "WyszukajBinarnie"
    {
        int początek, koniec, środek;                                               //   Deklaracja zmiennych
        
        początek = 0;                                                               //
        koniec = wektor.length;                                                     //   Inicjalizacja zmiennych
        środek = 0;                                                                 //
        
        while(początek < koniec)                                                    //   Pętla "while" będzie działąć dopóki zmienna "początek" będzie mniejsza od zmiennej "koniec"
        {
            środek = (int)((początek + koniec) / 2);                                //   Działanie mające na celu ustalić nowy punkt środka tablicy "wektor"
            
                 if(wektor[środek] == szukana) return środek;                       //   Jeżeli szukana wartość znajduje się w środkowym indeksie tablicy "wektor" zwróci indeks środkowy
            else if(wektor[środek] < szukana)  początek = środek + 1;               //   Jeżeli szukana wartość jest mniejsza niż indeksu środkowego tablicy "wektor" ustawi początkowy indeks tablicy "wektor" na indeks środka powiększony o "1"
            else                               koniec = środek - 1;                 //   Jeżeli szukana wartość jest większa od indeks środkowego tablicy "wektor" ustawi końcowy indeks tablicy "wektor" na indeks środka pomniejszony o "1"
        }
        
        return -1;                                                                  //   Zwróci "-1" jeśli nie znajdzie wartości zmiennej "szukana" w tablicy "wektor"
    }
}