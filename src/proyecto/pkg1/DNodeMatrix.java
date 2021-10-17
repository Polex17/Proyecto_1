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
public class DNodeMatrix<T> {

    private T info;
    private DNodeMatrix<T> next;
    private DNodeMatrix<T> previous;
    private int pos;

    public DNodeMatrix(T info, DNodeMatrix<T> next, DNodeMatrix<T> previous, int pos) {
        this.info = info;
        this.next = next;
        this.previous = previous;
        this.pos = pos;
    }

    public DNodeMatrix(T info, int pos) {
        this(info, null, null, pos);
    }

    public T getInfo() {
        return info;
    }

    public DNodeMatrix<T> getNext() {
        return next;
    }

    public DNodeMatrix<T> getPrevious() {
        return previous;
    }

    public void setNext(DNodeMatrix<T> next) {
        this.next = next;
    }

    public void setPrevious(DNodeMatrix<T> previous) {
        this.previous = previous;
    }

    public void setPos(int pos) {
        this.pos = pos;
    }

    public int getPos() {
        return pos;
    }

    @Override
    public String toString() {
        String r = info.toString();
        return r;
    }

}
