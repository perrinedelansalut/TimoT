package vol.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Version;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * @author ajc
 *
 */
@Entity
public class Vol {

	/**
	 * id du vol
	 */
	private Integer idVol;
	/**
	 * date de départ du vol
	 */
	private Date dateDepart;
	/**
	 * date d'arrivé du vol
	 */
	private Date dateArrivee;
	/**
	 * heure départ du vol
	 */
	private Date heureDepart;
	/**
	 * heure d'arrivée du vol
	 */
	private Date heureArrivee;
	private Aeroport aeroportDepart;
	private Aeroport aeroportArrivee;
	/**
	 * liste d'escales par lesquelles on peut passer
	 */
	private List<Escale> escales;
	private List<Reservation> reservations;
	private List<CompagnieAerienneVol> compagnieAerienneVols;
	private int version;
	
	

	@Version
	public int getVersion() {
		return version;
	}
	public void setVersion(int version) {
		this.version = version;
	}
	/**
	 * Constructeur de vol
	 */
	public Vol(){
		this.escales = new ArrayList<Escale>();
		this.reservations = new ArrayList<Reservation>();
		this.compagnieAerienneVols = new ArrayList<CompagnieAerienneVol>();
	}
	/**
	 * constructeur de vol
	 * 
	 * @param idVol
	 *            l'ID du vol
	 */
	public Vol(Integer idVol) {
		this.idVol = idVol;
		this.escales = new ArrayList<Escale>();
		this.reservations = new ArrayList<Reservation>();
		this.compagnieAerienneVols = new ArrayList<CompagnieAerienneVol>();
	}
	
	@JsonIgnore
	@ManyToOne
	@JoinColumn(name="aeroport_Arrivée_Id")
	public Aeroport getAeroportArrivee() {
		return aeroportArrivee;
	}
	
	@JsonIgnore
	@ManyToOne
	@JoinColumn(name="aeroport_Depart_Id")
	public Aeroport getAeroportDepart() {
		return aeroportDepart;
	}
	
	@JsonIgnore
	@OneToMany(mappedBy="vol")
	public List<CompagnieAerienneVol> getCompagnieAerienneVols() {
		return compagnieAerienneVols;
	}
	
		
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern="yyyy-MM-dd")
	
	public Date getDateArrivee() {
		return dateArrivee;
	}
	
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern="yyyy-MM-dd")
	
	public Date getDateDepart() {
		return dateDepart;
	}

	@JsonIgnore
	@OneToMany(mappedBy="id.vol")
	public List<Escale> getEscales() {
		return escales;
	}

	@Temporal(TemporalType.TIME)
	@DateTimeFormat(pattern="HH:mm")
	@JsonFormat(pattern = "HH:mm")
	public Date getHeureArrivee() {
		return heureArrivee;
	}

	@Temporal(TemporalType.TIME)
	@DateTimeFormat(pattern="HH:mm")
	@JsonFormat(pattern = "HH:mm")
	public Date getHeureDepart() {
		return heureDepart;
	}

	@Id
	@GeneratedValue
	public Integer getIdVol() {
		return idVol;
	}

	@JsonIgnore
	@OneToMany(mappedBy="vol")
	public List<Reservation> getReservations() {
		return reservations;
	}

	public void setAeroportArrivee(Aeroport aeroportArrivee) {
		this.aeroportArrivee = aeroportArrivee;
	}

	public void setAeroportDepart(Aeroport aeroportDepart) {
		this.aeroportDepart = aeroportDepart;
	}

	public void setCompagnieAerienneVols(List<CompagnieAerienneVol> compagnieAerienneVols) {
		this.compagnieAerienneVols = compagnieAerienneVols;
	}

	public void setDateArrivee(Date dateArrivee) {
		this.dateArrivee = dateArrivee;
	}

	public void setDateDepart(Date dateDepart) {
		this.dateDepart = dateDepart;
	}

	public void setEscales(List<Escale> escales) {
		this.escales = escales;
	}

	public void setHeureArrivee(Date heureArrivee) {
		this.heureArrivee = heureArrivee;
	}

	public void setHeureDepart(Date heureDepart) {
		this.heureDepart = heureDepart;
	}

	public void setIdVol(Integer idVol) {
		this.idVol = idVol;
	}

	public void setReservations(List<Reservation> reservations) {
		this.reservations = reservations;
	}

	public String toString() {
		String reponse = "Le vol  de : " + this.aeroportDepart.getNom() + " qui part le " + this.dateDepart + " à "
				+ this.heureDepart + "\n Arrivera à " + this.aeroportArrivee.getNom() + " à " + this.heureArrivee
				+ "\nIl fera des escales à : ";
		for (int i =0; i < escales.size(); i++) {
			reponse += "\n" + this.escales.get(i).getId().getAeroport().getNom() + " le "
					+ this.escales.get(i).getDateArrivee() + " à " + this.escales.get(i).getHeureArrivee() + "jusqu'au"
					+ this.escales.get(i).getDateDepart() + " à " + this.escales.get(i).getHeureDepart();
		}

		return reponse;
	}
}
