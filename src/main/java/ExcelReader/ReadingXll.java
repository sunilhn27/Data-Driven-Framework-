package ExcelReader;

import java.util.Hashtable;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class ReadingXll {

	

	public static Object[][] getdata(String Testcase, ExcelReader excel) {

		String sheetName = "Sheet1";
		String testCase = Testcase;

		int testCaseRowNum = 1;

		while (!excel.getCellData(sheetName, 0, testCaseRowNum).equalsIgnoreCase(testCase)) {
			testCaseRowNum++;
		}
		System.out.println("Test case starts from : " + testCaseRowNum);
		int colsStartRowNum = testCaseRowNum + 1;
		int dataStartRowNum = colsStartRowNum + 1;
		int cols = 0;
		while (!excel.getCellData(sheetName, cols, colsStartRowNum).trim().equals("")) {
			cols++;
		}
		System.out.println("Total cols in a test are : " + cols);
		int rows = 0;
		while (!excel.getCellData(sheetName, 0, dataStartRowNum + rows).trim().equals("")) {
			rows++;
		}
		System.out.println("Total rows are : " + rows);

		Object[][] data = new Object[rows][1];
		int i = 0;
		for (int row = dataStartRowNum; row < dataStartRowNum + rows; row++) {
			Hashtable<String, String> table = new Hashtable<String, String>();
			for (int col = 0; col < cols; col++) {

				// System.out.println(excel.getCellData(sheetName, col, row));
				String Testdata = excel.getCellData(sheetName, col, row);
				String colName = excel.getCellData(sheetName, col, colsStartRowNum);
				table.put(colName, Testdata);

			}

			data[i][0] = table;
			i++;
		}

		return data;
	}
}
