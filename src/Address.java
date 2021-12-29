public class Address {
    private String cityName;
    private String streetName;



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
        String[] cityArray={"Tel Aviv","Kiryat Gat","Ashqelon","Haifa","Jerusalem"};
        if (i> cityArray.length-1){
            i=i-(cityArray.length);
        }
        return cityArray[i];
    }
    public String streetArray(int i){
        String[] streetArray={"Hertzel","Rabin","Begin","Dizingov","Shamgar Ben Anat","Mishol Shimshon"};
        if (i> streetArray.length-1){
            i=i-(streetArray.length);
        }
        return streetArray[i];
    }

}
