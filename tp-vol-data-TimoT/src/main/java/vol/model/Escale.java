/**
 * 
 */
package vol.model;

import java.sql.Time;
import java.util.Date;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;

/**
 * @author ajc
 *
 */
@Entity
public class Escale {

	private int Version;
	private Date dateDepart;
	private Date dateArrivee;
	private Time heureDepart;
	private Time heureArrivee;
	private EscaleId id;

	public Escale() {

		this.dateDepart = null;
		this.dateArrivee = null;
		this.heureDepart = null;
		this.heureArrivee = null;

	}
	
	
	public Date getDateArrivee() {
		return dateArrivee;
	}



	public Date getDateDepart() {
		return dateDepart;
	}



	public Time getHeureArrivee() {
		return heureArrivee;
	}

	public Time getHeureDepart() {
		return heureDepart;
	}

	@EmbeddedId
	public EscaleId getId() {
		return id;
	}

	public int getVersion() {
		return Version;
	}

	public void setDateArrivee(Date dateArrivee) {
		this.dateArrivee = dateArrivee;
	}

	public void setDateDepart(Date dateDepart) {
		this.dateDepart = dateDepart;
	}

	public void setHeureArrivee(Time heureArrivee) {
		this.heureArrivee = heureArrivee;
	}

	public void setHeureDepart(Time heureDepart) {
		this.heureDepart = heureDepart;
	}

	public void setId(EscaleId id) {
		this.id = id;
	}
	
	public void setId(Vol vol, Aeroport aeroport) {
		this.id = new EscaleId(vol, aeroport);
	}

	public void setVersion(int version) {
		Version = version;
	}
	

	@Override
	public String toString() {
		return "Escale [dateDepart=" + dateDepart + ", dateArrivee=" + dateArrivee + ", heureDepart=" + heureDepart
				+ ", heureArrivee=" + heureArrivee + ", vol=" + id.getVol()+ ", aeoroport="
				+ id.getAeroport() + "]";
	}



}
