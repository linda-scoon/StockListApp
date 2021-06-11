/**
 * 
 */
package io.stockcontrolsystem;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.Serializable;

import org.junit.jupiter.api.Test;

import io.stockcontrolsystemExceptions.AddException;
import io.stockcontrolsystemExceptions.DeleteException;

/**
 * @author lns18qlr
 *
 */
class StockLinkedListTest implements Serializable {

	private static final long serialVersionUID = 1L;

	/**
	 * Test method for
	 * {@link io.stockcontrolsystem.StockLinkedList#addItem(io.stockcontrolsystem.StockItem)}.
	 * 
	 * @throws AddException
	 */
	@Test
	void testAddItem() throws AddException {
		StockLinkedList list = new StockLinkedList();

		StockItem stock = new StockItem("009", "item1", 4.99, 4, 7);
		StockItem stock2 = new StockItem("0r80", "item2", 9.66, 90, 12);

		list.addItem(stock);
		list.addItem(stock2);
		String expected = "ItemID     Description           Price      Qnty       Re-Order Level \r\n"
				+ "******     ***********           *****      ****       ************** \r\n"
				+ "009        item1                 4.99       4          7\r\n"
				+ "0r80       item2                 9.66       90         12\r\n" + "";
		String actual = list.formatStockList();
		System.out.print("\nADDED ITEMS:\n" + list.formatStockList());
		assertEquals(expected, actual, "checking that 2 items have been added to the list");
	}

	/**
	 * Test method for
	 * {@link io.stockcontrolsystem.StockLinkedList#deleteItem(java.lang.String)}.
	 * 
	 * @throws AddException
	 * @throws DeleteException
	 */
	@Test
	void testDeleteItem() throws AddException, DeleteException {
		StockLinkedList list2 = new StockLinkedList();
		StockItem stock2 = new StockItem("0r80", "item2", 9.66, 90, 12);

		list2.addItem(stock2);
		list2.deleteItem("0r80");
		String expected = "[THERE ARE NO ITEMS IN YOUR STOCK LIST]" + "";
		String actual = list2.formatStockList();
		System.out.print("\nDELETED ITEM:\n" + list2.formatStockList());
		assertEquals(expected, actual, "the item of the given itemID must be removed");
	}

	/**
	 * Test method for
	 * {@link io.stockcontrolsystem.StockLinkedList#updateItemPrice(java.lang.String, double)}.
	 * 
	 * @throws AddException
	 */
	@Test
	void testUpdateItemPrice() throws AddException {
		StockLinkedList list3 = new StockLinkedList();
		StockItem stock = new StockItem("009", "item3", 4.99, 4, 7);

		list3.addItem(stock);
		list3.updateItemPrice("009", 2.55);

		String expected = "ItemID     Description           Price      Qnty       Re-Order Level \r\n"
				+ "******     ***********           *****      ****       ************** \r\n"
				+ "009        item3                 2.55       4          7\r\n" + "";
		String actual = list3.formatStockList();
		System.out.print("\nUPDATED PRICE:\n" + list3.formatStockList());
		assertEquals(expected, actual, "the item of the given itemID must have its price updated");
	}

	/**
	 * Test method for
	 * {@link io.stockcontrolsystem.StockLinkedList#updateItemQuantity(java.lang.String, int)}.
	 * 
	 * @throws AddException
	 */
	@Test
	void testUpdateItemQuantity() throws AddException {
		StockLinkedList list4 = new StockLinkedList();
		StockItem stock = new StockItem("009", "item4", 9.66, 90, 14);

		list4.addItem(stock);
		list4.updateItemQuantity("009", 88);

		String expected = "ItemID     Description           Price      Qnty       Re-Order Level \r\n"
				+ "******     ***********           *****      ****       ************** \r\n"
				+ "009        item4                 9.66       88         14\r\n" + "";
		String actual = list4.formatStockList();
		System.out.print("\nUPDATED QUANTITY:\n" + list4.formatStockList());
		assertEquals(expected, actual, "the item of the given itemID must have its quantity updated");
	}

	/**
	 * Test method for
	 * {@link io.stockcontrolsystem.StockLinkedList#updateReOrderLevel(java.lang.String, int)}.
	 * 
	 * @throws AddException
	 */
	@Test
	void testUpdateReOrderLevel() throws AddException {
		StockLinkedList list5 = new StockLinkedList();
		StockItem stock = new StockItem("009", "item5", 4.99, 40, 7);

		list5.addItem(stock);
		list5.updateReOrderLevel("009", 14);

		String expected = "ItemID     Description           Price      Qnty       Re-Order Level \r\n"
				+ "******     ***********           *****      ****       ************** \r\n"
				+ "009        item5                 4.99       40         14\r\n" + "";
		String actual = list5.formatStockList();
		System.out.println("\nUPDATED REORDER LEVEL:\n" + list5.formatStockList());
		assertEquals(expected, actual, "should only display the items with quantity less than reorder level");
	}

	/**
	 * Test method for
	 * {@link io.stockcontrolsystem.StockLinkedList#formatReOrderList()}.
	 * 
	 * @throws AddException
	 */
	@Test
	void testFormatReOrderList() throws AddException {

		StockLinkedList list6 = new StockLinkedList();
		StockItem stock = new StockItem("009", "item1", 4.99, 5, 7);
		StockItem stock2 = new StockItem("0r80", "item2", 9.66, 90, 12);

		list6.addItem(stock);
		list6.addItem(stock2);

		String expected = "ItemID     Description           Price      Qnty       Re-Order Level \r\n"
				+ "******     ***********           *****      ****       ************** \r\n"
				+ "009        item1                 4.99       5          7\r\n" + "";
		String actual = list6.formatReOrderList();
		System.out.print("\nFORMATTED REORDER LEVEL:\n" + list6.formatReOrderList());
		assertEquals(expected, actual, "should only display the items with quantity less than reorder level");
	}

	@Test // testing save and load methods
	public void testSaveStockDatat() throws AddException {
		StockLinkedList list7 = new StockLinkedList();
		StockItem stock = new StockItem("0r70", "item2", 9.66, 90, 12);

		list7.loadStockData("stockDataFile.txt");
//		list7.addItem(stock);
		list7.saveStockData();

		String expected = "ItemID     Description           Price      Qnty       Re-Order Level \r\n"
				+ "******     ***********           *****      ****       ************** \r\n"
				+ "0r80       item2                 9.66       90         12\r\n" + "";

		System.out.println("\nLOADED DATA FROM FILE\n" + list7.formatStockList());
		assertEquals(expected, list7.formatStockList(),
				"should display the item that has been loaded from file. May fail if file already has data ");

	}

}
