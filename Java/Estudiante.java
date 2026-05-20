package Java;

public class Estudiante {
  // Atributos privados
    private String cedula;
    private String nombre;
    private String apellido;
    private float nota1, nota2, nota3;
    private float promedio;
    private String estado;

    // Constructor
    public Estudiante(String cedula, String nombre, String apellido, float nota1, float nota2, float nota3) {
        this.cedula = cedula;
        this.nombre = nombre;
        this.apellido = apellido;
        setNotas(nota1, nota2, nota3); // Validación de notas
        calcularPromedio();
        determinarEstado();
    }

    // Método para asignar notas con validación (0 a 10)
    public void setNotas(float n1, float n2, float n3) {
        this.nota1 = (n1 >= 0 && n1 <= 10) ? n1 : 0;
        this.nota2 = (n2 >= 0 && n2 <= 10) ? n2 : 0;
        this.nota3 = (n3 >= 0 && n3 <= 10) ? n3 : 0;
    }

    // Calcular promedio
    public void calcularPromedio() {
        promedio = (nota1 + nota2 + nota3) / 3;
    }

    // Determinar estado (Aprobado/Reprobado)
    public void determinarEstado() {
        estado = (promedio >= 7.0) ? "Aprobado" : "Reprobado";
    }

    // Mostrar información del estudiante
    public void mostrarInfo() {
        System.out.println("Cedula: " + cedula);
        System.out.println("Nombre: " + nombre + " " + apellido);
        System.out.println("Notas: " + nota1 + ", " + nota2 + ", " + nota3);
        System.out.println("Promedio: " + promedio);
        System.out.println("Estado: " + estado);
        System.out.println("-----------------------------");
    }

    // Obtener estado (para contar aprobados/reprobados)
    public String getEstado() {
        return estado;
    }
}

