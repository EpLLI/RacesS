package by.academy.it.pojos;

import javax.persistence.*;
@Entity
@Table(name = ("bets"))
public class Bets {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO )
    @Column(name="id")
	private int id;
	@Column(name="id_client")
	private int id_client;
	@Column(name="race")
	private String race;
	@Column(name="tupe_bets")
	private String tupe_bets;
	@Column(name="sum")
	private int sum;
	@Column(name="coeff")
	private double coeff;
	
	

	

	public Bets() {
	}

	@Override
	public String toString() {
		return "Bets [id=" + id + ", id_client=" + id_client + ", race=" + race + ", tupe_bets=" + tupe_bets + ", sum="
				+ sum + ", coeff=" + coeff + "]";
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getId_client() {
		return id_client;
	}

	public void setId_client(int id_client) {
		this.id_client = id_client;
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

	public int getSum() {
		return sum;
	}

	public void setSum(int sum) {
		this.sum = sum;
	}

}
