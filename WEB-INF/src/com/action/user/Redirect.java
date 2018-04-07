package com.action.user;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.URL;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.DAOFactory.CommonDAO;
import com.DAOFactory.DAO;
import com.DAOFactory.DAOFactory;
import com.util.Utility;

public class Redirect extends HttpServlet
{

	
	public void doPost(HttpServletRequest request,HttpServletResponse response)throws IOException
	{
		PrintWriter out = response.getWriter();
		HttpSession session =request.getSession();
		try
		{
			String ip=session.getAttribute("clientip").toString();
			String serverid=CommonDAO.getSeverId(ip);
			System.out.println("===serverid==="+serverid);
			if(serverid.trim().equals("1"))
			{
				String str1="";
				String url1="http://"+Utility.getPro("IP1")+":"+Utility.getPro("Port1")+"/"+Utility.getPro("AppName1");
				
				URL url = new URL( url1+"/UploadFile?submit=Upload"); 
				BufferedReader in = new BufferedReader(new InputStreamReader(url.openStream())); 
				System.out.println("Get MD method is working properlyyy");
				str1 = in.readLine(); 
				in.close(); 
			     

				
				
			
			}
			else
			{
				response.sendRedirect(request.getContextPath()+"?no=1");
			}
		}
		catch(Exception e)
		{
			System.out.println("Opps's Error is in UserLogin Servlet......"+e);
			out.println("Opps's Error is in UserLogin Servlet......"+e);
		}
	}
}
