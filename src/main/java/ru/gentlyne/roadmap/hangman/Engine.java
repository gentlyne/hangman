package ru.gentlyne.roadmap.hangman;

import java.util.*;

public class Engine {
    
    public static final int LENGTH_WORST_CHARS = 6;

    private final String[] poolWords;
    private final Set<Character> worstChars = new HashSet<>(LENGTH_WORST_CHARS);
    private String hiddenWord;
    private char[] guessedChars;

    public Engine(String[] poolWords) {
        this.poolWords = poolWords;
    }

    public void reset() {
        Random random = new Random(System.currentTimeMillis());
        this.hiddenWord = poolWords[random.nextInt(poolWords.length)].toLowerCase();
        this.guessedChars = new char[this.hiddenWord.length()];
        Arrays.fill(this.guessedChars, '_');
        worstChars.clear();
    }

    public boolean isWinGame() {
        return hiddenWord.equals(getGuessedLetter());
    }
    
    public boolean isLossGame() {
        return worstChars.size() >= LENGTH_WORST_CHARS;
    }

    public boolean isEndGame() {
        return isLossGame() || isWinGame();
    }
    
    public void suggestLetter(String input) {
        if (input.length() != 1) {
            throw new IllegalLetterException();
        }
        suggestLetter(input.charAt(0));
    }
    
    public void suggestLetter(Character input) {
        if (!Character.isLetter(input) || ! Character.isLowerCase(input)) {
            throw new IllegalLetterException();
        }

        int index = hiddenWord.indexOf(input);
        if (index == -1) {
            worstChars.add(input);
        } else {
            while (index > -1) {
                guessedChars[index] = input;
                index = hiddenWord.indexOf(input, index + 1);
            }            
        }
    }

    public String getGuessedLetter() {
        return new String(guessedChars);
    }

    public Set<Character> getWorstChars() {
        return worstChars;
    }

    public String getAnswer() {
      if (!isEndGame()) {
          throw new GameNotFinishedException();
      }
      return hiddenWord;
    }
}
