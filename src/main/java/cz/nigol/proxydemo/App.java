package cz.nigol.proxydemo;

import java.lang.reflect.Proxy;

import cz.nigol.proxydemo.handlers.MyInvocationHandler;
import cz.nigol.proxydemo.services.Service;
import cz.nigol.proxydemo.services.ServiceImpl;

public class App {

    public static void main(String[] args) {
        MyInvocationHandler<Service> invocationHandler = new MyInvocationHandler<Service>(new ServiceImpl());
        Service service = (Service) Proxy.newProxyInstance(ServiceImpl.class.getClassLoader(),
                new Class[]{Service.class}, invocationHandler);
        service.output("service");
    }
}
