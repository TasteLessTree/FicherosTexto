/** @author Andrés P
 *
 **/

package ejercicios;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.Scanner;

// Ejercicio propuesto A.3: Crea un programa que pida al usuario el nombre de un fichero de texto y muestre en pantalla la cantidad de líneas de texto que contiene.
public class EjercicioA3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("\nEscribe el nombre del archivo: ");
        String nombre = sc.nextLine();

        File directory = new File("src/ejercicios");
        File file = new File(directory, nombre);

        // Código reusado de: "EjercicioA2.java"
        // Nos aseguramos que el archivo exista
        while (!file.exists()) {
            System.out.println("El fichero no existe. Mostrando todos los ficheros y directorios dentro del directorio actual: ");
            String[] infoDirect = directory.list();

            // Asegurarse que infoDirect no sea null
            assert infoDirect != null;
            for (String files : infoDirect) {
                System.out.println(files);
            }

            System.out.print("\nEscribe el nombre del fichero: ");
            nombre = sc.nextLine();

            file = new File(directory, nombre);
        }

        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            int lineCounter = 0;

            while (reader.readLine() != null)
                lineCounter++;

            System.out.println("El archivo: \"" + file.getName() + "\" contiene: " + lineCounter + " líneas.");
        } catch (Exception e) {
            throw new RuntimeException("Error al leer el fichero: " + e.getMessage());
        }
    }
}