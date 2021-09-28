package org.example;

/*
 *  UCF COP3330 Fall 2021 Assignment 36 Solution
 *  Copyright 2021 Jonathan Luong
 */

import java.util.Objects;
import java.util.Scanner;
import java.util.Random;

public class App {
    static double average(int[] nums, int count) {
        double aver = 0;
        double total = 0;

        for(int i = 0; i < count; i++) {
            total += nums[i];
        }

        aver = total / (count);

        return aver;
    }
    static int minimum(int[] nums, int count) {
        int min = nums[0];

        for(int i = 0; i < count; i++) {
            if(min > nums[i])
                min = nums[i];
        }

        return min;
    }
    static int maximum(int[] nums, int count) {
        int max = nums[0];

        for(int i = 0; i < count; i++) {
            if(max < nums[i])
                max = nums[i];
        }

        return max;
    }
    static double stdDev(int[] nums, int count) {
        double res = 0;
        double aver = average(nums, count);
        double total = aver * count;

        for(int i = 0; i < count; i++) {
            total += Math.pow((nums[i]-aver),2);
        }

        aver = total/(count);
        res = Math.sqrt(aver);

        return res;
    }

    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in); // Creates reader
        Random rand = new Random(); // Create random class

        int[] nums = new int[20];
        String nameX;
        boolean flag = true;
        int i = 0;

        while(flag) {
            System.out.printf("Enter a number: ");
            nameX = reader.nextLine();

            if(Objects.equals(nameX, "done")) {  // if 'done' turn flag to false to break loop
                flag = false;
                break;
            }

            int num = Integer.parseInt(nameX);

            nums[i] = num;
            i++; // Also a counter
        }

        System.out.printf("Numbers: %d", nums[0]);
        for(int j = 1; j < i; j++)
            System.out.printf(", %d", nums[j]);

        System.out.printf("\nThe average is %.1f", average(nums, i)); // print the func result
        System.out.printf("\nThe minimum  is %d", minimum (nums, i));
        System.out.printf("\nThe maximum  is %d", maximum (nums, i));
        System.out.printf("\nThe standard deviation is %.2f", stdDev(nums, i));


    }
}