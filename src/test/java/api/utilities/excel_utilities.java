package api.utilities;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class excel_utilities {
	
	
	// get(read) all data from xl....
	
	public static String[][] get_all_data(String filepath, String sheetname) throws IOException
	{
		
		FileInputStream file = new FileInputStream(filepath);
		
		XSSFWorkbook workbook= new  XSSFWorkbook(file);
		
		XSSFSheet sheet= workbook.getSheet(sheetname);
		
		int total_rows= sheet.getPhysicalNumberOfRows();
		
		int total_columns = sheet.getRow(0).getLastCellNum();
		
		String[][] data = new String[total_rows-1][total_columns];
		
		DataFormatter df= new DataFormatter();
		
		for(int i=1;i<total_rows;i++)
		{
			XSSFRow row= sheet.getRow(i);
			
			for(int j=0;j<total_columns;j++)
			{
				XSSFCell cell= row.getCell(j);
				
				data[i-1][j]= df.formatCellValue(cell);
			}
			
		}
		
		workbook.close();
		
		file.close();
		
		return data;
	}
	
	
	// read only usernames from excel....
	public static String[] get_all_usernames(String filepath, String sheetname) throws IOException
	
	{
FileInputStream file = new FileInputStream(filepath);
		
		XSSFWorkbook workbook= new  XSSFWorkbook(file);
		
		XSSFSheet sheet= workbook.getSheet(sheetname);
		
		
		int total_rows= sheet.getPhysicalNumberOfRows();
		
		String[] user_names= new String[total_rows-1];
		DataFormatter df= new DataFormatter();
		
		for(int i=1;i<total_rows;i++)
		{
			 String row= sheet.getRow(i).getCell(1).toString();
			user_names[i-1]=row;
			
		}
		
		return user_names;
		
	}

}
