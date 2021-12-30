import java.util.Scanner;
public class Main {

    public static final int REGISTER=1, LOGIN=2, FINISH_THE_PROGRAM=3;

    public static void main(String[] args) {
        chooseOption();
    }
    public static void printMenu() {
        System.out.println("1- Register: \n2- Sign in: \n3- Finish the program:");
    }

    public static void chooseOption() {
        RealEstate realEstate=new RealEstate();
        Scanner scanner = new Scanner(System.in);
        boolean run = true;
        int choose;
        while (run) {
            printMenu();
            choose = scanner.nextInt();
            switch (choose) {
                case REGISTER:
                    realEstate.createUser();
                    break;
                case LOGIN:
                    User user=realEstate.login();
                    if (user==null){
                        System.out.println("Invalid User");
                    }else {
                        realEstate.internalOptions(user);
                    }
                    break;
                case FINISH_THE_PROGRAM:
                    System.out.println("GoodBye!");
                    run=false;
                    break;
                default:
                    System.out.println("Invalid option");
            }
        }
    }
}
