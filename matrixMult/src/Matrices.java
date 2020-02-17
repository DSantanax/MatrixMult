public class Matrices implements Runnable{
    private float[] a;
    private float[][] b;
    private Sol s;
    private int m;
    private int n;
    private int p;
    private int index;
    /**
     * pass the C value already to place into position
     * 
     */
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
        //2x2 2x2
        //     for(int i = 0; i < m; i++){
        //         float total = 0;

        //             for(int k = 0; k < n; k++){
        //                 total = a[i] * b[k][i];
        //                 //System.out.println(total);
        //                 //must go i = 0 to k = 0, 1 2x2
        //                 s.put(index, k, total);   
        //                // c[i][j] += a[i] * b[k][j];
        //             }     
        // }
        //2x3 3x2
        for(int i = 0; i < p; i++) {
            for (int j = 0; j < n; j++) {
                //System.out.println(a[j] * b[j][i]);
                   // product[i][j] += a[i] * b[k][j];
                   // s.put(index, i, a[i] * b[j][i]);
                s.put(index , i, a[j] * b[j][i]);
            }
        }
    }
}