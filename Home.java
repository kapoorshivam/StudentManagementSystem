																																		/* Main class file  */
import java.sql.*;
import java.util.Scanner;

class Home
{
  public static void main( String args[] )  //throws Exception
  {
    Scanner input  = new Scanner(System.in);

    System.out.println("\n");
    System.out.println("\t\t Welcome TO Student Management System");
    System.out.println(" ");
    System.out.println("\t\t * * * * * * * * * * * * * * * * * * * ");
    System.out.println("\t\t * Enter 1 to Add Student Details    * ");
    System.out.println("\t\t * Enter 2 to Search Student Details * ");
    System.out.println("\t\t * Enter 3 to Update Student Details * ");
    System.out.println("\t\t * Enter 4 to Delete Student Details * ");
    System.out.println("\t\t * Enter 5 to View All Details       * ");
    System.out.println("\t\t * Enter 6 to Exit                   * ");
    System.out.println("\t\t * * * * * * * * * * * * * * * * * * * ");
    System.out.println(" ");
    System.out.print ("\t\t Please Enter your choice :::: " );
    int choice = input.nextInt();
    System.out.println(" ");

    switch (choice)
/* --------------------------------------------------------case 1 -------------------------------------------------------------------- */
    {
      case 1:   /* Will be used to add details from DB */
        System.out.println("\t\t You Have Selected Add Student Details Option ");
        StudentHelper.saveStudent();
        break;
/*---------------------------------------------------------Case 2--------------------------------------------------------------------------*/
      case 2:     /* Will be used to search details from DB*/
        System.out.println("\t\t You Have Selected Search Student Details Option ");
        StudentHelper.searchStudent();
        break;
/*----------------------------------------------------------Case 3-------------------------------------------------------------------------*/
      case 3:     /* Update details from DB */
        System.out.println("\t\t You Have Selected Update Student Details Option ");
        StudentHelper.editStudent();
        break;
/*-------------------------------------------------------------------case 4----------------------------------------------------------------*/
      case 4:   /* Will be used to delete  details from DB */
        System.out.println("\t\t You Have Selected Delete Student Details Option ");
        StudentHelper.deleteStudent();
        break;
/* --------------------------------------------------------------------case 5------------------------------------------------------------- */
      case 5:   /* Will be used to view all  details from DB */
        System.out.println("\t\t You Have Selected View All Details Option ");
        StudentHelper.viewAllStudent();
        break;
/*----------------------------------------------------------------------case 6-------------------------------------------------------------*/
      case 6:
        System.out.print("\t\t You Really Want to exit (Y/N) ::  ");
        Scanner scan = new Scanner(System.in);
        char con = scan.next().charAt(0);
				if(con == 'n' || con == 'N')
				// if(con.toUpperCase() == ’N')
        {
          System.out.println(" \t\t\t WELCOME AGAIN ::) ");
          Home.main(new String[]{});
        }
        else
        {
          System.out.println(" \t\t\t Thank you for Visiting BYE ");
        }
        break;
/* ------------------------------------------------------------------Default-------------------------------------------------------------- */
      default:
        System.out.println("\t\t You Have Selected Invalid Option ");
        Home.main(new String[]{});
    }
  }
}
