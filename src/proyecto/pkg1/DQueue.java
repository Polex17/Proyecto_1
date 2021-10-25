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
public class DQueue {

    private DNode first;
    private DNode last;

    private int total;

    public DQueue() {
        this.first = this.last = null;
    }

    public DQueue(DQueue q1) {
        this.first = q1.first;
        this.last = q1.last;
        this.total = q1.total;

    }

    public boolean isReal(int n) {
        DNode cursor = first;
        /*while (cursor != null) {
            cursor = cursor.getNext();

            if (aux == 0) {
                return true;
            } else {
                aux--;
            }
        }
        return false;
*/
        while (cursor != null) {
            if (cursor.getInfo().getPosRow()==n+1){
                return true;
            }
            else {
            cursor = cursor.getNext();}
        }
        return false;
    }

    public boolean isEmpty() {
        return total == 0;
    }

    public int size() {
        return total;
    }

    public void add(DQueueMatrix object) {
        if (object != null) {
            DNode node = new DNode(object, null, last);

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

    public void add(DQueueMatrix object, int location, int position) {
        if (object != null) {
            if ((position < 0 || last.getInfo().getPosRow() <= location)) {
                add(object);
            } else if (position == size() && last.getInfo().getPosRow() <= location) {
                add(object);
            } else {
                DNode nodeAux = findPositionRow(position);

                DNode node = new DNode(object, nodeAux, nodeAux.getPrevious());
                if (first.getInfo().getPosRow() == location || first.getInfo().getPosRow() > location) {
                    first = node;
                } else if (last.getInfo().getPosRow() == location || last.getInfo().getPosRow() < location) {
                    last = node;
                } else {
                    node.getNext().setPrevious(node);
                    node.getPrevious().setNext(node);
                }
                total++;
            }

        } else {
            throw new IllegalArgumentException();
        }
    }

    private DQueueMatrix deleteNode(DNode node) {
        assert (node != null);

        DQueueMatrix object = node.getInfo();

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

    public DQueueMatrix remove() { //Tiempo de O(1)
        DQueueMatrix object = null;
        if (!isEmpty()) {
            object = deleteNode(first);
        } else {
            throw new IllegalArgumentException();
        }
        return object;
    }

    public DQueueMatrix remove(int position) { // Tiempo de O(n)
        DQueueMatrix object = null;
        if (!isEmpty()) {
            object = deleteNode(findPosition(position));
        } else {
            throw new IllegalArgumentException();
        }
        return object;
    }

    public DQueueMatrix remove(DQueueMatrix object) { // Tiempo de O(n)
        DQueueMatrix objectAux = null;
        if (!isEmpty()) {
            objectAux = deleteNode(findValue(object));
        } else {
            throw new IllegalArgumentException();
        }
        return objectAux;
    }

    private DNode findPosition(int i) {
        if ((0 <= i) && (i < size())) {
            DNode cursor = first;
            int k = 0;
            while (k < i) {
                cursor = cursor.getNext();
                k++;
            }
            assert ((k == i) && (cursor != null));
            return cursor;
        } else {
            throw new IndexOutOfBoundsException();
        }
    }

    private DNode findPositionRow(int position) {
        if ((0 <= position) && (position <= last.getInfo().getPosRow())) {
            DNode cursor = first;

            while (cursor.getInfo().getPosRow() < position) {
                if (cursor.getInfo().getPosRow() != position) {
                    cursor = cursor.getNext();
                }
            }
            return cursor;
        } else {
            throw new IndexOutOfBoundsException();
        }

    }

    public DQueueMatrix get(int position) {
        return findPosition(position).getInfo();
    }

    private DNode findValue(DQueueMatrix object) {
        assert (object != null);

        DNode cursor = first;
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
        StringBuilder r = new StringBuilder("{");
        DNode cursor = first;
        while (cursor != null) {
            r.append(cursor.getInfo());
            cursor = cursor.getNext();
            if (cursor != null) {
                r.append(", ");
            }
        }
        r.append("}\n");
        return r.toString();
    }

}
