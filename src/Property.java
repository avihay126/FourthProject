public class Property {
    private Address address;
    private int numOfRooms;
    private int price;
    private String typeOfProperty;
    private boolean privateOrApartment;
    private boolean forRent;
    private int houseNumber;
    private int floorNumber;
    private User userWhoPostedTheProperty;

    public Property(){

    }

    public Address getAddress(){
        return this.address;
    }
    public void setAddress(Address address){
        this.address=address;
    }
    public int getNumOfRooms(){
        return this.numOfRooms;
    }
    public void setNumOfRooms(int numOfRooms){
        this.numOfRooms=numOfRooms;
    }
    public int getPrice(){
        return this.price;
    }
    public void setPrice(int price){
        this.price=price;
    }
    public String getTypeOfProperty(){
        return this.typeOfProperty;
    }
    public void setTypeOfProperty(String typeOfProperty){
        this.typeOfProperty=typeOfProperty;
    }
    public boolean isPrivateOrApartment(){
        return this.privateOrApartment;
    }
    public void setPrivateOrApartment(boolean privateOrApartment){
        this.privateOrApartment=privateOrApartment;
    }

    public boolean isForRent(){
        return this.forRent;
    }
    public void setForRent(boolean forRent){
        this.forRent=forRent;
    }
    public int getHouseNumber(){
        return this.houseNumber;
    }
    public void setHouseNumber(int houseNumber){
        this.houseNumber=houseNumber;
    }
    public int getFloorNumber(){
        return this.floorNumber;
    }
    public void setFloorNumber(int floorNumber){
        this.floorNumber=floorNumber;
    }
    public User getUserWhoPostedTheProperty(){
        return this.userWhoPostedTheProperty;
    }
    public void setUserWhoPostedTheProperty(User userWhoPostedTheProperty){
        this.userWhoPostedTheProperty=userWhoPostedTheProperty;
    }
    public String toString(){
        return this.typeOfProperty+"-"+(this.forRent ? "for rent":"for sale")+": "+this.numOfRooms+" rooms"+(this.privateOrApartment? ", floor "+this.floorNumber+".":".")+
                "\nPrice: "+this.price+"$" +
                "\nContact info: "+this.userWhoPostedTheProperty;
    }
}
