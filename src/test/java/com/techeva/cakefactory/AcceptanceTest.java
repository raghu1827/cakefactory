package com.techeva.cakefactory;

import org.junit.jupiter.api.BeforeEach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import com.techeva.cakefactory.client.BrowserClient;

@SpringBootTest
@AutoConfigureMockMvc
@AutoConfigureTestDatabase
public class AcceptanceTest {

    @Autowired
    protected MockMvc mockMvc;

    protected BrowserClient client;

    @BeforeEach
    void setUp() {
        client = new BrowserClient(mockMvc);
    }
}
