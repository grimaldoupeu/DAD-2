import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Ingrese un número (1-10): ");
        int numero = scanner.nextInt();

        if (numero < 1 || numero > 10) {
            System.out.println("Número fuera de rango. Debe ser entre 1 y 10.");
            return; // Salir del programa si el número no está en el rango
        }

        for (int i = 1; i <= 10; i++) {
            System.out.println(numero + " x " + i + " = " + (numero * i));
        }
        for (int i = 1; i <= 10; i++) {
            System.out.println(numero + " x " + i + " = " + (numero * i));
            {

            }
            for (i = 1; i <= 10; i++) {
                System.out.println(numero + " x " + i + " = " + (numero * i));
                {

                }

                scanner.close();
            }
        }
    }
}
