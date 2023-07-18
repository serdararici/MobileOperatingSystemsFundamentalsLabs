package pl.serdararici.countries;

public class Country {

    private int flag;
    private String country, capital;
    public Country(int flag, String country, String capital) {
        this.flag = flag;
        this.country = country;
        this.capital = capital;
    }
    public int getFlag() {return flag;}
    public String getCountry() {return country;}
    public String getCapital() {return capital;}
}
