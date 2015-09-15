package psyco.springRMI.server;

import org.springframework.stereotype.Component;
import psyco.springRMI.client.Data;
import psyco.springRMI.client.HelloService;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by lipeng on 15/9/11.
 */
@Component
public class HelloServiceImpl implements HelloService {
    static AtomicInteger ID = new AtomicInteger(0);

    @Override
    public Data echo(String a) {
        return new Data(a, ID.getAndIncrement());
    }
}
