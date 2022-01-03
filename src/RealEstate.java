import java.util.Scanner;

public class RealEstate {
    private User[] users;
    private Address[] addresses;
    private Property[] properties;

    private final int NO_TO_USE = -999, SIZE_ARRAY_ADDRESS = 10, START_ARRAY_SIZE = 0,
            POSTING_NEW_PROPERTY = 1, REMOVE_PROPERTY_POSTING = 2, VIEW_ALL_PROPERTY_IN_THE_SYSTEM = 3, VIEW_ALL_SELF_POSTED_PROPERTY = 4,
            PROPERTY_SEARCH_BY_PARAMETER = 5, LOG_OUT = 6, REAL_ESTATE_BROKER = 1, REGULAR_USER = 2, PHONE_NUMBER_LENGTH = 10,
            INDEX_ZERO_PHONE_NUMBER = 0, INDEX_ONE_PHONE_NUMBER = 1, MAX_POSTED_PROPERTIES_BROKER = 10, MAX_POSTED_PROPERTIES_REGULAR = 3,
            CHOOSE_REGULAR_APARTMENT = 1, CHOOSE_PENTHOUSE = 2, CHOOSE_PRIVATE_HOUSE = 3, FOR_RENT = 0, MIN_CHOOSE_OPTION = 1, CHOOSE_FO_RENT = 1,
            CHOOSE_FOR_SALE = 2, MINIMUM_ROOM_NUMBER = 0, MIN_PRICE = 0;


