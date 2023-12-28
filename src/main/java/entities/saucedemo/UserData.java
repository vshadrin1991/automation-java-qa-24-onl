package entities.saucedemo;

public class UserData {
    private String username;
    private String password;
    private Integer age;
    private String address;

    public UserData withUsername(String username) {
        this.username = username;
        return this;
    }

    public UserData withPassword(String password) {
        this.password = password;
        return this;
    }

    public UserData withUAge(Integer age) {
        this.age = age;
        return this;
    }

    public UserData withAddress(String address) {
        this.address = address;
        return this;
    }

    @Override
    public String toString() {
        return "UserData{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", age=" + age +
                ", address='" + address + '\'' +
                '}';
    }
}



