/**
 * 
 */
package com.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;


import com.dao.*;
import com.database.Database;



public class UserDAO 
{
	private static Connection connection = null;
	private static Statement statement = null;
	private static ResultSet resultSet = null;
	private static UserDAO userDAO=null;
	private UserDAO()
	{
		
	}
	public static UserDAO getInstance()
	{
		if(userDAO == null)
		{
			userDAO= new UserDAO();
		}
		return userDAO;
	}
	
	public static boolean checkUserID(String userid)
	{
		boolean flag=false;
		try
		{
			Database database = Database.getInstance();
			connection =database.connector();
			statement=connection.createStatement();
			String sql="select * from m_user where userid='"+userid+"'";
			System.out.println("sql  -->"+sql);
			resultSet =statement.executeQuery(sql);
			while(resultSet.next())
			{
				flag=true;
			}
			System.out.println("Flag value for new user check-->"+flag);
		}
		
		catch (Exception e) {
			System.out.println("Exception in USERDAO checkUSerID");
		}
		return flag;
	}
	
	public static String getRNSKeyFromDB(String ownerid ) 
	{
		boolean flag=false;
		String key1="";
		try
		{
			
			Database database = Database.getInstance();
			connection=database.connector();
			statement = connection.createStatement();
			String sql="select do_key1 from m_owner where ownerid='"+ownerid+"'";
			System.out.println("  sql :"+sql);
			resultSet =statement.executeQuery(sql);
			while(resultSet.next())
			{
				key1=resultSet.getString(1);
				System.out.println("Key 1 :"+key1);
			}
			
			flag=true;
			
			
		}
		catch(Exception e)
		{
			System.out.println("Opp's Error is in CommonDAO-getUserID()....."+e);
		}
		return key1;
	}
	
	public static String getU_ID_Token(String userid ) 
	{
		boolean flag=false;
		String token="";
		try
		{
			
			Database database = Database.getInstance();
			connection=database.connector();
			statement = connection.createStatement();
			String sql="select u_tocken_id from m_user where userid='"+userid+"'";
			System.out.println("  sql :"+sql);
			resultSet =statement.executeQuery(sql);
			while(resultSet.next())
			{
				token=resultSet.getString(1);
			
			}
			
			flag=true;
			
			
		}
		catch(Exception e)
		{
			System.out.println("Opp's Error is in CommonDAO-getU_ID_Token()....."+e);
		}
		return token;
	}
	
	
	
