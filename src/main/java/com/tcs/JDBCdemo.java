Skip to content
Search or jump to…
Pull requests
Issues
Marketplace
Explore
 
@swapbhosale 
tcspariwesh
/
JDBC-practice
1
00
Code
Issues
Pull requests
Actions
Projects
Wiki
Security
Insights
JDBC-practice/src/main/java/com/tcs/jdbc/demo/JDBCDemo.java
@ibmpariwesh
ibmpariwesh jdbc basics
Latest commit b823e65 30 minutes ago
 History
 1 contributor
35 lines (30 sloc)  1.03 KB
  
package com.tcs.jdbc.demo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBCDemo {
	public static void main(String[] args) {
		String DB_URL = "jdbc:mysql://localhost:3306/practice";
		String DB_USER = "root";
		String DB_PASSWORD = "root";

		try (Connection connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
				Statement statement = connection.createStatement();) {
//			create(statement); // create
			retrieve(statement);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	private static void retrieve(Statement statement) throws SQLException {
		ResultSet resultSet = statement.executeQuery("SELECT * from regions");
		while (resultSet.next()) {
			System.out.println(resultSet.getInt(1));
			System.out.println(resultSet.getNString("REGION_NAME"));
		}
	}

	private static void create(Statement statement) throws SQLException {
		statement.execute("INSERT INTO REGIONS VALUES(2, 'North America')");
	}
}
© 2021 GitHub, Inc.
Terms
Privacy
Security
Status
Docs
Contact GitHub
Pricing
API
Training
Blog
About
