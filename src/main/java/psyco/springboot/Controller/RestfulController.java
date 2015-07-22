package psyco.springboot.Controller;

import com.google.common.collect.Lists;
import org.apache.commons.lang.builder.ReflectionToStringBuilder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import psyco.springboot.config.Properties_Custom_ConfigBean;
import psyco.springboot.config.Properties_Spring_ConfigBean;
import psyco.springboot.config.YamlConfigBean;
import psyco.springboot.entity.Message;

import javax.annotation.Resource;

/**
 * Created by lipeng on 15/7/21.
 */
@RestController
@RequestMapping("/rest")
public class RestfulController {
    @Resource
    YamlConfigBean yamlConfigBean;
    @Resource
    Properties_Spring_ConfigBean propertiesConfigBean;
    @Resource
    Properties_Custom_ConfigBean properties_custom_configBean;

    @RequestMapping("yaml")
    String yaml() {
        return ReflectionToStringBuilder.toString(yamlConfigBean);
    }

    @RequestMapping("properties_spring")
    String properties_spring() {
        return propertiesConfigBean.fuck_you;
    }

    @RequestMapping("properties_custom")
    String properties_custom() {
        return properties_custom_configBean.custom_fuck;
    }

    @RequestMapping("object")
    YamlConfigBean object() {
        return yamlConfigBean;
    }


    /**
     * how to return XML response
     * 1.    增加xml解析依赖 woodstox-core-asl
     * 2.    在Bean class 上标注@XmlRootElement
     * 3.    @RequestMapping header 设为headers = "Accept=application/xml"
     * XXX   在bean上注解@RequestMapping 并不影响默认的json response，因为json永远是默认的返回形式
     * XXX   HttpMessageConverter 并不是必须要配的
     */
    @RequestMapping(value = "xml", headers = "Accept=application/xml")
    Message xml() {
        Message m = new Message();
        m.setChildren(Lists.newArrayList("fuck", "you", "shit"));
        m.setId(333);
        m.setName("psyco");
        return m;
    }

    @RequestMapping(value = "pathvariable/{pathvariable}")
    Message pathvariable(@PathVariable("pathvariable") String pathvariable) {
        Message m = new Message();
        m.setChildren(Lists.newArrayList("fuck", "you", "shit"));
        m.setId(333);
        m.setName(pathvariable);
        return m;
    }


}
