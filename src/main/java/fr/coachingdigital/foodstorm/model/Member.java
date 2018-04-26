package fr.coachingdigital.foodstorm.model;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="MEMBER")
public class Member {

	private static final long serialVersionUID = 2492923586519001757L;
	@Id
	@Column(name = "MBR_ID")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	@Column(name = "MBR_LOGIN",unique=true)
	private String login;
	@Column(name = "MBR_PASSWD")
	private String passwd;
	@Column(name = "MBR_MAIL", unique=true)
	private String mail;
	@ManyToOne
	@JoinColumn(name="MBR_FAMILY_ID", nullable = false)
	private Family family;
	@ManyToMany(cascade = CascadeType.MERGE,fetch=FetchType.EAGER)
	@JoinTable(name = "MEMBER_ROLE")
	private Set<Role> roles;

	private String token;


	/**
	 * default
	 */
	public Member() {
		super();
	}

	/**
	 *
	 * @param id
	 * @param login
	 * @param passwd
	 * @param mail
	 * @param family
	 */
	public Member(final long id, final String login, final String passwd, final String mail, final Family family, final Set<Role> roles) {
		super();
		this.id = id;
		this.login = login;
		this.passwd = passwd;
		this.mail = mail;
		this.family = family;
		this.roles = roles;
	}

	/**
	 *
	 * @param login
	 * @param passwd
	 * @param mail
	 * @param family
	 */
	public Member(final String login, final String passwd, final String mail, final Family family, final Set<Role> roles) {
		super();
		this.login = login;
		this.passwd = passwd;
		this.mail = mail;
		this.family = family;
		this.roles = roles;
	}
	/**
	 *
	 * @return the family
	 */
	public Family getFamily() {
		return family;
	}
	/**
	 *
	 * @return the id
	 */
	public long getId() {
		return id;
	}
	/**
	 *
	 * @return the login
	 */
	public String getLogin() {
		return login;
	}
	/**
	 *
	 * @return the mail
	 */
	public String getMail() {
		return mail;
	}
	/**
	 *
	 * @return the password
	 */
	public String getPasswd() {
		return passwd;
	}
	/**
	 *
	 * @return the set of role
	 */
	public Set<Role> getRoles() {
		return roles;
	}
	/**
	 *
	 * @return the token
	 */
	public String getToken() {
		return token;
	}
	/**
	 *
	 * @param family the family to set
	 */
	public void setFamily(final Family family) {
		this.family = family;
	}
	/**
	 *
	 * @param id the id to set
	 */
	public void setId(final long id) {
		this.id = id;
	}
	/**
	 *
	 * @param login the login to set
	 */
	public void setLogin(final String login) {
		this.login = login;
	}

	/**
	 *
	 * @param mail the mail to set
	 */
	public void setMail(final String mail) {
		this.mail = mail;
	}
	/**
	 *
	 * @param passwd the password to set
	 */
	public void setPasswd(final String passwd) {
		this.passwd = passwd;
	}

	/**
	 *
	 * @param roles the set or role to set
	 */
	public void setRoles(final Set<Role> roles) {
		this.roles = roles;
	}

	/**
	 *
	 * @param token the token to set
	 */
	public void setToken(final String token) {
		this.token = token;
	}
	/**
	 * tostring
	 */
	@Override
	public String toString() {
		return "Member [id=" + id + ", login=" + login + ", passwd=" + passwd + ", mail=" + mail +
				", family=" + family + ", roles=" + roles + "]";
	}





}
