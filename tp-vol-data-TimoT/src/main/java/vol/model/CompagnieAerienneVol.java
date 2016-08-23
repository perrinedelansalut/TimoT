package vol.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Version;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
public class CompagnieAerienneVol {

	private Integer id;
	private int version;
	private String numero;
	private Boolean ouvert;
	private CompagnieAerienne compagnieAerienne;
	private Vol vol;

	public CompagnieAerienneVol() {
		super();
	}

	public CompagnieAerienneVol(CompagnieAerienne compagnieAerienne, Vol vol) {
		super();
	}

	
	@Id
	@GeneratedValue
	public Integer getId() {
		return id;
	}

	public void setIdCAV(Integer id) {
		this.id = id;
	}
	
	@ManyToOne
	@JoinColumn(name="compagnieAerienneId")
	@NotNull(message="{compagnieAerienneVol.compagnieAerienne.error.notNull}")
	public CompagnieAerienne getCompagnieAerienne() {
		return compagnieAerienne;
	}

	public void setCompagnieAerienne(CompagnieAerienne compagnieAerienne) {
		this.compagnieAerienne = compagnieAerienne;
	}

	@ManyToOne
	@JoinColumn(name="volId")
	@NotNull(message="{compagnieAerienneVol.vol.error.notNull}")
	public Vol getVol() {
		return vol;
	}

	public void setVol(Vol vol) {
		this.vol = vol;
	}


	@Version
	public int getVersion() {
		return version;
	}

	public void setVersion(int version) {
		this.version = version;
	}

	@Size(min=2, max=100, message="{compagnieAerienneVol.numero.error.size}")
	@Column(length = 100)
	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	@NotNull(message="{compagnieAerienneVol.ouvert.error.notNull}")
	public Boolean getOuvert() {
		return ouvert;
	}

	public void setOuvert(Boolean ouvert) {
		this.ouvert = ouvert;
	}

	public void setId(Integer id) {
		this.id = id;
	}
	
	

	
	/*
	 * @Override public String toString() { return
	 * "CompagnieAerienneVol [ compagnieAerienne=" + compagnieAerienne +
	 * ", vol=" + vol + ", numero=" + numero + ", ouvert=" + ouvert + "]"; }
	 */

}
