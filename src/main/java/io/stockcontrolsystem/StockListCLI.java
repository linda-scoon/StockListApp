
package io.stockcontrolsystem;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import io.stockcontrolsystemExceptions.AddException;
import io.stockcontrolsystemExceptions.DeleteException;

/**
 * @author Linda Scoon
 *
 */
public class StockListCLI {

	private BufferedReader in;
	private StockList stock;

	/**
	 * Constructor
	 * 
	 * @param stock
	 */
	public StockListCLI(StockList stock) {

		((StockLinkedList) stock).setLogging();
		this.stock = stock;

		// https://docs.oracle.com/javase/7/docs/api/java/io/InputStreamReader.html
		in = new BufferedReader(new InputStreamReader(System.in));
	}

	/**
	 * Displays main menu and gets valid option from user
	 */
	public void doMenu() {

		boolean done = false;
		while (!done) {
			System.out.print("\nStock List Main Menu\r\n" + "********************\r\n" + "1. Add an Item\r\n"
					+ "2. Delete an Item\r\n" + "3. Update Item Price\r\n" + "4. Update Item Quantity\r\n"
					+ "5. Update Re-Order Level\r\n" + "6. Print Stock List\r\n" + "7. Print ReOrder List\r\n"
					+ "8. Exit\r\n" + "Select option [1-8] : ");

			try {
				String reply = in.readLine();
				switch (reply) {
				case "1":
					doAddItem();
					break;
				case "2":
					doDeleteItem();
					break;
				case "3":
					doUpdateItemPrice();
					break;
				case "4":
					doUpdateItemQuantity();
					break;
				case "5":
					doUpdateReOrderLevel();
					break;
				case "6":
					doPrintStockList();
					break;
				case "7":
					doPrintReorderLIst();
					break;
				case "8":
					System.out.println("\nProgram ended");
					done = true;
					break;
				default:
					System.err.println("INVALID ENTRY");
				}
			} catch (IOException e) {
				System.err.println("Invalid input. Re-enter option." + e);
			}
		}
	}

	/**
	 * Obtain input for stock list operation and invoke operation
	 */
	private void doAddItem() {

		boolean done = false;
		try {
			while (!done) {

				System.out.printf("%n%s%n%s%n", "Add New Item", "************");

				System.out.print("Enter ID: ");
				String id = in.readLine();

				System.out.print("Enter Description: ");
				String desc = in.readLine();

				System.out.print("Enter Price: ");
				double price = Double.parseDouble(in.readLine());

				System.out.print("Enter Quantity: ");
				int quantity = Integer.parseInt(in.readLine());

				System.out.print("Re-Order Level: ");
				int reOrderLevel = Integer.parseInt(in.readLine());

				StockItem item = new StockItem(id, desc, price, quantity, reOrderLevel);// creating item
				stock.addItem(item);// adding item to the list
				stock.saveStockData();// saving changes

				boolean valid = false;// validating reply
				while (!valid) {
					System.out.print("Enter Another (Y/N): ");
					String reply = in.readLine();

					if (reply.equalsIgnoreCase("Y")) {
						valid = true;
					} else if (reply.equalsIgnoreCase("N")) {
						valid = true;
						done = true;
					} else {
						System.out.println("Invalid Input");
					}
				}
			}
		} catch (IOException e) {
			System.err.println("Invalid input. Item has not been added. Re-enter data. " + e);
		} catch (NumberFormatException e) {
			System.err.println("Ensure price = double; quantity = int; reOrderLevel = int. " + e);
		} catch (AddException e) {
			System.err.println("The Item ID already exists. Item has not been saved. " + e);
		}
	}

	private void doDeleteItem() {

		boolean done = false;
		try {
			while (!done) {

				System.out.printf("%n%s%n%s%n", "Delete Item", "************");
				System.out.print("Enter Item ID: ");
				String id = in.readLine();
				stock.deleteItem(id);
				stock.saveStockData();// saving changes

				boolean valid = false;
				while (!valid) {
					System.out.print("Delete Another (Y/N): ");
					String reply = in.readLine();
					if (reply.equalsIgnoreCase("Y")) {
						valid = true;
					} else if (reply.equalsIgnoreCase("N")) {
						valid = true;
						done = true;
					} else {
						System.err.println("Invalid Input");
					}
				}

			}
		} catch (IOException e) {
			System.err.println("Invalid input. Item has not been deleted. Re-enter data. " + e);
		} catch (DeleteException e) {
			System.err.println("Item does not exist. " + e);
		}
	}

