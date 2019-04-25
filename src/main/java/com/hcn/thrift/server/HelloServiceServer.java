package com.hcn.thrift.server;

import org.apache.thrift.protocol.TBinaryProtocol;
import org.apache.thrift.protocol.TBinaryProtocol.Factory;
import org.apache.thrift.server.TServer;
import org.apache.thrift.server.TSimpleServer;
import org.apache.thrift.transport.TServerSocket;
import org.apache.thrift.transport.TTransportException;

import com.hcn.thrift.server.HelloService.Processor;
import com.hcn.thrift.server.impl.HelloServiceImpl;

public class HelloServiceServer {

    public static void main(String[] args) {
        try {

            TServerSocket ts = new TServerSocket(9090);

            Factory protocolFactory = new TBinaryProtocol.Factory();

            Processor<HelloService.Iface> processor = new HelloService.Processor<HelloService.Iface>(new HelloServiceImpl());

            TServer.Args simpleArgs = new TServer.Args(ts);
            simpleArgs.processor(processor);
            simpleArgs.protocolFactory(protocolFactory);
            TServer server = new TSimpleServer(simpleArgs);
            System.out.println("open thrift server at port:9090");
            server.serve();


           /* TThreadPoolServer.Args poolArgs = new TThreadPoolServer.Args(ts);
            poolArgs.processor(processor);
            poolArgs.protocolFactory(protocolFactory);
            TServer poolServer = new TThreadPoolServer(poolArgs);
            poolServer.serve();*/

        } catch (TTransportException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

}