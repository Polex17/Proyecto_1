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
public class SparseMatrix<T> {

    int tamRow;
    int tamCol;
    DQueue<DQueueMatrix> rows;
    boolean dynamic;

    SparseMatrix(int m, int n, T value) {
        tamRow = m;
        tamCol = n;

        rows = new DQueue<>();
        //Falta ver que hacer con el value de T
    }

    SparseMatrix(int m, int n) {
        tamRow = m;
        tamCol = n;

        rows = new DQueue<>();
    }

    int getRowCount() {
        return 0;
    }

    int getColumnCount() {
        return 0;
    }

    void set(int positionRow, int positionColumn, T object) {
        if (object != null) {

            if (rows.isEmpty()) {

                DQueueMatrix<T> rowToAdd = new DQueueMatrix<>(positionRow);
                rowToAdd.add(object, positionColumn);
                rows.add(rowToAdd, positionRow);

            } else if (positionRow <= this.tamRow && positionColumn <= this.tamCol) {
                
                int index = 0;
                
                while (index < rows.size()) {
                    
                    if (rows.get(index).getPosRow() == positionRow) {
                        
                        rows.get(index).addPosition(object, positionColumn, positionColumn);
                        break;
                    }
                    
                    index++;
                }
            } else if (this.dynamic) {
                
                if (positionRow > this.tamRow) {
                    
                    DQueueMatrix<T> rowToAdd = new DQueueMatrix<>(positionRow);
                    rowToAdd.add(object, positionColumn);
                    rows.add(rowToAdd, positionRow);
                    
                } else if (positionRow <= this.tamRow && positionColumn > this.tamCol) {
                    
                    int index = 0;
                    
                    while (index < rows.size()) {
                        
                        if (rows.get(index).getPosRow() == positionRow) {
                            rows.get(index).addPosition(object, positionColumn, positionColumn);
                            break;
                        }
                        
                        index++;
                    }

                }
            }

        } else {
            throw new IllegalArgumentException();
        }
    }

    T get(int m, int n) {
        return null;
    }

    @Override
    public String toString() {
        StringBuilder r = new StringBuilder();
        r.append(rows.toString());
        return r.toString();
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

    SparseMatrix<T> splice(int m0, int m1, int n0, int n1) {

        return null;

    }
}
