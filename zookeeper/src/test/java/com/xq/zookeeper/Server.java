package com.xq.zookeeper;

import org.apache.zookeeper.*;

import java.io.IOException;

/***
 * 动态上下线
 *
 */

//连接
//注册
//业务逻辑处理

public class Server {

    private String connectString = "106.14.32.152:2181";
    private int sessionTimeout = 2000;
    private ZooKeeper zk;

    public static void main(String[] args) throws Exception{

            Server server = new Server();

            server.getConnect();


            server.regist(args[0]);


            server.business();

        System.out.println(args.length);


    }


    private void business() throws InterruptedException {
        Thread.sleep(Long.MAX_VALUE);
    }

    private void regist(String hostname)throws Exception{
        String path = zk.create("/servers/server" , hostname.getBytes() , ZooDefs.Ids.OPEN_ACL_UNSAFE , CreateMode.EPHEMERAL_SEQUENTIAL);


    }

    private void getConnect()throws IOException {

         zk = new ZooKeeper(connectString, sessionTimeout, new Watcher() {
            @Override
            public void process(WatchedEvent watchedEvent) {
            }
        });

    }


}
