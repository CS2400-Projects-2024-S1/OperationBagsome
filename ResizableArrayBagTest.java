import java.util.Arrays;

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
        
        // getFrequencyOf() 
        String[] testItems = {"A", "B", "C", "D", "Z"};
        for (String item : testItems) {
            System.out.println("Does this bag contain " + item + "? " + bag.contains(item));
            System.out.println("The count of " + item + " in this bag has " + bag.getFrequencyOf(item) + "\n");
        }
        
        // remove()
        System.out.println("\nRemoving a string from the bag:");
        System.out.println("remove() returns " + bag.remove());
        System.out.println("The bag contains " + bag.getCurrentSize() + " string(s), as follows:");
        bag.forEach((x) -> System.out.print(x + " "));

        // remove(item)
        String[] itemsToRemove = {"B", "A", "C", "Z"};
        for (String item : itemsToRemove)
            bag.remove(item);
        System.out.println("\nThe bag contains " + bag.getCurrentSize() + " string(s), as follows:");
        bag.forEach((x) -> System.out.print(x + " "));
        
    }
}
