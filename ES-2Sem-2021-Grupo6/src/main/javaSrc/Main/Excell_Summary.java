package Main;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Excell_Summary {

	
	private int num_packages;
	private int num_classes;
	private int num_methods;
	private int num_lines;
	
	public Excell_Summary(String f) throws IOException {
		File file = new File(f);
		getMetrics(file);
	}
	
	
	
	private void getMetrics(File file) throws IOException {
		try {
			FileInputStream is = new FileInputStream(file);
			
			XSSFWorkbook workbook = new XSSFWorkbook(is);
			XSSFSheet firstSheet = (XSSFSheet) workbook.getSheetAt(0);
	        String np = firstSheet.getRow(1).getCell(1).getStringCellValue();
	        int count = 0;
	        int it = 1;
	        int last = firstSheet.getLastRowNum();
	        while (it != last) {
	            XSSFRow nextRow = firstSheet.getRow(it);
	            if( nextRow.getCell(1) != null) {
		            String cell = nextRow.getCell(1).getStringCellValue();
		            if (!np.equals(cell)) {
		            	np = cell;
		            	count ++;
		            }                
	            }
	            it++;
	        }
	        System.out.println(count);
	        double count_lines = 0;
	        int count_classes = 0;
	        it = 1;
	        np = firstSheet.getRow(1).getCell(2).getStringCellValue();
	        while (it != last) {
	            XSSFRow nextRow = firstSheet.getRow(it);
	            if( nextRow.getCell(2) != null) {
		            String cell = nextRow.getCell(2).getStringCellValue();
		            if (!np.equals(cell)) {
		            	np = cell;
		            	count_classes ++;
		            	if(nextRow.getCell(5) != null)
		            		count_lines += nextRow.getCell(5).getNumericCellValue();
		            }                
	            }
	            it++;
	        }
	        System.out.println(count_classes);
	        System.out.println(count_lines);
	        
	        count = 0;
	        it = 1;
	        np = firstSheet.getRow(1).getCell(2).getStringCellValue();
	        while (it != last) {
	            XSSFRow nextRow = firstSheet.getRow(it);
	            if( nextRow.getCell(2) != null) {
		            String cell = nextRow.getCell(2).getStringCellValue();
		            if (!np.equals(cell)) {
		            	np = cell;
		            	count ++;
		            }                
	            }
	            it++;
	        }
	        System.out.println(count); 
	        
	        workbook.close();
	        is.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	 
	
	public static void main(String[] args) {
		try {
			Excell_Summary e = new Excell_Summary("C:\\Users\\35196\\git\\ES-2Sem-2021-Grupo6\\ES-2Sem-2021-Grupo6\\temp.xlsx");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	
}
