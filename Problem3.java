
package data.structures;


public class Problem3 {

    public static void main(String[] args) {
     
        double[] doubleArray = new double[100000];
        long startTime = System.currentTimeMillis();
        prefixAverage1(doubleArray);
        long endTime = System.currentTimeMillis();
        long elapsed = endTime - startTime;
        System.out.println(elapsed);

        startTime = System.currentTimeMillis();
        prefixAverage2(doubleArray);
        endTime = System.currentTimeMillis();
        elapsed = endTime - startTime;
        System.out.println(elapsed);

    }

    public static double[] prefixAverage1(double[] x) {
        int n = x.length;
        double[] a = new double[n];
        for (int j = 0; j < n; j++) {
            double total = 0;
            for (int i = 0; i <= j; i++) {
                total += x[i];
            }
            a[j] = total / (j + 1);

        }

        return a;

    }

    public static double[] prefixAverage2(double[] x) {
        int n = x.length;
        double[] a = new double[n];
        double total = 0;
        for (int j = 0; j < n; j++) {
            total += x[j];
            a[j] = total / (j + 1);
        }
        return a;

    }

}
