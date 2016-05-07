package itaf.framework.domain.im;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 
 *
 *
 * @author
 *
 * @UpdateDate 2014年9月4日
 */
@Entity
@Table(name = "OFUSER")
public class OfUser implements java.io.Serializable {

	private static final long serialVersionUID = -3420028851475778941L;

	private String username;
	private String plainpassword;
	private String encryptedpassword;
	private String name;
	private String email;

	public OfUser() {
		//
	}

	@Id
	@Column(name = "USERNAME")
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	@Column(name = "PLAINPASSWORD")
	public String getPlainpassword() {
		return plainpassword;
	}

	public void setPlainpassword(String plainpassword) {
		this.plainpassword = plainpassword;
	}

	@Column(name = "ENCRYPTEDPASSWORD")
	public String getEncryptedpassword() {
		return encryptedpassword;
	}

	public void setEncryptedpassword(String encryptedpassword) {
		this.encryptedpassword = encryptedpassword;
	}

	@Column(name = "NAME")
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Column(name = "EMAIL")
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
}
