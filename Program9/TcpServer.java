// import java.io.*;
// import java.net.ServerSocket;
// import java.net.Socket;

// public class TcpServer{
//     public static void main(String args[]) throws Exception{
//         ServerSocket sersock = new ServerSocket(4000);
//         System.out.println("Server ready for connnection");
//         Socket sock = sersock.accept();
//         System.out.println("Connection successfull, waiting for file");

//         InputStream istream = sock.getInputStream();
//         BufferedReader br = new BufferedReader(new InputStreamReader(istream));
//         String fname = br.readLine();
//         BufferedReader contentRead = new BufferedReader(new FileReader(fname));

//         OutputStream ostream = sock.getOutputStream();
//         PrintWriter pwrite = new PrintWriter(ostream, true);
//         String str;
//         while((str = contentRead.readLine()) != null){
//             pwrite.println(str);
//         }
//         System.out.println("File contents sent successfully");

//         sersock.close();
//         sock.close();
//         br.close();
//         contentRead.close();
//         pwrite.close();
//     }
// }


import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
public class TcpServer  
{
  public static void main(String args[]) throws Exception
  {                           
     ServerSocket sersock = new ServerSocket(4000);
     System.out.println("Server ready for connection");
     Socket sock = sersock.accept();           
     System.out.println("Connection successful | wating for file name");
     InputStream istream = sock.getInputStream( );
     BufferedReader br =new BufferedReader(new InputStreamReader(istream));
     String fname = br.readLine( );                        
     BufferedReader contentRead = new BufferedReader(new FileReader(fname) );                        
     OutputStream ostream = sock.getOutputStream( );
     PrintWriter pwrite = new PrintWriter(ostream, true);
     String str;
     while((str = contentRead.readLine()) !=  null) 
     {
	pwrite.println(str);         
     }
     System.out.println("File Contents sent successfully");
 
     sock.close();  sersock.close();       
     pwrite.close();  br.close(); contentRead.close();
  }
}