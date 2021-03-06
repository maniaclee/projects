//package psyco.springboot.config;
//
//import org.springframework.context.annotation.BeanX;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.http.converter.HttpMessageConverter;
//import org.springframework.http.converter.xml.MarshallingHttpMessageConverter;
//import org.springframework.oxm.jaxb.Jaxb2Marshaller;
//import psyco.springboot.entity.Message;
//
///**
// * Created by lipeng on 15/7/21.
// */
//
//@Configuration
//public class HttpMessageConverterConfig {
//
//    @BeanX
//    public HttpMessageConverter marshallingHttpMessageConverter() {
//        Jaxb2Marshaller jaxb2Marshaller = new Jaxb2Marshaller();
//        jaxb2Marshaller.setPackagesToScan(Message.class.getPackage().get_name());
//        return new MarshallingHttpMessageConverter(jaxb2Marshaller);
//    }
//
//}
