package com.bussiness;

import java.util.List;
import java.util.Random;
import java.util.Scanner;
import java.util.stream.IntStream;

public class BussinesOperation {

    private final Scanner scanner;

    public BussinesOperation(Scanner scanner) {
        this.scanner = scanner;
    }

    public void operation() {
        printInConsole("Se revisara la suma de: ");
        int total = scanner.nextInt();

        List<Integer> list = generateValues();
        printInConsole("Valores = " + list);

        int[] array = filterValues(list, total);

        boolean anyCombination = false;
        for (int i = 0; i < array.length; i++) {
            for (int j = (i - 1); j >= 0; j--) {

                int suma = array[i] + array[j];
                if (suma == total) {
                    printInConsole(array[j] + " + " + array[i] + "= " + suma);
                    anyCombination = true;
                }

            }
        }

        if (!anyCombination) {
            printInConsole("No existen combinaciones :)");
        }

    }

    private int[] filterValues(List<Integer> list, int total) {
        return list.stream().filter(v -> v < total).mapToInt(Integer::intValue).toArray();
    }

    private static List<Integer> generateValues() {
        return IntStream.generate(() -> new Random().nextInt(20))
                .limit(10)
                .boxed()
                .toList();
    }

    private void printInConsole(String message) {
        System.out.println(message);
    }
}
