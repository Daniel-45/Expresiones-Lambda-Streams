package alumnos;

/* Dadas las clases Alumno y CrearLista, realizar un programa que realice las siguientes opciones:
 * 
 * 1. Listar todos los alumnos
 * 
 * 2. Mostrar ordenada la lista de alumnos por:
 * - Nombre
 * - Apellidos
 * - Apellidos y nombre
 * - Apellidos y nombre ascendente (z-a)
 * - Edad de menor a mayor
 * - Edad de mayor a menor
 * - Edad y apellidos
 * - Nota de menor a mayor
 * - Nota de mayor a menor
 * - Curso y nota
 * 
 * 3. Mostrar la lista de cursos, a continuacion seleccionar un curso y mostrar el nombre, 
 * apellidos y nota de los alumnos que han aprobado el curso.
 * 
 * 4. Mostrar el alumno mas joven y el alumno con mayor edad. 
 * 
 * 5. Mostrar número de alumnos
 * 
 * 6. Limitar la lista a 10 alumnos
 */

public class MainAlumno {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Metodos m = new Metodos();

		// Listar todos los alumnos
		m.listadoAlumnos();

		// Listar ordenados por nombre
		m.ordenarPorNombre();

		// Listar ordenados por apellidos
		m.ordenarPorApellidos();

		// Listar ordenados por apellidos y por nombre
		m.ordenarPorApellidoYNombre();

		// Listar ordenados por apellidos y nombre (ascendente)
		m.ordenarPorApellidosYNombreAscendente();

		// Listar ordenados por edad de menor a mayor
		m.ordenarPorEdadMenorMayor();

		// Listar ordenados por edad de mayor a menor
		m.ordenarPorEdadMayorMenor();

		// Listar ordenados por edad de menor a mayor y apellidos
		m.ordenarPorEdadYApellidos();

		// Listar ordenados por nota de menor a mayor y apellidos
		m.ordenarPorNotaYApellidosMenorAMayor();

		// Listar por nota de mayor a menor y apellidos
		m.ordenarPorNotaYApellidosMayorMenor();

		// Listar ordenados por curso y nota
		m.ordenarPorCursoYNota();

		// Listar cursos disponibles y alumnos aprobados
		m.listarAprobados();

		// Alumno de menor edad
		m.alumnoMenorEdad();

		// Alumno mayor edad
		m.alumnoMayorEdad();

		// Número de alumnos
		m.contarAlumnos();

		// Lista de alumnos limitada a 10 elementos
		m.listaReducida();
	}

}
