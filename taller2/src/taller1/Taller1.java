/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package taller1;

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

        int n = 0, temp = 0;
        double[] x = new double[8], y = new double[8];
        int[] z = new int[8], z1 = new int[8];
        Object[] algoritmo = {"taller1", "Generador Midsquare", "Congruenciales lineales", "taller4", "taller5", "taller6"};

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
                x[n] = h( z[0] );
                
                temp++;

            }

            JOptionPane.showMessageDialog(null, "Numeros aleatorios en x " + Arrays.toString(x) + "\n" + "Numeros aleatorios en U: " + Arrays.toString(y));

        } else if (opcion == algoritmo[2]) {

            JTextField x1 = new JTextField(5);
            JTextField y1 = new JTextField(5);
            JTextField A = new JTextField(5);
            JTextField B = new JTextField(5);
            JTextField Mod = new JTextField(5);

            int aux2 = 0;
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

        } else if (opcion == algoritmo[4]) {

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
