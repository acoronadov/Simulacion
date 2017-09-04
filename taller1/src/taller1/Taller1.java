/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package taller1;

import java.util.Arrays;
import javax.swing.JOptionPane;

/**
 *
 * @author acoronado
 */
public class Taller1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
      int n=0, temp=0;
        double [] x=new double[8],y= new double[8];
        x[0] = Double.parseDouble(JOptionPane.showInputDialog(null,"Ingrese un numero para generar numeros aleatorios a partir del numero ingresado: "));
        while(temp< 7){
            n++;
            x[n]=transaction(x[n-1]);
            y[n-1]=exit(x[n]); 
            temp++;
    }
    
     JOptionPane.showMessageDialog(null,"Numeros aleatorios en x "+Arrays.toString(x)+"\n"+"Numeros aleatorios en U: "+Arrays.toString(y));

    }
     public static double transaction(double n){
     return (n+2)/Math.pow(n, 2);
     }
     public static double exit(double n){
         return n/33;
     }
    }
    

