

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class server
 */
@WebServlet("/server")
public class server extends HttpServlet {
	public void service(HttpServletRequest req, HttpServletResponse res) throws IOException{
		res.setContentType("text/html");
		PrintWriter out = res.getWriter();
		Enumeration flds = req.getParameterNames();
		if(!flds.hasMoreElements()){
			out.print("<html>");
			out.print("<form method=\"POST\""+"action=\"server\">");
			for(int i=0;i<10;i++){
				out.print("<b>Field"+i+"</b>"+"<input type= \"text\""+"size=\"20\"name=\"Field"+i+"\"value=\"Value"+i+"\"><br>");
			}
			out.print("<INPUT TYPE =submit name=submit Value =\"Submit\"></form></html>");
			
		}else{
			out.print("<h1>your form contained:</h1>");
			while(flds.hasMoreElements()){
				String field =(String)flds.nextElement();
				String value =req.getParameter(field);
				out.print(field+"="+value+"<br>");
			}
		}
		out.close();
	}
}
