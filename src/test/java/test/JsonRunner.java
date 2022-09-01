package test;

import com.example.json.JSON;
import com.example.json.parser.Json;
import com.example.json.parser.JsonLexer;
import com.example.json.parser.JsonParser;
import com.example.json.parser.Value;
import com.example.json.type.ClassType;

import java.util.*;

public class JsonRunner {
    public static Json getJson(String text){
        return new JsonParser(new JsonLexer(text)).parseJson();
    }
    public static List<Value> getValues(String text){
        return new JsonParser(new JsonLexer(text)).parseJsonArray();
    }
    public static Value getValue(String text){
        return new JsonParser(new JsonLexer(text)).parseValue();
    }

    public static void main(String[] args)  {
        System.out.println(Arrays.deepToString(JSON.getArray(int[][].class,"[[1,2],[3,4]]")));
        JSON.getObjList("[[1,2],[3,4]]",int[].class).forEach(x->{
           System.out.println( Arrays.toString(x));;
       });
        //复杂结构测试
        String  json = "{\n" +
                "\n" +
                "\"i\":1,\n" +
                "\"is\":[1,2,3,4],\n" +

                "\"il1\":[1,2,3,4],\n" +
                "\"str\":\"helo world\",\n" +
                "\"c\":3,\n" +
                "\"d\":\"hello wor\",\n" +
                "\"e\":4,\n" +
                "\"s\":[5,6,7,8],\n" +
                "\"cc\":[[1,2,3],[4,5,6]],\n" +
                "\"xx\":[[1,2,3],[4,5,6]],\n" +
                "\"mm\":{\"1\":\"a\",\"2\":\"b\"},\n" +
                "\"vv\":{\"[1,2,3]\":\"helo\",\"[4,5,6]\":\"world\"}\n" +
                "\n" +
                "\n" +
                "}";
       ClassType<A<Integer,String,Integer>> classType = new ClassType<>(){};
        A a = JSON.getObj(A.class,json,classType);
        System.out.println(a);

    }
    public static class A<C,D,E>{
        Integer i;
        Integer[] is;
        int il;
        short sht;
        long sdf;
        float ff;
        double sdfsdf;
        char csdc;
        int[] il1;
        String str;
        C c;
        D d;
        E E;
        //复杂对象注释掉，会上升一个数量级
        List<C> s;
        LinkedList<ArrayList<C>> cc;
        HashSet<C>[] xx;
        Map<C,D> mm;
        LinkedHashMap<LinkedList<C>,D> vv;
    }


}
