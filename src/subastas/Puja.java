package subastas;

public class Puja {

	private static Usuario pujador;
	private float cantidad;
	private Subasta subasta;

	@SuppressWarnings("static-access")
	public Puja(Usuario pujador, float cantidad, Subasta subasta) {
		this.pujador = pujador;
		this.cantidad = cantidad;
		this.subasta = subasta;
	}

	public static Usuario getPujador() {
		return pujador;
	}

	public float getCantidad() {
		return cantidad;
	}

	public Subasta getSubasta() {
		return subasta;
	}

	@Override
	public String toString() {
		return "Puja [Pujador = " + pujador + ", Cantidad = " + cantidad + ", Subasta = " + subasta + "]";
	}

}
