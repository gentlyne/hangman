package ru.gentlyne.roadmap.hangman;

import java.util.Scanner;

public class Main {
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);  
        System.out.println("Друг, добро пожаловать в игру \"Виселица\"");
        int choose = 0;
        while (choose != 2) {
            System.out.println("[1] Начало игры");
            System.out.println("[2] Выход");
            System.out.print("Введите пункт: ");
            
            choose = scanner.nextInt();
            
            
            if (choose == 1) {
                Game game = new Game();
                game.start();
            } else if (choose == 2) {
                System.out.println("Очень жаль, пока!");
            } else {
                System.err.println("Нет такого пункта. Повторите еще раз!");
            }
        }
        scanner.close();
    }
}