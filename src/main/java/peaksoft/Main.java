package peaksoft;

import peaksoft.model.User;
import peaksoft.service.UserService;
import peaksoft.service.UserServiceImpl;
import peaksoft.util.Util;

import java.sql.SQLException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws SQLException {

        UserService userService = new UserServiceImpl();
        Scanner scannerInt = new Scanner(System.in);
        Scanner scannerStr = new Scanner(System.in);
        while (true) {
            instructions();
            int commandNum = scannerInt.nextInt();
            switch (commandNum) {
                case 1 -> userService.createUsersTable();
                case 2 -> {
                    System.out.println("     Name        |     Last name          |  Age  |    Date base        |");
                    userService.saveUser("Toichubai", "Chekirov      ", (byte) 57);
                    userService.saveUser("Gulbira  ", "Borkoshova    ", (byte) 54);
                    userService.saveUser("Ayjamal  ", "Chekirova     ", (byte) 33);
                    userService.saveUser("Uulkan   ", "Toichubai kyzy", (byte) 28);
                    userService.saveUser("Ulanbek  ", "Asanov        ", (byte) 26);
                    userService.saveUser("Muhammed ", "Toichubai     ", (byte) 25);
                    userService.saveUser("Meerimgul", "Toichubai kyzy", (byte) 22);
                }
                case 3 -> {
                    System.out.println("Write name?");

                    System.out.println(userService.existsByFirstName(scannerStr.nextLine()));
                }
                case 4 -> System.out.println(userService.getAllUsers());
                case 5 -> {
                    System.out.println("Write id");
                    userService.removeUserById(scannerInt.nextInt());
                }
                case 6 -> userService.cleanUsersTable();
                case 7 -> userService.dropUsersTable();
                default -> System.out.println("Wrong enter, you have only 7 commands!");
            }
        }
    }

    public static void instructions() {
        System.out.println("\n>>>>>>>>>>>> Commands <<<<<<<<<<<<");
        System.out.println("Press 1 to create table");
        System.out.println("Press 2 to add users to database");
        System.out.println("Press 3 to exist by name");
        System.out.println("Press 4 to get all users");
        System.out.println("Press 5 to delete value by id");
        System.out.println("Press 6 to delete values of table");
        System.out.println("Press 7 to drop the table");
        System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>\n");
    }

}
