package przykładNaRekurencyjneDefinicjeKLas;

// Klasy odwołujące się do własnej definicji - czysty przykład
class A{
    A a;
}

// Klasy odwołujące się do własnej definicji - przykład praktyczny

class WęzełListy{
    private int 	    wartość;            // Atrybut
    private WęzełListy  następny;          // Atrybut tej samej klasy i jest to bardzo potrzebne, że tej samej

    public WęzełListy(int wart, WęzełListy nast) {  // konstruktor
        wartość   = wart;
        następny = nast;
    }

    public void wypisz(){                        // jakaś metoda, tylko dla pokazania, że coś jest w węzłach
        System.out.print(wartość); 	// wypisz swoją wartość

        if (następny != null) {
            System.out.print(",");      // tylko żeby liczby się nie sklejały
            następny.wypisz();         // wypisz resztę
        }
    }
    // dalsze metody, tu nieistotne
}

class Lista{
    private WęzełListy początek;         // Atrybut

    public Lista(){                              // Konstruktor
        początek = null;
    }

    public void wstawNaPoczątek(int k){  // Jakaś metoda, wstawia do listy (czyli używa WęzełListy)
        początek = new WęzełListy(k, początek);
    }

    public void wypisz(){                // Jakaś metoda, tylko dla sprawdzenia, że coś (WęzełListy) w liście jest
        System.out.print("[");

        if(początek != null)
            początek.wypisz();

        System.out.println("]");
    }

    // Pewnie dalsze metody, tu nieistotne
}


public class Test {

    public static void main(String args){
        // Dla sprawdzenia:

        // Tworzę obiekt A
        A a = new A();

        // Tworzę obiekt lista
        Lista lst = new Lista();

        // Wywołuję jego metody wstawiając liczby na początek
        for(int i=0; i<=10; i++){
            lst.wstawNaPoczątek(i);
        }

        // Wypisuję
        lst.wypisz();
    }
}
