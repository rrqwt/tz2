package org.example;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.Assertions;

import java.util.ArrayList;

import java.io.BufferedWriter;

import java.io.FileWriter;
import java.time.Duration;
import java.util.*;

import java.io.IOException;
import java.math.BigInteger;


public class MainTest {

    private static ArrayList<BigInteger> numbers = new ArrayList<>();
    static {
        numbers = new ArrayList<>();
        numbers.add(new BigInteger("5"));
        numbers.add(new BigInteger("10"));
        numbers.add(new BigInteger("20"));
    }
    public static class FileUtil {

        public static void generateNumbersFile(String filename, long count) {
            try (BufferedWriter writer = new BufferedWriter(new FileWriter(filename))) {
                Random random = new Random();
                for (int i = 0; i < count; i++) {
                    writer.write(Integer.toString(random.nextInt(1000)));
                    writer.newLine();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }

    @Test
    public void min() throws IOException {
        BigInteger min = Main.min(numbers);
        Assertions.assertEquals(new BigInteger("5"), min);
    }

    @Test
    public void max() throws IOException {
        BigInteger max = Main.max(numbers);
        Assertions.assertEquals(new BigInteger("20"), max);
    }

    @Test
    public void sum() throws IOException {
        BigInteger sum = Main.sum(numbers);
        Assertions.assertEquals(new BigInteger("35"), sum);
    }

    @Test
    public void mult() throws IOException {
        BigInteger mult = Main.mult(numbers);
        Assertions.assertEquals(new BigInteger("1000"), mult);
    }

    @Test
    public void testMaxPerformance() throws IOException {
        long[] sizes = {100, 1000, 10000, 100000, 1000000}; // Размеры входного файла для тестирования
        long timeLimit = 1500000; // Устанавливаем временной лимит

        for (long size : sizes) {
            String fileName = "numbers_" + size + ".txt";
            FileUtil.generateNumbersFile(fileName, size);

            long startTime = System.nanoTime();
            Main.max(numbers);
            long endTime = System.nanoTime();
            long duration = endTime - startTime;

            Assertions.assertTrue(duration <= timeLimit, "Превышено время выполнения для файла размером " + size);
        }
    }

    @Test
    public void testMinPerformance() throws IOException {
        long[] sizes = {100, 1000, 10000, 100000, 1000000}; // Размеры входного файла для тестирования
        long timeLimit = 1500000; // Устанавливаем временной лимит

        for (long size : sizes) {
            String fileName = "numbers_" + size + ".txt";
            FileUtil.generateNumbersFile(fileName, size);

            long startTime = System.nanoTime();
            Main.min(numbers);
            long endTime = System.nanoTime();
            long duration = endTime - startTime;

            Assertions.assertTrue(duration <= timeLimit, "Превышено время выполнения для файла размером " + size);
        }
    }
    @Test
    public void testSumPerformance() throws IOException {
        long[] sizes = {100, 1000, 10000, 100000, 1000000}; // Размеры входного файла для тестирования
        long timeLimit = 1500000; // Устанавливаем временной лимит

        for (long size : sizes) {
            String fileName = "numbers_" + size + ".txt";
            FileUtil.generateNumbersFile(fileName, size);

            long startTime = System.nanoTime();
            Main.sum(numbers);
            long endTime = System.nanoTime();
            long duration = endTime - startTime;

            Assertions.assertTrue(duration <= timeLimit, "Превышено время выполнения для файла размером " + size);
        }
    }

    @Test
    public void testMultPerformance() throws IOException {
        long[] sizes = {100, 1000, 10000, 100000, 1000000}; // Размеры входного файла для тестирования
        long timeLimit = 1500000; // Устанавливаем временной лимит

        for (long size : sizes) {
            String fileName = "numbers_" + size + ".txt";
            FileUtil.generateNumbersFile(fileName, size);

            long startTime = System.nanoTime();
            Main.mult(numbers);
            long endTime = System.nanoTime();
            long duration = endTime - startTime;

            Assertions.assertTrue(duration <= timeLimit, "Превышено время выполнения для файла размером " + size);
        }
    }
    @Test
    public void TimeOutMinTest() {
        Assertions.assertTimeout(Duration.ofMillis(15), () -> Main.min(numbers));
    }

    @Test
    public void TimeOutMaxTest() {
        Assertions.assertTimeout(Duration.ofMillis(15), () -> Main.max(numbers));
    }

    @Test
    public void TimeOutSumTest() {
        Assertions.assertTimeout(Duration.ofMillis(15), () -> Main.sum(numbers));
    }

    @Test
    public void TimeOutMultTest() {
        Assertions.assertTimeout(Duration.ofMillis(15), () -> Main.mult(numbers));
    }

}
