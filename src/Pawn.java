import java.util.Map;

/**
 * Created by Syokh Vitalii on 23.11.14.
 */
public class Pawn extends Figures {
    public boolean isMoveAvailable(Map<Figures, String> hashMap, int x1, int y1) {
        boolean T = false;
        if (this.x >= 0 && this.x < 8 && this.y >= 0 && this.y < 8 && x1 >= 0 && x1 < 8 && y1 >= 0 && y1 < 8) {
            int ay1 = this.y + 1;
            int ay2 = this.y - 1;

            if (this.color == "white") {

                if (this.x == x1 && 4 == y1) {
                    T = true;
                    for (Figures white : hashMap.keySet()) {
                        if (x1 == white.getX() && 5 == white.getY()) T = false;
                    }
                    for (Figures white : hashMap.keySet()) {
                        if (x1 == white.getX() && y1 == white.getY()) T = false;
                    }
                }
                if (this.x == x1 && ay2 == y1) {
                    T = true;
                    for (Figures white : hashMap.keySet()) {
                        if (x1 == white.getX() && y1 == white.getY()) T = false;
                    }
                }
                int ax1 = this.x + 1;
                int ax2 = this.x - 1;
                if (ax1 == x1 && y1 == ay2 ) {
                    T =  checkPawn(hashMap, x1, y1);
                }
                if (ax2 == x1 && y1 == ay2) {
                    T = checkPawn(hashMap, x1, y1);
                }
            } else {
                if (this.x == x1 && 3 == y1) {
                    T = true;
                    for (Figures white : hashMap.keySet()) {
                        if (x1 == white.getX() && 2 == white.getY()) T = false;
                    }
                    for (Figures white : hashMap.keySet()) {
                        if (x1 == white.getX() && y1 == white.getY()) T = false;
                    }
                }
                if (this.x == x1 && ay1 == y1) {
                    T = true;
                    for (Figures white : hashMap.keySet()) {
                        if (x1 == white.getX() && y1 == white.getY()) T = false;
                    }
                }
                int ax1 = this.x + 1;
                int ax2 = this.x - 1;
                if (ax1 == x1 && y1 == ay1) {
                    T = checkPawn(hashMap, x1, y1);
                }
                if (ax2 == x1 && y1 == ay1) {
                    T = checkPawn(hashMap, x1, y1);
                }
            }
        }
        return T;
    }

    public Pawn(int x, int y, String color, String name) {
        this.x = x;
        this.y = y;
        this.color = color;
        this.name = name;
    }

    @Override
    public String getName() {return name; }

    @Override
    public String getColor() { return color; }

    public int getX() { return x; }

    public void setX(int x) { this.x = x; }

    public int getY() { return y; }

    public void setY(int y) { this.y = y; }
}
