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
                    userService.saveUser("Azamat", "Azamatov      ", (byte) 57);
                    userService.saveUser("Azat  ", "Azatov    ", (byte) 76);
                    userService.saveUser("Ayjamal  ", "Azamatovna     ", (byte) 54);
                    userService.saveUser("Aziza   ", "Azizovna", (byte) 28);
                    userService.saveUser("Ulan  ", "Ulanbekov        ", (byte) 26);
                    userService.saveUser("Uson ", "Asanov     ", (byte) 25);
                    userService.saveUser("Asan", "Usonev", (byte) 22);
                }
                case 3 -> {
                    System.out.println("Напишите имя?");

                    System.out.println(userService.existsByFirstName(scannerStr.nextLine()));
                }
                case 4 -> System.out.println(userService.getAllUsers());
                case 5 -> {
                    System.out.println("Напишите id");
                    userService.removeUserById(scannerInt.nextInt());
                }
                case 6 -> userService.cleanUsersTable();
                case 7 -> userService.dropUsersTable();
                default -> System.out.println("Неверный ввод, у вас всего 7 команд!");
            }
        }
    }

    public static void instructions() {
        System.out.println("\n>>>>>>>>>>>> Команды <<<<<<<<<<<<");
        System.out.println("Нажмите 1, чтобы создать таблицу.");
        System.out.println("Нажмите 2, чтобы добавить пользователей в базу данных.");
        System.out.println("Нажмите 3, чтобы существовать по имени.");
        System.out.println("Нажмите 4, чтобы вывести всех пользователей.");
        System.out.println("Нажмите 5, чтобы удалить значение по id.");
        System.out.println("Нажмите 6, чтобы удалить значения в таблицы.");
        System.out.println("Нажмите 7, чтобы удалить таблицу.");
        System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>\n");
    }

}
