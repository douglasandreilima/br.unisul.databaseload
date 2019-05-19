package br.unisul.databaseload;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Iterator;
import java.util.concurrent.BlockingQueue;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadDataXls extends Thread {

	private String caminhoArquivo;

	protected BlockingQueue<DataModel> queue = null;

	@Override
	public void run() {
		this.recuperarListaArquivo();
	}

	public ReadDataXls(String caminhoRaiz, BlockingQueue<DataModel> queue) {
		this.queue = queue;
		this.caminhoArquivo = caminhoRaiz;
	}

	private void recuperarListaArquivo() {
		try {

			this.lerDadosXls(caminhoArquivo);

			// queue.put(null);
		} catch (InterruptedException e) {
			System.err.println(e);
		}
	}

	private void lerDadosXls(String caminhoArquivo) throws InterruptedException {
		File excelFile = new File(caminhoArquivo);

		DataModel dado = new DataModel();

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
					dado.setCnpj((int) row.getCell(0).getNumericCellValue());
					dado.setNome(row.getCell(1).getStringCellValue());
					dado.setEndereco(row.getCell(2).getStringCellValue());
					dado.setProduto(row.getCell(7).getStringCellValue());

					queue.put(dado);

					System.out.println(dado.toString());
				}

				// Iterator<Cell> cellIterator = row.cellIterator();
				// while (cellIterator.hasNext()) {
				// Cell cell = cellIterator.next();
				// System.out.println(row.getCell(0).getStringCellValue() + " ; ");
				// queue.put(cell.toString() + " ; ");
				//
				// }
			}
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
	}
}
