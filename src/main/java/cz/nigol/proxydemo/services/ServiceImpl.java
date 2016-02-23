package cz.nigol.proxydemo.services;

import cz.nigol.proxydemo.annotations.Transaction;

public class ServiceImpl implements Service {

    @Override
    @Transaction
    public void output(String msg) {
        System.out.println(msg);
    }
}
