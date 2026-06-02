
package javaX;
public class HelloThread extends Thread{

    private int initialNumber;
    private int finalNumber;

    public HelloThread(int initialNumber,int finalNumber){
        this.finalNumber = finalNumber;
        this.initialNumber = initialNumber;
    }

    @Override
    public void run(){
        for(int i = initialNumber; i < finalNumber; i ++){
            System.out.printf(String.valueOf(i));
             System.out.printf("- \n");
        }

    }
}