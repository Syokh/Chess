import java.util.Map;

/**
 * Created by Syokh Vitalii on 23.11.14.
 */
public class King extends Figures {
    public boolean isMoveAvailable(Map<Figures, String> hashMap, int x1, int y1) {
        boolean T = false;
        if (this.x >= 0 && this.x < 8 && this.y >= 0 && this.y < 8 && x1 >= 0 && x1 < 8 && y1 >= 0 && y1 < 8) {
            int ax = this.x - 1;
            int ay = this.y - 1;
            int ax1 = this.x + 1;
            int ay1 = this.y + 1;

            if (this.x == x1 && ay == y1) {
                T = true;
            }
            if (ax == x1 && ay == y1) {
                T = true;
            }
            if (ax == x1 && this.y == y1) {
                T = true;
            }
            if (ax == x1 && ay1 == y1) {
                T = true;
            }
            if (this.x == x1 && ay1 == y1) {
                T = true;
            }
            if (ax1 == x1 && ay1 == y1) {
                T = true;
            }
            if (ax1 == x1 && this.y == y1) {
                T = true;
            }
            if (ax1 == x1 && ay == y1) {
                T = true;
            }
            if (T == true) {
                T = checkMoves(hashMap, x1, y1);
            }
        }
        return T;
    }

    public King(int x, int y, String color, String name) {
        this.x = x;
        this.y = y;
        this.color = color;
        this.name = name;
    }

    public int getX() { return x; }

    public void setX(int x) { this.x = x; }

    public int getY() { return y; }

    public void setY(int y) {
        this.y = y;
    }

    @Override
    public String getName() { return name; }

    @Override
    public String getColor() { return color;}
}
