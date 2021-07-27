package com.xq.zookeeper;

import org.apache.zookeeper.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Client {

    private String connectString = "106.14.32.152:2181";
    private int sessionTimeout = 2000;
    private ZooKeeper zk;

    public static void main(String[] args) throws Exception{

        Client client = new Client();

        client.getConnect();


        client.getChildren();
        client.regist(args[0]);


        client.business();

        System.out.println(args.length);


    }


    private void business() throws InterruptedException {
        Thread.sleep(Long.MAX_VALUE);
    }

    private void regist(String hostname)throws Exception{
        String path = zk.create("/servers/server" , hostname.getBytes() , ZooDefs.Ids.OPEN_ACL_UNSAFE , CreateMode.EPHEMERAL_SEQUENTIAL);


    }
    private void getChildren()throws Exception{
         
        List<String> list = zk.getChildren("/servers",true);
        ArrayList<String> hosts = new ArrayList<>();

        for (String child:list
             ) {
            byte[]  data =  zk.getData("/server"+child , false , null );
            hosts.add(new String(data) );
        }

        System.out.println(hosts);

        
        
    }

    private void getConnect()throws IOException {

        zk = new ZooKeeper(connectString, sessionTimeout, new Watcher() {
            @Override
            public void process(WatchedEvent watchedEvent) {

                try {
                    getChildren();
                } catch (Exception e) {
                    e.printStackTrace();
                }

            }
        });

    }

}
