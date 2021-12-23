public class Address {
    private String cityName;
    private String streetName;

    public Address(String cityName, String streetName){
        this.cityName=cityName;
        this.streetName=streetName;
    }

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

    public String cityArray(int i){
        if (i>4){
            i=i-5;
        }
        String cityArray[]={"Tel Aviv","Kiryat Gat","Ashqelon","Haifa","Jerusalem"};
        return cityArray[i];
    }
    public String streetArray(int i){
        if (i>5){
            i=i-6;
        }
        String streetArray[]={"Hertzel","Rabin","Begin","Dizingov","shamgar ben anat","mishol shimshon"};
        return streetArray[i];
    }

}
