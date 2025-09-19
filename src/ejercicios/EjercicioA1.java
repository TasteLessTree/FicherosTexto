/** @author Andrés P
 *
 **/

package ejercicios;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.util.Scanner;

// Ejercicio propuesto A.1: Crea un programa que pida frases al usuario y las guarde en un fichero de texto, cada frase en una línea.
public class EjercicioA1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        File file = new File("src/ejercicios/ejercicioA1.txt");

        // El bucle dentrá su ejecución cuando el usuario lo indice con "salir"
        while (true) {
            System.out.println("\nIngrese una frase o escribe \"salir\" para salir.");
            System.out.print(">> ");

            String frase = sc.nextLine();

            if (frase.equalsIgnoreCase("salir")) {
                System.out.println("Adios.");
                break;
            }

            // Si el archivo no existe, lo creará
            try (BufferedWriter writer = new BufferedWriter(new FileWriter(file, true))) {
                // NO SOBREESCRIBE EL ARCHIVO
                writer.write(frase);
                writer.newLine();
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
    }
}