package io.stockcontrolsystem;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.LinkedList;
import java.util.logging.ConsoleHandler;
import java.util.logging.Level;
import java.util.logging.Logger;

import io.stockcontrolsystemExceptions.AddException;
import io.stockcontrolsystemExceptions.DeleteException;

/**
 * @author Linda Scoon Maintains and manages a list of stockItems
 *
 */
public class StockLinkedList implements StockList {

	/**
	 * 
	 */
	private LinkedList<StockItem> stockList;
	private static Logger fileLog = Logger.getLogger(StockLinkedList.class.getName());// Creating A logger
	private static ConsoleHandler screenLog = new ConsoleHandler();// Creating a console logger

	/**
	 * Class constructor
	 */
	public StockLinkedList() {
		stockList = new LinkedList<StockItem>();
	}

	/**
	 * Adds item to stock list
	 * 
	 * @param item
	 * @throws AddException
	 */
	public void addItem(StockItem item) throws AddException {
		// throwing add exception

		for (StockItem stock : stockList) {
			if (stock.getItemID().equals(item.getItemID())) {
				throw new AddException("Already exists");
			}
		}
		stockList.add(item);

	}

	/**
	 * Removes item identified by productID from stock list
	 * 
	 * @param itemID
	 * @throws DeleteException
	 */
	public void deleteItem(String itemID) throws DeleteException {
		// throwing delete exception
		boolean match = false;

		for (StockItem item : stockList) {
			if (item.getItemID().equals(itemID)) {
				stockList.remove(item); // removes elements from list
				match = true;
			}
		}
		if (!match) {
			throw new DeleteException("item does not exist");
		}

	}

	/**
	 * Updates price of existing item
	 * 
	 * @param itemID
	 * @param price
	 */
	public void updateItemPrice(String itemID, double price) {
		for (StockItem item : stockList) {
			if (item.getItemID().equals(itemID)) {
				item.setPrice(price);
			}
		}
	}

	/**
	 * Updates quantity of existing item
	 * 
	 * @param itemID
	 * @param quantity
	 */
	public void updateItemQuantity(String itemID, int quantity) {
		for (StockItem item : stockList) {
			if (item.getItemID().equals(itemID)) {
				item.setQuantity(quantity);
			}
		}
	}

	/**
	 * Updates re-order level of existing item
	 * 
	 * @param itemID
	 * @param reOrderLevel
	 */
	public void updateReOrderLevel(String itemID, int reOrderLevel) {
		for (StockItem item : stockList) {
			if (item.getItemID().equals(itemID)) {
				item.setReOrderLevel(reOrderLevel);
			}
		}

	}

	/**
	 * Returns formatted representation of the stock list
	 * 
	 * @return
	 */
	public String formatStockList() {

		String printOut = null;
		StringBuffer formatted = new StringBuffer();
		String header = String.format("%-10s %-21s %-10s %-10s %s %n", "ItemID", "Description", "Price", "Qnty",
				"Re-Order Level");
		String divider = String.format("%-10s %-21s %-10s %-10s %s %n", "******", "***********", "*****", "****",
				"**************");

		for (StockItem item : stockList) {
			formatted.append(String.format("%s%n", item.format()));
		}
		if (stockList.isEmpty()) {// checking for an empty list
			printOut = "[THERE ARE NO ITEMS IN YOUR STOCK LIST]";
		} else {
			printOut = header + divider + formatted;
		}

		return printOut;
	}

	/**
	 * Returns formatted representation of re-order list Items are on this list if
	 * quantity < reOrderLevel
	 * 
	 * @return
	 */
	public String formatReOrderList() {

		String printOut = null;
		StringBuffer formatted = new StringBuffer();
		String header = String.format("%-10s %-21s %-10s %-10s %s %n", "ItemID", "Description", "Price", "Qnty",
				"Re-Order Level");
		String divider = String.format("%-10s %-21s %-10s %-10s %s %n", "******", "***********", "*****", "****",
				"**************");

		for (StockItem item : stockList) {
			if (item.getQuantity() < item.getReOrderLevel()) {
				formatted.append(String.format("%s%n", item.format()));
			}
		}
		if (formatted.length() == 0) {// checking for an empty list
			printOut = "[THERE ARE NO ITEMS IN YOUR RE-ORDER LIST]";
		} else {
			printOut = header + divider + formatted;
		}
		return printOut;
	}

	/**
	 * Loads data from the stock file into the stock list refer to
	 * https://docs.oracle.com/javase/tutorial/essential/io/objectstreams.html
	 * 
	 * @param filename
	 */
	public void loadStockData(String filename) {
		try {

			ObjectInputStream inputData = new ObjectInputStream(new FileInputStream(filename));

			// data has been cast to linkedList
			this.stockList = (LinkedList<StockItem>) inputData.readObject();

			inputData.close();
			fileLog.info("Data Loaded from file " + filename);

		} catch (IOException | ClassNotFoundException e) {
			System.err.println("\nFile error. Could not load data. " + e);
		}
	}

	/**
	 * refer to
	 * https://docs.oracle.com/javase/tutorial/essential/io/objectstreams.html Saves
	 * data from stock list to file
	 */
	public void saveStockData() {
		try {
			ObjectOutputStream saveData = new ObjectOutputStream(new FileOutputStream("stockDataFile.txt"));
			saveData.writeObject(stockList);
			saveData.close();
			fileLog.info("Data saved to stockDataFile.txt");

		} catch (IOException e) {
			System.err.println("\nFile error. Could not save data. " + e);
		}
	}

	/**
	 * Logger
	 */
	public void setLogging() {
		fileLog.addHandler(screenLog);// adding a console handler to the fileLog

		fileLog.setLevel(Level.INFO);// setting a log level for the logger ---turn off by setting levels to OFF---
		// e.g. (Level.OFF)
		screenLog.setLevel(Level.INFO);// setting a logging level for the console handler

		fileLog.setUseParentHandlers(false);// turning off global logger

	}

}
