/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
//package Binary_Arithmetic_Coding;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import static jdk.nashorn.internal.objects.NativeArray.map;

import java.io.File;  // Import the File class
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;  // Import the IOException class to handle errors

import java.io.*;

import java.io.FileWriter;   // Import the FileWriter class
import java.io.IOException;  // Import the IOException class to handle errors
import static java.lang.Math.pow;

/**
 *
 * @author a
 */
public class BinaryArithmeticCoding 
{

    public static class Node 
    {
        double lower;
        double uper;
    }

    static List<String> result = new ArrayList<>();
    
    static Map<Character, Node> finall = new HashMap<>();
    static String RR="";

    public static String Comprassed(Map<Character, Node> D, String s, double min_prb) 
    {

        double L = 0.0;
        double U = 1.0;
        double preL = 0.0;
        double preU = 0.0;
        Node p = new Node();
        String re = "";
        char C;

        /*
        Lower (Symbol) = Lower+ Range * Low_Range(Symbol)
        Upper (Symbol)= Lower+ Range * High_Range(Symbol)
         */
        for (int i = 0; i < s.length(); i++) 
        {
            C = s.charAt(i);
            if (i == 0) 
            {
                p = D.get(C);
                L = p.lower;
                U = p.uper;
                preL = L;
                preU = U;
                //  System.out.println(L);
                //  System.out.println(U);
                //   System.out.println("***********");
            }
            else 
            {
                p = D.get(C);
                L = preL + (preU - preL) * p.lower;
                U = preL + (preU - preL) * p.uper;

                //  System.out.println(L);
                //  System.out.println(U);
                //  System.out.println("***********");
            }
            while (!(L < 0.5 && 0.5 < U)) 
            {
                while (U < 0.5) //scaling E1
                {

                    U = U * 2;
                    L = L * 2;
                    re += "0";
                    //   System.out.println(L);
                    //  System.out.println(U);
                    ///  System.out.println("***********");
                }
                while (L > 0.5) //scaling E2
                {
                    // preL=L;
                    // preU=U;    
                    L = (L - 0.5) * 2;
                    U = (U - 0.5) * 2;
                    re += "1";
                    //  System.out.println(L);
                    //  System.out.println(U);
                    // System.out.println("***********");
                }
                preL = L;
                preU = U;

            }

        }
        

        while ((1 / Math.pow(2, k)) > min_prb) 
        {
            k++;
        }
        
        if (k == 1) 
        {
            re += "1";
            RR+="1";
        } 
        else 
        {
            re += "1";
            RR+="1";
            for (int i = 1; i < k; i++) {
                re += "0";
                RR+="0";
            }
        }

        return re;
    }

    static int k = 0;
    public static Scanner input = new Scanner(System.in);

    public static void main(String[] args) throws IOException 
    {
        int num_of_char;
        System.out.println("Enter number of char");
        num_of_char = input.nextInt();
        Map<Character, Node> D = new HashMap<>();
        double l1 = 0;
        double l2 = 0;
        double[] arr;
        
        arr = new double[num_of_char];
        double min_prb = 0;
        for (int i = 0; i < num_of_char; i++) 
        {
            char a;
            double b;

            a = input.next().charAt(0);
            b = input.nextDouble();

            arr[i] = b;

            if (i == 0) 
            {
                l1 = 0;
                l2 = b;
            }
            else 
            {
                l1 = l2;
                l2 = b + l2;
            }
            

            Node w = new Node();
            w.lower = l1;
            w.uper = l2;
            D.put(a, w);
        }

        min_prb = arr[0];
        for (int i = 0; i < num_of_char; i++) 
        {
            if (arr[i] <= min_prb) 
            {
                min_prb = arr[i];
            }
        }

        //    System.out.println(Arrays.asList(D));
        /*  for (Map.Entry<Character,Node> entry : D.entrySet()) 
        {
            System.out.println(entry.getKey() + ":" + entry.getValue().lower +":"+entry.getValue().uper);
        }*/
        
        System.out.println("Enter the string");
        String s = "";
        s = input.next();
        String F;
        F = Comprassed(D, s, min_prb);
        System.out.println(F);
        String r = Decomprassed(F, k, D);
        System.out.println(r);
        ///////////////////////////////////////////////////////////////
        
        try 
        {
            BufferedWriter bw = new BufferedWriter(new FileWriter("C:\\Users\\a\\Documents\\NetBeansProjects\\Binary\\output.txt"));
            //  bw.write(F+"\n");
           //   bw.write(r+"\n");
            bw.close();

        } 
        catch (Exception ex) 
        {
            return;
        }

        try 
        {
            BufferedReader br = new BufferedReader(new FileReader("C:\\Users\\a\\Documents\\NetBeansProjects\\Binary\\output.txt"));
            String S;
            while ((S = br.readLine()) != null) {
                System.out.println(S);
            }
            br.close();

        } 
        catch (Exception ex) 
        {
            return;
        }

        //////////////////////////////////////////////////////////////////////////
    }

