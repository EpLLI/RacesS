package by.academy.it.pojos;

import javax.persistence.*;
import javax.persistence.Table;

import org.hibernate.annotations.Cache;


@Entity
//@Cache( region = "by.academy.it.Tupebets",usage = CacheConcurrencyStrategy.READ_WRITE)
@Table(name = ("Tupebets"))


public class Tupebets {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO )
    @Column(name="id_bets")
	private int id_bets;
	 @Column(name="tupe_bets")
	private String tupe_bets;

	public Tupebets() {
	}

	public int getId_bets() {
		return id_bets;
	}

	public void setId_bets(int id_bets) {
		this.id_bets = id_bets;
	}

	public String getTupe_bets() {
		return tupe_bets;
	}

	public void setTupe_bets(String tupe_bets) {
		this.tupe_bets = tupe_bets;
	}
}
