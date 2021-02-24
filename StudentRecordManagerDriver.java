// StudentRecordManagerDriver.java (complete)
// HW5
// part of Student Record managing system program
// driver class. Used with Student and StudentRecordManager classes

public class StudentRecordManagerDriver
{
  public static void main(String[] args)
  {
    StudentRecordManager roster = new StudentRecordManager("data/cs219.txt");
    roster.showMenu();
  } // end main
} // end class StudentRecordManager