package com.example.demo.vm.testmain;

import java.lang.invoke.MethodHandle;
import java.lang.invoke.MethodType;

import static java.lang.invoke.MethodHandles.lookup;

public class MethodHandleTest {
    static class ClassA{
        public void println(String s) {
            System.out.println("classA");
            System.out.println(s);
        }
    }
    public static void main(String[] args) throws Throwable {
            for (int i = 0; i < 10; i++) {
                Object o = System.currentTimeMillis()%2==0?System.out:new ClassA();
                System.out.println(System.currentTimeMillis());
                getPrintMH(o).invokeExact("ddddddddddddd");

            }
     }
    private static MethodHandle getPrintMH(Object receiver) throws Exception{
        //相当于方法描述符，都包含方法返回值和方法参数
        MethodType mt = MethodType.methodType(void.class,String.class);
        /*
         lookup()返回MethodHander构造器Lookup
         findVirtual对应方法调用指令invorkVirtual,查找对象实例方法
         bindTo绑定方法的第一个参数（根据java规范，方法的第一个参数时隐形的，代表方法的接收者，也就是this）
         */

        return lookup().findVirtual(receiver.getClass(),"println",mt).bindTo(receiver);

    }
}
