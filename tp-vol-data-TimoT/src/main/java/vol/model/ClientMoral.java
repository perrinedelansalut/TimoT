package vol.model;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity @DiscriminatorValue("Moral")
public class ClientMoral extends Client{
	private Integer siret;

	public Integer getSiret() {
		return siret;
	}

	public void setSiret(Integer siret) {
		this.siret = siret;
	}
	

}
