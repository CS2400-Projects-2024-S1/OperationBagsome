package org.pizza;

/** ResizableArray.java
    A class that implements a bag of objects by using an array.
    The bag is never full.
    @author Frank M. Carrano
    @version 4.0
*/
// Modified Version

import java.util.Arrays;
import java.util.Iterator;
import java.util.NoSuchElementException;

public final class ResizableArrayBag<T> implements BagInterface<T>
{
    private T[] bag; // Cannot be final due to doubling
    private int numberOfEntries;
    private boolean initialized = false;
    private static final int DEFAULT_CAPACITY = 25; //Initial capacity of bag
    private static final int MAX_CAPACITY = 1000000;

    //*********************************************************************
    //This section contains three constructors and two public core methods.
    //*********************************************************************
    /**
        Create an empty bag whose initial capacity is 25.
    */
    public ResizableArrayBag()
    {
        this(DEFAULT_CAPACITY);
    }

    /**
        Create an empty bag having a given initial capacity.
        @param initialCapacity The integer capacity desired.
    */
    public ResizableArrayBag(int initialCapacity)
    {
        checkCapacity(initialCapacity);

        //The cast is safe because the new array contains null entries
        @SuppressWarnings("unchecked")
        T[] tempBag = (T[]) new Object[initialCapacity]; //Unchecked cast
        bag = tempBag;
        numberOfEntries = 0;
        initialized = true;
    }

    /**
        Create a bag containing given entries.
        @param contents An array of objects.
    */
    public ResizableArrayBag(T[] contents)
    {
        checkCapacity(contents.length);
        bag = Arrays.copyOf(contents, contents.length);
        numberOfEntries = contents.length;
        initialized = true;
    }

    /**
        Add a new entry to this bag.
        @param newEntry The object to be added as a new entry.
        @return true.
    */
    public boolean add(T newEntry)
    {
        checkInitialization();
        if (isArrayFull())
        {
            doubleCapacity();
        }
        bag[numberOfEntries] = newEntry;
        numberOfEntries++;
        return true;
    }

    /**
        Retrieve all entries that are in this bag and put them into an array.
        @return A newly allocated array of all the entries in this bag.
    */
    public T[] toArray()
    {
        checkInitialization();
        @SuppressWarnings("unchecked")
        T[] result = (T[]) new Object[numberOfEntries]; //Unchecked cast
        for (int index = 0; index < numberOfEntries; index++)
        {
            result[index] = bag[index];
        }
        return result;
    }

    //********************************************************************
    //This section contains seven additional public methods.
    //********************************************************************
    /**
        Test whether this bag is empty.
        @return true if this bag is empty, or false if not.
    */
    public boolean isEmpty()
    {
        return numberOfEntries == 0;
    }

    /**
        Get the current number of entries in this bag.
        @return The integer number of entries currently in this bag.
    */
    public int getCurrentSize()
    {
        return numberOfEntries;
    }

    /**
        Count the number of times a given entry appears in this bag.
        @param anEntry The entry to be counted.
        @return The number of times anEntry appears in this bag.
    */
    public int getFrequencyOf(T anEntry)
    {
        checkInitialization();
        int counter = 0;
        for (int index = 0; index < numberOfEntries; index++)
        {
            if (anEntry.equals(bag[index]))
            {
                counter++;
            }
        }
        return counter;
    }

    /**
        Test whether this bag contains a given entry.
        @param anEntry The entry to locate.
        @return true if this bag contains anEntry, or false otherwise.
    */
    public boolean contains(T anEntry)
    {
        checkInitialization();
        return getIndexOf(anEntry) > -1; //or >= 0
    }

    /**
        Removes all entries from this bag.
    */
    public void clear()
    {
        while (!isEmpty())
        {
            remove();
        }
    }

    /**
        Remove one unspecified entry from this bag, if possible.
        @return Either the removed entry, if removal was successful, or null.
    */
    public T remove()
    {
        checkInitialization();
        T result = removeEntry(numberOfEntries - 1);
        return result;
    }

