import java.util.Arrays;

public class Sol{
    public float[][] c;

    public Sol(float[][] c){
        this.c = c;
    }
    public synchronized void put(int r, int col, float value){
        c[r][col] += value;
        //System.out.println(Arrays.deepToString(c));
    }
}