/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto.pkg1;

import java.util.Comparator;

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
public class DQueue<T> {

    private DNode<T> first;
    private DNode<T> last;
    private int posRow;
    private int total;

    public DQueue() {
        this.total=0;
        this.first = this.last = null;
    }

    public DQueue(DQueue<T> q1) {
        this.first = q1.first;
        this.last = q1.last;
        this.total = q1.total;

    }

    public boolean isEmpty() {
        return total == 0;
    }

    public int size() {
        return total;
    }

    public void add(T object, int pos) {
        if (object != null) {
            DNode<T> node = new DNode<>(object, null, last, pos);

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
    
/*
    public void add(T object, int position) {
        if (object != null) {
            if ((position < 0) || (total <= position)) {
                position = total;
            }
            if (position == size()) {
                add(object);
            } else {
                DNode<T> nodeAux = findPosition(position);
                DNode<T> node = new DNode<>(object, nodeAux, nodeAux.getPrevious());

                if (position == 0) {
                    first = node;
                } else {
                    node.getPrevious().setNext(node);
                }

                if (position == size() - 1) {
                    last = node;
                } else {
                    node.getNext().setPrevious(node);
                }

                total++;
            }
        } else {
            throw new IllegalArgumentException();
        }
    }
*/
    
    private T deleteNode(DNode<T> node) {
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

    private DNode<T> findPosition(int position) {
        if ((0 <= position) && (position < size())) {
            DNode cursor = first;
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

    public T get(int position) {
        return findPosition(position).getInfo();
    }

    private DNode<T> findValue(T object) {
        assert (object != null);

        DNode<T> cursor = first;
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
        DNode<T> cursor = first;
        while (cursor != null) {
            r.append(cursor.getInfo());
            cursor = cursor.getNext();
            if (cursor != null) {
                r.append(", ");
            }
        }
        r.append("}");
        return r.toString();
    }

    public int getPosRow() {
        return posRow;
    }
    

}
