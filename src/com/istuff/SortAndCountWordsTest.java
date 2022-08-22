package com.istuff;
import org.junit.Assert;
import org.junit.Test;
import java.util.LinkedHashMap;
import java.util.SortedMap;
import java.util.TreeMap;

public class SortAndCountWordsTest {


    @Test
    public void testIsStringNullOrBlank() {
        Assert.assertEquals(new SortAndCountWords().isStringNullOrBlank(""),Boolean.TRUE);
    }

    @Test
    public void testSortAndCountByKey() {
        SortedMap<String, Integer> s = new TreeMap<>();
        s.put("the",2);
        s.put("great",1);
        Assert.assertEquals(new SortAndCountWords().SortAndCountByKey("the  great the"),s);
    }

    @Test
    public void testSortAndCountByKey2ndWay() {
        SortedMap<String, Integer> s = new TreeMap<>();
        s.put("the",2);
        s.put("great",1);
        Assert.assertEquals(new SortAndCountWords().SortAndCountByKey2ndWay("the  great the"),s);
    }

    @Test
    public void testSortAndCountByValue() {
        LinkedHashMap<String, Integer> s = new LinkedHashMap<>();
        s.put("great",1);
        s.put("the",2);
        Assert.assertEquals(new SortAndCountWords().SortAndCountByValue("the  great the"),s);
    }
}