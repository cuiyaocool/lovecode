package com.example.lovecode;


import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.function.BiConsumer;
import java.util.function.BiFunction;
import java.util.function.Function;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class MapTest {

    private Map<String, String> map;

    @BeforeClass
    public void init () {
        System.out.println("beforeClass");
        map = new HashMap() {{
                    put("1", "a");
                    put("2", "d");
                    put("3", "F");
                }};
    }

    @Before
    public void before() {
        System.out.println("before");
        map = new HashMap() {{
            put("1", "a");
            put("2", "d");
            put("3", "F");
        }};
    }

    @Test
    public void testAll() {
        map = new HashMap() {{
            put("1", "a");
            put("2", "d");
            put("3", "F");
        }};
        if (map == null) {
            System.out.println("null");
        }
        assertTrue(map.containsValue("a"));
        assertFalse(map.containsKey("r"));
        map.forEach(new BiConsumer<String, String>() {
            @Override
            public void accept(String s, String s2) {
                s2 = s2.toUpperCase();
                map.put(s, s2);
            }
        });
        System.out.println(map);
        map.computeIfAbsent("4", new Function<String, String>() {
            @Override
            public String apply(String s) {
                return s + "gg";
            }
        });
        System.out.println(map);
        map.computeIfAbsent("1", new Function<String, String>() {
            @Override
            public String apply(String s) {
                return s + "gg";
            }
        });
        System.out.println(map);
        map.merge("4", "K", new BiFunction<String, String, String>() {
            @Override
            public String apply(String s, String s2) {
                return "L";
            }
        });
        System.out.println(map);
        map.compute("4", new BiFunction<String, String, String>() {
            @Override
            public String apply(String s, String s2) {
                return null;
            }
        });
        System.out.println(map);
        BiFunction<String, String, String> myBiFun = new BiFunction<String, String, String>() {
            @Override
            public String apply(String s, String s2) {
                return "P";
            }
        };
        map.compute("4", myBiFun);
        System.out.println(map);
        BiFunction<String, String, String> stringStringStringBiFunction = myBiFun.andThen((key) -> {
            System.out.println(key + "ll");
            return "ll" + key + "1";
        });
        map.compute("4", stringStringStringBiFunction);
        System.out.println(map);

        // keySet得到的key的集合，该集合的实现无法删除和添加
        Set<String> set = map.keySet();
        System.out.println(String.format("set is %s", set));
        Set<Map.Entry<String, String>> entries = map.entrySet();
        Iterator<String> iterator = set.iterator();
        Iterator<Map.Entry<String, String>> iterator1 = entries.iterator();
        while (iterator.hasNext()) {
            String a = iterator.next();
            while (iterator1.hasNext()) {
                Map.Entry<String, String> entry = iterator1.next();
                if (entry.getKey().equals(a)) {
                    System.out.println(a);
                    System.out.println(String.format("key 相同 %s", a == entry.getKey()));
                    break;
                }
            }
        }

        System.out.println(map.size());
        map.remove("1");
        System.out.println(map.size());
        System.out.println("keyset size : " + set.size());

    }

}
