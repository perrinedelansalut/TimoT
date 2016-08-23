package vol.model;

import javax.persistence.Embeddable;

import org.hibernate.validator.constraints.Length;

@Embeddable
public class Login {

	private String login;
	private String motDePasse;
	private Boolean admin;
	
	public Login() {
		super();
	}
	
	
	public Login(String login, String motDePasse, Boolean admin) {
		super();
		this.login = login;
		this.motDePasse = motDePasse;
		this.admin = admin;
	}
	@Length(min=8, message="{client.error.login.size}")
	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}
	
	@Length(min=8, message="{client.error.login.size}")
	public String getMotDePasse() {
		return motDePasse;
	}

	public void setMotDePasse(String motDePasse) {
		this.motDePasse = motDePasse;
	}
	
	public Boolean getAdmin() {
		return admin;
	}

	public void setAdmin(Boolean admin) {
		this.admin = admin;
	}

	@Override
	public String toString() {
		return "Login [Login=" + login + ", motDePasse=" + motDePasse + ", admin=" + admin + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((login == null) ? 0 : login.hashCode());
		result = prime * result + ((admin == null) ? 0 : admin.hashCode());
		result = prime * result + ((motDePasse == null) ? 0 : motDePasse.hashCode());
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
		Login other = (Login) obj;
		if (login == null) {
			if (other.login != null)
				return false;
		} else if (!login.equals(other.login))
			return false;
		if (admin == null) {
			if (other.admin != null)
				return false;
		} else if (!admin.equals(other.admin))
			return false;
		if (motDePasse == null) {
			if (other.motDePasse != null)
				return false;
		} else if (!motDePasse.equals(other.motDePasse))
			return false;
		return true;
	}
	
	

}
