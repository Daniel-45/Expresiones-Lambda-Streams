package subastas;

public class Usuario {

	private final String nombre;
	private String email;
	private float credito;
	private final float CREDITO_POR_DEFECTO = 50;

	public Usuario(String nombre, float credito, String email) {
		this.nombre = nombre;
		this.credito = credito;
		this.email = email;
	}

	public Usuario(String nombre) {
		this.nombre = nombre;
		this.email = "";
		this.credito = CREDITO_POR_DEFECTO;
	}

	public String getNombre() {
		return nombre;
	}

	public String getEmail() {
		return email;
	}

	public double getCredito() {
		return credito;
	}

	public float incrementarCredito(float cantidad) {

		credito += cantidad;

		return credito;

	}

	public float decrementarCredito(float cantidad) {

		credito -= cantidad;

		return credito;
	}

	@Override
	public String toString() {
		return "Usuario [Nombre = " + nombre + ", Email = " + email + ", Credito = " + credito + "]";
	}

}
