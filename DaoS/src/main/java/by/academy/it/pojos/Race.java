package by.academy.it.pojos;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.*;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;



@Entity
@Table(name = "Race")
public class Race implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO )
    @Column(name="id_race")
	private int id_race;
	@Pattern(regexp = "[a-z]{1,50}", message = "not correctly entered data")
	@Size(min = 2, max = 200,message="Title must be between 2 and 200 characters long.")
	@Column(name = "race" ,nullable = false)
	private String race;
	@Column(name = "result")
	private String result;
	 @OneToMany(mappedBy="race", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private Set<Coefficient> Coefficient;

	
	@Override
	public String toString() {
		return "" + id_race ;
	}

	public Set<Coefficient> getCoefficient() {
		return Coefficient;
	}

	public void setCoefficient(Set<Coefficient> coefficient) {
		Coefficient = coefficient;
	}

	public Race() {
	}
/*
	public Race(String race, String result) {
		this.race = race;
		this.result = result;

	}*/

	public int getId_race() {
		return id_race;
	}

	public void setId_race(int id_race) {
		this.id_race = id_race;
	}

	

	public String getRace() {
		return race;
	}

	public void setRace(String race) {
		this.race = race;
	}

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id_race;
		result = prime * result + ((race == null) ? 0 : race.hashCode());
		result = prime * result + ((this.result == null) ? 0 : this.result.hashCode());
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
		Race other = (Race) obj;
		if (id_race != other.id_race)
			return false;
		if (race == null) {
			if (other.race != null)
				return false;
		} else if (!race.equals(other.race))
			return false;
		if (result == null) {
			if (other.result != null)
				return false;
		} else if (!result.equals(other.result))
			return false;
		return true;
	}

}
