/**
 * Java class placeholder for the Attraction object in the Disney Park
 *
 * @author Haniel Alva
 */

public class AttractionFD implements IAttraction{

    String name;
    String type;

    public AttractionFD(String name, String type){
        this.name = name;
        this.type = type;
    }

    /**
     * Returns the name of the attraction
     *
     * @return String of name of attraction
     */
    @Override
    public String getName() {
        return this.name;
    }

    /**
     * Returns the attraction type (ride, food, or bathroom)
     *
     * @return String of type of attraction
     */
    @Override
    public String getType() {
        return this.type;
    }
}
