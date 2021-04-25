package controller;

import Services.HouseService;

import java.util.Scanner;

public class MainController {

    private HouseService houseService;
    HouseController houseController = new HouseController();
    VillaController villaController = new VillaController();
    RoomController roomController = new RoomController();

    public void displayMainMenu() {
        System.out.println("==================================================");
        System.out.println("****** Furama Resort Management Application ******");
        System.out.println("1. Add New Services");
        System.out.println("2. Show Services");
        System.out.println("3. Add New Customer");
        System.out.println("4. Show Information of Customer");
        System.out.println("5. Add New Booking");
        System.out.println("6. Show Information of Employee");
        System.out.println("7. Exit");
        System.out.println("==================================================");
        int choose;
        Scanner input = new Scanner(System.in);
        while (true) {
            System.out.println("Please choose 1 number (1-7):");
            choose = input.nextInt();
            switch (choose) {
                case 1:
                    addNewSerVice();
                    break;
                case 2:
                    showServices();
                    break;
                case 7:
                    System.out.println("Exit!!! Goodbye!!!!");
                    System.exit(0); // thoát chương trình
                    break;
            }
        }
    }

    public void showServices() {
        int choose;
        Scanner scanner = new Scanner(System.in);
        for (;;) {
            System.out.println("==================================================");
            System.out.println("1. Show all Villa");
            System.out.println("2. Show all House");
            System.out.println("3. Show all Room");
            System.out.println("4. Show All Name Villa Not Duplicate");
            System.out.println("5. Show All Name House Not Duplicate");
            System.out.println("6. Show All Name Room Not Duplicate");
            System.out.println("7. Back to menu");
            System.out.println("8. Exit");
            System.out.println("==================================================");
            do {
                System.out.println("Choose number(1-8): ");
                choose = scanner.nextInt();
            } while ((choose < 1) || (choose > 8));


            switch (choose) {
                case 1:
                    villaController.showAllVilla();
                    break;
                case 2:
                    houseController.showAllHouse();
                    break;
                case 3:
                    roomController.showAllRoom();
                    break;
                case 4:
                    villaController.showDistinctVillaName();
                    break;
                case 5:
                    houseController.showDistinctHouseName();
                    break;
                case 6:
                    roomController.showDistinctRoomName();
                    break;
                case 7:
                    displayMainMenu();
                    break;
                case 8:
                    System.out.println("Exit!!! Goodbye!!!!");
                    System.exit(0); // thoát chương trình
                    break;
            }
        }

    }

    public void addNewSerVice() {
        int choose;
        Scanner scanner = new Scanner(System.in);
        for (;;) {
            System.out.println("==================================================");
            System.out.println("1. Add New Villa");
            System.out.println("2. Add New House");
            System.out.println("3. Add New Room");
            System.out.println("4. Back to menu");
            System.out.println("5. Exit");
            System.out.println("==================================================");
            do {
                System.out.println("Choose number(1-5): ");
                choose = scanner.nextInt();
            } while ((choose < 1) || (choose > 5));

            switch (choose) {
                case 1:
                    try {
                        villaController.add();
                    } catch (Exception e) {
                        System.err.println(e.getMessage());
                        addNewSerVice();
                    }
                    break;
                case 2:
                    try {
                        houseController.add();
                    } catch (Exception e) {
                        System.err.println(e.getMessage());
                        addNewSerVice();
                    }
                    break;
                case 3:
                    try {
                        roomController.add();
                    } catch (Exception e) {
                        System.err.println(e.getMessage());
                        addNewSerVice();
                    }
                    break;
                case 4:
                    displayMainMenu();
                    break;
                case 5:
                    System.out.println("Exit!!! Goodbye!!!!");
                    System.exit(0); // thoát chương trình
                    break;
            }
        }
    }

    public static void main(String[] args) {

        MainController mainController = new MainController();
        mainController.displayMainMenu();

    }
}