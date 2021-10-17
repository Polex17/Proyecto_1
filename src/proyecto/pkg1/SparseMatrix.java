/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto.pkg1;

/** 
* 
* (c) 2021 
* @author Jeffrey Steven Monroy Laguna, , 
* @version 1.0.0 2021-10-24 
* 
* ----------------------------------------------- 
* EIF207 Estructuras de Datos 
* 2do ciclo 2021, grupo ???? 
* Proyecto 1 
* 
* 117180577 Jeffrey Steven Monroy Laguna
* 
* 
* 
* ----------------------------------------------- 
* 
* 
*/

public class SparseMatrix<T> {

    int tamRow;
    int tamCol;
    DQueue<DQueue> rows;
    boolean dynamic;

    SparseMatrix(int m, int n, T v) {
    }

    SparseMatrix(int m, int n) {
    }

    int getRowCount() {
        return 0;
    }

    int getColumnCount() {
        return 0;
    }

    void set(int m, int n, T v) {
    }

    T get(int m, int n) {
        return null;
    }

    @Override
    public String toString() {
        return null;
    }

    boolean equals(SparseMatrix<T> other) {
        return false;
    }

    SparseMatrix<T> add(SparseMatrix<T> m) {
        return null;
    }

    SparseMatrix<T> transpose() {
        return null;
    }

    SparseMatrix<T> multiply(SparseMatrix<T> m) {
        return null;
    }

    SparseMatrix<T> splice(int m0, int m1, int n0, int n1){
    
        return null;
    
    }
}
