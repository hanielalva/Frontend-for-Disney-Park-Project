import java.util.ArrayList;
import java.util.Arrays;

/**
 * Backend placeholder for the Frontend of the Dinsey Park project
 *
 * @author Haniel Alva
 */
public class DisneyParkBackendFD implements IDisneyParkBackend{

    private String currLocation;
    private String destination;

    /**
     * Gets the visitor's current location
     */
    public String getCurrentLocation() {
        return this.currLocation;
    }

    /**
     * Gets the visitor's destination
     */
    public String getCurrentDestination() {
        return this.destination;
    }

    /**
     * Sets the visitor's current location to a given attraction, bathroom, or food truck.
     *
     * @param currLocation current location given by frontend
     */
    @Override
    public void setCurrentLocation(String currLocation) {
        this.currLocation = "placeholder";
        System.out.println();
    }

    /**
     * Sets the visitor's desired location to a given attraction, bathroom, or food truck.
     *
     * @param destination the visitor's desired location given by frontend
     */
    @Override
    public void setDestination(String destination) {
        System.out.println();
    }

    /**
     * Finds the closest bathroom to the visitor's current location.
     */
    @Override
    public void closestBathroom() {
        System.out.println();
    }

    /**
     * Finds the closest food truck to the visitor's current location.
     */
    @Override
    public void closestFoodTruck() {
        System.out.println();
    }

    /**
     * Returns an array of all the attractions available in the Disney Park.
     *
     * @return array of all attractions in park.
     */
    @Override
    public AttractionFD[] printAttractions() {
        AttractionFD attraction1 = new AttractionFD("AnimalKingdom", "Ride");
        AttractionFD attraction2 = new AttractionFD("GalaxysEdge", "Ride");
        AttractionFD attraction3 = new AttractionFD("Bathroom1", "Bathroom");
        AttractionFD[] locations = new AttractionFD[]{ attraction1, attraction2, attraction3};
        return locations;
    }
}

