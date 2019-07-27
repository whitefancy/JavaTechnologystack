package javacore;

import JavaBasics.Person;

import java.util.Arrays;
import java.util.List;

/*
通过视图views 可以获得其他实现了Collection 和Map接口的对象
实际情况是 这个类的方法对原映射进行操作， 这种复合的集合称为视图
 */
public class ViewsTest {
    /*
    轻量级 集合包装器
    Arrays 的asList方法 返回 包装了普通Java数组 的List包装器
    返回的对象并不是ArrayList，而是一个带有访问数组全部方法的视图对象，
    只能用get和set ，不能用ArrayList的add 或remove 但实际上可以用？？？
     */
    private Person[] people = new Person[20];
    private List<Person> peoplelist = Arrays.asList(people);

    {
        peoplelist.add(new Person("d"));
        peoplelist.remove(0);
        peoplelist.set(0, new Person("s"));
    }
}
