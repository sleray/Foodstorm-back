package fr.coachingdigital.foodstorm.bean;
/**
 * Class Handle login password for signin
 * @author jetrilla
 *
 */
public class SignInBean {
	private String login;
	private String password;

	public SignInBean() {
		super();
	}
	public SignInBean(final String login,final String password) {
		super();
		this.login = login;
		this.password = password;
	}
	/**
	 *
	 * @return login
	 */
	public String getLogin() {
		return login;
	}
	/**
	 *
	 * @return password
	 */
	public String getPassword() {
		return password;
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
	 * @param password the password to set
	 */
	public void setPassword(final String password) {
		this.password = password;
	}

}
