import java.util.Scanner;
/****************************************************************
 * MovieRating.java
 * Dean & Dean
 *
 * This program determines what kind of movie you may watch when going to movie
 ***************************************************************/

public class MovieRating
{
    public static void main(String[] args)
    {
        Scanner stuff = new Scanner(System.in);

        int age;
        String parent;

        System.out.println("The type of movies you can watch ...");
        System.out.println("Enter your age: ");
        age = stuff.nextInt();


        System.out.println("With parent ");
        parent = stuff.nextLine();
        parent.toUpperCase();

        if (parent == "Y"){
            if (age<13){
                System.out.println("You can watch G, PG movie.");
            }
            else{
                System.out.println("You can watch G,PG,R movie.");
            }
        }
        if(parent== "N"){
            if(age<13){
                System.out.println("You can watch G movie.");
            }
            else if(age < 17){
                System.out.println("You can watch G, PG movie.");
            }
            else{
                System.out.println("You can watch G, PG, R movie.");
            }
        }

    }// end main

} // end class MovieRating