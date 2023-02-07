import java.io.FileNotFoundException;
import java.util.List;
import java.util.Scanner;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import java.util.jar.JarOutputStream;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * Tests the functioinality of the various methods and code in DisneyParkFrontend
 *
 * @author Haniel Alva
 */
public class FrontendDeveloperTests {

    Scanner userInputScanner;
    DisneyParkFrontend frontend;
    DisneyParkBackendFD backend;

    /**
     * BeforeEach is empty as the TextUITester needs to be initialized before the scanner and front end and back end
     * objects to work as intended. Each test case has different inputs for TextUITester.
     *
     */
    @BeforeEach
    public void setupUI(){
    }

    /**
     * Tests whether the program header and menu is output as intended
     */
    @Test
    public void Test1(){
        TextUITester tester = new TextUITester("6\n");
        Scanner userInputScanner = new Scanner(System.in);
        DisneyParkBackendFD backend = new DisneyParkBackendFD();
        DisneyParkFrontend frontend = new DisneyParkFrontend(userInputScanner, backend);
        frontend.runCommandLoop();
        String output = tester.checkOutput();
        assertTrue(output.contains("Welcome to DisneyWorld!\n" +
                "x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-\n" +
                "\n" +
                "\n" +
                "       1. Enter your current location\n" +
                "       2. Enter your destination\n" +
                "       3. Find nearest bathroom\n" +
                "       4. Find nearest food truck\n" +
                "       5. Show all attractions and facilities\n" +
                "       6. Exit"));
    }

    /**
     * Tests whether the program recognises invalid input and whether it closes as given the correct input as intended
     */
    @Test
    public void Test2(){
        TextUITester tester = new TextUITester("12\n6\n");
        Scanner userInputScanner = new Scanner(System.in);
        DisneyParkBackendFD backend = new DisneyParkBackendFD();
        DisneyParkFrontend frontend = new DisneyParkFrontend(userInputScanner, backend);
        frontend.runCommandLoop();
        String output = tester.checkOutput();
        assertTrue(output.contains("Not a valid option. Please try again!"));
        assertTrue(output.contains("Goodbye!"));
    }

    /**
     * Tests whether the program prints out the list of all the attractions and facilities in the park properly
     */
    @Test
    public void Test3(){
        TextUITester tester = new TextUITester("5\n6\n");
        Scanner userInputScanner = new Scanner(System.in);
        DisneyParkBackendFD backend = new DisneyParkBackendFD();
        DisneyParkFrontend frontend = new DisneyParkFrontend(userInputScanner, backend);
        frontend.runCommandLoop();
        String output = tester.checkOutput();
        assertTrue(output.contains("The list of all the attractions and facilities:\n" +
                "1. AnimalKingdom\n" +
                "2. GalaxysEdge\n" +
                "3. Bathroom1"));
    }

    /**
     * Tests whether the program takes in input for a valid location as intended and whether the program displays
     * the correct error message if input location is invalid.
     */
    @Test
    public void Test4(){
        TextUITester tester = new TextUITester("1\ngalaxysedge\n1\nbruh\n6\n");
        Scanner userInputScanner = new Scanner(System.in);
        DisneyParkBackendFD backend = new DisneyParkBackendFD();
        DisneyParkFrontend frontend = new DisneyParkFrontend(userInputScanner, backend);
        frontend.runCommandLoop();
        String output = tester.checkOutput();
        assertTrue(output.contains("Your current location is now: galaxysedge"));
        assertTrue(output.contains("Sorry, the location you input was invalid"));
    }

    /**
     * Tests whether the program takes in input for a valid destination as intended and whether the program displays
     * the correct error message if input destination is invalid.
     */
    @Test
    public void Test5(){
        TextUITester tester = new TextUITester("1\ngalaxysedge\n2\nbruh\n2\nanimalkingdom\n6\n");
        Scanner userInputScanner = new Scanner(System.in);
        DisneyParkBackendFD backend = new DisneyParkBackendFD();
        DisneyParkFrontend frontend = new DisneyParkFrontend(userInputScanner, backend);
        frontend.runCommandLoop();
        String output = tester.checkOutput();
        assertTrue(output.contains("Sorry, the destination you input was invalid"));
        assertTrue(output.contains("Your current destination is now: animalkingdom"));
        assertTrue(output.contains("The distance from your current location is: " + "placeholder" + "m"));
    }

    /**
     * Tests whether the program displays the correct error message if destination is input before location
     */
    @Test
    public void Test6Integration(){
        TextUITester tester = new TextUITester("2\nanimalkingdom\n6\n");
        Scanner userInputScanner = new Scanner(System.in);
        DisneyParkBackendFD backend = new DisneyParkBackendFD();
        DisneyParkFrontend frontend = new DisneyParkFrontend(userInputScanner, backend);
        frontend.runCommandLoop();
        String output = tester.checkOutput();
        assertTrue(output.contains("Input current location before destination"));
    }

    /**
     * Tests whether the program takes in input for 2 valid locations and then a valid destination as intended.
     */
    @Test
    public void Test7Integration(){
        TextUITester tester = new TextUITester("1\ngalaxysedge\n1\nanimalkingdom\n2\ngalaxysedge\n6\n");
        Scanner userInputScanner = new Scanner(System.in);
        DisneyParkBackendFD backend = new DisneyParkBackendFD();
        DisneyParkFrontend frontend = new DisneyParkFrontend(userInputScanner, backend);
        frontend.runCommandLoop();
        String output = tester.checkOutput();
        assertTrue(output.contains("Your current location is now: galaxysedge"));
        assertTrue(output.contains("Your current location is now: animalkingdom"));
        assertTrue(output.contains("Your current destination is now: galaxysedge"));
    }


}