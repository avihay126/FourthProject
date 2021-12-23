public class Address {
    private String cityName;
    private String streetName;

    public String getCityName(){
        return this.cityName;
    }
    public void setCityName(String cityName){
        this.cityName=cityName;
    }
    public String getStreetName(){
        return this.streetName;
    }
    public void setStreetName(String streetName){
        this.streetName=streetName;
    }
    public String toString(){
        return "City: "+this.cityName+"\nStreet: "+this.streetName;
    }
}
