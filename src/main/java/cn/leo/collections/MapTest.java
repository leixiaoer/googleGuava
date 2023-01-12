package cn.leo.collections;

import com.google.common.collect.MapDifference;
import com.google.common.collect.Maps;
import com.google.common.collect.Sets;
import org.junit.Test;

import java.util.Map;
import java.util.Set;

/*
 *文件名: MapTest
 *创建者: leo
 *创建时间:2023/1/12 12:04
 *描述: TODD
 */
public class MapTest {
    @Test
    public void createDemo(){
        Maps.newHashMap();
        Maps.newHashMapWithExpectedSize(10);
        //Maps.newEnumMap();
        Maps.newConcurrentMap();
        Maps.newIdentityHashMap();

        Maps.newLinkedHashMap();

        Maps.newTreeMap();
    }


    @Test
    public void asMapTest(){
        Set<String> set = Sets.newHashSet("a","b","c");
        //将set转成Map,key为set元素,value为每个元素的长度
        Map<String,Integer> map = Maps.asMap(set,String::length);
        System.out.println(map);
    }

    @Test
    public void differenceTest(){
        Map<String,String> map1 = Maps.newHashMap();
        map1.put("a","1");
        map1.put("b","2");
        map1.put("c","3");
        Map<String,String> map2 = Maps.newHashMap();
        map2.put("a","1");
        map2.put("e","5");
        map2.put("f","6");
        //mapDifference是将两个map相同的部分剔除
        MapDifference<String,String> mapDifference = Maps.difference(map1,map2);
        //两个Map相同的部分
        System.out.println(mapDifference.entriesInCommon());
        //左边集合剔除相同部分后的剩余
        System.out.println(mapDifference.entriesOnlyOnLeft());
        //右边集合剔除相同部分后的剩余
        System.out.println(mapDifference.entriesOnlyOnRight());
    }

    @Test
    public void filterEntriesTest(){
        Map<String,String> map1 = Maps.newHashMap();
        map1.put("a","1");
        map1.put("b","2");
        map1.put("c","3");
        Map<String,String> result = Maps.filterEntries(map1,item -> !item.getValue().equalsIgnoreCase("2"));
        System.out.println(result);

    }


    @Test
    public void filterKeysTest(){
        Map<String,String> map1 = Maps.newHashMap();
        map1.put("a","1");
        map1.put("b","2");
        map1.put("c","3");
        Map<String,String> result = Maps.filterKeys(map1, item -> !item.equalsIgnoreCase("b"));
        System.out.println(result);
    }


    @Test
    public void filterValuesTest(){
        Map<String,String> map1 = Maps.newHashMap();
        map1.put("a","1");
        map1.put("b","2");
        map1.put("c","3");
        Map<String,String> result =  Maps.filterValues(map1,item -> !item.equalsIgnoreCase("3"));
        System.out.println(result);
    }


    @Test
    public void transFormEntriesTest(){
        Map<String,String> map1 = Maps.newHashMap();
        map1.put("a","1");
        map1.put("b","2");
        map1.put("c","3");
        Map<String,String> result = Maps.transformEntries(map1,(k,v) -> k + v);
        System.out.println(result);
    }


    @Test
    public void transformValuesTest(){
        Map<String,String> map1 = Maps.newHashMap();
        map1.put("a","1");
        map1.put("b","2");
        map1.put("c","3");
        Map<String,String> result = Maps.transformValues(map1, value -> value + 10);
        System.out.println(result);
    }


}
