/** @author Andrés P
 *
 **/

package ejercicios;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.Scanner;

// Ejercicio propuesto A.2: Crea un programa que pida al usuario el nombre de un fichero de texto
// y muestre todo su contenido en pantalla.
//  Tras cada 24 líneas, deberá hacer una pausa hasta que el usuario pulse Intro.
public class EjercicioA2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Scanner enter = new Scanner(System.in);

        System.out.print("\nEscribe el nombre del fichero: ");
        String nombre = sc.nextLine();

        File directory = new File("src/ejercicios");
        File file = new File(directory, nombre);

        // Nos aseguramos que el archivo exista
        while (!file.exists()) {
            System.out.println("El fichero no existe. Mostrando todos los ficheros y directorios dentro del directorio actual: ");
            System.out.println("Recomendado: \"texto.txt\""); // https://es.lipsum.com/feed/html
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
            String line;
            int count = 0;

            while ((line = reader.readLine()) != null) {
                System.out.println(line);
                count++;

                if (count % 24 == 0) {
                    System.out.print("\nPulsa [ENTER] para continuar leyendo el documento.");
                    enter.nextLine();
                    System.out.println();
                }
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}