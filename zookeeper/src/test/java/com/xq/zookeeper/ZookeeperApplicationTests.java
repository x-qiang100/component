package com.xq.zookeeper;

import org.apache.zookeeper.*;
import org.apache.zookeeper.data.Stat;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.IOException;
import java.util.List;

@SpringBootTest
class ZookeeperApplicationTests {

    private String connectString = "106.14.32.152:2181";
    private int sessionTimeout = 2000;

    private ZooKeeper zk;
    @Test
    void contextLoads() throws Exception {
        System.out.println("---");
        /***
         * 集群
         * 超时时间
         * 监听回调
         */
        zk = new ZooKeeper(connectString, sessionTimeout, new Watcher() {
            @Override
            public void process(WatchedEvent watchedEvent) {
            }
        });


        String path = zk.create("/615","my".getBytes() , ZooDefs.Ids.OPEN_ACL_UNSAFE , CreateMode.PERSISTENT);

        System.out.println(path);


         //获取所有路径
        List<String> children = zk.getChildren("/",true);
        for (String s:children
             ) {
            System.out.println(s);
        }
        Thread.sleep(Long.MAX_VALUE);


        //判断节点是否存在
        Stat stat =zk.exists("/615",false);
        System.out.println(stat);


        //动态上下线

    }

    void server(){



    }



}
