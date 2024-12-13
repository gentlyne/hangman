package ru.gentlyne.roadmap.hangman;

import java.util.Scanner;

public class Menu {

    private final Game game;

    public Menu(Game game) {
        this.game = game;
    }

    public void start(Scanner scanner) {
        MenuStatus select = MenuStatus.WAIT_CHOICE;
        while (select != MenuStatus.EXIT) {
            System.out.println("[1] Начало игры");
            System.out.println("[2] Выход");
            select = nextSelect(scanner);
            if (select == MenuStatus.GAME) {
                game.start(scanner);
            } else if (select == MenuStatus.EXIT) {
                System.out.println("Очень жаль, пока!");
            } else {
                System.out.println("Ошибка ввода. Повторите еще раз!");
            }
        }
    }

    private MenuStatus nextSelect(Scanner scanner) {
        System.out.print("Выберите действия: ");
        try {
            int choice = Integer.parseInt(scanner.nextLine());
            return MenuStatus.getMenuStatus(choice);
        } catch (RuntimeException e) {
            return MenuStatus.ERROR;
        }
    }

    private enum MenuStatus {
        ERROR(-1),
        WAIT_CHOICE(0),
        GAME(1),
        EXIT(2);

        private final int id;

        MenuStatus(int id) {
            this.id = id;
        }

        public static MenuStatus getMenuStatus(int id) {
            for (MenuStatus status : MenuStatus.values()) {
                if (status.id == id) {
                    return status;
                }
            }
            return ERROR;
        }
    }
}
