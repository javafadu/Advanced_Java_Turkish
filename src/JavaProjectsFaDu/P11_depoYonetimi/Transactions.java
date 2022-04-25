package JavaProjectsFaDu.P11_depoYonetimi;

import JavaProjectsFaDu.P05_HalukMarket.Products;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class Transactions {

    static Scanner scan = new Scanner(System.in);
    static String selection;
    static Map<Integer, Product> addedProductsMap = new HashMap<>();


    // 1 - SYSTEM MENU PAGE
    public static void warManSystemMenu() {

        System.out.println("*****  WAREHOUSE MANAGEMENT SYSTEM ****** ");
        System.out.println("-------------------------");
        System.out.println("1 - Product Management\t\t3 - List Products");
        System.out.println("2 - Shelf Planning \t\t\t4 - Deliver Products");
        System.out.println("5 - Quit");
        System.out.print("Chose your selection : ");
        selection = scan.next();

        switch (selection) {

            case "1":
                productManagement();
                break;

            case "2":
                shelfPlanning();
                break;

            case "3":
                listProducts();
                break;

            case "4":
                deliverProducts();
                break;

            case "5":
                exitSystem();
                break;

            default:
                System.out.println("Please enter a valid menu number");
                warManSystemMenu();

        }

    }

    // 4- Deliver Products
    private static void deliverProducts() {
        System.out.println("*****  DELIVER PRODUCT PAGE ****** ");
        System.out.println("-------------------------");

        int returnedProductCode = ExceptionManagement.selectProductCode(); // write code number of the registered product
        int returnedProductQuantity = ExceptionManagement.addQuantityProduct(); // write product quantity to be updated

        Product prdTemp = addedProductsMap.get(returnedProductCode);


        int productQuantity = prdTemp.getProductQuantity();
        System.out.println("Product Code : " + returnedProductCode + " - Product Quantity : " + prdTemp.getProductQuantity());


        if (returnedProductQuantity > productQuantity) {
            System.out.println("Please enter enough quantity to deliver");

        } else {
            prdTemp.setProductQuantity((prdTemp.getProductQuantity() - returnedProductQuantity));
            addedProductsMap.put(returnedProductCode, prdTemp);
        }


        productManagement();
    }

    // 5- QUIT SYSTEM
    private static void exitSystem() {
        System.out.println("******** HAVE A NICE DAY ********");
    }

    // 4- SHELF PLANNING
    private static void shelfPlanning() {
        String newShelfNo = "";
        System.out.println("*****  SHELF PLANNING PAGE ****** ");
        System.out.println("-------------------------");

        int returnedProductCode = ExceptionManagement.selectProductCode(); // write code number of the registered product


        if (ExceptionManagement.quantityControl(returnedProductCode) > 0) {
            System.out.print("Enter the shelf code to be assigned for the relevant product :");
            newShelfNo = scan.next();
            Product prdTemp = addedProductsMap.get(returnedProductCode);
            prdTemp.setProductShelfNo(newShelfNo);

            addedProductsMap.put(returnedProductCode, prdTemp);
        } else {
            System.out.println("WARNING ! You can only assign shelves for products with a quantity. ");
            int userSelection = ExceptionManagement.afterSelectionZeroQuantity();
            switch (userSelection) {
                case 1:
                    shelfPlanning();
                    break;
                case 2:
                    warManSystemMenu();
                    break;
                default:
                    System.out.println("please enter a valid number");
                    ExceptionManagement.afterSelectionZeroQuantity();
                    break;
            }
        }

        System.out.println("Shelf no " + newShelfNo + "has been assigned to " + returnedProductCode + "Product");

        warManSystemMenu();
    }

    // 2- PRODUCT MANAGEMENT PAGE
    private static void productManagement() {
        System.out.println("*****  PRODUCT MANAGEMENT PAGE ****** ");
        System.out.println("-------------------------");
        System.out.println("1 - Add New Product\t\t3 - Remove Product");
        System.out.println("2 - Update Product \t\t4 - List Products");
        System.out.println("5 - Main Menu");
        System.out.print("Chose your selection : ");
        selection = scan.next();

        switch (selection) {
            case "1":
                addNewProduct();
                break;
            case "2":
                updateProduct();
                break;
            case "3":
                removeProduct();
                break;
            case "4":
                listProducts();
                break;
            case "5":
                warManSystemMenu();
                break;
            default:
        }
    }

    // 2-3 PRODUCT MANAGEMENT - Remove Product
    private static void removeProduct() {
        System.out.println("*****  PRODUCT UPDATE PAGE ****** ");
        System.out.println("-------------------------");

        int returnedProductCode = ExceptionManagement.selectProductCode(); // write code number of the registered product

        Product prdTemp = addedProductsMap.get(returnedProductCode);
        System.out.println("Product Code : " + returnedProductCode + " - Product Quantity : " + prdTemp.getProductQuantity());

        addedProductsMap.remove(returnedProductCode);
        System.out.println(returnedProductCode + " Product has been removed from system");

        listProducts();

    }

    // 2-2 PRODUCT MANAGEMENT - Update Product
    private static void updateProduct() {
        System.out.println("*****  PRODUCT UPDATE PAGE ****** ");
        System.out.println("-------------------------");

        int returnedProductCode = ExceptionManagement.selectProductCode(); // write code number of the registered product

        Product prdTemp = addedProductsMap.get(returnedProductCode);

        System.out.println("Product Code : " + returnedProductCode + " - Product Quantity : " + prdTemp.getProductQuantity());
        int returnedProductQuantity = ExceptionManagement.addQuantityProduct(); // write product quantity to be updated

        prdTemp.setProductQuantity(returnedProductQuantity);

        addedProductsMap.put(returnedProductCode, prdTemp);

        listProducts();

    }

    // 3 | 2-4 LIST PRODUCTS
    private static void listProducts() {
        System.out.println("Prd ID  Prd Name  Prd Producer  Prd Unit  Prd Quantity  Prd ShelfNo");
        System.out.println("-------------------------------------------------------------------");

        Set<Map.Entry<Integer, Product>> productEntrySet = addedProductsMap.entrySet();

        for (Map.Entry<Integer, Product> each : productEntrySet
        ) {
            System.out.printf("%-6d %-10s %-12s %-10s %-8d %-8s \n", each.getKey(), each.getValue().getProductName(), each.getValue().getProductProducer(),
                    each.getValue().getProductUnit(), each.getValue().getProductQuantity(), each.getValue().getProductShelfNo());
        }
        System.out.println("-------------------------------------------------------------------");

        productManagement();

    }

    // 2-1 PRODUCT MANAGEMENT - ADD NEW PRODUCT
    private static void addNewProduct() {
        System.out.println("*****  ADD NEW PRODUCT PAGE ****** ");
        System.out.println("-------------------------");

        int returnedNum = ExceptionManagement.pNumbers(); // how many products will you enter?
        // Check exceptions

        scan.nextLine(); // dummy scan
        int pId = 0;
        String pName = "";
        String pProducer = "";
        String pUnit = "";
        for (int i = 0; i < returnedNum; i++) {

            Product prdTemp = new Product();

            pId = Product.getProductId();

            System.out.print(i + 1 + ". Product Name : ");
            pName = scan.nextLine();
            prdTemp.setProductName(pName);

            System.out.print("Product Producer : ");
            pProducer = scan.nextLine();
            prdTemp.setProductProducer(pProducer);

            System.out.print("Product Unit : ");
            pUnit = scan.nextLine();
            prdTemp.setProductUnit(pUnit);


            addedProductsMap.put(pId, prdTemp);


        }
        System.out.println("All products have been added into the WarManSystem");

        listProducts();

    }

}
