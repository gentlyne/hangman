package ru.gentlyne.roadmap.hangman;

import java.util.Scanner;

public class Game {

    private final Engine engine;
    private final EngineFormatter formatter;

    public Game(Engine engine, EngineFormatter formatter) {
        this.engine = engine;
        this.formatter = formatter;
    }

    public void start(Scanner scanner) {
        engine.reset();
        while (!engine.isEndGame()) {
            System.out.println(formatter.format(engine));
            try {
                engine.suggestLetter(nextLetter(scanner));
            } catch (IllegalLetterException e) {
                System.err.println("Неверный символ или формат");
            }
        }
        System.out.println(formatter.format(engine));
    }

    private String nextLetter(Scanner scanner) {
        System.out.print("Введите следующий символ: ");
        return scanner.nextLine();
    }
}
