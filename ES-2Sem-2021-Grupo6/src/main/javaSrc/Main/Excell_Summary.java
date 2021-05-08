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
			num_packages= countPackages(firstSheet, np);
	        np = firstSheet.getRow(1).getCell(2).getStringCellValue();
	        num_classes = count_classes(firstSheet, np);
	        workbook.close();
	        is.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/** Counts the number of classes, methods and lines 
	 * 
	 * @param firstSheet Sheet of excel
	 * @param np name of the first class
	 * @return	number of classes
	 */
	private int count_classes(XSSFSheet firstSheet, String np) {
		int count_classes = 1;
		int count_methods = (int) firstSheet.getRow(1).getCell(4).getNumericCellValue();
		int count_lines = (int) firstSheet.getRow(1).getCell(5).getNumericCellValue();
		int it = 1;
		int last = firstSheet.getLastRowNum();
		while (it != last) {
			XSSFRow nextRow = firstSheet.getRow(it);
			if (firstSheet.getRow(it).getCell(2) != null) {
				String cell = nextRow.getCell(2).getStringCellValue();
				if (!np.equals(cell)) {
					np = cell;
					if(nextRow.getCell(5) != null && nextRow.getCell(4)!=null) {
            			count_methods += nextRow.getCell(4).getNumericCellValue();
            			count_lines += nextRow.getCell(5).getNumericCellValue();
            		}              
					count_classes++;
				}
			}
			it++;
		}
        num_lines=(int) count_lines;
        num_methods = (int) count_methods;
		return count_classes;
	}
	
	/** Counts the number of packages
	 * 
	 * @param firstSheet Sheet of excel
	 * @param np name of the first package
	 * @return	number of packages
	 */
	private int countPackages(XSSFSheet firstSheet, String np) {
		int count = 1;
        int it = 1;
        int last = firstSheet.getLastRowNum();
		while (it != last && !firstSheet.getRow(it).getCell(1).equals("")) {
			XSSFRow nextRow = firstSheet.getRow(it);
			String cell = nextRow.getCell(1).getStringCellValue();
			if (!np.equals(cell)) {
				np = cell;
				count++;
			}
			it++;
		}
		return count;
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
