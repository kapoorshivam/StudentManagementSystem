																																/*	Student Class File	*/
import java.sql.*;
import static commons.Constants.*;
import java.util.Scanner;
public class StudentHelper
{
  public StudentHelper() { }
/*------------------------------------------------------------------1---------*/
  public static boolean saveStudent()  {
    Student student = getStudentInfo();
    return student.saveDetails(getConnection());
  }
/*-------------------------------------------------------------------2--------*/
  public static boolean searchStudent()  {
    Student student = getStudentSearch();
    return student.searchDetails(getConnection());
  }
/*--------------------------------------------------------------------3-------*/
  public static boolean editStudent()  {
    Student student = getStudentEdit();
    return student.updateDetails(getConnection());
  }
/*---------------------------------------------------------------------4------*/
  public static boolean deleteStudent()  {
    Student student = getStudentDelete();
    return student.deleteDetails(getConnection());
  }
/*----------------------------------------------------------------------5-----*/
    public static boolean viewAllStudent()  {
      Student student = getStudentAllDetails();
      return student.printDetails(getConnection());
    }
/*----------------------------------------------------------------------------*/
  static Scanner input = new Scanner(System.in);
/*------------------------------------------------------------------1---------*/
  private static Student getStudentInfo()	 {
    System.out.print("Enter Full Name :: ");
    String fullName  = input.nextLine();
    System.out.print("Enter The Roll Number ");
    int rollNo  = input.nextInt();
    System.out.print("Enter Date of birth ex (YYYY/MM/DD) :: ");
    String dateOfBirth  = input.next();
    System.out.print("Enter Gender (Male/Female) :: ");
    String gender = input.next();
    System.out.print("Enter Phone number :: ");
    String phoneNumber = input.next();
    System.out.print("Enter Branch :: ");
    String branch = input.next();

    Student student = new Student();

    student.setRollNo(rollNo);
    student.setFullName(fullName);
    student.setDateOfBirth(dateOfBirth);
    student.setGender(gender);
    student.setPhoneNumber(phoneNumber);
    student.setBranch(branch);
    return student;
  }
/*-------------------------------------------------------------------2--------*/
  private static Student getStudentSearch()	 {
    System.out.println("Enter Roll No.");
    int rollNo = input.nextInt();

    Student student = new Student();
    student.setRollNo(rollNo);
    return student;
  }
/*--------------------------------------------------------------------3-------*/
  private static Student getStudentEdit()	 {
    System.out.print("Enter The Roll Number To Change Details :: ");
    int rollNo  = input.nextInt();
    System.out.print("Enter New Name :: ");
    String fullName  = input.next();
    System.out.print("Enter New Date of birth ex (YYYY/MM/DD) :: ");
    String dateOfBirth  = input.next();
    System.out.print("Enter New Gender (Male/Female) :: ");
    String gender = input.next();
    System.out.print("Enter New Phone number :: ");
    String phoneNumber = input.next();
    System.out.print("Enter New Branch :: ");
    String branch = input.next();

    Student student = new Student();

    student.setRollNo(rollNo);
    student.setFullName(fullName);
    student.setDateOfBirth(dateOfBirth);
    student.setGender(gender);
    student.setPhoneNumber(phoneNumber);
    student.setBranch(branch);
    return student;
  }
/*---------------------------------------------------------------------4------*/
  private static Student getStudentDelete()	 {
    System.out.println("Enter Roll No. to Delete Student Details");
    int rollNo = input.nextInt();

    Student student = new Student();
    student.setRollNo(rollNo);
    return student;
  }
/*----------------------------------------------------------------------5------*/
  private static Student getStudentAllDetails()  {
    Student student = new Student();
    return student;
  }
/*-----------------------------------------------------------------------------*/

  public static Connection getConnection()  {
    Connection conn;
      try  {
        Class.forName("com.mysql.jdbc.Driver");
        conn = DriverManager.getConnection(CONNECTION_URL, DB_USER_NAME , DB_PASSWORD);
      }
      catch (Exception e)		{
        System.out.println("ERROR :-  "+e);
        conn = null;
      }
    return conn;
  }
}
