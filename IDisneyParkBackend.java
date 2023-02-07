import java.util.Arrays;

/**
 * Interface to set up the backend portion of DisneyParkBackend.java
 *
 * @author Henry Burke
 */
public interface IDisneyParkBackend {

    /**
     * Sets the visitor's current location to a given attraction, bathroom, or food truck.
     *
     * @param currLocation current location given by frontend
     */
    public void setCurrentLocation(String currLocation);

    /**
     * Sets the visitor's desired location to a given attraction, bathroom, or food truck.
     *
     * @param destination the visitor's desired location given by frontend
     */
    public void setDestination(String destination);

    /**
     * Finds the closest bathroom to the visitor's current location.
     */
    public void closestBathroom();

    /**
     * Finds the closest food truck to the visitor's current location.
     */
    public void closestFoodTruck();

    /**
     * Returns an array of all the attractions available in the Disney Park.
     *
     * @return array of all attractions in park.
     */
    public IAttraction[] printAttractions();
}

