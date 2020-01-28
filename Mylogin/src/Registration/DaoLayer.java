package Registration;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class DaoLayer {
	//private static final int  = 0;

	public static Connection getConnection() throws ClassNotFoundException, SQLException {
		Connection con = null;
		Class.forName("com.mysql.cj.jdbc.Driver");
		con = DriverManager.getConnection("jdbc:mysql://localhost:3306/drivepojo?useSSL=false", "root", "root");
		return con;
	}
	
	public static Map<String, String> saveData(Drivepojo c) throws ClassNotFoundException, SQLException {

		Connection con = getConnection();
		
		PreparedStatement ps = con.prepareStatement("insert into createdata(companyname,resources,exp,ctc,positions,joining,education,followup,bond) values(?,?,?,?,?,?,?,?,?)");
		
	
		String cname = c.getCompanyname();
		int resource= c.getResource();
		int exp= c.getExp();
		int ctc=c.getCtc();
		int position= c.getPosition();
		int jc= c.getJoining();
		int ec = c.getEducation();
		Date followup = c.getFollowup();
		int bond= c.getBond();
		
		
		
		
		ps.setObject(1, cname);
		ps.setObject(2, resource);
		ps.setObject(3, exp);
		ps.setObject(4, ctc);
		ps.setObject(5, position);
		ps.setObject(6, jc);
		ps.setObject(7, ec);
		ps.setObject(8, followup);
		ps.setObject(9, bond);
		
		int status = ps.executeUpdate();
		
		Map<String, String> map = new HashMap<>();

		if (status == 1) 
		{
			map.put("msg", "done");
		}
		else
		{
			map.put("msg", "Sorry.Eroor occur.");
		}
		return map;

}
	
	public static ArrayList<Drivepojo> getUserDataFromDB() throws ClassNotFoundException, SQLException {

		Connection con = getConnection();

		PreparedStatement ps = con.prepareStatement("select * from createdata");

		ResultSet rs = ps.executeQuery();

		ArrayList<Drivepojo> list = new ArrayList<>();
		

		while (rs.next()) {
			Drivepojo c = new Drivepojo();
			
		   
			c.setId(rs.getInt(1));
			c.setCompanyname(rs.getString(2));
			c.setResource(rs.getInt(3));
			c.setExp(rs.getInt(4));
			c.setCtc(rs.getInt(5));
			c.setPosition(rs.getInt(6));
			c.setJoining(rs.getInt(7));
			c.setEducation(rs.getInt(8));
			c.setFollowup(rs.getDate(9));
			c.setBond(rs.getInt(10));
			
			list.add(c);
		}
		return list;
	}
}


