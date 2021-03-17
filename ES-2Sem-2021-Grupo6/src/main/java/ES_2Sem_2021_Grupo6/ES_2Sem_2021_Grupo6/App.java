package ES_2Sem_2021_Grupo6.ES_2Sem_2021_Grupo6;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.FillPatternType;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFFont;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) throws IOException
    {
    	Workbook workbook = new XSSFWorkbook();

    	Sheet sheet = workbook.createSheet("Persons");
    	sheet.setColumnWidth(0, 6000);
    	sheet.setColumnWidth(1, 4000);

    	Row header = sheet.createRow(0);

    	CellStyle headerStyle = workbook.createCellStyle();
    	headerStyle.setFillForegroundColor(IndexedColors.LIGHT_BLUE.getIndex());
    	headerStyle.setFillPattern(FillPatternType.SOLID_FOREGROUND);

    	XSSFFont font = ((XSSFWorkbook) workbook).createFont();
    	font.setFontName("Arial");
    	font.setFontHeightInPoints((short) 16);
    	font.setBold(true);
    	headerStyle.setFont(font);

    	Cell headerCell = header.createCell(0);
    	headerCell.setCellValue("Name");
    	headerCell.setCellStyle(headerStyle);

    	headerCell = header.createCell(1);
    	headerCell.setCellValue("Age");
    	headerCell.setCellStyle(headerStyle);
    	
    	CellStyle style = workbook.createCellStyle();
    	style.setWrapText(true);

    	Row row = sheet.createRow(2);
    	Cell cell = row.createCell(0);
    	cell.setCellValue("John Smith");
    	cell.setCellStyle(style);

    	cell = row.createCell(1);
    	cell.setCellValue(20);
    	cell.setCellStyle(style);
    	
    	File currDir = new File(".");
    	String path = currDir.getAbsolutePath();
    	String fileLocation = path.substring(0, path.length() - 1) + "temp.xlsx";

    	FileOutputStream outputStream;
		try {
			outputStream = new FileOutputStream(fileLocation);
			workbook.write(outputStream);
			workbook.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
}
