package psyco.springboot.test;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.boot.test.WebIntegrationTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;
import psyco.springboot.Application;

/**
 * Created by lipeng on 15/7/22.
 */
//@RunWith(SpringJUnit4ClassRunner.class)
//@ContextConfiguration(classes = {TestContext.class,Application.class})
//@WebAppConfiguration
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = {Application.class})
@WebIntegrationTest({"server.port=0", "management.port=0"})
public class RestfulControllerMockmvcTest {

    @Autowired
    private WebApplicationContext webApplicationContext;
    private MockMvc mockMvc;

    @Before
    public void setup() {
        mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
    }


    private void test(String s) throws Exception {
        MvcResult re = mockMvc.perform(MockMvcRequestBuilders.get("/rest/" + s)).andExpect(MockMvcResultMatchers.status().isOk()).andReturn();
        System.out.println(re.getResponse().getContentAsString());
    }

    @Test
    public void testString() throws Exception {
        test("yaml");
    }

    @Test
    public void testProperties_spring() throws Exception {
        test("properties_spring");
    }

    @Test
    public void testProperties_custom() throws Exception {

    }

    @Test
    public void testObject() throws Exception {
            test("object");
    }

    @Test
    public void testXml() throws Exception {
        test("xml");
    }

    @Test
    public void testPathVaraible() throws Exception {
        test("pathvariable/xxxxxxxxxxxxxxx");
    }
}