Connection connection = DriverManager.getConnection(
		"jdbc:oracle:thin:", "scott", "tiger");
PreparedStatement statement = connection.prepareStatement(
		"SELECT * FROM foo WHERE name=?");
statement.setString(1, "tk");
ResultSet result = statement.executeQuery();

