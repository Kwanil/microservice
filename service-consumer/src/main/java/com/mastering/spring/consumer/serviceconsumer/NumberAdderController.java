package com.mastering.spring.consumer.serviceconsumer;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Objects;

@RestController
public class NumberAdderController {
    private Log log = LogFactory.getLog(NumberAdderController.class);

    @Autowired
    RandomServiceProxy randomServiceProxy;

    @HystrixCommand(fallbackMethod = "getDefaultResponse")
    @RequestMapping("/add")
    public Long add() {
        long sum = 0;
        List<Integer> numbers = randomServiceProxy.getRandomNumbers();
        for(int number : Objects.requireNonNull(numbers)) {
            sum += number;
        }
        log.warn("Returning : " + sum);
        return sum;
    }

    public Long getDefaultResponse() {
        return 1000L;
    }
}
