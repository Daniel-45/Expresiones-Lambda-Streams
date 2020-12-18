package subastas;

import java.util.ArrayList;
import java.util.List;

public class Subasta {

	// Atributos
	private String nombreProducto;
	private Usuario propietario;
	private boolean abierta;
	private List<Puja> pujas;
	private float pujaMayor;

	// Constructor
	public Subasta(String nombreProducto, Usuario propietario) {
		this.nombreProducto = nombreProducto;
		this.propietario = propietario;
		this.abierta = true;
		this.pujas = new ArrayList<>();
		this.pujaMayor = 0;
	}

	// Getters
	public String getNombreProducto() {
		return nombreProducto;
	}

	public Usuario getPropietario() {
		return propietario;
	}

	public boolean isAbierta() {
		return abierta;
	}

	public List<Puja> getPujas() {
		return new ArrayList<Puja>();
	}

	public float getPujaMayor() {

		pujaMayor = 0;

		if (!pujas.isEmpty()) {

			pujaMayor = pujas.get(0).getCantidad();

			for (Puja p : pujas) {

				if (p.getCantidad() > pujaMayor) {

					pujaMayor = p.getCantidad();
				}
			}
		}
		return pujaMayor;
	}

	/*
	 * La puja es aceptada si: 
	 * 1. La subasta está abierta. 
	 * 2. El crédito del usuario que la realiza es suficiente para la cantidad por la que puja.
	 * 3. El usuario no es propietario de la subasta y la cantidad es mayor que la cantidad de la puja mayor, si la hubiera. 
	 * Si la puja es aceptada, entonces se construye una puja  y se almacena en la lista de pujas. 
	 * Por último, esta operación finaliza indicando si la puja ha sido aceptada (retorna un valor booleano).
	 */

	public boolean pujaAceptada(Usuario pujador, float cantidad) {

		boolean exito = false;

		if (cantidad < 1) {

			throw new IllegalArgumentException("\nLa cantidad de la puja tiene que ser mayor que cero.");
		}

		if (isAbierta() && pujador.getCredito() >= cantidad && pujador != propietario && cantidad > getPujaMayor()) {

			Puja puja = new Puja(pujador, cantidad, this);

			pujas.add(puja);

			exito = true;
		}

		return exito;
	}

	/*
	 * Pujar: versión sobrecargada del método anterior que permite pujar sin indicar la cantidad. 
	 * Es decir, sólo se tiene como parámetro el usuario que la realiza.
	 * La cantidad será un euro más que la cantidad de la puja mayor. 
	 * Si no hubiera puja mayor, la cantidad sería de un euro.
	 */

	public float pujar(Usuario pujador) {

		float cantidad = 1;

		if (getPujaMayor() > 1) {

			cantidad += getPujaMayor();

		}
		pujaAceptada(pujador, cantidad);
		return cantidad;
	}

	/*
	 * Ejecutar:
	 * Este método cierra la subasta realizando las transferencias de crédito entre el usuario que ha ganado la subasta  y el usuario propietario. 
	 * Esta operación no tiene parámetros. 
	 * Una subasta se puede ejecutar si se cumplen las siguientes condiciones: 
	 * 1. Existe alguna puja o la subasta está abierta. 
	 * 2. La ejecución de una subasta consiste en: 
	 * Decrementar el crédito del usuario que ha realizado la puja mayor e incrementar el crédito del propietario de la subasta por la cantidad de la puja mayor. 
	 * Establecer a falso el valor de la propiedad abierta. 
	 * El método finaliza informando si la subasta ha podido ejecutarse o no (retorna un valor booleano)
	 */

	public boolean ejecutar() {

		if (isAbierta() && getPujaMayor() > 0) {

			Usuario ganador = Puja.getPujador();

			float cantidad = getPujaMayor();

			propietario.incrementarCredito(cantidad);

			ganador.decrementarCredito(cantidad);

			abierta = false;

			return true;

		} else {

			return false;
		}
	}

	@Override
	public String toString() {
		return "\nSubasta [Producto = " + nombreProducto + ", Propietario = " + propietario + ", Abierta = " + abierta
				+ ", Pujas realizadas = " + pujas.size() + ", Puja mayor = " + pujaMayor + "]";
	}

}
