package br.unisul.databaseload;

import java.util.List;

/**
 * Hello world!
 *
 */
public class App {
	public static void main(String[] args) throws InterruptedException {

		long start = System.currentTimeMillis();

		List<DataModel> list = new ReadDataXls().lerDadosXls("test-files/infopreco1.xlsx");

		DatabaseWriter databaseWriter = new DatabaseWriter(list);

		databaseWriter.insertInfo();

		System.out.println("Total time: " + (System.currentTimeMillis() - start));
	}
}
