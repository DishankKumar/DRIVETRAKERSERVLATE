package Registration;

import java.io.BufferedReader;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.codehaus.jackson.map.ObjectMapper;

/**
 * Servlet implementation class Register
 */
@WebServlet("/Register")
public class Register extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		System.out.println("angular data=" + request);
		
		System.out.println("Inside doPost method.");
		String requestdata = request.getReader().readLine();
		System.out.println("Angular Data = "+requestdata);
		Drivepojo c = (Drivepojo) ObjMap.getObjectFromJSON(requestdata, Drivepojo.class);
		
		Map<String, String> map = null;
		try
		{
			map = DaoLayer.saveData(c);
		}
		catch (ClassNotFoundException | SQLException e) 
		{
			e.printStackTrace();
		}
				
		
String responsedata = (String) ObjMap.getJSONFromObject(map);
		
		response.getWriter().write(responsedata);
		
		response.flushBuffer();
	}	
}
