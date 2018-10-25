/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package java_algorithms;

import java.util.concurrent.Semaphore;

/**
 *
 * @author Pasindu Siriwardana
 * --PRODUCER CONSUMER PROBLEM USING SEMAPHORES--
 */

class Q{
    int item;
    static Semaphore semCon=new Semaphore(0);
    static Semaphore semProd=new Semaphore(1);
    
    void get(){
        try 
        {
            semCon.acquire();
            
        } catch (Exception e) {
            System.out.println(e);
        }
        System.out.println("Consumer consumed item: "+item);
        semProd.release();
    }
    
    void put(int item){
        try 
        {
            semProd.acquire();
            
        } catch (Exception e) {
            System.out.println(e);
        }
        this.item=item;
        System.out.println("producer produced item: "+item);
        semCon.release();
    }
}

class producer implements Runnable{
    Q q=new Q();
    producer(Q q){
        this.q=q;
        new Thread(this,"producer").start();
    }

    @Override
    public void run() {
        for(int i=0;i<5;i++){
            q.put(i);
        }
        
    }
    
}

class consumer implements Runnable{
    Q q;
    consumer(Q q){
        this.q=q;
        new Thread(this,"consumer").start();
    }

    @Override
    public void run() {
        for(int i=0;i<5;i++){
            q.get();
        }
        
    }
    
}
public class pC_semaphore {
    public static void main(String[] args) {
        Q q=new Q();
        new consumer(q);
        new producer(q);
    }
}
