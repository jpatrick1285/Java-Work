package linkedLists;

public interface LinkedListInterface<T>
{
  boolean isEmpty();
  int size();
  void addFirst(T element);
  void addLast(T element);
  T removeFirst();
  T removeLast();
  IteratorInterface<T> iterator(int index);
  default void add(int index, T element)
  { }
  default T remove(int index)
  {return null;}
} // end LinkedListInterface 