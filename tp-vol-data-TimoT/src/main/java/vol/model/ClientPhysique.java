package vol.model;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

import org.hibernate.validator.constraints.Length;

@Entity @DiscriminatorValue("Physique")
public class ClientPhysique  extends Client{
	private String prenom;

	@Length(min=1, message="{client.error.nom.size}")
	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	
	

}
