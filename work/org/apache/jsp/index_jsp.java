package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import com.util.*;
import java.net.*;

public final class index_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");

//int no=Utility.parse(request.getParameter("no"));

      out.write("\r\n");
      out.write("<link href=\"");
      out.print(request.getContextPath());
      out.write("/Files/CSS/style.css\"\r\n");
      out.write("\trel=\"stylesheet\" type=\"text/css\" />\r\n");
      out.write("<link href=\"");
      out.print(request.getContextPath());
      out.write("/Files/CSS/message.css\"\r\n");
      out.write("\trel=\"stylesheet\" type=\"text/css\" />\r\n");
      out.write("<link rel=\"stylesheet\"\r\n");
      out.write("\thref=\"");
      out.print(request.getContextPath());
      out.write("/Files/CSS/login.css\"\r\n");
      out.write("\ttype=\"text/css\" />\r\n");
      out.write("<script type=\"text/javascript\"\r\n");
      out.write("\tsrc=\"");
      out.print(request.getContextPath());
      out.write("/Files/JS/style.js\"></script>\r\n");
      out.write("<link href=\"");
      out.print(request.getContextPath());
      out.write("/Files/CSS/styles.css\" rel=\"stylesheet\" type=\"text/css\" />\r\n");
      out.write("<link href=\"");
      out.print(request.getContextPath());
      out.write("/Files/CSS/logins.css\" rel=\"stylesheet\" type=\"text/css\" />\r\n");
      out.write("<link href=\"");
      out.print(request.getContextPath());
      out.write("/Files/CSS/popup.css\" rel=\"stylesheet\" type=\"text/css\" />\r\n");
      out.write("<script src=\"");
      out.print(request.getContextPath());
      out.write("/Files/JS/jquery-1.6.4.min.js\" type=\"text/javascript\"></script>\r\n");
      out.write("\r\n");
