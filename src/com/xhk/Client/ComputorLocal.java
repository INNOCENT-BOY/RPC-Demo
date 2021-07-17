package com.xhk.Client;

import com.xhk.Common.IComputer;
import com.xhk.Common.RequestFormat;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class ComputorLocal implements IComputer {

    @Override
    public Integer add(Integer a, Integer b) throws Exception {

        Socket socket = new Socket("127.0.0.1",9090);
        System.out.println("开始访问。。。");

        RequestFormat request = new RequestFormat("com.xhk.ServiceProvider.ComputerRemoteImpl", "add", a, b);
        ObjectOutputStream outputStream = new ObjectOutputStream(socket.getOutputStream());
        outputStream.writeObject(request);
        outputStream.flush();

        ObjectInputStream inputStream = new ObjectInputStream(socket.getInputStream());
        Integer ret = (Integer)inputStream.readObject();


        return ret;

    }

}
