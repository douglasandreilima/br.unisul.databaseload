package main;

import java.util.List;

import br.unisul.databaseload.DataModel;
import br.unisul.databaseload.DatabaseWriter;
import br.unisul.databaseload.ReadDataXls;

/**
 * Hello world!
 *
 */
public class App {
	public static void main(String[] args) throws InterruptedException {
		
		System.out.println("Iniciando -" +System.currentTimeMillis());
		Long inicio = System.currentTimeMillis();
		
		ReadDataXls reader = new ReadDataXls();
		List<DataModel> list = reader.ler("test-files/");
		DatabaseWriter databaseWriter = new DatabaseWriter();
		databaseWriter.inserirDados(list);
		
		System.out.println("the end total time = "+(System.currentTimeMillis() - inicio));
	}
}
