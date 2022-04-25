package JavaProjectsFaDu.P11_depoYonetimi;

import _15_ExceptionsFaDu.Q02.Student;

import java.util.Scanner;

import static JavaProjectsFaDu.P11_depoYonetimi.Transactions.addedProductsMap;
import static JavaProjectsFaDu.P11_depoYonetimi.Transactions.scan;

public class ExceptionManagement {


    // 2-1 : PRODUCT MANAGEMENT - how many products will you enter?

    public static int pNumbers() {

        int tempNum = 0;

        while (true) {
            try {
                System.out.print("How many products will you enter : ");
                tempNum = scan.nextInt();
                if (tempNum < 0 || tempNum > 10) {  // check integer value between
                    throw new ArithmeticException();
                } else {
                    break;
                }

            } catch (ArithmeticException e) {
                System.out.println("WARNING ! : You can enter maximum 10 products each time");

            } catch (Exception e) {   // if any key like String situation
                String str = scan.next();
                System.out.println("WARNING ! Please enter a valid number");

            }
        }

        return tempNum;
    }


    // 2-2 : which product and how many of them
    // 2-2-a (select product code check)
    public static int selectProductCode() {
        int tempNum = 0;

        while (true) {
            try {
                System.out.print("Enter the product code for the transaction : ");
                tempNum = scan.nextInt();


                if (!addedProductsMap.keySet().contains(tempNum)) {
                    throw new ArithmeticException();
                } else {
                    break;
                }

            } catch (ArithmeticException e) {
                System.out.println("WARNING ! : Please write only registered product code");

            } catch (Exception e) {
                String str = scan.next();
                System.out.println("WARNING ! Please enter a valid number");

            }
        }

        return tempNum;
    }

    // 2-2-b (how many product check)
    public static int addQuantityProduct() {
        int tempNum = 0;

        while (true) {
            try {
                System.out.print("Enter the Quantity (max 100 unit): ");
                tempNum = Integer.valueOf(scan.next());

                if (tempNum < 0 || tempNum > 100) {
                    throw new ArithmeticException();
                } else {
                    break;
                }

            } catch (ArithmeticException e) {
                System.out.println("WARNING ! : You can enter maximum 100 quantity of  each product");

            } catch (Exception e) {
                System.out.println("WARNING ! Please enter a valid number");

            }
        }

        return tempNum;
    }


    // 4 - Shelf Planning quantity should ve more than 0
    public static int quantityControl(int productId) {
        int tempQuantity = 0;

        Product prdTemp = addedProductsMap.get(productId);
        return prdTemp.getProductQuantity();

    }

    // 4b Shelf Planning (if enter the product code with 0 quantity  )
    public static int afterSelectionZeroQuantity() {
        int tempNum = 0;

        while (true) {
            try {
                System.out.println("1: assign a shelf for another product\n2: Return main menu");
                tempNum = Integer.valueOf(scan.next());

                if (tempNum < 0 || tempNum > 2) {
                    throw new ArithmeticException();
                } else {
                    break;
                }

            } catch (ArithmeticException e) {
                System.out.println("WARNING ! : Please enter 1 to continue shelf assignment or " +
                        "\n enter 2 to go mainmenu");

            } catch (Exception e) {
                System.out.println("WARNING ! Please enter a valid number");

            }
        }

        return tempNum;
    }


}
