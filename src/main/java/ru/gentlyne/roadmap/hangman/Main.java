package ru.gentlyne.roadmap.hangman;

import java.util.Scanner;

public class Main {
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);  
        System.out.println("����, ����� ���������� � ���� \"��������\"");
        int choose = 0;
        while (choose != 2) {
            System.out.println("[1] ������ ����");
            System.out.println("[2] �����");
            System.out.print("������� �����: ");
            
            choose = scanner.nextInt();
            
            
            if (choose == 1) {
                Game game = new Game();
                game.start();
            } else if (choose == 2) {
                System.out.println("����� ����, ����!");
            } else {
                System.err.println("��� ������ ������. ��������� ��� ���!");
            }
        }
        scanner.close();
    }
}