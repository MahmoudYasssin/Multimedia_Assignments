/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lz77.decompretion;

/**
 *
 * @author a
 */
import java.util.*;

public class LZ77Decompretion {

    /**
     * @param args the command line arguments
     */
    public static Scanner input=new Scanner(System.in);
    public static void main(String[] args) {
        // TODO code application logic here
        System.out.println("Enter the number of tags : ");
        int num_of_tags;
        num_of_tags=input.nextInt();
        int i;
        int pos=0;
        int len=0;
        String next;
        String str ="";
        int g=0,j=0;
        for(i=0;i<num_of_tags;i++)
        {
            pos=input.nextInt();
            len=input.nextInt();
            next=input.next();
            if(str.isEmpty())
            {
                str+=next;
            }
            else
            {
               String temp;
                g=str.length()-pos;
               j=g+len;
               temp=str.substring(g, j);
               str+=temp;
               str+=next;
            }
        }
        System.out.println(str);
    }
    
}

