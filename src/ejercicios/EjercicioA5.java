/** @author Andrés P
 *
 **/

package ejercicios;

import java.io.*;
import java.util.Scanner;

// Ejercicio propuesto A.5: Crea un programa que pida al usuario el nombre de un fichero de texto,
// guarde todas sus líneas en un array y las vuelque a un nuevo fichero llamado "salida.txt",
// en orden contrario (de la última a la primera).
public class EjercicioA5 {
    public static void main(String[] args) {
        // Código reusado de: "EjercicioA4.java"
        Scanner sc = new Scanner(System.in);

        System.out.print("\nEscribe el nombre del archivo: ");
        String nombre = sc.nextLine();

        File directory = new File("src/ejercicios");
        File file = new File(directory, nombre);

        String[] fileContent;
        int lineCounter = 0;

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
            // Cuenta las líneas
            while (reader.readLine() != null)
                lineCounter++;
        } catch (Exception e) {
            throw new RuntimeException("Error al leer el fichero: " + e.getMessage());
        }

        fileContent = new String[lineCounter];

        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;

            int i = 0;
            while ((line = reader.readLine()) != null) {
                fileContent[i] = line;
                i++;
            }
        } catch (Exception e) {
            throw new RuntimeException("Error al leer el archivo y modificar el array: " + e.getMessage());
        }

        File output = new File(directory, "salida.txt");

        // Crea el archivo si no existe
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(output))) {
            // Escribir en orden inverso
            for (int i = fileContent.length - 1; i >= 0; i--) {
                writer.write(fileContent[i]);
                writer.newLine();
            }
        } catch (Exception e) {
            throw new RuntimeException("Error al modificar el archivo: \"salida.txt\"" + e.getMessage());
        }
    }
}