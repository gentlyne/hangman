package ru.gentlyne.roadmap.hangman;

import java.util.*;

public class Engine {
    
    public static final int LENGTH_WORST_CHARS = 6;
    
    private final String hiddenWord;
    private final char[] guessedChars;
    private final List<Character> worstChars = new ArrayList<>(LENGTH_WORST_CHARS);
    
    public Engine(String[] poolWords) {
        Random random = new Random(System.currentTimeMillis());
        this.hiddenWord = poolWords[random.nextInt(poolWords.length)].toLowerCase();
        this.guessedChars = new char[this.hiddenWord.length()];
        Arrays.fill(this.guessedChars, '_');
    }
    
    public boolean isWinGame() {
        return hiddenWord.equals(getGuessedLetter());
    }
    
    public boolean isLossGame() {
        return worstChars.size() >= LENGTH_WORST_CHARS;
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
        if (index == -1 && !worstChars.contains(input)) {
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
    
    public int getCountWorstChars() {
        return worstChars.size();
    }
   
}
