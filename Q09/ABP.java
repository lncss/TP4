import java.util.Scanner;

public class ABP {

    public static class No {
        public char elemento;
        public No esq, dir;

        public No(char elemento) {
            this(elemento, null, null);
        }

        public No(char elemento, No esq, No dir) {
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

        public boolean pesquisar(char x) {
            return pesquisar(x, raiz);
        }

        private boolean pesquisar(char x, No i) {
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

        public void inserir(char x) throws Exception {
            raiz = inserir(x, raiz);
        }

        private No inserir(char x, No i) throws Exception {
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
    public static void main(String[] args)throws Exception{
        Binaria a = new Binaria();
        String line = "";
        char c, resultado;

        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()){
            line = sc.nextLine();
            c = line.charAt(0);
            resultado = line.charAt(2);

            if(c == 'I' && line.charAt(1) == ' '){
                a.inserir(resultado);
            }else if(c == 'P' && line.charAt(1) == ' '){
                if(a.pesquisar(resultado)){
                    MyIO.println(resultado + " existe");
                }else{
                    MyIO.println("nao existe");
                }
            }else if(c == 'I' && resultado == 'F'){
                a.caminharCentral();
            }else if(c == 'P' && resultado == 'E'){
                a.caminharPre();
            }else if(c == 'P' && resultado == 'S'){
                a.caminharPos();
            }
        }
        sc.close();
    }
}
