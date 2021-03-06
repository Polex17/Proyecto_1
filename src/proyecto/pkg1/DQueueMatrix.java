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
public class DQueueMatrix<T> {

    private DNodeMatrix<T> first;
    private DNodeMatrix<T> last;
    private int posRow;
    private int total;

    public DQueueMatrix() {
        this.total = 0;
        this.first = this.last = null;
    }

    public DQueueMatrix(DQueueMatrix<T> q1) {
        this.first = q1.first;
        this.last = q1.last;
        this.total = q1.total;

    }

    public DQueueMatrix(int posRow) {
        this.first = this.last = null;
        this.total = 0;
        this.posRow = posRow;

    }

    public boolean isEmpty() {
        return total == 0;
    }

    public int size() {
        return total;
    }

    public void add(T object, int pos) {
        if (object != null) {
            DNodeMatrix<T> node = new DNodeMatrix<>(object, null, last, pos);

            if (isEmpty()) {
                first = last = node;
            } else {
                last.setNext(node);
                last = node;
            }
            total++;
        } else {
            throw new IllegalArgumentException();
        }
    }

    public void addPosition(T object, int location, int position) {
        if (object != null) {
            if ((position < 0 || last.getPos() <= position) && (last.getPos() != location)) {
                add(object, location);
            } else if (position == size() && last.getPos() != location) {
                add(object, location);
            } else {
                DNodeMatrix<T> nodeAux = findPositionMatrix(location);
                if (nodeAux.getPos() == location) {
                    DNodeMatrix<T> node = new DNodeMatrix<>(object, nodeAux.getNext(), nodeAux.getPrevious(), location);
                    if (first.getPos() == location) {
                        first = node;
                    }
                    if (last.getPos() == location) {
                        last = node;
                    } else {
                        node.getNext().setPrevious(node);
                    }
                } else {
                    DNodeMatrix<T> node = new DNodeMatrix<>(object, nodeAux, nodeAux.getPrevious(), location);
                    if (first.getPos() == location || first.getPos() > location) {
                        first = node;
                    }
                    if (last.getPos() == location || last.getPos() < location) {
                        last = node;
                    } else {
                        node.getNext().setPrevious(node);
                    }
                    total++;
                }

            }
        } else {
            throw new IllegalArgumentException();
        }
    }

    public String toString3(int n, String T) {
        StringBuilder r = new StringBuilder();
        DNodeMatrix<T> nodeAux;
        int aux;
        r.append(posRow);
        r.append("|");
        for (int i = 0; i < n; i++) {
            nodeAux = first;
            aux = 0;
            while (nodeAux != null) {
                if (nodeAux.getPos() == i + 1) {
                    r.append(nodeAux.getInfo());
                    nodeAux = nodeAux.getNext();
                    aux = 1;
                    if (i + 1 != n) {
                        r.append(", ");
                    }

                } else {
                    nodeAux = nodeAux.getNext();
                    //aux--;
                }
            }
            if (aux == 0) {
                r.append(T);
                if (i + 1 != n) {
                    r.append(", ");
                }
            }
        }
        r.append("|\n");
        return r.toString();
    }

    public String toString2(int n, String commonValue) {
        StringBuilder r = new StringBuilder();
        DNodeMatrix<T> nodeAux = first;
        int aux = n;
        r.append("|");
        while (nodeAux != null) {
            r.append(nodeAux.getInfo());
            nodeAux = nodeAux.getNext();
            if (nodeAux != null) {
                r.append(", ");
            }
            aux--;
        }
        for (int k = aux; k > 0; k--) {
            r.append("," + commonValue);
        }
        r.append("|\n");
        return r.toString();
    }

    private T deleteNode(DNodeMatrix<T> node) {
        assert (node != null);

        T object = node.getInfo();

        if (node.getPrevious() != null) {
            node.getPrevious().setNext(node.getNext());
        } else {
            first = node.getNext();
        }
        if (node.getNext() != null) {
            node.getNext().setPrevious(node.getPrevious());
        } else {
            last = node.getPrevious();
        }

        node.setNext(null);
        node.setPrevious(null);
        total--;
        return object;
    }

    public T remove() { //Tiempo de O(1)
        T object = null;
        if (!isEmpty()) {
            object = deleteNode(first);
        } else {
            throw new IllegalArgumentException();
        }
        return object;
    }

    public T remove(int position) { // Tiempo de O(n)
        T object = null;
        if (!isEmpty()) {
            object = deleteNode(findPosition(position));
        } else {
            throw new IllegalArgumentException();
        }
        return object;
    }

    public T remove(T object) { // Tiempo de O(n)
        T objectAux = null;
        if (!isEmpty()) {
            objectAux = deleteNode(findValue(object));
        } else {
            throw new IllegalArgumentException();
        }
        return objectAux;
    }

    private DNodeMatrix<T> findPosition(int position) {
        if ((0 <= position) && (position < size())) {
            DNodeMatrix cursor = first;
            int index = 0;
            while (index < position) {
                cursor = cursor.getNext();
                index++;
            }
            //Assert es una forma de validar por decirlo un if con menos lineas de codigo tambien para evitar poner las lineas de excepcion
            assert ((index == position) && (cursor != null));
            return cursor;
        } else {
            throw new IndexOutOfBoundsException();
        }

    }

    private DNodeMatrix<T> findPositionMatrix(int position) {
        if ((0 <= position) && (position <= last.getPos())) {
            DNodeMatrix cursor = first;

            while (cursor.getPos() < position) {
                if (cursor.getPos() != position) {
                    cursor = cursor.getNext();
                }
            }
            return cursor;
        } else {
            throw new IndexOutOfBoundsException();
        }

    }

    public T get(int position) {
        return findPosition(position).getInfo();
    }

    public int getNodePos(int position) {
        return findPosition(position).getPos();
    }

    private DNodeMatrix<T> findValue(T object) {
        assert (object != null);

        DNodeMatrix<T> cursor = first;
        boolean found = false;
        while (cursor != null && !found) {
            if (!(found = cursor.getInfo().equals(object))) {
                cursor = cursor.getNext();
            }
        }
        if (!found) {
            throw new IllegalArgumentException();
        }
        return cursor;
    }

    @Override
    public String toString() {
        StringBuilder r = new StringBuilder(getPosRow() + " [");
        DNodeMatrix<T> cursor = first;
        while (cursor != null) {
            r.append(cursor.getInfo());
            cursor = cursor.getNext();
            if (cursor != null) {
                r.append(", ");
            }
        }
        r.append("] \n");
        return r.toString();
    }

    public int getPosRow() {
        return posRow;
    }

    public DNodeMatrix<T> getFirst() {
        return first;
    }

    public DNodeMatrix<T> getLast() {
        return last;
    }
}
