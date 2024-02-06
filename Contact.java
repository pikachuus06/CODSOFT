import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Contact {
	private String name;
	private String mobileNo;
	private String email;
	
	public Contact(String name, String mobileNo, String email) {
		super();
		this.name = name;
		this.mobileNo = mobileNo;
		this.email = email;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getMobileNo() {
		return mobileNo;
	}

	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
}
class AddressBook{
	private List<Contact> contacts;

	public AddressBook() {
		this.contacts = new ArrayList<>();
	}
	 
	public void addContact(Contact contact) {
		this.contacts.add(contact);
	}
	public void removeContact(Contact contact) {
		this.contacts.remove(contact);
	}
	public List<Contact> searchContact(String keyword){
		List<Contact> result = new ArrayList<>();
		for(Contact contact : this.contacts) {
			if(contact.getName().toLowerCase().contains(keyword.toLowerCase())) {
				result.add(contact);
			}
		}
		return result;
	}
	public void displayAllContacts() {
		for(Contact contact : this.contacts) {
			System.out.println("*Name : " + contact.getName() +  " *Mobile Number : " + contact.getMobileNo() + " *Email : " + contact.getEmail());
			
		}
	}

//public class AddressBookApp{
	 public static void main(String[] args) {
	        AddressBook addressBook = new AddressBook();
		try (Scanner s = new Scanner(System.in)) {
            while(true) {
				System.out.println("*********************************************************");
            	 System.out.println("Address Book System");
                    System.out.println("1. Add Contact");
                    System.out.println("2. Remove Contact");
                    System.out.println("3. Search Contact");
                    System.out.println("4. Display All Contacts");
                    System.out.println("5. Exit");
					System.out.println("*********************************************************");

                    System.out.print("Enter your choice: ");
                    int choice = s.nextInt();
                    s.nextLine();  

                    switch (choice) {
                        case 1:
                            System.out.print("Enter name: ");
                            String name = s.nextLine();
                            System.out.print("Enter phone number: ");
                            String mobileNo = s.nextLine();
                            System.out.print("Enter email address: ");
                            String email = s.nextLine();
                            Contact newContact = new Contact(name, mobileNo, email);
                            addressBook.addContact(newContact);
							System.out.println("Contact added successfully...");
                            break;
                        case 2:
                        	 System.out.print("Enter name of the contact to remove: ");
                             String nameToRemove = s.nextLine();
                             List<Contact> searchResult = addressBook.searchContact(nameToRemove);
                             if (!searchResult.isEmpty()) {
                                 Contact contactToRemove = searchResult.get(0);
                                 addressBook.removeContact(contactToRemove);
                                 System.out.println("Contact removed successfully.");
                             } else {
                                 System.out.println("Contact not found.");
                             }
                            break;
                        case 3:
                            System.out.print("Enter search keyword: ");
                            String keyword = s.nextLine();
                            List<Contact> searchResult1 = addressBook.searchContact(keyword);
                            // Display search results
                            break;
                        case 4:
                            addressBook.displayAllContacts();
                            break;
                        case 5:
                            System.out.println("Exiting the application. Goodbye!");
                            System.exit(0);
                            break;
                        default:
                            System.out.println("Invalid choice. Please enter a valid option.");
                    }
                }
        }
	    }
	
			
		
	}
