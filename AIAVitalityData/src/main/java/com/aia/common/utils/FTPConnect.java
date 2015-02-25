package com.aia.common.utils;

import java.io.IOException;
import java.net.SocketException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTPFile;
import org.apache.log4j.Logger;

import com.aia.data.DataOutputProcessor;

public class FTPConnect {
	
	static Logger logger = Logger.getLogger(FTPConnect.class);
	 public static FTPClient getFtpConnection()
	  {
		  // get an ftpClient object  
		  FTPClient ftpClient = new FTPClient();  
		  
		  try {  
		   // pass directory path on server to connect  
		   ftpClient.connect("0343825.netsolhost.com");  
		  
		   // pass username and password, returned true if authentication is  
		   // successful  
		   boolean login = ftpClient.login("verticurl_aia", "Passw0rd2015");  
		  
		   if (login) {  
		    System.out.println("Connection established...");  
		    System.out.println("Status: "+ftpClient.getStatus());  
		 
		   } else {  
		    System.out.println("Connection fail...");  
		   }  
		  
		  } catch (SocketException e) {  
		   e.printStackTrace();  
		  } catch (IOException e) {  
		   e.printStackTrace();  
		  }   
		  return ftpClient;
		 }  
	 
	 public static void disconnectConn(FTPClient ftpClient)
	 {
		 try
		 {
			 boolean logout = ftpClient.logout();  
			    if (logout) {  
			     System.out.println("Connection close...");  
			    }  
			   else {  
			    System.out.println("Connection fail...");  
			   }  
		 }
		 catch (SocketException e) {  
			   e.printStackTrace();  
			  } catch (IOException e) {  
			   e.printStackTrace();  
			  } finally {  
			   try {  
			    ftpClient.disconnect();  
			   } catch (IOException e) {  
			    e.printStackTrace();  
			   }  
			  }  
	 }

}
