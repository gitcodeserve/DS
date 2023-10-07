package com.learning.ds.string;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class IPAddressValidation {

    public static void main(String[] args) {
        String ip = "125.10.10.10";
        String zeroTo255
                = "(\\d{1,2}|(0|1)\\d{2}|2[0-4]\\d|25[0-5])";

//        \d represents digits in regular expressions, same as [0-9]
//        \\d{1, 2} catches any one or two-digit number
//        (0|1)\\d{2} catches any three-digit number starting with 0 or 1.
//        2[0-4]\\d catches numbers between 200 and 249.
//        25[0-5] catches numbers between 250 and 255.

        // Regex for a digit from 0 to 255 and
        // followed by a dot, repeat 4 times.
        // this is the regex to validate an IP address.
        String regex
                = zeroTo255 + "\\."
                + zeroTo255 + "\\."
                + zeroTo255 + "\\."
                + zeroTo255;

        Pattern patter = Pattern.compile(regex);

        // If the IP address is empty
        // return false
        if (ip == null) {
            return;
        }

        // Pattern class contains matcher() method
        // to find matching between given IP address
        // and regular expression.
        Matcher m = patter.matcher(ip);

        // Return if the IP address
        // matched the ReGex
        System.out.println("Correct IP Address " + m.matches());

    }
}
