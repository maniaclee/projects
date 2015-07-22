package psyco.springboot.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/***
 * springboot yaml 自动注入yaml变量，
 * 必须为bean-> getters/setters!
 */
@Component
@ConfigurationProperties(prefix = "db")
public class YamlConfigBean {
    private String url;
    private String userName;
    private String password;

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}