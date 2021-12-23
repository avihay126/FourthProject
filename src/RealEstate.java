import java.util.Scanner;

public class RealEstate {
    private User[] users;
    private Address[] addresses;
    private Property[] properties;

    public RealEstate(){
        Address address =new Address(null,null);
        this.users=new User[0];
        this.addresses=new Address[10];
        for (int i=0;i<this.addresses.length;i++){
            addresses[i]=new Address(address.cityArray(i),address.streetArray(i));
        }
        this.properties=new Property[0];
    }

    public User[] getUsers() {
        return users;
    }
    public void setUsers(User[] users) {
        this.users = users;
    }

    public Address[] getAddresses() {
        return addresses;
    }

    public void setAddresses(Address[] addresses) {
        this.addresses = addresses;
    }

    public Property[] getProperties() {
        return properties;
    }

    public void setProperties(Property[] properties) {
        this.properties = properties;
    }

    public void createUser(){
        User[]newArray = new User[this.users.length+1];
        for (int i =0;i<this.users.length;i++){
            newArray[i]=this.users[i];
        }
        User userToCreate=new User(createUserName(),password(),phoneNumber(),isMediator());
        newArray[this.users.length]=userToCreate;
        this.users=newArray;
    }
    private String createUserName(){
        Scanner scanner=new Scanner(System.in);
        String userName=null;
        do {
            System.out.println("Enter userName: ");
            userName= scanner.nextLine();
        }while (isUserNameExist(userName));
        return userName;
    }
    private boolean isUserNameExist(String userName){
        boolean isExist= false;
        for (int i=0;i<this.users.length;i++){
            if (this.users[i].getUserName().equals(userName)){
                isExist=true;
                System.out.println("UserName already exists! Try again!");
                break;
            }
        }
        return isExist;
    }
    private String password(){
        Scanner scanner=new Scanner(System.in);
        String password=null;
        do {
            System.out.println("Enter password:(must '$'/'%'/'_' & digit)");
            password =scanner.nextLine();
        }while (!isStrongPassword(password));
        return password;
    }
    private boolean isStrongPassword(String password){
        boolean isStrong=false;
        if (password.contains("$")||password.contains("%")||password.contains("_")) {
            for (int i = 0; i < password.length(); i++) {
                char currentChar = password.charAt(i);
                if (Character.isDigit(currentChar)) {
                    isStrong=true;
                    break;
                }
            }
        }else {
            System.out.println("Weak password. Try again!");
        }
        return isStrong;
    }
    private String phoneNumber(){
        Scanner scanner=new Scanner(System.in);
        String phoneNumber=null;
        do {
            System.out.println("Enter phone number: ");
            phoneNumber=scanner.nextLine();
        }while (!isProperPhoneNumber(phoneNumber));
        return phoneNumber;
    }
    private boolean isProperPhoneNumber(String phoneNumber){
        boolean isProper =false;
        if (phoneNumber.length()==10&& phoneNumber.charAt(0)=='0'
        &&phoneNumber.charAt(1)=='5'){
            for (int i =2;i<phoneNumber.length();i++){
                char currentChar= phoneNumber.charAt(i);
                if (!Character.isDigit(currentChar)){
                    isProper=false;
                    break;
                }else {
                    isProper=true;
                }
            }
        }
        if (!isProper){
            System.out.println("Invalid phone number!");
        }
        return isProper;
    }
    private boolean isMediator(){
        Scanner scanner=new Scanner(System.in);
        boolean isMediator=false;
        boolean run=false;
        int choose;
        while (!run) {
            System.out.println("1- Real estate broker: \n" +
                    "2- Regular user :");
            choose = scanner.nextInt();
            switch (choose) {
                case 1:
                    isMediator = true;
                    run=true;
                    break;
                case 2:
                    isMediator = false;
                    run=true;
                    break;
                default:
                    System.out.println("Invalid option!");
            }
        }
        return isMediator;
    }

    public User login(){
        Scanner scanner=new Scanner(System.in);
        User user=null;
        System.out.print("UserName: ");
        String userName=scanner.nextLine();
        System.out.print("Password: ");
        String password= scanner.nextLine();
        for (int i=0;i<this.users.length;i++){
            if (this.users[i].getUserName().equals(userName)&&this.users[i].getPassword().equals(password)){
                user=users[i];
            }
        }
        return user;
    }
    public void internalMenu(){
        System.out.println("1- Posting a new property: \n" +
                "2- Remove property posting: \n" +
                "3- View all property in the system: \n" +
                "4- View all self-posted properties: \n" +
                "5- Property search by parameters\n" +
                "6- Log out: ");
    }

    public void internalOptions(User user){
        Scanner scanner = new Scanner(System.in);
        boolean run = true;
        int choose;
        while (run) {
            internalMenu();
            choose=scanner.nextInt();
            switch (choose){
                case 1:
                    postNewProperty(user);
                    break;
                case 2:
                    break;
                case 3:
                    break;
                case 4:
                    break;
                case 5:
                    break;
                case 6:
                    System.out.println("Bye for now!");
                    run=false;
                    break;
                default:
                    System.out.println("Invalid option!");
            }
        }
    }
    private boolean postNewProperty(User user){

        return
    }
    private boolean


}
