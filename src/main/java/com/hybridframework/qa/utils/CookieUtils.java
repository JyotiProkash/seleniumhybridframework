package com.hybridframework.qa.utils;

import io.restassured.http.Cookies;
import org.openqa.selenium.Cookie;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Jyoti on 15/04/2020
 */
public class CookieUtils {

    public List<Cookie> convertRestAssuredCookiesToSeleniumCookies(Cookies cookies){
        List<io.restassured.http.Cookie> restAssuredCookies = new ArrayList<>();
        restAssuredCookies = cookies.asList();
        List<Cookie> seleniumCookies = new ArrayList<>();
        for(io.restassured.http.Cookie cookie: restAssuredCookies){
            seleniumCookies.add(new Cookie(cookie.getName(), cookie.getValue(), cookie.getDomain(),
                    cookie.getPath(), cookie.getExpiryDate(), cookie.isSecured(), cookie.isHttpOnly(),
                    cookie.getSameSite()));
        }
        return seleniumCookies;
    }
}
