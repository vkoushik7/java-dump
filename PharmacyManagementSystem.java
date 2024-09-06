import java.util.Scanner;

class Node {
    int receiptNumber;
    String customerName;
    String date;
    int[] quantity = new int[10];
    String type = "OTC";
    int[] menu2 = new int[10];
    double[] amount = new double[10];
    String[] medicineName = { "Probiotics", "Vitamin C(500mg)", "Acid Free C(500mg)", "Women'S Multivate",
            "Marino Tablet", "Maxi Cal Tablet", "Amino Zinc Tablet", "Burnex", "Fabuloss 5", "Royal Propollen" };
    double[] medicinePrice = { 2.00, 3.00, 1.00, 4.00, 1.00, 5.00, 7.00, 4.00, 3.00, 5.00 };
    double total;
    Node next;
    Node prev;
    double[] price = new double[10]; // Prices for the medicines
}

public class PharmacyManagementSystem {
    Node start_ptr = null;

    public static void main(String[] args) {
        PharmacyManagementSystem medicine = new PharmacyManagementSystem();
        int menu;
        Scanner input = new Scanner(System.in);

        do {
            System.out.println("Pharmacy Management System");
            System.out.println("1. Take new Medicine order");
            System.out.println("2. Delete latest Medicine order");
            System.out.println("3. Modify Order List");
            System.out.println("4. Print the Reciept and Make Payment");
            System.out.println("5. Daily Summary of total Sale");
            System.out.println("6. Exit");
            System.out.print("Enter choice: ");
            menu = input.nextInt();

            switch (menu) {
                case 1:
                    medicine.takeOrder();
                    break;
                case 2:
                    medicine.deleteOrder();
                    break;
                case 3:
                    medicine.modifyOrder();
                    break;
                case 4:
                    medicine.printReceipt();
                    break;
                case 5:
                    medicine.dailySummary();
                    break;
                case 6:
                    medicine.exit();
                    break;
                default:
                    System.out.println("Invalid input. Please try again.");
            }
        } while (menu != 6);
    }

    public void takeOrder() {
        Scanner input = new Scanner(System.in);
        int i;
        int choice, quantity;
        double price;
        System.out.println("\nAdd Order Details");
        System.out.println("_____________ \n");

        Node temp = new Node();

        System.out.println("**************************");
        System.out.println("DRUGS ID\tDRUGS TYPE\t\tDRUGS NAME\t\t\tDRUGS PRICE(RM)");
        System.out.println("**************************");
        for (i = 0; i < temp.medicineName.length; i++) {
            System.out.printf("%04d\t\t%s\t\t%s\t\tRM %.2f\n", i + 1, temp.type, temp.medicineName[i],
                    temp.medicinePrice[i]);
        }
        System.out.println(" ");

        System.out.print("Type Order no: ");
        temp.receiptNumber = input.nextInt();
        System.out.print("Enter Customer Name: ");
        temp.customerName = input.next();
        System.out.print("Enter Date: ");
        temp.date = input.next();
        System.out.println("How many Medicine would you like to order:");
        System.out.println("( Maximum is 10 order for each transaction ) ");
        System.out.print("  ");
        int numOrders = input.nextInt();
        if (numOrders > 10) {
            System.out.println("The Medicine you order is exceed the maximum amount of order!");
        } else {
            for (i = 0; i < numOrders; i++) {
                System.out.println("Please enter your selection: ");
                temp.menu2[i] = input.nextInt();
                System.out.println("Medicine Name: " + temp.medicineName[temp.menu2[i] - 1]);
                System.out.print("How many medicine do you want: ");
                temp.quantity[i] = input.nextInt();
                temp.amount[i] = temp.quantity[i] * temp.medicinePrice[temp.menu2[i] - 1];
                System.out.printf("The amount You need to pay is: %.2f RM\n", temp.amount[i]);
                System.out.println("Press Enter to continue...");
                input.nextLine(); // Consume newline left-over
                input.nextLine(); // Wait for enter press
            }
            System.out.println("===========================================================================");
            System.out.println("Order Taken Successfully");
            System.out.println("===========================================================================");
            System.out.println("Go to Receipt Menu to Pay The Bill");
            System.out.println("===========================================================================");
            System.out.println("Press Enter to continue...");
            input.nextLine(); // Wait for enter press

            temp.next = null;
            if (start_ptr != null) {
                temp.next = start_ptr;
            }
            start_ptr = temp;
        }
    }

    public void deleteOrder() {
        Scanner input = new Scanner(System.in);
        int receiptNumberToDelete;
        System.out.println("Enter the receipt number you want to delete:");
        receiptNumberToDelete = input.nextInt();
        Node temp = start_ptr, prev = null;
        boolean found = false;

        if (temp == null) {
            System.out.println("Cannot delete from an empty list.");
        } else {
            // Deleting the first node
            if (temp.receiptNumber == receiptNumberToDelete) {
                start_ptr = temp.next; // Changed head
                System.out.println("The Receipt is Deleted Successfully");
                return;
            }

            // Search for the receipt number to delete, keep track of the previous node
            while (temp != null && temp.receiptNumber != receiptNumberToDelete) {
                prev = temp;
                temp = temp.next;
            }

            // If receipt number was not present in linked list
            if (temp == null) {
                System.out.println("Item to be deleted is not in the list.");
                return;
            }

            // Unlink the node from linked list
            prev.next = temp.next;
            System.out.println("The Receipt is Deleted Successfully");
        }
    }

