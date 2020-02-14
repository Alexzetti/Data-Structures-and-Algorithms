/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data.structures;

/**
 *
 * @author AR
 */
public class Problem2 {

    public static void main(String[] args) {

        int[] array = {1,2,3,4,5,6,8,9,10,11,12,13,14};  

        findMissing(array);

    }

    public static void findMissing(int[] array) {

        Boolean[] bool = new Boolean[array.length + 1]; 
        int i = 0;
        while (i < bool.length) {                       
            bool[i] = false;
            i++;
        }

        i = 0;                                         
        while (i < array.length) {
            int myNumber = 0;                          
            myNumber = array[i];

            bool[myNumber - 1] = true;                  
            i++;                                        

        }

        for (int a = 0; a < bool.length; a++) {        

            if (bool[a] == false) {
                System.out.printf("The missing number is: %d\n ", a + 1);
            }

        }

    }

}
