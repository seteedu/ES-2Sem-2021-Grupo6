package Main;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFFont;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import Metrics.Result;


/**Creates the excel file with template in the same folder as the user selected 
 * It will be used to show the metrics extracted
 */
public class App {
	private Workbook workbook;
	//first row titles
	private String[] titles = {"MethodID", "Package", "Class", "Method", "NOM_Class", "LOC_Class", "WMC_Class", "is_God_Class", "LOC_Method", "CYCLO_Method", "is_Long_Method"};
	//columns sizes 
	private int[] sizes = {3000, 3000, 6000, 8000, 3000,3000,3000, 3000, 3000, 3000, 3000};
	FileOutputStream outputStream;
	String fileLocation1;
	String fileLocation2;
	Sheet sheet;
	
	/**Constructor of the excel file
	 * 
	 * @param file	name of the folder selected by the user
	 * @param results	ArrayList with results gotten by the program to write in the file
	 * @throws IOException	Exception if it write on the new excel file
	 */
    public App ( String file, ArrayList<Result> results) throws IOException
    {	
     	File currDir = new File(file);
    	String path = currDir.getAbsolutePath();
    	fileLocation1 = path.substring(0, path.length() - 1) + currDir.getName() + ".xlsx";
    
    	workbook = new XSSFWorkbook();
    	try {
    	
    	sheet = workbook.createSheet("Results");
    	
    	
    	//creating style format for first row
    	CellStyle headerStyle = workbook.createCellStyle();
    	XSSFFont font = ((XSSFWorkbook) workbook).createFont();
    	font.setFontName("Arial");
    	font.setFontHeightInPoints((short) 11);
    	font.setBold(true);
    	headerStyle.setFont(font);
    	
    	//creating first row with terms {MethodID, Package, Class, Method, NOM_Class, LOC_class, WMC_Class, is_God_Class, LOC_Method, CYCLO_Method, is_Long_Method
    	Row header = sheet.createRow(0);
    	Cell headerCell;
    	for (int i = 0; i < sizes.length; i++) {
    		sheet.setColumnWidth(i, sizes[i]);
    		headerCell = header.createCell(i);
    		headerCell.setCellValue(titles[i]);
    		headerCell.setCellStyle(headerStyle);
    	}
    	
    	//writing results in sheet
    	Row row;
    	for (int i = 0; i < results.size(); i++ ) {
    		row = sheet.createRow(i + 1);
    		writeResult(results.get(i), row);
    	}
		outputStream = new FileOutputStream(fileLocation1);
		workbook.write(outputStream);
		workbook.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
	
    /**Method to write each result 
     * 
     * @param res	Result gotten from the program 
     * @param line	Row to write the result
     */
	public void writeResult(Result res, Row line) {
		Cell coluna = line.createCell(0);
		coluna.setCellValue(line.getRowNum());
		coluna = line.createCell(1);
		coluna.setCellValue(res.getPackage1());
		coluna = line.createCell(2);
		coluna.setCellValue(res.getClass1());
		coluna = line.createCell(3);
		coluna.setCellValue(res.getMethod1());
		coluna = line.createCell(4);
		coluna.setCellValue(res.getNom());
		coluna = line.createCell(5);
		coluna.setCellValue(res.getLoc());
		coluna = line.createCell(6);
		coluna.setCellValue(res.getWmc());
		coluna = line.createCell(8);
		coluna.setCellValue(res.getLocm());
		coluna = line.createCell(9);
		coluna.setCellValue(res.getCyclom());
	}
}
