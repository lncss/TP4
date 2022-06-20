//package Q08;
import java.io.*;
import java.text.ParseException;
import java.util.Scanner;

public class Busca {

    public static class No {
        public int elemento;
        public No esq, dir;

        public No(int elemento) {
            this(elemento, null, null);
        }

        public No(int elemento, No esq, No dir) {
            this.elemento = elemento;
            this.esq = esq;
            this.dir = dir;
        }
    }

    public static class Binaria {
        private No raiz;

        public Binaria() {
            raiz = null;
        }

        public boolean pesquisar(int x) {
            return pesquisar(x, raiz);
        }

        private boolean pesquisar(int x, No i) {
            boolean resp;
            if (i == null) {
                resp = false;

            } else if (x == i.elemento) {
                resp = true;

            } else if (x < i.elemento) {
                resp = pesquisar(x, i.esq);

            } else {
                resp = pesquisar(x, i.dir);
            }
            return resp;
        }

        public void caminharCentral() {
            caminharCentral(raiz);
            System.out.println("");
        }

        private void caminharCentral(No i) {
            if (i != null) {
                caminharCentral(i.esq);
                System.out.print(i.elemento + " ");
                caminharCentral(i.dir);
            }
        }

        public void caminharPre() {
            caminharPre(raiz);
            System.out.println("");
        }

        private void caminharPre(No i) {
            if (i != null) {
                System.out.print(i.elemento + " ");
                caminharPre(i.esq);
                caminharPre(i.dir);
            }
        }

        public void caminharPos() {
            caminharPos(raiz);
            System.out.println("");
        }

        private void caminharPos(No i) {
            if (i != null) {
                caminharPos(i.esq);
                caminharPos(i.dir);
                System.out.print(i.elemento + " ");
            }
        }

        public void inserir(int x) throws Exception {
            raiz = inserir(x, raiz);
        }

        private No inserir(int x, No i) throws Exception {
            if (i == null) {
                i = new No(x);

            } else if (x < i.elemento) {
                i.esq = inserir(x, i.esq);

            } else if (x > i.elemento) {
                i.dir = inserir(x, i.dir);

            } else {
                throw new Exception("Erro ao inserir!");
            }

            return i;
        }
    }
    public static void main(String[] args) throws Exception, ParseException{
        Scanner sc = new Scanner(System.in);
        int c = Integer.parseInt(sc.nextLine().trim()); //numero de casos de teste 
    
        for(int i = 0; i < c; i++){
            Binaria a = new Binaria();

            int n = Integer.parseInt(sc.nextLine().trim()); //quantidade de num que deve compor a arvore
            
            String num = sc.nextLine(); //numeros da arvore
            String[] array = num.split(" "); //quebra a string em substrings apos os espacos e armazena em um array de strings
            
            for(int j = 0; j < n; j++){
                a.inserir(Integer.parseInt(array[j])); //passar as substrings armazenados no array para inteiros
            }

            System.out.println("Case " + (i + 1) + ":");

            System.out.print("Pre.: ");
            a.caminharPre(); //mostra caminhar pre

            System.out.print("In..: ");
            a.caminharCentral(); //mostra caminhar central

            System.out.print("Post: ");
            a.caminharPos(); //mostra camnihar pos

            System.out.println(""); //ultima linha em branco 
        }

        sc.close();     
    }
}
