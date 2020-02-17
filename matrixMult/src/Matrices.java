public class Matrices implements Runnable{
    private float[] a;
    private float[][] b;
    private Sol s;
    private int m;
    private int n;
    private int p;
    private int index;
    
    public Matrices(float[] a, float[][] b, int m, int n, int p, int ind ,Sol s){
        this.a = a;
        this.b = b;
        this.m = m;
        this.n = n;
        this.p = p;
        this.s = s;
        this.index = ind;
    }

    @Override
    public void run() {
        for(int i = 0; i < p; i++) {
            for (int j = 0; j < n; j++) {
                s.put(index , i, a[j] * b[j][i]);
            }
        }
    }
}