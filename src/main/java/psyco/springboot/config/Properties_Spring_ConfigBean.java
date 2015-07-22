package psyco.springboot.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * Created by lipeng on 15/7/22.
 * 默认会访问 application.properties
 */
@Component
public class Properties_Spring_ConfigBean {

    @Value("${psyco.shit}")
    public  String fuck_you;


}
