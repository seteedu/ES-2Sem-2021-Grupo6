package Main;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/**
 * 
 * Used in "MetricMenu" window to give the metrics summary
 *
 */
public class Excell_Summary {

	
	private int num_packages;
	private int num_classes;
	private int num_methods;
	private int num_lines;
		
	/**Gets a summary of the metrics written in the excel file
	 * 
	 * @param file	excel file to be read
	 * @throws IOException	throws an exception if it can't read the excel file
	 */
	public void getMetrics(File file) throws IOException {
		try {
			FileInputStream is = new FileInputStream(file);
			
			XSSFWorkbook workbook = new XSSFWorkbook(is);
			XSSFSheet firstSheet = (XSSFSheet) workbook.getSheetAt(0);
	        String np = firstSheet.getRow(1).getCell(1).getStringCellValue();
	        int count = 1;
	        int it = 1;
	        int last = firstSheet.getLastRowNum();
	        while (it != last && firstSheet.getRow(it).getCell(10)!=null && firstSheet.getRow(it).getCell(7)!=null) {
	            XSSFRow nextRow = firstSheet.getRow(it);
	            System.out.println("LIHNA -> " + nextRow.getCell(1));
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
	        num_packages=count;
	        
	        double count_methods = firstSheet.getRow(1).getCell(4).getNumericCellValue();
	        double count_lines = firstSheet.getRow(1).getCell(5).getNumericCellValue();
	        int count_classes = 1;
	        it = 1;
	        np = firstSheet.getRow(1).getCell(2).getStringCellValue();
	        while (it != last && firstSheet.getRow(it).getCell(10)!=null && firstSheet.getRow(it).getCell(7)!=null) {
	            XSSFRow nextRow = firstSheet.getRow(it);
	            if( nextRow.getCell(2) != null) {
		            String cell = nextRow.getCell(2).getStringCellValue();
		            if (!np.equals(cell)) {
		            	np = cell;
		            	count_classes ++;
		            	if(nextRow.getCell(5) != null && nextRow.getCell(4)!=null) {
		            		count_methods += nextRow.getCell(4).getNumericCellValue();
		            		count_lines += nextRow.getCell(5).getNumericCellValue();
		            	}
		            		
		            }                
	            }
	            it++;
	        }
	        System.out.println(count_classes);
	        num_classes=count_classes;
	        System.out.println(count_lines);
	        num_lines=(int) count_lines;
	        num_methods = (int) count_methods;
	        System.out.println(num_methods);
	        
	        workbook.close();
	        is.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/**Get the number of packages written in the excel file
	 * 
	 * @return a number of packages
	 */
	public int getNumPackages() {
		return num_packages;
	}
	
	/**Get the number of classes written in the excel file
	 * 
	 * @return a number of classes
	 */
	public int getNumClasses() {
		return num_classes;
	}

	/**Get the number of methods written in the excel file
	 * 
	 * @return a number of methods
	 */
	public int getNumMethods() {
		return num_methods;
	}

	/**Get the number of lines in the project
	 * 
	 * @return a number of lines
	 */
	public int getNumLines() {
		return num_lines;
	}
}
