package vol.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Version;

import org.springframework.format.annotation.DateTimeFormat;


@Entity

public class Reservation {

	private Integer idRes;
	private int version;
	private EtatReservation etatReservation;
	private Date date;
	private String numero;
//	private EtatReservation etat;
	private Vol vol=new Vol();
	private Passager passager=new Passager();
	private Client client;

	@Id
	@GeneratedValue
	public Integer getIdRes() {
		return idRes;
	}

	public void setIdRes(Integer idRes) {
		this.idRes = idRes;
	}

	@Version
	public int getVersion() {
		return version;
	}

	public void setVersion(int version) {
		this.version = version;
	}
	
	@Enumerated (EnumType.STRING)
	public EtatReservation getEtatReservation() {
		return etatReservation;
	}

	public void setEtatReservation(EtatReservation etatReservation) {
		this.etatReservation = etatReservation;
	}

	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern="yyyy-MM-dd")
	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}
	
	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

//	public EtatReservation getEtat() {
//		return etat;
//	}
//
//	public void setEtat(EtatReservation etat) {
//		this.etat = etat;
//	}

	@ManyToOne
	@JoinColumn(name="vol_id")
	public Vol getVol() {
		return vol;
	}

	public void setVol(Vol vol) {
		this.vol = vol;
	}

	@ManyToOne
	@JoinColumn(name="passager_id")
	public Passager getPassager() {
		return passager;
	}

	public void setPassager(Passager passager) {
		this.passager = passager;
	}

	@ManyToOne
	@JoinColumn(name="client_id")
	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}
	
	public String toString() {
		String reponse = "La Reservation : " + this.numero + " a été effectuée par le Client : \n" + client.getNom()
				 + "\nElle porte sur le vol de " + vol.getAeroportDepart().getNom() + " à "
				+ vol.getAeroportArrivee().getNom() + ".\nElle concerne le passager :\n" + passager.getNom() + " "
				+ passager.getPrenom();

		return reponse;
	}

}