InetAddress thisIp = InetAddress.getLocalHost(); 
String ip=thisIp.getHostAddress();


      out.write("\r\n");
      out.write("\r\n");
      out.write("</head>\r\n");
      out.write("\r\n");
      out.write("<body   onload=\"startTimer()\" >\r\n");
      out.write("<div \tstyle=\"position: centre;  left: -10px;\"\t>\r\n");
      out.write("\t<img src=\"");
      out.print(request.getContextPath());
      out.write("/Files/Images/cooltext11.png\" width=100%></img>  \r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\t<div class=\"TabMenu\" id=\"label\"\tstyle=\"position: absolute;  right: 0px;\"\t>\r\n");
      out.write("\t\r\n");
      out.write("\t\t<a href=\"#overlay\" id=\"button1\"><span style=\"position: absolute; top: 110px; height:120; width:120\">\r\n");
      out.write("\t\t \r\n");
      out.write("\t\t<img src=\"");
      out.print(request.getContextPath() );
      out.write("/Files/Images/admin1.png\" align=\"center\" height=\"120\" width=\"120\"  />\r\n");
      out.write("\t\t\t</a>\r\n");
      out.write("\t\t</span> \r\n");
      out.write("\t\t\r\n");
      out.write("\t\t<a href=\"#overlay_signup\" id=\"button1\"><span style=\"position: absolute; top: 210px; height:120; width:120\"> \r\n");
      out.write("\t\t<br/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;\r\n");
      out.write("\t\t <img src=\"");
      out.print(request.getContextPath() );
      out.write("/Files/Images/user1.png\" height=\"120\" width=\"120\" />\r\n");
      out.write("\t\t\t<br/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;\r\n");
      out.write("\t\t\t&nbsp;&nbsp;&nbsp;&nbsp;\r\n");
      out.write("\t\t\t\r\n");
      out.write("\t\t</span> \r\n");
      out.write("\t\t\r\n");
      out.write("\t\r\n");
      out.write("\t\t\r\n");
      out.write("\t</div>\r\n");
      out.write("\r\n");
      out.write("\t<!-- Admin Login Pop Up -->\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\t <div id=\"overlay\"> \r\n");
      out.write("\r\n");
      out.write("\t\t <div id=\"popup\"> \r\n");
      out.write("\t\t\t<a href=\"\"> <img class=\"close_button\" src=\"");
      out.print(request.getContextPath() );
      out.write("/Files/Images/c.png\"height=\"30\"\r\n");
      out.write("\t\t\t\twidth=\"30\" onmouseover=\"this.src='../Files/Images/c1.png';\" onmouseout=\"this.src='../Files/Images/c.png';\" /></a>\r\n");
      out.write("\r\n");
      out.write("\t\t\t<form class=\"login\" action=\"");
      out.print(request.getContextPath());
      out.write("/AdminLogin\"\r\n");
      out.write("\t\t\t\tmethod=\"post\">\r\n");
      out.write("\r\n");
      out.write("\t\t\t\t<center>\r\n");
      out.write("\t\t\t\t\t<label><font\r\n");
      out.write("\t\t\t\t\t\tstyle=\"font-family: Monotype Corsiva; font-size: 35px; color: blue;\">ADMIN LOGIN</font></label>\r\n");
      out.write("\t\t\t\t</center>\r\n");
      out.write("\t\t\t\t<br> <label><font style=\"color: brown;\">AdminID</font></label>&nbsp;&nbsp; <input type=\"text\" tabindex=\"1\" class=\"input\"\r\n");
      out.write("\t\t\t\t\tplaceholder=\"Admin Id\" name=\"name\" required><br> <br>\r\n");
      out.write("\r\n");
      out.write("\t\t\t\t<label><font style=\"color: BROWN;\">Password</font></label> <input\r\n");
      out.write("\t\t\t\t\ttype=\"password\" class=\"input\" tabindex=\"2\" name=\"pass\"\r\n");
      out.write("\t\t\t\t\tplaceholder=\"Password\" required><br> <br>\r\n");
      out.write("\t\t\t\t&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type=\"image\" id=\"\"\r\n");
      out.write("\t\t\t\t\tvalue=\"submit\" src=\"");
      out.print(request.getContextPath() );
      out.write("/Files/Images/login2.png\"alt=\"submit Button\"\r\n");
      out.write("\t\t\t\t\tclass=\"gradientbuttons\"\r\n");
      out.write("\t\t\t\t\twidth=\"120\" height=\"80\">\r\n");
      out.write("\t\t\t</form>\r\n");
      out.write("\t\t </div> \r\n");
      out.write("\r\n");
      out.write(" </div> \r\n");
      out.write("\r\n");
      out.write("\t<!-- User Login Pop Up -->\r\n");
      out.write("\r\n");
      out.write("\t<div id=\"overlay_signup\">\r\n");
      out.write("\t\t<div id=\"popup\">\r\n");
      out.write("\t\t\t<a href=\"\"><img class=\"close_button\" src=\"");
      out.print(request.getContextPath() );
      out.write("/Files/Images/c.jpg\"height=\"30\"\r\n");
      out.write("\t\t\t\twidth=\"30\" /></a>\r\n");
      out.write("\r\n");
      out.write("\t\t\t<form class=\"login\" action=\"");
      out.print(request.getContextPath());
      out.write("/UserLogin\"\r\n");
      out.write("\t\t\t\tmethod=\"post\">\r\n");
      out.write("\t\t\t\t\r\n");
      out.write("\t\t\t\t<input type=\"hidden\" name=\"clientip\" value=\"");
      out.print(ip);
      out.write("\">\r\n");
      out.write("\t\t\t\t <input type=\"hidden\" name=\"ip\" value=");
      out.print(ip);
      out.write(">\r\n");
      out.write("                ");
