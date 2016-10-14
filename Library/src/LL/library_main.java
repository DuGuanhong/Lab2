package LL;
import java.sql.*;

import java.util.ArrayList;
import java.util.List;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import LL.library_main;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.struts2.ServletActionContext;
import java.net.URLDecoder;
import javax.servlet.http.HttpSession;
import java.io.BufferedInputStream;  
import java.io.BufferedOutputStream;  
import java.io.File;  
import java.io.FileInputStream;  
import java.io.FileOutputStream;  
import java.io.InputStream;  
import java.io.OutputStream;  
import java.util.ArrayList;  
import java.util.Date;  
import java.util.List;  

import org.apache.struts2.ServletActionContext;  
  
import com.opensymphony.xwork2.ActionSupport;  
public class  library_main{
	private Connection conn = null;
	PreparedStatement statement = null;
    private int ISBN;
    private String Title;
    private int AuthorID;
    private String Publisher;
    private String Pubishdate;
    private int Price;
    private String Name;
    private String Country;
    private int Age;
    public ArrayList<String> list=null;
	// connect to MySQL
    ArrayList<String> getList(){
    	return list;
    }
	public void connSQL() {
		String url = "jdbc:mysql://localhost:3306/library?characterEncoding=UTF-8";
		String username = "root";
		String password = "1234"; // 加载驱动程序以连接数据库 
		try { 
			Class.forName("com.mysql.jdbc.Driver" ); 
			conn = DriverManager.getConnection( url,username, password ); 
			}
		//捕获加载驱动程序异常
		 catch ( ClassNotFoundException cnfex ) {
			 System.err.println(
			 "装载 JDBC/ODBC 驱动程序失败。" );
			 cnfex.printStackTrace(); 
		 } 
		 //捕获连接数据库异常
		 catch ( SQLException sqlex ) {
			 System.err.println( "无法连接数据库" );
			 sqlex.printStackTrace(); 
		 }
	}

	// disconnect to MySQL
	public void deconnSQL() {
		try {
			if (conn != null)
				conn.close();
		} catch (Exception e) {
			System.out.println("关闭数据库问题 ：");
			e.printStackTrace();
		}
	}

