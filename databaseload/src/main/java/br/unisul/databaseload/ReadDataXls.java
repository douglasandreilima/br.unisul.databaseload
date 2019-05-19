package br.unisul.databaseload;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadDataXls {

	public ReadDataXls() {
	}

	public List<DataModel> lerDadosXls(String caminhoArquivo) throws InterruptedException {

		List<DataModel> list = new ArrayList<DataModel>();

		File excelFile = new File(caminhoArquivo);

		FileInputStream fis = null;

		XSSFWorkbook workbook = null;

		try {

			fis = new FileInputStream(excelFile);

			workbook = new XSSFWorkbook(fis);

			XSSFSheet sheet = workbook.getSheetAt(0);

			Iterator<Row> rowIt = sheet.iterator();

			while (rowIt.hasNext()) {
				Row row = rowIt.next();

				if (row.getRowNum() > 0) {
					DataModel dado = new DataModel();
					dado.setCnpj((int) row.getCell(0).getNumericCellValue());
					dado.setNome(row.getCell(1).getStringCellValue());
					dado.setEndereco(row.getCell(2).getStringCellValue());
					dado.setProduto(row.getCell(7).getStringCellValue());

					list.add(dado);
				}

				// Iterator<Cell> cellIterator = row.cellIterator();
				// while (cellIterator.hasNext()) {
				// Cell cell = cellIterator.next();
				// System.out.println(row.getCell(0).getStringCellValue() + " ; ");
				// queue.put(cell.toString() + " ; ");
				//
				// }
			}

			return list;
		} catch (IOException e) {
			e.printStackTrace();

		} finally {
			try {
				fis.close();
				workbook.close();
			} catch (IOException e) {
				e.printStackTrace();
			}

		}
		return null;
	}
}
