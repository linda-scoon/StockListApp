/**
 * 
 */
package io.stockcontrolsystem;

import io.stockcontrolsystemExceptions.AddException;
import io.stockcontrolsystemExceptions.DeleteException;

/**
 * @author lns18qlr
 *
 */
public interface StockList {

	/**
	 * Adds item to stock list
	 * 
	 * @param item
	 * @throws AddException
	 */
	public void addItem(StockItem item) throws AddException;

	/**
	 * Removes item identified by productID from stock list
	 * 
	 * @param itemID
	 * @throws DeleteException
	 */
	public void deleteItem(String itemID) throws DeleteException;

	/**
	 * Updates price of existing item
	 * 
	 * @param itemID
	 * @param price
	 */
	public void updateItemPrice(String itemID, double price);

	/**
	 * Updates quantity of existing item
	 * 
	 * @param itemID
	 * @param quantity
	 */
	public void updateItemQuantity(String itemID, int quantity);

	/**
	 * Updates re-order level of existing item
	 * 
	 * @param itemID
	 * @param reOrderLevel
	 */
	public void updateReOrderLevel(String itemID, int reOrderLevel);

	/**
	 * Returns formatted representation of the stock list
	 * 
	 * @return
	 */
	public String formatStockList();

	/**
	 * Returns formatted representation of re-order list Items are on this list if
	 * quantity < reOrderLevel
	 * 
	 * @return
	 */
	public String formatReOrderList();

	/**
	 * Loads data from the stock file into the stock list
	 * 
	 * @param filename
	 */
	public void loadStockData(String filename);

	/**
	 * Saves data from stock list to file
	 */
	public void saveStockData();

}
