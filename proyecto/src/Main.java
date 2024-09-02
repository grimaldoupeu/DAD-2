public class Main {
    public static void main(String[] args) {
       int i; //declaramos una variable

        for (i=2; i<=100; i+=2) { //biucle for que itera desde 2 hasta 100 de 2 em 2
            System.out.println(i+",");//imprimimos en pantalla a"i"
            if (i%20==0) {//si el resto de "i" entre 20 nos da cero.....
                System.out.println(i);//imprimimos un salto de linea

            }
        }
    }
}