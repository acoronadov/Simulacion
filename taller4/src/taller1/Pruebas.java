/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package taller1;

import java.util.Arrays;
import javax.swing.JOptionPane;
import org.apache.commons.math3.distribution.NormalDistribution;
import org.apache.commons.math3.distribution.ChiSquaredDistribution;
import org.apache.commons.math3.stat.descriptive.DescriptiveStatistics;
import org.apache.spark.SparkConf;
import org.apache.spark.api.java.JavaDoubleRDD;
import org.apache.spark.api.java.JavaSparkContext;
import org.apache.spark.mllib.stat.Statistics;
import org.apache.spark.mllib.stat.test.KolmogorovSmirnovTestResult;

/**
 *
 * @author acoronado
 */
public class Pruebas {

    public void pruebas(double[] a) {

        JOptionPane.showMessageDialog(null, "Numeros aleatorios en y  " + Arrays.toString(a));

        Object[] algoritmo = {"Prueba Promedios", "Prueba Varianza", "Prueba frecuencia Chicuadrado", "Prueba Kolmogorov"};

        Object opcion = JOptionPane.showInputDialog(null, "Seleccione un algoritmo", "Elegir", JOptionPane.QUESTION_MESSAGE, null, algoritmo, algoritmo[0]);

        if (opcion == algoritmo[0]) {
            int N = a.length;

            double promedio = 0;
            for (int i = 0; i < a.length; i++) {
                promedio += a[i];
            }
            promedio = promedio / a.length;

            double alpha = 0.05;
            double Li = 0;
            double Ls = 0;

            Li = 0.5 - calculaz(alpha / 2);
            Ls = 0.5 + calculaz(alpha / 2);
//            JOptionPane.showMessageDialog(null, "Promedio " + promedio);
//            JOptionPane.showMessageDialog(null, "Limite inferior " + Li);
//            JOptionPane.showMessageDialog(null, "Limite inferior " + Ls);
            if (Li < promedio && Ls > promedio) {
                JOptionPane.showMessageDialog(null, "Segun limite inferior" + Li + " y Limite superior " + Ls + " El algoritmo pasa la prueba con: " + promedio);
            } else {
                JOptionPane.showMessageDialog(null, "Segun limite inferior" + Li + " y Limite superior " + Ls + " El algoritmo NO pasa la prueba con: " + promedio);
            }
        } else if (opcion == algoritmo[1]) {

            int cant_datos = a.length;
            int grados_libertad = cant_datos - 1;
            double confianza = .95;
            double alfa = 1 - confianza;

            NormalDistribution nd = new NormalDistribution();
            ChiSquaredDistribution chi = new ChiSquaredDistribution(grados_libertad);
            DescriptiveStatistics estadistica = new DescriptiveStatistics();

            int i;

            for (i = 0; i < cant_datos; i++) {
                estadistica.addValue(a[i]);
            }

            double varianza, li2, ls2;
            varianza = estadistica.getVariance();

            li2 = chi.inverseCumulativeProbability(alfa / 2) / (12 * grados_libertad);
            ls2 = chi.inverseCumulativeProbability(1 - alfa / 2) / (12 * grados_libertad);

            JOptionPane.showMessageDialog(null, "---Prueba de varianza---");
            if (varianza > li2 && varianza < ls2) {
                JOptionPane.showMessageDialog(null, "Varianza: " + varianza + " Limite inferior: " + li2 + " Limite superior: " + ls2 + " PASA LA PRUEBA");
            } else {
                JOptionPane.showMessageDialog(null, "Varianza: " + varianza + " Limite inferior: " + li2 + " Limite superior: " + ls2 + " NO PASA LA PRUEBA");
            }

        } else if (opcion == algoritmo[2]) {
            if (a.length != 0) {
                int acum[] = {0, 0, 0, 0, 0};
                float FE = (float) a.length / 5;
                System.out.println(FE);
                for (int i = 0; i < a.length; i++) {
                    float num = (float) a[i];
                    //            System.out.println(num);
                    if (num >= 0 && num < 0.2) {
                        acum[0]++;
                    } else if (num >= 0.2 && num < 0.4) {
                        acum[1]++;
                    } else if (num >= 0.4 && num < 0.6) {
                        acum[2]++;
                    } else if (num >= 0.6 && num < 0.8) {
                        acum[3]++;
                    } else if (num >= 0.8 && num <= 1) {
                        acum[4]++;
                    }
                }
                //        System.out.println(acum[0]);
                float es = 0;
                for (int i = 0; i < 5; i++) {
                    es += (float) (((acum[i] - FE) * (acum[i] - FE)) / FE);

                }

                if (es < 9.49) {
                    JOptionPane.showMessageDialog(null, "Los aleatorios pasan la prueba", "Error", JOptionPane.INFORMATION_MESSAGE);
                } else if (es > 9.49) {
                    JOptionPane.showMessageDialog(null, "Los aleatorio no pasan la prueba", "Error", JOptionPane.ERROR_MESSAGE);
                } else {
                    JOptionPane.showMessageDialog(null, "La lista esta vacia", "Error", JOptionPane.ERROR_MESSAGE);

                }
            }
        } else if (opcion == algoritmo[3]) {
            SparkConf conf = new SparkConf().setAppName("JavaHypothesisTestingKolmogorovSmirnovTestExample").setMaster("local");
            JavaSparkContext jsc = new JavaSparkContext(conf);
            JavaDoubleRDD data = jsc.parallelizeDoubles(a);

            KolmogorovSmirnovTestResult test = Statistics.kolmogorovSmirnovTest(data, "norma", 35.0, 1.5);
            if (test < 0.5) {
                JOptionPane.showMessageDialog(null, "Prueba pasa la prueba con: " + test);
            } else {
                JOptionPane.showMessageDialog(null, "NO Prueba pasa la prueba con: " + test);
            }
            jsc.stop();

        }
    }

    public double calculaz(double v) { //funcion de densidad de probabilidad normal
        double N = Math.exp(-Math.pow(v, 2) / 2) / Math.sqrt(2 * Math.PI);
        return N;
    }

}
