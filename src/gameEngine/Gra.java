package gameEngine;

import java.util.Random;

import okrety.advanced.Fregata;
import okrety.advanced.Korweta;
import okrety.advanced.Niszczyciel;
import okrety.basic.Ship;

public class Gra implements Graj, PrintableBoard {
    public Ship[][] board;
    private static Random random;
    private Cannon cannon;

    private void inicjalizuj(int liczbaNiszczycieli, int liczbaFregat, int liczbaKorwet) {
        random = new Random();
        board = new Ship[100][100];
        cannon = new Cannon();
        Ship.setBoard(board);
        drawShips("Niszczyciel", liczbaNiszczycieli);
        drawShips("Fregata", liczbaFregat);
        drawShips("Korweta", liczbaKorwet);

    }

    public static void main(String[] args) {
        Gra gra = new Gra();
        gra.graj(10);

    }

    public class Cannon {
        public void shoot() {
            int coordinateY = Gra.random.nextInt(100);
            int coordinateX = Gra.random.nextInt(100);
            if (board[coordinateY][coordinateX] != null) {
                board[coordinateY][coordinateX].takeHit();

            }
        }
    }

    private void drawShips(String type, int count) {
        for (int i = 0; i < count; i++) {
            int coordinateY = random.nextInt(100);
            int coordinateX = random.nextInt(100);
            if (board[coordinateY][coordinateX] != null) {
                i--;
            } else {
                board[coordinateY][coordinateX] = type == "Niszczyciel" ? new Niszczyciel(coordinateY, coordinateX)
                        : type == "Fregata" ? new Fregata(coordinateY, coordinateX)
                                : new Korweta(coordinateY, coordinateX);
            }

        }

    }

    public Gra() {
        inicjalizuj(100, 500, 1000);
    }

    public Gra(int liczbaNiszczycieli, int liczbaFregat, int liczbaKorwet) {
        inicjalizuj(liczbaNiszczycieli, liczbaFregat, liczbaKorwet);
    }

    @Override
    public void graj(int liczbaTur) {
        for (int turnNumber = 1; turnNumber <= liczbaTur; turnNumber++) {
            System.out.println("Tura nr " + turnNumber);
            for (int i = 0; i < 10; i++) {
                cannon.shoot();

            }
            PrintBoard();

        }
    }

    @Override
    public void PrintBoard() {
        for (Ship[] i : board) {
            for (Ship j : i) {
                if (j == null) {
                    System.out.print("-");
                } else {
                    System.out.print(j.getSymbol());
                }
            }
            System.out.println();
        }

    }
}
