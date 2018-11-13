package com.mastering.spring.consumer.serviceconsumer;

import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Service
//@FeignClient(name = "microservice-a")
@FeignClient(name = "zuul-api-gateway")
@RibbonClient(name = "microservice-a")
public interface RandomServiceProxy {

    //@GetMapping("/random")
    @GetMapping("/microservice-a/random")
    List<Integer> getRandomNumbers();
}
