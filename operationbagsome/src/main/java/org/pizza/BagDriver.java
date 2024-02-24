package org.pizza;
public class BagDriver {
    public static void main(String[] args) {
        LinkedBagDemo();
        ResizableArrayBagDemo();
        BagInteroperabilityDemo();
    }

    public static void LinkedBagDemo() {
        System.out.println("\n\nLinkedBagDemo");
        LinkedBag<Integer> bag1 = new LinkedBag<>();
        LinkedBag<Integer> bag2 = new LinkedBag<>();

        // Initialize Bag 1 and Bag 2
        for (Integer i = 0; i < 6; i++)
            bag1.add(i);
        for (Integer i = 4; i < 8; i++)
            bag2.add(i);

        // Prints Bag 1 and Bag 2
        System.out.println("Bag 1: ");
        bag1.forEach((x)-> System.out.print(x + " "));
        System.out.println("\nBag 2: ");
        bag2.forEach((x)-> System.out.print(x + " "));

        // Union
        System.out.println("\nUnion:");
        BagInterface<Integer> union = bag1.union(bag2);
        union.forEach((x) -> System.out.print(x + " "));

        // Intersection
        System.out.println("\nIntersection:");
        BagInterface<Integer> intersection = bag1.intersection(bag2);
        intersection.forEach((x) -> System.out.print(x + " "));

        // Difference
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
        ResizableArrayBag<Integer> bag1 = new ResizableArrayBag<>();
        ResizableArrayBag<Integer> bag2 = new ResizableArrayBag<>();

        // Initialize Bag 1 and Bag 2
        for (Integer i = 0; i < 6; i++)
            bag1.add(i);
        for (Integer i = 4; i < 8; i++)
            bag2.add(i);


        // Prints Bag 1 and Bag 2
        System.out.println("Bag 1: ");
        bag1.forEach((x)-> System.out.print(x + " "));
        System.out.println("\nBag 2: ");
        bag2.forEach((x)-> System.out.print(x + " "));

        // Union
        System.out.println("\nUnion:");
        BagInterface<Integer> union = bag1.union(bag2);
        union.forEach((x) -> System.out.print(x + " "));

        // Intersection
        System.out.println("\nIntersection:");
        BagInterface<Integer> intersection = bag1.intersection(bag2);
        intersection.forEach((x) -> System.out.print(x + " "));

        // Difference
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
        LinkedBag<Integer> linkedBag = new LinkedBag<>();
        ResizableArrayBag<Integer> resizableArrayBag = new ResizableArrayBag<>();



        // Initialize LinkedBag 
        linkedBag.add(1);
        linkedBag.add(2);
        linkedBag.add(3);
        linkedBag.add(4);

        // Initialize ResizableArrayBag
        resizableArrayBag.add(3);
        resizableArrayBag.add(4);
        resizableArrayBag.add(5);
        resizableArrayBag.add(6);

        // Prints LinkedBag and ResizableArrayBag
        System.out.println("LinkedBag: ");
        linkedBag.forEach((x)-> System.out.print(x + " "));
        System.out.println("\nResizableArrayBag: ");
        resizableArrayBag.forEach((x)-> System.out.print(x + " "));

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
