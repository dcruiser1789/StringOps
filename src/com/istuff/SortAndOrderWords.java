package com.istuff;
import com.sun.org.apache.xml.internal.security.utils.JavaUtils;

import java.time.LocalTime;
import java.util.*;
/**
 *  Classs to implement methods to sort & Count words of a string
 */

class SortAndCountWords {

    // Check For null or empty of string
    protected boolean isStringNullOrBlank(String strInput){
            return strInput == null || strInput.equals("") || strInput.trim().equals("");
    }

    // Add, Sort and count words by key using SortedMap
    protected SortedMap<String,Integer> SortAndCountByKey(String strInput){
            if(!isStringNullOrBlank(strInput)) {
                SortedMap<String, Integer> WordsOfStringSortedMap = new TreeMap<String, Integer>();
                String[] words = strInput.split("\\s+");
                Arrays.stream(words).forEach(x -> {
                    WordsOfStringSortedMap.merge(x.toLowerCase(), 1, Integer::sum);
                });
                return WordsOfStringSortedMap;
            }
            return null;
    }
    // Add by HashMap and Sort and count words by key using SortedMap
    protected SortedMap<String,Integer> SortAndCountByKey2ndWay(String strInput){
        if(!isStringNullOrBlank(strInput)) {
            Map<String, Integer> hashMap = new HashMap<>();
            SortedMap<String,Integer> WordsOfStringSortedMap =new TreeMap<String, Integer>();
            String[] words = strInput.split("\\s+");
            Arrays.stream(words).forEach(x->{
                hashMap.merge(x.toLowerCase(), 1, Integer::sum);
            });
            WordsOfStringSortedMap.putAll(hashMap);

            return WordsOfStringSortedMap;
        }
        return null;

    }
    // Add by HashMap and Sort and count words by value using LinkedHashMap
    protected LinkedHashMap<String, Integer> SortAndCountByValue(String strInput){
        if(!isStringNullOrBlank(strInput)) {
            Map<String, Integer> hashMap = new HashMap<>();
            SortedMap<String,Integer> WordsOfStringSortedMap =new TreeMap<String, Integer>();
            String[] words = strInput.split("\\s+");
            Arrays.stream(words).forEach(x->{
                hashMap.merge(x.toLowerCase(), 1, Integer::sum);
            });
            LinkedHashMap<String, Integer> orderedMap = new LinkedHashMap<>();
            hashMap.entrySet().stream().sorted(Map.Entry.comparingByValue())
                    .forEachOrdered(x -> orderedMap.put(x.getKey(), x.getValue()));

            return orderedMap;
        }
        return null;

    }

    public static void main(String[] args) {
        //
        String strInput = "The tree had all the flowers that made all the Visitors Happy. The best day of my life is each of the days I felt alive";
        //String strInput=null;
        SortAndCountWords sortAndCountWords = new SortAndCountWords();
        System.out.println("Start Of The Program"+LocalTime.now());

        System.out.println(LocalTime.now()+"\nSortedMap to Add & to  Sort,SortAndCountByKey: \n" + sortAndCountWords.SortAndCountByKey(strInput)+"\n"+LocalTime.now()+"\n");

        System.out.println(LocalTime.now()+"\nhashMap to Add & SortMap to  Sort, SortAndCountByKey2ndWay:\n " + sortAndCountWords.SortAndCountByKey2ndWay(strInput)+"\n"+LocalTime.now()+"\n");

        System.out.println(LocalTime.now()+"\nhashMap to Add & SortMap to  Sort, SortAndCountByValue:\n" + sortAndCountWords.SortAndCountByValue(strInput)+"\n"+LocalTime.now());

        System.out.println("End Of The Program"+LocalTime.now());
    }
}

