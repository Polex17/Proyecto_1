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
 * 117210130 Jean Paul Castillo Vives
 *
 *
 * -----------------------------------------------
 *
 *
 */

public class DNode {

    private DQueueMatrix info;
    private DNode next;
    private DNode previous;

    public DNode(DQueueMatrix info, DNode next, DNode previous) {
        this.info = info;
        this.next = next;
        this.previous = previous;
    }

    public DNode() {

    }

    public DQueueMatrix getInfo() {
        return info;
    }

    public DNode getNext() {
        return next;
    }

    public DNode getPrevious() {
        return previous;
    }

    public void setNext(DNode next) {
        this.next = next;
    }

    public void setPrevious(DNode previous) {
        this.previous = previous;
    }

}
