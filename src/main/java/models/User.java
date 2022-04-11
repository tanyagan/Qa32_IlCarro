package models;

public class User {
    String name;
    String LastName;
    private String email;
    private  String password;
    String phone;

    public String getPhone() {
        return phone;
    }

    public User withPhone(String phone) {
        this.phone = phone;
        return this;
    }

    public User withName(String name) {
        this.name = name;
        return this;
    }

    public User withLastName(String lastName) {
        LastName = lastName;
        return this;
    }

    public String getName() {
        return name;
    }

    public String getLastName() {
        return LastName;
    }

    public User withEmail(String email) {
        this.email = email;
        return this;
    }

    public User  withPassword(String password) {
        this.password = password;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", LastName='" + LastName + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", phone='" + phone + '\'' +
                '}';
    }
}

