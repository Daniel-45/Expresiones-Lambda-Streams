package subastas;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class MainSubasta {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Usuario u1 = new Usuario("Juan", 100, "juan@gmail.com");

		Usuario u2 = new Usuario("Pedro", 150, "pedro@yahoo.com");

		Usuario u3 = new Usuario("Enrique", 300, "enrique@hotmail.com");

		Set<Usuario> usuarios = new HashSet<>();

		usuarios.add(u1);
		usuarios.add(u2);
		usuarios.add(u3);

		System.out.println("\nSUBASTA NUMERO 1");
		System.out.println("----------------");

		// Crea una subasta del producto "Teléfono Móvil" cuyo propietario sea el usuario Juan.
		Subasta subasta1 = new Subasta("Teléfono Móvil", u1);

		// El usuario Pedro puja por esa subasta 100 euros.
		subasta1.pujaAceptada(u2, 100);

		// Muestra en la consola la puja mayor de la subasta (nombre del usuario y cantidad).
		System.out.println(
				"\nEl usuario " + u2.getNombre() + " puja con la cantidad " + subasta1.getPujaMayor() + " euros");

		// El usuario Enrique puja por esa subasta 50 euros.
		subasta1.pujaAceptada(u3, 50);

		System.out.println("\nLa mayor puja de la subasta es: " + subasta1.getPujaMayor() + " euros");

		// Ejecutar la subasta número 1.
		subasta1.ejecutar();

		System.out.println(subasta1.toString());

		// Comprobar crédito usuarios
		for (Usuario usuario : usuarios) {

			System.out.println("\nUsuario: " + usuario.getNombre() + " - Crédito: " + usuario.getCredito() + " euros");
		}

		System.out.println("\nSUBASTA NUMERO 2");
		System.out.println("----------------");

		Subasta subasta2 = new Subasta("Telefono Fijo", u2);

		subasta2.pujaAceptada(u1, 30);

		System.out.println(
				"\nEl usuario " + u1.getNombre() + " puja con la cantidad " + subasta2.getPujaMayor() + " euros");

		System.out.println("\nLa mayor puja de la subasta es: " + subasta2.getPujaMayor() + " euros");

		subasta2.pujar(u3);

		// Ejecutar la subasta número 2
		subasta2.ejecutar();

		System.out.println(subasta2.toString());

		// Comprobar crédito usuarios
		for (Usuario usuario : usuarios) {

			System.out.println("\nUsuario: " + usuario.getNombre() + " - Crédito: " + usuario.getCredito() + " euros");
		}

		// Muestra las subastas de las que son propietarios los tres usuarios.
		List<Subasta> subastas = new ArrayList<>();

		subastas.add(subasta1);
		subastas.add(subasta2);

		System.out.println("\nDATOS DE LAS SUBASTAS");
		System.out.println("---------------------");

		for (Subasta subasta : subastas) {

			System.out.println(subasta.toString());
		}

		// 1. Cuenta los usuarios que tienen cuenta de correo en Gmail. Muestra el resultado en la consola.
		System.out.println("\nUSUARIOS QUE TIENEN CUENTA DE CORREO GMAIL");
		System.out.println("--------------------------------------------");
		usuarios.stream().filter(u -> u.getEmail().contains("gmail")).forEach(usuario -> System.out.println(usuario));

		System.out.println("\nLa cantidad de usuarios con cuenta de correo gmail es: "
				+ usuarios.stream().filter(u -> u.getEmail().contains("gmail")).count());

		// 2. Mostrar por la consola los nombres de usuarios que sean propietarios de subastas ordenados por orden alfabético inverso.
		System.out.println("\nUSUARIOS PROPIETARIOS DE UNA SUBASTA ORDENADOS INVERSO");
		System.out.println("--------------------------------------------------------");

		Comparator<Usuario> porNombre = (Usuario usuario1, Usuario usuario2) -> usuario1.getNombre()
				.compareTo(usuario2.getNombre());

		subastas.stream().map(u -> u.getPropietario()).sorted(porNombre.reversed()).forEach(System.out::println);

		// 3. Mostrar por la consola los nombres de los productos cuyas subastas hayan recibido alguna puja ordenados alfabéticamente.
		System.out.println("\nNOMBRES PRODUCTOS CUYAS SUBASTAS HAN RECIBIDO ALGUNA PUJA ORDENADOS ALFABETICAMENTE");
		System.out.println("-------------------------------------------------------------------------------------");
		subastas.stream().filter(p -> p.getPujaMayor() > 0)
				.forEach(producto -> System.out.println("\n" + producto.getNombreProducto()));

		// 4. Mostrar por la consola el nombre de los productos de aquellas subastas que hayan recibido pujas superiores a 50 euros.
		System.out.println("\nNOMBRES PRODUCTOS CUYAS SUBASTAS HAN RECIBIDO ALGUNA PUJA SUPERIOR A 50 EUROS");
		System.out.println("-------------------------------------------------------------------------------");
		subastas.stream().filter(p -> p.getPujaMayor() > 50)
				.forEach(producto -> System.out.println("\n" + producto.getNombreProducto()));
	}

}
