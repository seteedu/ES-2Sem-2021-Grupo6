package Main;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import CodeSmell.Logic_Expressions;
import CodeSmell.Rule;
import CodeSmell.Threshold;

public class CodeSmell_Detector {
	
	private static final HashMap<String, Integer> m = new HashMap<>();
	
	static {
		m.put("NOM_Class", 4);
		m.put("LOC_Class", 5);
		m.put("WMC_Class", 6);	
		m.put("is_God_Class", 7);
		m.put("LOC_Method", 8);
		m.put("CYCLO_Method",9);
		m.put("is_Long_Method", 10);
	}
	
	public void detect(String file, Rule rule) throws IOException {
		File f = new File(file);
		try {
			FileInputStream is = new FileInputStream(file);
			
			XSSFWorkbook workbook = new XSSFWorkbook(is);
			XSSFSheet firstSheet = (XSSFSheet) workbook.getSheetAt(0);
			int it = 1;
	        int last = firstSheet.getLastRowNum();
			while( it <= last) {
				System.out.println(it);
				XSSFRow nextRow = firstSheet.getRow(it);
				boolean b = expression(rule, nextRow);
				if (rule.getCodeSmell().equals("is_God_Class")) {
					nextRow.createCell(7);
					nextRow.getCell(7).setCellValue(b);
				}
				else {
					nextRow.createCell(10);
					nextRow.getCell(10).setCellValue(b);
				}
				it++;
			}
			FileOutputStream os = new FileOutputStream(file);
			workbook.write(os);
			workbook.close();
			is.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	
	public boolean expression (Rule rule, XSSFRow row) {
		boolean b = true;
		Logic_Expressions le = new Logic_Expressions();
		ArrayList<Threshold> t = rule.getThresholds();
		for( int i = 0 ; i < rule.getThresholds().size(); i++) {
			System.out.println("REGRA: " + rule.toString());
			int val = (int)row.getCell(m.get(t.get(i).getName())).getNumericCellValue();
				if( i != rule.getThresholds().size()-1) {
				if ( t.get(i).getLogic().equals("E"))
					b = le.twoAnd(b, t.get(i), val);
				else
					b = le.twoOr(b, t.get(i), val);
			} 
			else {
				b = le.twoAnd(b, t.get(i), val);
			}
		}
		return b;
		
	}

	
	public static void main(String[] args) {
		Threshold t1 = new Threshold("LOC_Class",  ">",2, "E");
		Threshold t2 = new Threshold("NOM_Class", "<", 2);
		Rule a1 = new Rule ("um","is_God_Class");
		a1.add_threshold(t1);
		a1.add_threshold(t2);
		CodeSmell_Detector n = new CodeSmell_Detector();
		try {
			n.detect("C:\\Users\\35196\\OneDrive - ISCTE-IUL\\univ\\3 ano\\2ºsemestre\\Engenharia de Software\\Code_Smells.xlsx", a1 );
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	
	
	
	
	
}
