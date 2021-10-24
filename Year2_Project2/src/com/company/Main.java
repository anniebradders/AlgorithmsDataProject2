package com.company;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    static String city[] = {"Atlanta", "Boston", "Chicago", "Miami", "Philadelphia"};
    static int flight[][] = {{701, 2, 3},
            {702, 3, 2},
            {705, 5, 3},
            {708, 3, 4},
            {711, 2, 5},
            {712, 5, 2},
            {713, 5, 1},
            {715, 1, 4},
            {717, 5, 4},
            {718, 4, 5}
    };
    static int option = 0;
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int flightNum = 0;
        int originNum = 0;
        int destNum = 0;
        System.out.print("\n1) Find Origin and Destination" +
                "\n2) Find Flight Number" +
                "\nPlease enter option: ");
        option = in.nextInt();

        switch (option){
            case 1:
                System.out.println("Enter a flight number: ");
                flightNum = in.nextInt();

                System.out.println("Origin: " + city[getFlight(flightNum,originNum,destNum)[1]-1]);
                System.out.println("Destination: " + city[getFlight(flightNum,originNum,destNum)[2]-1]);
                break;
            case 2:
                in.nextLine();
                System.out.println("Enter Origin: ");
                String origin = in.nextLine();
                System.out.println("Enter Destination: ");
                String destination = in.nextLine();

                originNum = Arrays.asList(city).indexOf(origin) + 1;
                destNum = Arrays.asList(city).indexOf(destination) + 1;

                System.out.println("Flight Number: " + getFlight(flightNum,originNum,destNum)[0]);
        }
    }

    static int[] getFlight(int flightNum,int originNum, int destNum){
        int[] flightDetails = {};

        for(int i = 0; i < flight.length; i++){
            for(int j = 0; j < flight[i].length; j++){
                if(option == 1) {
                    if (flight[i][j] == flightNum) {
                        flightDetails = flight[i];
                    }
                }else{
                    if ((originNum == flight[i][1]) && (destNum == flight[i][2])){
                        flightDetails = flight[i];
                    }
                }
            }
        }
        return flightDetails;
    }
}
