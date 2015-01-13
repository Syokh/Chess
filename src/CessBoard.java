import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.image.BufferedImage;
import java.net.URL;

/**
 * Created by Syokh Vitalii on 02.12.14.
 */
public class CessBoard extends JFrame implements MouseMotionListener, MouseListener {

    JLayeredPane layeredPane;
    JPanel chessBoard;
    JPanel[][] square = new JPanel[8][8];
    private Image[][] chessPieceImages = new Image[2][6];
    CHESS chess = CHESS.getInstance();

    public CessBoard() {
        createImages();
        setTitle("Chess");
        chess.setHashMap();
        Dimension boardSize = new Dimension(512, 512);
        layeredPane = new JLayeredPane();
        getContentPane().add(layeredPane);

        layeredPane.setPreferredSize(boardSize);
        layeredPane.addMouseListener(this);
        layeredPane.addMouseMotionListener(this);
        chessBoard = new JPanel();

        layeredPane.add(chessBoard, JLayeredPane.DEFAULT_LAYER);
        chessBoard.setLayout(new GridLayout(8, 8));
        chessBoard.setPreferredSize(boardSize);
        chessBoard.setBounds(0, 0, boardSize.width, boardSize.height);
        int c = 0;
        int f = 0;
        for (int a = f; a < 8; a++) {
            for (int b = c; b < 8; b++) {
                square[a][b] = new JPanel();

                if ((a + b) % 2 == 0) {
                    square[a][b].setBackground(new Color(238, 221, 187));
                } else {
                    square[a][b].setBackground(new Color(204, 136, 68));
                }
                chessBoard.add(square[a][b]);
            }
        }


        square[0][0].add(new JLabel(new ImageIcon(chessPieceImages[0][2])));
        square[0][1].add(new JLabel(new ImageIcon(chessPieceImages[0][3])));
        square[0][2].add(new JLabel(new ImageIcon(chessPieceImages[0][4])));
        square[0][3].add(new JLabel(new ImageIcon(chessPieceImages[0][1])));
        square[0][4].add(new JLabel(new ImageIcon(chessPieceImages[0][0])));
        square[0][5].add(new JLabel(new ImageIcon(chessPieceImages[0][4])));
        square[0][6].add(new JLabel(new ImageIcon(chessPieceImages[0][3])));
        square[0][7].add(new JLabel(new ImageIcon(chessPieceImages[0][2])));

        square[1][0].add(new JLabel(new ImageIcon(chessPieceImages[0][5])));
        square[1][1].add(new JLabel(new ImageIcon(chessPieceImages[0][5])));
        square[1][2].add(new JLabel(new ImageIcon(chessPieceImages[0][5])));
        square[1][3].add(new JLabel(new ImageIcon(chessPieceImages[0][5])));
        square[1][4].add(new JLabel(new ImageIcon(chessPieceImages[0][5])));
        square[1][5].add(new JLabel(new ImageIcon(chessPieceImages[0][5])));
        square[1][6].add(new JLabel(new ImageIcon(chessPieceImages[0][5])));
        square[1][7].add(new JLabel(new ImageIcon(chessPieceImages[0][5])));

        square[6][0].add(new JLabel(new ImageIcon(chessPieceImages[1][5])));
        square[6][1].add(new JLabel(new ImageIcon(chessPieceImages[1][5])));
        square[6][2].add(new JLabel(new ImageIcon(chessPieceImages[1][5])));
        square[6][3].add(new JLabel(new ImageIcon(chessPieceImages[1][5])));
        square[6][4].add(new JLabel(new ImageIcon(chessPieceImages[1][5])));
        square[6][5].add(new JLabel(new ImageIcon(chessPieceImages[1][5])));
        square[6][6].add(new JLabel(new ImageIcon(chessPieceImages[1][5])));
        square[6][7].add(new JLabel(new ImageIcon(chessPieceImages[1][5])));

        square[7][0].add(new JLabel(new ImageIcon(chessPieceImages[1][2])));
        square[7][1].add(new JLabel(new ImageIcon(chessPieceImages[1][3])));
        square[7][2].add(new JLabel(new ImageIcon(chessPieceImages[1][4])));
        square[7][3].add(new JLabel(new ImageIcon(chessPieceImages[1][1])));
        square[7][4].add(new JLabel(new ImageIcon(chessPieceImages[1][0])));
        square[7][5].add(new JLabel(new ImageIcon(chessPieceImages[1][4])));
        square[7][6].add(new JLabel(new ImageIcon(chessPieceImages[1][3])));
        square[7][7].add(new JLabel(new ImageIcon(chessPieceImages[1][2])));
    }

