package com.xhk.ServiceProvider;

import com.xhk.Common.RequestFormat;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.reflect.Method;
import java.net.ServerSocket;
import java.net.Socket;
public class ServiceProvider {
    public static void main(String[] args) throws Exception {

        ServerSocket server = new ServerSocket(9090);
        System.out.println("服务器端已经开启。。。。");
        while (true) {
            Socket socket = server.accept();
            System.out.printf("客户地址%s:%d 连接成功\n", socket.getInetAddress(), socket.getPort());
            ObjectInputStream objectInputStream = new ObjectInputStream(socket.getInputStream());
            RequestFormat request = (RequestFormat) objectInputStream.readObject();
            Class clz = Class.forName(request.getClassName());

            Method method = clz.getMethod("add", request.getParamsType());
            int ret = (int)method.invoke(clz.newInstance(),request.getParams());
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(socket.getOutputStream());
            objectOutputStream.writeObject(ret);
            objectOutputStream.flush();
        }
    }
}
