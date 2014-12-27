import javax.swing.*;
import java.awt.*;
import java.util.*;

/**
 * Created by Syokh Vitalii on 22.11.14.
 */
public class CHESS  {
    public static CHESS instance = new CHESS();
    private Map<Figures, String> hashMap = new HashMap<Figures, String>();
    private CHESS (){}

    public static CHESS getInstance(){
        if(instance == null){
            instance =new CHESS();
        }
        return instance;
    }

    public static Figures kingBlack = new King(4, 0, "black", "KingB");
    public static Figures kingWhite = new King(4, 7, "white", "KingW");

    public static Figures queenBlack = new Queen(3, 0, "black", "QueenB");
    public static Figures queenWhite = new Queen(3, 7, "white", "QueenW");

    public static Figures kightBlack1 = new Knight(1, 0, "black", "KingLb");
    public static Figures kightBlack2 = new Knight(6, 0, "black", "KingRb");
    public static Figures kightWhite1 = new Knight(1, 7, "white", "KingLw");
    public static Figures kightWhite2 = new Knight(6, 7, "white", "KingRw");

    public static Figures rookBlack1 = new Rook(0, 0, "black", "RookLb");
    public static Figures rookBlack2 = new Rook(7, 0, "black", "RookRb");
    public static Figures rookWhite1 = new Rook(0, 7, "white", "RookLw");
    public static Figures rookWhite2 = new Rook(7, 7, "white", "RookRw");

    public static Figures bishopBlack1 = new Bishop(2, 0, "black", "BishopLb");
    public static Figures bishopBlack2 = new Bishop(5, 0, "black", "BishopRb");
    public static Figures bishopWhite1 = new Bishop(2, 7, "white", "BishopLw");
    public static Figures bishopWhite2 = new Bishop(5, 7, "white", "BishopRw");

    public static Figures pawnBlack1 = new Pawn(0, 1, "black", "PawnB1");
    public static Figures pawnBlack2 = new Pawn(1, 1, "black", "PawnB2");
    public static Figures pawnBlack3 = new Pawn(2, 1, "black", "PawnB3");
    public static Figures pawnBlack4 = new Pawn(3, 1, "black", "PawnB4");
    public static Figures pawnBlack5 = new Pawn(4, 1, "black", "PawnB5");
    public static Figures pawnBlack6 = new Pawn(5, 1, "black", "PawnB6");
    public static Figures pawnBlack7 = new Pawn(6, 1, "black", "PawnB7");
    public static Figures pawnBlack8 = new Pawn(7, 1, "black", "PawnB8");

    public static Figures pawnWhite1 = new Pawn(0, 6, "white", "PawnW1");
    public static Figures pawnWhite2 = new Pawn(1, 6, "white", "PawnW2");
    public static Figures pawnWhite3 = new Pawn(2, 6, "white", "PawnW3");
    public static Figures pawnWhite4 = new Pawn(3, 6, "white", "PawnW4");
    public static Figures pawnWhite5 = new Pawn(4, 6, "white", "PawnW5");
    public static Figures pawnWhite6 = new Pawn(5, 6, "white", "PawnW6");
    public static Figures pawnWhite7 = new Pawn(6, 6, "white", "PawnW7");
    public static Figures pawnWhite8 = new Pawn(7, 6, "white", "PawnW8");

    public static void main(String[] args) {
        
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                CessBoard frame = new CessBoard();
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.pack();
                frame.setResizable(false);
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);
            }
        });
    }

    public void setHashMap() {

        hashMap.put(kingBlack, kingBlack.getColor());
        hashMap.put(queenBlack, queenBlack.color);
        hashMap.put(kightBlack1, kightBlack1.color);
        hashMap.put(kightBlack2, kightBlack2.color);
        hashMap.put(rookBlack1, rookBlack1.color);
        hashMap.put(rookBlack2, rookBlack2.color);
        hashMap.put(bishopBlack1, bishopBlack1.color);
        hashMap.put(bishopBlack2, bishopBlack2.color);
        hashMap.put(pawnBlack1, pawnBlack1.color);
        hashMap.put(pawnBlack2, pawnBlack2.color);
        hashMap.put(pawnBlack3, pawnBlack3.color);
        hashMap.put(pawnBlack4, pawnBlack4.color);
        hashMap.put(pawnBlack5, pawnBlack5.color);
        hashMap.put(pawnBlack6, pawnBlack6.color);
        hashMap.put(pawnBlack7, pawnBlack7.color);
        hashMap.put(pawnBlack8, pawnBlack8.color);

        hashMap.put(kingWhite, kingWhite.color);
        hashMap.put(queenWhite, queenWhite.color);
        hashMap.put(kightWhite1, kightWhite1.color);
        hashMap.put(kightWhite2, kightWhite2.color);
        hashMap.put(rookWhite1, rookWhite1.color);
        hashMap.put(rookWhite2, rookWhite2.color);
        hashMap.put(bishopWhite1, bishopWhite1.color);
        hashMap.put(bishopWhite2, bishopWhite2.color);
        hashMap.put(pawnWhite1, pawnWhite1.color);
        hashMap.put(pawnWhite2, pawnWhite2.color);
        hashMap.put(pawnWhite3, pawnWhite3.color);
        hashMap.put(pawnWhite4, pawnWhite4.color);
        hashMap.put(pawnWhite5, pawnWhite5.color);
        hashMap.put(pawnWhite6, pawnWhite6.color);
        hashMap.put(pawnWhite7, pawnWhite7.color);
        hashMap.put(pawnWhite8, pawnWhite8.color);
    }

    public boolean gamePieces(Map<Figures, String> hashMap, String nameF, String color, int x1, int y1){
        boolean permissibleTravel = false;
        for (Figures figure : hashMap.keySet()) {
            if (figure.getName() == (nameF)) {
                permissibleTravel = figure.isMoveAvailable(hashMap, x1, y1);
            }
            if (permissibleTravel == true && figure.getName() == (nameF)) {
                figure.setX(x1);
                figure.setY(y1);
            }
        }
        return permissibleTravel;
    }

    public Figures removeFigure(Map<Figures, String> hashMaps, String color, int x1, int y1){
        Figures checkWhite = null;
        for (Figures white : hashMaps.keySet()) {
            if (x1 == white.getX() && y1 == white.getY()) {
                if (white.getColor() != color) {
                    checkWhite = white;
                }
            }
        }
        hashMap.remove(checkWhite);
        return checkWhite;
    }

    public boolean checkMoves(Map<Figures, String> hashMap, int x1, int y1){
        boolean T = false;

     return T;
    }

    public Map<Figures, String> getHashMap() {
        return hashMap;
    }
}
