package psyco.tricks;

import org.junit.Test;

import java.lang.management.ManagementFactory;

/**
 * Created by lipeng on 15/9/13.
 */
public class TricksFromDubboSource {


    public static Integer getPid() {
        String name = ManagementFactory.getRuntimeMXBean().getName();
        return Integer.parseInt(name.substring(0, name.indexOf('@')));
    }

    public static Integer getMultiThreadCount_best() {
        return Runtime.getRuntime().availableProcessors()+1;
    }


    @Test
    public void pid() {
        System.out.println(ManagementFactory.getRuntimeMXBean().getName());//
        System.out.println(getPid());
        System.out.println(getMultiThreadCount_best());
    }

}
