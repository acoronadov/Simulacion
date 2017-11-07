/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pi;

import java.util.Arrays;
import javax.swing.JOptionPane;

/**
 *
 * @author acoronado
 */
public class PI {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        double ejecutados = 0;
        double adentro = 0;
        double b = 0;
        double c = 0;
        double pi = 0;
        double piv = Math.PI;
        System.out.println("Inicia");
        int i, puntos;
        puntos = Integer.parseInt(JOptionPane.showInputDialog(null, "Ingrese un numero de puntos para generar aleatorios fuera y dentro de la circunferencia: "));
        for (i = 0; i < puntos; i++) {
            b = Math.random();
            c = Math.random();
            ejecutados++;
            if (b * b + c * c <= 1) {
                adentro++;
            }
            System.out.println(adentro);
        }
        pi = (4 * adentro) / ejecutados;
//  

        if (piv - pi <= 0.01) {
            JOptionPane.showMessageDialog(null, "Probable " + "PI: " + piv + " PI estimado: " + pi + "\n" + "Al restar PI real - PI Estimado:" + (piv - pi));
        } else {
            JOptionPane.showMessageDialog(null, "Nada probable " + "PI: " + piv + " PI estimado" + pi + "\n" + "Al restar PI real - PI Estimado:" + (piv - pi));
        }
    }

}
