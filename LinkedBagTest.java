public class LinkedBagTest {
    public static void main(String[] args) {
        LinkedBag<Integer> myBag = new LinkedBag<Integer>();
        myBag.add(4);
        myBag.add(5);
        myBag.add(2);

        myBag.getCapacity();
        myBag.getCurrentSize();

        myBag.forEach((x) -> System.out.print(x + " "));
        
    }
}
