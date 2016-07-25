package com.thejas;

import java.io.*;
class Persist{
 public static void main(String args[])throws Exception{
  Student s1 =new Student("hello champ");

  FileOutputStream fout=new FileOutputStream("f.ser");
  ObjectOutputStream out=new ObjectOutputStream(fout);

  out.writeObject(s1);
  out.flush();

  System.out.println("serialized success");
 }
}