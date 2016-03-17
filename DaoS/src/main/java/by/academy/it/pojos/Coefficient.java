package by.academy.it.pojos;

import java.io.Serializable;

import javax.persistence.*;

@Entity
@Table(name="Coefficient")
public class Coefficient implements Serializable{
	private static final long serialVersionUID = 4L;
    @Id
    @GeneratedValue
    @Column(name="id")
	private int id;
 
	@Override
	public String toString() {
		return "Coefficient [id=" + id + ", id_bets=" + id_bets + ", coeff=" + coeff + ", race=" + race + "]";
	}

	//private int id_race;
    @Column(name="id_bets")
	private int id_bets;
    @Column(name="Coeff")
	private double coeff;
	@ManyToOne
    @JoinColumn(name="id_race")
	private Race race;
	
	public Coefficient() {
	}
	public Coefficient( int id_bets, double coeff ) {
		this.id_bets = id_bets;
		this.coeff = coeff;		
	}
	public Race getRace() {
		return race;
	}

	public void setRace(Race race) {
		this.race = race;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	
	public int getId_bets() {
		return id_bets;
	}

	public void setId_bets(int id_bets) {
		this.id_bets = id_bets;
	}
	public double getCoeff() {
		return coeff;
	}

	public void setCoeff(double coeff) {
		this.coeff = coeff;
	}
}
