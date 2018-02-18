import java.sql.*;
import oracle.jdbc.driver.*;

public clas jdbcTest{
  jdbcTest(){
  }
  public static void main(String args[]){
    try{
      DriverManager.registerDriver(
		      new OracleDriver());
      Connection connection = 
	      DriverManager.getConnection("jdbc:oracle:thin",
			      "scott", "tiger");
      connection.setAutoCommit(false);
      Statement statement =
	      connection.createStatement();
      try{
        statement.execute(
			"INSERT INTO foo VALUES('tky', 23, '090-1111-1111')");
	statement.execute(
			"INSERT INTO foo VALUES('tky', 23, '090-2222-2222')");
	connection.commit();
      }
      catch(SQLException ex){
        System.out.println(ex.toString());
	connection.rollback();
      }
      statement.close();
      connection.close();
    }
    catch(SQLException ex){
      System.out.println(ex.toString());
    }
  }
}

