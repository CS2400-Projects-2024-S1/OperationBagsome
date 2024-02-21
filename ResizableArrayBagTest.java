import java.util.Arrays;
import java.util.Iterator;

public class ResizableArrayBagTest {
    public static void main(String[] args) {
        ResizableArrayBag<String> bag = new ResizableArrayBag<>();
        
        // isEmpty Check
        System.out.println(bag.isEmpty() ? "Bag is Empty" : "Bag is Not Empty");
        
        // Initialize Bag
        String[] itemsToAdd = {"A", "D", "B", "A", "C", "A", "D"};
        for (String item : itemsToAdd) {
            bag.add(item);
        }

        // isEmpty Check
        System.out.println(bag.isEmpty() ? "Bag is Empty" : "Bag is Not Empty");

        System.out.println("Items should be added: " + Arrays.toString(itemsToAdd));
        System.out.println("The bag contains " + bag.getCurrentSize() + " items as following:");
        bag.forEach((x) -> System.out.print(x + " "));
        
        String[] testItems = {"A", "B", "C", "D", "Z"};
        for (String item : testItems) {
            System.out.println("Does this bag contain " + item + "? " + bag.contains(item));
            System.out.println("The count of " + item + " in this bag has " + bag.getFrequencyOf(item) + "\n");
        }
        
        System.out.println("\nRemoving a string from the bag:");
        System.out.println("remove() returns " + bag.remove());
        System.out.println("The bag contains " + bag.getCurrentSize() + " string(s), as follows:");
        System.out.println(Arrays.toString(bag.toArray()));

        String[] itemsToRemove = {"B", "A", "C", "Z"};
        for (String item : itemsToRemove) {
            System.out.println("\nRemoving \"" + item + "\" from the bag:");
            System.out.println("remove(\"" + item + "\") returns " + bag.remove(item));
            System.out.println("The bag contains " + bag.getCurrentSize() + " string(s), as follows:");
            System.out.println(Arrays.toString(bag.toArray()));
        }
        
        // // Clearing the bag
        // System.out.println("\nClearing the bag:");
        // assert bag.isEmpty() : "isEmpty finds the bag empty: OK.";
        // System.out.println("The bag contains " + bag.getCurrentSize() + " string(s), as follows:");
        // System.out.println(Arrays.toString(bag.toArray()));
    }
}
