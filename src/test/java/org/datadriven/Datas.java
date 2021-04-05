package org.datadriven;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.poi.ss.formula.functions.Value;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.remote.server.handler.GetElementDisplayed;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class Datas {
	
	
	@DataProvider(name = "data")
	public static Object[][] getexcel() throws Exception {
		 Object[][] data = getData();
		return data;

	}


	public static Object[][] getData() throws Exception {
		File loc = new File("C:\\Users\\Rahul\\eclipse-workspace\\Lennox\\src\\test\\resources\\Lennox.xlsx");
		FileInputStream is = new FileInputStream(loc);
		Workbook w = new XSSFWorkbook(is);
		Sheet s = w.getSheet("Sheet1");
		Row r = s.getRow(1);

		int rowcount = s.getPhysicalNumberOfRows();
		int cellcount = r.getPhysicalNumberOfCells();
		Object obj[][] = new Object[rowcount - 1][cellcount];

		for (int i = 0; i < rowcount - 1; i++) {
			Row row = s.getRow(i + 1);
			for (int j = 0; j < cellcount; j++) {
				Cell cell = row.getCell(j);
				int type = cell.getCellType();
				String value = null;
				if (type == 1) {
					value = cell.getStringCellValue();
				} else if (DateUtil.isCellDateFormatted(cell)) {
					Date date = cell.getDateCellValue();
					SimpleDateFormat sf = new SimpleDateFormat("d-MMMM-yyyy");
					value = sf.format(date);
				} else {
					double db = cell.getNumericCellValue();
					long lg = (long) db;
					value = String.valueOf(lg);

				}
				obj[i][j] = value;
			}

		}
		return obj;

	}

	
}