	// execute selection language
	public ResultSet selectSQL(String sql) {
		ResultSet rs = null;
		try {
			statement = conn.prepareStatement(sql);
			rs = statement.executeQuery(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return rs;
	}

	

	public String return1(){
		return "SUCCESS";
	}


	public int getISBN() {
		return ISBN;
	}

	public void setISBN(int ISBN) {
		this.ISBN = ISBN;
	}

	public String getTitle() {
		return Title;
	}

	public void setTitle(String Title) {
		this.Title = Title;
	}

	public int getAuthorID() {
		return AuthorID;
	}

	public void setAuthorID(int AuthorID ) {
		this.AuthorID = AuthorID ;
	}

	public String getPublisher() {
		return Publisher;
	}

	public void setPublisher(String Publisher) {
		this.Publisher = Publisher;
	}

	public String getPubishdate() {
		return Pubishdate;
	}

	public void setPubishdate(String Pubishdate ) {
		this.Pubishdate = Pubishdate ;
	}

	public int getPrice() {
		return Price;
	}

	public void setPrice(int Price) {
		this.Price = Price;
	}

	public String getName() {
		return Name;
	}

	public void setName(String Name) {
		this.Name = Name;
	}

	public String getCountry() {
		return Country;
	}

	public void setCountry(String Country) {
		this.Country = Country;
	}

	public int getAge() {
		return Age;
	}

	public void setAge(int Age) {
		this.Age = Age;
	}
public String findAuthor()
{
	String url = "jdbc:mysql://localhost:3306/library?characterEncoding=UTF-8";
	String username = "root";
	String password = "1234"; // 加载驱动程序以连接数据库 
	ArrayList<String> list2= new ArrayList<String>();
	String value=Name;
	try { 
	Class.forName("com.mysql.jdbc.Driver" ); 
	conn = DriverManager.getConnection( url,username, password ); 
	String sql = "SELECT * FROM Author where Name = '"+value+"'";  
	System.out.println("---------------------------------------------");
	System.out.println(value);
	Statement stmt= conn.createStatement();
	ResultSet rs = stmt.executeQuery(sql); 
	String ID="";
	while (rs.next()) { 
		ID=rs.getString("AuthorID");
	 } 
	
	sql="select * from Book where AuthorID="+ID;
	ResultSet rs2 = stmt.executeQuery(sql); 
    String ISBN=null;
    String Title=null;
    while(rs2.next()){
    	ISBN=rs2.getString("ISBN");
    	Title=rs2.getString("Title");
    	list2.add(ISBN);
    	list2.add(Title);
    }
	 rs2.close();
	 rs.close();  
	 conn.close();
	}catch(Exception e)
	{System.out.println("cannot find the driver!");
	e.printStackTrace();
    }
this.list=list2;
ServletRequest request=ServletActionContext.getRequest();
HttpServletRequest req=(HttpServletRequest) request;
HttpSession session=req.getSession();
session.setAttribute("list",list);
if(list.size()>0) return "SUCCESS";
else return "FALSE";
}

public String bookdetail(){
	
	String url = "jdbc:mysql://localhost:3306/library?characterEncoding=UTF-8";
	String username = "root";
	String password = "1234"; // 加载驱动程序以连接数据库 
	ArrayList<String> list2= new ArrayList<String>();
	String value=Name;
	System.out.println(Name);
	try { 
	Class.forName("com.mysql.jdbc.Driver" ); 
	conn = DriverManager.getConnection( url,username, password ); 
	String sql = "SELECT * FROM Book where Title = '"+value+"'";  
	Statement stmt= conn.createStatement();
	ResultSet rs = stmt.executeQuery(sql); 
	String ISBN=null;
    String Title=null;
    String AuthorID=null;
    String Publisher=null;
    String Publishdate=null;
    String Price=null;
    while(rs.next()){
    	ISBN=rs.getString("ISBN");
    	Title=rs.getString("Title");
    	AuthorID=rs.getString("AuthorID");
    	Publisher=rs.getString("Publisher");
    	Publishdate=rs.getString("Publishdate");
    	Price=rs.getString("Price");
    	list2.add(ISBN);
    	list2.add(Title);
    	list2.add(AuthorID);
    	list2.add(Publisher); 
    	list2.add(Publishdate);
    	list2.add(Price);
    }
	 rs.close();  
	}catch(Exception e)
	{System.out.println("cannot find the driver!");
	e.printStackTrace();
    }
this.list=list2;
ServletRequest request=ServletActionContext.getRequest();
HttpServletRequest req=(HttpServletRequest) request;
HttpSession session=req.getSession();
session.setAttribute("list",list);
if(list.size()>0) return "SUCCESS";
else return "FALSE";

}
public String delete() {
	connSQL();
	String instruction="delete from Book where Title='"+Name+"'";
	System.out.println(instruction);
	try {
	    System.out.println(instruction);
		statement = conn.prepareStatement(instruction);
		statement.executeUpdate();
		return "SUCCESS";
	} catch (Exception e) {
		System.out.println("删除时出错：");
		e.printStackTrace();
	}
	return "FALSE";
}
public String insertSQL() {
	
	connSQL();
	String instruction1="insert into Book Values ("+getISBN()+",'"+getTitle()+"',"+getAuthorID()+",'"+getPublisher()+"','"+getPubishdate()+"',"+getPrice()+");";
	String ifauthor = "select count(*)  from Author where AuthorID= " +getAuthorID()+";";
	String instruction2 ="insert into Author Values ("+getAuthorID()+",'"+getName()+"',"+getAge()+",'"+getCountry()+"');";
	try {
	    System.out.println(instruction1);
		statement = conn.prepareStatement(instruction1);
		statement.executeUpdate();
		
		
		ResultSet rs = statement.executeQuery(ifauthor);
		int count = 0; 
		while (rs.next()) { 
		count = rs.getInt(1); 
		} 
		if(count == 0) { 
		statement = conn.prepareStatement(instruction2);
		statement.executeUpdate();
		return "SUCCESS";
		}
	} catch (SQLException e) {
		System.out.println("插入数据库时出错：");
		e.printStackTrace();
	} catch (Exception e) {
		System.out.println("插入时出错：");
		e.printStackTrace();
	}
	return "SUCCESS";
}

public String update(){
	connSQL();
	System.out.println(Publisher);
	String instruction1="update Book set Title='"+getTitle()+"',Publisher='"+getPublisher()+"' , Publishdate='"+getPubishdate()+"',Price="+getPrice()+" where ISBN ="+getISBN();
	try {
	    System.out.println(instruction1);
		statement = conn.prepareStatement(instruction1);
		statement.executeUpdate();
		return "SUCCESS";
	} catch (Exception e) {
		System.out.println("修改时出错：");
		e.printStackTrace();
	}
	return "FALSE";

}
}






