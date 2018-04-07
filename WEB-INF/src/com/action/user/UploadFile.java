/**
 * 
 */
package com.action.user;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.URL;
import java.sql.ResultSet;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.DAOFactory.CommonDAO;
import com.DAOFactory.DAO;
import com.DAOFactory.DAOFactory;
import com.util.Utility;

public class UploadFile extends HttpServlet 
{
	
	public void doGet(HttpServletRequest request,HttpServletResponse response)throws IOException
	{
		HttpSession session=request.getSession();
		PrintWriter out = response.getWriter();
		try
		{
			String submit=request.getParameter("submit");
			String name=request.getParameter("name");
			System.out.println("submit---"+submit);
			System.out.println("name----"+name);
			boolean result=false;
			ResultSet rs=CommonDAO.getFiles("uploaded");
			RequestDispatcher rd=null;
			if(submit.equals("get"))
			{
				if(rs.next())
				{
					rs=CommonDAO.getFiles("uploaded");
					request.setAttribute("rs", rs);
					request.setAttribute("name", name);
					rd=request.getRequestDispatcher("/Files/JSP/User/files.jsp");
					rd.forward(request, response);
				}
				else
				{
					rd=request.getRequestDispatcher("/Files/JSP/User/files.jsp?no=-1");
					rd.forward(request, response);
				}
			}
			else if(submit.equals("Upload"))
			{
				
				
				//============================================
				
				String ip=session.getAttribute("clientip").toString();
				String serverid=CommonDAO.getSeverId(ip);
				System.out.println("===serverid==="+serverid);
				if(serverid.trim().equals("1"))
				{
					String str1="";
					String url1="http://"+Utility.getPro("IP1")+":"+Utility.getPro("Port1")+"/"+Utility.getPro("AppName1");
					String url2=url1+"/UploadFile?submit=Upload";
					System.out.println("================URL===="+url2);
					
				     
					response.sendRedirect( url1+"/UploadFile?submit=Upload&name="+name+"");
					
					
				
				}
				else if(serverid.trim().equals("2"))
				{
					String str1="";
					String url1="http://"+Utility.getPro("IP2")+":"+Utility.getPro("Port2")+"/"+Utility.getPro("AppName2");
					String url2=url1+"/UploadFile?submit=Upload&name="+name+"";
					System.out.println("================URL===="+url2);
					/*URL url = new URL( url1+"/UploadFile?submit=Upload"); 
					url.openStream();
*/					/*BufferedReader in = new BufferedReader(new InputStreamReader(url.openStream())); 
					System.out.println("Get MD method is working properlyyy");
					str1 = in.readLine(); 
					in.close(); */
				     
					response.sendRedirect( url1+"/UploadFile?submit=Upload&name="+name+"");
				}
				else
				{
					
				
				//================================================
				
				rs=CommonDAO.getFiles("uploaded");
				request.setAttribute("rs", rs);
				rd=request.getRequestDispatcher("/Files/JSP/User/files.jsp?no=1");
				rd.forward(request, response);
				}
			}
			else if(submit.equals("Delete"))
			{
				String []chk=request.getParameterValues("chk");
				request.setAttribute("name", name);
				if(chk==null)
				{
					rs=CommonDAO.getFiles("uploaded");
				    request.setAttribute("rs", rs);
					rd=request.getRequestDispatcher("/Files/JSP/User/files.jsp?no=3");
					rd.forward(request,response);
				}
				else
				{
					for(int i=0;i<chk.length;i++)
					{
						
						String fname=CommonDAO.getFileName(chk[i]);
						String hashblocks=CommonDAO.gethashblknos(fname);
						
						 String[] temp;
						 
						  /* delimiter */
						  String delimiter = "-";
						  /* given string will be split by the argument delimiter provided. */
						  temp = hashblocks.split(delimiter);
						  /* print substrings */
						  System.out.println("======== "+hashblocks);
						  String blockname="";
						  System.out.println("-----Temp Size--"+temp.length);
						  for(int j =0; j < temp.length ; j++)
						  {
							  System.out.println("--===-======-= "+temp[j]);
							    //int id2=Integer.parseInt(temp[i]);
							    blockname=CommonDAO.getblocks(temp[j]); 
							    System.out.println("-----BLOCK NAME------"+blockname);
							    boolean flag=false;
							    flag=CommonDAO.getInstance(temp[j]);
							    if(flag==true)
							    {
							    	result=Utility.deleteFile(Utility.getPro("server"),Utility.getPro("user"),Utility.getPro("pass"), blockname);	
							    	 result=CommonDAO. Updatehashtable(temp[j]);
							    }
							}
						
						 result=CommonDAO.UpdateTrans(chk[i], "uploaded");
						Utility.writeOnFile(name+".txt", "User has deleted file ("+fname+") on date "+Utility.getDate()+" and time "+Utility.getTime()+"", getServletContext().getRealPath("/"));
					
					}
						rs=CommonDAO.getFiles("uploaded");
						request.setAttribute("rs", rs);
						rd=request.getRequestDispatcher("/Files/JSP/User/files.jsp?no=4");
						rd.forward(request,response);
					}
			}
		}
		catch(Exception e)
		{
			System.out.println("Opps's Error is in User UploadFile Servlet......"+e);
			out.println("Opps's Error is in User UploadFile Servlet......"+e);
		}
	}
}
