/**
 * 
 */
package vol.model;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.Size;

@Embeddable
public class Adresse {

	private String adresse;
	private String codePostal;
	private String ville;
	private String pays;

	public Adresse() {
		// TODO Auto-generated constructor stub
	}

	public Adresse(String adresse, String codePostal, String ville, String pays) {
		super();
		this.adresse = adresse;
		this.codePostal = codePostal;
		this.ville = ville;
		this.pays = pays;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((adresse == null) ? 0 : adresse.hashCode());
		result = prime * result + ((codePostal == null) ? 0 : codePostal.hashCode());
		result = prime * result + ((pays == null) ? 0 : pays.hashCode());
		result = prime * result + ((ville == null) ? 0 : ville.hashCode());
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
		Adresse other = (Adresse) obj;
		if (adresse == null) {
			if (other.adresse != null)
				return false;
		} else if (!adresse.equals(other.adresse))
			return false;
		if (codePostal == null) {
			if (other.codePostal != null)
				return false;
		} else if (!codePostal.equals(other.codePostal))
			return false;
		if (pays == null) {
			if (other.pays != null)
				return false;
		} else if (!pays.equals(other.pays))
			return false;
		if (ville == null) {
			if (other.ville != null)
				return false;
		} else if (!ville.equals(other.ville))
			return false;
		return true;
	}

	@Column(length = 200)
	@Size(min=1, max=100, message="{adresse.adresse.error.size}")
	public String getAdresse() {
		return adresse;
	}

	@Column(length = 10)
	@Size(min=1, max=10, message="{adresse.codePostal.error.size}")
	public String getCodePostal() {
		return codePostal;
	}

	@Column(length = 200)
	@Size(min=1, max=200, message="{adresse.pays.error.size}")
	public String getPays() {
		return pays;
	}

	@Column(length = 200)
	@Size(min=1, max=200, message="{adresse.ville.error.size}")
	public String getVille() {
		return ville;
	}

	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}

	public void setCodePostal(String codePostal) {
		this.codePostal = codePostal;
	}

	public void setPays(String pays) {
		this.pays = pays;
	}

	public void setVille(String ville) {
		this.ville = ville;
	}

	@Override
	public String toString() {
		return "Adresse [adresse=" + adresse + ", codePostal=" + codePostal + ", ville=" + ville + ", pays=" + pays
				+ "]";
	}

}
