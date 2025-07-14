
public class Alumnos {
	private String matricula;
	private String nombre;
	private long numcel;
	private String genero;
	public Alumnos(String matricula, String nombre, long numcel, String genero) {
		this.matricula = matricula;
		this.nombre = nombre;
		this.numcel = numcel;
		this.genero = genero;
	}
	@Override
	public String toString() {
		return "Alumnos [matricula=" + matricula + ", nombre=" + nombre + ", numcel=" + numcel + ", genero=" + genero
				+ "]\n";
	}
	public String getMatricula() {
		return matricula;
	}
	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public long getNumcel() {
		return numcel;
	}
	public void setNumcel(long numcel) {
		this.numcel = numcel;
	}
	public String getGenero() {
		return genero;
	}
	public void setGenero(String genero) {
		this.genero = genero;
	}
	
}