    /**
        Remove one occurrence of a given entry from this bag.
        @param anEntry The entry to be removed.
        @return true if the removal was successful, or false if not.
    */
    public boolean remove(T anEntry)
    {
        checkInitialization();
        int index = getIndexOf(anEntry);
        T result = removeEntry(index);
        return anEntry.equals(result);
    }

    
    /** 
     * @return boolean
     */
    //********************************************************************
    //This section contains six private helper methods.
    //********************************************************************
    //Return true if the array bag is full, or false if not.
    private boolean isArrayFull()
    {
        return numberOfEntries >= bag.length;
    }

    
    /** 
     * @param anEntry
     * @return int
     */
    //Locate a given entry within the array bag.
    //Returns the index of the entry if located, -1 otherwise.
    //Pre-condition: checkInitialization has been called.
    private int getIndexOf(T anEntry)
    {
        int where = -1;
        boolean found = false;
        int index = 0;
        while (!found && (index < numberOfEntries))
        {
            if (anEntry.equals(bag[index]))
            {
                found = true;
                where = index;
            }
            index++;
        }
        //Assertion: If where > -1, anEntry is in the array bag, and it
        //equals bag[where]; otherwise, anEntry is not in the array.

        return where;
    }

    
    /** 
     * @param givenIndex
     * @return T
     */
    //Remove and return the entry at a given index within the array.
    //If no such entry exists, returns null.
    //Precondition: 0 <= givenIndex < numberOfEntries.
    //Precondition: checkInitialization has been called.
    private T removeEntry(int givenIndex)
    {
        T result = null;

        if (!isEmpty() && (givenIndex >= 0))
        {
            result = bag[givenIndex]; //Entry to remove
            int lastIndex = numberOfEntries - 1;

            //Replace entry to remove with last entry, then
            //remove reference to last entry and adjust numberOfEntries.
            bag[givenIndex] = bag[lastIndex];
            bag[lastIndex] = null;
            numberOfEntries--;
        }
        return result;
    }

    //Throws an exception if receiving object is not initialized.
    private void checkInitialization()
    {
        if (!initialized)
        {
            throw new SecurityException
            (
                "Uninitialized object used "
                + "to call an ArrayBag method."
            );
        }
    }

    //Throw an exception if the client requests a capacity that is too large.
    private void checkCapacity(int capacity)
    {
        if (capacity > MAX_CAPACITY)
        {
            throw new IllegalStateException
            (
                "Attempt to create a bag whose "
                + "capacity exceeds allowed maximum of " + MAX_CAPACITY + "."
            );
        }
    }

    //Double the size of the array bag.
    //Pre-condition: checkInitialization has been called.
    private void doubleCapacity()
    {
        int newLength = 2 * bag.length;
        checkCapacity(newLength);
        bag = Arrays.copyOf(bag, newLength);
    }

    /**
        Returns a bag containing the union of this bag and another bag.
		@param otherBag  The other bag to union with.
		@return  A bag containing the union of these bags.
    */
	public BagInterface<T> union(BagInterface<T> otherBag) {
      ResizableArrayBag<T> unionBag = new ResizableArrayBag<T>(getCurrentSize()+otherBag.getCurrentSize());
      forEach((x)->{
         if (x != null) {
            unionBag.add(x);
         }
      });
      otherBag.forEach((x)->{
         if (x != null) {
            unionBag.add(x);
         }
      });
      return unionBag;
   }

    /** Returns a bag containing the intersection of this bag and another bag.
		@param otherBag  The other bag to intersect with.
		@return  A bag containing the intersection of these bags.
    */
	public BagInterface<T> intersection(BagInterface<T> otherBag) {
      BagInterface<T> intersectionBag = new ResizableArrayBag<T>
          (getCurrentSize() < otherBag.getCurrentSize() ? getCurrentSize() : otherBag.getCurrentSize());
      BagInterface<T> tempBag = new ResizableArrayBag<T>(getCurrentSize());
      otherBag.forEach((x) -> {
          tempBag.add(x);
      });
    
      forEach((x) -> {
          if (x != null && tempBag.contains(x)) { 
              intersectionBag.add(x); 
              tempBag.remove(x); 
          }
      });
      return intersectionBag;
   }
   
    /** Returns a bag containing the difference of this bag and another bag.
		@param otherBag  The other bag to differ with.
		@return  A bag containing the difference of these bags.
    */
	public BagInterface<T> difference(BagInterface<T> otherBag) {
      BagInterface<T> differenceBag = new ResizableArrayBag<T>(getCurrentSize());
      forEach((x)->{
         if (x != null) {
            differenceBag.add(x);
         }
      });
      otherBag.forEach((x)->{
         if (differenceBag.contains(x)) {
            differenceBag.remove(x);
         }
      });
      return differenceBag;
  }
   

   @Override
   public Iterator<T> iterator() {
      return new ArrayBagIterator();
   }

   private class ArrayBagIterator implements Iterator<T> {
        private int currentIndex = 0;

        @Override
        public boolean hasNext() {
            return currentIndex < numberOfEntries;
        }

        @Override
        public T next() {
            if(!hasNext())
               throw new NoSuchElementException();
            return bag[currentIndex++];
        }
      }
} 
