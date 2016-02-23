package cz.nigol.proxydemo.handlers;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import cz.nigol.proxydemo.annotations.Transaction;

public class MyInvocationHandler<T> implements InvocationHandler {

    private final T proxied;

    public MyInvocationHandler(T proxied) {
        this.proxied = proxied;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        Object result;
        Method m = proxied.getClass().getMethod(method.getName(), method.getParameterTypes());
        if (m.isAnnotationPresent(Transaction.class)) {
            System.out.println("--Start Transaction");
            result = method.invoke(proxied, args);
            System.out.println("--End Transaction");
        } else {
            result = method.invoke(proxied, args);
        }
        return result;
    }
}
