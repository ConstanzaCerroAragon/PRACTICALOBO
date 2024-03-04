import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Main {
    public static Scanner input = new Scanner(System.in);
    public static String[][] jugadadores = new String[7][2];
    public static void main(String[] args) {
        String[] personaje = {"Lobo", "Lobo", "Aldeano", "Aldeano", "Aldeano", "Vidente", "Cupido"};
        ArrayList<Integer> idsAsignados = new ArrayList<>();
        Random random = new Random();
        while (idsAsignados.size() < personaje.length) {
            int id = random.nextInt(7) + 1;
            if (!idsAsignados.contains(id)) {
                idsAsignados.add(id);
            }
        }
        for (int i = 0; i < personaje.length; i++) {
            System.out.println(personaje[i] + " corresponde a id" + " " + idsAsignados.get(i));
        }
    }
    private static String pedirNombre () {
        System.out.println("Ingresa tu nombre: ");
        String Nombre = input.nextLine();
        return Nombre;
    }


}