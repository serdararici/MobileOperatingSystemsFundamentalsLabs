package pl.serdararici.app_8_1;

public class People {
    private int image;
    private String name, email, phone;
    public People(int image, String name, String email, String phone) {
        this.image = image;
        this.name = name;
        this.email = email;
        this.phone = phone;
    }
    public int getImage() {return image;}
    public String getName() {return name;}
    public String getEmail() {return email;}
    public String getPhone() {return phone;}

}
