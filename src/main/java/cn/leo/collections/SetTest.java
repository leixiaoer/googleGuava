package cn.leo.collections;

import com.google.common.collect.Lists;
import com.google.common.collect.Sets;
import org.junit.Test;

import java.util.*;

/*
 *文件名: SetTest
 *创建者: leo
 *创建时间:2023/1/12 11:59
 *描述: TODD
 */
public class SetTest {

    @Test
    public void setsCreate(){
        HashSet<String> set = Sets.newHashSet();
        LinkedHashSet<Object> objects = Sets.newLinkedHashSet();
        HashSet<Object> objects1 = Sets.newHashSetWithExpectedSize(10);
        TreeSet<Comparable> comparables = Sets.newTreeSet();
    }

    @Test
    public void cartesianProduct(){
        Set<String> set1 = Sets.newHashSet("a","b","c");
        Set<String> set2 = Sets.newHashSet("1","2","3");
        Set<String> set3 = Sets.newHashSet("@","#","&");
        //多个Set的笛卡尔集，参数接收多个set集合
        Set<List<String>> sets = Sets.cartesianProduct(set1,set2,set3);
        System.out.println(sets);

        List<Set<String>> list = Lists.newArrayList(set1,set2,set3);
        //也可以把多个Set集合，放到一个list中，再计算笛卡尔集
        Set<List<String>> sets1 = Sets.cartesianProduct(list);
        System.out.println(sets1);
        //Sets.combinations()
        //Sets.difference()
    }


    @Test
    public void differenceTest(){
        Set<String> set1 = Sets.newHashSet("a","b","d");
        Set<String> set2 = Sets.newHashSet("d","e","f");
        //difference返回：从set1中剔除两个set公共的元素
        System.out.println(Sets.difference(set1,set2));
        //symmetricDifference返回：剔除两个set公共的元素，再取两个集合的并集
        System.out.println(Sets.symmetricDifference(set1,set2));
    }


    @Test
    public void intersectionTest(){
        Set<String> set1 = Sets.newHashSet("a","b","c");
        Set<String> set2 = Sets.newHashSet("a","b","f");
        //取两个集合的交集
        System.out.println(Sets.intersection(set1,set2));
    }

    @Test
    public void filterTest(){
        Set<String> set1 = Sets.newHashSet("a","b","c");
        //建议可以直接使用java8的过滤，比较方便
        Set<String> set2 = Sets.filter(set1,str -> str.equalsIgnoreCase("b"));
        System.out.println(set2);
    }

    @Test
    public void powerSetTest(){
        Set<String> set1 = Sets.newHashSet("a","b","c");
        //获取set可分隔成的所有子集
        Set<Set<String>> allSet = Sets.powerSet(set1);
        for(Set<String> set : allSet){
            System.out.println(set);
        }
    }

    @Test
    public void unionTest(){
        Set<String> set1 = Sets.newHashSet("a","b","c");
        Set<String> set2 = Sets.newHashSet("1","2","3");
        //取两个集合的并集
        System.out.println(Sets.union(set1,set2));
    }


}
