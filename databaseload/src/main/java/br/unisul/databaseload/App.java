package br.unisul.databaseload;

import java.util.List;

/**
 * Hello world!
 *
 */
public class App {
	public static void main(String[] args) throws InterruptedException {

		long start = System.currentTimeMillis();
		
		ReadDataXls reader = new ReadDataXls();
		List<DataModel> list = reader.ler("test-files/aposentados-012018.xlsx");

		DatabaseWriter databaseWriter = new DatabaseWriter(list);

		databaseWriter.inserirDados();

		System.out.println("Total time: " + (System.currentTimeMillis() - start));
	}
}
