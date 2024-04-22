MyClient.java
import java.util.Scanner;
import java.rmi.*;
public class MyClient
{
public static void main(String args[])
{
try
{
Concat stub=(Concat)Naming.lookup("localhost");
Scanner input = new Scanner(System.in);
String x,y;
System.out.println("Enter String 1: ");
x = input.nextLine();
System.out.println("Enter String 2: ");
y = input.nextLine();
System.out.println(stub.concat(x,y));
}
catch(Exception e){}
}
}



MyServer.java

import java.rmi.*;
import java.rmi.registry.*;
public class MyServer
{
public static void main(String args[])
{
try
{
Concat stub=new ConcatRemote();
Naming.rebind("localhost",stub);
}
catch(Exception e)
{
System.out.println(e);
}
}
}




ConcatRemote.java

import java.rmi.*;
import java.rmi.server.*;
public class ConcatRemote extends UnicastRemoteObject implements Concat
{
ConcatRemote()throws RemoteException
{
super();
}
public String concat(String x,String y)
{
return x+y;
}
}



Concat.java
import java.rmi.*;
public interface Concat extends Remote
{
public String concat(String x,String y)throws RemoteException;
}

Note: Save all the codes in one folder named RMI.


steps to run
javac *.java
rmic ConcatRemote
Warning
rmicregistry

java MyServer
java  MyClient