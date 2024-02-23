
import java.util.Arrays;
import java.util.Iterator;
import java.util.NoSuchElementException;

public final class ResizableArrayBag<T> implements BagInterface<T>
{
	private T[] bag; 
	private int numberOfEntries;
   private boolean integrityOK = false;
	private static final int DEFAULT_CAPACITY = 25; 
	private static final int MAX_CAPACITY = 10000;

	public ResizableArrayBag() 
	{
		this(DEFAULT_CAPACITY);
	} 

	public ResizableArrayBag(int initialCapacity)
	{
      checkCapacity(initialCapacity);
      
      @SuppressWarnings("unchecked")
      T[] tempBag = (T[])new Object[initialCapacity]; 
      bag = tempBag;
      numberOfEntries = 0;
      integrityOK = true;
	} 

   public ResizableArrayBag(T[] contents) 
   {
      checkCapacity(contents.length);
      bag = Arrays.copyOf(contents, contents.length);
      numberOfEntries = contents.length;
      integrityOK = true;
   } 

	public boolean add(T newEntry)
	{
		checkintegrity();
      if (isArrayFull())
      {
         doubleCapacity();
      } 
      
      bag[numberOfEntries] = newEntry;
      numberOfEntries++;
      
      return true;
	} 

	public T[] toArray() 
	{
		checkintegrity();
      
      @SuppressWarnings("unchecked")
      T[] result = (T[])new Object[numberOfEntries]; 
      for (int index = 0; index < numberOfEntries; index++)
      {
         result[index] = bag[index];
      } 
      
      return result;
	} 
   
	public boolean isEmpty()
	{
      return numberOfEntries == 0;
	} 
   
	public int getCurrentSize()
	{
      return numberOfEntries;
	} 

	public int getFrequencyOf(T anEntry)
	{
		checkintegrity();
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
   
   public boolean contains(T anEntry)
	{
		checkintegrity();
      return getIndexOf(anEntry) > -1; 
	} 
   
	public void clear()
	{
      while (!isEmpty())
         remove();
	} 
	
	public T remove()
	{
		checkintegrity();
      T result = removeEntry(numberOfEntries - 1);
      return result;
	} 
	
	public boolean remove(T anEntry)
	{
		checkintegrity();
      int index = getIndexOf(anEntry);
      T result = removeEntry(index);
      return anEntry.equals(result);
	}

	public BagInterface<T> union(BagInterface<T> otherBag) {
      System.out.println("Stub function ResizableArrayBag.union() called!");
      return null;
   }

   public BagInterface<T> intersection(BagInterface<T> otherBag) {
      System.out.println("Stub function ResizableArrayBag.intersection() called!");
      return null;
   }

   public BagInterface<T> difference(BagInterface<T> otherBag) {
      System.out.println("Stub function ResizableArrayBag.difference() called!");
      return null;
   }
   
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
      
      
		return where;
	} 

	private T removeEntry(int givenIndex)
	{
		T result = null;
      
		if (!isEmpty() && (givenIndex >= 0))
		{
         result = bag[givenIndex];
         int lastIndex = numberOfEntries - 1;
         bag[givenIndex] = bag[lastIndex];  
         bag[lastIndex] = null;             
         numberOfEntries--;
		} 
      
      return result;
	} 
   
	private boolean isArrayFull()
	{
		return numberOfEntries >= bag.length;
	} 
   

	private void doubleCapacity()
	{
      int newLength = 2 * bag.length;
      checkCapacity(newLength);
      bag = Arrays.copyOf(bag, newLength);
	} 
   
   private void checkCapacity(int capacity)
   {
      if (capacity > MAX_CAPACITY)
         throw new IllegalStateException("Attempt to create a bag whose capacity exceeds " + "allowed maximum of " + MAX_CAPACITY);
   } 

   private void checkintegrity()
   {
      if (!integrityOK)
         throw new SecurityException ("ArrayBag object is corrupt.");
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
