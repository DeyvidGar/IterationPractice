package com.bussiness;

import com.bussiness.bussiness.BussinesOperation;

import java.util.Scanner;

/** Main class.  */
public class IteracionesMain {

    /**
     * Main method, run here the application.
     * @param args params.
     */
    public static void main(String[] args) {
        BussinesOperation bo = new BussinesOperation(new Scanner(System.in));
        bo.operation();
    }
}
