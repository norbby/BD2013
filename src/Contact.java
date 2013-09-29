/**
 * 
 */

/**
 * @author misha
 *
 */
public class Contact extends BaseTable {
	private String nickname;
	private String firstname;
	private String lastname;
	private String patronymic;
	private String phoneNumber;
	
	public Contact(String nickname, String firstname, String lastname, 
			String patronymic, String phoneNumber) {
		super(nickname);
		setNickname(nickname);		
		setFirstname(firstname);
		setLastname(lastname);
		setPatronymic(patronymic);
		setPhoneNumber(phoneNumber);
	}
	
	// start of a set and get methods block
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	
	public String getNickname() {
		return this.nickname;
	}
	
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	
	public String getFirstname() {
		return this.firstname;
	}
	
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	
	public String getLastname() {
		return this.lastname;
	}
	
	public void setPatronymic(String patronymic) {
		this.patronymic = patronymic;
	}
	
	public String getPatronymic() {
		return this.patronymic;
	}
	
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	
	public String getPhoneNumber() {
		return this.phoneNumber;
	}
	// end of a set and get methods block
}
