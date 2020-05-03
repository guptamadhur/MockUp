package web.app.madhurgupta.Learning.Topic.Thread;

/*
# Author: Madhur Gupta
# Github: github.com/guptamadhur
# Project: Java MockUp
 */

public class InheritableThreadLocalDemo {
    public static void main(String[] args) {
        ParentThread parentThread=new ParentThread();
        parentThread.start();
    }
}

class ParentThread extends Thread{
    //First Option Parent Value set and ChildVale is null
    //public static ThreadLocal threadLocal= new ThreadLocal();

    //First Option Parent Value set and ChildVale is same as Parent
    //public static InheritableThreadLocal threadLocal= new InheritableThreadLocal();

    //parent value would be different and Parent Thread Value would be different
    public static InheritableThreadLocal threadLocal= new InheritableThreadLocal(){
      public Object childValue(Object a){
          return "ChildThread Value";
      }
    };

    public void run(){
        threadLocal.set("Default Value");
        System.out.println("Parent Thread Value:"+threadLocal.get());
        ChildThread ct=new ChildThread();
        ct.start();
    }
}

class ChildThread extends Thread{
    public void run(){
        System.out.println("Child Thread Value:" + ParentThread.threadLocal.get());
    }
}
