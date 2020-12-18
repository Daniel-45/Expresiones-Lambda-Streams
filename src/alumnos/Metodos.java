package alumnos;

import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class Metodos {

	// Comparador por apellidos
	Comparator<Alumno> porApellidos = (Alumno a1, Alumno a2) -> a1.getApellidos().compareTo(a2.getApellidos());

	// Compardor por nombre
	Comparator<Alumno> porNombre = (Alumno a1, Alumno a2) -> a1.getNombre().compareTo(a2.getNombre());

	// Comparador por edad
	Comparator<Alumno> porEdad = (Alumno a1, Alumno a2) -> a1.getEdad() - a2.getEdad();

	// Comparador por nota
	Comparator<Alumno> porNota = (Alumno a1, Alumno a2) -> Double.compare(a1.getNota(), a2.getNota());

	// Comparador por curso
	Comparator<Alumno> porCurso = (Alumno a1, Alumno a2) -> a1.getCurso().compareTo(a2.getCurso());

	// Coleccion de tipo List
	List<Alumno> lista = CrearLista.crearLista();

	// Listar todos los alumnos
	public void listadoAlumnos() {
		System.out.println("LISTADO DE ALUMNOS");
		System.out.println("------------------");
		lista.stream().forEach(a -> System.out.println(a));
		System.out.println();
	}

	// Ordenar por nombre
	public void ordenarPorNombre() {
		System.out.println("LISTADO DE ALUMNOS ORDENADOS POR NOMBRE");
		System.out.println("---------------------------------------");
		lista.sort(porNombre);
		lista.forEach(System.out::println);
		System.out.println();
	}

	// Ordenar por apellidos
	public void ordenarPorApellidos() {
		System.out.println("LISTADO DE ALUMNOS ORDENADOS POR APELLIDOS");
		System.out.println("------------------------------------------");
		lista.sort(porApellidos);
		lista.forEach(System.out::println);
		System.out.println();
	}

	// Ordenar por apellidos y por nombre
	public void ordenarPorApellidoYNombre() {
		System.out.println("LISTADO DE ALUMNOS ORDENADOS POR APELLIDOS Y NOMBRE");
		System.out.println("---------------------------------------------------");
		lista.sort(porApellidos.thenComparing(porNombre));
		lista.forEach(System.out::println);
		System.out.println();
	}

	// Ordenar por apellidos y por nombre al revés
	public void ordenarPorApellidosYNombreAscendente() {
		System.out.println("LISTA ORDENADA DE ALUMNOS POR APELLIDOS Y NOMBRE DESCENDENTE (Z - A)");
		System.out.println("--------------------------------------------------------------------");
		lista.sort(porApellidos.thenComparing(porNombre).reversed());
		lista.forEach(System.out::println);
		System.out.println();
	}

	// Ordenar por edad de menor a mayor
	public void ordenarPorEdadMenorMayor() {
		System.out.println("LISTADO DE ALUMNOS ORDENADOS POR EDAD DE MENOR A MAYOR");
		System.out.println("------------------------------------------------------");
		lista.sort(porEdad);
		lista.forEach(System.out::println);
		System.out.println();
	}

	// Ordenar por edad de mayor a menor
	public void ordenarPorEdadMayorMenor() {
		System.out.println("LISTADO DE ALUMNOS ORDENADOS POR EDAD DE MAYOR A MENOR");
		System.out.println("------------------------------------------------------");
		lista.sort(porEdad.reversed());
		lista.forEach(System.out::println);
		System.out.println();
	}

	// Ordenar por edad y apellidos
	public void ordenarPorEdadYApellidos() {
		System.out.println("LISTADO DE ALUMNOS ORDENADOS POR EDAD Y APELLIDOS");
		System.out.println("-------------------------------------------------");
		lista.sort(porEdad.thenComparing(porApellidos));
		lista.forEach(System.out::println);
		System.out.println();
	}

	// Ordenar por nota de menor a mayor
	public void ordenarPorNotaYApellidosMenorAMayor() {
		System.out.println("LISTADO DE ALUMNOS ORDENADOS POR NOTA DE MENOR A MAYOR Y APELLIDOS");
		System.out.println("------------------------------------------------------------------");
		lista.sort(porNota.thenComparing(porApellidos));
		lista.forEach(System.out::println);
		System.out.println();
	}

	// Ordenar por nota de mayor a menor
	public void ordenarPorNotaYApellidosMayorMenor() {
		System.out.println("LISTADO DE ALUMNOS ORDENADOS POR NOTA DE MAYOR A MENOR Y APELLIDOS");
		System.out.println("------------------------------------------------------------------");
		lista.sort(porNota.reversed().thenComparing(porApellidos));
		lista.forEach(System.out::println);
		System.out.println();
	}

	// Ordenar por curso y nota
	public void ordenarPorCursoYNota() {
		System.out.println("LISTA ORDENADA DE ALUMNOS POR CURSO Y NOTA");
		System.out.println("------------------------------------------");
		lista.sort(porCurso.thenComparing(porNota));
		lista.forEach(System.out::println);
		System.out.println();
	}

	/*
	 * Mostrar la lista de cursos, a continuacion seleccionar un curso y mostrar el
	 * nombre, apellidos y nota de los alumnos que han aprobado el curso.
	 */
	@SuppressWarnings("resource")
	public List<Alumno> listarAprobados() {

		Scanner sc = new Scanner(System.in);

		System.out.println("LISTA DE CURSOS DISPONIBLES");
		System.out.println("---------------------------");

		Set<String> cursos = new HashSet<>();
		lista.forEach((Alumno a) -> cursos.add(a.getCurso()));
		cursos.forEach(System.out::println);

		String curso;

		System.out.println();

		// Validar
		do {
			System.out.print("Introduce el nombre de un curso: ");
			curso = sc.nextLine();
		} while (!cursos.contains(curso));

		String micurso = curso; // para usar el parámetro en la expresión lambda

		// Filtrar por curso
		List<Alumno> copia = CrearLista.crearLista();

		System.out.println("\nLISTA ORDENADA DE ALUMNOS POR NOMBRE Y APELLIDOS QUE HAN APROBADO EL CURSO");
		System.out.println("----------------------------------------------------------------------------");

		System.out.println("\nALUMNOS APROBADOS DEL CURSO: " + curso + "\n");

		copia.stream().filter(a -> a.getNota() >= 5 && a.getCurso().equals(micurso))
				.forEach(aprobados -> System.out.println(aprobados));

		return copia;

	}

	// Alumno de menor edad
	public void alumnoMenorEdad() {
		System.out.println("\nALUMNO DE MENOR EDAD");
		System.out.println("----------------------");
		lista.sort(porEdad);
		System.out.println(lista.get(0).toString());
	}

	// Alumno mayor edad
	public void alumnoMayorEdad() {
		System.out.println("\nALUMNO DE MAYOR EDAD");
		System.out.println("----------------------");
		lista.sort(porEdad.reversed());
		System.out.println(lista.get(0).toString());
	}

	// Mostrar el número de alumnos
	public void contarAlumnos() {
		System.out.println("\nNÚMERO DE ALUMNOS");
		System.out.println("-------------------");
		System.out.println("El número total de alumnos es: " + lista.stream().count());
	}

	// Limitar la lista de alunmos a mostrar a 10
	public void listaReducida() {
		System.out.println("\nLISTA DE ALUMNOS REDUCIDA");
		System.out.println("---------------------------");
		lista.stream().sorted(porNombre).limit(10).forEach(a -> System.out.println(a));
	}

}
