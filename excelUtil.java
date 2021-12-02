package com.Test.Utility;

import java.util.ArrayList;

public class excelUtil {
	static Xls_Reader reader;
	public static ArrayList<Object[]> getDataFromExcel(){
		
	ArrayList<Object[]> mydata = new ArrayList<Object[]>();
	Xls_Reader reader = new Xls_Reader(
			"/home/buildsupply/eclipse-workspace/ert/src/test/java/com/Test/Utility/1633082000981_1633073727202_11991633064294981_1417_1199_materials.xlsx");
	
	for (int rowNum = 2; rowNum <= reader.getRowCount("Sheet1"); rowNum++) {
		
				String poId = reader.getCellData("Sheet1", "poId", rowNum);
				

				System.out.println(poId);
		
//				String ok = reader.getCellData("Sheet1", "ok", rowNum);
//
//				System.out.println(ok);
				Object ob[] = {poId};
				mydata.add(ob);
				
			}
	
	
	return mydata;
	}
}
