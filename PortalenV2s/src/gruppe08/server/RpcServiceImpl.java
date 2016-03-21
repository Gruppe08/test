package gruppe08.server;


import gruppe08.client.rpc.RpcService;
import gruppe08.shared.Person;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;

/**
 * The server-side implementation of the RPC service.
 */
@SuppressWarnings("serial")
public class RpcServiceImpl extends RemoteServiceServlet implements RpcService {

	private static final String URL = "jdbc:mysql://localhost:3306/doek15";
	private static final String USERNAME = "root";
	private static final String PASSWORD = "grisling1";
	private static Connection connection = null;
	
	public RpcServiceImpl() {
		try {
			connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
		} catch (SQLException sqlException) {
			sqlException.printStackTrace();
			System.exit(1);
		}
	}
	
	private static void close() {
		try {
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public Person authorizeUser(String username, String password) throws IllegalArgumentException {
		System.out.println("THIS IS A TEST THIS IS A TEST");
		ResultSet resultSet = null;
		Person user = null;
		
		
		try {
			
			PreparedStatement getUser = connection.prepareStatement("SELECT * FROM brugere where navn = ? AND kodeord = ?");
			getUser.setString(1, username);
			getUser.setString(2, password);
			resultSet = getUser.executeQuery();
			while (resultSet.next()) {
					user = new Person(resultSet.getString("navn"), resultSet.getString("kodeord"), "https://scontent-ams3-1.xx.fbcdn.net/hphotos-xfp1/v/l/t1.0-9/522337_3735025689708_1964239124_n.jpg?oh=23427e806608de240d0402aaae448c7a&oe=572FE3B8", 'm', "Flot Desc");
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				resultSet.close();
			} catch (SQLException ex) {
				ex.printStackTrace();
//				close();
			}
		}
		return user;
	}
	
	
	@Override
	public String test() throws IllegalArgumentException {
		// TODO Auto-generated method stub
		return "hello";
	}

	
}

