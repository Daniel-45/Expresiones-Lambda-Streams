package alumnos;

public class Alumno {

	private int id;
	private String dni;
	private String nombre;
	private String apellidos;
	private int edad;
	private String curso;
	private double nota;

	public Alumno() {
	}

	public Alumno(String dni) {
		this.dni = dni;
	}

	public Alumno(int id, String dni, String nombre, String apellidos, int edad, String curso, double nota) {
		this.id = id;
		this.dni = dni;
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.edad = edad;
		this.curso = curso;
		this.nota = nota;
	}

	public int getId() {
		return id;
	}

	public String getDni() {
		return dni;
	}

	public String getNombre() {
		return nombre;
	}

	public String getApellidos() {
		return apellidos;
	}

	public int getEdad() {
		return edad;
	}

	public String getCurso() {
		return curso;
	}

	public double getNota() {
		return nota;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public void setEdad(int edad) {
		this.edad = edad;
	}

	public void setCurso(String curso) {
		this.curso = curso;
	}

	public void setNota(double nota) {
		this.nota = nota;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((dni == null) ? 0 : dni.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Alumno other = (Alumno) obj;
		if (dni == null) {
			if (other.dni != null)
				return false;
		} else if (!dni.equals(other.dni))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Alumno [ID = " + id + ", DNI = " + dni + ", Nombre = " + nombre + ", Apellidos = " + apellidos
				+ ", Edad = " + edad + ", Curso = " + curso + ", Nota = " + nota + "]";
	}

}
