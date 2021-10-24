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
    DQueue rows;
    boolean dynamic;
    T commonValue = (T) "0";

    SparseMatrix(int m, int n, T value) {
        tamRow = m;
        tamCol = n;

        rows = new DQueue();

        commonValue = value;
    }

    SparseMatrix(int m, int n) {
        tamRow = m;
        tamCol = n;

        rows = new DQueue();

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
                rows.add(rowToAdd);
                commonValue = (T) this.getCommonValue();

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
                    rows.add(rowToAdd, positionRow, positionRow);
                }
            } else if (this.dynamic) {

                if (positionRow > this.tamRow && positionColumn <= this.tamCol) {

                    DQueueMatrix<T> rowToAdd = new DQueueMatrix<>(positionRow);
                    rowToAdd.add(object, positionColumn);
                    rows.add(rowToAdd, positionRow, positionRow);
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
                        rows.add(rowToAdd, positionRow, positionRow);
                    }
                    this.setTamCol(positionColumn);

                } else {

                    DQueueMatrix<T> rowToAdd = new DQueueMatrix<>(positionRow);
                    rowToAdd.add(object, positionColumn);
                    rows.add(rowToAdd, positionRow, positionRow);
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

    @Override
    public String toString() {

        StringBuilder r = new StringBuilder();
        r.append(" +");
        for (int i = 0; i < tamCol; i++) {
            r.append("----");
        }
        r.append("+\n");
        for (int j = 0; j < tamRow; j++) {
            if (rows.isReal(j)) {
                r.append(rows.get(j).toString3(tamCol, "0"));
            } else {
                r.append(j + 1 + "|" + commonValue);
                for (int l = 1; l < tamCol; l++) {
                    r.append(", " + commonValue);
                }
                r.append("|\n");
            }
        }

        r.append(" +");
        for (int i = 0; i < tamCol; i++) {
            r.append("----");
        }
        r.append("+\n");
        return r.toString();
    }

    boolean equals(SparseMatrix<T> other) {

        //Con solo que los tamanios de columnas o filas sean diferentes, ya se sabe que no son iguales
        if (this.tamCol != other.tamCol || this.tamRow != other.tamRow) {
            return false;
        }

        //k tiene que llegar a ser igual a la cantidad de columnas ya que es la cantidad de elementos que tiene una fila
        //asi va a ir comparando cada elemento por filas y no se va a ir a una fila inexistente o columna inexistente
        int filaRecorrida = tamRow;
        for (int k = 1; k <= tamCol; k++) {

            //Si se encuentra en la fila 0 quiero que se salga porque no existe.
            if (filaRecorrida == 0) {
                break;
            }

            //Si con solo una comparacion es false, que retorne false porque no son iguales las matrices.
            if (!this.get(filaRecorrida, k).equals(other.get(filaRecorrida, k))) {
                return false;
            };

            //Si k es igual al tamaño de la columna, quiere decir que ya recorrio la fila completa
            //Entonces lo igualo a 0 y la fila recorrida va a cambiar
            //Esto para que se vuelva a repetir el ciclo pero esta vez en una fila diferente
            //Este proceso se debe repetir hasta que la filaRecorrida sea 0 y haga break del ciclo.
            if (k == tamCol && filaRecorrida > 0) {
                k = 0;
                filaRecorrida--;
            }

        }

        //si termino el proceso sin caer en el return false, quiere decir que son iguales y retorna true 
        return true;
    }

    SparseMatrix<T> add(SparseMatrix<T> a) {
        int c, r;
        if (this.getRowCount() > a.getRowCount()) {
            r = this.getRowCount();
            a.setTamRow(r);
        } else if (this.getRowCount() < a.getRowCount()) {
            r = a.getRowCount();
            this.setTamRow(r);
        } else {
            r = this.getRowCount();
        }
        if (this.getColumnCount() > a.getColumnCount()) {
            c = this.getColumnCount();
            a.setTamCol(c);
        } else if (this.getColumnCount() < a.getColumnCount()) {
            c = a.getColumnCount();
            this.setTamCol(c);
        } else {
            c = this.getColumnCount();
        }

        int x, y, z;
        SparseMatrix<T> suma = new SparseMatrix<T>(r, c, commonValue);

        for (int i = 1; i <= r; i++) {
            for (int j = 1; j <= c; j++) {
                if (this.get(i, j) == commonValue && a.get(i, j) == commonValue) {
                    //
                } else if (this.get(i, j) == commonValue) {
                    suma.set(i, j, a.get(i, j));
                } else if (a.get(i, j) == commonValue) {
                    suma.set(i, j, this.get(i, j));
                } else {
                    x = (Integer) this.get(i, j);
                    y = (Integer) a.get(i, j);
                    z = x + y;
                    T tz = (T) (Integer) z;
                    suma.set(i, j, tz);
                }
            }
        }
        return suma;
    }

    SparseMatrix<T> transpose() {
        int c, r;
        c = this.getRowCount();
        r = this.getColumnCount();
        SparseMatrix<T> trans = new SparseMatrix<T>(r, c, commonValue);
        for (int i = 1; i <= c; i++) {
            for (int j = 1; j <= r; j++) {
                if (this.get(i, j) != commonValue) {
                    trans.set(j, i, this.get(i, j));
                }
            }
        }
        return trans;
    }

    SparseMatrix<T> multiply(SparseMatrix<T> a) {
        int c, r, m, x, y;
        if (this.getColumnCount() > a.getRowCount()) {
            a.setTamRow(this.getColumnCount());
        } else if (this.getColumnCount() < a.getRowCount()) {
            this.setTamCol(a.getRowCount());
        }
        r = this.getRowCount();
        c = a.getColumnCount();
        m = this.getColumnCount();

        SparseMatrix<T> mult = new SparseMatrix<T>(r, c, commonValue);

        for (int i = 1; i <= r; i++) {
            for (int j = 1; j <= c; j++) {
                x = (Integer) commonValue;
                for (int k = 1; k <= m; k++) {
                    if (this.get(i, k) == commonValue && a.get(k, j) == commonValue) {

                    } else if (this.get(i, k) == commonValue) {
                        y = (Integer) a.get(k, j) * (Integer) commonValue;
                        x = x + y;
                    } else if (a.get(k, j) == commonValue) {
                        y = (Integer) this.get(i, k) * (Integer) commonValue;
                        x = x + y;
                    } else {
                        y = (Integer) a.get(k, j) * (Integer) this.get(i, k);
                        x = x + y;
                    }
                }
                if (x != (Integer) commonValue) {
                    T tx = (T) (Integer) x;
                    mult.set(i, j, tx);
                }
            }
        }

        return mult;
    }

    SparseMatrix<T> splice(int positionRowFrom, int positionRowTo, int positionColumnFrom, int positionColumnTo) {
        if ((positionRowFrom > 0 && positionRowTo <= this.tamRow) && (positionColumnFrom > 0 && positionColumnTo <= this.tamCol) && (positionRowFrom <= positionRowTo) && (positionColumnFrom <= positionColumnTo)) {
            SparseMatrix<T> matrix = new SparseMatrix<>(sumatoria(positionRowFrom, positionRowTo), sumatoria(positionColumnFrom, positionColumnTo), this.getCommonValue());
            int index = 0;
            int currentRow = 1;
            int currentCol = 1;
            int currentRowPositionFrom = positionRowFrom;

            DNodeMatrix cursor = null;
            while (index < rows.size()) {

                if (rows.get(index).getPosRow() <= positionRowTo && rows.get(index).getPosRow() >= positionRowFrom) {

                    if (rows.get(index).getPosRow() == currentRowPositionFrom) {

                        int currentColPositionFrom = positionColumnFrom;
                        currentCol = 1;
                        cursor = rows.get(index).getFirst();

                        while (cursor != null) {

                            if (cursor.getPos() <= positionColumnTo && cursor.getPos() >= positionColumnFrom) {

                                if (cursor.getPos() == currentColPositionFrom) {

                                    matrix.set(currentRow, currentCol, (T) cursor.getInfo());
                                    currentCol = currentCol + 1;
                                    currentColPositionFrom += 1;
                                    cursor = cursor.getNext();

                                } else {
                                    currentCol = currentCol + 1;
                                    currentColPositionFrom += 1;
                                }
                            } else {
                                cursor = cursor.getNext();
                            }

                        }
                        currentRowPositionFrom += 1;
                        currentRow += 1;
                        index++;

                    } else {
                        currentRowPositionFrom += 1;
                        currentRow += 1;

                    }

                } else {
                    index++;

                }
            }

            return matrix;
        } else {
            throw new IndexOutOfBoundsException();
        }
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

    private int sumatoria(int valor1, int valor2) {
        return sumatoriaAux(valor1, valor2, 0);
    }

    private int sumatoriaAux(int valor1, int valor2, int contador) {
        return !(valor1 <= valor2) ? contador : sumatoriaAux(valor1 += 1, valor2, contador += 1);
    }

    public T getCommonValue() {
        T result = (T) "0";

        try {
            if (this.get(3, 3).getClass().getSimpleName().equals("Integer")) {
                result = (T) "0";
            } else if (this.get(3, 3).getClass().getSimpleName().equals("String")) {
                result = (T) "X";
            }

            return result;
        } catch (Exception e) {
            return result;
        }
    }
}
