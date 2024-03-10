import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;
import java.util.List;

public class  Main {
    public static Scanner scanner = new Scanner(System.in);
    public static Random random = new Random();

    public static void main(String[] args) {
     Main juego=new Main(); //Creamos el objeto juego
     juego.iniciarJuego();
    }
    public void iniciarJuego() {
        System.out.println("Bienvenidos al juego.");
    }
}
