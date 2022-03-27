package com.hybridframework.qa.utils;

import com.github.javafaker.Faker;

/**
 * Created by Jyoti on 14/04/2020
 */

public class FakerUtils {

    public Long generateRandomNumber(){
        Faker faker = new Faker();
        return faker.number().randomNumber(10, true);
    }
}
