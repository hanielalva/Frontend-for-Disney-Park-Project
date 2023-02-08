/**
 * This interface defines methods to display the user interface of the program
 * and control all front end functionality
 *
 * @author Haniel Alva & Sreyas Srivastava
 */
public interface IDisneyParkFrontend {

    /**
     * This method runs the command loop for the front end, and will terminate when
     * the user exits the application
     */
    public void runCommandLoop();

    /**
     * This method displays the main menu of the application
     */
    public void displayMainMenu();

    /**
     * This method allows the user to choose their current location from a list of
     * locations in the theme park
     */
    public void chooseCurrentLocation();

    /**
     * This method allows the user to choose their destination from a list of
     * locations in the theme park
     */
    public void chooseDestination();

    /**
     * This method allows the user to find the nearest bathroom based on their
     * current location
     */
    public void findBathroom();

    /**
     * This method allows the user to find the nearest food truck based on their
     * current location
     */
    public void findFoodTruck();

    /**
     * This methods displays a list of all the attractions and facilities in the
     * theme park
     */
    public void displayAttractions();

}
