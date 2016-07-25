package com.thejas;

import java.io.*;
public class DeserializeDemo
{
   public static void main(String [] args)
   {
      Student e = null;
      try
      {
         FileInputStream fileIn = new FileInputStream("f.ser");
         ObjectInputStream in = new ObjectInputStream(fileIn);
         e = (Student) in.readObject();
         in.close();
         fileIn.close();
         System.out.println(e.name);
      }catch(IOException i)
      {
         i.printStackTrace();
         return;
      }catch(ClassNotFoundException c)
      {
         System.out.println("student class not found");
         c.printStackTrace();
         return;
      }
      System.out.println("Deserialized ...");
      
    }
}
