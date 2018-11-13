package com.mastering.spring.cloud.microservicea;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@RestController
public class RandomNumberController {

    @RequestMapping("/random")
    public List<Integer> random(){
        return IntStream.rangeClosed(1, 5).mapToObj(i -> generateRandomNumber()).collect(Collectors.toList());
    }

    private Integer generateRandomNumber() {
        return (int) (Math.random() * 1000);
    }

}
