package New;

public class Assignemnt1 {

    public static void main(String[] args) {

        int m = 100, n = 100, m1 = 100, n1 = 100, lower, higher,
                c, d, i, j, k, l, random,
                sum = 0;
        long startTime, stopTime, elapsedTime = 0;

        for (int x = 0; x < 10000; x++) {

            int A[][] = new int[m][n];
            int B[][] = new int[m1][n1];

            int Mul[][] = new int[10000][10000];

            for (i = 0; i < m; i++) {
                for (j = 0; j < n; j++) {
                    random = 1 + (int) (Math.random() * 10);
                    A[i][j] = random;
                }
            }

            for (i = 0; i < m1; i++) {
                for (j = 0; j < n1; j++) {
                    random = 1 + (int) (Math.random() * 10);
                    B[i][j] = random;
                }
            }
            if (n != m1) {
                System.out.println("Dimensions do not match for multiplication!");

            } else {
                startTime = System.nanoTime();

                for (c = 0; c < m; c++) {
                    for (d = 0; d < n1; d++) {
                        for (k = 0; k < m1; k++) {
                            sum = sum + A[c][k] * B[k][d];
                        }
                        Mul[c][d] = sum;
                        sum = 0;
                    }
                }

                stopTime = System.nanoTime();
                elapsedTime = stopTime - startTime;
            }

            System.out.println(m + "--->" + elapsedTime);
            m = m + 100;
            n = n + 100;
            m1 = m1 + 100;
            n1 = n1 + 100;
           
        }
    }

}
