import java.util.Scanner;

public class Main {
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
                case 1:
                    realEstate.createUser();
                    break;
                case 2:
                    realEstate.login();
                    break;
                case 3:
                    System.out.println("GoodBye!");
                    run=false;
                    break;
                default:
                    System.out.println("Invalid option");
            }
        }
    }
}
