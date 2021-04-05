package Main;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.FillPatternType;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.xssf.usermodel.XSSFFont;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import Metrics.Result;



public class App 
{
	private static Workbook workbook;
	private static String[] titles = {"MethodID", "Package", "Class", "Method", "NOM_Class", "LOC_Class", "WMC_Class", "is_God_Class", "LOC_Method", "CYCLO_Method", "is_Long_Method"};
	private static int[] sizes = {3000, 3000, 6000, 8000, 3000,3000,3000, 3000, 3000, 3000, 3000};
	private static int rowCount = 0;
	FileOutputStream outputStream;
	String fileLocation;
	Sheet sheet;
	
    public App ( String file ) throws IOException
    {
    	
    	
    	
    	File currDir = new File(".");
    	String path = currDir.getAbsolutePath();
    	fileLocation = path.substring(0, path.length() - 1) + "temp.xlsx";

    	
    	workbook = new XSSFWorkbook();
    	try {
    	
    	sheet = workbook.createSheet("Results");
    	
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
    
    public void ExcelHandler(ArrayList<Result> result) throws IOException, EncryptedDocumentException, InvalidFormatException {
    	FileInputStream file = new FileInputStream(fileLocation);
        Workbook wb = new XSSFWorkbook();
        Sheet sheet = wb.getSheet("Results");
		
//		for(Result res : result) {
//			Row line = sheet.createRow(++rowCount);
//			writeResult(res, line);
//		}
//		 outputStream = new FileOutputStream(fileLocation);
//		 workbook.write(outputStream);
        
        CellStyle headerStyle = wb.createCellStyle();
    	XSSFFont font = ((XSSFWorkbook) wb).createFont();
    	font.setFontName("Arial");
    	font.setFontHeightInPoints((short) 11);
    	font.setBold(true);
    	headerStyle.setFont(font);
    	
    	Row header = sheet.createRow(1);
    	Cell headerCell;
    	for (int i = 0; i < sizes.length; i++) {
    		sheet.setColumnWidth(i, sizes[i]);
    		headerCell = header.createCell(i);
    		headerCell.setCellValue(titles[i]);
    		headerCell.setCellStyle(headerStyle);
    	}
    	
    	CellStyle style = wb.createCellStyle();
    	style.setWrapText(true);
        
		 outputStream = new FileOutputStream(fileLocation);
		 outputStream.flush();
		 System.out.println("Output string: " +outputStream);
         wb.write(outputStream);
         wb.close();
         outputStream.close();
	}
	
	public void writeResult(Result res, Row line) {
		Cell coluna = line.createCell(1);
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
		coluna = line.createCell(7);
		coluna.setCellValue(res.getLocm());
		coluna = line.createCell(8);
		coluna.setCellValue(res.getCyclom());
	}
  
  
    
}
