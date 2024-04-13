package net.micro;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class CustomerDataServiceApplicationTests {

    @Test
    void contextLoads() {
        System.out.println("test contextLoads");
    }
    @BeforeEach
    void solve(){
        System.out.println("before each");
    }
    @AfterEach
    void solv3(){
        System.out.println("after each");
    }

}
