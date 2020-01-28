package Registration;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Delete
 */
@WebServlet("/Delete")
public class Delete extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    static int id;
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	
		String s=request.getReader().readLine();
		id=Integer.parseInt(s);
		System.out.println(id);
		
		try {
			Deletedata();
		}
		catch (ClassNotFoundException e) 
		{
			e.printStackTrace();
		} 
		catch (SQLException e) 
		{		
			e.printStackTrace();
		}
	}
	protected void Deletedata() throws ClassNotFoundException, SQLException
	{
		Connection con=DaoLayer.getConnection();
		
		PreparedStatement ps=con.prepareStatement("delete from createdata where id=?");
		
		
		ps.setObject(1, id);
		
		int status =ps.executeUpdate();
		System.out.println(status);
		
	}
		
	}


