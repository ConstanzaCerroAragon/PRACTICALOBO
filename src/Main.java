import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Main {

    static Scanner scanner = new Scanner(System.in);
    static String[] nombre = new String[7];
    static int[] ids = new int [7];
    static boolean [] roles = new boolean[7];


    public static void main(String[] args) {
        captarNombresUsuarios();
        asignarids();
        mostrarNombresYIds();
    }

    /**
     * Los jugadores ingresan sus nombres
     */
    static void captarNombresUsuarios() {
        for (int i = 0; i < 7; i++) {
            System.out.println("Ingrese el nombre del jugador " + (i + 1) + ": ");
            nombre[i] = scanner.nextLine();
        }
    }

    /**
     *Asignan los ids a los nombres de los usuarios de forma random
     */
    static void asignarids()  {
        int [] idsDisponibles = new int [7];
        for (int i = 0; i < 7; i++) {
            idsDisponibles[i] = i + 1;
        }

        for (int i = 0; i < 7; i++) {
            int randomIndex = Random.nextInt(7 - i); // Genera un índice aleatorio
            ids[i] = idsDisponibles[randomIndex]; // Asigna el ID correspondiente
            // Eliminamos el ID asignado de la lista de IDs disponibles
            for (int j = randomIndex; j < 6 - i; j++) {
                idsDisponibles[j] = idsDisponibles[j + 1];
            }
        }

    }

    static void mostrarNombresYIds() {
        System.out.println("Nombres y IDs asignados: ");
        for (int i=0; i < 7; i++) {
            System.out.println("Nombre: " + nombre[i] + ids[i]);
        }
    }


}

*/