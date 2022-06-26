package level_2.lessone_3;

import java.util.ArrayList;
import java.util.HashMap;

public class PhoneBook {
    private HashMap<String,ArrayList<String>> contactPhone;
    private HashMap<String,ArrayList<String>> contactEmail;
    public ArrayList<Person> listPerson;

    PhoneBook(){
        listPerson = new ArrayList<>();
        contactPhone = new HashMap<>();
        contactEmail = new HashMap<>();
    }

    PhoneBook(ArrayList<Person> listPerson){
        this.listPerson = listPerson;
        contactPhone  = new HashMap<>();
        contactEmail = new HashMap<>();
        for (Person person :
                listPerson) {
            ArrayList<String> buffer = contactPhone.getOrDefault(person.getName(),new ArrayList<>());
            buffer.add(person.getPhonenamber());
            contactPhone.put(person.getName(), buffer);
            buffer = contactEmail.getOrDefault(person.getName(),new ArrayList<>());
            buffer.add(person.getEmail());
            contactEmail.put(person.getName(),buffer);
        }
    }

    void add(Person person){
        listPerson.add(person);
        ArrayList<String> bufferPhone = contactPhone.getOrDefault(person.getName(),new ArrayList<>());
        bufferPhone.add(person.getPhonenamber());
        contactPhone.put(person.getName(), bufferPhone);
        ArrayList<String> bufferEmail = contactEmail.getOrDefault(person.getName(),new ArrayList<>());
        bufferEmail.add(person.getEmail());
        contactEmail.put(person.getName(),bufferEmail);
    }


    ArrayList<String> getPhoneNumber(String name){
        return contactPhone.get(name);
    }

    ArrayList<String> getEmail(String name){
        return contactEmail.get(name);
    }
}
