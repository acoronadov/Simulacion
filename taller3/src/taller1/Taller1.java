/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package taller1;

import static java.awt.SystemColor.info;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;
import javax.swing.Box;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author acoronado
 */
public class Taller1 {

    /**
     * @param args the command line arguments
     */
    static final int k = 10;
    static final int w = 32;

    public static void main(String[] args) {

        int n = 0, nf = 1, temp = 0, aux2 = 0;
        double[] x = new double[8], y = new double[8];
        int[] z = new int[8], z1 = new int[8];
        Object[] algoritmo = {"Pseudo Aleatorio", "Generador Midsquare", "Congruenciales lineales", "Fibonacci", "Wichmann", "L'Ecuyer"};

        Object opcion = JOptionPane.showInputDialog(null, "Seleccione un algoritmo", "Elegir", JOptionPane.QUESTION_MESSAGE, null, algoritmo, algoritmo[0]);

        if (opcion == algoritmo[0]) {

            x[0] = Double.parseDouble(JOptionPane.showInputDialog(null, "Ingrese un numero para generar numeros aleatorios a partir del numero ingresado: "));
            while (temp < 7) {
                n++;
                x[n] = transaction(x[n - 1]);
                y[n - 1] = exit(x[n]);
                temp++;

            }

            JOptionPane.showMessageDialog(null, "Numeros aleatorios en x " + Arrays.toString(x) + "\n" + "Numeros aleatorios en U: " + Arrays.toString(y));

        } else if (opcion == algoritmo[1]) {

            z[0] = Integer.parseInt(JOptionPane.showInputDialog(null, "Ingrese un numero para generar numeros aleatorios a partir del numero ingresado: "));
            while (temp < 7) {
                n++;
                x[n] = h(z[0]);

                temp++;

            }

            JOptionPane.showMessageDialog(null, "Numeros aleatorios en x " + Arrays.toString(x) + "\n" + "Numeros aleatorios en U: " + Arrays.toString(y));

        } else if (opcion == algoritmo[2]) {

            JTextField x1 = new JTextField(5);
            JTextField y1 = new JTextField(5);
            JTextField A = new JTextField(5);
            JTextField B = new JTextField(5);
            JTextField Mod = new JTextField(5);

            JPanel myPanel = new JPanel();
            myPanel.add(new JLabel("Iteraciones:"));
            myPanel.add(x1);

            myPanel.add(Box.createHorizontalStrut(15)); // semilla
            myPanel.add(new JLabel("Semilla:"));
            myPanel.add(y1);

            myPanel.add(Box.createHorizontalStrut(15)); // semilla
            myPanel.add(new JLabel("Numero A:"));
            myPanel.add(A);

            myPanel.add(Box.createHorizontalStrut(15)); // semilla
            myPanel.add(new JLabel("Numero B:"));
            myPanel.add(B);

            myPanel.add(Box.createHorizontalStrut(15)); // semilla
            myPanel.add(new JLabel("Modulo:"));
            myPanel.add(Mod);

            int result = JOptionPane.showConfirmDialog(null, myPanel,
                    "Completar la información", JOptionPane.OK_CANCEL_OPTION);
            if (result == JOptionPane.OK_OPTION) {
                String text = x1.getText();
                int it = Integer.parseInt(text);
                double s[] = new double[it + 1];
                double u[] = new double[it + 1];
                String text1 = y1.getText();
                int y11 = Integer.parseInt(text1);
                s[0] = y11;
                String text2 = A.getText();
                int A1 = Integer.parseInt(text2);
                String text3 = B.getText();
                int B1 = Integer.parseInt(text3);
                String text4 = Mod.getText();
                int Mo = Integer.parseInt(text4);
                while (aux2 < it) {

                    n++;
                    s[n] = ((A1 * (s[n - 1])) + B1) % Mo;
                    u[n] = s[n] / Mo;
                    aux2++;
                }
                JOptionPane.showMessageDialog(null, "Numeros aleatorios en X " + Arrays.toString(s) + "\n" + "Numeros aleatorios en U: " + Arrays.toString(u));

            }

        } else if (opcion == algoritmo[3]) {

            Object[] algoritmo2 = {"+", "-", "*"};
            JTextField ite = new JTextField(5);
            JTextField N0 = new JTextField(5);
            JTextField N1 = new JTextField(5);
            JTextField o = new JTextField(5);
            JTextField M = new JTextField(5);
            JTextField S = new JTextField(5);
            JTextField R = new JTextField(5);

            JPanel myPanel = new JPanel();

            myPanel.add(new JLabel("Iteraciones:"));
            myPanel.add(ite);

            myPanel.add(Box.createHorizontalStrut(16));
            myPanel.add(new JLabel("No:"));
            myPanel.add(N0);

            myPanel.add(Box.createHorizontalStrut(15));
            myPanel.add(new JLabel("N1:"));
            myPanel.add(N1);

            Object opcion2 = JOptionPane.showInputDialog(null, "Seleccione un algoritmo", "Elegir", JOptionPane.QUESTION_MESSAGE, null, algoritmo2, algoritmo2[0]);

            myPanel.add(Box.createHorizontalStrut(15));
            myPanel.add(new JLabel("Modulo:"));
            myPanel.add(M);

            myPanel.add(Box.createHorizontalStrut(15));
            myPanel.add(new JLabel("Numero S"));
            myPanel.add(S);

            myPanel.add(Box.createHorizontalStrut(15));
            myPanel.add(new JLabel("Numero R"));
            myPanel.add(R);

            int result = JOptionPane.showConfirmDialog(null, myPanel,
                    "Completar la información", JOptionPane.OK_CANCEL_OPTION);
            if (result == JOptionPane.OK_OPTION) {
                String tex = ite.getText();
                int iter = Integer.parseInt(tex);
                String text = N0.getText();
                int it = Integer.parseInt(text);
                double s[] = new double[iter + 2];
                double u[] = new double[iter + 2];
                String text1 = N1.getText();
                int N01 = Integer.parseInt(text1);
                s[0] = it;
                String text2 = N1.getText();
                int N11 = Integer.parseInt(text2);
                s[1] = N11;
                String text3 = M.getText();
                int M1 = Integer.parseInt(text3);
                String text4 = S.getText();
                int S1 = Integer.parseInt(text4);
                String text5 = R.getText();
                int R1 = Integer.parseInt(text5);

                while (aux2 < iter) {
                    nf++;
                    if (opcion2 == algoritmo2[0]) {

                        s[nf] = (s[nf - S1] + s[nf - R1]) % M1;
                        u[nf] = s[nf] / M1;

                    } else if (opcion2 == algoritmo2[1]) {

                        s[nf] = (s[nf - S1] - s[nf - R1]) % M1;
                        u[nf] = s[nf] / M1;

                    } else if (opcion2 == algoritmo2[2]) {

                        s[nf] = (s[nf - S1] * s[nf - R1]) % M1;
                        u[nf] = s[nf] / M1;

                    }
                    aux2++;
                }
                JOptionPane.showMessageDialog(null, "Numeros aleatorios en X " + Arrays.toString(s) + "\n" + "Numeros aleatorios en U: " + Arrays.toString(u));
            }
        } else if (opcion == algoritmo[4]) {

            JTextField x1 = new JTextField(5);
            JTextField y1 = new JTextField(5);
            JTextField A = new JTextField(5);
            JTextField B = new JTextField(5);
            JTextField Mod = new JTextField(5);

            JPanel myPanel3 = new JPanel();
            myPanel3.add(new JLabel("Iteraciones:"));
            myPanel3.add(x1);

            myPanel3.add(Box.createHorizontalStrut(15)); // semilla
            myPanel3.add(new JLabel("Semilla X:"));
            myPanel3.add(y1);

            myPanel3.add(Box.createHorizontalStrut(15)); // semilla
            myPanel3.add(new JLabel("Semilla Y:"));
            myPanel3.add(A);

            myPanel3.add(Box.createHorizontalStrut(15)); // semilla
            myPanel3.add(new JLabel("Semilla Z:"));
            myPanel3.add(B);

            int result2 = JOptionPane.showConfirmDialog(null, myPanel3,
                    "Completar la información", JOptionPane.OK_CANCEL_OPTION);
            if (result2 == JOptionPane.OK_OPTION) {
                String text = x1.getText();
                int it = Integer.parseInt(text);
                double s[] = new double[it + 1];
                double xx[] = new double[it + 1];
                double zz[] = new double[it + 1];
                double u[] = new double[it + 1];
                String text1 = y1.getText();
                int y11 = Integer.parseInt(text1);
                s[0] = y11;
                String text4 = A.getText();
                int xx1 = Integer.parseInt(text4);
                xx[0] = xx1;
                String text5 = B.getText();
                int zz1 = Integer.parseInt(text5);
                zz[0] = zz1;

                while (aux2 < it) {

                    n++;
                    s[n] = ((171 * (s[n - 1]))) % 30269;
                    xx[n] = ((172 * (xx[n - 1]))) % 30307;
                    zz[n] = ((170 * (zz[n - 1]))) % 30323;
                    u[n] = (s[n - 1] / 30269) + (xx[n - 1] / 30307) + (zz[n - 1] / 30323);
                    aux2++;
                }
                JOptionPane.showMessageDialog(null, "Numeros aleatorios en X " + Arrays.toString(s) + "\n" + "Numeros aleatorios en Y: " + Arrays.toString(xx) + "\n" + "Numeros aleatorios en Z: " + Arrays.toString(zz) + "\n" + "Numeros aleatorios en U: " + Arrays.toString(u));

            }

        } else if (opcion == algoritmo[5]) {

            JTextField x1 = new JTextField(5);
            JTextField y1 = new JTextField(5);
            JTextField A = new JTextField(5);
            JTextField B = new JTextField(5);

            JPanel myPanel3 = new JPanel();
            myPanel3.add(new JLabel("Iteraciones:"));
            myPanel3.add(x1);

            myPanel3.add(Box.createHorizontalStrut(15)); // semilla
            myPanel3.add(new JLabel("Semilla X:"));
            myPanel3.add(y1);

            myPanel3.add(Box.createHorizontalStrut(15)); // semilla
            myPanel3.add(new JLabel("Semilla Y:"));
            myPanel3.add(A);

            int result2 = JOptionPane.showConfirmDialog(null, myPanel3,
                    "Completar la información", JOptionPane.OK_CANCEL_OPTION);
            if (result2 == JOptionPane.OK_OPTION) {
                String text = x1.getText();
                int it = Integer.parseInt(text);
                double s[] = new double[it + 1];
                double xx[] = new double[it + 1];
                double zz[] = new double[it + 1];
                double u[] = new double[it + 1];
                String text1 = y1.getText();
                int y11 = Integer.parseInt(text1);
                s[0] = y11;
                String text4 = A.getText();
                int xx1 = Integer.parseInt(text4);
                xx[0] = xx1;

                while (aux2 < it) {

                    n++;
                    s[n] = ((40014 * (s[n - 1]))) % 2147483563;
                    xx[n] = ((171 * (xx[n - 1]))) % 2147483399;
                    zz[n] = (s[n - 1]) - (xx[n - 1]) % 2147483562;
                    if (zz[n - 1] >= 0) {
                        u[n] = (zz[n] / 2147483563);
                    } else if (zz[n] == 0) {
                        u[n] = (2147483562 / 2147483563);
                    }

                    aux2++;
                }
                JOptionPane.showMessageDialog(null, "Numeros aleatorios en X " + Arrays.toString(s) + "\n" + "Numeros aleatorios en Y: " + Arrays.toString(xx) + "\n" + "Numeros aleatorios en Z: " + Arrays.toString(zz) + "\n" + "Numeros aleatorios en U: " + Arrays.toString(u));

            }

        }

    }

    public static double transaction(double n) {
        return (n + 2) / Math.pow(n, 2);
    }

    public static double exit(double n) {
        return n / 33;
    }

    public static int h(int x) {
        return (x * x) >>> (w - k);
    }

}
