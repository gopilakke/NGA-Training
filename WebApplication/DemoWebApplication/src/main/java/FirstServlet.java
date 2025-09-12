

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class FirstServlet
 */
@WebServlet("/wipro.com")
public class FirstServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public FirstServlet() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter pw = response.getWriter();
		String username = request.getParameter("txt1");
		String password = request.getParameter("txt2");
		                
		
		
		if (username.equals("Admin") && password.equals("admin123"))
		{
			
			pw.println("Welcome");
			// If you want to dispatch the request to another html page or servlet
			RequestDispatcher rd = request.getRequestDispatcher("restaurant.html");
			
			// either you can include the response provided by any page on same page 
			
			rd.include(request, response);
			
			// or else we can forward the request and response object to a new page 
			
			rd.forward(request, response);
			
		}
		else
		{
			
			pw.println("Bad Request");
		}
	}

}
