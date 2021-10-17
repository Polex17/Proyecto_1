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

public class DNode<T> {

    private T info;
    private DNode<T> next;
    private DNode<T> previous;
    private int pos;



    public DNode(T info, DNode<T> next, DNode<T> previous, int pos) {
        this.info = info;
        this.next = next;
        this.previous = previous;
        this.pos = pos;
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
    
    public void setPos(int pos) {
        this.pos = pos;
    }

    public int getPos() {
        return pos;
    }
    
}
