/** @author Andrés P
 *
 **/

package ejercicios;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.Scanner;

// Ejercicio propuesto A.4: Crea un programa que pida al usuario el nombre de un fichero de texto,
// cuente cuántas líneas contiene, cree un array y guarde todas ellas,
// para luego mostrarlas en pantalla en orden contrario (de la última a la primera).
public class EjercicioA4 {
    public static void main(String[] args) {
        // Código reusado de: "EjercicioA2.java" y "EjercicioA3.java"
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
            throw new RuntimeException("Error al modificar el array: " + e.getMessage());
        }

        // Imprimir en orden inverso
        for (int i = fileContent.length - 1; i >= 0; i--)
            System.out.println(fileContent[i]);
    }
}