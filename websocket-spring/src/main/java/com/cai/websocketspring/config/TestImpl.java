package com.cai.websocketspring.config;

import org.springframework.stereotype.Service;

/**
 * @date 2018/4/189:25
 * @author caijun
 * @Description: ${todo}
*/
@Service
public class TestImpl implements ITest{
    @Override
    public String hi() {
        return "123";
    }
}