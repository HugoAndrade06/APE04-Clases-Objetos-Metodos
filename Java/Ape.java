package Java;
import java.util.Scanner;
public class Ape {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int cantidad = 5; // mínimo 5 estudiantes
        Estudiante[] estudiantes = new Estudiante[cantidad];

        System.out.println("=== Registro de Estudiantes ===");

        // Registrar estudiantes con entrada del usuario
        for (int i = 0; i < cantidad; i++) {
            System.out.println("\nEstudiante " + (i + 1));

            System.out.print("Ingrese cedula: ");
            String cedula = sc.nextLine();

            System.out.print("Ingrese nombre: ");
            String nombre = sc.nextLine();

            System.out.print("Ingrese apellido: ");
            String apellido = sc.nextLine();

            System.out.print("Ingrese nota 1: ");
            float n1 = sc.nextFloat();

            System.out.print("Ingrese nota 2: ");
            float n2 = sc.nextFloat();

            System.out.print("Ingrese nota 3: ");
            float n3 = sc.nextFloat();
            sc.nextLine(); // limpiar buffer

            estudiantes[i] = new Estudiante(cedula, nombre, apellido, n1, n2, n3);
        }

        int aprobados = 0, reprobados = 0;

        System.out.println("\n=== Listado de Estudiantes ===");
        // Mostrar información y contar aprobados/reprobados
        for (Estudiante e : estudiantes) {
            e.mostrarInfo();
            if (e.getEstado().equals("Aprobado")) {
                aprobados++;
            } else {
                reprobados++;
            }
        }

        // Mostrar estadísticas finales
        System.out.println("Total Aprobados: " + aprobados);
        System.out.println("Total Reprobados: " + reprobados);

        sc.close();
    }
}