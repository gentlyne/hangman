package ru.gentlyne.roadmap.hangman;

import java.util.Set;

public class EngineFormatter {
    
    private final String[] hangmanPics = {"""
           ═╤═══╗
            │   ║
                ║
                ║
                ║
                ║
          ══════╩══""", """
           ═╤═══╗
            │   ║
            O   ║
                ║
                ║
                ║
          ══════╩══""", """
           ═╤═══╗
            │   ║
            O   ║
            |   ║
                ║
                ║
          ══════╩══""", """
           ═╤═══╗
            │   ║
            O   ║
           /│   ║
                ║
                ║
          ══════╩══""", """
           ═╤═══╗
            │   ║
            O   ║
           /│\\  ║
                ║
                ║
          ══════╩══""", """
           ═╤═══╗
            │   ║
            O   ║
           /│\\  ║
           /    ║
                ║
          ══════╩══""", """
           ═╤═══╗
            │   ║
            O   ║
           /│\\  ║
           / \\  ║
                ║
          ══════╩══"""};

    public String format(Engine engine) {
        StringBuffer result = new StringBuffer(); 
        
        formatGame(result, engine);
        formatWinGame(result, engine);
        formatLossGame(result, engine);
        
        return result.toString();
    }
    
    private void formatWinGame(StringBuffer result, Engine engine) {
        if (!engine.isWinGame()) {
            return ;
        }
        result.append("Вы совершенно правы. Это - ")
                .append(engine.getAnswer().toUpperCase())
                .append(System.lineSeparator())
                .append("У нас есть победитель. Хотите сыграть ещё?")
                .append(System.lineSeparator());
    }
    
    private void formatLossGame(StringBuffer result, Engine engine) {
        if (!engine.isLossGame()) {
            return ;
        }
        result.append("Сожалею, вы проиграли. Загаданное слово было: ")
                .append(engine.getAnswer().toUpperCase())
                .append(System.lineSeparator());
    }
    
    private void formatGame(StringBuffer result, Engine engine) {
        formatGuessedLetters(result, engine);
        formatHangman(result, engine);
        formatErrors(result, engine);
    }
    
    private void formatGuessedLetters(StringBuffer result, Engine engine) {
        String[] guessedString = engine.getGuessedLetter().toUpperCase().split("");
        result.append(String.join(" ", guessedString))
                .append(System.lineSeparator());
    }
    
    private void formatHangman(StringBuffer result, Engine engine) {
        result.append(hangmanPics[engine.getWorstChars().size()])
                .append(System.lineSeparator());
    }
    
    private void formatErrors(StringBuffer result, Engine engine) {
        Set<Character> worstChars = engine.getWorstChars();
        result.append("Ошибок: ")
                .append(worstChars.size())
                .append(" - {")
                .append(String.join(", ", worstChars.stream().map(String::valueOf).toArray(String[]::new)))
                .append("}")
                .append(System.lineSeparator());
    }
}
