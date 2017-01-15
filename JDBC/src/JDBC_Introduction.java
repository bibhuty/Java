import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBC_Introduction {
	//JDBC driver name and database URL
	final String JDBC_DRIVER="oracle.jdbc.driver.OracleDriver";
	final String DB_URL="jdbc:oracle:thin:@localhost:1521:xe";
	
	//Database Credentials
	final String USERNAME="hr";
	final String PASSWORD="neiogrin";
	
	public static void main(String[] args) {
		@SuppressWarnings("unused")
		JDBC_Introduction jdbc_Demo = new JDBC_Introduction();
		//jdbc_Demo.getEmployeeInformation();
		//jdbc_Demo.getEmployeeMetadataInformation();
		//jdbc_Demo.databaseMetadataDemo();
		//jdbc_Demo.preparedStatementDemo();
		//jdbc_Demo.scrollableResultSetDemo();
		//jdbc_Demo.updatableResultSetDemo();
		
	}
	
	//01. Steps of JDBC
	@SuppressWarnings("unused")
	private void getEmployeeInformation(){
		Connection connection=null;
		/*
		 * Statement:
		 * 	- A statement object encapsulates a SQL statement which is passed to the
		 * 	  database to be parsed, compiled, planned and executed.
		 * 	- It is used to execute static queries unlike prepared statement
		 */
		Statement stmt=null;
		try{
			//Step 1: Register the JDBC driver
			Class.forName(JDBC_DRIVER);
			
			//Step 2: Open a connection
			System.out.println("Connecting to database......");
			connection=DriverManager.getConnection(DB_URL, USERNAME, PASSWORD);
			
			//Step 3: Execute a query
			System.out.println("Creating a statement");
			System.out.println("---------------------------------------------------------------------------------");
			stmt=connection.createStatement();
			String sql="SELECT EMPLOYEE_ID,FIRST_NAME,LAST_NAME,EMAIL,PHONE_NUMBER FROM EMPLOYEES";
			ResultSet rs=stmt.executeQuery(sql);
			
			
			//Step 4: Extract data from the result set
			System.out.println("------------------------------------------------");
			while(rs.next()){
				//Retrieve the column name
				int id=rs.getInt("EMPLOYEE_ID");
				String firstname=rs.getString("FIRST_NAME");
				String lastname=rs.getString("LAST_NAME");
				String email=rs.getString("EMAIL");
				String phoneNumber=rs.getString("PHONE_NUMBER");
				
				//Display the values
				System.out.println("ID: "+id);
				System.out.println("Firstname: "+firstname);
				System.out.println("Lastname: "+lastname);
				System.out.println("Email: "+email);
				System.out.println("PhoneNumber: "+phoneNumber);	
				System.out.println("------------------------------------------------");
			}				

			//Step 5: Close resources
			rs.close();
		}catch(SQLException sqlException) {
			sqlException.printStackTrace();
		}catch(ClassNotFoundException e){
			e.printStackTrace();
		}finally{
			//It is advisable to use this to close resources
			try{
				if(stmt!=null)stmt.close();
			}catch(SQLException sqlException){
				sqlException.printStackTrace();
			}
			
			try{
				if(connection!=null)connection.close();
			}catch(SQLException sqlException){
				sqlException.printStackTrace();
			}
		}
	}

	//02. ResultSetMetadata(i.e. information about the data we are fetching)
	@SuppressWarnings("unused")
	private void getEmployeeMetadataInformation(){
		Connection connection=null;
		Statement stmt=null;
		try{
			//Step 1: Register the JDBC driver
			Class.forName(JDBC_DRIVER);
			
			//Step 2: Open a connection
			System.out.println("Connecting to database......");
			connection=DriverManager.getConnection(DB_URL, USERNAME, PASSWORD);
			
			//Step 3: Execute a query
			System.out.println("Creating a statement");
			System.out.println("---------------------------------------------------------------------------------");
			stmt=connection.createStatement();
			String sql="SELECT EMPLOYEE_ID,FIRST_NAME,LAST_NAME,EMAIL,PHONE_NUMBER FROM EMPLOYEES";
			ResultSet rs=stmt.executeQuery(sql);
			ResultSetMetaData rsmd=rs.getMetaData();//ResultSetMetaData contains various useful interfaces
			int columnCount=rsmd.getColumnCount();
			
			
			//Step 4: Extract data from the result set
			System.out.println("Nubmber of columns are "+columnCount);
			System.out.println("------------------------------------------------");
			for(int i=1;i<=columnCount;++i){
				String columnName=rsmd.getColumnName(i);
				String columnType=rsmd.getColumnTypeName(i);
				int columnDisplaySize=rsmd.getColumnDisplaySize(i);
				System.out.println("Column name is "+columnName+"\nColumn type is "+columnType+"\nColumn size is "+columnDisplaySize+"\n");
			}

			//Step 5: Close resources
			rs.close();
		}catch(SQLException sqlException) {
			sqlException.printStackTrace();
		}catch(ClassNotFoundException e){
			e.printStackTrace();
		}finally{
			//It is advisable to use to close resources
			try{
				if(stmt!=null)stmt.close();
			}catch(SQLException sqlException){
				sqlException.printStackTrace();
			}
			
			try{
				if(connection!=null)connection.close();
			}catch(SQLException sqlException){
				sqlException.printStackTrace();
			}
		}
	}

	//03. Database Metadata
	@SuppressWarnings("unused")
	private void databaseMetadataDemo(){
		Connection connection=null;
		Statement stmt=null;
		try{
			//Step 1: Register the JDBC driver
			Class.forName(JDBC_DRIVER);
			
			//Step 2: Open a connection
			System.out.println("Connecting to database......");
			connection=DriverManager.getConnection(DB_URL, USERNAME, PASSWORD);
			DatabaseMetaData dbmd=connection.getMetaData();

			//Step 3: Fetch the data
			System.out.println("Driver name is "+dbmd.getDriverName());
			System.out.println("Driver version is "+dbmd.getDriverVersion());
			System.out.println("Username is "+dbmd.getUserName());
			System.out.println("Database product name is "+dbmd.getDatabaseProductName());
			System.out.println("Database product version is "+dbmd.getDatabaseProductVersion());
			
			
		}catch(SQLException sqlException) {
			sqlException.printStackTrace();
		}catch(ClassNotFoundException e){
			e.printStackTrace();
		}finally{
			//It is advisable to use to close resources
			try{
				if(stmt!=null)stmt.close();
			}catch(SQLException sqlException){
				sqlException.printStackTrace();
			}
			
			try{
				if(connection!=null)connection.close();
			}catch(SQLException sqlException){
				sqlException.printStackTrace();
			}
		}
	}
	
	//04. Prepared Statement
	@SuppressWarnings("unused")
	private void preparedStatementDemo(){
		Connection connection=null;
		/*
		 * - Prepared Statement:
		 * 		~ It is parameterized query, compiled only once and executed many times
		 * 		~ It is used for execution of dynamic query
		 * */
		PreparedStatement stmt=null;
		try{
			//Step 1: Register the JDBC driver
			Class.forName(JDBC_DRIVER);
			
			//Step 2: Open a connection
			System.out.println("Connecting to database......");
			connection=DriverManager.getConnection(DB_URL, USERNAME, PASSWORD);
			
			//Step 3: Execute a query
			System.out.println("Creating a statement");
			System.out.println("---------------------------------------------------------------------------------");
			String sql="SELECT * FROM EMPLOYEES WHERE EMPLOYEE_ID=?";
			stmt=connection.prepareStatement(sql);
			stmt.setString(1,"100");
			ResultSet rs=stmt.executeQuery();
			
			
			//Step 4: Extract data from the result set
			System.out.println("------------------------------------------------");
			while(rs.next()){
				//Retrive the column name
				int id=rs.getInt(1);
				String firstname=rs.getString(2);
				String lastname=rs.getString(3);
				String email=rs.getString(4);
				String phoneNumber=rs.getString(5);
				
				//Display the values
				System.out.println("ID: "+id);
				System.out.println("Firstname: "+firstname);
				System.out.println("Lastname: "+lastname);
				System.out.println("Email: "+email);
				System.out.println("PhoneNumber: "+phoneNumber);	
				System.out.println("------------------------------------------------");
			}				

			//Step 5: Close resources
			rs.close();
		}catch(SQLException sqlException) {
			sqlException.printStackTrace();
		}catch(ClassNotFoundException e){
			e.printStackTrace();
		}finally{
			//It is advisable to use to close resources
			try{
				if(stmt!=null)stmt.close();
			}catch(SQLException sqlException){
				sqlException.printStackTrace();
			}
			
			try{
				if(connection!=null)connection.close();
			}catch(SQLException sqlException){
				sqlException.printStackTrace();
			}
		}
	}


	//05. ScrollableResultset
	@SuppressWarnings("unused")
	private void scrollableResultSetDemo(){
		/*
		 * Using ScrollableResultSet we can move the cursor in forward as well as backward direction in any manner
		 */		
		Connection connection=null;
		PreparedStatement preparedStatement=null;
		try{
			Class.forName(JDBC_DRIVER);
			connection=DriverManager.getConnection(DB_URL, USERNAME, PASSWORD);
			String sql="SELECT * FROM EMPLOYEES WHERE EMPLOYEE_ID>?";
			preparedStatement=connection.prepareStatement(sql, ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_UPDATABLE);
			preparedStatement.setString(1, "195");
			ResultSet rs=preparedStatement.executeQuery();
			
			System.out.println("---------Resultset in forward direction------------");
			while(rs.next()){
				int id=rs.getInt("EMPLOYEE_ID");
				String firstname=rs.getString("FIRST_NAME");
				String lastname=rs.getString("LAST_NAME");
				String email=rs.getString("EMAIL");
				String phoneNumber=rs.getString("PHONE_NUMBER");
				
				System.out.println("ID: "+id);
				System.out.println("Firstname: "+firstname);
				System.out.println("Lastname: "+lastname);
				System.out.println("Email: "+email);
				System.out.println("PhoneNumber: "+phoneNumber);
				System.out.println();
			}
			
			System.out.println("---------Resultset in backward direction---------------");
			rs.last(); 
			while(rs.previous()){
				int id=rs.getInt("EMPLOYEE_ID");
				String firstname=rs.getString("FIRST_NAME");
				String lastname=rs.getString("LAST_NAME");
				String email=rs.getString("EMAIL");
				String phoneNumber=rs.getString("PHONE_NUMBER");
				
				System.out.println("ID: "+id);
				System.out.println("Firstname: "+firstname);
				System.out.println("Lastname: "+lastname);
				System.out.println("Email: "+email);
				System.out.println("PhoneNumber: "+phoneNumber);
				System.out.println();
			}
			
			System.out.println("-------------Result set in a particular point---------------");
			rs.absolute(3);
			int id=rs.getInt("EMPLOYEE_ID");
			String firstname=rs.getString("FIRST_NAME");
			String lastname=rs.getString("LAST_NAME");
			String email=rs.getString("EMAIL");
			String phoneNumber=rs.getString("PHONE_NUMBER");
			
			System.out.println("ID: "+id);
			System.out.println("Firstname: "+firstname);
			System.out.println("Lastname: "+lastname);
			System.out.println("Email: "+email);
			System.out.println("PhoneNumber: "+phoneNumber);
			System.out.println();
			
			rs.close();
		}catch(SQLException sqlException) {
			sqlException.printStackTrace();
		}catch(ClassNotFoundException e){
			e.printStackTrace();
		}finally{
			//It is advisable to use this to close resources
			try{
				if(preparedStatement!=null)preparedStatement.close();
			}catch(SQLException sqlException){
				sqlException.printStackTrace();
			}
			
			try{
				if(connection!=null)connection.close();
			}catch(SQLException sqlException){
				sqlException.printStackTrace();
			}
		}
	}

	//06.UpdatableResultSet(Doubt)
	@SuppressWarnings("unused")
	private void updatableResultSetDemo(){
		/*
		 * Using UpdatableResultSet we can update or insert new row in a database
		 */
		Connection connection=null;
		PreparedStatement preparedStatement=null;
		try{
			Class.forName(JDBC_DRIVER);
			connection=DriverManager.getConnection(DB_URL, USERNAME, PASSWORD);
			String sql="SELECT * FROM COUNTRIES WHERE COUNTRY_ID>?";
			preparedStatement=connection.prepareStatement(sql, ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_UPDATABLE);
			preparedStatement.setString(1, "0");
			ResultSet rs=preparedStatement.executeQuery();
			
			rs.absolute(7);
			rs.updateString("COUNTRY_NAME", "CHINAA");
			rs.updateRow();
			System.out.println("7th row of the column is updated");
			
			rs.close();
		}catch(SQLException sqlException) {
			sqlException.printStackTrace();
		}catch(ClassNotFoundException e){
			e.printStackTrace();
		}finally{
			//It is advisable to use this to close resources
			try{
				if(preparedStatement!=null)preparedStatement.close();
			}catch(SQLException sqlException){
				sqlException.printStackTrace();
			}
			
			try{
				if(connection!=null)connection.close();
			}catch(SQLException sqlException){
				sqlException.printStackTrace();
			}
		}
	}
	
}
	

