package vol.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Version;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.annotation.JsonNaming;

@Entity

public class CompagnieAerienne {
	
	private Integer id;
	private int version;
	private String nom;
	private List<CompagnieAerienneVol> compagnieAerienneVol = new ArrayList<CompagnieAerienneVol>();
	
	@Id
	@GeneratedValue
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@Version
	public int getVersion() { 
		return version;
	}

	public void setVersion(int version) {
		this.version = version;
	}

	@Column(length = 100)
	//@Size(min=4, max=100, message="{compagnieAerienne.nom.error.size}")
	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}
	
	@JsonIgnore
	@OneToMany(mappedBy="compagnieAerienne")
	public List<CompagnieAerienneVol> getCompagnieAerienneVol() {
		return compagnieAerienneVol;
	}

	public void setCompagnieAerienneVol(List<CompagnieAerienneVol> compagnieAerienneVol) {
		this.compagnieAerienneVol = compagnieAerienneVol;
	}

	@Override
	public String toString() {
		return "CompagnieAerienne [id=" + id + ", nom=" + nom + "]";
	}

}
