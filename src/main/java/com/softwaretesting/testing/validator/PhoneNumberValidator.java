package com.softwaretesting.testing.validator;

import org.springframework.stereotype.Service;

@Service
public class PhoneNumberValidator {
    private static int MINLENGTH = 5;
    private static String COUNTRYCODE="+49";
    public boolean validate(String x){
        if(x.length()>=MINLENGTH){
            if(x.startsWith(COUNTRYCODE)){
                return true;
            }
        }
        return false;
    }
}
