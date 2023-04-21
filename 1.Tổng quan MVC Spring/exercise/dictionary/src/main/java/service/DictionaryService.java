package service;

import java.util.HashMap;
import java.util.Map;

public class DictionaryService {
    static Map<String, String> dictionary = new HashMap<>();

    static {
        dictionary.put("hello", "xin chao");
        dictionary.put("beautiful", "xinh dep");
        dictionary.put("world", "the gioi");
        dictionary.put("red", "màu đỏ");
    }

    public String search(String val) {
        String result= dictionary.get(val);
        return result;
    }
}
