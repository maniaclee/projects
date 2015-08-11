package psyco.Zookeeper.raw;

import org.apache.zookeeper.CreateMode;
import org.apache.zookeeper.ZooDefs;
import org.apache.zookeeper.ZooKeeper;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.net.InetAddress;

/**
 * Created by lipeng on 15/8/7.
 */
public class Election implements Runnable {
    static Logger logger = LoggerFactory.getLogger(Election.class);
    String hostPort = "localhost:2181";
    ZooKeeper zk;
    String root = "/root";

    public void init() throws Exception {
        zk = new ZooKeeper(hostPort, 3000, watchedEvent -> logger.debug("", watchedEvent));
//        String re = zk.create(root, "root".getBytes(), ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.EPHEMERAL);
//        System.out.println("create:\t" + re);
    }

    void findLeader() throws InterruptedException {
        byte[] leader = null;
        try {
            leader = zk.getData(root + "/leader", true, null);
        } catch (Exception e) {
        }
        if (leader != null) {
        } else {
            String newLeader = null;
            try {
                byte[] localhost = InetAddress.getLocalHost().getAddress();
                newLeader = zk.create(root + "/leader", localhost,
                        ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.EPHEMERAL);
                logger.info("create success");
            } catch (Exception e) {
                e.printStackTrace();
            }
            if (newLeader != null) {
                logger.debug("new leader");
            } else {
                Thread.sleep(500);
            }
        }
    }

    public void run() {
        try {
            init();
            for (int i = 0; i < 5; i++) {
                findLeader();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void test() throws Exception {
//        for (int i = 0; i < 4; i++) {
//            System.out.println("start: " + i);
//            new Thread(new Election()).start();
//        }
        run();
    }
}
