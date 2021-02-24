// The bottom two methods are homework answers, so remove them
// before posting this code in Canvas.

package linkedLists;

import java.util.*;  // NoSuchElementException, Iterator

public class LinkedList<T> implements LinkedListInterface<T>  
{
  private Node<T> front;   // reference to front of list
  private Node<T> rear;    // reference to rear of list
  private int numElements; // number of elements in list
  
  //*********************************************
  
  public LinkedList()
  {
    front = null;
    rear = null;
    numElements = 0;
  }

  //*********************************************
  
  public boolean isEmpty()
  {
    return (numElements == 0);  
  }
   
  //*********************************************
  
  public int size()
  {
    return numElements;
  }

  //*********************************************
  
  // Add element to the front of the list.

  public void addFirst(T element)
  {
    Node<T> newNode = new Node<T>(element);
    
    if (front == null)
      front = rear = newNode;
    else
    {
      newNode.next = front;
      front = newNode;
    }
    numElements++;
  } // end addFirst

  //*********************************************
  
  // Add element to the rear of the list.

  public void addLast(T element)
  {
    Node<T> newNode = new Node<T>(element);
    
    if (front == null)
      front = rear = newNode;
    else
    {
      rear.next = newNode;
      rear = newNode;
    }
    numElements++;
  } // end addLast

  //*********************************************
  
  // Remove element from the front of the list.

  public T removeFirst()
  {
    T removedData;   // holds data from removed node

    if (numElements == 0)
      throw new NoSuchElementException(
        "Remove attempted on empty list\n");
    removedData = front.data;
    front = front.next;
    if (numElements == 1)
      rear = null;
    
    numElements--;
    return removedData;
  } // end removeFirst

  //*********************************************
  
  // Remove element from the rear of the list.

  public T removeLast()
  {
    T removedData;   // holds data from removed node
    Node<T> walker;  // for traversing the list

    if (numElements == 0)
      throw new NoSuchElementException(
        "Remove attempted on empty list\n");
    removedData = rear.data;
    if (numElements == 1)
      front = rear = null;
    else
    {
      walker = front;                                   
      while (walker.next != rear)
      {
        walker = walker.next;
      }
      walker.next = null;
      rear = walker;
    }
    
    numElements--;
    return removedData;
  } // end removeLast

  //*********************************************

  // This method implements an iterator class,
  // instantiates it, and returns it.
  
  public IteratorInterface<T> iterator(int index)
  {
    return new IteratorInterface<T>()
    {
      private Node<T> prev; // node before cursor position
      private Node<T> next; // node after cursor position
      
      // Use an instance initialization block because
      // anonymous classes don't support constructors.
      
      {
        Node<T> walker;  // needed for traversing the list
        
        if ((index < 0) || (index > numElements))
          throw new IndexOutOfBoundsException(
            "Illegal index " + index +
            " passed to iterator initialization block.\n");

        if (index == 0)
        {
          prev = null;
          next = front;
        }
        else if (index == numElements)
        {
          prev = rear;
          next = null;
        }
        else
        {
          walker = front;                                   
          for (int i=1; i<index; i++)
          {
            walker = walker.next;
          }
          prev = walker;
          next = walker.next;
        }
      } // end instance initialization block
      
      //*****************************************

      // Return true if not at the end of the list.
      
      public boolean hasNext()
      {
        return (next != null);
      }
      
      //*****************************************

      // Return the next node's value and move
      // cursor position forward.

      public T next()
      { 
        if (next == null)
          throw new NoSuchElementException("Attempt to" +
            " call next when there's no next element.");

        prev = next;
        next = next.next;
        return prev.data;
      } // end next

      //*****************************************

      // Instantiate a node and insert it before the
      // node that next points to. Afterward, the
      // cursor position is after the new node.
      
      public void add(T element)
      {
        Node<T> newNode = new Node<T>(element);
        Node<T> origPrev = prev; // remember original prev
        
        // these are needed for all 4 scenarios:
        newNode.next = next;
        prev = newNode;
        
        if (isEmpty())
        {
          front = rear = newNode;
        }
        
        // cursor position at front:
        else if (prev == null)
        {
          front = newNode;
        }

        // cursor position at rear:
        else if (next == null)
        {
          rear = newNode;
          origPrev.next = newNode;
        }

        else // cursor position in the interior:
        {
          origPrev.next = newNode;
        }
        
        numElements++;
      } // end add
    }; // end anonymous inner class
  } // end iterator
  
  //*********************************************
  
  // HOMEWORK:
  
  // If index < 0 or index > size(), throw IndexOutOfBoundsException.
  // Otherwise, insert element at the specified index.

  public void add(int index, T element)
  {
    Node<T> newNode = new Node<T>(element);
    Node<T> walker;  // needed for traversing the list
    
    if ((index < 0) || (index > numElements))
      throw new IndexOutOfBoundsException(
        "Illegal index " + index + " passed to add method.\n");

    if (front == null) // add to empty list
    { 
      front = newNode;
      rear = newNode;
    }
    else if (index == 0) // add to front
    {
      newNode.next = front;
      front = newNode;
    }
    else if (index == size()) // add to rear
    {
      rear.next = newNode;
      rear = newNode;
    }
    else  // add to interior part of list
    {
      walker = front;                                   
      for (int i=0; i<(index-1); i++)
      {
        walker = walker.next;
      }
      newNode.next = walker.next;
      walker.next = newNode;
    }
    numElements++;
  } // end add
  
  //*********************************************

  // HOMEWORK:
  
  // If index < 0 or index >= size(), throw IndexOutOfBoundsException.
  // Otherwise, remove element at the specified index and return the
  // removed element.
  
  public T remove(int index)
  {
    T removedData;     // holds data from removed node
    Node<T> walker;    // needed for traversing the list
    Node<T> successor; // node that is after walker

    if ((index < 0) || (index >= numElements))
      throw new IndexOutOfBoundsException(
          "Illegal index " + index + " passed to remove method.\n");
    
    if (index == 0) // remove front node
    {
      removedData = front.data;
      front = front.next;
      if (numElements == 1)
        rear = null;
    }
    else
    {
      walker = front;                                   
      for (int i=0; i<(index-1); i++)
        walker = walker.next;
      
      successor = walker.next;
      removedData = successor.data;
      if (successor == rear)  // remove rear node
        rear = walker;
      walker.next = successor.next;
    }

    numElements--;
    return removedData;
  } // end remove
} // end class LinkedList