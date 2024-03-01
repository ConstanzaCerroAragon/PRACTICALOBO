import java.util.ArrayList;
import java.util.Random;

public class Main {
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
}