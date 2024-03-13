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

        registrarJugadores(nombres, ids);
        asignarRoles(roles);
        mostrarRolesAsignados(nombres, ids, roles);

        // Inicio del juego
        System.out.println("\nHora de comenzar a jugar.");
        System.out.println("¡Que comiencen las rondas!");

        jugar(nombres, roles);
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


    public static void jugar(ArrayList<String> nombres, ArrayList<String> roles) {

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








/*
    public void iniciarJuego() {
        Scanner scanner = new Scanner(System.in);
        jugadores = new ArrayList<>();
        roles = new ArrayList<>();
        enamorados = new ArrayList<>();

        for (int i=1; i <= 7; i++) {
            System.out.println("Nombre del Jugador " + i + ": ");
            String nombreJugador = scanner.nextLine();
            jugadores.add(nombreJugador);
        }

        //para que se mezclen los roles, y no salgan siempre en ese orden, es decir que el jugador uno tenga siempre el aldeano y asi, se usa la funcion
        Collections.shuffle(roles);

        //rellenamos los roles en el array list de roles
        roles.add("Aldeano");
        roles.add("Aldeano");
        roles.add("Aldeano");
        roles.add("Hombre Lobo");
        roles.add("Hombre Lobo");
        roles.add("Bruja");
        roles.add("Cupido");

        System.out.println("Los ");
        //para asignar los nombres de los jugadores a un rol
        for (int i = 0; i <= jugadores.size(); i++) {
            String jugador = jugadores.get(i);
            String rol = roles.get(i);
            System.out.println(jugador + " es " + rol);
        }

        int noche = 1;
        while (!verificarVictoria()) {
            laNoche(noche);
            noche++;
        }

    }

    public void laNoche (int noche) {
        System.out.println("Se ha hecho de noche.....");
        System.out.println("Ahora si, comienza el juego.....");

        for (String rol : roles ) {
            if (rol.equals("Lobo")) {
                System.out.println("Se despertaron los Lobos y deben asignar a una victima: ");
                Scanner scanner = new Scanner(System.in);
                System.out.println("Ingresar el nombre de la victima: ");
                String victima = scanner.nextLine();
                System.out.println("La victima elegida por los Lobos es: " +  victima);
                break;
            }
        }

        for (String rol : roles ) {
            if (rol.equals("Bruja")) {
                Scanner scanner = new Scanner(System.in);
                System.out.println("La bruja se despierta, y decide si usar alguna de sus pociones: ");
                System.out.println("1-La Pocion Curativa");
                System.out.println("2-La Pocion Veneno");
                System.out.println("La bruja elije una opcion: ");
                int opcion = scanner.nextInt();
                scanner.nextLine();

                if (opcion == 1) {
                    System.out.println("La bruja a decidido usar la posicon Curativa.");
                }else if (opcion == 2) {
                    System.out.println("La bruja a decidido usar la pocion Veneno");
                }else {
                    System.out.println("Opcion no valida, ingrese 1 o 2");
                }
                break;
            }
        }

        for (String rol : roles) {
            if (rol.equals("Cupido")) {
                System.out.println("Se despierta cupido, que unira y enamorara a dos jugadores");
                Scanner scanner = new Scanner(System.in);
                System.out.println("Elije al primer enamorado");
                String enamorado1 = scanner.nextLine();
                System.out.println("Elije al segundo enamorado");
                String enamorado2 = scanner.nextLine();
                enamorados.add(enamorado1);
                enamorados.add(enamorado2);
                System.out.println(enamorado1 + "y" + enamorado2 + "estan enamorados");
                break;
            }
        }

        if (verificarVictoria()) {
            return;
        }

    }

    private boolean verificarVictoria() {
        int aldeanosRestantes = 0;
        int lobosRestantes = 0;

        for (String rol : roles){
            if (rol.equals("Aldeano")) {
                aldeanosRestantes++;
            }else if (rol.equals("Lobo")){
                lobosRestantes++;
            }
        }
        return aldeanosRestantes <= lobosRestantes || lobosRestantes == 0;
    }

    public void elDia () {

    }

     */





