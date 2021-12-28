public class User {
    private String userName;
    private String password;
    private String phoneNumber;
    private boolean mediatorOrRegular;

    public User (String userName,String password, String phoneNumber, boolean mediatorOrRegular){
        this.userName=userName;
        this.password=password;
        this.phoneNumber=phoneNumber;
        this.mediatorOrRegular=mediatorOrRegular;
    }

    public String getUserName(){
        return this.userName;
    }
    public void setUserName(String userName){
        this.userName=userName;
    }
    public String getPassword(){
        return this.password;
    }
    public void setPassword(String password){
        this.password=password;
    }
    public String getPhoneNumber(){
        return this.phoneNumber;
    }
    public void setPhoneNumber(String phoneNumber){
        this.phoneNumber=phoneNumber;
    }
    public boolean isMediatorOrRegular(){
        return this.mediatorOrRegular;
    }
    public void setMediatorOrRegular(boolean mediatorOrRegular){
        this.mediatorOrRegular=mediatorOrRegular;
    }
    public String toString(){
        return this.userName+" "+this.phoneNumber+" "+(this.mediatorOrRegular ? "(real estate broker)":"(regular user)");
    }
}
