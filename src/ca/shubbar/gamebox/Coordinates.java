package ca.shubbar.gamebox;

import java.util.Objects;

/**
 * @author Mustafa <codingbox@outlook.com>
 * Created at 2021-08-02
 */
public class Coordinates {
    private final int x;
    private final int y;

    public Coordinates(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    @Override
    public boolean equals(Object obj) {
        if(this == obj) return true;
        if(obj == null || getClass() != obj.getClass()) return false;
        Coordinates that = (Coordinates) obj;
        return x == that.x && y == that.y;
    }

    // Return a unique identifier for our coordinates
    @Override
    public int hashCode(){
        return Objects.hash(x, y);
    }
}
