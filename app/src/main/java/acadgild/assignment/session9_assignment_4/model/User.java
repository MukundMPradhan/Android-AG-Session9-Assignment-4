package acadgild.assignment.session9_assignment_4.model;

/**
 * Created by mukund on 20/5/16.
 */
public class User {
    String name, phone, dob;

    public User(String name, String phone, String dob) {
        this.dob = dob;
        this.name = name;
        this.phone = phone;
    }

    public String getDob() {
        return dob;
    }

    public User setDob(String dob) {
        this.dob = dob;
        return this;
    }

    public String getName() {
        return name;
    }

    public User setName(String name) {
        this.name = name;
        return this;
    }

    public String getPhone() {
        return phone;
    }

    public User setPhone(String phone) {
        this.phone = phone;
        return this;
    }
}
