package com.staff.staff.models;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CustomDate implements CustomDateTime{
    Map<String, String > dateFormats = new HashMap<>();

     void dateFormats(){
        dateFormats.put("BG","dd/MM/yyyy");
    }

    @Override
    public String startedAt(String nationality) {
        if (dateFormats.containsKey(nationality)){
            LocalDate date = LocalDate.now();
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern(dateFormats.get(nationality));
            return date.format(formatter);
        }else {
            return "Type another nationality!";
        }
    }

    @Override
    public String finishedAt(String nationality) {
        return nationality;
    }
}
