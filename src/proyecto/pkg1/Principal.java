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
 * 117180577 Jeffrey Steven Monroy Laguna 117210130 Jean Paul Castillo Vives
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
        SparseMatrix<Integer> m1 = new SparseMatrix<>(3, 3, 0);

        m1.setDynamic(true);

        m1.set(2, 2, 17);
        System.out.println(m1);
        System.out.println("TamCol: " + m1.getColumnCount());
        System.out.println("TamRow: " + m1.getRowCount());

        m1.set(1, 2, 7);
        System.out.println(m1);
        System.out.println("TamCol: " + m1.getColumnCount());
        System.out.println("TamRow: " + m1.getRowCount());

        m1.set(1, 1, 5);
        System.out.println(m1);
        System.out.println("TamCol: " + m1.getColumnCount());
        System.out.println("TamRow: " + m1.getRowCount());

        m1.set(1, 1, 10);
        System.out.println(m1);
        System.out.println("TamCol: " + m1.getColumnCount());
        System.out.println("TamRow: " + m1.getRowCount());

        m1.set(1, 3, 99);
        System.out.println(m1);
        System.out.println("TamCol: " + m1.getColumnCount());
        System.out.println("TamRow: " + m1.getRowCount());

        m1.set(2, 1, 25);
        System.out.println(m1);
        System.out.println("TamCol: " + m1.getColumnCount());
        System.out.println("TamRow: " + m1.getRowCount());

        m1.set(2, 3, 6);
        System.out.println(m1);
        System.out.println("TamCol: " + m1.getColumnCount());
        System.out.println("TamRow: " + m1.getRowCount());

        m1.set(3, 1, 30);
        System.out.println(m1);
        System.out.println("TamCol: " + m1.getColumnCount());
        System.out.println("TamRow: " + m1.getRowCount());

        m1.set(3, 2, 54);
        System.out.println(m1);
        System.out.println("TamCol: " + m1.getColumnCount());
        System.out.println("TamRow: " + m1.getRowCount());

        m1.set(3, 4, 61);
        System.out.println(m1);
        System.out.println("TamCol: " + m1.getColumnCount());
        System.out.println("TamRow: " + m1.getRowCount());

        m1.set(5, 5, 100);
        System.out.println(m1);
        System.out.println("TamCol: " + m1.getColumnCount());
        System.out.println("TamRow: " + m1.getRowCount());

        m1.set(5, 4, 200);
        System.out.println(m1);
        System.out.println("TamCol: " + m1.getColumnCount());
        System.out.println("TamRow: " + m1.getRowCount());

        m1.set(5, 3, 1000);
        System.out.println(m1);

        m1.set(4, 3, 500);
        System.out.println(m1);

        System.out.println(m1.get(5, 3));
        System.out.println(m1.get(4, 3));

        System.out.println("Splice");
        SparseMatrix<Integer> m2 = m1.splice(3, 5, 1, 3);

        System.out.println(m2);
        System.out.println("TamRow: " + m2.getRowCount());
        System.out.println("TamCol: " + m2.getColumnCount());

        SparseMatrix<Integer> m3 = new SparseMatrix<>(2, 3, 0);

        SparseMatrix<Integer> m4 = new SparseMatrix<>(3, 2, 0);

        SparseMatrix<Integer> m5;
        m3.set(1, 1, 2);
        m3.set(1, 2, 4);
        m3.set(2, 3, 3);

        m4.set(1, 1, 1);
        m4.set(1, 2, 2);
        m4.set(2, 1, 5);
        m4.set(3, 2, 2);
/*
        System.out.println(m3);
        System.out.println(m4);

        SparseMatrix<Integer> m0;

        System.out.println("Transpose");
        m5 = m2.transpose();
        System.out.println(m5);

        System.out.println("Multiply");
        m0 = m3.multiply(m4);
        System.out.println(m0);

        System.out.println(m1.equals(m2));
*/
    }

}
