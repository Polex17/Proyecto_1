/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto.pkg1;

/**
 *
 * (c) 2021
 *
 * @author Jeffrey Steven Monroy Laguna, ,
 * @version 1.0.0 2021-10-24
 *
 * ----------------------------------------------- EIF207 Estructuras de Datos
 * 2do ciclo 2021, grupo ???? Proyecto 1
 *
 * 117180577 Jeffrey Steven Monroy Laguna
 *
 *
 *
 * -----------------------------------------------
 *
 *
 */
public class Principal {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        SparseMatrix<Integer> m1 = new SparseMatrix<>(3, 3);

        m1.setDynamic(true);

        m1.set(1, 1, 5);
        System.out.println(m1);
        System.out.println("TamCol: " + m1.getColumnCount());
        System.out.println("TamRow: " + m1.getRowCount());
        System.out.println("CurrentTamCol: " + m1.getTamCol());
        System.out.println("CurrentTamRow: " + m1.getTamRow());

        m1.set(1, 1, 10);
        System.out.println(m1);
        System.out.println("TamCol: " + m1.getColumnCount());
        System.out.println("TamRow: " + m1.getRowCount());
        System.out.println("CurrentTamCol: " + m1.getTamCol());
        System.out.println("CurrentTamRow: " + m1.getTamRow());

        m1.set(1, 2, 7);
        System.out.println(m1);
        System.out.println("TamCol: " + m1.getColumnCount());
        System.out.println("TamRow: " + m1.getRowCount());
        System.out.println("CurrentTamCol: " + m1.getTamCol());
        System.out.println("CurrentTamRow: " + m1.getTamRow());

        m1.set(1, 3, 99);
        System.out.println(m1);
        System.out.println("TamCol: " + m1.getColumnCount());
        System.out.println("TamRow: " + m1.getRowCount());
        System.out.println("CurrentTamCol: " + m1.getTamCol());
        System.out.println("CurrentTamRow: " + m1.getTamRow());

        m1.set(2, 1, 25);
        System.out.println(m1);
        System.out.println("TamCol: " + m1.getColumnCount());
        System.out.println("TamRow: " + m1.getRowCount());
        System.out.println("CurrentTamCol: " + m1.getTamCol());
        System.out.println("CurrentTamRow: " + m1.getTamRow());

        m1.set(2, 2, 17);
        System.out.println(m1);
        System.out.println("TamCol: " + m1.getColumnCount());
        System.out.println("TamRow: " + m1.getRowCount());
        System.out.println("CurrentTamCol: " + m1.getTamCol());
        System.out.println("CurrentTamRow: " + m1.getTamRow());

        m1.set(2, 3, 6);
        System.out.println(m1);
        System.out.println("TamCol: " + m1.getColumnCount());
        System.out.println("TamRow: " + m1.getRowCount());
        System.out.println("CurrentTamCol: " + m1.getTamCol());
        System.out.println("CurrentTamRow: " + m1.getTamRow());

        m1.set(3, 1, 30);
        System.out.println(m1);
        System.out.println("TamCol: " + m1.getColumnCount());
        System.out.println("TamRow: " + m1.getRowCount());
        System.out.println("CurrentTamCol: " + m1.getTamCol());
        System.out.println("CurrentTamRow: " + m1.getTamRow());

        m1.set(3, 2, 54);
        System.out.println(m1);
        System.out.println("TamCol: " + m1.getColumnCount());
        System.out.println("TamRow: " + m1.getRowCount());
        System.out.println("CurrentTamCol: " + m1.getTamCol());
        System.out.println("CurrentTamRow: " + m1.getTamRow());

        m1.set(3, 3, 61);
        System.out.println(m1);
        System.out.println("TamCol: " + m1.getColumnCount());
        System.out.println("TamRow: " + m1.getRowCount());
        System.out.println("CurrentTamCol: " + m1.getTamCol());
        System.out.println("CurrentTamRow: " + m1.getTamRow());

        m1.set(5, 5, 100);
        System.out.println(m1);
        System.out.println("TamCol: " + m1.getColumnCount());
        System.out.println("TamRow: " + m1.getRowCount());
        System.out.println("CurrentTamCol: " + m1.getTamCol());
        System.out.println("CurrentTamRow: " + m1.getTamRow());

        m1.set(5, 4, 200);
        System.out.println(m1);
        System.out.println("TamCol: " + m1.getColumnCount());
        System.out.println("TamRow: " + m1.getRowCount());
        System.out.println("CurrentTamCol: " + m1.getTamCol());
        System.out.println("CurrentTamRow: " + m1.getTamRow());
    }

}
