import java.sql.*;
import oracle.jdbc.driver.*;

public class jdbcTest {
  jdbcTest(){
  }
  public static void main(String args[]){
    try{
      DriverManager.registerDriver(
		      new OracleDrivere());
      Connection connection =
	      DriverManger.getConnecton("jdbc:oracle:thin:",
			      "scott", "tiger");
      Statement statement =
	      connection.createStatement();
      ResultSet result =
	      statement.executeQuery("SELECT * FROM foo");
      String name;
      int age;
      String telephone;
      while( result.next() != false ){
        name = result.getString("name");
	age = result.getInt("age");
	telephone = result.getString("telephone");
      }
      result.close();
      result = null;
      statement.execute(
		      "INSERT INTO foo VALUES('tky', 33, '090-1111-1111')");
      statement.close();
      statement = null;
      connection.close();
      connection = null;
    }
    catch(SQLException ex){
      System.out.println(ex.toString());
    }
  }
}

