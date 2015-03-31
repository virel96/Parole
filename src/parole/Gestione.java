package parole;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Scanner;

public class Gestione {

    int numParole, numPDiverse = 0;
    String[] parole = null;
    HashMap<String, Integer> map;
    HashSet set;

    public Gestione() {
        
        map = new HashMap<>();
        set = new HashSet();
        
    }

    public int getInt() {
        
        Scanner lettore = new Scanner(System.in);
        System.out.println("Opzione: ");
        System.out.println("1 HashSet");
        System.out.println("2 HashMap");
        System.out.println("3 Exit");
        System.out.print("Inserisci un numero:");
        return lettore.nextInt();
        
    }

    public int readHashSet() {
        
        try {
            FileInputStream f = new FileInputStream("dati/romanzo.txt");
            InputStreamReader is = new InputStreamReader(f);
            BufferedReader b = new BufferedReader(is);
            while (b.ready()) {
                String str = b.readLine();
                System.out.println(str);
                parole = str.split(" |,|\\.|;|:|'|-|!|\\?");
                for (int i = 0; i < parole.length; i++) {
                    if (set.contains(parole[i])) {
                        numPDiverse++;
                    }
                    set.add(parole[i]);
                    numParole++;
                }
            }
            
            System.out.println("-------------------------");
            System.out.println(set.toString());
            Iterator it = set.iterator();
            while (it.hasNext()) {
                System.out.print("Value: " + it.next().toString() + " \t");
            }
            
            System.out.println("-------------------------");
            System.out.println("Parole: " + numParole);
            
        } catch (FileNotFoundException ex) {
            System.out.println(ex.getMessage());
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
        return numPDiverse;

    }

    public int readHashMap() {
        
        try {
            
            FileInputStream f = new FileInputStream("dati/romanzo.txt");
            InputStreamReader is = new InputStreamReader(f);
            BufferedReader b = new BufferedReader(is);
            while (b.ready()) {
                String str = b.readLine();
                parole = str.split(" |,|\\.|;|:|'|-|!|\\?");
                for (int i = 0; i < parole.length; i++) {
                    
                    if (map.containsKey(parole[i])) {
                        numPDiverse++;
                        map.replace(parole[i],map.get(parole[i]), map.get(parole[i])+1);
                    } else if (map.isEmpty() || !map.containsKey(parole[i])) {
                        map.put(parole[i], 1);
                    }
                    numParole++;
                }
                
            }
            
            System.out.println(map);
            System.out.println("Parole: " + numParole);
            
        } catch (FileNotFoundException ex) {
            System.out.println(ex.getMessage());
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
        
        return numPDiverse;
        
    }

}
