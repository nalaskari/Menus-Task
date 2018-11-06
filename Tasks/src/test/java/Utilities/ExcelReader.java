package Utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.ss.usermodel.DataFormat;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelReader {

	public String[][] ReadExcel(String path, String sheetname) throws IOException {

		File file = new File(path);
		DataFormatter df=new DataFormatter();

		FileInputStream fis = new FileInputStream(file);
		XSSFWorkbook workbook = new XSSFWorkbook(fis);
		XSSFSheet sheet = workbook.getSheet(sheetname);
		
		int row=sheet.getPhysicalNumberOfRows()-1;
		int col=sheet.getRow(0).getPhysicalNumberOfCells();
		
		String data[][]=new String [row][col];
		
		for(int i=1;i<=sheet.getLastRowNum();i++)
		{
			XSSFRow rw=sheet.getRow(i);
			for (int j=0;j<col;j++)
			{
				XSSFCell cell=rw.getCell(j);
				String value=df.formatCellValue(cell);
				data[i-1][j]=value;
			}
		}

		return data;
	}

}
