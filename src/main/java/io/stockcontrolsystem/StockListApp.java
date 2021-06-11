
package io.stockcontrolsystem;

/**
 * @author Linda Scoon This program runs the stockList System
 */
public class StockListApp {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		// Create the stock list object
		StockList stockList = new StockLinkedList();

		// setting up logging
		((StockLinkedList) stockList).setLogging();

		// Create an interface
		StockListCLI stockListCLI = new StockListCLI(stockList);

		stockList.loadStockData("stockDataFile.txt");

		// Display the menu
		stockListCLI.doMenu();

	}

}
