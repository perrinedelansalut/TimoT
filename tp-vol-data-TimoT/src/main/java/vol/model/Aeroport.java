package vol.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Version;
import javax.validation.constraints.Size;

@Entity
public class Aeroport {

	private Integer idAer;
	private int version;
	private String nom;
	// private List<Ville> villes = new ArrayList<Ville>();
	private List<Vol> VolArrivee = new ArrayList<Vol>();
	private List<Vol> VolDepart = new ArrayList<Vol>();
	private List<AeroportVille> AeroportVille = new ArrayList<AeroportVille>();
	private List<Escale> Escales = new ArrayList<Escale>();

	public Aeroport() {

	}

	@OneToMany(mappedBy = "id.aeroport")
	public List<Escale> getEscales() {
		return Escales;
	}

	public void setEscales(List<Escale> escales) {
		Escales = escales;
	}

	public Aeroport(Integer idAer) {
		this.idAer = idAer;
	}

	public Aeroport(Integer idAer, String nom) {
		this.nom = nom;
		this.idAer = idAer;
	}

	// public void ajouterVille(Ville ville) {
	// this.villes.add(ville); // ajout d'une ville déjà existante
	// }

	@Id
	@GeneratedValue
	@Column(length = 100)
	public Integer getIdAer() {
		return idAer;
	}

	@Column(length = 100)
	@Size(min=4, max=500, message="{aeroportEdit.nom.error.size}")
	public String getNom() {
		return nom;
	}

	public void setIdAer(Integer idAer) {
		this.idAer = idAer;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	// public List<Ville> getVilles() {
	// return villes;
	// }

	// public void setVilles(List<Ville> villes) {
	// this.villes = villes;
	// }

	@OneToMany(mappedBy = "aeroportArrivee")
	public List<Vol> getVolArrivee() {
		return VolArrivee;
	}

	@Version
	public int getVersion() {
		return version;
	}

	public void setVersion(int version) {
		this.version = version;
	}

	public void setVolArrivee(List<Vol> volArrivee) {
		VolArrivee = volArrivee;
	}

	@OneToMany(mappedBy = "aeroportDepart")
	public List<Vol> getVolDepart() {
		return VolDepart;
	}

	public void setVolDepart(List<Vol> volDepart) {
		VolDepart = volDepart;
	}

	@OneToMany(mappedBy = "aeroport")
	public List<AeroportVille> getAeroportVille() {
		return AeroportVille;
	}

	public void setAeroportVille(List<AeroportVille> aeroportVille) {
		AeroportVille = aeroportVille;
	}

	@Override
	public String toString() {
		return "Aeroport [idAer=" + idAer + ", nom=" + nom + "]";
	}

}
