package com.learning.ds.validation;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

public class ZipValidator {

    public static void main(String[] args) {

        List<String> zips = new ArrayList<>();

//Valid ZIP codes
        zips.add("12345");     //true
        zips.add("12345-6789");   //true

//Invalid ZIP codes
        zips.add("123456");   //false
        zips.add("1234");    //false
        zips.add("12345-678");  //false
        zips.add("12345-67890");  //false


        String regEx = "^[0-9]{5}(?:-[0-9]{4})?$";
        Pattern pattern = Pattern.compile(regEx);

        for(String zip: zips) {
            System.out.println(zip + " ---- "+ pattern.matcher(zip).matches());
        }

    }
}
