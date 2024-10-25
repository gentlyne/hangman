package ru.gentlyne.roadmap.hangman;

public class EngineFormatter {
    
    private String[] hangmanPics = {"""
            +---+
            |   |
                |
                |
                |
                |
          =========""", """
            +---+
            |   |
            O   |
                |
                |
                |
          =========""", """
            +---+
            |   |
            O   |
            |   |
                |
                |
          =========""", """
            +---+
            |   |
            O   |
           /|   |
                |
                |
          =========""", """
            +---+
            |   |
            O   |
           /|\\  |
                |
                |
          =========""", """
            +---+
            |   |
            O   |
           /|\\  |
           /    |
                |
          =========""", """
            +---+
            |   |
            O   |
           /|\\  |
           / \\  |
                |
          ========="""};
    
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
        result.append("Поздравляем, вы выиграли");
        result.append(System.lineSeparator());
    }
    
    private void formatLossGame(StringBuffer result, Engine engine) {
        if (!engine.isLossGame()) {
            return ;
        }
        result.append("Сожалею, вы проиграли");
        result.append(System.lineSeparator());
    }
    
    private void formatGame(StringBuffer result, Engine engine) {
        formatGuessedLetters(result, engine);
        formatHangman(result, engine);
        formatErrors(result, engine);
    }
    
    private void formatGuessedLetters(StringBuffer result, Engine engine) {
        result.append(String.join(" ", (new String(engine.getHiddenChars()).split(""))));
        result.append(System.lineSeparator());
    }
    
    private void formatHangman(StringBuffer result, Engine engine) {
        result.append(hangmanPics[engine.getCountWorstChars()]);        
        result.append(System.lineSeparator());
    }
    
    private void formatErrors(StringBuffer result, Engine engine) {
        result.append("Ошибок: " + engine.getCountWorstChars());
        result.append(System.lineSeparator());
    }
}