session.setAttribute("ipadd",ip); 
      out.write("\r\n");
      out.write("\t\t\t\t<center>\r\n");
      out.write("\t\t\t\t\t<label><font\r\n");
      out.write("\t\t\t\t\t\tstyle=\"font-family: Monotype Corsiva; font-size: 35px; color: blue;\">USER LOGIN</font></label>\r\n");
      out.write("\t\t\t\t</center>\r\n");
      out.write("\t\t\t\t<br> <label><font style=\"color: brown;\">UserID</font></label> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <input type=\"text\"\r\n");
      out.write("\t\t\t\t\ttabindex=\"1\" class=\"input\" name=\"name\" placeholder=\"User Id\"\r\n");
      out.write("\t\t\t\t\trequired><br> <br> <label><font\r\n");
      out.write("\t\t\t\t\tstyle=\"color: BROWN;\">Password</font></label><input type=\"password\"\r\n");
      out.write("\t\t\t\t\tclass=\"input\" tabindex=\"2\" name=\"pass\" placeholder=\"Password\"\r\n");
      out.write("\t\t\t\t\trequired><br> <br> <br>\r\n");
      out.write("\r\n");
      out.write("\t\t\t\t&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type=\"image\" id=\"\"\r\n");
      out.write("\t\t\t\t\tvalue=\"submit\" src=\"");
      out.print(request.getContextPath() );
      out.write("/Files/Images/login2.png\" alt=\"submit Button\"\r\n");
      out.write("\t\t\t\t\t class=\"gradientbuttons\"\r\n");
      out.write("\t\t\t\t\twidth=\"120\" height=\"80\">&nbsp;&nbsp;&nbsp;&nbsp; \r\n");
      out.write("\t\t\t\t\r\n");
      out.write("\t\t\t</form>\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t</div>\r\n");
      out.write("\r\n");
      out.write("\t<!-- Tpa Login Pop Up -->\r\n");
      out.write("\t<!--  <div id=\"overlay-tpa\">\r\n");
      out.write("\r\n");
      out.write("\t\t<div id=\"popup\">\r\n");
      out.write("\t\t\t<a href=\"\"> <img class=\"close_button\" src=\"");
      out.print(request.getContextPath() );
      out.write("/Files/Images/close.png\" height=\"50\"\r\n");
      out.write("\t\t\twidth=\"50\"/></a>\r\n");
      out.write("\r\n");
      out.write("\t\t\t<form class=\"login\" action=\"");
      out.print(request.getContextPath());
      out.write("/AuditorLogin\"\r\n");
      out.write("\t\t\t\tmethod=\"post\">\r\n");
      out.write("\r\n");
      out.write("\t\t\t\t<center>\r\n");
      out.write("\t\t\t\t\t<label><font\r\n");
      out.write("\t\t\t\t\t\tstyle=\"font-family: Monotype Corsiva; font-size: 35px; color: #DAA520;\">Auditor's\r\n");
      out.write("\t\t\t\t\t\t\tLogin</font></label>\r\n");
      out.write("\t\t\t\t</center>\r\n");
      out.write("\t\t\t\t<br> <label><font style=\"color: #336633;\">Auditor's Id</font></label>&nbsp;&nbsp;\r\n");
      out.write("\t\t\t\t<input type=\"text\" tabindex=\"1\" class=\"input\" placeholder=\"Tpa Id\"\r\n");
      out.write("\t\t\t\t\tname=\"name\" required><br> <br> <label><font\r\n");
      out.write("\t\t\t\t\tstyle=\"color: #336633;\">Password</font></label> <input type=\"password\"\r\n");
      out.write("\t\t\t\t\tclass=\"input\" tabindex=\"2\" name=\"pass\" placeholder=\"Password\"\r\n");
      out.write("\t\t\t\t\trequired><br> <br>\r\n");
      out.write("\t\t\t\t&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type=\"image\" id=\"\"\r\n");
      out.write("\t\t\t\t\tvalue=\"submit\" src=\"");
      out.print(request.getContextPath() );
      out.write("/Files/Images/login2.png\" alt=\"submit Button\"\r\n");
      out.write("\t\t\t\t\t class=\"gradientbuttons\"\r\n");
      out.write("\t\t\t\t\twidth=\"120\" height=\"80\">\r\n");
      out.write("\t\t\t</form>\r\n");
      out.write("\t\t</div></div>-->\r\n");
      out.write("\t\t");

		int noo=Utility.parse(request.getParameter("no"));
		if(noo==1)
{
	
      out.write("\r\n");
      out.write("\t\t\r\n");
      out.write("\t\t\t<div class=\"error\" id=\"message\" style=\"height: 65; width: 250px; top:180\" >\t\r\n");
      out.write("\t\t\t<p>Opp's,your Id or password is wrong ..!</p>\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t\t\t\r\n");
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