	private void doUpdateItemPrice() {

		boolean done = false;
		while (!done) {

			System.out.printf("%n%s%n%s%n", "Update Price", "************");

			try {
				System.out.print("Enter Item ID: ");
				String id = in.readLine();
				System.out.print("Enter New Price: ");
				double price = Double.parseDouble(in.readLine());
				stock.updateItemPrice(id, price);
				stock.saveStockData();// saving changes

				boolean valid = false;
				while (!valid) {
					System.out.print("Update Another (Y/N): ");

					String reply = in.readLine();

					if (reply.equalsIgnoreCase("Y")) {
						valid = true;
					} else if (reply.equalsIgnoreCase("N")) {
						valid = true;
						done = true;
					} else {
						System.err.println("Invalid Input");
					}
				}
			} catch (IOException e) {
				System.err.println("Invalid input. Item has not been updated. Re-enter data. " + e);
			} catch (NumberFormatException e) {
				System.err.println("Ensure price = double; quantity = int; reOrderLevel = int. " + e);
			}
		}
	}

	private void doUpdateItemQuantity() {

		boolean done = false;
		while (!done) {

			try {
				System.out.printf("%n%s%n%s%n", "Update Quantity", "************");
				System.out.print("Enter Item ID: ");
				String id = in.readLine();
				System.out.print("Enter New Quantity: ");
				int quantity = Integer.parseInt(in.readLine());
				stock.updateItemQuantity(id, quantity);
				stock.saveStockData();// saving changes

				boolean valid = false;
				while (!valid) {
					System.out.print("Update Another (Y/N): ");
					String reply = in.readLine();
					if (reply.equalsIgnoreCase("Y")) {
						valid = true;
					} else if (reply.equalsIgnoreCase("N")) {
						valid = true;
						done = true;
					} else {
						System.err.println("Invalid Input");
					}
				}
			} catch (IOException e) {
				System.err.println("Invalid input. Item has not been updated. Re-enter data. " + e);
			} catch (NumberFormatException e) {
				System.err.println("Ensure price = double; quantity = int; reOrderLevel = int. " + e);
			}
		}
	}

	private void doUpdateReOrderLevel() {

		boolean done = false;
		while (!done) {

			try {
				System.out.printf("%n%s%n%s%n", "Update Re-Order Level", "**************");
				System.out.print("Enter Item ID: ");
				String id = in.readLine();
				System.out.print("Enter New Re-Order Level: ");
				int reOrderLevel = Integer.parseInt(in.readLine());
				stock.updateReOrderLevel(id, reOrderLevel);
				stock.saveStockData();// saving changes

				boolean valid = false;
				while (!valid) {
					System.out.print("Update Another (Y/N): ");
					String reply = in.readLine();
					if (reply.equalsIgnoreCase("Y")) {
						valid = true;
					} else if (reply.equalsIgnoreCase("N")) {
						valid = true;
						done = true;
					} else {
						System.err.println("Invalid Input");
					}
				}
			} catch (IOException e) {
				System.err.println("Invalid input. Item has not been updated. Re-enter data. " + e);
			} catch (NumberFormatException e) {
				System.err.println("Ensure price = double; quantity = int; reOrderLevel = int. " + e);
			}

		}
	}

	/**
	 * Display contents of stock list
	 */
	private void doPrintStockList() {
		System.out.printf("%n%10s%n%10s%n", "STOCK LIST", "--------------");
		System.out.println(stock.formatStockList());
	}

	/**
	 * Display contents of re-order list
	 */
	private void doPrintReorderLIst() {
		System.out.printf("%n%10s%n%10s%n", "RE-ORDER LIST", "-------------");
		System.out.println(stock.formatReOrderList());

	}

}
