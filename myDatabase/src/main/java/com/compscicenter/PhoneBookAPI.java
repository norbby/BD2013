import phoneBookExeptions.ObjectAlreadyExists;
import phoneBookExeptions.ParsingError;

/**
 * 
 */

/**
 * @author misha
 *
 */
public interface PhoneBookAPI {
	void add(String nickname, String firstname, String lastname, String patronymic,
			String phoneNumber) throws ObjectAlreadyExists;
	void add(Contact contact) throws ObjectAlreadyExists;
	Contact get(String primaryKey);
	void delete(String primaryKey);
	String parse(String command) throws ParsingError, ObjectAlreadyExists;
}