    public void modifyOrder() {
        Scanner input = new Scanner(System.in);
        int receiptNumber, newReceiptNumber, quantity, selection;
        String newCustomerName, newDate;
        boolean found = false;

        System.out.println("Enter Receipt Number To Modify: ");
        receiptNumber = input.nextInt();
        Node temp = start_ptr;

        if (temp == null) {
            System.out.println("NO RECORD TO MODIFY..!");
        } else {
            while (temp != null && !found) {
                if (temp.receiptNumber == receiptNumber) {
                    found = true;
                    System.out.println("Change Order Number: ");
                    newReceiptNumber = input.nextInt();
                    temp.receiptNumber = newReceiptNumber;

                    System.out.println("Change Customer Name: ");
                    newCustomerName = input.next();
                    temp.customerName = newCustomerName;

                    System.out.println("Change Date: ");
                    newDate = input.next();
                    temp.date = newDate;

                    System.out.println(
                            "How many New Medicines would you like to Change (Maximum is 10 orders for each transaction): ");
                    int newMedicineCount = input.nextInt();
                    if (newMedicineCount > 10) {
                        System.out.println("The Medicine you order exceeds the maximum amount of order!");
                    } else {
                        for (int i = 0; i < newMedicineCount; i++) {
                            System.out.println("Please enter your selection to Change: ");
                            selection = input.nextInt();
                            System.out.println("Change Medicine Name: " + temp.medicineName[selection - 1]);
                            System.out.println("How many New medicines do you want: ");
                            quantity = input.nextInt();
                            temp.quantity[i] = quantity;
                            temp.amount[i] = quantity * temp.price[selection - 1]; // Assuming there's a price array
                                                                                   // parallel to medicineName
                            System.out.println("The amount You need to pay After Modify is: " + temp.amount[i] + " RM");
                        }
                        System.out.println("RECORD MODIFIED....!");
                    }
                }
                temp = temp.next;
            }
            if (!found) {
                System.out.println("Invalid Receipt Number...!");
            }
        }
    }

    public void printReceipt() {
        Scanner input = new Scanner(System.in);
        int receiptNumber;
        boolean found = false;

        System.out.println("Enter the Receipt Number To Print The Receipt");
        receiptNumber = input.nextInt();
        System.out.println("\n===========================================================================");
        System.out.println("\t\tHere is the Order list");
        System.out.println("===========================================================================");

        Node temp = start_ptr;

        if (temp == null) {
            System.out.println("\tThere is no Order to show\n\t\t\tSo The List is Empty\n\n\n");
        } else {
            while (temp != null && !found) {
                if (temp.receiptNumber == receiptNumber) {
                    found = true;
                    System.out.println("Receipt Number: " + temp.receiptNumber);
                    System.out.println("Customer Name: " + temp.customerName);
                    System.out.println("Order Date: " + temp.date);
                    System.out.println("_____________________________________________________________________________");
                    System.out.println("|  Medicine Type |     Medicine Name    |   Quantity     |    Total Price |");
                    System.out.println("=============================================================================");
                    for (int i = 0; i < temp.quantity.length; i++) {
                        if (temp.quantity[i] > 0) { // Assuming quantity array is initialized to 0 and only filled up to
                                                    // the number of orders
                            System.out.printf("%-15s %-25s %-15d %-15.2f RM\n", temp.type,
                                    temp.medicineName[temp.menu2[i] - 1], temp.quantity[i], temp.amount[i]);
                            System.out.println(
                                    "_____________________________________________________________________________");
                        }
                    }
                    temp.total = 0; // Reset total to 0 before calculating
                    for (double amount : temp.amount) {
                        temp.total += amount;
                    }
                    System.out.println("Total Bill is: " + temp.total + " RM");
                    System.out.println("\nType the exact amount You need to pay: ");
                    double amountPaid = input.nextDouble();
                    System.out.println("\nPayment Done\nThank You\n");
                    System.out.println("\n___________________________\n");
                }
                temp = temp.next;
            }
            if (!found) {
                System.out.println("Receipt Number Not Found.");
            }
        }
    }

    public void dailySummary() {
        Node temp = start_ptr;

        if (temp == null) {
            System.out.println("\t\t\tThere is no Order to show\n\t\t\tSo The List is Empty\n\n\n");
        } else {
            System.out.println("\n");
            System.out.println("===========================================================================");
            System.out.println(" \t\tHere is the Daily Summary of All Orders");
            System.out.println("===========================================================================");

            while (temp != null) {
                System.out.println("Receipt Number: " + temp.receiptNumber);
                System.out.println("Customer Name: " + temp.customerName);
                System.out.println("Order Date: " + temp.date);
                System.out.println("_____________________________________________________________________________");
                System.out.println("|  Medicine Type |     Medicine Name    |   Quantity     |    Total Price |");
                System.out.println("=============================================================================");
                for (int i = 0; i < temp.quantity.length; i++) {
                    if (temp.quantity[i] > 0) { // Assuming quantity array is initialized to 0 and only filled up to the
                                                // number of orders
                        System.out.printf("%-15s %-25s %-15d %-15.2f RM\n", temp.type,
                                temp.medicineName[temp.menu2[i] - 1], temp.quantity[i], temp.amount[i]);
                        System.out.println(
                                "_____________________________________________________________________________");
                    }
                }
                temp.total = 0; // Reset total to 0 before calculating
                for (double amount : temp.amount) {
                    temp.total += amount;
                }
                System.out.println("Total Bill is: " + temp.total + " RM");
                System.out.println("\n___________________________\n");

                temp = temp.next;
            }
        }
    }

    public void exit() {
        System.out.println("Exiting the program.");
    }
}