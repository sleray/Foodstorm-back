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
	public Member(long id, String login, String passwd, String mail, Family family) {
		super();
		this.id = id;
		this.login = login;
		this.passwd = passwd;
		this.mail = mail;
		this.family = family;
	}
	
	/**
	 * 
	 * @param login
	 * @param passwd
	 * @param mail
	 * @param family
	 */
	public Member(String login, String passwd, String mail, Family family) {
		super();
		this.login = login;
		this.passwd = passwd;
		this.mail = mail;
		this.family = family;
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
	 * @param id the id to set
	 */
	public void setId(long id) {
		this.id = id;
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
	 * @param login the login to set
	 */
	public void setLogin(String login) {
		this.login = login;
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
	 * @param passwd the password to set
	 */
	public void setPasswd(String passwd) {
		this.passwd = passwd;
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
	 * @param mail the mail to set
	 */
	public void setMail(String mail) {
		this.mail = mail;
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
	 * @param family the family to set
	 */
	public void setFamily(Family family) {
		this.family = family;
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
