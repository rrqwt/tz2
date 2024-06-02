package org.example;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.math.BigInteger;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        String filename = "numbers.txt";
        ArrayList<BigInteger> numbers = readNumbersFromFile(filename);
        try {
            System.out.println("Минимальное: " + min(numbers));
            System.out.println("Максимальное: " + max(numbers));
            System.out.println("Сумма: " + sum(numbers));
            System.out.println("Произведение: " + mult(numbers));
        } catch (IOException e) {
            System.err.println("An error occurred: " + e.getMessage());
        }
    }
    public static ArrayList<BigInteger> readNumbersFromFile(String fileName) {
        ArrayList<BigInteger> numbersList = new ArrayList<>();

        try {
            FileReader fileReader = new FileReader(fileName);
            BufferedReader bufferedReader = new BufferedReader(fileReader);

            String line;
            while ((line = bufferedReader.readLine()) != null) {
                BigInteger number = new BigInteger(line.trim());
                numbersList.add(number);
            }

            bufferedReader.close();
        } catch (IOException e) {
            System.err.println("Ошибка при чтении файла: " + e.getMessage());
        }

        return numbersList;
    }

    public static BigInteger min(ArrayList<BigInteger> numbers) throws IOException {
        BigInteger min = numbers.get(0);
        for (int i = 1; i < numbers.size(); i++) {
                BigInteger current = numbers.get(i);
                if (current.compareTo(min) < 0) {
                    min = current;
                }
            }
            return min;
    }

    public static BigInteger max(ArrayList<BigInteger> numbers) throws IOException {
        BigInteger max = numbers.get(0);
        for (int i = 1; i < numbers.size(); i++) {
            BigInteger current = numbers.get(i);
            if (current.compareTo(max) > 0) {
                max = current;
            }
        }
        return max;
    }

    public static BigInteger sum(ArrayList<BigInteger> numbers) throws IOException {
        BigInteger sum = BigInteger.ZERO;
        for (BigInteger current : numbers) {
            sum = sum.add(current);
        }
        return sum;
    }

    public static BigInteger mult(ArrayList<BigInteger> numbers) throws IOException {
        BigInteger mult = BigInteger.ONE;
        for (BigInteger current : numbers) {
            mult = mult.multiply(current);
        }
        return mult;
    }
}