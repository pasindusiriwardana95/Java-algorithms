/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package java_algorithms;

import java.util.LinkedList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Pasindu Siriwardana
 * --PRODUCER CONSUMER PROBLEM WITHOUT SEMAPHORE
 */

public class producerConsumerProblem {
    
    public static void main(String args[]) throws InterruptedException{
        final casee A=new casee();
//        y Y = new y();
//        x X =new x();
//        producer
        Thread t1=new Thread(new Runnable(){
            @Override
            public void run() {
                try 
                {
                    A.produce();
                    
                } catch (Exception e) {
                    e.printStackTrace();
                }
                
            }
            
        });
        Thread t2=new Thread(new Runnable(){
            @Override
            public void run() {
                try 
                {
                    A.consume();
                    
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            
        });
        
        t1.start();
        t2.start();
        
        t1.join();
        t2.join();
           
        
    }
    public static class casee{
        LinkedList<Integer> list=new LinkedList<>();
        int capacity=2;

        public void produce() throws InterruptedException{
            int value=0;
            while(true){
                synchronized(this){
                    while(list.size()==capacity){
                        wait();
                    }
                    System.out.println("produser produced: "+value);
                    list.add(value++);
                    notify();
                    Thread.sleep(1000);
               }
            }

        }

        public void consume() throws InterruptedException{
            while(true){
                synchronized(this){
                    while(list.size()==0){
                        wait();
                    }
                    int value=list.removeFirst();
                    System.out.println("Consumer consumed! "+value);
                    notify();
                    Thread.sleep(1000);
                }
            }
        }

    }
    
}


