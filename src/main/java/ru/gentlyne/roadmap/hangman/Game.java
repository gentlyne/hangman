package ru.gentlyne.roadmap.hangman;

import java.util.Scanner;

public class Game {
    
    public void start() {        
        WordSource source = new StaticWordSource();
        Engine engine = new Engine(source.getWords());
        EngineFormatter formatter = new EngineFormatter();
        while (!engine.isWinGame() && !engine.isLossGame()) {
            System.out.println(formatter.format(engine));
            try {
                engine.suggestLetter(nextLetter());
            } catch (IllegalLetterException e) {
                System.err.println("Неверный символ или формат");
            }
        }
        System.out.println(formatter.format(engine));
    }
    
    private String nextLetter() {
        System.out.print("Введите следующий символ: ");
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }
}
