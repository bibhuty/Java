import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBC_Operations {
	
	//JDBC driver name and database URL
	final String JDBC_DRIVER="oracle.jdbc.driver.OracleDriver";
	final String DB_URL="jdbc:oracle:thin:@localhost:1521:xe";
		
	//Database Credentials
	final String USERNAME="hr";
	final String PASSWORD="neiogrin";
		
	public static void main(String[] args) {
		JDBC_Operations jdbc_Operations=new JDBC_Operations();
		//jdbc_Operations.operationsDemo();
		jdbc_Operations.batchProcessingDemo();
	}
	
	//Basis CRUD operations
	@SuppressWarnings("unused")
	private void operationsDemo(){
		Connection connection=null;
		PreparedStatement preparedStatement=null;
		try{
			Class.forName(JDBC_DRIVER);
			
			System.out.println("Connecting to database.......");
			connection=DriverManager.getConnection(DB_URL, USERNAME, PASSWORD);
			
			System.out.println("Statement creation...");
			
			//Insertion statement of SQL
			/*
			String sql="INSERT INTO CUSTOMERS (ID,NAME,AGE,SEX,BALANCE) VALUES (?,?,?,?,?)";
			preparedStatement=connection.prepareStatement(sql);
			preparedStatement.setInt(1, 12);
			preparedStatement.setString(2, "BONTY");
			preparedStatement.setInt(3, 22);
			preparedStatement.setString(4, "M");
			preparedStatement.setInt(5, 6263);
			*/
			
			//Update statement of SQL
			String sql="UPDATE CUSTOMERS SET NAME=? WHERE ID=?";
			preparedStatement=connection.prepareStatement(sql);
			preparedStatement.setString(1, "GELU");
			preparedStatement.setInt(2, 11);
			
			//Delete, Like, Sorting etc can be used
			
			
			int numberOfRowsInserted=preparedStatement.executeUpdate();
			System.out.println("Number of rows operated are "+numberOfRowsInserted);
			
			
		}catch(SQLException sqlException) {
			sqlException.printStackTrace();
		}catch(ClassNotFoundException e){
			e.printStackTrace();
		}finally{
			//It is advisable to use to close resources
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

	//BatchProcessing Statement
	private void batchProcessingDemo(){
		Connection connection=null;
		Statement statement=null;
		/*
		 * In the case of prepared statement we simply do the operations as usual and 
		 * then at the end add the statement as follows:
		 * preparedStatement.addBatch();
		 */
		try{
			Class.forName(JDBC_DRIVER);
			
			System.out.println("Connecting to database.......");
			connection=DriverManager.getConnection(DB_URL, USERNAME, PASSWORD);
			connection.setAutoCommit(false);
		
			String sql1="INSERT INTO CUSTOMERS (ID,NAME,AGE,SEX,BALANCE) VALUES (13,'BRAN',13,'M',9000)";
			String sql2="INSERT INTO CUSTOMERS (ID,NAME,AGE,SEX,BALANCE) VALUES (14,'RICON',9,'M',8000)";
			String sql3="INSERT INTO CUSTOMERS (ID,NAME,AGE,SEX,BALANCE) VALUES (15,'ARYA',10,'F',4000)";
			
			statement=connection.createStatement();
			
			statement.addBatch(sql1);
			statement.addBatch(sql2);
			statement.addBatch(sql3);
			
			int result[]=statement.executeBatch();
			
			connection.commit();
			
			for(int i=0;i<result.length;++i)System.out.println(result[i]);
			
			
			
		}catch(SQLException sqlException) {
			try{
				connection.rollback();
			}catch(SQLException e){
				e.printStackTrace();
			}
			sqlException.printStackTrace();
		}catch(ClassNotFoundException e){
			e.printStackTrace();
		}finally{
			try{
				if(statement!=null)statement.close();
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
