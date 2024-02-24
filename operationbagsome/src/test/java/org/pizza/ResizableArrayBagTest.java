package org.pizza;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Iterator;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ResizableArrayBagTest {

    private ResizableArrayBag<Integer> bag = new ResizableArrayBag<>();
    private ResizableArrayBag<Integer> bag2 = new ResizableArrayBag<>();

    @BeforeEach
    public void init() {
        assertTrue(bag.isEmpty());
        for (Integer i = 0; i < 6; i++)
            bag.add(i);
        for (Integer i = 4; i < 8; i++)
            bag2.add(i);
    }

    @Test
    public void testInitialize() {
        assertFalse(bag.isEmpty());
        assertEquals(6, bag.getCurrentSize());
        for (Integer i = 0; i < 6; i++)
            assertTrue(bag.contains(i));
    }

    @Test
    public void testFrequencyOf() {
        assertEquals(1, bag.getFrequencyOf(Integer.valueOf(1)));
    }


    @Test
    public void testRemove() {
        assertEquals(Integer.valueOf(5), bag.remove());
        assertEquals(5, bag.getCurrentSize());

        assertEquals(Integer.valueOf(4), bag.remove());
        assertEquals(4, bag.getCurrentSize());

        assertEquals(Integer.valueOf(3), bag.remove());
        assertEquals(3, bag.getCurrentSize());

        assertTrue(bag.remove(Integer.valueOf(1)));
        assertEquals(2, bag.getCurrentSize());
    }


    @Test
    public void testToArray() {
        Integer[] contents = {1, 2, 3, 4, 5};
        bag = new ResizableArrayBag<>(contents);

        Object[] expectedArray = {1, 2, 3, 4, 5};
        assertArrayEquals(expectedArray, bag.toArray());
    }

    @Test
    public void testCapacity() {
        bag = new ResizableArrayBag<>(2);
        bag.add(1);
        bag.add(2);
        assertEquals(2,bag.getCurrentSize());
        bag.add(3);
        assertEquals(3,bag.getCurrentSize());
    }

    @Test
    public void testUnion() {
        BagInterface<Integer> unionBag = bag.union(bag2);

        assertEquals(10, unionBag.getCurrentSize());
        for (Integer i = 0; i < 8; i++)
            assertTrue(unionBag.contains(i));
    }

    @Test
    public void testIntersection() {
        BagInterface<Integer> intersectionBag = bag.intersection(bag2);

        assertEquals(2, intersectionBag.getCurrentSize());
        assertTrue(intersectionBag.contains(4));
        assertTrue(intersectionBag.contains(5));
    }

    @Test
    public void testDifference() {
        BagInterface<Integer> differenceBag = bag.difference(bag2);

        Object[] expectedArray = {0, 1, 2, 3};
        assertArrayEquals(expectedArray, differenceBag.toArray());
        assertEquals(4, differenceBag.getCurrentSize());
        for (int i = 0; i < 4; i++)
            assertTrue(differenceBag.contains(i));

        BagInterface<Integer> differenceBag2 = bag2.difference(bag);
        
        Object[] expectedArray2 = {7, 6};
        assertArrayEquals(expectedArray2, differenceBag2.toArray());
        assertEquals(2, differenceBag2.getCurrentSize());
        for (int i = 6; i < 8; i++)
            assertTrue(differenceBag2.contains(i));
    }

    @Test
    public void testIterator() {

        Iterator<Integer> iterator = bag.iterator();
        assertNotNull(iterator);

        int count = 0;
        while (iterator.hasNext()) {
            int value = iterator.next();
            assertTrue(bag.contains(value));
            count++;
        }
        assertEquals(bag.getCurrentSize(), count);
    }

}
