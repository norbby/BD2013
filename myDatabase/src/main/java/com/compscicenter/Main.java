import java.io.File;
import phoneBookExeptions.ParsingError;

public class Main {

	public static void main(String[] args) throws Exception {
		File f = new File(Settings.PHONE_BOOK_STORAGE_FILE_NAME);
		
		String addCommand = "add(nickname2, Kolya, Kolya, Nikolai, 123456)";
		String getCommand = "get(nickname2)";
		String delCommand = "delete(nickname2)";
		PhoneBook pb = new PhoneBook();
		pb.loadContactsFromJSON(f);
		System.out.println(pb.parse(addCommand));
		System.out.println(pb.parse(getCommand));
		System.out.println(pb.parse(delCommand));
	}
}