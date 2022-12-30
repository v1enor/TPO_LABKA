package Model;

public class User {
    private String FirstName;
    private String SecondName;
    private String Number;
    private String Hotel;

    private String Email;



    public User(String firstname, String secondname, String number, String hotel, String email) {
        this.FirstName = firstname;
        this.SecondName = secondname;
        this.Number = number;
        this.Hotel = hotel;
        this.Email = email;
    }

    public String getUsername() {
        return FirstName;
    }

    public void setUsername(String firstname) {
        this.FirstName = firstname;
    }

    public String getSecondName() {
        return SecondName;
    }
    public String getHotel() {
        return Hotel;
    }

    public String getEmail() {
        return Email;
    }
    public void setSecondName(String secondName) {
        this.SecondName = secondName;
    }

    public void setNumber(String number) {
        this.Number = number;
    }
    public String getNumber() {
        return Number;
    }

}
