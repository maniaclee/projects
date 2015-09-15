package psyco.springRMI.client;

import org.springframework.stereotype.Component;

/**
 * Created by lipeng on 15/9/11.
 */
@Component
public interface HelloService {
    public Data echo(String a);
}
