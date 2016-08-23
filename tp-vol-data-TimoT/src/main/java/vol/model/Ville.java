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

@Entity
public class Ville {
	
	private Integer idVil;
	private String nom;
	private List<AeroportVille> AeroportVille = new ArrayList<AeroportVille>();
//	private int version;
	public Ville(){
		
	}
//	@Version
//	public int getVersion() {
//		return version;
//	}
//
//	public void setVersion(int version) {
//		this.version = version;
//	}

	public Ville(Integer idVil, String nom) {
		this.idVil = idVil;
		this.nom = nom;
		}

	@Id
	@GeneratedValue
	public Integer getIdVil() {
		return idVil;
	}

	public void setIdVil(Integer idVil) {
		this.idVil = idVil;
	}

	@Column(length = 100)
	@Size(min=4, max=100, message="{ville.nom.error.size}")
	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}
	
	@OneToMany(mappedBy = "ville")
	public List<AeroportVille> getAeroportVille() {
		return AeroportVille;
	}

	public void setAeroportVille(List<AeroportVille> aeroportVille) {
		AeroportVille = aeroportVille;
	}

	public String toString() {
		String reponse="La Ville : "+this.nom;
				
		return reponse;
}

}
