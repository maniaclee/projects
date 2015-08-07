package psyco.Zookeeper;

import org.apache.zookeeper.CreateMode;
import org.apache.zookeeper.ZooDefs;
import org.apache.zookeeper.ZooKeeper;
import org.junit.Test;

/**
 * Created by lipeng on 15/8/6.
 */
public class Api {

    static final String root = "/fucker";

    @Test
    public void sdfsdf() throws Exception {
        ZooKeeper zookeeper = new ZooKeeper("localhost:2181", 2000, event -> System.out.println("已经触发了" + event.getType() + "事件！"));
        zookeeper.create(root, "hello fucker".getBytes(), ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.PERSISTENT);
        System.out.println("-------------" + new String(zookeeper.getData(root, false, null)));
        zookeeper.close();
    }
}
