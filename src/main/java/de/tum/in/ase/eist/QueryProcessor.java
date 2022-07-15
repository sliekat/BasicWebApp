package de.tum.in.ase.eist;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Service
public class QueryProcessor {

    public String process(String query) {
		query = query.toLowerCase();
        if (query.contains("shakespeare")) {
            return "William Shakespeare (26 April 1564 - 23 April 1616) was an " +
                    "English poet, playwright, and actor, widely regarded as the greatest " +
                    "writer in the English language and the world's pre-eminent dramatist.";
        } else if (query.contains("name")) {
           return "kat";

        }else if (query.contains("plus")){
            query = query.substring(9);
            Pattern intPattern = Pattern.compile("-?\\d+");
            Matcher matcher = intPattern.matcher(query);

            List<String> integerList = new ArrayList<>();
            while (matcher.find()) {
                integerList.add(matcher.group());
            }

            String res = integerList.get(0) + integerList.get(1);
            return res;

        }else if(query.contains("largest")){
            query = query.substring(9);
            Pattern intPattern = Pattern.compile("-?\\d+");
            Matcher matcher = intPattern.matcher(query);

            List<String> integerList = new ArrayList<>();
            while (matcher.find()) {
                integerList.add(matcher.group());
            }

            integerList.stream().map(x -> Integer.getInteger(x)).toList();
            integerList.sort(Comparator.reverseOrder());
            return integerList.get(0);
        }
        else {
            return "";
        }
    }
}


