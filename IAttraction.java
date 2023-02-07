/**
 * Interface for the Attraction object
 *
 * @author Anton Gurevich
 */
public interface IAttraction {
    /**
     * Returns the name of the attraction
     *
     * @return String of name of attraction
     */
    String getName();

    /**
     * Returns the attraction type (ride, food, or bathroom)
     *
     * @return String of type of attraction
     */
    String getType();

    /**
     * Returns a string representing the Attraction. i.e. "Castaway Creek (Ride)"
     *
     * @return String of the attraction's name and type
     */
    @Override
    String toString();
}
