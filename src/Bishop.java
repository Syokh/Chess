import java.util.Map;

/**
 * Created by Syokh Vitalii on 22.11.14.
 */
public class Bishop extends Figures {
    public boolean isMoveAvailable(Map<Figures, String> hashMap, int x1, int y1) {
        boolean T = false;
        if (this.x >= 0 && this.x < 8 && this.y >= 0 && this.y < 8 && x1 >= 0 && x1 < 8 && y1 >= 0 && y1 < 8) {

            int ax = 0;
            int ay = 0;

            for (int i = this.x; i < x1; i++) {
                ax +=  1;
            }
            for (int i = this.x; i > x1; i--) {
                ax +=  1;
            }
            for (int i = this.y; i > y1; i--) {
                ay +=  1;
            }
            for (int i = this.y; i < y1; i++) {
                ay +=  1;
            }
            if (ax == ay){
                T = checkBishop(hashMap, x1, y1);
                if (T == true){
                   T = checkMoves(hashMap, x1, y1);
                }
            }
        }
        return T;
    }

    @Override
    public String getName() { return name; }

    public Bishop(int x, int y, String color, String name) {
        this.x = x;
        this.y = y;
        this.color = color;
        this.name = name;
    }

    @Override
    public String getColor() {return color; }

    public int getX() { return x; }

    public void setX(int x) { this.x = x; }

    public int getY() { return y; }

    public void setY(int y) { this.y = y; }
}
/**
 * Comment in Master
 */