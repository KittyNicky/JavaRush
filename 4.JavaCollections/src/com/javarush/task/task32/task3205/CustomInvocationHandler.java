package com.javarush.task.task32.task3205;

import com.javarush.task.task32.task3205.SomeInterfaceWithMethods;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class CustomInvocationHandler implements InvocationHandler {
    SomeInterfaceWithMethods interfaceWithMethods;

    public CustomInvocationHandler(SomeInterfaceWithMethods interfaceWithMethods) {
        this.interfaceWithMethods = interfaceWithMethods;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println(method.getName() + " in");
        Object invokeMethod = method.invoke(interfaceWithMethods, args);
        System.out.println(method.getName() + " out");
        return invokeMethod;
    }
}
