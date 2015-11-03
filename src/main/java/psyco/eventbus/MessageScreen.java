package psyco.eventbus;

import com.google.common.eventbus.EventBus;
import com.google.common.eventbus.Subscribe;
import org.junit.Test;

public class MessageScreen {

    public static class MessageListener {
        @Subscribe
        public void printMessage(String message) {
            System.out.println(message);
        }
        @Subscribe
        public void messge(String message) {
            System.out.println(message + "xxxx");
        }
        @Subscribe
        public void intX(Integer message) {
            System.out.println("Integer\t"  +message );
        }
    }

    @Test
    public void test() {
        EventBus eventBus = new EventBus();
        eventBus.register(new MessageListener());
        eventBus.post("Hello Screen");
        eventBus.post(23);
    }
}
