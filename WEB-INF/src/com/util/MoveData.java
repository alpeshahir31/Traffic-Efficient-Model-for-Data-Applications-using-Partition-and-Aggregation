

package com.util;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;
import java.net.URLConnection;
import java.nio.ByteBuffer;
import java.nio.channels.Channels;
import java.nio.channels.WritableByteChannel;
import java.sql.Connection;

import com.dao.UserDAO;




public class MoveData 
{

/* Moving File From One Cloud Server To Another Cloud Server (Starts)*/	
	public static boolean moveToCloud(int srcCloudId,String fileName,int destCloudId)
	{
		BufferedInputStream bis = null;
        BufferedOutputStream bos = null;
        
		boolean flag = false;
		String srcUrl="",destUrl="";
		try
		{
			//Getting The Source Cloud Url
			System.out.println("came to MoveVideo  jav********");
				System.out.println("SrcCloudId:"+srcCloudId);
				System.out.println("DestCloudId:"+destCloudId);
				System.out.println("FileName:"+fileName);
				
				srcUrl = getCloudUrl(srcCloudId, fileName);
				System.out.println("Source Cloud Url : " + srcUrl);
				
			//Getting The Destination Cloud Url
				destUrl = getCloudUrl(destCloudId, fileName);
				System.out.println("Dest. Cloud Url : " + srcUrl);
				
				
		        //Connecting To The Source Cloud Server
		        URL url = new URL(srcUrl);
	            URLConnection urlc = url.openConnection();
	            System.out.println("Src Url: "+urlc);
	            
	            //Connecting To The Dest Cloud Server
		        URL url1 = new URL(destUrl);
	            URLConnection urlc1 = url1.openConnection();
	            System.out.println("Dest Url: "+urlc1);
	            
	            //bis = new BufferedInputStream( new FileInputStream( file ) );
	            bis = new BufferedInputStream(urlc.getInputStream());
	            bos = new BufferedOutputStream( urlc1.getOutputStream() );
	           
	            String s="";
	            int i;
	            // read byte by byte until end of stream
	            while ((i = bis.read()) != -1)
	            {
	            	 bos.write((byte)(char)i);
	            }
	            
				flag = true;
				
				//Closing The Connections
				
			   if(bis != null)
               try
               {
                  bis.close();
               }
               catch (IOException ioe)
               {
                  ioe.printStackTrace();
               }
	            
			   if(bos != null)
               try
               {
                  bos.close();
               }
               catch (IOException ioe)
               {
                  ioe.printStackTrace();
               }
		}
		catch (Exception e)
		{
			System.out.println("Opps,Exception In Util=>MoveVideo->moveToCloud(int srcCloudId,String fileName,int destCloudId) : ");
			e.printStackTrace();
		}
		
		return flag;
	}
	
