/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algos_assignment_3.pkg1;

/**
 *
 * @author Mugdha
 */
public class Simple {

    int Mul[][] = new int[10][10];
    int a[][] = new int[10][10];
    int b[][] = new int[10][10];
    public void simple(int m) {
        int i, j, k, l, c, d, random, sum = 0;
        for (i = 0; i < m; i++) {
            for (j = 0; j < m; j++) {
                random = 1 + (int) (Math.random() * 10);
                a[i][j] = random;
            }
        }

        for (i = 0; i < m; i++) {
            for (j = 0; j < m; j++) {
                random = 1 + (int) (Math.random() * 10);
                b[i][j] = random;
            }
        }
        String str = "|\t";
        System.out.println("Matrix a");

        for (i = 0; i < m; i++) {
            for (j = 0; j < m; j++) {
                str += a[i][j] + "\t";
            }
            System.out.println(str + "|");
            str = "|\t";
        }
        System.out.println("************************************");

        String str1 = "|\t";
        System.out.println("Matrix b");

        for (k = 0; k < m; k++) {
            for (l = 0; l < m; l++) {
                str1 += b[k][l] + "\t";
            }
            System.out.println(str1 + "|");
            str1 = "|\t";
        }

        for (c = 0; c < m; c++) {
            for (d = 0; d < m; d++) {
                for (k = 0; k < m; k++) {
                    sum = sum + a[c][k] * b[k][d];
                }
                Mul[c][d] = sum;
                sum = 0;
            }
        }
       
        System.out.println("\n\nProduct of entered matrices:-");
        
        for (c = 0; c < m; c++) {
                for (d = 0; d < m; d++) {
                    System.out.print(Mul[c][d] + "\t");
                }
                System.out.print("\n");
            }
    }
}
