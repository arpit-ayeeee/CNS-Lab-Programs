//CRC
import java.util.Scanner;
import java.io.*;

public class Program7{
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);

        //Entering data
        System.out.print("Enter the message bits: ");
        String message = sc.nextLine();
        System.out.print("Enter the generator: ");
        String generator = sc.nextLine();
        int data[] = new int[message.length() + generator.length() - 1];
        int divisor[] = new int[generator.length()];
        for(int i=0; i<message.length(); i++){
            data[i] = Integer.parseInt(message.charAt(i) + "");
        }
        for( int i=0; i<generator.length(); i++){
            divisor[i] = Integer.parseInt(generator.charAt(i) + "");
        }

        //Checksum calculation
        for(int i=0; i<message.length(); i++){
            if(data[i] == 1){
                for(int j=0; j<divisor.length; j++){
                    data[i+j] ^=divisor[j];
                }
            }
        }

        //Display
        System.out.print("The checksum is : ");
        for(int i=0; i<message.length(); i++){
            data[i] = Integer.parseInt(message.charAt(i) + "");
        }
        for(int i=0; i<data.length; i++){
            System.out.print(data[i]);
        }
        System.out.println();

        //Input checksum
        System.out.print("Enter the checksum: ");
        message = sc.nextLine();
        System.out.print("Enter the generator: ");
        generator = sc.nextLine();
        data = new int[message.length() + generator.length() - 1];
        divisor = new int[generator.length()];
        for(int i=0; i<message.length(); i++){
            data[i] = Integer.parseInt(message.charAt(i) + "");
        }
        for( int i=0; i<generator.length(); i++){
            divisor[i] = Integer.parseInt(generator.charAt(i) + "");
        }

        //Checking remainder
        for(int i=0; i<message.length(); i++){
            if(data[i] == 1){
                for(int j=0; j<divisor.length; j++){
                    data[i+j] ^= divisor[j];
                }
            }
        }

        //Display validity
        boolean valid = true;
        for(int i=0; i<data.length; i++){
            if(data[i] == 1){
                valid = false;
                break;
            }
        }

        //Result
        if(valid == true){
            System.out.println("Data stream is valid");
        }
        else{
            System.out.println("Data stream is invalid");
        }
    }
}