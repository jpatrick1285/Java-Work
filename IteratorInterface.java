package linkedLists;

public interface IteratorInterface<T>
{
  boolean hasNext();
  T next();
  void add(T element);
  default boolean hasPrevious()
  {return false;}
  default T previous()
  {return null;}
  default void remove()
  { }
} // end IteratorInterface