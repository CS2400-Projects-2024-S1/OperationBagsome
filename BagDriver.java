import java.util.Arrays;

public class BagDriver {
    public static void main(String[] args) {
       
        // Testing ResizableArrayBag
        System.out.println("Testing ResizableArrayBag:");
        ResizableArrayBag<String> resizableBag = new ResizableArrayBag<>();
        testResizableArrayBag(resizableBag);
        
        // Testing LinkedBag
        System.out.println("\nTesting LinkedBag:");
        LinkedBag<Integer> linkedBag = new LinkedBag<>();
        testLinkedBag(linkedBag);
    }
    
    public static void testResizableArrayBag(ResizableArrayBag<String> bag) {
        // Add items to the bag
        String[] itemsToAdd = {"A", "D", "B", "A", "C", "A", "D"};
        for (String item : itemsToAdd) {
            bag.add(item);
        }
        
        // Print bag contents
        System.out.println("Bag contents: " + Arrays.toString(bag.toArray()));
        
        // Test frequency
        System.out.println("Frequency of 'A': " + bag.getFrequencyOf("A"));
    }
    
    public static void testLinkedBag(LinkedBag<Integer> bag) {
        // Add item to the bag
        bag.add(4);
        
        // Print bag contents
        System.out.println("Bag contents: " + Arrays.toString(bag.toArray()));
        
        // Test if bag is empty 
        System.out.println("Is bag empty? " + bag.isEmpty());
    }
}
