public class Address {
    private String cityName;
    private String streetName;
    public final int LENGTH_OF_CITIES = 4, LENGTH_OF_STREET =5;


    public Address(String cityName, String streetName) {
        this.cityName = cityName;
        this.streetName = streetName;
    }

    public String getCityName() {
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
        if (i> LENGTH_OF_CITIES){
            i=i-(LENGTH_OF_CITIES+1);
        }
        String cityArray[]={"Tel Aviv","Kiryat Gat","Ashqelon","Haifa","Jerusalem"};
        return cityArray[i];
    }
    public String streetArray(int i){
        if (i> LENGTH_OF_STREET){
            i=i-(LENGTH_OF_STREET+1);
        }
        String streetArray[]={"Hertzel","Rabin","Begin","Dizingov","Shamgar Ben Anat","Mishol Shimshon"};
        return streetArray[i];
    }

}
