
package EstructuraDeDatos;


import java.util.Scanner;

public class ReproductorApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ListaCircularDoble playlist = new ListaCircularDoble();
        int opcion = 0;

        do {
            System.out.println("\n========================================");
            System.out.println("GESTOR DE LISTA DE REPRODUCCIÓN (LCDC)");
            System.out.println("========================================");
            System.out.println("1. Agregar canción al inicio");
            System.out.println("2. Agregar canción al final");
            System.out.println("3. Buscar canción por identificador");
            System.out.println("4. Seleccionar canción por identificador (hacer actual)");
            System.out.println("5. Eliminar canción por identificador");
            System.out.println("6. Eliminar directamente la canción actual");
            System.out.println("7. Consultar la canción actual");
            System.out.println("8. Avanzar a la siguiente canción");
            System.out.println("9. Retroceder a la canción anterior");
            System.out.println("10. Mostrar la lista completa (ambos sentidos)");
            System.out.println("11. Consultar cantidad de canciones");
            System.out.println("12. Simular reproducción de 'k' canciones");
            System.out.println("13. Salir");
            System.out.print("Seleccione una opción: ");

            try {
                opcion = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Entrada inválida. Ingrese un número entero.");
                continue;
            }

            switch (opcion) {
                case 1:
                    System.out.print("Ingrese título: ");
                    String t1 = scanner.nextLine();
                    System.out.print("Ingrese artista: ");
                    String a1 = scanner.nextLine();
                    System.out.print("Ingrese duración en segundos (>0): ");
                    try {
                        int d1 = Integer.parseInt(scanner.nextLine());
                        playlist.agregarInicio(t1, a1, d1);
                    } catch (NumberFormatException e) {
                        System.out.println("Duración inválida.");
                    }
                    break;
                case 2:
                    System.out.print("Ingrese título: ");
                    String t2 = scanner.nextLine();
                    System.out.print("Ingrese artista: ");
                    String a2 = scanner.nextLine();
                    System.out.print("Ingrese duración en segundos (>0): ");
                    try {
                        int d2 = Integer.parseInt(scanner.nextLine());
                        playlist.agregarFinal(t2, a2, d2);
                    } catch (NumberFormatException e) {
                        System.out.println("Duración inválida.");
                    }
                    break;
                case 3:
                    System.out.print("Ingrese ID a buscar: ");
                    try {
                        int idB = Integer.parseInt(scanner.nextLine());
                        Nodo n = playlist.buscarPorId(idB);
                        if (n != null) System.out.println("Encontrado: " + n.getCancion());
                        else System.out.println("No se encontró el ID " + idB);
                    } catch (NumberFormatException e) {
                        System.out.println("ID inválido.");
                    }
                    break;
                case 4:
                    System.out.print("Ingrese ID a seleccionar como actual: ");
                    try {
                        int idS = Integer.parseInt(scanner.nextLine());
                        playlist.seleccionarPorId(idS);
                    } catch (NumberFormatException e) {
                        System.out.println("ID inválido.");
                    }
                    break;
                case 5:
                    System.out.print("Ingrese ID a eliminar: ");
                    try {
                        int idD = Integer.parseInt(scanner.nextLine());
                        playlist.eliminarPorId(idD);
                    } catch (NumberFormatException e) {
                        System.out.println("ID inválido.");
                    }
                    break;
                case 6:
                    playlist.eliminarActual();
                    break;
                case 7:
                    playlist.consultarActual();
                    break;
                case 8:
                    playlist.avanzar();
                    break;
                case 9:
                    playlist.retroceder();
                    break;
                case 10:
                    playlist.mostrarLista();
                    break;
                case 11:
                    System.out.println("Total de canciones: " + playlist.consultarCantidad());
                    break;
                case 12:
                    System.out.print("Ingrese k (reproducciones a simular > 0): ");
                    try {
                        int k = Integer.parseInt(scanner.nextLine());
                        playlist.simularReproduccion(k);
                    } catch (NumberFormatException e) {
                        System.out.println("Valor k inválido.");
                    }
                    break;
                case 13:
                    System.out.println("Saliendo del programa. ¡Hasta pronto!");
                    break;
                default:
                    System.out.println("Opción no válida.");
            }
        } while (opcion != 13);
        scanner.close();
    }
}
