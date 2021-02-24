// Student.java (complete)
// (part of Student Record managing system program)
// HW5 Project
// represents a student in school

public class Student
{
  // instance data members
  private String name;
  private int absenceCount = 0;

  // constructor
  public Student(String name, int absenceCount)
  {
    this.name = name;
    this.absenceCount = absenceCount;
  }

  // accessors
  public String getName() { return name; }

  public int getAbsenceCount() { return absenceCount; }

} // end class Student