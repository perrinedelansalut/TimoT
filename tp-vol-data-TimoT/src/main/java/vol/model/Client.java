/**
 * 
 */
package vol.model;


import java.util.ArrayList;
import java.util.List;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Version;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.Length;

/**
 * @author ajc
 *
 */
@Entity
@Table(name="Client")
@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="typeClient", discriminatorType=DiscriminatorType.STRING)
public abstract class Client {

	/**
	 * 
	 */
	private String typeClient;
	private Integer idCli;
	private String nom;
	private String numeroTel;
	private String numeroFax;
	private String email;
	private Titre titre;
	private int version;
	private List<Reservation> reservations = new ArrayList<Reservation>();
	private Adresse adresse = new Adresse();
	private Login Log = new Login();

	
	 public Client() {
	}

	public Client(int idCli) {

		this();
		this.idCli = idCli;
	}

	@Embedded
	public Adresse getAdresse() {
		return adresse;
	}

	@Email(message="{client.error.email.format}")
	public String getEmail() {
		return email;
	}

	@Id
	@GeneratedValue
	public Integer getIdCli() {
		return idCli;
	}

	@Embedded
	public Login getLog() {
		return Log;
	}
	
	@Length(min=1, message="{client.error.nom.size}")
	@NotNull(message="{client.error.nom.size}")
	public String getNom() {
		return nom;
	}

	public String getNumeroFax() {
		return numeroFax;
	}



	public String getNumeroTel() {
		return numeroTel;
	}

	@OneToMany(mappedBy="client")
	public List<Reservation> getReservations() {
		return reservations;
	}

	@Enumerated (EnumType.STRING)
	public Titre getTitre() {
		return titre;
	}
	
	@Column(name = "typeClient", insertable = false, updatable = false)
	public String getTypeClient() {
		return typeClient;
	}
	
	@Version
	public int getVersion() {
		return version;
	}

	public void setAdresse(Adresse adresse) {
		this.adresse = adresse;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setIdCli(Integer idCli) {
		this.idCli = idCli;
	}

	public void setLog(Login log) {
		Log = log;
	}

	public void setLog(String login, String motdepasse, boolean admin){
		this.Log = new Login(login, motdepasse, admin);
	}

	public void setNom(String nom) {
		this.nom = nom;
	}


	public void setNumeroFax(String numeroFax) {
		this.numeroFax = numeroFax;
	}

	public void setNumeroTel(String numeroTel) {
		this.numeroTel = numeroTel;
	}

	public void setReservations(List<Reservation> reservations) {
		this.reservations = reservations;
	}

	public void setTitre(Titre titre) {
		this.titre = titre;
	}

	public void setTypeClient(String typeClient) {
		this.typeClient = typeClient;
	}

	public void setVersion(int version) {
		this.version = version;
	}


	public String toString() {
		String reponse = "Le Client : " + this.nom  + " " + getNumeroTel()
				+ " a effectué la/les reservation(s) : \n";
		for (int i = 0; i < reservations.size(); i++) {
			reponse += "\n" + this.reservations.get(i).getNumero();
		}

		return reponse;
	}

}
