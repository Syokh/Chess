import java.util.Map;

/**
 * Created by Syokh Vitalii on 24.11.14.
 */
public abstract class Figures {
    int x;
    int y;
    String color;
    String name;

    abstract public boolean isMoveAvailable(Map<Figures, String> hashMap, int x1, int y1);

    abstract public String getName();

    abstract public String getColor();

    public boolean checkPawn(Map<Figures, String> hashMap, int x1, int y1) {
        boolean T = false;
        for (Figures white : hashMap.keySet()) {
            if (x1 == white.getX() && y1 == white.getY()) {
                if (white.getColor() == this.color) {
                    T = false;
                } else T = true;
            }
        }
        return T;
    }

    public boolean checkMoves(Map<Figures, String> hashMap, int x1, int y1) {
        boolean T = true;
        for (Figures white : hashMap.keySet()) {
            if (x1 == white.getX() && y1 == white.getY()) {
                if (white.getColor() == this.color) {
                    T = false;
                } else T = true;
            }
        }
        return T;
    }

    public boolean checkRook(Map<Figures, String> hashMap, int x1, int y1) {
        boolean T = true;
        for (int i = this.y + 1; i < y1; i++) {
            for (Figures white : hashMap.keySet()) {
                if (x1 == white.getX() && i == white.getY()) T = false;
            }
        }
        for (int i = this.y - 1; i > y1; i--) {
            for (Figures white : hashMap.keySet()) {
                if (x1 == white.getX() && i == white.getY()) T = false;
            }
        }
        for (int i = this.x + 1; i < x1; i++) {
            for (Figures white : hashMap.keySet()) {
                if (i == white.getX() && y1 == white.getY()) T = false;
            }
        }
        for (int i = this.x - 1; i > x1; i--) {
            for (Figures white : hashMap.keySet()) {
                if (i == white.getX() && y1 == white.getY()) T = false;
            }
        }
        return T;
    }

    public boolean checkBishop(Map<Figures, String> hashMap, int x1, int y1) {
        boolean T = true;

        int j = this.y + 1;
        for (int i = this.x + 1; i < x1 && this.y < y1; i++) {
            for (Figures white : hashMap.keySet()) {
                if (i == white.getX() && j == white.getY()) {
                    T = false;
                }
            }
            j = j + 1;
        }
        int t = this.y - 1;
        for (int p = this.x - 1; p > x1 && this.y > y1; p--) {
            for (Figures white : hashMap.keySet()) {
                if (p == white.getX() && t == white.getY()) {
                    T = false;
                }
            }
            t = t - 1;
        }
        int o = this.x + 1;
        for (int k = this.y - 1; k > y1 && this.x < x1; k--) {
            for (Figures white : hashMap.keySet()) {
                if (o == white.getX() && k == white.getY()) {
                    T = false;
                }
            }
            o = o + 1;
        }
        int m = this.x - 1;
        for (int n = this.y + 1; n < y1 && this.x > x1; n++) {
            for (Figures white : hashMap.keySet()) {
                if (m == white.getX() && n == white.getY()) {
                    T = false;
                }
            }
            m = m + 1;
        }
        return T;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }
}
