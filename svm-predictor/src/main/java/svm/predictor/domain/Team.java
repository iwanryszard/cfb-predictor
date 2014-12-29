package svm.predictor.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.Table;

import svm.predictor.dto.League;

@Entity
@Table(name="team")
public class Team implements BaseEntity<Integer> {

	private Integer id;
	private String name;
	private String stadiumLocation;
	private League league;
	
	@Override
	@Id
	@Column(name="id")
	public Integer getId() {
		return id;
	}

	@Override
	public void setId(Integer id) {
		this.id = id;
	}

	@Column(name="name")
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Column(name="stadium_location")
	public String getStadiumLocation() {
		return stadiumLocation;
	}

	public void setStadiumLocation(String stadiumLocation) {
		this.stadiumLocation = stadiumLocation;
	}

	@Column(name="league")
	@Enumerated(EnumType.ORDINAL)
	public League getLeague() {
		return league;
	}

	public void setLeague(League league) {
		this.league = league;
	}

}
