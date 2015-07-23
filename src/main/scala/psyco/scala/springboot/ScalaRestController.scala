package psyco.scala.springboot

import com.google.common.collect.Lists
import org.springframework.web.bind.annotation.{RequestMapping, RestController}
import psyco.springboot.entity.Message

/**
 * Created by lipeng on 15/7/23.
 * Scala对Jdk8的支持必须scala-version 2.11.4(越高越好)
 * Scala-compiler不能解析jdk包里jdk1.8的类，如java.util.function.Consumer
 */
@RestController
@RequestMapping(value = Array("/scala"))
class ScalaRestController {
  @RequestMapping(value = Array("hello"))
  def hello() = "scala hello world"

  /**
   * Message 有@XmlRootElement注解，所以默认返回xml
   * 如需json，只要限定headers就醒
   */
  @RequestMapping(value = Array("json"), headers = Array("Accept=application/json"))
  def json() = {
    val m = new Message
    m.setId(232)
    m.setName("scala")
    m.setChildren(Lists.newArrayList("sss", "xxxx", "fucker!"))
    m
  }


  @RequestMapping(value = Array("xml"))
  def xml() = {
    val m = new Message
    m.setId(232)
    m.setName("scala")
    m.setChildren(Lists.newArrayList("sss", "xxxx", "fucker!"))
    m
  }
}