	public static ArrayList<String> getCloud()
	{
		ArrayList<String> list = new ArrayList<String>();
		try
		{
			Database database = Database.getInstance();
			connection=database.connector();
			statement = connection.createStatement();
			resultSet = statement.executeQuery("select c_url,c_username,c_password from m_cloud where c_id='1'");
		
			while(resultSet.next())
			{
				list.add(resultSet.getString(1));
				list.add(resultSet.getString(2));
				list.add(resultSet.getString(3));
			}
			
		}
		catch(Exception e)
		{
			System.out.println("Exception in UserProcess-->getFiles(String userid): "+ e);
		}
		finally
		{
			try {
				resultSet.close();
				statement.close();
				connection.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		return list;
	}
	public static ArrayList<String> getsubCloud(int sub_serverid)
	{
		ArrayList<String> list = new ArrayList<String>();
		try
		{
			Database database = Database.getInstance();
			connection=database.connector();
			statement = connection.createStatement();
			resultSet = statement.executeQuery("select c_url,c_username,c_pass from m_cloud where c_id='"+sub_serverid+"'");
		
			while(resultSet.next())
			{
				list.add(resultSet.getString(1));
				list.add(resultSet.getString(2));
				list.add(resultSet.getString(3));
			}
			
		}
		catch(Exception e)
		{
			System.out.println("Exception in UserProcess-->getFiles(String userid): "+ e);
		}
		finally
		{
			try {
				resultSet.close();
				statement.close();
				connection.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		return list;
	}
	public static ArrayList<String> getSubCloud(int csid)
	{
		ArrayList<String> list = new ArrayList<String>();
		try
		{
			
			Database database = Database.getInstance();
			connection=database.connector();
			statement = connection.createStatement();
			resultSet = statement.executeQuery("select c_url,c_username,c_password from m_cloud where c_id='"+csid+"'");
		
			while(resultSet.next())
			{
				list.add(resultSet.getString(1));
				list.add(resultSet.getString(2));
				list.add(resultSet.getString(3));
			}
			
		}
		catch(Exception e)
		{
			System.out.println("Exception in UserProcess-->getFiles(String userid): "+ e);
		}
		finally
		{
			try {
				resultSet.close();
				statement.close();
				connection.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		return list;
	}
	public static ArrayList<String> getSubCloud_details(int sid)
	{
		ArrayList<String> list = new ArrayList<String>();
		try
		{
			String sql="select server_id,server_name,server_ip,server_port from m_process_server where server_id='"+sid+"'";
			System.out.println("sql~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~:"+sql);
			Database database = Database.getInstance();
			connection=database.connector();
			statement = connection.createStatement();
			resultSet = statement.executeQuery(sql);
		
			while(resultSet.next())
			{
				list.add(resultSet.getString(1));
				list.add(resultSet.getString(2));
				list.add(resultSet.getString(3));
				list.add(resultSet.getString(4));
			}
			
		}
		catch(Exception e)
		{
			System.out.println("Exception in UserProcess-->getFiles(String userid): "+ e);
		}
		finally
		{
			try {
				resultSet.close();
				statement.close();
				connection.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		return list;
	}
	public static int getCloud1()
	{
		int id=0;
		try
		{
			Database database = Database.getInstance();
			connection=database.connector();
			statement = connection.createStatement();
			resultSet = statement.executeQuery("select c_id from m_cloud where c_id='1'");
		
			while(resultSet.next())
			{
				id = resultSet.getInt(1);
			}
			
		}
		catch(Exception e)
		{
			System.out.println("Exception in UserProcess-->getFiles(String userid): "+ e);
		}
		finally
		{
			try {
				resultSet.close();
				statement.close();
				connection.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		return id;
	}
	public static int getServerId_lookup(String ip)
	{
		int id=0;
		try
		{
			String sql="select server_id from m_lookup where ip_address='"+ip+"' limit 1 ";
			Database database = Database.getInstance();
			connection=database.connector();
			statement = connection.createStatement();
			resultSet = statement.executeQuery(sql);
		System.out.println("sql:"+sql);
			while(resultSet.next())
			{
				id = resultSet.getInt(1);
			}
			
		}
		catch(Exception e)
		{
			System.out.println("Exception in UserProcess-->getFiles(String userid): "+ e);
		}
		finally
		{
			try {
				resultSet.close();
				statement.close();
				connection.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		return id;
	}
	public static String getupRNSKeyFromDB(String username ) 
	{
		boolean flag=false;
		String key1="";
		try
		{
			
			Database database = Database.getInstance();
			connection=database.connector();
			statement = connection.createStatement();
			String sql="select do_key1 from m_owner where ownerid='"+username+"'";
			System.out.println("  sql :"+sql);
			resultSet =statement.executeQuery(sql);
			while(resultSet.next())
			{
				key1=resultSet.getString(1);
				//System.out.println("Key 1 :"+key1);
			}
			
			flag=true;
			
			
		}
		catch(Exception e)
		{
			System.out.println("Opp's Error is in CommonDAO-getUserID()....."+e);
		}
		return key1;
	}
	
	public static int getAccess_Code(int f_id) 
	{
		boolean flag=false;
		int d_code=0;
		try
		{
			
			Database database = Database.getInstance();
			connection=database.connector();
			statement = connection.createStatement();
			String sql="select domain_code from m_acess_control where f_code='"+f_id+"'";
			
			resultSet =statement.executeQuery(sql);
			while(resultSet.next())
			{
				d_code=resultSet.getInt(1);
				
			}
			
			flag=true;
			
			System.out.println("Clud Flag : "+flag);
		}
		catch(Exception e)
		{
			System.out.println("Opp's Error is in CommonDAO-getUserID()....."+e);
		}
		return d_code;
	}
	
	public static int getAccess_DCode(int f_id) 
	{
		boolean flag=false;
		int d_code=0;
		try
		{
			
			Database database = Database.getInstance();
			connection=database.connector();
			statement = connection.createStatement();
			String sql="select subdomain_code from m_acess_control where f_code='"+f_id+"'";
		//	System.out.println("Subdomain querry is-->"+sql);
			resultSet =statement.executeQuery(sql);
			
			while(resultSet.next())
			{
				d_code=resultSet.getInt(1);
				
			}
			
			flag=true;
			
			
		}
		catch(Exception e)
		{
			System.out.println("Opp's Error is in CommonDAO-getUserID()....."+e);
		}
		return d_code;
	}
	
	public static String getRNSKeyFromDB1() 
	{
		boolean flag=false;
		String key1="";
		try
		{
			
			Database database = Database.getInstance();
			connection=database.connector();
			statement = connection.createStatement();
			String sql="select do_key1 from m_owner";
			
			resultSet =statement.executeQuery(sql);
			while(resultSet.next())
			{
				key1=resultSet.getString(1);
				//System.out.println("Key 1 :"+key1);
			}
			
			flag=true;
			
			System.out.println("Clud Flag : "+flag);
		}
		catch(Exception e)
		{
			System.out.println("Opp's Error is in CommonDAO-getUserID()....."+e);
		}
		return key1;
	}
	
	public static String getDESKeyFromDB(String key,String ownerid) 
	{
		boolean flag=false;
		String key2="";
		try
		{
			
			Database database = Database.getInstance();
			connection=database.connector();
			statement = connection.createStatement();
			String sql="select "+key+" from m_owner where ownerid='"+ownerid+"'";
			System.out.println("  sql :"+sql);
			resultSet =statement.executeQuery(sql);
			while(resultSet.next())
			{
				key2=resultSet.getString(1);
				System.out.println("Key 2 :"+key2);
			}
			
			flag=true;
			
			
		}
		catch(Exception e)
		{
			System.out.println("Opp's Error is in CommonDAO-getUserID()....."+e);
		}
		return key2;
	}
	
	public static String getupDESKeyFromDB(String username) 
	{
		boolean flag=false;
		String key2="";
		try
		{
			
			Database database = Database.getInstance();
			connection=database.connector();
			statement = connection.createStatement();
			String sql="select do_key2 from m_owner where ownerid='"+username+"'";
			System.out.println("  sql :"+sql);
			resultSet =statement.executeQuery(sql);
			while(resultSet.next())
			{
				key2=resultSet.getString(1);
				System.out.println("Key 2 :"+key2);
			}
			
			flag=true;
			
			
		}
		catch(Exception e)
		{
			System.out.println("Opp's Error is in CommonDAO-getUserID()....."+e);
		}
		return key2;
	}
	public static String getDESKeyFromDB1() 
	{
		boolean flag=false;
		String key2="";
		try
		{
			
			Database database = Database.getInstance();
			connection=database.connector();
			statement = connection.createStatement();
			String sql="select do_key2 from m_owner ";
			
			resultSet =statement.executeQuery(sql);
			while(resultSet.next())
			{
				key2=resultSet.getString(1);
				//System.out.println("Key 2 :"+key2);
			}
			
			flag=true;
			
			System.out.println("Clud Flag : "+flag);
		}
		catch(Exception e)
		{
			System.out.println("Opp's Error is in CommonDAO-getUserID()....."+e);
		}
		return key2;
	}
	
	
	
	
	public static ArrayList getDomain_SDomain_Code() 
	{
		boolean flag=false;
		String domain="";
		String sdomain="";
		
		ArrayList list=new ArrayList();
		try
		{
			
			Database database = Database.getInstance();
			connection=database.connector();
			statement = connection.createStatement();
			String sql="select domain_code,sdomain_code,email from m_user";
			
			resultSet =statement.executeQuery(sql);
			while(resultSet.next())
			{
				
				domain=resultSet.getString(5);
				sdomain=resultSet.getString(6);
				list.add(domain);
				list.add(sdomain);
				
				System.out.println("Key 1 :"+domain);
				System.out.println("Key 2 :"+sdomain);
			}
			
			flag=true;
			
			System.out.println("Clud Flag : "+flag);
		}
		catch(Exception e)
		{
			System.out.println("Opp's Error is in CommonDAO-getUserID()....."+e);
		}
		return list;
	}
	
	public boolean checkIdenty(String userid,String tocken_id)
	{
		boolean flag=false;
		String tocken_key="";
		try
		{
			Database database = Database.getInstance();
			connection=database.connector();
			statement = connection.createStatement();
			resultSet = statement.executeQuery("select u_tocken_id from m_user where userid='"+userid+"'");
			
			while(resultSet.next())
			{
				tocken_key=resultSet.getString(1);
				System.out.println("DB Key :"+tocken_key);
				
			}
			System.out.println("Downloded Key :"+tocken_id);
			if(tocken_key.equalsIgnoreCase(tocken_id))
			{
				flag=true;
			}
			System.out.println("User Login Status : "+flag);
		}
		catch(Exception e)
		{
			System.out.println("Exception in UserDAO-->checkUser(String userid,String pass): "+ e);
		}
		return flag;
	}
	

	public ResultSet getRequest()
	{
		try
		{
			Database database = Database.getInstance();
			connection=database.connector();
			statement = connection.createStatement();
			resultSet = statement.executeQuery("select * from m_request_secfile where flag='false'");
		}
		catch(Exception e)
		{
			System.out.println("Exception in adminDAO-->getUsers(): "+ e);
		}
		return resultSet;
	}
	
	
	public boolean checkUser(String username,String password)
	{
		boolean flag=false;
		try
		{
			Database database = Database.getInstance();
			connection=database.connector();
			statement = connection.createStatement();
			resultSet = statement.executeQuery("select * from m_user where userid='"+username+"' and password='"+password+"'");
			while(resultSet.next())
			{
				flag=true;
			}
			System.out.println("User Login Status : "+flag);
		}
		catch(Exception e)
		{
			System.out.println("Exception in UserDAO-->checkUser(String userid,String pass): "+ e);
		}
		return flag;
	}
	
	public boolean insertRequest(String userid,String key)
	{
		boolean flag=false;
		try
		{
			Database database = Database.getInstance();
			connection=database.connector();
			statement = connection.createStatement();
			
			String sql="insert into m_request_secfile(userid,identity_tocken,flag) values('"+userid+"','"+key+"','false')";
			
			int i=statement.executeUpdate(sql);
			if(i>0)
			{
			flag=true;
			}
			
			System.out.println("User Login Status : "+flag);
		}
		catch(Exception e)
		{
			System.out.println("Exception in UserDAO-->checkUser(String userid,String pass): "+ e);
		}
		return flag;
	}
	
	public boolean updateRequestFlag(String userid)
	{
		boolean flag=false;
		try
		{
			Database database = Database.getInstance();
			connection=database.connector();
			statement = connection.createStatement();
			
			String sql="update m_request_secfile set flag='false' where userid='"+userid+"'";
			System.out.println("Request file querry-->"+sql);
			
			int i=statement.executeUpdate(sql);
			if(i>0)
			{
			flag=true;
			}
			
			System.out.println("Request File flag : "+flag);
		}
		catch(Exception e)
		{
			System.out.println("Exception in UserDAO-->updateRequestFlag "+ e);
		}
		return flag;
	}
	
	
	public boolean addUser(String userid,String password,String name,String domain,String subdomain,String doj,String email,String tocken)
	{
		boolean flag=false;
		try
		{
			Database database = Database.getInstance();
			connection=database.connector();
			statement = connection.createStatement();
			
			String sql="insert into m_user(userid,password,u_name,domain_code,sdomain_code,u_doj,u_email,u_tocken_id) values('"+userid+"','"+password+"','"+name+"','"+domain+"','"+subdomain+"','"+doj+"','"+email+"','"+tocken+"')";
			
			statement.executeUpdate(sql);
			
			flag=true;
			
			System.out.println("User Login Status : "+flag);
		}
		catch(Exception e)
		{
			System.out.println("Exception in UserDAO-->checkUser(String userid,String pass): "+ e);
		}
		return flag;
	}
	
	/* Get Profile Details (Starts) */
	
	public ResultSet getProfile(String username)
	{
		try
		{
			Database database = Database.getInstance();
			connection=database.connector();
			statement = connection.createStatement();
			resultSet = statement.executeQuery("select * from m_user where userid='"+username+"'");
		}
		catch(Exception e)
		{
			System.out.println("Opp's Error is in UserDAO-getProfile()....."+e);
		}
		return resultSet;
	}
	
	/* Get Profile Details (Ends) */
	
	public String getID(String username)
	{
		String i="";
		try
		{
			Database database = Database.getInstance();
			connection=database.connector();
			statement = connection.createStatement();
			resultSet = statement.executeQuery("select u_code from m_user where userid='"+username+"'");
			while(resultSet.next())
			{
				i=resultSet.getString(1);
			}
			System.out.println("User ID is : "+i);
		}
		catch(Exception e)
		{
			System.out.println("Exception in UserDAO-->getID(String userid): ");
			e.printStackTrace();
		}
		return i;
	}
	
	public int getID1(String username)
	{
		int i=0;
		try
		{
			Database database = Database.getInstance();
			connection=database.connector();
			statement = connection.createStatement();
			resultSet = statement.executeQuery("select u_code from m_user where userid='"+username+"'");
			while(resultSet.next())
			{
				i=resultSet.getInt(1);
			}
			System.out.println("User ID is : "+i);
		}
		catch(Exception e)
		{
			System.out.println("Exception in UserDAO-->getID(String userid): ");
			e.printStackTrace();
		}
		return i;
	}
	
	public int getID2(int domain_code,int sdomain_code)
	{
		int i=0;
		try
		{
			Database database = Database.getInstance();
			connection=database.connector();
			statement = connection.createStatement();
			resultSet = statement.executeQuery("select u_code from m_user where domain_code='"+domain_code+"' and sdomain_code='"+sdomain_code+"'");
			while(resultSet.next())
			{
				i=resultSet.getInt(1);
			}
			System.out.println("User ID is : "+i);
		}
		catch(Exception e)
		{
			System.out.println("Exception in UserDAO-->getID(String userid): ");
			e.printStackTrace();
		}
		return i;
	}
	
	
	public String  getDomain_Code(String username)
	{
		  String i="";
		try
		{
			Database database = Database.getInstance();
			connection=database.connector();
			statement = connection.createStatement();
			resultSet = statement.executeQuery("select domain_code from m_user where userid='"+username+"'");
			while(resultSet.next())
			{
				i=resultSet.getString(1);
			}
			System.out.println("User ID is : "+i);
		}
		catch(Exception e)
		{
			System.out.println("Exception in UserDAO-->getID(String userid): ");
			e.printStackTrace();
		}
		return i;
	}
	
	public String  getSDomain_Code(String username)
	{
		  String i="";
		try
		{
			Database database = Database.getInstance();
			connection=database.connector();
			statement = connection.createStatement();
			resultSet = statement.executeQuery("select sdomain_code from m_user where userid='"+username+"'");
			while(resultSet.next())
			{
				i=resultSet.getString(1);
			}
			System.out.println("User ID is : "+i);
		}
		catch(Exception e)
		{
			System.out.println("Exception in UserDAO-->getID(String userid): ");
			e.printStackTrace();
		}
		return i;
	}
	
	public String  getEmail(String username)
	{
		  String i="";
		try
		{
			Database database = Database.getInstance();
			connection=database.connector();
			statement = connection.createStatement();
			resultSet = statement.executeQuery("select u_email from m_user where userid='"+username+"'");
			while(resultSet.next())
			{
				i=resultSet.getString(1);
			}
			System.out.println("Email ID : "+i);
		}
		catch(Exception e)
		{
			System.out.println("Exception in UserDAO-->getID(String userid): ");
			e.printStackTrace();
		}
		return i;
	}
	
	public ArrayList getDomainid()
	{
		ArrayList list=new ArrayList();
		try
		{
			Database database = Database.getInstance();
			connection=database.connector();
			statement = connection.createStatement();
			resultSet = statement.executeQuery("select domain_code from m_domain");
			while(resultSet.next())
			{
				list.add(resultSet.getInt(1));
			}
			
			
			System.out.println("Domain ID is : "+list);
		}
		catch(Exception e)
		{
			System.out.println("Exception in UserDAO-->getID(String userid): ");
			e.printStackTrace();
		}
		return list;
	}
	
	public int getSubDomainid()
	{
		int i=0;
		try
		{
			Database database = Database.getInstance();
			connection=database.connector();
			statement = connection.createStatement();
			resultSet = statement.executeQuery("select subdomain_code from m_subdomain");
			while(resultSet.next())
			{
				i=resultSet.getInt(1);
			}
			System.out.println("SubDomain ID is : "+i);
		}
		catch(Exception e)
		{
			System.out.println("Exception in UserDAO-->getID(String userid): ");
			e.printStackTrace();
		}
		return i;
	}
	
	
	
	
	public int getDepartmentID(String username)
	{
		int i=0;
		try
		{
			Database database = Database.getInstance();
			connection=database.connector();
			statement = connection.createStatement();
			resultSet = statement.executeQuery("select domain_code from m_user where userid='"+username+"'");
			while(resultSet.next())
			{
				i=resultSet.getInt(1);
			}
			System.out.println("User ID is : "+i);
		}
		catch(Exception e)
		{
			System.out.println("Exception in UserDAO-->getDepartmentID(String username): ");
			e.printStackTrace();
		}
		return i;
	}
	
	
	public int getDesignationID(String username)
	{
		int i=0;
		try
		{
			Database database = Database.getInstance();
			connection=database.connector();
			statement = connection.createStatement();
			resultSet = statement.executeQuery("select sdomain_code from m_user where userid='"+username+"'");
			while(resultSet.next())
			{
				i=resultSet.getInt(1);
			}
			System.out.println("User ID is : "+i);
		}
		catch(Exception e)
		{
			System.out.println("Exception in UserDAO-->getDesignationID(String username): ");
			e.printStackTrace();
		}
		return i;
	}
	public static ArrayList<String> getAddress(int server_id)
	{
		ArrayList<String> list = new ArrayList<String>();
		try
		{
			Database database = Database.getInstance();
			connection=database.connector();
			statement = connection.createStatement();
			resultSet = statement.executeQuery("select * from m_process_server where server_id='"+server_id+"'");
		
			while(resultSet.next())
			{
				list.add(resultSet.getString(2));
				list.add(resultSet.getString(3));
				list.add(resultSet.getString(4));
				
			}
			
		}
		catch(Exception e)
		{
			System.out.println("Exception in UserProcess-->getAddress: "+ e);
		}
		finally
		{
			try {
				resultSet.close();
				statement.close();
				connection.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		return list;
	}	
	public int getServerID(String serverip)
	{
		int server_id=0;
		try
		{
			Database database = Database.getInstance();
			connection=database.connector();
			statement = connection.createStatement();
			resultSet = statement.executeQuery("select server_id from m_lookup where ip_address='"+serverip+"'");
			while(resultSet.next())
			{
				server_id=resultSet.getInt(1);
			}
			System.out.println("User ID is : "+server_id);
		}
		catch(Exception e)
		{
			System.out.println("Exception in UserDAO-->getDesignationID(String username): ");
			e.printStackTrace();
		}
		return server_id;
	}
	
	
	public String getUsername(String userName)
	{
		String username = "";
		try
		{
			Database database = Database.getInstance();
			connection=database.connector();
			statement = connection.createStatement();
			resultSet = statement.executeQuery("select u_name from m_user where username='"+userName+"'");
			while(resultSet.next())
			{
				username=resultSet.getString(1);
			}
			System.out.println("User Name : "+username);
		}
		catch(Exception e)
		{
			System.out.println("Exception in UserDAO-->getUser(int userId): ");
			e.printStackTrace();
		}
		return username;
	}
	
	
	public boolean editProfile(String [] s) 
	{
		boolean flag=false;
		String sql = "";
		try
		{   
			Database database = Database.getInstance();
			connection=database.connector();
			statement = connection.createStatement();
			sql = "update m_user set u_name='"+s[1]+"',u_email='"+s[2]+"' where u_code='"+s[0]+"'";
			System.out.println("******* Edit User Profile Info *********\n");
			System.out.println(sql);
			int i=statement.executeUpdate(sql);
			if(i!=0)
			{
				flag=true;
			}
			System.out.println("User Edit Profile Status : "+flag);
		}
		catch(Exception e)
		{
			System.out.println("Opp's Error is in UserDAO-editProfile() :");
			e.printStackTrace();
		}
		return flag;
	}
	
	public boolean chnagePass(int id,String cpass) 
	{
		boolean flag=false;
		String sql = "";
		try
		{
			Database database = Database.getInstance();
			connection=database.connector();
			statement = connection.createStatement();
			sql = "update m_user set password='"+cpass+"' where u_code='"+id+"'";
			System.out.println("******* Change User Password Info *********\n");
			System.out.println(sql);
			int i=statement.executeUpdate(sql);
			if(i!=0)
			{
				flag=true;
			}
			System.out.println("User Change Pass Status : "+flag);
		}
		catch(Exception e)
		{
			System.out.println("Opp's Error is in UserDAO-chnagePass() : ");
			e.printStackTrace();
		}
		return flag;
	}
	
	

	
/* Add Download Transaction (Starts) */
	
	public boolean addDownloadTransaction(String date,String time,int userId,int fileId,int deptId,int designationId,String transactionStatus) 
	{
		boolean flag=false;
		String sql="";
		try
		{
			Database database = Database.getInstance();
			connection=database.connector();
			statement = connection.createStatement();
			sql="insert into m_transaction(t_date,t_time,u_code,f_code,domain_code,sdomain_code,t_status) values('"+date+"','"+time+"','"+userId+"','"+fileId+"','"+deptId+"','"+designationId+"','"+transactionStatus+"')";
			System.out.println(sql);
			int i=statement.executeUpdate(sql);
			if(i!=0)
			{
				flag=true;
			}
			System.out.println("Download Transaction Status : "+flag);
		}
		catch(Exception e)
		{
			System.out.println("Opp's Error is in UserDAO-addDownloadTransaction(): ");
			e.printStackTrace();
		}
		return flag;
	}
	
/* Add Download Transaction (Ends) */
	
// All About The Cloud Server (STARTS)	
	public static String getCloudHostName(int cloudId) 
	{
		String sql = "",cloudHostName="";
		try
		{
			Database database = Database.getInstance();
			connection=database.connector();
			statement = connection.createStatement();
			sql = "select c_url from m_cloud where c_id='"+cloudId+"'";
			System.out.println("*********** Getting The Cloud Server Host Name ***********");
			System.out.println(sql);
			resultSet = statement.executeQuery(sql);
			while(resultSet.next())
			{
				cloudHostName = resultSet.getString(1);
			}
			
			cloudHostName = cloudHostName.trim();
			
			System.out.println("Main Cloud Server Host Name["+cloudId+"] : " +cloudHostName);
		}
		catch(Exception e)
		{
			System.out.println("Opp's Error is in UserDAO-getCloudHostName(int cloudId) : ");
			e.printStackTrace();
		}
		return cloudHostName;
	}
	
	public static String getCloudUsername(int cloudId) 
	{
		String sql = "",cloudUserName="";
		try
		{
			Database database = Database.getInstance();
			connection=database.connector();
			statement = connection.createStatement();
			sql = "select c_username from m_cloud where c_id='"+cloudId+"'";
			System.out.println("*********** Getting The Cloud Server Host Name ***********");
			System.out.println(sql);
			resultSet = statement.executeQuery(sql);
			while(resultSet.next())
			{
				cloudUserName = resultSet.getString(1);
			}
			
			cloudUserName = cloudUserName.trim();
			
			System.out.println("Main Cloud Server Host Name["+cloudId+"] : " +cloudUserName);
		}
		catch(Exception e)
		{
			System.out.println("Opp's Error is in UserDAO-getCloudUsername(Connection con,int cloudId) : ");
			e.printStackTrace();
		}
		return cloudUserName;
	}
	
	public static String getCloudPassword(int cloudId) 
	{
		String sql = "",cloudPassword="";
		try
		{
			Database database = Database.getInstance();
			connection=database.connector();
			statement = connection.createStatement();
			sql = "select c_pass from m_cloud where c_id='"+cloudId+"'";
			System.out.println("*********** Getting The Cloud Server Host Name ***********");
			System.out.println(sql);
			resultSet = statement.executeQuery(sql);
			while(resultSet.next())
			{
				cloudPassword = resultSet.getString(1);
			}
			
			cloudPassword = cloudPassword.trim();
			
			System.out.println("Main Cloud Server Host Name["+cloudId+"] : " +cloudPassword);
		}
		catch(Exception e)
		{
			System.out.println("Opp's Error is in UserDAO-getCloudPassword(Connection con,int cloudId)  : ");
			e.printStackTrace();
		}
		return cloudPassword;
	}
	public static String getCloudDirectory(int cloudId) 
	{
		String sql = "",cloudDirectory="";
		try
		{
			Database database = Database.getInstance();
			connection=database.connector();
			statement = connection.createStatement();
			sql = "select c_folder from m_cloud where c_id='"+cloudId+"'";
			System.out.println("*********** Getting The Cloud Server Host Name ***********");
			System.out.println(sql);
			resultSet = statement.executeQuery(sql);
			while(resultSet.next())
			{
				cloudDirectory = resultSet.getString(1);
			}
			
			cloudDirectory = cloudDirectory.trim();
			
			System.out.println("Main Cloud Server Host Name["+cloudId+"] : " +cloudDirectory);
		}
		catch(Exception e)
		{
			System.out.println("Opp's Error is in UserDAO-getCloudDirectory(Connection con,int cloudId) : ");
			e.printStackTrace();
		}
		return cloudDirectory;
	}
	public static String getCloudID(Connection con,int cloudId) 
	{
		String sql = "",cloudUserName="";
		try
		{
			statement = con.createStatement();
			sql = "select c_username from m_cloud where c_id='"+cloudId+"'";
			System.out.println("*********** Getting The Cloud Server Host Name ***********");
			System.out.println(sql);
			resultSet = statement.executeQuery(sql);
			while(resultSet.next())
			{
				cloudUserName = resultSet.getString(1);
			}
			
			cloudUserName = cloudUserName.trim();
			
			System.out.println("Main Cloud Server Host Name["+cloudId+"] : " +cloudUserName);
		}
		catch(Exception e)
		{
			System.out.println("Opp's Error is in UserDAO-getCloudUsername(Connection con,int cloudId) : ");
			e.printStackTrace();
		}
		return cloudUserName;
	}
/* Get Download Transaction(Starts) */

	public ResultSet getDownloadTransaction(int userId)
	{
		try
		{
			Database database = Database.getInstance();
			connection=database.connector();
			statement = connection.createStatement();
			resultSet = statement.executeQuery("select * from m_transaction where u_code='"+userId+"'");
		}
		catch(Exception e)
		{
			System.out.println("Opp's Error is in UserDAO-getDownloadTransaction() : ");
			e.printStackTrace();
		}
		return resultSet;
	}
	
/* Get Download Transaction(Ends) */
	public static boolean checkFileInSubVB(int subVbId,String fileName) 
	{
		String sql = "";
		boolean flag = false;
		try
		{
			sql = "select * from m_sub_vb where c_id='"+subVbId+"' and file_name='"+fileName+"'";
			Database database = Database.getInstance();
			connection=database.connector();
			statement = connection.createStatement();
			
			System.out.println("*********** Checking The File In Sub VB ***********");
			System.out.println(sql);
			resultSet = statement.executeQuery(sql);
			while(resultSet.next())
			{
				flag = true;
			}
			
			System.out.println("Existing Status : "+ flag);
		}
		catch(Exception e)
		{
			System.out.println("Opp's Error is in UserDAO-checkFileInSubVB(int subVbId,String fileName) : ");
			e.printStackTrace();
		}
		return flag;
	}
	
	public static String getFileName(int fileId)
	{
		String fileName = "";
		try
		{
			Database database = Database.getInstance();
			connection=database.connector();
			statement = connection.createStatement();
			resultSet = statement.executeQuery("select f_name from m_file_Upload where f_code='"+fileId+"'");
			while(resultSet.next())
			{
				fileName=resultSet.getString(1);
			}
			System.out.println("File Name : "+fileName);
		}
		catch(Exception e)
		{
			System.out.println("Exception in UserDAO-->getFileName(int fileId): ");
			e.printStackTrace();
		}
		return fileName;
	}
	

	
/* Getting Cloud Status(Starts) */
	public String getCloudStatus(String cloudUrl)
	{
		String status = "Inactive";
		try
		{
			Database database = Database.getInstance();
			connection=database.connector();
			statement = connection.createStatement();
			System.out.println("******* Cloud Status Information *******");
			resultSet = statement.executeQuery("select c_status from m_cloud where c_url='"+cloudUrl+"'");
			while(resultSet.next())
			{
				status=resultSet.getString(1);
			}
			System.out.println("Cloud "+cloudUrl +" Status : "+status);
		}
		catch(Exception e)
		{
			System.out.println("Exception in UserDAO-->getCloudStatus(String cloudUrl): ");
			e.printStackTrace();
		}
		return status;
	}
	/* Getting Cloud Status(Starts) */

/* Get Files To Download (Starts) */

	public ResultSet getFilesToDownload(int userId)
	{
		try
		{
			Database database = Database.getInstance();
			connection=database.connector();
			statement = connection.createStatement();
			resultSet = statement.executeQuery("select * from m_upload where m_id='"+userId+"'");
		}
		catch(Exception e)
		{
			System.out.println("Opp's Error is in UserDAO-getFiles() : ");
			e.printStackTrace();
		}
		return resultSet;
	}
	
/* Get Files To Download (Ends) */
	
/* Get Download Transactions (Starts) */

	public ResultSet getUserDownloadTransaction(int userId)
	{
		try
		{
			Database database = Database.getInstance();
			connection=database.connector();
			statement = connection.createStatement();
			resultSet = statement.executeQuery("select * from m_download where m_id='"+userId+"'");
		}
		catch(Exception e)
		{
			System.out.println("Opp's Error is in UserDAO-getUserDownloadTransaction(int userId) : ");
			e.printStackTrace();
		}
		return resultSet;
	}
	
/* Get Download Transactions (Starts) */
	
	
/* Update Download Message Digest (Starts)*/
	
	public boolean updateDownloadMessageDigest(String fileName,String dMsgDigest)
	{
		boolean flag = false;
		int i = 0;
		String sql = "";
		try
		{
			Database database = Database.getInstance();
			connection=database.connector();
			statement = connection.createStatement();
			sql="update m_download set d_messagedigest='"+dMsgDigest+"' where d_filename='"+fileName+"'";
			i = statement.executeUpdate(sql);
			
			if(i>0)
			{
				flag = true;
			}
		}
		catch(Exception e)
		{
			System.out.println("Exception in UserDAO-->updateDownloadMessageDigest(): ");
			e.printStackTrace();
		}
		return flag;
	}

/* Update Download Message Digest (Ends)*/
	
/* Get Upload Message Digest (Starts)*/
	public String getUploadMsgDigest(String fileName)
	{
		String msgDigest = "";
		try
		{
			Database database = Database.getInstance();
			connection=database.connector();
			statement = connection.createStatement();
			resultSet = statement.executeQuery("select m_messagedigest from m_upload where u_filename='"+fileName+"'");
			while(resultSet.next())
			{
				msgDigest=resultSet.getString(1);
			}
			System.out.println("Upload Msg Digest : "+msgDigest);
		}
		catch(Exception e)
		{
			System.out.println("Exception in UserDAO-->getUploadMsgDigest(String fileName): ");
			e.printStackTrace();
		}
		return msgDigest;
	}
	
/* Get Upload Message Digest (Ends)*/
	
/* Get Download Message Digest (Starts)*/
	public String getDownloadMsgDigest(String fileName)
	{
		String msgDigest = "";
		try
		{
			Database database = Database.getInstance();
			connection=database.connector();
			statement = connection.createStatement();
			resultSet = statement.executeQuery("select d_messagedigest from m_download where d_filename='"+fileName+"'");
			while(resultSet.next())
			{
				msgDigest=resultSet.getString(1);
			}
			System.out.println("Download Msg Digest : "+msgDigest);
		}
		catch(Exception e)
		{
			System.out.println("Exception in UserDAO-->getDownloadMsgDigest(String fileName): ");
			e.printStackTrace();
		}
		return msgDigest;
	}
	
/* Get Download Message Digest (Ends)*/

/* Update Download Integrity Status (Starts)*/
	
	public boolean updateDownloadIntegrityStatus(String fileName,String integrityConstraint)
	{
		boolean flag = false;
		int i = 0;
		String sql = "";
		try
		{
			Database database = Database.getInstance();
			connection=database.connector();
			statement = connection.createStatement();
			sql="update m_download set integrity_status='"+integrityConstraint+"' where d_filename='"+fileName+"'";
			i = statement.executeUpdate(sql);
			
			if(i>0)
			{
				flag = true;
			}
		}
		catch(Exception e)
		{
			System.out.println("Exception in UserDAO-->updateDownloadIntegrityStatus(): ");
			e.printStackTrace();
		}
		return flag;
	}
	
/* Update Download Integrity Status (Ends)*/
	
/* Add Upload Transactions (Starts)*/
	
	public boolean addUploadConstraints(int uploadId,int cloudId)
	{
		boolean flag = false;
		int i = 0;
		String sql = "";
		try
		{
			Database database = Database.getInstance();
			connection=database.connector();
			statement = connection.createStatement();
			sql="insert into m_transactions (u_id,c_id) values('"+uploadId+"','"+cloudId+"')";
			i = statement.executeUpdate(sql);
			
			if(i>0)
			{
				flag = true;
			}
		}
		catch(Exception e)
		{
			System.out.println("Exception in UserDAO-->addUploadTransactions(int uploadId,int cloudId): ");
			e.printStackTrace();
		}
		return flag;
	}
	
	public static boolean addSubcloudTransactions(int cid,String filename)
	{
		boolean flag = false;
		int i = 0;
		String sql = "";
		try
		{
			Database database = Database.getInstance();
			connection=database.connector();
			statement = connection.createStatement();
			sql="insert into m_sub_vb(c_id,file_name) values('"+cid+"','"+filename+"')";
			i = statement.executeUpdate(sql);
			
			if(i>0)
			{
				flag = true;
			
			}
		}
		catch(Exception e)
		{
			System.out.println("Exception in UserDAO-->addSubcloudTransactions(int cid,int filename): ");
			e.printStackTrace();
		}
		return flag;
	}
/* Add Upload Transactions (Ends)*/	
	
/* Get Max Upload ID (Starts)*/	
	
	public int getMaxUploadID()
	{
		int i=0;
		try
		{
			Database database = Database.getInstance();
			connection=database.connector();
			statement = connection.createStatement();
			resultSet = statement.executeQuery("select max(u_id) from m_upload");
			while(resultSet.next())
			{
				i=resultSet.getInt(1);
			}
			System.out.println("Max Upload ID is : "+i);
		}
		catch(Exception e)
		{
			System.out.println("Exception in UserDAO--> getMaxUploadID(): ");
			e.printStackTrace();
		}
		return i;
	}
	
/* Get Max Upload ID (Ends)*/	
	
/* Get Cloud ID (Starts)*/	
	
	public int getCloudID(String url)
	{
		int i=0;
		String sql = "";
		try
		{
			Database database = Database.getInstance();
			connection=database.connector();
			statement = connection.createStatement();
			sql = "select c_id from m_cloud where c_url='"+url+"'";
			System.out.println("******************** Get Cloud Ids Info ********************");
			System.out.println(sql);
			resultSet = statement.executeQuery(sql);
			while(resultSet.next())
			{
				i=resultSet.getInt(1);
			}
			System.out.println("Cloud ID is : "+i);
		}
		catch(Exception e)
		{
			System.out.println("Exception in UserDAO--> getCloudID(String url): ");
			e.printStackTrace();
		}
		return i;
	}
	
/* Get Cloud  ID (Ends)*/	
	
/* Get Cloud ID using UploadId (Starts)*/	
	
	public ArrayList getCloudIDByUploadId(int uploadId)
	{
		int i=0;
		String sql = "";
		ArrayList list = new ArrayList();
		try
		{
			Database database = Database.getInstance();
			connection=database.connector();
			statement = connection.createStatement();
			sql = "select c_id from m_transactions where u_id='"+uploadId+"'";
			System.out.println("******************** Get Cloud Ids By Using Upload ID ********************");
			System.out.println(sql);
			resultSet = statement.executeQuery(sql);
			while(resultSet.next())
			{
				i=resultSet.getInt(1);
				list.add(i);
			}
			System.out.println("Cloud IDs are : "+list);
		}
		catch(Exception e)
		{
			System.out.println("Exception in UserDAO--> getCloudIDByUploadId(String uploadId): ");
			e.printStackTrace();
		}
		return list;
	}
	
/* Get Cloud ID using UploadId (Ends)*/		
	
/* Getting Clouds Status By Id (Starts)*/	
	
	public String getCloudStatusById(int cloudId)
	{
		String status = "";
		try
		{
			Database database = Database.getInstance();
			connection=database.connector();
			statement = connection.createStatement();
			resultSet = statement.executeQuery("select c_status from m_cloud where c_id='"+cloudId+"'");
			while(resultSet.next())
			{
				status=resultSet.getString(1);
			}
			System.out.println("Cloud Status : "+status);
		}
		catch(Exception e)
		{
			System.out.println("Exception in UserDAO-->getCloudStatusById(int cloudId): ");
			e.printStackTrace();
		}
		return status;
	}
/* Getting Clouds Status By Id (Ends)*/
	
	
}
