import java.net.*;
import java.io.*;
class MyClient1b{
public static void main(String args[])throws Exception{
Socket s=new Socket("localhost",3333);
System.out.println("Connected...");
DataInputStream din=new DataInputStream(s.getInputStream());
DataOutputStream dout=new DataOutputStream(s.getOutputStream());
BufferedReader br=new BufferedReader(new InputStreamReader(System.in));

System.out.println("From Server:");
System.out.println("These are the list of branches available:");

int MSc_AIML=din.readInt();
System.out.println("1. MSc AIML:"+MSc_AIML);
int MSc_Data_Science=din.readInt();
System.out.println("2. MSc Data Science:"+MSc_Data_Science);
int MSc_CyberSecurity=din.readInt();
System.out.println("3. MSc Cyber Security :"+MSc_CyberSecurity);
String dep="";
System.out.println("Enter the department : " );
dep=br.readLine();
System.out.println("Need admission for "+dep);
dout.writeUTF(dep);
dout.flush();

int m1,m2,m3;
System.out.println("Enter the Maths mark : " );
m1=din.readInt();
dout.writeInt(m1);
dout.flush();
System.out.println("Enter the Chemistry mark : " );
m2=din.readInt();
dout.writeInt(m2);
dout.flush();
System.out.println("Enter the Physics mark : " );
m3=din.readInt();
dout.writeInt(m3);
dout.flush();

String str="",str2="";
while(!str.equals("stop")){
str=br.readLine();
dout.writeUTF(str);
dout.flush();
str2=din.readUTF();
System.out.println("Server says: "+str2);
}
dout.close();
s.close();
}}
