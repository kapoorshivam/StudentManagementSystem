
import java.sql.*;
import static commons.Constants.*;
public class Student
{
  public static Statement stmt;
  public static Connection conn;
  public static ResultSet rs;

  public int rollNo;
  public String fullName;
  public String dateOfBirth;
  public String gender;
  public String phoneNumber;
  public String branch;

/*----------------------------------------------------------------------------*/
  public int getRollNo()
  {
    return rollNo;
  }
  public void setRollNo(int rollNo)
  {
    this.rollNo = rollNo;
  }
/*----------------------------------------------------------------------------*/
  public String getFullName()
  {
    return fullName;
  }
  public void setFullName(String fullName)
  {
    this.fullName = fullName;
  }
/*----------------------------------------------------------------------------*/
  public String getDateOfBirth()
  {
    return dateOfBirth;
  }
  public void setDateOfBirth(String dateOfBirth)
  {
    this.dateOfBirth = dateOfBirth;
	}
/*----------------------------------------------------------------------------*/
  public String getGender()
  {
    return gender;
  }
    public void setGender(String gender)
  {
    this.gender = gender;
  }
/*----------------------------------------------------------------------------*/
  public String getPhoneNumber()
  {
    return phoneNumber;
  }
    public void setPhoneNumber(String phoneNumber)
  {
    this.phoneNumber = phoneNumber;
	}
/*----------------------------------------------------------------------------*/
  public String getBranch()
  {
    return branch;
  }
    public void setBranch(String branch)
  {
    this.branch = branch;
  }

/*---------------------------------------------------1-------------------------------------------------------------------------------------*/
/*this method will be used to store information into the database by taking input from the user*/
  public boolean saveDetails(Connection conn)
  {
    try
    {
      stmt = conn.createStatement();
      String sql = "INSERT INTO TEST11 VALUES ('"+rollNo+"','"+fullName+"','"+dateOfBirth+"', '"+gender+"' ,'"+phoneNumber+"' , '"+branch+"')";
      stmt.executeUpdate(sql);
      conn.close();
      System.out.println("\t\t\tDetails Saved Sucessfully");
      return true;
    }
      catch (SQLException sqle)
      {
        System.out.println("\t\t\t EROOR IN INPUTING DATA ");
        System.out.println("ERROR :: "+ sqle);
      }
        System.out.println("\t\t\tDETAILS NOT SAVED TRY AGAIN");
        return false;
  }
/*-------------------------------------------------2---------------------------------------------------------------------------------------*/
/*this method will be used to search student details from database by taking input from the user that's is ROLLNO*/
  public boolean searchDetails(Connection conn)
  {
    try
    {
      stmt = conn.createStatement();
      String queryString = "SELECT * FROM TEST11 WHERE ROLLNO =  '" +rollNo + "'";
      rs = stmt.executeQuery(queryString);
      if(rs.next())
      {
        System.out.format("%15s%15s%15s%15s%15s%15s","Roll No.", "Name", "Date Of Birth","Gender","Phone Num", "Branch" );
        System.out.print("\n");
        System.out.format("%15s%15s%15s%15s%15s%15s" , rs.getInt("ROLLNO"), rs.getString("NAME"),rs.getString("DATEOFBIRTH"),
                                                       rs.getString("GENDER"),rs.getString("PHONENUM"),rs.getString("BRANCH"));
        System.out.println("");
      }
      	else
      	{
        	System.out.println("\t\t\tRoll Number Not Found In DB");
        	conn.close();
      	}
        return true;
    }
      catch (SQLException sqle1)
      {
        System.out.println("\t\t\t EROOR IN SHOWING DATA ");
        System.out.println("ERROR :: "+ sqle1);
      }
        return false;
  }

/*-------------------------------------------------------------3---------------------------------------------------------------------------*/
  /* This method will be used to print the updated details  */
  public boolean updateDetails(Connection conn)
  {
    try
    {
      stmt = conn.createStatement();
      String sql = "UPDATE TEST11 SET NAME = '"+fullName+"', DATEOFBIRTH = '"+dateOfBirth+"', GENDER = '"+gender+"', PHONENUM = '"+phoneNumber+"' , BRANCH = '"+branch+"' Where ROLLNO = '"+rollNo+"'";
      stmt.executeUpdate(sql);
      String queryString = "SELECT * FROM TEST11 WHERE ROLLNO =  '" +rollNo + "'";
      rs = stmt.executeQuery(queryString);
      if(rs.next())
      {
        System.out.format("%15s%15s%15s%15s%15s%15s","Roll No.", "Name", "Date Of Birth","Gender","Phone Num", "Branch" );
        System.out.print("\n");
        System.out.format("%15s%15s%15s%15s%15s%15s" , rs.getInt("ROLLNO"), rs.getString("NAME"),rs.getString("DATEOFBIRTH"),
                                                       rs.getString("GENDER"),rs.getString("PHONENUM"),rs.getString("BRANCH"));
        System.out.println("");
        System.out.println("\t\t\tDetails Sucessfully Updated");
      }
      	else
      	{
        	System.out.println("\t\t\tRoll Number Not Found In DB");
        	conn.close();
      	}
        return true;
    }
      catch (SQLException sqle1)
      {
        System.out.println("\t\t\t EROOR IN SHOWING DATA ");
        System.out.println("ERROR :: "+ sqle1);
      }
        return false;
  }
/*------------------------------------------------------------4----------------------------------------------------------------------------*/
/* This method will be used to delete details from the database  */
  public boolean deleteDetails(Connection conn)
  {
    try
    {
      stmt = conn.createStatement();
      String sql = "DELETE FROM TEST11 WHERE ROLLNO =  '" +rollNo + "'";
      stmt.executeUpdate(sql);
      conn.close();
      return true;
    }
    catch (SQLException sqle1)
    {
      System.out.println("\t\t\t ERROR IN SHOWING DATA ");
      System.out.println("ERROR :: "+ sqle1);
    }
    return false;
  }
/*------------------------------------------------------------5----------------------------------------------------------------------------*/
/* This method will be used to print all the details that are present in the database */
  public boolean printDetails(Connection conn)
  {
    try
    {
      stmt = conn.createStatement();
      String queryString = "SELECT * FROM TEST11 ";
      rs = stmt.executeQuery(queryString);
      System.out.format("%15s%15s%15s%15s%15s%15s","Roll No.", "Name", "Date Of Birth","Gender","Phone Num", "Branch" );
      System.out.print("\n");
      while(rs.next())
      {
        System.out.format("%15s%15s%15s%15s%15s%15s" , rs.getInt("ROLLNO"), rs.getString("NAME"),rs.getString("DATEOFBIRTH"),
                                                       rs.getString("GENDER"),rs.getString("PHONENUM"),rs.getString("BRANCH"));
        System.out.println("");
      }
      conn.close();
      return true;
    }
      catch (SQLException sqle1)
      {
        System.out.println("\t\t\t EROOR IN SHOWING DATA ");
        System.out.println("ERROR :: "+ sqle1);
      }
        return false;
  }
}
