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
public class SparseMatrix<T> {

    int tamRow;
    int tamCol;
    DQueue<DQueueMatrix> rows;
    boolean dynamic;
    T commonValue;

    SparseMatrix(int m, int n, T value) {
        tamRow = m;
        tamCol = n;

        rows = new DQueue<>();

        commonValue = value;
    }

    SparseMatrix(int m, int n) {
        tamRow = m;
        tamCol = n;

        rows = new DQueue<>();
    }

    public boolean isDynamic() {
        return dynamic;
    }

    public void setDynamic(boolean dynamic) {
        this.dynamic = dynamic;
    }

    int getRowCount() {
        return this.tamRow;
    }

    int getColumnCount() {
        return this.tamCol;
    }

    void set(int positionRow, int positionColumn, T object) {
        if (object != null) {

            if (rows.isEmpty()) {

                DQueueMatrix<T> rowToAdd = new DQueueMatrix<>(positionRow);
                rowToAdd.add(object, positionColumn);
                rows.add(rowToAdd, positionRow);

            } else if (positionRow <= this.tamRow && positionColumn <= this.tamCol) {

                int index = 0;
                boolean isFound = false;
                while (index < rows.size()) {

                    if (rows.get(index).getPosRow() == positionRow) {
                        isFound = true;
                        rows.get(index).addPosition(object, positionColumn, positionColumn);
                        break;
                    }

                    index++;
                }
                if (!isFound) {
                    DQueueMatrix<T> rowToAdd = new DQueueMatrix<>(positionRow);
                    rowToAdd.add(object, positionColumn);
                    rows.add(rowToAdd, positionRow);
                }
            } else if (this.dynamic) {

                if (positionRow > this.tamRow && positionColumn <= this.tamCol) {

                    DQueueMatrix<T> rowToAdd = new DQueueMatrix<>(positionRow);
                    rowToAdd.add(object, positionColumn);
                    rows.add(rowToAdd, positionRow);
                    this.setTamRow(positionRow);

                } else if (positionRow <= this.tamRow && positionColumn > this.tamCol) {

                    int index = 0;
                    boolean isFound = false;
                    while (index < rows.size()) {

                        if (rows.get(index).getPosRow() == positionRow) {
                            rows.get(index).addPosition(object, positionColumn, positionColumn);
                            isFound = true;
                            break;
                        }

                        index++;
                    }

                    if (!isFound) {
                        DQueueMatrix<T> rowToAdd = new DQueueMatrix<>(positionRow);
                        rowToAdd.add(object, positionColumn);
                        rows.add(rowToAdd, positionRow);
                    }
                    this.setTamCol(positionColumn);

                } else {

                    DQueueMatrix<T> rowToAdd = new DQueueMatrix<>(positionRow);
                    rowToAdd.add(object, positionColumn);
                    rows.add(rowToAdd, positionRow);
                    this.setTamCol(positionColumn);
                    this.setTamRow(positionRow);
                }
            } else {
                throw new IndexOutOfBoundsException();
            }

        } else {
            throw new IllegalArgumentException();
        }
    }

    T get(int positionRow, int positionColumn) {
        if ((0 <= positionRow && positionRow <= this.tamRow) && (0 <= positionColumn && positionColumn <= this.tamCol)) {
            int index = 0;
            boolean isFound = false;
            while (index < rows.size()) {

                if (rows.get(index).getPosRow() == positionRow) {
                    isFound = true;
                    break;
                }

                index++;
            }

            if (isFound) {
                for (int index2 = 0; index2 < rows.get(index).size(); index2++) {
                    if (rows.get(index).getNodePos(index2) == positionColumn) {
                        return (T) rows.get(index).get(index2);

                    }
                }
            }
            return this.commonValue;
        } else {
            throw new IndexOutOfBoundsException();
        }

    }

    /*
    SparseMatrix<T> suma(SparseMatrix<T> a, SparseMatrix<T> b){
        if (a.getColumnCount() == b.getColumnCount() && a.getRowCount() == b.getRowCount()){
            SparseMatrix<T> x;
            for (int i=0;i<a.getColumnCount();i++){
                for (int j=0;j<a.getRowCount();j++){
                    x.set(a.getColumnCount(),a.getRowCount(), a.get(i,j));
                    String sa = (String) a.get(i,j);
                }
            }

        }
        else{

            throw new IndexOutOfBoundsException();
        }
    }
     */
    @Override
    public String toString() {
        StringBuilder r = new StringBuilder();
        r.append("+");
        for (int i = 0; i < tamCol; i++) {
            r.append("----");
        }
        r.append("+\n");

        int aux;

        for (int i = 0; i < tamRow; i++) {
            aux = tamRow;
            for (int j = 0; j < tamRow; j++) {
                if (rows.isReal(j)) {
                    if (rows.get(j).getPosRow() == i + 1) {
                        r.append(rows.get(j).toString3(tamCol));
                    } else {
                        aux--;
                    }
                } else {
                    aux--;
                }
            }
            if (aux == 0) {
                r.append(i + 1 + "|0");
                for (int l = 1; l < tamCol; l++) {
                    r.append(", 0");
                }
                r.append("|\n");
            }
        }

        r.append("+");
        for (int i = 0; i < tamCol; i++) {
            r.append("----");
        }
        r.append("+\n");
        return r.toString();
    }

    /*@Override
    public String toString() {
        StringBuilder r = new StringBuilder();
        r.append("+");
        for (int i = 0; i < tamCol; i++) {
            r.append("----");
        }
        r.append("+\n");

        for (int j = 0; j < tamRow; j++) {
            if (rows.isReal(j)) {
                r.append(rows.get(j).toString2(tamCol));
            } else {
                if (rows.get(0).get(0) instanceof String){
                    r.append("| ");
                    for (int l = 1; l < tamCol; l++) {
                        r.append(", ");
                    }
                    r.append("|\n");
                }
                else if (rows.get(0).get(0) instanceof Boolean){
                    r.append("| "+false);
                    for (int l = 1; l < tamCol; l++) {
                        r.append(", "+false);
                    }
                    r.append("|\n");
                }
                else if (rows.get(0).get(0) instanceof Character){
                    r.append("| ");
                    for (int l = 1; l < tamCol; l++) {
                        r.append(", ");
                    }
                    r.append("|\n");
                }
                else {
                    r.append("|0");
                    for (int l = 1; l < tamCol; l++) {
                        r.append(", 0");
                    }
                    r.append("|\n");
                }
            }
        }

        r.append("+");
        for (int i = 0; i < tamCol; i++) {
            r.append("----");
        }
        r.append("+\n");
        return r.toString();
    }*/
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

    private void setTamRow(int tamRow) {
        this.tamRow = tamRow;
    }

    private void setTamCol(int tamCol) {
        this.tamCol = tamCol;
    }

    public int getTamRow() {
        return tamRow;
    }

    public int getTamCol() {
        return tamCol;
    }
}
