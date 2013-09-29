import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;

import org.json.simple.JSONObject;
import org.json.simple.JSONArray;
import org.json.simple.JSONValue;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.FileInputStream;
/**
 * 
 */
import java.io.UnsupportedEncodingException;

/**
 * @author misha
 *
 */
public class PhoneBook{
	
	private HashMap<String, Contact> contacts;

	public PhoneBook() {
		setContacts(new HashMap<String, Contact>());
	}
	
	// start of a set and get methods block
	public void setContacts(HashMap<String, Contact> contacts) {
		this.contacts = contacts;
	}
	public HashMap<String, Contact> getContacts() {
		return this.contacts;
	}
	// end of a set and get methods block
	
	public void addContact(Contact contact) {
		this.contacts.put(contact.getPrimaryKey(), contact);
	}
	
	public void addContact(String nickname, String firstname, String lastname, 
			String patronymic, String phoneNumber) {
		Contact contact = new Contact(nickname, firstname, lastname, patronymic, 
				phoneNumber);
		this.contacts.put(contact.getPrimaryKey(), contact);
	}
	
	public void writeContactsToJSON() {
		Set<Entry<String, Contact>> set = this.contacts.entrySet();
		Iterator<Entry<String, Contact>> iter = set.iterator();
		JSONObject resultJSON = new JSONObject();
		JSONArray contactsArray = new JSONArray();
		JSONObject tmpJSONObject = null;
		
		while (iter.hasNext()) {
			tmpJSONObject = new JSONObject();
			Contact contact = iter.next().getValue();
//			System.out.println(contact.getKey() + " : " + contact.getValue().getLastname());
			tmpJSONObject.put("nickname", contact.getNickname());
			tmpJSONObject.put("firstname", contact.getFirstname());
			tmpJSONObject.put("lastname", contact.getLastname());
			tmpJSONObject.put("patronymic", contact.getPatronymic());
			tmpJSONObject.put("phoneNumber", contact.getPhoneNumber());
			contactsArray.add(tmpJSONObject);
		}
		resultJSON.put("phoneBook", contactsArray);
//		System.out.print(resultJSON.toJSONString());
		
		try {
			File file = new File(Settings.PHONE_BOOK_STORAGE_FILE_NAME);
			FileWriter wrt;
			wrt = new FileWriter(file);
//			CharSequence cq = "welcome to future2 \n ор зщш";
			wrt.append(resultJSON.toJSONString());
//			wrt.append("asdfdaf");
			wrt.flush();
			wrt.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	public void loadContactsFromJSON(File jsonFile) {
		BufferedReader reader = null;
		try {
			reader = new BufferedReader(new InputStreamReader(
					new FileInputStream(jsonFile), "utf8"));
			
			String tmpStr = "";
			String fileContent = "";
			while ((tmpStr = reader.readLine()) != null) {
				fileContent += tmpStr;
			}
			
			this.setContacts(parseContactsFromJson(fileContent));
		} catch (FileNotFoundException e) {
			System.out.println("file is not found");
			System.exit(0);
		} catch (UnsupportedEncodingException e) {
			System.out.println("UnsupportedEncodingException in loadContactsFromJSON");
			System.exit(0);
		} catch (IOException e) {
			System.out.println("IOException in loadContactsFromJSON");
			System.exit(0);
		}
	}
	
	private HashMap<String, Contact> parseContactsFromJson(String jsonString) {
		Object obj = JSONValue.parse(jsonString);
		JSONObject jsonObj = (JSONObject) obj;
		JSONArray contactArray = (JSONArray) jsonObj.get("phoneBook");
		JSONObject jsonTempObject = null;
		Contact tmpContact = null;
		HashMap<String, Contact> contactsSet = new HashMap<String, Contact>();
		for (Object e : contactArray) {
			jsonTempObject = (JSONObject)e;
			tmpContact = new Contact(jsonTempObject.get("nickname").toString(), 
					jsonTempObject.get("firstname").toString(), 
					jsonTempObject.get("lastname").toString(), 
					jsonTempObject.get("patronymic").toString(), 
					jsonTempObject.get("phoneNumber").toString());
			contactsSet.put(tmpContact.getPrimaryKey(), tmpContact);
		}
		return contactsSet;
	}
}