    public RealEstate() {
        Address address = new Address(null, null);
        this.users = new User[START_ARRAY_SIZE];
        this.addresses = new Address[SIZE_ARRAY_ADDRESS];
        for (int i = 0; i < this.addresses.length; i++) {
            addresses[i] = new Address(address.cityArray(i), address.streetArray(i));
        }
        this.properties = new Property[START_ARRAY_SIZE];
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

    public void createUser() {
        User[] newArray = new User[this.users.length + 1];
        for (int i = 0; i < this.users.length; i++) {
            newArray[i] = this.users[i];
        }
        User userToCreate = new User(createUserName(), password(), phoneNumber(), isMediator());
        newArray[this.users.length] = userToCreate;
        this.users = newArray;
    }

    private String createUserName() {
        Scanner scanner = new Scanner(System.in);
        String userName = null;
        do {
            System.out.println("Enter userName: ");
            userName = scanner.nextLine();
        } while (isUserNameExist(userName));
        return userName;
    }

    private boolean isUserNameExist(String userName) {
        boolean isExist = false;
        for (int i = 0; i < this.users.length; i++) {
            if (this.users[i].getUserName().equals(userName)) {
                isExist = true;
                System.out.println("UserName already exists! Try again!");
                break;
            }
        }
        return isExist;
    }

    private String password() {
        Scanner scanner = new Scanner(System.in);
        String password = null;
        do {
            System.out.println("Enter password:(must '$'/'%'/'_' & digit)");
            password = scanner.nextLine();
        } while (!isStrongPassword(password));
        return password;
    }

    private boolean isStrongPassword(String password) {
        boolean isStrong = false;
        if (password.contains("$") || password.contains("%") || password.contains("_")) {
            for (int i = 0; i < password.length(); i++) {
                char currentChar = password.charAt(i);
                if (Character.isDigit(currentChar)) {
                    isStrong = true;
                    break;
                }
            }
        } else {
            System.out.println("Weak password. Try again!");
        }
        return isStrong;
    }

    private String phoneNumber() {
        Scanner scanner = new Scanner(System.in);
        String phoneNumber = null;
        do {
            System.out.println("Enter phone number: ");
            phoneNumber = scanner.nextLine();
        } while (!isProperPhoneNumber(phoneNumber));
        return phoneNumber;
    }

    private boolean isProperPhoneNumber(String phoneNumber) {
        boolean isProper = false;
        if (phoneNumber.length() == PHONE_NUMBER_LENGTH && phoneNumber.charAt(INDEX_ZERO_PHONE_NUMBER) == '0'
                && phoneNumber.charAt(INDEX_ONE_PHONE_NUMBER) == '5') {
            for (int i = 2; i < phoneNumber.length(); i++) {
                char currentChar = phoneNumber.charAt(i);
                if (!Character.isDigit(currentChar)) {
                    isProper = false;
                    break;
                } else {
                    isProper = true;
                }
            }
        }
        if (!isProper) {
            System.out.println("Invalid phone number!");
        }
        return isProper;
    }

    private boolean isMediator() {
        Scanner scanner = new Scanner(System.in);
        boolean isMediator = false;
        boolean run = false;
        int choose;
        while (!run) {
            System.out.println("1- Real estate broker: \n" +
                    "2- Regular user :");
            choose = scanner.nextInt();
            switch (choose) {
                case REAL_ESTATE_BROKER:
                    isMediator = true;
                    run = true;
                    break;
                case REGULAR_USER:
                    isMediator = false;
                    run = true;
                    break;
                default:
                    System.out.println("Invalid option!");
            }
        }
        return isMediator;
    }

    public User login() {
        Scanner scanner = new Scanner(System.in);
        User user = null;
        System.out.print("UserName: ");
        String userName = scanner.nextLine();
        System.out.print("Password: ");
        String password = scanner.nextLine();
        for (int i = 0; i < this.users.length; i++) {
            if (this.users[i].getUserName().equals(userName) && this.users[i].getPassword().equals(password)) {
                user = users[i];
            }
        }
        return user;
    }

    public void internalMenu() {
        System.out.println("1- Posting a new property: \n" +
                "2- Remove property posting: \n" +
                "3- View all property in the system: \n" +
                "4- View all self-posted properties: \n" +
                "5- Property search by parameters\n" +
                "6- Log out: ");
    }

    public void internalOptions(User user) {
        Scanner scanner = new Scanner(System.in);
        boolean run = true;
        int choose;
        while (run) {
            internalMenu();
            choose = scanner.nextInt();
            switch (choose) {
                case POSTING_NEW_PROPERTY:
                    postNewProperty(user);
                    break;
                case REMOVE_PROPERTY_POSTING:
                    removeProperty(user);
                    break;
                case VIEW_ALL_PROPERTY_IN_THE_SYSTEM:
                    printAllProperties(this.properties);
                    break;
                case VIEW_ALL_SELF_POSTED_PROPERTY:
                    printAllUserProperties(user);
                    break;
                case PROPERTY_SEARCH_BY_PARAMETER:
                    search();
                    break;
                case LOG_OUT:
                    System.out.println("Bye for now!\n");
                    run = false;
                    break;
                default:
                    System.out.println("Invalid option!");
            }
        }
    }

    private boolean postNewProperty(User user) {
        boolean newProperty = false;
        if (!isCanPost(user)) {
            System.out.println("You have reached the posting limit!\n");
        } else {
            String cityName = chooseCity();
            if (cityName != null) {
                String streetName = chooseStreet(cityName);
                if (streetName != null) {
                    Address address = new Address(cityName, streetName);
                    addPropertyToArray(typeOfProperty(address, user));
                    newProperty = true;
                }
            }
        }
        return newProperty;
    }

    private boolean isCanPost(User user) {
        boolean canPost = true;
        int counter = 0;
        for (int i = 0; i < this.properties.length; i++) {
            if (user.equals(this.properties[i].getUserWhoPostedTheProperty())) {
                counter++;
            }
        }
        if (user.isMediatorOrRegular() && counter == MAX_POSTED_PROPERTIES_BROKER) {
            canPost = false;
        } else if (!user.isMediatorOrRegular() && counter >= MAX_POSTED_PROPERTIES_REGULAR) {
            canPost = false;
        }
        return canPost;
    }

    private String[] citiesName() {
        String[] cityArray = new String[this.addresses.length];
        int counter = this.addresses.length;
        int cityArrayIndex = 0;
        for (int i = 0; i < this.addresses.length; i++) {
            for (int j = i + 1; j < this.addresses.length; j++) {
                if (this.addresses[i].getCityName().equals(this.addresses[j].getCityName())) {
                    counter--;
                    break;
                } else if (j == this.addresses.length - 1) {
                    cityArray[cityArrayIndex] = this.addresses[i].getCityName();
                    cityArrayIndex++;
                }
            }
            if (i == this.addresses.length - 1) {
                cityArray[cityArrayIndex] = this.addresses[i].getCityName();
            }

        }
        String[] newCityArray = new String[counter];
        for (int i = 0; i < newCityArray.length; i++) {
            newCityArray[i] = cityArray[i];
            System.out.println(newCityArray[i]);
        }
        return newCityArray;
    }

    private String chooseCity() {
        Scanner scanner = new Scanner(System.in);
        boolean isEqual = false;
        System.out.println("Choose city: ");
        String[] cityArray = citiesName();
        String cityName = scanner.nextLine();
        for (int i = 0; i < cityArray.length; i++) {
            if (cityName.equals(cityArray[i])) {
                isEqual = true;
                break;
            }
        }
        if (!isEqual) {
            System.out.println("This city name is not in the list.");
            cityName = null;
        }
        return cityName;
    }

    private String[] streetName(String cityName) {
        String[] streetName = new String[this.addresses.length];
        int counter = 0;
        int indexStreetName = 0;
        for (int i = 0; i < this.addresses.length; i++) {
            if (cityName.equals(this.addresses[i].getCityName())) {
                streetName[indexStreetName] = this.addresses[i].getStreetName();
                indexStreetName++;
                counter++;
            }
        }
        String[] newStreetName = new String[counter];
        for (int i = 0; i < newStreetName.length; i++) {
            newStreetName[i] = streetName[i];
            System.out.println(streetName[i]);
        }
        return newStreetName;
    }

    private String chooseStreet(String cityName) {
        Scanner scanner = new Scanner(System.in);
        boolean isEqual = false;
        System.out.println("Choose street: ");
        String[] streets = streetName(cityName);
        String streetName = scanner.nextLine();
        for (int i = 0; i < streets.length; i++) {
            if (streetName.equals(streets[i])) {
                isEqual = true;
                break;
            }
        }
        if (!isEqual) {
            System.out.println("This street name is not in the list.");
            streetName = null;
        }
        return streetName;
    }

    private Property typeOfProperty(Address address, User user) {
        Scanner scanner = new Scanner(System.in);
        int choose;
        String typeOfProperty = null;
        int floorNumber = 0;
        boolean privateOrApartment = false;
        do {
            System.out.println("1- Regular apartment. \n" +
                    "2- Penthouse. \n" +
                    "3- Private house.");
            choose = scanner.nextInt();
            if (choose == CHOOSE_REGULAR_APARTMENT || choose == CHOOSE_PENTHOUSE) {
                privateOrApartment = true;
                if (choose == CHOOSE_REGULAR_APARTMENT) {
                    typeOfProperty = "Regular apartment";
                } else {
                    typeOfProperty = "Penthouse";
                }
                do {
                    System.out.println("Choose floor:");
                    floorNumber = scanner.nextInt();
                }while (floorNumber<0);
            } else if (choose == CHOOSE_PRIVATE_HOUSE) {
                typeOfProperty = "Private house";
            }
        } while (choose < CHOOSE_REGULAR_APARTMENT || choose > CHOOSE_PRIVATE_HOUSE);
        int numOfRooms;
        do {
            System.out.println("Number of rooms:");
            numOfRooms = scanner.nextInt();
        }while (numOfRooms<0);
        int houseNumber;
        do {
            System.out.println("House number");
            houseNumber = scanner.nextInt();
        }while (houseNumber<0);
        System.out.println("0-For rent:\nOther number-For sale:");
        int option = scanner.nextInt();
        boolean forRent;
        if (option == FOR_RENT) {
            forRent = true;
        } else {
            forRent = false;
        }
        int price;
        do{
            System.out.println("Price:");
            price = scanner.nextInt();
        }while (price<0);
        Property property = new Property(address, numOfRooms, price, typeOfProperty, privateOrApartment, forRent, houseNumber, floorNumber, user);
        return property;
    }

    private void addPropertyToArray(Property property) {
        Property[] newArray = new Property[this.properties.length + 1];
        for (int i = 0; i < this.properties.length; i++) {
            newArray[i] = this.properties[i];
        }
        newArray[this.properties.length] = property;
        this.properties = newArray;
    }

    private void removeProperty(User user) {
        int numberOfOwnedProperties = printAllUserProperties(user);
        if (numberOfOwnedProperties != 0) {
            choosePropertyToRemove(user, numberOfOwnedProperties);
        }
    }

    private int printAllUserProperties(User user) {
        int counter = 0;
        for (int i = 0; i < this.properties.length; i++) {
            if (user.equals(this.properties[i].getUserWhoPostedTheProperty())) {
                counter++;
                System.out.println(counter + ".\n" + properties[i] + "\n");
            }
        }
        if (counter == 0) {
            System.out.println("There are no user-owned properties.\n");
        }
        return counter;
    }

    private void choosePropertyToRemove(User user, int numberOfOwnedProperties) {
        Scanner scanner = new Scanner(System.in);
        int propertyToRemove;
        do {
            System.out.println("Choose property to remove: ");
            propertyToRemove = scanner.nextInt();
        } while (propertyToRemove < MIN_CHOOSE_OPTION || propertyToRemove > numberOfOwnedProperties);
        int counter = 0;
        for (int i = 0; i < this.properties.length; i++) {
            if (user.equals(this.properties[i].getUserWhoPostedTheProperty())) {
                counter++;
                if (propertyToRemove == counter) {
                    this.properties = removePropertyFromArray(this.properties[i], this.properties);
                    System.out.println("The selected property was deleted.\n");
                }
            }
        }
    }

    private void printAllProperties(Property[] properties1) {
        if (properties1.length == 0) {
            System.out.println("There are no properties in the system.\n");

        } else {
            for (int i = 0; i < properties1.length; i++) {
                System.out.println(i + 1 + ".\n" + properties1[i] + "\n");
            }
        }
    }

    private Property[] search() {
        Scanner scanner = new Scanner(System.in);
        Property[] searchArray = this.properties;
        int choose;
        int minPrice;
        int maxPrice;
        do {
            System.out.println("1- For Rent:\n2- For Sale\n -999 - For ignore.");
            choose = scanner.nextInt();
        } while ((choose < CHOOSE_FO_RENT || choose > CHOOSE_FOR_SALE) && choose != NO_TO_USE);
        if (choose == CHOOSE_FO_RENT) {
            for (int i = 0; i < searchArray.length; i++) {
                if (!searchArray[i].isForRent()) {
                    searchArray = removePropertyFromArray(searchArray[i], searchArray);
                    i--;
                }
            }
        } else if (choose == CHOOSE_FOR_SALE) {
            for (int i = 0; i < searchArray.length; i++) {
                if (searchArray[i].isForRent()) {
                    searchArray = removePropertyFromArray(searchArray[i], searchArray);
                    i--;
                }
            }
        }
        do {
            System.out.println("1- Regular apartment. \n" +
                    "2- Penthouse. \n" +
                    "3- Private house.\n-999 - For ignore.");
            choose = scanner.nextInt();
        } while ((choose < CHOOSE_REGULAR_APARTMENT || choose > CHOOSE_PRIVATE_HOUSE) && choose != NO_TO_USE);
        if (choose == CHOOSE_REGULAR_APARTMENT) {
            for (int i = 0; i < searchArray.length; i++) {
                if (!searchArray[i].getTypeOfProperty().equals("Regular apartment")) {
                    searchArray = removePropertyFromArray(searchArray[i], searchArray);
                    i--;
                }
            }
        } else if (choose == CHOOSE_PENTHOUSE) {
            for (int i = 0; i < searchArray.length; i++) {
                if (!searchArray[i].getTypeOfProperty().equals("Penthouse")) {
                    searchArray = removePropertyFromArray(searchArray[i], searchArray);
                    i--;
                }
            }
        } else if (choose == CHOOSE_PRIVATE_HOUSE) {
            for (int i = 0; i < searchArray.length; i++) {
                if (!searchArray[i].getTypeOfProperty().equals("Private house")) {
                    searchArray = removePropertyFromArray(searchArray[i], searchArray);
                    i--;
                }
            }
        }
        do {
            System.out.println("Number of rooms:\n-999 - For ignore. ");
            choose = scanner.nextInt();
        } while (choose <= MINIMUM_ROOM_NUMBER && choose != NO_TO_USE);
        if (choose != NO_TO_USE) {
            for (int i = 0; i < searchArray.length; i++) {
                if (choose != searchArray[i].getNumOfRooms()) {
                    searchArray = removePropertyFromArray(searchArray[i], searchArray);
                    i--;
                }
            }
        }
        System.out.println("Price range(min-max):\n-999 - For ignore.");
        do {
            System.out.print("Minimum price: ");
            minPrice = scanner.nextInt();
            System.out.print("Maximum price: ");
            maxPrice = scanner.nextInt();
        } while (((maxPrice < MIN_PRICE || minPrice < MIN_PRICE) && (maxPrice != NO_TO_USE && minPrice != NO_TO_USE)) || ((maxPrice < minPrice)&&maxPrice!=NO_TO_USE));
        if (minPrice != NO_TO_USE && maxPrice != NO_TO_USE) {
            for (int i = 0; i < searchArray.length; i++) {
                if (searchArray[i].getPrice() < minPrice || searchArray[i].getPrice() > maxPrice) {
                    searchArray = removePropertyFromArray(searchArray[i], searchArray);
                    i--;
                }
            }
        }
        printAllProperties(searchArray);

        return searchArray;

    }

    private Property[] removePropertyFromArray(Property property, Property[] properties) {
        Property[] newArray = new Property[properties.length - 1];
        int newArrayIndex = 0;
        for (int i = 0; i < properties.length; i++) {
            if (property != properties[i]) {
                newArray[newArrayIndex] = properties[i];
                newArrayIndex++;
            }
        }
        return newArray;
    }

}
