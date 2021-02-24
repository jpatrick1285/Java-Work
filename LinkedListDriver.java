package linkedLists;

public class LinkedListDriver
{
  public static void main(String[] args)
  {
    LinkedListInterface<Integer> ll = new LinkedList<>();
    IteratorInterface<Integer> iter;

    iter = ll.iterator(0);
    iter.add(100);
    iter.add(200);
    iter = ll.iterator(0);
    while (iter.hasNext())
    {
      System.out.print(iter.next() + " ");
    }
    
    // start over...
    
    ll = new LinkedList<>();
    
    ll.addFirst(10);
    ll.addLast(20);
    ll.addFirst(30);
    ll.addLast(40);
    ll.addFirst(50);
    System.out.println("\nremoved last = " + ll.removeLast());
    System.out.println("removed First = " + ll.removeFirst());
    
    iter = ll.iterator(1);
    iter.add(60);
    iter.add(70);
    
    iter = ll.iterator(0);
    while (iter.hasNext())
    {
      System.out.print(iter.next() + " ");
    }
    
    // HW test...

    System.out.println();
    ll.add(1, -1);
    ll.add(1, -2);
    System.out.println("\nremove(0) = " + ll.remove(0));
    System.out.println("remove(2) = " + ll.remove(2));
    ll.add(ll.size(), -3);
    
    iter = ll.iterator(0);
    while (iter.hasNext())
    {
      System.out.print(iter.next() + " ");
    }
  } // end main
} // end class LinkedListDriver