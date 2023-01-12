package cn.leo.collections;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.Lists;
import org.junit.Test;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.stream.Collectors;

/*
 *文件名: ListTest
 *创建者: leo
 *创建时间:2023/1/12 11:42
 *描述: 集合工具类
 */
public class ListTest {

    /**
     * 创建集合的方式
     */
    @Test
    public void ListCreateTest() {
        //将数组转成list,并在开头位置插入元素
        List<String> list = Lists.asList("a", new String[]{"b", "c", "d"});
        System.out.println(list);

        List<String> list1 = Lists.asList("a", "b", new String[]{"c", "d", "e"});
        System.out.println(list1);

        //直接创建ArrayList
        ArrayList<String> arrayList = Lists.newArrayList();
        System.out.println(arrayList);

        //创建ArrayList,并初始化
        ArrayList<String> arrayList1 = Lists.newArrayList("a", "b", "c");
        System.out.println(arrayList1);

        //基于现有的arrayList,创建一个arrayList
        ArrayList<String> arrayList2 = Lists.newArrayList(arrayList1);
        System.out.println(arrayList2);

        //初始化指定容量大小的ArrayList，其中容量指ArrayList底层依赖的数组的length属性值，常用于提前知道ArrayList大小的情况的初始化
        ArrayList<String> arrayList3 = Lists.newArrayListWithCapacity(10);
        System.out.println(arrayList3);

        //初始化预定容量大小的ArrayList，返回的list的实际容量为5L + estimatedSize + (estimatedSize / 10)，常用于不确定ArrayList大小的情况的初始化
        ArrayList<String> arrayList4 = Lists.newArrayListWithExpectedSize(20);
        System.out.println(arrayList4);

        //创建CopyOnWriteArrayList
        CopyOnWriteArrayList<String> copyOnWriteArrayList = Lists.newCopyOnWriteArrayList();
        System.out.println(copyOnWriteArrayList);

        //创建linkedList
        LinkedList<String> linkedList = Lists.newLinkedList();
        System.out.println(linkedList);
    }


    @Test
    public void partitionTest(){
        List<String> list = Lists.newArrayList("a","b","c","d","e");
        //将list按大小为2分隔成多个list
        List<List<String>> splitList = Lists.partition(list,2);
        System.out.println(splitList);

    }


    @Test
    public void charactersOfTest(){
        //将字符串转成字符集合
        ImmutableList<Character> list = Lists.charactersOf("ababcdfb");
        System.out.println(list);
    }


    @Test
    public void reverseTest(){
        List<String> list = Lists.newArrayList("a","b","c","1","2","3");
        //反转list
        List<String> reverseList = Lists.reverse(list);
        System.out.println(reverseList);
    }


    @Test
    public void transFormTest(){
        List<String> list = Lists.newArrayList("a","b","c");
        //把list中的每个元素拼接一个1
        //List<String> list1 = list.stream().map(str -> str + "1").collect(Collectors.toList());
        List<String> list1 = Lists.transform(list,str -> str + "1");
        System.out.println(list1);
    }



}
