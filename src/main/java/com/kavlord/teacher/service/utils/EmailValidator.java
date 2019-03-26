package com.kavlord.teacher.service.utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class EmailValidator {
    public static boolean isEmail(String email){
        Pattern pattern = Pattern.compile("^[\\w.]*@[\\w\\.]*\\.[\\w]{2,3}$");
        Matcher matcher = pattern.matcher(email);
        return matcher.find();
    }
}
