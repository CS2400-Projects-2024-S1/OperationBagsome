package org.pizza;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Iterator;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class LinkedBagTest {

    private LinkedBag<Integer> bag;
    private LinkedBag<Integer> bag2;

    @BeforeEach
    public void init() {
        bag = new LinkedBag<>();
        bag2 = new LinkedBag<>();

        assertTrue(bag.isEmpty());
        for (int i = 0; i < 6; i++)
            bag.add(i);
        for (int i = 4; i < 8; i++)
            bag2.add(i);
    }

    @Test
    public void testInitialize() {
        assertFalse(bag.isEmpty());
        assertEquals(6, bag.getCurrentSize());
        for (int i = 0; i < 6; i++)
            assertTrue(bag.contains(i));
    }

    @Test
    public void testFrequencyOf() {
        assertEquals(1, bag.getFrequencyOf(1));
    }

    @Test
    public void testRemove() {
        assertEquals(Integer.valueOf(5), bag.remove());
        assertEquals(5, bag.getCurrentSize());

        assertEquals(Integer.valueOf(4), bag.remove());
        assertEquals(4, bag.getCurrentSize());

        assertEquals(Integer.valueOf(3), bag.remove());
        assertEquals(3, bag.getCurrentSize());

        assertTrue(bag.remove(1));
        assertEquals(2, bag.getCurrentSize());
    }

    @Test
    public void testToArray() {
        Integer[] contents = {1, 2, 3, 4, 5};
        bag = new LinkedBag<>();
        for (Integer integer : contents) {
            bag.add(integer);
        }

        Object[] expectedArray = {5, 4, 3, 2, 1};
        assertArrayEquals(expectedArray, bag.toArray());
    }

    @Test
    public void testUnion() {
        BagInterface<Integer> unionBag = bag.union(bag2);

        assertEquals(10, unionBag.getCurrentSize());
        for (int i = 0; i < 8; i++)
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

        assertEquals(4, differenceBag.getCurrentSize());
        for (int i = 0; i < 4; i++)
            assertTrue(differenceBag.contains(i));
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
