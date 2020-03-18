/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.lotto;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Random;

/**
 *
 * @author vassb
 */
public class otoslotto {
    
    public static void main(String [] args) throws IOException{
        Random rand = new Random();
        
        File file = new File("Lotto.txt");
        if (file.createNewFile()){
            System.out.println("A fájl létrehozva!");
        }
        String s;
        RandomAccessFile file = new RandomAccessFile("Lotto.txt","rw");
        
        int[] tomb = new int[5];
        int i, j, cs;
        for (i = 0; i<5; i++) {
            tomb[i] = rand.nextInt(90)+1;
        }
        
        for (i = 0; i<4; i++) {
            for (j = i+1; j<5; j++)
                if (tomb[i] == tomb[j]) {
                    while (tomb[i] == tomb[j]){
                        tomb[j] = rand.nextInt(90) + 1;
                    }
                }
        }
        
        for (i = 0; i<4; i++) {
            for (j=i+1; j<5; j++) {
                if (tomb[i]>tomb[j]) {
                    cs = tomb[i];
                    tomb[i] = tomb[j];
                    tomb[j] = cs;
                }
            }
        }
        for (i = 0; i<5; i++) {
            s = String.valueOf(tomb[i]);
            file.writeBytes(s + "\r\n");
        }
        
        file.close();
}
    
}
