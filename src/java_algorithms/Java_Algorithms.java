/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package java_algorithms;

/**
 *
 * @author Pasindu Siriwardana
 * ---PETERSONS SOLUTION----
 */
public class Java_Algorithms {
    
    int i=0;
    int j=1;
    boolean wants[] = new boolean[2];
    int c=0;
    
    private class I extends Thread{
        public void run(){
            try {
                do{
                int turn=j;
                wants[i]=true;
                while(turn==j && wants[i]==true);
                System.out.println("process I is in the C_region!");
                c++;
                wants[i]=false;
            }while(c<100);
            } catch (Exception e) {
                e.printStackTrace();
            }
            
        }
    }
    
    private class J extends Thread{
        public void run(){
            try {
                do{
                    int turn=i;
                    wants[j]=true;
                    while(turn==i && wants[j]==true);
                    System.out.println("process J is in the c_region!");
                    c++;
                    wants[j]=false;
                }while(c<100);
            } catch (Exception e) {
                e.printStackTrace();
            }
            
        }
    }
    
    public Java_Algorithms(){
        I i=new I();
        J j=new J();
        i.start();
        j.start();
    }
    
    public static void main(String[] args) {
        Java_Algorithms a = new Java_Algorithms();
    }
    
}
    

