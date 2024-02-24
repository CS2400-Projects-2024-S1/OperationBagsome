public class BagDriver {
    public static void main(String[] args) {
        LinkedBagDemo();
        ResizableArrayBagDemo();
        BagInteroperabilityDemo();
    }

    public static void LinkedBagDemo() {
        System.out.println("\n\nLinkedBagDemo");
        // Create two bags
        LinkedBag<Integer> bag1 = new LinkedBag<>();
        LinkedBag<Integer> bag2 = new LinkedBag<>();

        // Adding elements to the first bag
        bag1.add(1);
        bag1.add(2);
        bag1.add(3);
        bag1.add(4);

        // Adding elements to the second bag
        bag2.add(3);
        bag2.add(4);
        bag2.add(5);
        bag2.add(6);

        // Display original bags
        System.out.println("Bag 1: ");
        bag1.forEach((x)-> System.out.print(x + " "));
        System.out.println("\nBag 2: ");
        bag2.forEach((x)-> System.out.print(x + " "));

        // Demonstrate union
        System.out.println("\nUnion:");
        BagInterface<Integer> union = bag1.union(bag2);
        union.forEach((x) -> System.out.print(x + " "));

        // Demonstrate intersection
        System.out.println("\nIntersection:");
        BagInterface<Integer> intersection = bag1.intersection(bag2);
        intersection.forEach((x) -> System.out.print(x + " "));

        // Demonstrate difference
        System.out.println("\nDifference:");
        BagInterface<Integer> difference = bag1.difference(bag2);
        difference.forEach((x) -> System.out.print(x + " "));

        // Demonstrate that bags are unchanged
        System.out.println("\nEnding Bag 1: ");
        bag1.forEach((x)-> System.out.print(x + " "));
        System.out.println("\nEnding Bag 2: ");
        bag2.forEach((x)-> System.out.print(x + " "));

    }

    public static void ResizableArrayBagDemo() {
        System.out.println("\n\n------------------------------\nResizableArrayBagDemo");
        // Create two bags
        ResizableArrayBag<Integer> bag1 = new ResizableArrayBag<>();
        ResizableArrayBag<Integer> bag2 = new ResizableArrayBag<>();

        // Adding elements to the first bag
        bag1.add(1);
        bag1.add(2);
        bag1.add(3);
        bag1.add(4);

        // Adding elements to the second bag
        bag2.add(3);
        bag2.add(4);
        bag2.add(5);
        bag2.add(6);

        // Display original bags
        System.out.println("Bag 1: ");
        bag1.forEach((x)-> System.out.print(x + " "));
        System.out.println("\nBag 2: ");
        bag2.forEach((x)-> System.out.print(x + " "));

        // Demonstrate union
        System.out.println("\nUnion:");
        BagInterface<Integer> union = bag1.union(bag2);
        union.forEach((x) -> System.out.print(x + " "));

        // Demonstrate intersection
        System.out.println("\nIntersection:");
        BagInterface<Integer> intersection = bag1.intersection(bag2);
        intersection.forEach((x) -> System.out.print(x + " "));

        // Demonstrate difference
        System.out.println("\nDifference:");
        BagInterface<Integer> difference = bag1.difference(bag2);
        difference.forEach((x) -> System.out.print(x + " "));

        // Demonstrate that bags are unchanged
        System.out.println("\nEnding Bag 1: ");
        bag1.forEach((x)-> System.out.print(x + " "));
        System.out.println("\nEnding Bag 2: ");
        bag2.forEach((x)-> System.out.print(x + " "));

     }

     public static void BagInteroperabilityDemo() {
        System.out.println("\n\n------------------------------\nBagInteroperabilityDemo");
        // Create a LinkedBag and a ResizableArrayBag
        LinkedBag<Integer> linkedBag = new LinkedBag<>();
        ResizableArrayBag<Integer> resizableArrayBag = new ResizableArrayBag<>();

        // Adding elements to the LinkedBag
        linkedBag.add(1);
        linkedBag.add(2);
        linkedBag.add(3);
        linkedBag.add(4);

        // Adding elements to the ResizableArrayBag
        resizableArrayBag.add(3);
        resizableArrayBag.add(4);
        resizableArrayBag.add(5);
        resizableArrayBag.add(6);

        // Display original bags
        System.out.println("LinkedBag: ");
        linkedBag.forEach((x)-> System.out.print(x + " "));
        System.out.println("\nResizableArrayBag: ");
        resizableArrayBag.forEach((x)-> System.out.print(x + " "));

        // Perform union, intersection, and difference using interoperability

        // Union: LinkedBag with ResizableArrayBag
        BagInterface<Integer> union1 = linkedBag.union(resizableArrayBag);
        System.out.println("\n\nUnion of LinkedBag with ResizableArrayBag:");
        union1.forEach((x)-> System.out.print(x + " "));

        // Union: ResizableArrayBag with LinkedBag
        BagInterface<Integer> union2 = resizableArrayBag.union(linkedBag);
        System.out.println("\nUnion of ResizableArrayBag with LinkedBag:");
        union2.forEach((x)-> System.out.print(x + " "));

        // Intersection: LinkedBag with ResizableArrayBag
        BagInterface<Integer> intersection1 = linkedBag.intersection(resizableArrayBag);
        System.out.println("\nIntersection of LinkedBag with ResizableArrayBag:");
        intersection1.forEach((x)-> System.out.print(x + " "));

        // Intersection: ResizableArrayBag with LinkedBag
        BagInterface<Integer> intersection2 = resizableArrayBag.intersection(linkedBag);
        System.out.println("\nIntersection of ResizableArrayBag with LinkedBag:");
        intersection2.forEach((x)-> System.out.print(x + " "));

        // Difference: LinkedBag with ResizableArrayBag
        BagInterface<Integer> difference1 = linkedBag.difference(resizableArrayBag);
        System.out.println("\nDifference of LinkedBag with ResizableArrayBag:");
        difference1.forEach((x)-> System.out.print(x + " "));

        // Difference: ResizableArrayBag with LinkedBag
        BagInterface<Integer> difference2 = resizableArrayBag.difference(linkedBag);
        System.out.println("\nDifference of ResizableArrayBag with LinkedBag:");
        difference2.forEach((x)-> System.out.print(x + " "));

        // Demonstrate that bags are unchanged
        System.out.println("\n\nEnding LinkedBag: ");
        linkedBag.forEach((x)-> System.out.print(x + " "));
        System.out.println("\nEnding ResizableArrayBag: ");
        resizableArrayBag.forEach((x)-> System.out.print(x + " "));

    }

}
