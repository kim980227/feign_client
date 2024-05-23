package com.example.controller;

import feign.hystrix.FallbackFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@FeignClient(name = "Feign0002",
        fallbackFactory = FeignFactory.class)
interface TestClient2{
    @RequestMapping("/bpp2")
    String myFunc();
}

@RestController
@RequestMapping("/app2")
class AppController2{

    @Autowired
    TestClient2 tc;

    @GetMapping
    String f1(){
        System.out.println("app2");
        String str = tc.myFunc();

        return "app2"+str;
    }
}

@Component
class FeignFactory implements FallbackFactory<TestClient2>{

    @Override
    public TestClient2 create(Throwable cause) {
        System.out.println("factory");
        return new TestClient2() {
            @Override
            public String myFunc() {
                return "Hystrix Fallback";
            }
        };
    }
}


@FeignClient(name = "Feign0001",
fallbackFactory = FeignFactory.class)
interface TestClient3{
    @RequestMapping("/bpp3/{num}")
    String myFunc(@PathVariable Integer num);
}



@RestController
@RequestMapping("/app3")
class AppController3{

    @Autowired
    TestClient3 tc;

    @GetMapping
    String f1(){
        System.out.println("app3");
        String str = tc.myFunc(3);

        return "app3"+str;
    }
}