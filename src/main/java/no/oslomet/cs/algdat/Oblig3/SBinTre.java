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
            rot = new Node<T>(verdi, null); //p blir rotnode
        } else if (cmp < 0) {
            q.venstre = new Node<T>(verdi, q); //venstre barn til q
        } else {
            q.høyre =  new Node<T>(verdi, q);    // høyre barn til q
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
        //Sjekker om verdien vi ser etter er null.
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
                }
                n = n.høyre;
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
        //Finne første noden når man det er sortert etter postorden. Bruker her en while-løkke
        //Sjekker om nodene har en verdi
        while(p.venstre != null || p.høyre != null){
            if(p.venstre != null){
                p=p.venstre;
            }else {
                p=p.høyre;
            }
        }
        return p;
    }

        private static <T > Node < T > nestePostorden(Node < T > p) {
            //nestePostorden skal returnere den noden som kommer
            //etter p i postorden. Hvis p er den siste i postorden, skal metoden returnere null

            //Hvis p er rotnode, returner null.
            if (p.forelder==null){
                return null;
            }
            //Sjekker om p er et høyrebarn. I såfall er foreldre den neste.t
            else if (p.forelder.høyre == p) {
                return p.forelder;
            }

            //
            else{
                //Returnerer foreldrenoden hvis den er enebarn
                if(p.forelder.høyre == null){
                    return p.forelder;
                }
                //Hvis den ikke er enebarn så kaller vi på en annen metode slik at vi
                //returnerer førstePostorden i subtreet til høyrebarnet til foreldren dens
                else{
                    return førstePostorden(p.forelder.høyre);
                }
            }
        }

        //Oppgave 4
        public void postorden (Oppgave<? super T> oppgave){
           Node <T> p= førstePostorden(rot);
           while(p!=null){
               oppgave.utførOppgave(p.verdi);
               p = nestePostorden(p);
           }
        }

        public void postordenRecursive (Oppgave < ? super T > oppgave){
            postordenRecursive(rot, oppgave);
        }

        private void postordenRecursive (Node < T > p, Oppgave < ? super T > oppgave){

        if(p.venstre!=null){
            postordenRecursive(p.venstre,oppgave);
        }
        if(p.høyre!=null){
            postordenRecursive(p.høyre,oppgave);
        }

        oppgave.utførOppgave(p.verdi);

        }

        //Oppgave 5

        public ArrayList<T> serialize () {
            throw new UnsupportedOperationException("Ikke kodet ennå!");
        }


        static <K> SBinTre <K> deserialize(ArrayList < K > data, Comparator < ? super K > c) {
            throw new UnsupportedOperationException("Ikke kodet ennå!");
        }


    } // ObligSBinTre

