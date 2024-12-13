package ru.gentlyne.roadmap.hangman;

import java.util.Scanner;

public class Main {
    
    public static void main(String[] args) {
        System.out.println("Добрый вечер! Здравствуйте, уважаемые дамы и господа! Игра \"Виселица\"");
        try (Scanner scanner = new Scanner(System.in)) {
            Engine engine = new Engine(new WordSource().getWords());
            Game game = new Game(engine, new EngineFormatter());
            Menu menu = new Menu(game);
            menu.start(scanner);
        }
    }
}