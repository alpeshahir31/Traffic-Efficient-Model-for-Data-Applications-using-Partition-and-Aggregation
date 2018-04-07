package org.apache.jsp.Files.JSP.Admin;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import com.util.*;
import java.sql.*;

public final class adduser_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List _jspx_dependants;

  private javax.el.ExpressionFactory _el_expressionfactory;
  private org.apache.AnnotationProcessor _jsp_annotationprocessor;

  public Object getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
    _jsp_annotationprocessor = (org.apache.AnnotationProcessor) getServletConfig().getServletContext().getAttribute(org.apache.AnnotationProcessor.class.getName());
  }

  public void _jspDestroy() {
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;


    try {
      response.setContentType("text/html");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("\r\n");
      out.write("\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("<link href=\"");
      out.print(request.getContextPath() );
      out.write("/Files/CSS/message.css\"\r\n");
      out.write("\trel=\"stylesheet\" type=\"text/css\" />\r\n");
      out.write("<link rel=\"stylesheet\"\r\n");
      out.write("\thref=\"");
      out.print(request.getContextPath() );
      out.write("/Files/CSS/login.css\"\r\n");
      out.write("\ttype=\"text/css\" />\r\n");
      out.write("<script type=\"text/javascript\"\r\n");
      out.write("\tsrc=\"");
      out.print(request.getContextPath() );
      out.write("/Files/JS/style.js\"></script>\r\n");
      out.write("<link href=\"");
      out.print(request.getContextPath());
      out.write("/Files/CSS/styles.css\"\r\n");
      out.write("\trel=\"stylesheet\" type=\"text/css\" />\r\n");
      out.write("<link href=\"");
      out.print(request.getContextPath());
      out.write("/Files/CSS/logins.css\"\r\n");
      out.write("\trel=\"stylesheet\" type=\"text/css\" />\r\n");
      out.write("<link href=\"");
      out.print(request.getContextPath());
      out.write("/Files/CSS/popup.css\"\r\n");
      out.write("\trel=\"stylesheet\" type=\"text/css\" />\r\n");
      out.write("<script src=\"");
      out.print(request.getContextPath());
      out.write("/Files/JS/jquery-1.6.4.min.js\"\r\n");
      out.write("\ttype=\"text/javascript\"></script>\r\n");
      out.write("<style>\r\n");
      out.write("table, tr, td\r\n");
      out.write("th, td\r\n");
      out.write("{\r\n");
      out.write("padding:8px;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("</style>\r\n");
      out.write("</head>\r\n");

    Class.forName("com.mysql.jdbc.Driver");
    Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/bigdata_ontraffic_aware","root", "root");
    Statement st = con.createStatement();
    ResultSet rs=st.executeQuery("select * from userlogin");
    
    
      out.write("\r\n");
      out.write("<body onload=\"startTimer()\">\r\n");
      out.write("\r\n");
      out.write("\t<!-- User Register Pop Up -->\r\n");
      out.write("\r\n");
      out.write("\t<div >\r\n");
      out.write("\t\t<div id=\"popup\" style=\"height: 400px; width: 600px; padding: 10px; background-color: #FFFFD1\">\r\n");
      out.write("\r\n");
      out.write("\t\t\t\r\n");
      out.write("\r\n");
      out.write("\t\t\t<form action=\"");
      out.print(request.getContextPath() );
      out.write("/UserList\">\r\n");
      out.write("\t\t\t\t<input type=\"hidden\" name=\"submit\" value=\"Add\"></input> <input\r\n");
      out.write("\t\t\t\t\ttype=\"hidden\" name=\"add1\" value=\"YES\"></input>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\t\t\t\t<div style=\"position: absolute; top: 30px; left: 50px;\">\r\n");
      out.write("\t\t\t\t\r\n");
      out.write("\t\t\t\t<center><label><font style=\"font-family: Monotype Corsiva; font-size: 35px; color:blue;\">User\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\tRegistration</font></label></center><br></br>\r\n");
      out.write("\t\t\t\t\t<table style=\"width: 130\">\r\n");
      out.write("\t\t\t\t\t\t\r\n");
      out.write("\t\t\t\t\t\t\r\n");
      out.write("\t\t\t\t\t\t\r\n");
      out.write("\t\t\t\t\t\t\r\n");
      out.write("\t\t\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t\t\t<td><label><font style=\"color: maroon;font-weight: bold;\">UserId</font></label></td>\r\n");
      out.write("\t\t\t\t\t\t\t<td><input type=\"text\" tabindex=\"1\" name=\"id\" class=\"input\" placeholder=\"User Id\"\r\n");
      out.write("\t\t\t\t\t\t\t\trequired></td>\r\n");
      out.write("\t\t\t\t\t\t\t\t<td> <label><font style=\"color: maroon;font-weight: bold;\">Password</font></label></td>\r\n");
      out.write("\t\t\t\t\t\t\t\t<td> <input type=\"password\" class=\"input\" name=\"pass\" tabindex=\"2\"\r\n");
      out.write("\t\t\t\t\t\t\t\tplaceholder=\"Password\" required></td>\r\n");
      out.write("\t\t\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t\t\t\r\n");
      out.write("\t\t\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t\t\t<td><label><font style=\"color: maroon;font-weight: bold;\">User Name</font></label> </td><td>\r\n");
      out.write("\t\t\t\t\t\t\t<input type=\"text\" tabindex=\"1\" class=\"input\" name=\"name\"\r\n");
      out.write("\t\t\t\t\t\t\t\tplaceholder=\"User Name\" required></td>\r\n");
      out.write("\t\t\t\t\t\t\t\t\r\n");
      out.write("\t\t\t\t\t\t\t\t<td> <label><font style=\"color: maroon;font-weight: bold;\">Gender</font></label></td>\r\n");
      out.write("\t\t\t\t\t\t\t\t<td> <input name=\"gender\" value=\"Male\"\r\n");
      out.write("\t\t\t\t\t\t\t\ttype=\"radio\" checked=\"true\" /> Male<input\r\n");
      out.write("\t\t\t\t\t\t\t\tname=\"gender\" value=\"Female\" type=\"radio\" />Female</td>\r\n");
      out.write("\t\t\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t\t\t\r\n");
      out.write("\r\n");
      out.write("\t\t\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t\t\t<td><label><font style=\"color: maroon;font-weight: bold;\">Address</font></label>\r\n");
      out.write("\t\t\t\t\t\t\t\t</td><td> <input type=\"text\"\r\n");
      out.write("\t\t\t\t\t\t\t\ttabindex=\"1\" name=\"add\" class=\"input\" placeholder=\"Address\"\r\n");
      out.write("\t\t\t\t\t\t\t\trequired></td><td> <label><font\r\n");
      out.write("\t\t\t\t\t\t\t\t\tstyle=\"color: maroon;font-weight: bold;\">City</font></label>\r\n");
      out.write("\t\t\t\t\t\t\t\t</td><td>\r\n");
      out.write("\t\t\t\t\t\t\t\t<input type=\"text\" class=\"input\" tabindex=\"2\" name=\"city\"\r\n");
      out.write("\t\t\t\t\t\t\t\tplaceholder=\"City\" required></td>\r\n");
      out.write("\t\t\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t\t\t\r\n");
      out.write("\r\n");
      out.write("\t\t\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t\t\t<td><label><font style=\"color: maroon;font-weight: bold;\">Email</font></label>\r\n");
      out.write("\t\t\t\t\t\t\t\t</td><td>\r\n");
      out.write("\t\t\t\t\t\t\t\t<input type=\"text\" tabindex=\"1\" class=\"input\" name=\"email\"\r\n");
      out.write("\t\t\t\t\t\t\t\tplaceholder=\"Email\"\r\n");
      out.write("\t\t\t\t\t\t\t\tpattern=\"\\w+([-+.]\\w+)*@\\w+([-.]\\w+)*\\.\\w+([-.]\\w+)*\" required>\r\n");
      out.write("\t\t\t\t\t\t\t\t\r\n");
      out.write("\t\t\t\t\t\t\t\t</td><td><label> <font style=\"color: maroon;font-weight: bold;\">Phone</font></label>\r\n");
      out.write("\t\t\t\t\t\t\t\t</td><td> <input type=\"text\"\r\n");
      out.write("\t\t\t\t\t\t\t\tclass=\"input\" tabindex=\"2\" name=\"phone\" placeholder=\"Phone\"\r\n");
      out.write("\t\t\t\t\t\t\t\tpattern=\"[7-9]{1}[0-9]{9}\" minlength=\"10\" maxlength=\"10\" required></td>\r\n");
      out.write("\t\t\t\t\t\t</tr>\r\n");
      out.write("\r\n");
      out.write("\t\t\t\t\t\t\r\n");
      out.write("\r\n");
      out.write("\t\t\t\t\t\t\r\n");
      out.write("</center>\r\n");
      out.write("\t\t\t\t\t</table>\r\n");
      out.write("\t\t\t\t\t<center>\r\n");
      out.write("\t\t\t\t\t<input type=\"image\" id=\"\" value=\"register\"src=\"");
      out.print(request.getContextPath() );
      out.write("/Files/Images/register.png\"\r\n");
      out.write("\t\t\t\t\t\t\t\talt=\"submit Button\" width=\"80\" height=\"30\"></center>\r\n");
      out.write("\t\t\t\t</div>\r\n");
      out.write("\r\n");
      out.write("\t\t\t</form>\r\n");
      out.write("\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t</div>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\t");

			int no = Utility.parse(request.getParameter("no"));
			if (no == 1) {
		
      out.write("\r\n");
      out.write("\t<div class=\"error\" id=\"message\">\r\n");
      out.write("\t\t<p>Opp's,Invalid userid / password..!</p>\r\n");
      out.write("\t</div>\r\n");
      out.write("\t");

			}
			if (no == 3) {
		
      out.write("\r\n");
      out.write("\t<div class=\"error\" id=\"message\">\r\n");
      out.write("\t\t<p>Opp's,Something went wrong ..!</p>\r\n");
      out.write("\t</div>\r\n");
      out.write("\t");

			}
			if (no == 4) {
		
      out.write("\r\n");
      out.write("\t<div class=\"success\" id=\"message\">\r\n");
      out.write("\t\t<p>You have registered successfully!</p>\r\n");
      out.write("\t</div>\r\n");
      out.write("\t");

			}
		
      out.write("\r\n");
      out.write("\t</div>\r\n");
      out.write("\r\n");
      out.write("\t");

			if (Utility.parse(request.getParameter("no1")) == 5) {
		
      out.write("\r\n");
      out.write("\t<div class=\"error\" id=\"message\" style=\"position: absolute\">\r\n");
      out.write("\t\t<p>Sorry this user id is already exists.....!</p>\r\n");
      out.write("\t</div>\r\n");
      out.write("\t");

			}
		
      out.write("\r\n");
      out.write("</body>\r\n");
      out.write("</html>");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try { out.clearBuffer(); } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else log(t.getMessage(), t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
