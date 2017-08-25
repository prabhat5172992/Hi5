package com.prabhat;
import java.io.*;
import jxl.*;
import java.util.*;

public class ExcelConversion {
	
	public static void main(String[] args) 
	  {
	    try
	    {
	      String filename = "C:\\Users\\Prabhat\\Desktop\\book12.xls";
	      WorkbookSettings ws = new WorkbookSettings();
	      ws.setLocale(new Locale("en", "EN"));
	      Workbook w = Workbook.getWorkbook(new File(filename),ws);

	      File f = new File("C:\\Users\\Prabhat\\Desktop\\new.csv");
	      OutputStream os = (OutputStream)new FileOutputStream(f);
	      String encoding = "UTF8";
	      OutputStreamWriter osw = new OutputStreamWriter(os, encoding);
	      BufferedWriter bw = new BufferedWriter(osw);


	      for (int sheet = 0; sheet < w.getNumberOfSheets(); sheet++)
	      {
	        Sheet s = w.getSheet(sheet);

	        bw.write(s.getName());
	        bw.newLine();

	        Cell[] row = null;

	        for (int i = 0 ; i < s.getRows() ; i++)
	        {
	          row = s.getRow(i);

	          if (row.length > 0)
	          {
	            bw.write(row[0].getContents());
	            for (int j = 1; j < row.length; j++)
	            {
	              bw.write(',');
	              bw.write(row[j].getContents());
	            }
	          }
	          bw.newLine();
	        }
	      }
	      bw.flush();
	      bw.close();
	      System.out.println("Success");
	    }
	    catch (Exception e)
	    {
	      System.err.println(e);
	    }

	  }

}
