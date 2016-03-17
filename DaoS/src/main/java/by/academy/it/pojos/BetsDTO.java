package by.academy.it.pojos;

public class BetsDTO {
	private int id;
	private String race;
	private String tupe_bets;
	private double coeff;

	public BetsDTO() {
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getRace() {
		return race;
	}

	public void setRace(String race) {
		this.race = race;
	}

	public String getTupe_bets() {
		return tupe_bets;
	}

	public void setTupe_bets(String tupe_bets) {
		this.tupe_bets = tupe_bets;
	}

	public double getCoeff() {
		return coeff;
	}

	public void setCoeff(double coeff) {
		this.coeff = coeff;
	}
	
}
