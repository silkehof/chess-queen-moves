/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.program;

import java.util.HashMap;
import java.util.Scanner;

/**
 *
 * @author s.hofmann
 */
public class Program {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        HashMap<String, Integer> strToNum = new HashMap<>();
        strToNum.put("A", 1);
        strToNum.put("B", 2);
        strToNum.put("C", 3);
        strToNum.put("D", 4);
        strToNum.put("E", 5);
        strToNum.put("F", 6);
        strToNum.put("G", 7);
        strToNum.put("H", 8);

        int x = 0;
        int y = 0;
        int newX = 0;
        int newY = 0;
        boolean ok = false;

        System.out.println("Is the queen's move valid?");
        System.out.println("Enter all positions in the format 'H1'.");
        System.out.println("- - - - - - - - - - - - - - - - - - - - - - - - -");
        System.out.print("Enter the queen's current position on the board: ");

        while (!ok) {
            try {
                String pos = scanner.nextLine();
                String[] posParts = pos.split("");
                x = strToNum.get(posParts[0]);
                y = Integer.valueOf(posParts[1]);
                if (y >= 1 && y <= 8 && posParts.length == 2) {
                    ok = true;
                } else {
                    System.out.print("Only numbers 1-8 allowed - try again: ");
                }
            } catch (Exception e) {
                System.out.print("Invalid format - try again: ");
            }
        }

        ok = false;
        System.out.print("Enter the queen's target position: ");

        while (!ok) {
            try {
                String newPos = scanner.nextLine();
                newX = strToNum.get(newPos.split("")[0]);
                newY = Integer.valueOf(newPos.split("")[1]);
                if (newY >= 1 && newY <= 8) {
                    ok = true;
                } else {
                    System.out.print("Only numbers 1-8 allowed - try again: ");
                }
            } catch (Exception e) {
                System.out.print("Only letters A-H allowed - try again: ");
            }
        }

        System.out.println();
        if (isValidMove(x, y, newX, newY)) {
            System.out.println("The move is valid!");
        } else {
            System.out.println("The move is invalid.");
        }
    }

    public static boolean isValidMove(int x, int y, int newX, int newY) {
        // positions are the same, invalid move - optional check!
        if (x == newX && y == newY) {
            return false;
        }
        // queen moves up, down, right or left, valid move
        if (x == newX || y == newY) {
            return true;
        }
        // queen moves diagonally, valid move
        return Math.abs(newX - x) == Math.abs(newY - y);
    }
}
