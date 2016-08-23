package vol.model;

import java.io.Serializable;

import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

@Embeddable
public class EscaleId implements Serializable{
	private Vol vol;
	private Aeroport aeroport;
	
	
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((aeroport == null) ? 0 : aeroport.hashCode());
		result = prime * result + ((vol == null) ? 0 : vol.hashCode());
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
		EscaleId other = (EscaleId) obj;
		if (aeroport == null) {
			if (other.aeroport != null)
				return false;
		} else if (!aeroport.equals(other.aeroport))
			return false;
		if (vol == null) {
			if (other.vol != null)
				return false;
		} else if (!vol.equals(other.vol))
			return false;
		return true;
	}

	public EscaleId() {
		super();
	}
	
	public EscaleId(Vol vol, Aeroport aeroport) {
		super();
		this.vol = vol;
		this.aeroport = aeroport;
	}
	
	@ManyToOne
	@JoinColumn(name="vol_id")
	public Vol getVol() {
		return vol;
	}
	public void setVol(Vol vol) {
		this.vol = vol;
	}
	@ManyToOne
	@JoinColumn(name="aeroport_id")
	public Aeroport getAeroport() {
		return aeroport;
	}
	public void setAeroport(Aeroport aeroport) {
		this.aeroport = aeroport;
	}
	
	

}
