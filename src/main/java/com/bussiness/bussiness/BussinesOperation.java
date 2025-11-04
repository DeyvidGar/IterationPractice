package com.bussiness.bussiness;

import java.util.List;
import java.util.Random;
import java.util.Scanner;
import java.util.stream.IntStream;

/** Bussiness class. */
public class BussinesOperation {

    /** Attribute to read values in console. */
    private final Scanner scanner;

    /** Constructor. */
    public BussinesOperation(Scanner scanner) {
        this.scanner = scanner;
    }

    /** Main operation, show in console the information and possibles combinations. */
    public void operation() {
        printInConsole("Se revisara la suma de: ");
        int calculateValue = scanner.nextInt();

        List<Integer> list = generateValues();
        printInConsole("Valores = " + list);

        int[] array = filterValues(list, calculateValue);

        boolean anyCombination = false;
        for (int i = 0; i < array.length; i++) {
            for (int j = (i - 1); j >= 0; j--) {

                int suma = array[i] + array[j];
                if (suma == calculateValue) {
                    printInConsole(array[j] + " + " + array[i] + "= " + suma);
                    anyCombination = true;
                }

            }
        }

        if (!anyCombination) {
            printInConsole("No existen combinaciones :)");
        }

    }

    /**
     * Filter valid values in collection.
     * @param list collection.
     * @param calculateValue find values minus that this.
     * @return array with only valid values.
     */
    private int[] filterValues(List<Integer> list, int calculateValue) {
        return list.stream().filter(v -> v < calculateValue).mapToInt(Integer::intValue).toArray();
    }

    /** Generate random values. */
    private static List<Integer> generateValues() {
        return IntStream.generate(() -> new Random().nextInt(20))
                .limit(10)
                .boxed()
                .toList();
    }

    /** Method to print in console. */
    private void printInConsole(String message) {
        System.out.println(message);
    }
}
