#include <iostream>
#include <string>
using namespace std;

// -------------------------------
// Clase Estudiante
// -------------------------------
class Estudiante {
private:
    // Atributos privados
    string cedula;
    string nombre;
    string apellido;
    float nota1, nota2, nota3;
    float promedio;
    string estado;

public:
    // Constructor vacío (inicializa valores por defecto)
    Estudiante() {
        cedula = "";
        nombre = "";
        apellido = "";
        nota1 = nota2 = nota3 = 0;
        promedio = 0;
        estado = "Reprobado";
    }

    // Método para registrar datos del estudiante
    void registrarDatos() {
        cout << "Ingrese cedula: ";
        cin >> cedula;
        cout << "Ingrese nombre: ";
        cin >> nombre;
        cout << "Ingrese apellido: ";
        cin >> apellido;

        // Ingreso y validación de notas
        cout << "Ingrese nota 1: ";
        cin >> nota1;
        validarNota(nota1);

        cout << "Ingrese nota 2: ";
        cin >> nota2;
        validarNota(nota2);

        cout << "Ingrese nota 3: ";
        cin >> nota3;
        validarNota(nota3);

        // Calcular promedio y estado automáticamente
        calcularPromedio();
        determinarEstado();
    }

    // Validar que la nota esté entre 0 y 10
    void validarNota(float &nota) {
        if (nota < 0 || nota > 10) {
            cout << "Nota invalida. Se asigna 0." << endl;
            nota = 0;
        }
    }

    // Calcular promedio de las tres notas
    void calcularPromedio() {
        promedio = (nota1 + nota2 + nota3) / 3;
    }

    // Determinar estado (Aprobado si promedio >= 7.0)
    void determinarEstado() {
        estado = (promedio >= 7.0) ? "Aprobado" : "Reprobado";
    }

    // Mostrar información completa del estudiante
    void mostrarInfo() {
        cout << "Cedula: " << cedula << endl;
        cout << "Nombre: " << nombre << " " << apellido << endl;
        cout << "Notas: " << nota1 << ", " << nota2 << ", " << nota3 << endl;
        cout << "Promedio: " << promedio << endl;
        cout << "Estado: " << estado << endl;
        cout << "-----------------------------" << endl;
    }

    // Obtener estado (para contar aprobados/reprobados)
    string getEstado() {
        return estado;
    }
};

// -------------------------------
// Función principal
// -------------------------------
int main() {
    int cantidad = 5; // mínimo 5 estudiantes
    Estudiante estudiantes[5]; // arreglo de objetos Estudiante

    cout << "=== Registro de Estudiantes ===" << endl;

    // Registrar estudiantes con entrada del usuario
    for (int i = 0; i < cantidad; i++) {
        cout << "\nEstudiante " << (i + 1) << endl;
        estudiantes[i].registrarDatos();
    }

    int aprobados = 0, reprobados = 0;

    cout << "\n=== Listado de Estudiantes ===" << endl;
    // Mostrar información y contar aprobados/reprobados
    for (int i = 0; i < cantidad; i++) {
        estudiantes[i].mostrarInfo();
        if (estudiantes[i].getEstado() == "Aprobado") {
            aprobados++;
        } else {
            reprobados++;
        }
    }

    // Mostrar estadísticas finales
    cout << "Total Aprobados: " << aprobados << endl;
    cout << "Total Reprobados: " << reprobados << endl;

    return 0;
}
