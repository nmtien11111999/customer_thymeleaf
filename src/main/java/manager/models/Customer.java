package manager.models;

public class Customer {
    private int id;
    private String Name;

    private String email;
    private String Address;

    public Customer() {
    }
    public Customer(int id, String name, String email, String address) {
        this.id = id;
        Name = name;
        this.email = email;
        Address = address;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String address) {
        Address = address;
    }
}
