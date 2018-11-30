package com.dgl.通配符;

class Generics<T> {
    private T t;

    public T getT() {
        return t;
    }

    public void setT(T t) {
        this.t = t;
    }
}

public class Test {
    //使用泛型定义方法
    private static <T> void print(Generics<T> generics){
        System.out.println(generics.getT());
    }
    //使用通配符定义的方法
    private static  void println(Generics<?> generics){
        System.out.println(generics.getT());
    }

    public static void main(String[] args){
        /*
        Generics<?> gen;//定义的时候使用通配符
        gen = new Generics<String>();//实例化的时候，必须明确类型，
        因为要告诉编译器，在内存中给对象分配地址了
         */
        Generics<String>  gen = new Generics<String>();
        gen.setT("abc");
        Generics<Integer>  gen2 = new Generics<Integer>();
        gen2.setT(123);
        //测试2个方法
        print(gen);
        println(gen2);
    }
}
