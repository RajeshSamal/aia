package com.aia.data;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.net.SocketException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Iterator;
import java.util.List;

import jxl.Cell;
import jxl.CellType;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;

import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTPFile;

import com.aia.common.CSVReader;

public class DataInputProcessor {
	
	/*public void processRecord()
	{
		InputStream fis = DataInputProcessor.class.getResourceAsStream("/resources/benupload/MT103_BeneUpload.txt");
		byte[] newValue = null;
		try
		{
			newValue = IOUtils.toByteArray(fis);
		}
		catch (IOException e1)
		{
			e1.printStackTrace();
		}
		String filecontent = null;
		try
		{
			filecontent = new String(newValue, "UTF-8");
		}
		catch (UnsupportedEncodingException e2)
		{
			//LOG.info("Exception while reading the file", e2);
		}
		CSVReader csvr = null;
		csvr = new CSVReader(new StringReader(filecontent));
		List fileRecordList = null;
		try {
			fileRecordList = csvr.readAll();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Workbook wie=null;
	}*/
	
	private String inputFile;

	  public void setInputFile(String inputFile) {
	    this.inputFile = inputFile;
	  }

	  public void read() throws IOException  {
	    File inputWorkbook = new File(inputFile);
	    System.out.println(inputWorkbook.getCanonicalPath());
	    Workbook w;
	    try {
	      w = Workbook.getWorkbook(inputWorkbook);
	      // Get the first sheet
	      Sheet sheet = w.getSheet(0);
	      // Loop over first 10 column and lines

	      for (int j = 0; j < sheet.getColumns(); j++) {
	        for (int i = 0; i < sheet.getRows(); i++) {
	          Cell cell = sheet.getCell(j, i);
	          CellType type = cell.getType();
	          if (type == CellType.LABEL) {
	            System.out.println("I got a label "
	                + cell.getContents());
	          }

	          if (type == CellType.NUMBER) {
	            System.out.println("I got a number "
	                + cell.getContents());
	          }

	        }
	      }
	    } catch (BiffException e) {
	      e.printStackTrace();
	    }
	  }
	  
	  public static void getFtpConnection()
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
		    // logout the user, returned true if logout successfully 
		    FTPFile[] files = ftpClient.listFiles();
		 // iterates over the files and prints details for each
		    DateFormat dateFormater = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		     
		    for (FTPFile file : files) {
		        String details = file.getName();
		        if (file.isDirectory()) {
		            details = "[" + details + "]";
		        }
		        details += "\t\t" + file.getSize();
		        details += "\t\t" + dateFormater.format(file.getTimestamp().getTime());
		        System.out.println(details);
		    }
		    boolean logout = ftpClient.logout();  
		    if (logout) {  
		     System.out.println("Connection close...");  
		    }  
		   } else {  
		    System.out.println("Connection fail...");  
		   }  
		  
		  } catch (SocketException e) {  
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

	  public static void main(String[] args) throws IOException {
		/*DataInputProcessor test = new DataInputProcessor();
	    test.setInputFile("D:\\Docs\\Personal\\AIA\\Files\\HK-ACHIEVE_GOLD-20141028040046.csv");
	    test.read();*/
		  getFtpConnection();
	    File inputCsvbook = new File("D:\\Docs\\Personal\\AIA\\Files\\HK-ACHIEVE_GOLD-20141028040046.csv");
	    FileReader fr = new FileReader(inputCsvbook);
	    //byte byteArr[] = fis.
	    CSVReader csvr = new CSVReader(fr);
	    List recordList = null;
	    Iterator itr = null;
	    String[] headerRow = null;
		String[] mandatoryHeaderRow = null;
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
				}
			}
		}
		catch (IOException e1)
		{
			e1.printStackTrace();
		}
	  }

}
