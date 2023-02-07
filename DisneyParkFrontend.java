import java.util.Scanner;

/**
 * Creates the Frontend for users to interact with for the DisneyPark application and its functions
 *
 * @author Haniel Alva
 */
public class DisneyParkFrontend implements IDisneyParkFrontend{

    public String welcomeMessage = ("Welcome to DisneyWorld!\n" +
            "x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-");
    private Scanner userInputScanner = new Scanner(System.in);
    private DisneyParkBackendFD backend ;
    private CS400Graph graph;

    /**
     * The constructor that the implementation this interface will
     * provide. It takes the Scanner that will read user input as
     * a parameter as well as the backend.
     */
    public DisneyParkFrontend (Scanner userInputScanner, DisneyParkBackendFD backend){
        this.userInputScanner = userInputScanner;
        this.backend = backend;
    }

    /**
     * This method runs the command loop for the front end, and will terminate when
     * the user exits the application
     */
    @Override
    public void runCommandLoop() {
        System.out.println(welcomeMessage);
        String userInput;
        boolean runLoop = true;
        while(runLoop){
            System.out.println("\n");
            displayMainMenu();
            userInput = userInputScanner.next();
            switch(userInput){
                case "1":
                    System.out.println("Choose your current location from the list:");
                    chooseCurrentLocation();
                    break;
                case "2":
                    System.out.println("Choose your destination from the list:");
                    chooseDestination();
                    break;
                case "3":
                    System.out.println("The closest bathroom is:");
                    findBathroom();
                case "4":
                    System.out.println("The closest food truck is:");
                    findFoodTruck();
                case "5":
                    displayAttractions();
                case "6":
                    System.out.println("Goodbye!");
                    runLoop = false;
                    break;
                default:
                    System.out.println("Not a valid option. Please try again!\n");
                    break;
            }
        }
    }

    /**
     * This method displays the main menu of the application
     */
    @Override
    public void displayMainMenu() {
        String menuText =(
                "       1. Enter your current location\n" +
                        "       2. Enter your destination\n" +
                        "       3. Find nearest bathroom\n" +
                        "       4. Find nearest food truck\n" +
                        "       5. Show all attractions and facilities\n" +
                        "       6. Exit\n");
        System.out.println(menuText);
    }

    /**
     * This method allows the user to choose their current location from a list of
     * locations in the theme park
     */
    @Override
    public void chooseCurrentLocation() {
        String inputLocation = userInputScanner.next();
        for (int i = 0; i < backend.printAttractions().length; i++) {
            if (backend.printAttractions()[i].getName().equalsIgnoreCase(inputLocation)){
                backend.setCurrentLocation(backend.printAttractions()[i].getName());
                System.out.println("Your current location is now: " + inputLocation);
                break;
            }
        }
        System.out.println("Sorry, the location you input was invalid");
    }

    /**
     * This method allows the user to choose their destination from a list of
     * locations in the theme park
     */
    @Override
    public void chooseDestination() {
        if(backend.getCurrentLocation() != null ){
            String inputDestination = userInputScanner.next();
            for (int i = 0; i < backend.printAttractions().length; i++) {
                if (backend.printAttractions()[i].getName().equalsIgnoreCase(inputDestination)){
                    backend.setDestination(backend.printAttractions()[i].getName());
                    System.out.println("Your current destination is now: " + inputDestination);
                    System.out.println("The distance from your current location is: " + "placeholder" + "m");
                    break;
                }
            }
            System.out.println("Sorry, the destination you input was invalid");
        }else{
            System.out.println("Input current location before destination");
        }
    }

    /**
     * This method allows the user to find the nearest bathroom based on their
     * current location
     */
    @Override
    public void findBathroom() {
        System.out.print("The nearest bathroom is: ");
        backend.closestBathroom();
    }

    /**
     * This method allows the user to find the nearest food truck based on their
     * current location
     */
    @Override
    public void findFoodTruck() {
        System.out.print("The nearest food truck is: ");
        backend.closestFoodTruck();
    }

    /**
     * This methods displays a list of all the attractions and facilities in the
     * theme park
     */
    @Override
    public void displayAttractions() {
        for (int i = 0; i < backend.printAttractions().length; i++) {
            if (i == 0){
                System.out.println("The list of all the attractions and facilities:");
            }
            System.out.println((i + 1) + ". " + backend.printAttractions()[i].getName());
        }
    }
}

