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
	private static Workbook workbook;
	private static String[] titles = {"MethodID", "Package", "Class", "Method", "NOM_Class", "LOC_Class", "WMC_Class", "is_God_Class", "LOC_Method", "CYCLO_Method", "is_Long_Method"};
	private static int[] sizes = {3000, 3000, 6000, 8000, 3000,3000,3000, 3000, 3000, 3000, 3000};
	
	
    public App ( String file ) throws IOException
    {
    	
    	
    	File currDir = new File(".");
    	String path = currDir.getAbsolutePath();
    	String fileLocation = path.substring(0, path.length() - 1) + "temp.xlsx";

    	FileOutputStream outputStream;
    	Workbook workbook = new XSSFWorkbook();
    	try {
    	
    	Sheet sheet = workbook.createSheet("Results");
    	
    	CellStyle headerStyle = workbook.createCellStyle();
    	XSSFFont font = ((XSSFWorkbook) workbook).createFont();
    	font.setFontName("Arial");
    	font.setFontHeightInPoints((short) 11);
    	font.setBold(true);
    	headerStyle.setFont(font);
    	
    	Row header = sheet.createRow(0);
    	Cell headerCell;
    	for (int i = 0; i < sizes.length; i++) {
    		sheet.setColumnWidth(i, sizes[i]);
    		headerCell = header.createCell(i);
    		headerCell.setCellValue(titles[i]);
    		headerCell.setCellStyle(headerStyle);
    	}
    	
    	
    	CellStyle style = workbook.createCellStyle();
    	style.setWrapText(true);
    	
    	
		outputStream = new FileOutputStream(fileLocation);
		workbook.write(outputStream);
		workbook.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
    }
  
    /*
    public static void main (String[] args) throws IOException {
    	App app = new App();
    }
    */
    
}
