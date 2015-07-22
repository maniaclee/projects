package psyco.springboot.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

/**
 * Created by lipeng on 15/7/22.
 * 如果是自定义的properties文件，必须用@PropertySource 来指明所引用文件
 */
@Component
@PropertySource(value = "application.custom.properties")
public class Properties_Custom_ConfigBean {

    @Value("${custom.fuck}")
    public  String custom_fuck;


}