	public static String getCloudUrl(int main_cloudId,String fileName)
	{
		Connection con = null;
		String ftpServerHostName="",ftpusername="",password="",dirToUploadFile="",url="";
		try 
		{
			
			
			//Composing The Cloud Url
			ftpServerHostName = UserDAO.getCloudHostName(main_cloudId);
			ftpusername = UserDAO.getCloudUsername(main_cloudId);
			password = UserDAO.getCloudPassword(main_cloudId);
			dirToUploadFile = UserDAO.getCloudDirectory(main_cloudId);
			
			if(!ftpServerHostName.equals("") && !ftpusername.equals("") && !dirToUploadFile.equals("") && !fileName.equals(""))
		    {
		         StringBuffer sb = new StringBuffer( "ftp://" ); //ftp://dhsinf17:nikisujai@dhsinformatics.com
		         // ftp://blrstore:*blrstore123@ftp.drivehq.com
		         if (ftpusername != null && password != null)
		         {
		            sb.append( ftpusername );
		            sb.append( ':' );
		            sb.append( password );
		            sb.append( '@' );
		         }
		         sb.append( ftpServerHostName );
		         sb.append( '/' );
		         sb.append( dirToUploadFile );
		         sb.append( '/' );
		         sb.append( fileName );
		         /*
		          * type ==> a=ASCII mode, i=image (binary) mode, d= file directory
		          * listing
		          */
		         sb.append( ";type=i" );
		         url = sb.toString();
		         System.out.println("URL:"+url);
		    }
		} 
		catch (Exception e) 
		{
			System.out.println("Opps,Exception In Util=>MoveVideo->getCloudUrl(int cloudId,String fileName) :");
			e.printStackTrace();
		}
		
		return url;
	}
/* Moving File From One Cloud Server To Another Cloud Server (Ends)*/	
	

/* Moving File From One Cloud Server To Local Server(Tomact Appln) (Starts)*/	
	public static boolean moveFileFromCloudToLocalVB(int srcCloudId,String fileName,int processingServerId)
	{
		BufferedInputStream bis = null;
        BufferedOutputStream bos = null;
        
		boolean flag = false;
		String srcUrl="",destUrl="";
		try
		{
			//Getting The Source Cloud Url
			//srcUrl = getCloudUrl(srcCloudId, fileName,ownername);
			//System.out.println("Source Cloud Url : " + srcUrl);
			
			//Getting The Source Cloud Url
			destUrl = getServerUrl(processingServerId, fileName);
			System.out.println("Dest Server Url : " + srcUrl);
			
	        //Connecting To The Source Cloud Server
	        URL url = new URL(srcUrl);
            URLConnection urlc = url.openConnection();
            System.out.println("Src Url Connection "+urlc);
            
            URL url1 = new URL(destUrl);
            URLConnection urlc1 = url1.openConnection();
            urlc1.setDoOutput(true);
            System.out.println("Dest Url Connection "+urlc1);
            
            //bis = new BufferedInputStream( new FileInputStream( file ) );
            bis = new BufferedInputStream(urlc.getInputStream());
            bos = new BufferedOutputStream(urlc1.getOutputStream());
           
           
            String s="";
            int i;
            // read byte by byte until end of stream
            while ((i = bis.read()) != -1)
            {
            	 bos.write((byte)(char)i);
            }
            
			flag = true;
			
			//Closing The Connections
			
		   if(bis != null)
           try
           {
              bis.close();
           }
           catch (IOException ioe)
           {
              ioe.printStackTrace();
           }
            
		   if(bos != null)
           try
           {
              bos.close();
           }
           catch (IOException ioe)
           {
              ioe.printStackTrace();
           }
		}
		catch (Exception e)
		{
			System.out.println("Opps,Exception In Util=>MoveVideo->moveFileFromCloudToLocalVB(int srcCloudId,String fileName,int processingServerId) : ");
			e.printStackTrace();
		}
		
		return flag;
	}
	
	public static String getServerUrl(int processingServerId,String fileName)
	{
		Connection con = null;
		String processingServerIP="",processingServerName="",processingServerUrl="";
		int processingServerPort=0;
		try 
		{
			//con = DAO.getConnection();
			
			//processingServerIP = User_DAO.getProcessServerIPaddress(con,processingServerId);
			//processingServerPort = User_DAO.getProcessServerPort(con, processingServerId);
			//processingServerName = User_DAO.getProcessServerName(con, processingServerId);
			
			//processingServerUrl = "http://192.168.1.16:8080/AMES_LocalVB1/Res/Files/Videos/"+fileName;
			processingServerUrl = "http://"+processingServerIP+":"+processingServerPort+"/"+processingServerName+"/Res/Files/Videos/"+fileName;
			System.out.println("Processing Server URL :\n"+processingServerUrl);
			
			
		} 
		catch (Exception e) 
		{
			System.out.println("Opps,Exception In Util=>MoveVideo->getCloudUrl(int cloudId,String fileName) :");
			e.printStackTrace();
		}
		
		return processingServerUrl;
	}
	
	
/* Moving File From One Cloud Server To Local Server(Tomact Appln) (Starts)*/	
	
/*  Testing The Developments */
	
	public static void main(String[] args) 
	{
		
/*		boolean flag = moveToCloud(1,"bg4.jpg",2);
		if(flag)
		{
			System.out.println("File Moved Successfully.....");
		}
		else
		{
			System.out.println("Opps,Something Went Wrong!!!!!");
		}
*/		
		boolean flag = moveFileFromCloudToLocalVB(1,"4607test.flv",1);
		if(flag)
		{
			System.out.println("File Moved Successfully.....");
		}
		else
		{
			System.out.println("Opps,Something Went Wrong!!!!!");
		}

		
	}
}
