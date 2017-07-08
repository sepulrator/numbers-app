package com.numbersapp.number;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

/**
 * Created by sepulrator on 08.07.2017.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = NumberServiceApplication.class)
@WebAppConfiguration
public class NumberServiceApplicationTests {

    @Test
    public void contextLoads() {

    }
}
