package ru.gentlyne.roadmap.hangman;

import java.util.Random;

public class Engine {
    
    public static final int LENGTH_WORST_CHARS = 6;
    
    private String hiddenWord;
    private char[] hiddenChars;
    private char[] worstChars = new char[LENGTH_WORST_CHARS];
    private int countWorstChars = 0;
    
    public Engine(String[] poolWords) {
        Random random = new Random(System.currentTimeMillis());
        this.hiddenWord = poolWords[random.nextInt(poolWords.length)].toUpperCase();
        this.hiddenChars = "_".repeat(this.hiddenWord.length()).toCharArray();
    }
    
    public boolean isWinGame() {
        return hiddenWord.equals(new String(hiddenChars));
    }
    
    public boolean isLossGame() {
        return countWorstChars >= LENGTH_WORST_CHARS;
    }
    
    public void suggestLetter(String input) {
        if (input.length() != 1 || !Character.isLetter(input.charAt(0))) {
            throw new IllegalLetterException();
        }
        
        String letter = input.toUpperCase();
        
        if (hiddenWord.contains(letter)) {
            int index = hiddenWord.indexOf(letter);
            while (index > -1) {
                hiddenChars[index] = letter.charAt(0);
                index = hiddenWord.indexOf(letter, index + 1);
            }
        } else {
            worstChars[countWorstChars] = letter.charAt(0);
            countWorstChars++;
        }
    }

    public char[] getHiddenChars() {
        return hiddenChars;
    }
    
    public int getCountWorstChars() {
        return countWorstChars;
    }
   
}
