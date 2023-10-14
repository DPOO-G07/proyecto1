package logica;

public class Categoria {
	public double iddeCategoria;
	public double tarifaporDia;
	public String temporada;
	public Categoria(double iddeCategoria, double tarifaporDia, String temporada) {
		super();
		this.iddeCategoria = iddeCategoria;
		this.tarifaporDia = tarifaporDia;
		this.temporada = temporada;
	}
	public double getIddeCategoria() {
		return iddeCategoria;
	}
	public double getTarifaporDia() {
		return tarifaporDia;
	}
	public String getTemporada() {
		return temporada;
	}

}
