/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto.pkg1;

import java.util.Comparator;

/**
 *
 * @author Jeffrey
 * @param <T>
 */
public class DQueue<T> {

    private DNode<T> first;
    private DNode<T> last;

    private int total;

    public DQueue() {
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

    public void add(T object) {
        if (object != null) {
            DNode<T> node = new DNode<>(object, null, last);

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

    private DNode<T> findPosition(int i) {
        if ((0 <= i) && (i < size())) {
            DNode<T> cursor = first;
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
        r.append("}\n");
        return r.toString();
    }
/*
    public void sort(DQueue<T> q1) {
        q1 = MergeSort(q1);
    }

    private DQueue<T> MergeSort(DQueue<T> q1) {
        if (q1.size() > 1) {
            int middle = (q1.size() / 2);
            DQueue<T> qLeft = split(q1, middle);
            DQueue<T> qRight = new DQueue<>(q1);

            qLeft = MergeSort(qLeft);

            qRight = MergeSort(qRight);

            return (Merge(qLeft, qRight));
        } else {
            return q1;
        }
    }

    private DQueue<T> Merge(DQueue<T> qLeft, DQueue<T> qRight) {
        DQueue<T> qSort = new DQueue<>();
        while (!qLeft.isEmpty() && !qRight.isEmpty()) {
            if (qLeft.get(0).compareTo(qRight.get(0)) <= 0) {
                qSort.add(qLeft.remove(0));
            } else {
                qSort.add(qRight.remove(0));
            }
        }

        while (!qLeft.isEmpty()) {
            qSort.add(qLeft.remove());
        }

        while (!qRight.isEmpty()) {
            qSort.add(qRight.remove());
        }
        System.out.printf("Sort(%s)%n", qSort.toString());

        return qSort;
    }

    private DQueue<T> split(DQueue<T> q1, int middle) {

        DQueue<T> qSplit = new DQueue<>();
        while (middle < q1.size()) {
            qSplit.add(q1.remove());
        }

        return qSplit;
    }

    public void sort(DQueue<T> q1, Comparator<T> comparator) {
        q1 = MergeSort(q1, comparator);
    }

    private DQueue<T> MergeSort(DQueue<T> q1, Comparator<T> comparator) {
        if (q1.size() > 1) {
            int middle = (q1.size() / 2);
            DQueue<T> qLeft = split(q1, middle);
            DQueue<T> qRight = new DQueue<>(q1);

            qLeft = MergeSort(qLeft);

            qRight = MergeSort(qRight);

            return (Merge(qLeft, qRight, comparator));
        } else {
            return q1;
        }
    }

    private DQueue<T> Merge(DQueue<T> qLeft, DQueue<T> qRight, Comparator<T> comparator) {
        DQueue<T> qSort = new DQueue<>();
        while (!qLeft.isEmpty() && !qRight.isEmpty()) {
            if (comparator.compare(qLeft.get(0), qRight.get(0)) <= 0) {
                qSort.add(qLeft.remove(0));
            } else {
                qSort.add(qRight.remove(0));
            }
        }

        while (!qLeft.isEmpty()) {
            qSort.add(qLeft.remove());
        }

        while (!qRight.isEmpty()) {
            qSort.add(qRight.remove());
        }
        System.out.printf("Sort(%s)%n", qSort.toString());

        return qSort;
    }*/

}
