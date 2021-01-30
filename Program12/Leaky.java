import java.util.Scanner;
import java.lang.*;

public class Leaky{
    public static void main(String arg[]){
        int i;      //For iteration
        int a[] = new int[20];
        int remaining = 0, accepted, sent;

        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the number of packets");
        int n = sc.nextInt();

        System.out.println("Enter the bucket's capacity");
        int capacity = sc.nextInt();

        System.out.println("Enter the rate of flow");
        int rate = sc.nextInt();

        System.out.println("Enter the value of packets");
        for(i=1; i<=n; i++){
            a[i] = sc.nextInt();
        }

        System.out.println("Clock   Packet Size     Accepted    Sent    Remaining");
        for(i=1; i<=n; i++){
            //For accepting value
            if(a[i]!=0){
                if(remaining + a[i] > capacity){
                    accepted = -1;
                }
                else{
                    accepted = a[i];
                    remaining += a[i]; 
                }
            }
            else{
                accepted = 0;
            }
            //For sending value
            if(remaining!=0){
                if(remaining < rate){
                    sent = remaining;
                    remaining = 0;
                }
                else{
                    sent = rate;
                    remaining = remaining - sent;
                }
            }
            else{
                sent = 0;
            }

            //Display
            if(accepted == -1){
                System.out.println(i+"\t\t"+a[i]+"\t\t"+"Dropped\t\t"+sent+"\t\t"+remaining);
            }
            else{
                System.out.println(i+"\t\t"+a[i]+"\t\t"+accepted+"\t\t"+sent+"\t\t"+remaining);
            }
        }
    }
}