Connection connection = DriverManger.getConnection(
		"jdbc:oracle:thin:", "scott", "tiger");
PreparedStatement statement = connection.prepareCall(
		"{call p_foo(?,?,?)}");
statement.setString(1, "tk");
statement.setInt(2,22);
statement.setString(3, "090-1111-1111")
statement.executeUpdate();

