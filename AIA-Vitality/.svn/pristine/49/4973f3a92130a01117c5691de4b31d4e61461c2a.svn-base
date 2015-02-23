package com.aia.data;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Iterator;
import java.util.List;

import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTPFile;
import org.apache.log4j.Logger;

import com.aia.common.utils.CSVReader;
import com.aia.common.utils.FTPConnect;

public class DataInputProcessor {
	
	private static final String localDirectory = "D://Temp";
	static Logger logger = Logger.getLogger(DataInputProcessor.class);
	
	  public static void retrieveFiles(FTPClient ftpClient)
	  {
		  FTPFile[] files = null; 
		  OutputStream output = null; 
		  BufferedOutputStream bos = null;
		  try {
			  files = ftpClient.listFiles();
			  for (FTPFile file : files) {
			        String details = file.getName();
			        output = new FileOutputStream(localDirectory + "/" + file.getName());
			        ftpClient.retrieveFile(details, output); 
			        output.close();
			        output=null;
			 		processFiles(localDirectory + "/" + file.getName());   
			        System.out.println(details);
			    }
			 
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	  }

	  
	  public static void processFiles(String fileName)
	  {
		    File inputCsvbook = new File(fileName);
		    FileReader fr = null;
			try {
				fr = new FileReader(inputCsvbook);
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		    CSVReader csvr = new CSVReader(fr);
		    List recordList = null;
		    Iterator itr = null;
		    String[] headerRow = null;
			String[] mandatoryHeaderRow = null;
			Integer colNum = 1;
		    try
			{
		    	recordList = csvr.readAll();
				itr = recordList.iterator();
				if (itr.hasNext())
				{
					headerRow = (String[]) itr.next();

					Integer l = 0;
					for (String headerVal : headerRow)
					{
						System.out.println("header : " + headerVal);
						System.out.println(String.valueOf(colNum++));
					}
				}
				String[] row = null;
				while (itr.hasNext())
				{

					row = (String[]) itr.next();
					for (String headerVal : row)
					{
						System.out.println("header : " + headerVal);
						System.out.println(String.valueOf(colNum++));
					}

				}
			}
			catch (IOException e1)
			{
				e1.printStackTrace();
			}
	  }
	
	  public static void main(String[] args) throws IOException {
		  FTPClient ftpClient = FTPConnect.getFtpConnection();
		  retrieveFiles(ftpClient);
		  //processFiles("D:\\Docs\\Personal\\AIA\\Files\\HK-ACHIEVE_GOLD-20141028040046.csv");
	 
	  }

}
