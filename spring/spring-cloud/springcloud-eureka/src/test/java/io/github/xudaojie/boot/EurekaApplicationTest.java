package io.github.xudaojie.boot;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;


/**
 * Created by xdj on 2017/5/18.
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = EurekaApplicationTest.class) // 通过Spring Boot 加载上下文
@WebAppConfiguration
public class EurekaApplicationTest {

    @Test
    public void contextLoads() {
    }

    @Test
    public void home() throws Exception {

    }

}