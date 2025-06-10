import java.io.*; 
import java.util.*; 
 
// Interface declaration - defines a contract with a display() method 
interface AffirmationInterface { 
    void display(); // Method to be implemented by any class that implements this interface 
} 
 
// Base class to handle file reading functionality 
class BaseLoader { 
    // Method to load affirmations from a text file 
    public List<String> loadAffirmations(String filename) throws IOException { 
        List<String> list = new ArrayList<>(); // To store each line from the file 
        // Modify this line in BaseLoader class
    BufferedReader br = new BufferedReader(new FileReader("C:\\Users\\RIDDHI KULKARNI\\Downloads\\Affrimationapp\\affirmations.txt"));// Open file
 
        String line; 
        while ((line = br.readLine()) != null) { 
            list.add(line.trim()); // Trim and add each line to the list 
        } 
        br.close(); // Close the file reader 
        return list; // Return the list of affirmations 
    } 
} 
 
// Derived class that inherits from BaseLoader and implements AffirmationInterface 
class AffirmationDisplay extends BaseLoader implements AffirmationInterface { 
    private List<String> affirmations; // To store loaded affirmations 
 
    // Constructor that loads affirmations from file using inherited method 
    public AffirmationDisplay(String filename) throws IOException { 
        this.affirmations = loadAffirmations(filename); 
    } 
 
    // Override the display method to show a random affirmation 
    @Override 
    public void display() { 
        if (affirmations.isEmpty()) { 
            System.out.println("No affirmations to display."); 
        } else { 
            int index = new Random().nextInt(affirmations.size()); // Random index 
            System.out.println("\nAffirmation: " + affirmations.get(index)); // Display 
        } 
    } 
} 
 
// Main class where the application starts 
public class AffirmationGenerator { 
    public static void main(String[] args) { 
        Scanner scanner = new Scanner(System.in); // To take user input 
        try { 
            // Create an object of the AffirmationDisplay class and load affirmations 
            AffirmationDisplay obj = new AffirmationDisplay("affirmations.txt"); 
 
            int choice; 
            // Show menu until user chooses to exit 
            do { 
                System.out.println("\n===== Affirmation Generator Menu ====="); 
                System.out.println("1. Show a Random Affirmation"); 
                System.out.println("2. Exit"); 
                System.out.print("Enter your choice: "); 
                choice = scanner.nextInt(); 
 
                // Perform action based on user choice 
                switch (choice) { 
                    case 1: 
                        obj.display(); // Show random affirmation 
                        break; 
                    case 2: 
                        System.out.println("Goodbye! Stay positive "); 
                        break; 
                    default: 
                        System.out.println("Invalid choice. Please select 1 or 2."); 
                } 
            } while (choice != 2); // Loop ends when user chooses Exit 
 
        } catch (FileNotFoundException e) { 
            System.out.println("File not found. Please make sure 'affirmations.txt' exists."); 
        } catch (IOException e) { 
            System.out.println("Error reading the file."); 
        } catch (Exception e) { 
            System.out.println("Something went wrong: " + e.getMessage()); 
        } finally { 
            scanner.close(); // Always close the scanner to free resources 
        } 
    } 
}
