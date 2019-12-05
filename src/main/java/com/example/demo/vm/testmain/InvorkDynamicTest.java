package com.example.demo.vm.testmain;

import java.lang.invoke.MethodHandle;
import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;

public class InvorkDynamicTest {
  public static void main(String[] args){
      new Son().thinking();
  }

}

class GrandFather{
    void thinking() {
        System.out.println("i am grandFather");
    }
}
class Father extends GrandFather{
    @Override
    void thinking() {
        System.out.println("i am Father");
    }

}
class  Son extends Father{
    @Override
    public void thinking() {
        MethodType mt = MethodType.methodType(void.class);
        try {
            MethodHandle m = MethodHandles.lookup().findSpecial(GrandFather.class,"thinking",mt,this.getClass());
            m.invoke(this);
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
    }

}


