package com.xhk.ServiceProvider;

import com.xhk.Common.IComputer;

public class ComputerRemoteImpl implements IComputer {

    @Override
    public Integer add(Integer a, Integer b) {
        return a + b;
    }

//    public int add(int a, int b, int c) {
//        return a + b + c;
//    }
}
