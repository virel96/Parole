package parole;

public class Parole {

    public static void main(String[] args) {
        
        Gestione g = new Gestione();
        int option;
        
        do {
            option = g.getInt();
        } while (option > 4 || option < 0);

        switch (option) {
            case 1:
                hashSet(g);
                break;
            case 2:
                hashMap(g);
                break;
            case 3:
                System.exit(0);
        }

    }

    public static void hashMap(Gestione g) {
        
        System.out.println("Parole diverse tra loro: " + g.readHashMap());
        
    }

    public static void hashSet(Gestione g) {
        
        System.out.println("Parole diverse tra loro: " + g.readHashSet());
        
    }

}