    ////////////////////////////////////////////Decom////////////////////////////////
    public static String Decomprassed(String s, int k, Map<Character, Node> D) 
    {
        double LO = 0.0;
        double UP = 0.0;
        double PreLO = 0.0;
        double PreUP = 0.0;
        int x = 0;
        int y = 0;
        y = k;
        double tempcode=0;
         tempcode = Integer.parseInt(RR, 2);
         tempcode /= Math.pow(2, k);
         
         double XX;
         
        
       
       
        
        
        String fin = "";

        int co = 0;

        double code = Integer.parseInt(s.substring(x, y), 2);
        code /= Math.pow(2, k);
        XX=code;
        System.out.println("code = "+code);
        System.out.println("**************");
                    
                    

        for (int i = 0; i < s.length(); i++) 
        {
            Node temp = new Node();
            for (Map.Entry<Character, Node> entry : D.entrySet()) 
            {
                if (code > entry.getValue().lower && code < entry.getValue().uper) 
                {
                    fin+= entry.getKey();
                    temp = entry.getValue();
                    System.out.println("fun = "+fin);
                    if(XX==tempcode)
                    {
                        return fin;
                    }
                 
                    
                }
            }

            if (co == 0) 
            {
              
                LO = temp.lower;
                UP = temp.uper;
                
                PreLO = LO;
                PreUP = UP;
                co++;
                System.out.println("LO = "+LO);
                System.out.println("UP = "+UP);
                System.out.println("**************");
            } 
            else 
            {
                LO = PreLO + (PreUP - PreLO) * temp.lower;
                UP = PreLO + (PreUP - PreLO) * temp.uper;
                System.out.println("LO = "+LO);
                System.out.println("UP = "+UP);
                System.out.println("**************");
            }
            //Check

            while (!(LO < 0.5 && 0.5 < UP) && (y<=s.length()) ) 
            {
                while (UP < 0.5 &&y<=s.length()) //scaling E1
                {
                    UP = UP * 2;
                    LO = LO * 2;
                    System.out.println("LO = "+LO);
                    System.out.println("UP = "+UP);
                    x++;
                    y++;
                    System.out.println(" = "+x);
                    System.out.println("y = "+y);
                    System.out.println("**************");
                  
                }
                while (LO > 0.5 && y<=s.length()) //scaling E2
                {
                    LO = (LO - 0.5) * 2;
                    UP = (UP - 0.5) * 2;
                    System.out.println("LO = "+LO);
                    System.out.println("UP = "+UP);
                    
                    
                    x++;
                    y++;
                    System.out.println(" = "+x);
                    System.out.println("y = "+y);
                    System.out.println("**************");
                  
                }

                PreLO = LO;
                PreUP = UP;
                 System.out.println("preLO = "+PreLO);
                 System.out.println("preUP = "+PreUP);
               
                code = Integer.parseInt(s.substring(x, y), 2);
                code /= Math.pow(2, k);
                XX=code;
                 System.out.println("code = "+code);
                  System.out.println("******************");

            }
            code = (code - PreLO) / (PreUP - PreLO);
             System.out.println("code = "+code);
             System.out.println("******************");
       
        }

        return fin;
    }

}
