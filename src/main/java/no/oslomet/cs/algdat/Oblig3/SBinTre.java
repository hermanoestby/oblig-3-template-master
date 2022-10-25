package no.oslomet.cs.algdat.Oblig3;


import java.util.ArrayList;
import java.util.Comparator;
import java.util.Objects;
import java.util.StringJoiner;

public class SBinTre<T> {


    public static void main(String[] args) {


    }


    private static final class Node<T>   // en indre nodeklasse
    {
        private T verdi;                   // nodens verdi
        private Node<T> venstre, høyre;    // venstre og høyre barn
        private Node<T> forelder;          // forelder

        // konstruktør
        private Node(T verdi, Node<T> v, Node<T> h, Node<T> forelder) {
            this.verdi = verdi;
            venstre = v;
            høyre = h;
            this.forelder = forelder;
        }

        private Node(T verdi, Node<T> forelder)  // konstruktør
        {
            this(verdi, null, null, forelder);
        }

        @Override
        public String toString() {
            return "" + verdi;
        }

    } // class Node

    private Node<T> rot;                            // peker til rotnoden
    private int antall;                             // antall noder
    private int endringer;                          // antall endringer

    private final Comparator<? super T> comp;       // komparator

    public SBinTre(Comparator<? super T> c)    // konstruktør
    {
        rot = null;
        antall = 0;
        comp = c;
    }

    public boolean inneholder(T verdi) {
        if (verdi == null) return false;

        Node<T> p = rot;

        while (p != null) {
            int cmp = comp.compare(verdi, p.verdi);
            if (cmp < 0) p = p.venstre;
            else if (cmp > 0) p = p.høyre;
            else return true;
        }

        return false;
    }

    public int antall() {
        return antall;
    }

    public String toStringPostOrder() {
        if (tom()) return "[]";

        StringJoiner s = new StringJoiner(", ", "[", "]");

        Node<T> p = førstePostorden(rot); // går til den første i postorden
        while (p != null) {
            s.add(p.verdi.toString());
            p = nestePostorden(p);
        }

        return s.toString();
    }

    public boolean tom() {
        return antall == 0;
    }

    //Oppgave 1
    public boolean leggInn(T verdi) {
        Objects.requireNonNull(verdi, "Ulovlig med nullverdier!");

        Node<T> p = rot, q = null;               // p starter i roten
        int cmp = 0;                      // hjelpevariabel som skal sammenlikne roten med verdien som skal settes inn

        while (p != null)       // fortsetter til p er ute av treet
        {
            q = p;                                 // q er forelder til p
            cmp = comp.compare(verdi, p.verdi);     // bruker komparatoren
            p = cmp < 0 ? p.venstre : p.høyre;     // flytter p
        }

        // p er nå null, dvs. ute av treet, q er den siste vi passerte

        p = new Node<T>(verdi, null);  // oppretter en ny node, med foreldrepeker lik null siden den ikke er satt inn noe sted

        if (q == null) {
            rot = p; // p blir rotnode
            Node<T> n = new Node<T>(verdi, null); //Oppretter en node n med forelder med nullverdi
        } else if (cmp < 0) {
            q.venstre = p; // venstre barn til q
            Node<T> n = new Node<T>(verdi, q); //Oppretter en ny node n med q som foreldrepeker
        } else {
            q.høyre = p;           // høyre barn til q
            Node<T> n = new Node<T>(verdi, q); //Oppretter en ny node n med p som foreldrepeker.
        }

        antall++; // én verdi mer i treet
        endringer++;
        return true;              // vellykket innlegging

        //Det som må legges inn er at noden som legges inn må ha riktig verdi på foreldrepeker.
    }

    //Oppgave 6
    public boolean fjern(T verdi) {
        throw new UnsupportedOperationException("Ikke kodet ennå!");
    }

    public int fjernAlle(T verdi) {
        throw new UnsupportedOperationException("Ikke kodet ennå!");
    }

    //Oppgave 2
    public int antall(T verdi) {
        //Sjekker om null er i treet.
        if (verdi == null) {
            return 0;
        }

        int antall = 0;

        //Lager så en node n som er rotnoden.
        Node<T> n = rot;

        while (n != null) {
            int cmp = comp.compare(verdi, n.verdi);
            if (cmp < 0) {
                n = n.venstre;
            } else {
                if (cmp == 0) {
                    antall++;
                    n = n.høyre;
                }
            }
        }
        return antall;
    }

    //Oppgave 6
    public void nullstill() {
        throw new UnsupportedOperationException("Ikke kodet ennå!");
    }

    //Oppgave 3
    private static <T> Node<T> førstePostorden(Node<T> p) {
        throw new UnsupportedOperationException("Ikke kodet ennå!");

    }

        private static <T > Node < T > nestePostorden(Node < T > p) {
            throw new UnsupportedOperationException("Ikke kodet ennå!");
        }

        //Oppgave 4
        public void postorden (Oppgave<? super T> oppgave){
            throw new UnsupportedOperationException("Ikke kodet ennå!");
        }

        public void postordenRecursive (Oppgave < ? super T > oppgave){
            postordenRecursive(rot, oppgave);
        }

        private void postordenRecursive (Node < T > p, Oppgave < ? super T > oppgave){
            throw new UnsupportedOperationException("Ikke kodet ennå!");
        }

        //Oppgave 5

        public ArrayList<T> serialize () {
            throw new UnsupportedOperationException("Ikke kodet ennå!");
        }


        static <K> SBinTre <K> deserialize(ArrayList < K > data, Comparator < ? super K > c) {
            throw new UnsupportedOperationException("Ikke kodet ennå!");
        }


    } // ObligSBinTre

