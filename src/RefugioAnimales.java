import java.util.*;

public class RefugioAnimales {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        boolean activo = true;
        List<String> animales = new ArrayList<>();
        Map<String, String> estadoAnimal = new HashMap<>();
        Set<String> especies = new HashSet<>();
        Map<String, String> animalEspecie = new HashMap<>();
        String[] estados = { "Disponible", "Adoptado" };
        Map<String, String> nombreOriginal = new HashMap<>();
        int opcion = 0;

        do {
            mostrarMenu();
            System.out.print("Ingrese una opcion: ");

            if (!scan.hasNextInt()) {
                System.out.println("Debe ingresar un número");
                scan.nextLine();
                continue;
            }

            opcion = scan.nextInt();
            scan.nextLine(); // limpiar buffer

            switch (opcion) {
                case 1 -> RegistrarAnimal(
                    scan,
                    animales,
                    especies,
                    estadoAnimal,
                    animalEspecie,
                    nombreOriginal,
                    estados
                );

                case 6 -> mostrarReporte(animales, estadoAnimal, animalEspecie, nombreOriginal);

                case 7 -> activo = false;

                default -> System.out.println("Opcion no valida");
            }

        } while (activo);

        scan.close();
    }

    public static void mostrarMenu() {
        System.out.println("\n=== REFUGIO DE ANIMALES ===");
        System.out.println("1. Registrar animal");
        System.out.println("2. Registrar especie");
        System.out.println("3. Marcar animal como adoptado");
        System.out.println("4. Mostrar animales disponibles");
        System.out.println("5. Mostrar animales adoptados");
        System.out.println("6. Mostrar reporte general");
        System.out.println("7. Salir");
    }

    public static void RegistrarAnimal(Scanner scan, List<String> animales, Set<String> especies, Map<String, String> estadoAnimal, Map<String, String> animalEspecie, Map<String, String> nombreOriginal, String[] estados) {
        System.out.println("Ingrese nombre del animal: ");
        String input = scan.nextLine().trim();
        String nombre = input.toLowerCase();
        String nombreFormateado = capitalizar(input);

        if(animales.contains(nombre)) {
            System.out.println("El animal " + nombreFormateado + " ya esta registrado.");
            return;
        }

        System.out.print("Especie: ");
        String especieInput = scan.nextLine().trim();
        String especie = especieInput.toLowerCase();

        if(!especies.contains(especie)){
            System.out.println("La especie no existe.");
            System.out.print("¿Desea registrarla? (s/n): ");
            String respuesta = scan.nextLine();

            if(respuesta.equalsIgnoreCase("s")) {
                especies.add(especie);
                System.out.println("Especie registrada.");
            } else {
                System.out.println("Registro cancelado.");
                return;
            }
        }

        animales.add(nombre);
        estadoAnimal.put(nombre, estados[0]);

        nombreOriginal.put(nombre, nombreFormateado);
        animalEspecie.put(nombre, especie);
        System.out.println("Animal registrado");
    }

    public static String capitalizar(String texto){
        if (texto == null || texto.isEmpty()) return texto;
        return texto.substring(0, 1).toUpperCase() + texto.substring(1).toLowerCase();
    }

    public static void mostrarReporte(List<String> animales, Map<String, String> estadoAnimal, Map<String, String> animalEspecie, Map<String, String> nombreOriginal) {
        long adoptados = animales.stream()
                .filter(animal -> "Adoptado".equalsIgnoreCase(estadoAnimal.get(animal)))
                .count();

        List<String> reporte = new ArrayList<>();

        reporte.add("\n========= REPORTE GENERAL =========");
        reporte.add(String.format("Total de animales registrados: %d", animales.size()));
        reporte.add(String.format("Total disponibles             : %d", animales.size() - adoptados));
        reporte.add(String.format("Total adoptados               : %d", adoptados));

        reporte.add("\n--- Animales registrados ---");
        if (animales.isEmpty()) {
            reporte.add("No hay animales registrados.");
        } else {
            reporte.add("+-----------------+--------------+------------+");
            reporte.add("| NOMBRE          | ESPECIE      | ESTADO     |");
            reporte.add("+-----------------+--------------+------------+");

            for (String animal : animales) {
                String nombreMostrar = nombreOriginal.getOrDefault(animal, capitalizar(animal));
                String especie = animalEspecie.getOrDefault(animal, "Sin especie");
                String estado = estadoAnimal.getOrDefault(animal, "Disponible");

                reporte.add(String.format("| %-15s | %-12s | %-10s |",
                        nombreMostrar,
                        especie,
                        estado));
            }

            reporte.add("+-----------------+--------------+------------+");
        }
        reporte.forEach(System.out::println);
    }
}
