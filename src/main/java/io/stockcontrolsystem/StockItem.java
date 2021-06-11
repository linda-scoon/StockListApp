package io.stockcontrolsystem;

import java.io.Serializable;

/**
 * @author lns18qlr Defines a stock item and its properties
 */
public class StockItem implements Serializable {

	private static final long serialVersionUID = 5886443094853079636L;
	private String itemID; // Five alpha-numeric characters
	private String itemDesc; // Item description
	private double price; // Item price in pounds sterling
	private int quantity; // Quantity in stock
	private int reOrderLevel; // Level at which to re-order

	public StockItem() {
		itemID = null;
		itemDesc = null;
		price = 0.00;
		quantity = 0;
		reOrderLevel = 0;
	}

	public StockItem(String id, String desc, double price, int quantity, int reOrderLvl) {

		this.itemID = id;
		this.itemDesc = desc;
		this.price = price;
		this.quantity = quantity;
		this.reOrderLevel = reOrderLvl;
	}

	/**
	 * @return the itemID
	 */
	public String getItemID() {
		return itemID;
	}

	/**
	 * @param itemID the itemID to set
	 */
	public void setItemID(String itemID) {
		this.itemID = itemID;
	}

	/**
	 * @return the itemDesc
	 */
	public String getItemDesc() {
		return itemDesc;
	}

	/**
	 * @param itemDesc the itemDesc to set
	 */
	public void setItemDesc(String itemDesc) {
		this.itemDesc = itemDesc;
	}

	/**
	 * @return the price
	 */
	public double getPrice() {
		return price;
	}

	/**
	 * @param price the price to set
	 */
	public void setPrice(double price) {
		this.price = price;
	}

	/**
	 * @return the quantity
	 */
	public int getQuantity() {
		return quantity;
	}

	/**
	 * @param quantity the quantity to set
	 */
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	/**
	 * @return the reOrderLevel
	 */
	public int getReOrderLevel() {
		return reOrderLevel;
	}

	/**
	 * @param reOrderLevel the reOrderLevel to set
	 */
	public void setReOrderLevel(int reOrderLevel) {
		this.reOrderLevel = reOrderLevel;
	}

	/**
	 * 
	 */
	@Override
	public String toString() {
		return "StockItem [ItemID : " + getItemID() + ", Description : " + getItemDesc() + ", Price : " + getPrice()
				+ ", Quantity : " + getQuantity() + ", ReOrder Level : " + getReOrderLevel() + "]";
	}

	public String format() {
		String formatted = String.format("%-10s %-21s %-10s %-10s %s", getItemID(), getItemDesc(), getPrice(),
				getQuantity(), getReOrderLevel());
		return formatted;
	}

}
