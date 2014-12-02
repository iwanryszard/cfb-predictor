package svm.predictor.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="calculated_distance")
public class CalculatedDistance implements BaseEntity<Integer> {

	private Integer id;
	private Integer fromTeamId;
	private Integer toTeamId;
	private Integer distanceKm;
	
	@Id
	@Column(name="id")
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Override
	public Integer getId() {
		return id;
	}

	@Override
	public void setId(Integer id) {
		this.id = id;
	}

	@Column(name="from_team_id")
	public Integer getFromTeamId() {
		return fromTeamId;
	}

	public void setFromTeamId(Integer fromTeamId) {
		this.fromTeamId = fromTeamId;
	}

	@Column(name="to_team_id")
	public Integer getToTeamId() {
		return toTeamId;
	}

	public void setToTeamId(Integer toTeamId) {
		this.toTeamId = toTeamId;
	}

	@Column(name="distance_km")
	public Integer getDistanceKm() {
		return distanceKm;
	}

	public void setDistanceKm(Integer distanceKm) {
		this.distanceKm = distanceKm;
	}

}
