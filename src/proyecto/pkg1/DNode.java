/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto.pkg1;

/**
 *
 * @author Jeffrey
 * @param <T>
 */
public class DNode<T> {

    private T info;
    private DNode<T> next;
    private DNode<T> previous;

    public DNode(T info, DNode<T> next, DNode<T> previous) {
        this.info = info;
        this.next = next;
        this.previous = previous;
    }

    public DNode() {

    }

    public T getInfo() {
        return info;
    }

    public DNode<T> getNext() {
        return next;
    }

    public DNode<T> getPrevious() {
        return previous;
    }

    public void setNext(DNode<T> next) {
        this.next = next;
    }

    public void setPrevious(DNode<T> previous) {
        this.previous = previous;
    }

}
