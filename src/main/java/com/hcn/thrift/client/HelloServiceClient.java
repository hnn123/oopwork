package com.hcn.thrift.client;

import org.apache.thrift.TException;
import org.apache.thrift.protocol.TBinaryProtocol;
import org.apache.thrift.protocol.TProtocol;
import org.apache.thrift.transport.TSocket;
import org.apache.thrift.transport.TTransport;
import org.apache.thrift.transport.TTransportException;

import com.hcn.thrift.server.HelloService;

public class HelloServiceClient {

    public static void main(String[] args) {

        try {

            TTransport transport = new TSocket("127.0.0.1", 9090);

            TProtocol protocol = new TBinaryProtocol(transport);

            HelloService.Client client = new HelloService.Client(protocol);

            transport.open();
            System.out.println("getsum"+client.add(100, 150));
            System.out.println(client.getLong(System.currentTimeMillis()));
            System.out.println(client.sayHello("lisi"));
            System.out.println(client.getShort((short)10));

        } catch (TTransportException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (TException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

}
