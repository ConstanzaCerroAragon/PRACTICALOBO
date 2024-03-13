import java.util.*;

public class Main {

    public static void main(String[] args) {
        jugarJuego();
    }

    public static void jugarJuego() {
        Scanner scanner = new Scanner(System.in);
        ArrayList<String> nombres = new ArrayList<>();
        ArrayList<Integer> ids = new ArrayList<>();
        ArrayList<String> roles = new ArrayList<>();
        ArrayList<String> accionLobos = new ArrayList<>();

        registrarJugadores(nombres, ids);
        asignarRoles(roles);
        mostrarRolesAsignados(nombres, ids, roles);

        // Inicio del juego
        System.out.println("\nHora de comenzar a jugar.");
        System.out.println("¡Que comiencen las rondas!");

        jugar(nombres, roles, accionLobos);
    }

    public static void registrarJugadores(ArrayList<String> nombres, ArrayList<Integer> ids){
        Scanner scanner = new Scanner(System.in);

        //Se registran los jugadores
        System.out.println("Bienvenidos al juego de LOBO");

        for (int i = 1; i <= 7; i++) {
                System.out.println("Ingrese el nombre del Jugador " + i + ": ");
                String nombre = scanner.nextLine();
                nombres.add(nombre);
                ids.add(i);
                System.out.println(nombre + " debes recordar este numero de ID ya que luego tu rol estara asociado a este numero ---> ID: " + i);
                System.out.println("Presiona enter si estas listo para que otro juagdor se registre");
                scanner.nextLine();

                //agregamos estas lineas, para que el jugador que sigue, no pueda ver el ID del jugador que se registro antes
                System.out.println("-------------------------------");
                System.out.println("-------------------------------");
                System.out.println("-------------------------------");
                System.out.println("-------------------------------");
                System.out.println("-------------------------------");
                System.out.println("-------------------------------");
                System.out.println("-------------------------------");
                System.out.println("-------------------------------");
                System.out.println("-------------------------------");
                System.out.println("-------------------------------");
                System.out.println("-------------------------------");
        }
    }

    public static void asignarRoles(ArrayList<String> roles) {
        roles.add("Lobo");
        roles.add("Aldeano");
        roles.add("Bruja");
        roles.add("Lobo");
        roles.add("Aldeano");
        roles.add("Aldeano");
        roles.add("Cupido");
        Collections.shuffle(roles);
    }

    public static void mostrarRolesAsignados(ArrayList<String> nombres, ArrayList<Integer> ids, ArrayList<String> roles) {
        System.out.println("\nHora de comenzar a jugar. Los roles son:");
        for (int i = 0; i < nombres.size(); i++) {
            System.out.println("ID " + ids.get(i) + ": " + roles.get(i));
        }
    }


    public static void jugar(ArrayList<String> nombres, ArrayList<String> roles, ArrayList<String> accionLobos) {

        System.out.println("\n¡Es de noche en la aldea!");

        for (String rol : roles) {
            switch (rol) {
                case "Cupido":
                    cupido(nombres);
                    break;
                case "Vidente":
                    vidente(nombres, roles);
                    break;
                case "Lobo":
                    lobo();
                    break;
                case "Aldeano":
                    aldeano();
                    break;
                case "Bruja":
                    bruja();
                    break;
            }

        }
        // Votación
        votacion(nombres);
    }

    public static void cupido(ArrayList<String> nombres) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Cupido se despierta!! Y elije a dos jugadores para enamorar");

        System.out.println("Elije al primer enamorado");
        String enamorado1 = scanner.nextLine();

        System.out.println("Elije al segundo enamorado");
        String enamorado2 = scanner.nextLine();

        System.out.println(enamorado1 + "y" + enamorado2 + "ahora son enamorados");
    }

    public static void vidente(ArrayList<String> nombres, ArrayList<String> roles) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("La vidente se despierta y elije el rol de que jugador quiere saber");

        System.out.println("Escribe el jugador de quien quieres conocer el rol");
        String nombreJugador = scanner.nextLine();

        int index = nombres.indexOf(nombreJugador);
        if (index != -1) {
            String rolJugador = roles.get(index);
            System.out.println("El jugador" + nombreJugador + "tiene el rol: " + rolJugador);
        }else{
            System.out.println("El nombre del jugador no existe en la partida");
        }
    }

    public static void lobo(ArrayList<String> nombres, ArrayList<String> accionLobos) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Se despiertan los lobos y deciden a quien quieren matar esta noche");

        System.out.println("Escribe el nombre del jugador que quieren matar");
        String jugadorMatado = scanner.nextLine();

        if (nombres.contains(jugadorMatado)) {
            accionLobos.add("Atacaron a " + jugadorMatado);
        }else {
            System.out.println("Ingrese un nombre valido");
        }
    }

    public static void bruja(boolean pocionSalvacion, boolean pocionMatar, ArrayList<String> accionesLobos) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Se despierta la bruja!! y decide si usar sus pocimas");

        if (!pocionSalvacion) {
            System.out.println("¿Quieres usar la poción de salvación? (s/n)");
            String respuestaSalvacion = scanner.nextLine();

            if (respuestaSalvacion.equalsIgnoreCase("s")) {
                System.out.println("El jugador atacado por los lobos es: " + accionesLobos.get(accionesLobos.size() - 1));
                System.out.println("¿Quieres salvarlo? (s/n)");
                String respuestaSalvar = scanner.nextLine();
                if (respuestaSalvar.equalsIgnoreCase("s")) {
                    System.out.println("La bruja ha usado la poción de salvación para salvar al jugador atacado por los lobos.");
                    pocionSalvacion = true;
                }
            }

            if (!pocionMatar) {
                System.out.println("¿Quieres usar la poción de matar? (s/n)");
                String respuestaMatar = scanner.nextLine();

                if (respuestaMatar.equalsIgnoreCase("s")) {
                    System.out.println("¿A quién quieres matar?");
                    String jugadorAMatar = scanner.nextLine();

                    // Lógica para matar al jugador...
                    System.out.println("La bruja ha usado la poción de matar para eliminar a " + jugadorAMatar + ".");
                    accionesLobos.add("La bruja ha matado a " + jugadorAMatar); // guardo el nombre del jugador matado
                }
            }
        }
    }


    public static void votacion(ArrayList<String> nombres) {
        Scanner scanner = new Scanner(System.in);
        int[] votos = new int[nombres.size()];

        System.out.println("\n¡Es de día en la aldea! Hora de votar quién será eliminado.");

        // Turno de votación
        for (int i = 0; i < nombres.size(); i++) {
            System.out.println("Jugador " + nombres.get(i) + ", es tu turno de votar:");
            System.out.println("¿A quién votas para eliminar? (Escribe el nombre del jugador)");
            String voto = scanner.nextLine();

            // Contar votos
            int votoIndex = nombres.indexOf(voto);
            if (votoIndex != -1) {
                votos[votoIndex]++;
            } else {
                System.out.println("¡El jugador ingresado no existe!");
            }
        }

        // Encontrar al jugador más votado
        int maxVotos = 0;
        int jugadorEliminado = -1;
        for (int i = 0; i < votos.length; i++) {
            if (votos[i] > maxVotos) {
                maxVotos = votos[i];
                jugadorEliminado = i;
            }
        }

        // Anunciar jugador eliminado
        System.out.println("El jugador " + nombres.get(jugadorEliminado) + " ha sido eliminado.");
    }

    }





