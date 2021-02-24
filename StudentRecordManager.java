// StudentRecordManager.java (incomplete. fill in ADD CODE #1-#4)
// HW5
// manages student records in a class. Used with Student class.
// Maintains student records in an ArrayList of Student.
// - Load student record data from file in constructor
// - provides methods to display, to sort by name, and to sort by absence count
// - provides a menu to interact with user

// java.io classes, used for file i/o
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import java.util.Scanner; // I/O methods

import java.util.ArrayList;

public class StudentRecordManager
{
  // instance data members
  private ArrayList<Student> records;


  // constructor
  public StudentRecordManager(String rosterFileName)
  {
    records = new ArrayList<Student>();

    loadFromFile(rosterFileName);
  }


  // use menu to interact with user
  public void showMenu()
  {
    final String[] options = {"\n== Menu ==\n",
        "1. Show student records\n",
        "2. Order by name (alphabetic order)\n",
        "3. Order by absence count (ascending order)\n",
        "0. Exit\n",
        "Enter: "};

    Scanner stdIn = new Scanner(System.in);
    int choice;  // user menu input
    do
    {
      // display menu
      for (String s : options)
        System.out.print(s);

      // get user input
      choice = stdIn.nextInt();

      switch (choice)
      {
      case 0:
        System.out.println("Thank you for using our system. Bye-bye.");
        break;
      case 1:
        displayRecords();
        break;
      case 2:
        sortByName(); // sort by name. no printing. Next need to choose option 1 to display results
        break;
      case 3:
        sortByAbsenceCount(); // sort by absence count. no printing. Next need to choose option 1 to display results
      default: // invalid choice
        System.out.println("invalid input. Please try again.");
        break;
      }
    } while (choice != 0);

    stdIn.close();
  } // end showMenu


  // display student records on screen
  private void displayRecords()
  {
    if (records == null || records.size() == 0) // null or empty
    {
      System.out.println("Empty class. No data to show");
      return; // exit method now
    }

    // has some records
    System.out.println("-----------------------------------");
    System.out.printf("%-20s%s\n", "StudentName", "AbsenceCount");

    // ADD CODE #1: add code to print all records.
    //   - name in a 20-char column, left aligned
    //   - absence count in a 2-char column

    // END ADD CODE #1

    System.out.println("-----------------------------------");
  } // end displayRecords


  // sort student records by name (alphabetic order)
  private void sortByName()
  {
    // can be done with either selection sort or insertion sort. Demonstrate selection sort
    // use name of student object to compare, but re-arrange student objects in the array list
    // only sort. Do NOT print anything
    /*
    for index i = 0 to records.size() - 1
      find the record with the smallest name from (i) to end
      swap the student object with the smallest name and the student object at index i
    end for
    */
    for (int i=0; i<records.size()-1; i++)
    {
      // 1. find index of smallest remaining value. remember to compare names of Student objects
      int min = i;   // index of Student obj with smallest name. assume i
      // ADD CODE #2
      // END ADD CODE #2

      // 2. swap obj at (i) and (min). remember to swap Student objects
      // ADD CODE #3
      // END ADD CODE #3

    } // end for i (outer for loop)

  } // end sortByName


  // sort student records by absence count
  private void sortByAbsenceCount()
  {
    // can be done with either selection sort or insertion sort
    // remember to compare counts of Student objs, but re-arrange Student object in the array list
    // only sort. Do NOT print anything

    // ADD CODE #4

    // END ADD CODE #4

  } // end sortByAbsenceCount


  // load student data from text files
  /**
     * Fills student record ArrayList with data from text file.
     * columns are separated with comma ,
     *
     * @param fileName  name of input text file
     * @return  number of records loaded
     * @throws IOException: any exception during file opening, reading, and closing
     */
    private int loadFromFile(String fileName)
    {
      Scanner fileIn = null;     // scanner object to connect to file
      int recordCount = 0;       // track # of records

      try {
        // open input file
        fileIn = new Scanner(new BufferedReader(new FileReader(fileName)));

        // skip first line (record headings)
        fileIn.nextLine(); // read one line, but do not use

        // loop through multiple records
        while (fileIn.hasNext())
        {
          // 1. read one line containing all columns of a record
          String line = fileIn.nextLine();
          if (line.isEmpty())  // empty line: go to next
            continue;

          // 2. extract name (1st column) and absence count (2nd column)
          // 1st col is name, 2nd col is absence count: xxxx, dd
          String name;
          int absenceCount;

          int toIndex = line.indexOf(','); // locate first comma ,
          name = line.substring(0, toIndex); // from beginning to the char right before first comma ,

          String absenceCountStr = line.substring(toIndex+1); // +1 to pass comma ,
          absenceCount = Integer.parseInt(absenceCountStr.trim()); // trim() leading/trailing whitespace

          // 3. create Student object and add to ArrayList records
          records.add(new Student(name, absenceCount));

          // 4. end reading one record. increment record counter
          recordCount++;

          // end one record
        }// end while: reading all records

      }
      catch (IOException ioe)
      {
        System.out.println("Error reading \"" + fileName + "\" file: " + ioe);
      }
      finally // close file
      {
        if ( fileIn != null)
        {  // close if was connected to a file
            fileIn.close();
        }
      }
      // end file input

      return recordCount;
  }// end loadFromFile

} // end class StudentRecordManager