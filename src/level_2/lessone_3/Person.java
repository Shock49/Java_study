package level_2.lessone_3;

public class Person {
    private String name;
    private String email;
    private String phonenamber;

    public Person(String name, String email, String phonenamber) {
        this.name = name;
        this.email = email;
        this.phonenamber = phonenamber;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getPhonenamber() {
        return phonenamber;
    }
}
