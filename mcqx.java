import jakarta.servlet.ServletException; import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest; import jakarta.servlet.http.HttpServletResponse; import java.io.IOException;
import java.io.PrintWriter; import java.sql.Connection; import java.sql.DriverManager; import java.sql.SQLException; import java.sql.Statement; import java.util.logging.Level; import java.util.logging.Logger;

public class mcqex extends HttpServlet {
protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
response.setContentType("text/html;charset=UTF-8"); Connection con;
Statement st;
try ( PrintWriter out = response.getWriter()) int mark=0;
String n=request.getParameter("t1"); String q1=request.getParameter("q1"); String q2=request.getParameter("q2"); String q3=request.getParameter("q3");
 
String q4=request.getParameter("q4"); String q5=request.getParameter("q5"); if(q1.equals("True"))
{
mark=mark+1;
}
if(q2.equals("True"))
{
mark=mark+1;
}
if(q3.equals("True"))
{
mark=mark+1;
}
if(q4.equals("True"))
{
mark=mark+1;
}
if(q5.equals("True"))
{
mark=mark+1;
}
out.println(n+" "+mark); con=DriverManager.getConnection("jdbc:derby://localhost:1527/marks [marks on MARKS]"); out.println("Row Inserted");
st=con.createStatement();
String insert="insert into Name values('"+n+"',"+mark+")"; //String st.executeUpdate(insert);
out.println("Row inerted");
}
catch (SQLException ex) { Logger.getLogger(mcqex.class.getName()).log(Level.SEVERE, null, ex);
}
}
@Override
protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
processRequest(request, response);
}
@Override
protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
processRequest(request, response);
}
@Override
public String getServletInfo() { return "Short description";
}
}
 
