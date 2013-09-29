import java.io.File;

public class Main {

	public static void main(String[] args) throws Exception {
		
		PhoneBook pb = new PhoneBook();
		File f = new File(Settings.PHONE_BOOK_STORAGE_FILE_NAME);
		pb.loadContactsFromJSON(f);
		pb.addContact("max", "Maxim", "Eshow", "Andatrevich", "564879");
		pb.writeContactsToJSON();
	}
}