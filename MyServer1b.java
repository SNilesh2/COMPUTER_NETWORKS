import java.net.*;
import java.io.*;
class MyServer1b{
public static void main(String args[])throws Exception{
int MSc_AIML=0;
int MSc_Data_Science=0;
int MSc_CyberSecurity=0;
System.out.println("Waiting for client...");
ServerSocket ss=new ServerSocket(3333);
Socket s=ss.accept();
DataInputStream din=new DataInputStream(s.getInputStream());
DataOutputStream dout=new DataOutputStream(s.getOutputStream());
BufferedReader br=new BufferedReader(new InputStreamReader(System.in));

System.out.println("To Client:");
System.out.println("1. MSc AIML:");
MSc_AIML=Integer.parseInt(br.readLine());
dout.writeInt(MSc_AIML);
dout.flush();
System.out.println("2. MSc Data Science : ");
MSc_Data_Science=Integer.parseInt(br.readLine());
dout.writeInt(MSc_Data_Science);
dout.flush();
System.out.println("3. MSc Cyber Security :");
MSc_CyberSecurity=Integer.parseInt(br.readLine());
dout.writeInt(MSc_CyberSecurity);
dout.flush();

String dep="";
dep=din.readUTF();
System.out.println("Need admission for "+dep);
System.out.println("Please send the mark details of the student ");

int m1,m2,m3;
int mark=0;
m1=din.readInt();
m2=din.readInt();
m3=din.readInt();
mark=m1+m2+m3;

String str="",str2="";
while(!str.equals("stop")){
str=din.readUTF();
System.out.println("client says: "+str);
str2=br.readLine();
dout.writeUTF(str2);
dout.flush();
}
din.close();
s.close();
ss.close();
}}