    private final void createImages() {
        try {
            URL url = new URL("http://i.stack.imgur.com/memI0.png");
            BufferedImage bi = ImageIO.read(url);
            for (int ii = 0; ii < 2; ii++) {
                for (int jj = 0; jj < 6; jj++) {
                    chessPieceImages[ii][jj] = bi.getSubimage(
                            jj * 64, ii * 64, 64, 64);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.exit(1);
        }
    }


    int xAdjustment;
    int yAdjustment;
    JLabel chessPiece;
    String nameFi = "";
    String color = "";
    boolean Flag = true;
    boolean Flag2 = true;

    public void mousePressed(MouseEvent e) {
        chessPiece = null;
        Component c = chessBoard.findComponentAt(e.getX(), e.getY());

        if (c instanceof JPanel) return;

        Point parentLocation = c.getParent().getLocation();
        xAdjustment = parentLocation.x - e.getX();
        yAdjustment = parentLocation.y - e.getY();
        chessPiece = (JLabel) c;
        chessPiece.setLocation(e.getX(), e.getY());
        chessPiece.setSize(chessPiece.getWidth(), chessPiece.getHeight());
        layeredPane.add(chessPiece, JLayeredPane.DRAG_LAYER);

        int x1 = e.getX() / 64;
        int y1 = e.getY() / 64;
        for (Figures figure : chess.getHashMap().keySet()) {
            if (figure.getX() == x1 && figure.getY() == y1) {
                nameFi = figure.getName();
                color = figure.getColor();
                System.out.println(figure.getName() + " " + figure.getColor());
            }
        }
    }

    public void mouseDragged(MouseEvent me) {
        if (chessPiece == null) return;
        chessPiece.setLocation(me.getX() + xAdjustment, me.getY() + yAdjustment);
    }

    public void mouseReleased(MouseEvent e) {
        int x1 = e.getX() / 64;
        int y1 = e.getY() / 64;
        boolean T = false;

        if (color.equals("white") && Flag2 == true) {
            T = chess.gamePieces(chess.getHashMap(), nameFi, color, x1, y1);
            if(T){
               chess.removeFigure(chess.getHashMap(), color, x1, y1);
            }
            Flag = false;
        } else if (color.equals("black") && Flag2 == false) {
            T = chess.gamePieces(chess.getHashMap(), nameFi, color, x1, y1);
            if (T){
               chess.removeFigure(chess.getHashMap(), color, x1, y1);
            }
            Flag = true;
        }

        if (T == true) {
            if (chessPiece == null) return;
            chessPiece.setVisible(false);
            Component c = chessBoard.findComponentAt(e.getX(), e.getY());

            if (c instanceof JLabel) {
                Container parent = c.getParent();
                parent.remove(c);
                parent.validate();
                parent.repaint();
                parent.add(chessPiece);

            } else {

                Container parent = (Container) c;
                parent.remove(c);
                parent.validate();
                parent.repaint();
                parent.add(chessPiece);

            }
            chessPiece.setVisible(true);
            if (Flag == true) {
                Flag2 = true;
            }
            if (Flag == false) {
                Flag2 = false;
            }

        } else {
            for (Figures white : chess.getHashMap().keySet()) {
                if (white.getName() == nameFi) {
                    int i = white.getX() * 64;
                    int j = white.getY() * 64;
                    if (chessPiece == null) return;
                    chessPiece.setVisible(false);
                    Component c = chessBoard.findComponentAt(i, j);

                    if (c instanceof JLabel) {
                        Container parent = c.getParent();
                        parent.remove(0);
                        parent.add(chessPiece);
                    } else {
                        Container parent = (Container) c;
                        parent.add(chessPiece);
                    }
                    chessPiece.setVisible(true);
                }
            }
        }
    }

    @Override
    public void mouseClicked(MouseEvent e) {
    }

    @Override
    public void mouseEntered(MouseEvent e) {
    }

    @Override
    public void mouseExited(MouseEvent e) {
    }

    @Override
    public void mouseMoved(MouseEvent e) {
    }
}
