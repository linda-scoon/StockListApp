
/**
 * 
 */
package io.stockcontrolsystem;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

/**
 * @author lns18qlr
 *
 */
class StockItemTest {

	/**
	 * Test method for constructor}.
	 */
	@Test
	void testStockItem() {
		StockItem stock = new StockItem();
		String expected = null;
		String actual = stock.getItemID();
		assertEquals(expected, actual, "This method is supposed to return the default item ID.");
	}

	/**
	 * Test method for
	 * {@link io.stockcontrolsystem.StockItem#setItemID(java.lang.String)}.
	 */
	@Test
	void testSetItemID() {
		StockItem stock2 = new StockItem();
		stock2.setItemID("009");

		String expected = "009";
		String actual = stock2.getItemID();
		assertEquals(expected, actual, "This method is supposed to set the item ID");
	}

	/**
	 * Test method for
	 * {@link io.stockcontrolsystem.StockItem#setItemDesc(java.lang.String)}.
	 */
	@Test
	void testSetItemDesc() {
		StockItem stock3 = new StockItem();
		stock3.setItemDesc("item1");

		String expected = "item1";
		String actual = stock3.getItemDesc();
		assertEquals(expected, actual, "This method is supposed to set the item description");
	}

	/**
	 * Test method for {@link io.stockcontrolsystem.StockItem#setPrice(double)}.
	 */
	@Test
	void testSetPrice() {
		StockItem stock4 = new StockItem();
		stock4.setPrice(4.99);

		double expected = 4.99;
		double actual = stock4.getPrice();
		assertEquals(expected, actual, "This method is supposed to set the price");
	}

	/**
	 * Test method for {@link io.stockcontrolsystem.StockItem#setQuantity(int)}.
	 */
	@Test
	void testSetQuantity() {
		StockItem stock5 = new StockItem();
		stock5.setQuantity(4);

		int expected = 4;
		int actual = stock5.getQuantity();
		assertEquals(expected, actual, "This method is supposed to set the quantity.");
	}

	/**
	 * Test method for {@link io.stockcontrolsystem.StockItem#setReOrderLevel(int)}.
	 */
	@Test
	void testSetReOrderLevel() {
		StockItem stock6 = new StockItem();
		stock6.setReOrderLevel(7);

		int expected = 7;
		int actual = stock6.getReOrderLevel();
		assertEquals(expected, actual, "This method is supposed to set the reorder level");
	}

	/**
	 * Test method for {@link io.stockcontrolsystem.StockItem#toString()}.
	 */
	@Test
	void testToString() {
		StockItem stock7 = new StockItem("009", "item1", 4.99, 4, 7);

		String expected = "StockItem [ItemID : 009, Description : item1, Price : 4.99, Quantity : 4, ReOrder Level : 7]";
		String actual = stock7.toString();
		assertEquals(expected, actual, "This method is supposed to return a string of the object");
		System.out.println(stock7);
	}

	/**
	 * Test method for {@link io.stockcontrolsystem.StockItem#format()}.
	 */
	@Test
	void testFormat() {

		StockItem stock8 = new StockItem("009", "item1", 4.99, 4, 7);

		String expected = "009        item1                 4.99       4          7";
		String actual = stock8.format();
		assertEquals(expected, actual, "This method is supposed to return a formatted string of the object");
		System.out.println(stock8.format());
	}

}
