/**
 * 
 */
package com.action.user;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;

import com.DAOFactory.CommonDAO;
import com.dao.UserDAO;
import com.database.Database;

import com.util.MoveData;
import com.util.Utility;


public class DownloadFile extends HttpServlet 
{ 
	String processingServerUrl="";
	private static Connection connection = null;
	private static Statement statement = null;
	private static ResultSet resultSet = null;	
	int subVbId = 0;
	
	public void service(HttpServletRequest request,HttpServletResponse response)
	{
		ArrayList<String> list = new ArrayList<String>();
		 int  SubServerId=0;
		 String transactionStatus = "",SubServerIP="",SubServerPort="",SubServerName="";
		 boolean flag7=false;
		 HttpSession session = request.getSession();
		 
		 int sub_server_id = 0;
		 
		try
		{
			String submit=request.getParameter("submit");
			String name=request.getParameter("name");
			boolean result=false;
			//int id=CommonDAO.getID(name);
			ResultSet rs=CommonDAO.getFiles("Upload");
			RequestDispatcher rd=null;
			if(submit.equals("get"))
			{
				if(rs.next())
				{
					rs=CommonDAO.getFiles("Upload");
					request.setAttribute("rs", rs);
					request.setAttribute("name", name);
					rd=request.getRequestDispatcher("/Files/JSP/User/download.jsp");
					rd.forward(request, response);
				}
				else
				{
					rd=request.getRequestDispatcher("/Files/JSP/User/download.jsp?no=-1");
					rd.forward(request, response);
				}
			}
			else if(submit.equals("Delete"))
			{
				String []chk=request.getParameterValues("chk");
				request.setAttribute("name", name);
				if(chk==null)
				{
					rs=CommonDAO.getFiles("Upload");
					request.setAttribute("rs", rs);
					rd=request.getRequestDispatcher("/Files/JSP/User/download.jsp?no=3");
					rd.forward(request,response);
				}
				else
				{
					for(int i=0;i<chk.length;i++)
					{
						String fname=CommonDAO.getFileName(chk[i]);
						result=Utility.deleteFile(Utility.getPro("server"), Utility.getPro("user"), Utility.getPro("pass"), fname);
						if(result)
						{
						CommonDAO.UpdateTrans(chk[i], "Upload");
						Utility.writeOnFile(name+".txt", "User has deleted file ("+fname+") on date "+Utility.getDate()+" and time "+Utility.getTime()+"", getServletContext().getRealPath("/"));
						}
					}
					if(result)
					{
						rs=CommonDAO.getFiles("Upload");
						request.setAttribute("rs", rs);
						rd=request.getRequestDispatcher("/Files/JSP/User/download.jsp?no=4");
						rd.forward(request,response);
					}
					if(result==false)
					{
						rd=request.getRequestDispatcher("/Files/JSP/User/files.jsp?no=5");
						rd.forward(request,response);
					}
				}
			}
			else if(submit.equals("Download"))
			{
						String []chk=request.getParameterValues("chk");
						request.setAttribute("name", name);
						
						
						if(chk==null || chk.length!=1)
						{
							rs=CommonDAO.getFiles("Upload");
							request.setAttribute("rs", rs);
							rd=request.getRequestDispatcher("/Files/JSP/User/download.jsp?no=3");
							rd.forward(request,response);
						}
						else
						{
							
							
							
							String ip=session.getAttribute("clientip").toString();
							String serverid=CommonDAO.getSeverId(ip);
							System.out.println("===serverid==="+serverid);
							if(serverid.trim().equals("1"))
							{
								String url1="http://"+Utility.getPro("IP1")+":"+Utility.getPro("Port1")+"/"+Utility.getPro("AppName1");
							//	String url2=url1+"/UploadFile?submit=Upload";
							//	System.out.println("================URL===="+url2);
								
							     
								response.sendRedirect( url1+"/DownloadFile?submit=Download&chk="+chk[0]+"");
							}
							else if(serverid.trim().equals("2"))
							{
								String url1="http://"+Utility.getPro("IP2")+":"+Utility.getPro("Port2")+"/"+Utility.getPro("AppName2");
								//	String url2=url1+"/UploadFile?submit=Upload";
								//	System.out.println("================URL===="+url2);
									
								     
									response.sendRedirect( url1+"/DownloadFile?submit=Download&chk="+chk[0]+"");
							}
							else
							{
							
								String fname=CommonDAO.getFileName(chk[0]);
								String hashblknos=CommonDAO.gethashblknos(fname);
								System.out.println("Hash blocks id is"+hashblknos);
								
								String str = CommonDAO.gethashblknos(fname);
								  String[] temp;
								 
								  /* delimiter */
								  String delimiter = "-";
								  /* given string will be split by the argument delimiter provided. */
								  temp = str.split(delimiter);
								  /* print substrings */
								  System.out.println("======== "+str);
								  String blockname="";
								  String dest1=request.getRealPath("") + "/MergedFile/"+fname; 
								  File f=new File(dest1);
								  f.delete();
								  String dest=request.getRealPath("") + "/MergedFile/"+fname;
								 // File fin = new File(Merged);
								  List<File> list1 = new ArrayList<File>();
								  System.out.println("-----Temp Size--"+temp.length);
								  for(int i =0; i < temp.length ; i++)
								  {  
								    System.out.println("--===-======-= "+temp[i]);
								 
								    blockname=CommonDAO.getblocks(temp[i]); 
									System.out.println("----BLOCKNAME-----"+blockname);
									
									String destFilePath=request.getRealPath("") + "/Download/";
									
									//===============================Hadoop Download Process===================================================
									
									try
									{
										list1.add(new File(destFilePath+blockname));

										result=Utility.download(Utility.getPro("server"), Utility.getPro("user"), Utility.getPro("pass"),blockname,destFilePath);
									}
									
									catch(Exception e)
									{
										
										e.printStackTrace();
									}
									
									
							
							}
							
							
							
											
											
								 try
									{
									 
									 String FILE_NAME1 = fname;
										System.out.println("-------------------FNAME-------------------------"+fname);
										String FILE_NAME5=FILE_NAME1.replace(".", "_");
										int PART_SIZE = 1000;
										
										 String path=request.getRealPath("") + "/MergedFile/";
										// String path1=request.getRealPath("") + "/Download/";
										    String FILE_NAME2 =path+fname;
										    String FILE_NAME3 = FILE_NAME5;
										
											File ofile = new File(FILE_NAME2);
											System.out.println("ofile is)))))))))))))))))))))))"+ofile);
											
											FileOutputStream fos;
											FileInputStream fis;
											byte[] fileBytes;
											int bytesRead = 0;
									 
									 fos = new FileOutputStream(ofile,true);
									    
									    System.out.println("List contents are>>>>>>................."+list);
									    
									    for (File file : list1)
									    {
									    	
									        fis = new FileInputStream(file);
									        
									        
									        
									        fileBytes = new byte[(int) file.length()];
									        
									       
									        
									        bytesRead = fis.read(fileBytes, 0,(int)  file.length());
									        
									        
									        System.out.println("file bytes are>>>>>>>>>>>>>>>>>>>>>>>> "+bytesRead);
									        
									        assert(bytesRead == fileBytes.length);
									        assert(bytesRead == (int) file.length());
									        fos.write(fileBytes);
									        fos.flush();
									        fileBytes = null;
									        fis.close();
									        fis = null;
									    }
									    
									    fos.close();
									    fos = null;
									 
									 
									 
									 
									 
									 
									 
									 
									 
									 
									 
									 
									String filename="";
									String downloadedfilepath=dest;
									File file = new File(downloadedfilepath);
									ServletContext context = getServletContext();
									String mimeType = context.getMimeType(downloadedfilepath);
									if (mimeType == null) 
									{
									// set to binary type if MIME mapping not found
									mimeType = "application/octet-stream";
									}
									System.out.println("MIME type: " + mimeType);
																					
									// modifies response
									response.setContentType(mimeType);
									response.setContentLength((int) file.length());

									System.out.println("=======lenghthhhhh========="+(int) file.length());
									FileInputStream inStream = new FileInputStream(file);												
									// forces download
									String headerKey = "Content-Disposition";
									String headerValue = String.format("attachment; filename=\"%s\"", file.getName());
									
									response.setHeader(headerKey, headerValue);
									// obtains response's output stream
									OutputStream outStream = response.getOutputStream();
																					
									byte[] buffer = new byte[100096];
									int bytesRead1 = -1;
																					
									while ((bytesRead1 = inStream.read(buffer)) != -1) 
									{
									outStream.write(buffer, 0, bytesRead1);
									}
									inStream.close();
									outStream.close();
									}
									catch(Exception e)
									{
										e.printStackTrace();
									}
							
					         }
						}
		
			        }
		        }
				catch(Exception e)
				{
					e.printStackTrace();
					System.out.println("Opps's Error is in User DownloadFile Servlet......"+e);
				}
	}
}