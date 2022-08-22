										File Handling In Java
										=====================
File handling implies how to read from and write to the file in Java. Java provides the basic I/O package for 
reading and writing the streams.
java.io package allows to do all Input and Output tasks in Java.

Java uses the concept of Stream to make Input and Output operations on a File.
Stream
======
Stream is a sequence of data and it can be of two types 1.Byte Stream
2.Character Stream

Byte Stream -> It mainly incorporate the byte  data..
When an input and output process happens with byte data then it is called the file process with byte stream..

Character Stream -> It is a stream incorporate with characters. When an Input and Output process happens to the 
Character then it is called as File Handling Process with Character stream.

Java File Methods
=================
canRead() -> Tests whether file is readable or not.
canWrite() -> Tests whether the file is writable or not.
createNewFile() -> Creates an Empty file.
Delete() -> Deletes a file.
Exists() -> Tests whether the file exist or not.
getName() -> Returns the name of the file.
getAbsolutePath() -> Returns the absolute pathname of the file.
Length() -> Returns the size of the file in bytes.
List() -> Returns the Array of the file in the directory.
Mkdir() -> use to create the directory.

File Operations In Java
=======================
First you need to create a file then once you create a file, you need to get the information out of the file.
After that you have to write the information to the file and then you have to read the data to the file.

Lets take an example:-
----------------------
1. Cerate a file. In this case in order to create the file use the createNewFile() method. And this method 
returns true if the file created successfully else rerturns false if the file already exist.
==================================================================================
package FileHandling;

import java.io.File; //Import the file class
import java.io.IoException; //Import the IOException class to handle errors

public class CreateFile {
	public static void main(String []args){
		try{
			File myObj = new File("D:\\FileHandling\\File1.txt"); //I am creating the file in the specified directory.
			//If i will not give the path then the file will get created in Eclipse Workspace.

			if(myObj.createNewFile()){
				System.out.println("File created: "+myObj.getName());
			}else{
				System.out.println("File Already Exists");
			}
		}catch(IOException e){
			System.out.println("An error occurred.");
			e.printStackTrace();
		}
	}
}
==================================================================================

package FileInformation;

import java.io.File; //Import the file class
import java.io.IoException; //Import the IOException class to handle errors

public class FileInformation {
	public static void main(String []args){
		try{
			File myObj = new File("D:\\FileHandling\\File1.txt"); //I am creating the file in the specified directory.
			//If i will not give the path then the file will get created in Eclipse Workspace.
			
			if(myObj.exists()){
				System.out.println("File name: "+myObj.getName());
				System.out.println("Absolute path: "+myObj.getAbsolutePath());
				System.out.println("Writeable: "+myObj.canWrite());
				System.out.println("Readable: "+myObj.canRead());
				System.out.println("File size in bytes: "+myObj.length());
			}else{
				System.out.println("File doesn't exists");
			}
		}
	}
==================================================================================
Write to File
==============
package FileHandling;

import java.io.FileWriter;

public class WriteToFile {
	public static void main(String []args){
	try {
		FileWriter myWriter = new FileWriter("D:\\FileHandling\\Filef1.txt");
		myWriter.write("Java is the prominent programming language of the millenium");
		myWriter.close();
			System.out.println("Successfully wrote to the file.");
	}catch(IOException e){
		System.out.println("An error occured.");
		e.printStackTrace();
	}
  }
}

==================================================================================
Read From File
==============
import java.io.FileWriter;

public class ReadFromFile {
	public static void main(String []args){
		try {
		File myObj = new File("D:\\FileHandling\\Filef1.txt");
		Scanner myReader = new Scanner(myObj);
		while(myReader.hasNextLine()){
			String data = myReader.nextLine();
			System.out.println(data);
		}
		myReader.close();
	}catch(IOException e){
		System.out.println("An error occured.");
		e.printStackTrace();
	}
  }
}
======================================================================================