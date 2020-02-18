import java.util.Arrays;
import java.util.Random;

/**
 * TODO: Testing
 * 
 */
class Matrix {
    public static void main(String[] args) {
        // assume correct format mxn nxp = mxp
        // where n=n
        //set m n and p first
        int m = 5;
        int n = 700;
        int p = 900;
        Random rand = new Random();

        // [0].length column
        // .length row

        // m can be the thread maker
        // a will be the copy and b will be the pass
        // c can be the synchronized put

        // 5x2 3x4
        // float[][] a = { { 5, 2, 1 }, { 4, 5, 2 }, { 1, 2, 3 }, { 4, 5, 3 }, { 1, 2, 4 } };
        // float[][] b = { { 3, 4, 3, 4 }, { 6, 2, 3, 4 }, { 2, 2, 1, 7 } };

        //randomize arrays
        float[][] a = new float[m][n];
        float[][] b = new float[n][p];
        
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a[i].length; j++) {
                a[i][j] = rand.nextInt(1000);
            }
        }
        for (int i = 0; i < b.length; i++) {
            for (int j = 0; j < b[i].length; j++) {
                b[i][j] = rand.nextInt(1000);
            }
        }

        float[][] c = new float[m][p];
        Sol solution = new Sol(c);

         // test with formula using 1 thread
         Long start = System.nanoTime();
         c = multiplyMatrix(a, b, c, m, n, p);
         System.out.println("Time with 1 thread: " + (System.nanoTime()-start)/1000F);

         //test with multiple threads
        Thread[] threads = new Thread[m];

        // prep threads
        for (int i = 0; i < m; i++) {
            float[] a1 = new float[a[0].length];
            System.arraycopy(a[i], 0, a1, 0, a[i].length);
            // System.out.println(Arrays.toString(a1));
            //System.out.println("Thread start!");
            threads[i] = new Thread(new Matrices(a1, b, m, n, p, i, solution));
        }
        // start threads & timer
        long strt = System.nanoTime();
        for (Thread th : threads) {
            th.start();
        }
        // wait for each to finishing joining
        for (Thread th : threads) {
            try {
                th.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        // print out time
        System.out.println("Time with " + m + " thread: " + (System.nanoTime() - strt) / 1000F);
    }

    public static float[][] multiplyMatrix(float[][] a, float[][] b, float[][] c, int m, int n, int p) {

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < p; j++) {
                for (int k = 0; k < n; k++) {
                    c[i][j] += a[i][k] * b[k][j];
                }
            }
        }
        return c;
    }
}