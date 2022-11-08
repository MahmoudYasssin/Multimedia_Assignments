/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lz.pkg77;

/**
 *
 * @author a
 */
import java.util.*;

public class LZ77 {
   

    /**
     * @param args the command line arguments
     */
    
    public static Scanner input=new Scanner(System.in);
    public static void main(String[] args) {
     
       
        String str;
        System.out.println("Enter the string : ");
        str=input.next();
       String s="";
       String temp="";
       int po=0;
       int len=0;
       char next;
       int l=0;
       int i;       
        for( i=0;i<str.length();i++)
        {
            
            temp+=str.charAt(i);
            
             next=str.charAt(i);
            if(s.contains(temp) && i!=str.length()-1) 
            { 
               continue;
            }
            else if(temp.length()==1 && !s.contains(temp))
            {
                   
      
                System.out.println(po+" , "+len+" , "+next);
    
                s+=temp;
                temp="";
            }
            else
            {
                s+=temp;
                l=i-temp.length()+1;
                temp=temp.substring(0, temp.length() - 1);
                po=l-s.indexOf(temp);
                len=i-l;
                System.out.println(po+" , "+len+" , "+next);
                temp="";
          
            }
        }
    }
}