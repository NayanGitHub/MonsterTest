package com.monster.main;

import java.util.*;
 public class DecodeOctal {
    public static void main(String args[]) {
        int octnum, rem, quot, i = 1, j;
        int binnum[] = new int[100];
        Scanner scan = new Scanner(System.in);
        System.out.print("Enter Octal Number : ");
        String octalStr = scan.nextLine();
        int binary = octalToBinary(octalStr);
        System.out.println("Binary is: "+binary);
        octnum = Integer.parseInt(scan.nextLine(),8);
         quot = octnum;
         while (quot != 0) {
            binnum[i++] = quot % 2;
            quot = quot / 2;
        }
         System.out.print("Equivalent Binary Value of " + octnum + " is :\n");
        for (j = i - 1; j > 0; j--) {
            System.out.print(binnum[j]);
        }
         String strArray[] = Arrays.stream(binnum)
            .mapToObj(String::valueOf)
            .toArray(String[]::new);
         //System.out.println(strArray);
         //System.out.println(binaryToString(strArray.toString()));
     }
     /*public static String binaryToByte(String[] binary) {
        String output = "";
        for (int i = 0; i < binary.length(); i += 8) {
            String next = binary.substring(i, i + 8);
            int code = Integer.parseInt(next, 2);
            output += ((char) code);
        }
        return output;
    }*/
     /*public static String binaryToByte(String binary) {
         String output = "";
         for (int i = 0; i < binary.length(); i += 8) {
             String next = binary.substring(i, i + 8);
             int code = Integer.parseInt(next, 2);
             output += ((char) code);
         }
         return output;
     } */
    
    public static int octalToBinary(String octal) {
        int binary = 0;
        for (int i = 0; i < octal.length(); i++) {
            char octalDigit = octal.charAt(i);
            int octalDigitValue = octalDigit - '0';
            // Octal must be 0 - 7
            if (0 <= octalDigitValue && octalDigitValue <= 7) {
                binary = octalDigitValue + binary <<3;
            } else {
                throw new NumberFormatException("Invalid octal number " + octal);
            }
        }
        return binary;
    }
}
