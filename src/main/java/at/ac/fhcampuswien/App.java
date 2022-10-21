package at.ac.fhcampuswien;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;
import java.util.Formatter; // fuer String.format

public class App {

    // Implement all methods as public static
    public static void oneMonthCalendar(int daysOfMonth, int firstDayOfMonth){
        int[] allDays=new int[daysOfMonth];
        int daysofweek=7;
        daysofweek=daysofweek-firstDayOfMonth+1;
        for(int i=0;i<allDays.length;i++){
            allDays[i]=i+1;
        }
        for(int i=1;i<firstDayOfMonth;i++){
            System.out.print("   ");
        }
        for(int count=1;count<=allDays.length;count++){ // von 1 bis ink. daysOfMonth
            String dayToFormattedString = String.format("%2d", allDays[count-1]); // allDays an den Stellen 0 bis daysOfMonth - 1 // Format Specifier "%2d", 2 Stellen
            System.out.print(dayToFormattedString + " ");
            daysofweek--;
            if(daysofweek==0 || count== allDays.length){
                System.out.println();
                daysofweek=7;
            }
        }
        //System.out.println();
    }

    public static long[] lcg(long seed){
        long[] result = new long[10];
        long m = (long) Math.pow(2,31);
        int a = 1103515245;
        int c = 12345;
        for(int i=0;i<result.length;i++){
            if(i==0){result[i]=(a*seed+c)%m;}
            else {result[i]=(a*result[i-1]+c)%m;}
        }
        return result;
    }

    public static void guessingGame(int numberToGuess){
        Scanner sc = new Scanner(System.in);
        int count=1;
        while(count<=10) {
            System.out.print("Guess number " + count + ": ");
            int guess=sc.nextInt();

            if (numberToGuess < guess && count!=10) {
                System.out.println("The number AI picked is lower than your guess.");
            }
            if (numberToGuess > guess && count!=10) {
                System.out.println("The number AI picked is higher than your guess.");
            }
            if (numberToGuess == guess) {
                System.out.println("You won wisenheimer!");
                return;
            }
            count++;
        }
        System.out.println("You lost! Have you ever heard of divide & conquer?");
    }

    public static int randomNumberBetweenOneAndHundred(){
        Random random = new Random();
        int randVal=random.nextInt(100)+1;
        return randVal;
    }

    public static boolean swapArrays(int[] array1, int[] array2){

        if(array1.length!=array2.length){
            return false;
        } else {
            int[] help = new int[array1.length];
            for(int i=0;i<array1.length;i++){
                help[i]=array1[i];
            }
            for(int i=0;i<array2.length;i++){
                array1[i]=array2[i];
            }
            for(int i=0;i<help.length;i++){
                array2[i]=help[i];
            }
            return true;
        }
    }

    public static String camelCase(String string){
        char[] chars = string.toCharArray();
        StringBuilder result = new StringBuilder();
        final int UPPER_CASE_A = 65;
        final int UPPER_CASE_Z = 90;
        final int LOWER_CASE_A = 97;
        final int LOWER_CASE_Z = 177;
        final int SPACE = 32;
        for(int i=0;i<chars.length;i++){
            int currentChar = (int) chars[i];
            if(i==0){
                if (currentChar >= UPPER_CASE_A && currentChar <= UPPER_CASE_Z) {
                        result.append((char) currentChar);
                } else if (currentChar >= LOWER_CASE_A && currentChar <= LOWER_CASE_Z) {
                        result.append(createUpperFromLower((char) currentChar));
                }
            } else {
                int previousChar = (int) chars[i - 1];
                if (currentChar >= UPPER_CASE_A && currentChar <= UPPER_CASE_Z) {
                    if (previousChar == SPACE) {
                        result.append((char) currentChar);
                    } else {
                        result.append(createLowerFromUpper((char) currentChar));
                    }
                } else if (currentChar >= LOWER_CASE_A && currentChar <= LOWER_CASE_Z) {
                    if (previousChar == SPACE) {
                        result.append(createUpperFromLower((char) currentChar));
                    } else {
                        result.append((char) currentChar);
                    }
                }
            }

        }
        return result.toString();
    }

    public static char createUpperFromLower(char lowerCaseChar){
        int lowerCaseCharAsInt = (int) lowerCaseChar;
        char upperCaseChar = (char) (65 + (lowerCaseCharAsInt - 97));
        return upperCaseChar;
    }
    public static char createLowerFromUpper(char upperCaseChar){
        int upperCaseCharAsInt = (int) upperCaseChar;
        char lowerCaseChar = (char) (97 + (upperCaseCharAsInt - 65));
        return lowerCaseChar;
    }

    public static int checkDigit(int[] input){

        int[] gewichte=new int[input.length];
        int[] produkte = new int[input.length];
        for(int i=0;i<input.length;i++){
            gewichte[i]=i+2;
            produkte[i]=gewichte[i]*input[i];
        };
        int sum = Arrays.stream(produkte).sum();
        int mod11 = sum % 11;
        int checksum=11-mod11;
        if(checksum==10){checksum=0;}
        if(checksum==11){checksum=5;}
        return checksum;
    }

    public static void main(String[] args) {
        // test your method implementations here
        // make method calls
        // print their results
        // etc.
        oneMonthCalendar(31,2);
        //guessingGame(randomNumberBetweenOneAndHundred());
        /*int[] Array1={1,2,3,4,5};
        int[] Array2={5,6,7,8};
        System.out.println(swapArrays(Array1,Array2));*/
        //System.out.println(camelCase("AnY noise annoYs an oYster but a noisY noise annoYs an oYster more"));
        /*int[] test = {3,9,1,5,8};
        System.out.println(checkDigit(test));*/
        //lcg(54645681);
    }
}