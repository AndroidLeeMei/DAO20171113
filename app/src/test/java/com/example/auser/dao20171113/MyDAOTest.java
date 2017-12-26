package com.example.auser.dao20171113;

import com.example.auser.dao20171113.data.Student;
import com.example.auser.dao20171113.data.StudentDAOMemoryImpl;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * 測試程式的class檔名在newbin裏一定要
 JUnit Assert 提供的方法
 http://jjnnykimo.pixnet.net/blog/post/31091305-junit-assert-%E6%8F%90%E4%BE%9B%E7%9A%84%E6%96%B9%E6%B3%95

 1．assertEquals()方法，用來查看物件中存的值是否是期待的值，與字串比較中使用的equals()方法類似；
 　　2．assertFalse()和assertTrue()方法，用來查看變數是是否為false或true，如果assertFalse()查看的變數的值是false則測試成功，如果是true則失敗，assertTrue()與之相反；
 　　3．assertSame()和assertNotSame()方法，用來比較兩個物件的引用是否相等和不相等，類似於通過“==”和“!=”比較兩個物件；
 　　4．assertNull()和assertNotNull()方法，用來查看物件是否為空和不為空;
 　　5．fail ()方法，意為失敗，用來拋出錯誤。我個人認為有兩個用途：首先是在測試驅動開發中，由於測試用例都是在被測試的類之前編寫，而寫成時又不清楚其正確與否，此時就可以使用fail方法拋出錯誤進行類比；其次是拋出意外的錯誤，比如要測試的內容是從資料庫中讀取的資料是否正確，而導致錯誤的原因卻是資料庫連接失敗。
 */

public class MyDAOTest {
    @Test
    public void MyTest1(){
//        assertEquals(3+6,9);
        assertEquals(11,9+2);
    }
    @Test
    public void TestMemoryDAO2(){
        StudentDAOMemoryImpl dao=new StudentDAOMemoryImpl();
        dao.clear();
        dao.add(new Student("aa","55","aaaa"));
        Student[] atus=dao.getData();
//        Student[] stus=dao.getData();
        assertEquals(atus[0].tel,"55");//
//        assertEquals(atus[0].tel,"22");//org.junit.ComparisonFailure:
//        System.out.println("測試成");
    }
    @Test
    public void TestMemoryDAO3Update(){
        StudentDAOMemoryImpl dao=new StudentDAOMemoryImpl();
        dao.add(new Student("aa","55","aaaa"));
        dao.add(new Student("bb","522","bbbb"));
        Student[] stus=dao.getData();
        Student s=stus[1];
        s.addr="addr";
//        Student[] check=d
        assertEquals(stus[1].addr,"addr");
        System.out.println("TestMemoryDAO3Update test ok");
    }

    @Test
    public void TestDAOUpdate(){
        StudentDAOMemoryImpl dao=new StudentDAOMemoryImpl();
//        dao.clear();
        dao.add(new Student("aa","55","aaaa"));
        dao.add(new Student("bb","522","bbbb"));
        Student[] atus=dao.getData();
        System.out.println("atus[0].tel=" +atus[0].id);

        Student s=new Student("CCC","333","cccc");
        s.id=atus[0].id;
        dao.update(s);
        System.out.println("atus[0].tel=" +atus[0].tel);

        System.out.println("TestDAOUpdate test ok");

//        dao.aa();
//
////        Student[] stus=dao.getData();
//        assertEquals(atus[0].tel,"55");//
////        assertEquals(atus[0].tel,"22");//org.junit.ComparisonFailure:
//        System.out.println("測試成");
    }
    @Test
    public void TestMemoryDAO4Delete(){
        StudentDAOMemoryImpl dao=new StudentDAOMemoryImpl();
        dao.add(new Student("1aa","51","aaaa"));
        dao.add(new Student("1aa","52","bbb2"));
        dao.add(new Student("1aa","53","bbbb3"));
        dao.add(new Student("1aa","54","bbbb4"));
        Student s=dao.getData()[2];
        dao.delete(s);
        System.out.println("TestMemoryDAO4Delete=" + dao.getData()[0].addr);
        assertEquals(dao.getData()[2].name,"1aa");
        assertEquals(dao.getData()[2].tel,"54");
        assertEquals(dao.getData()[2].addr,"bbbb4");
    }

    @Test
    public void getCount(){
        StudentDAOMemoryImpl dao=new StudentDAOMemoryImpl();
        dao.add(new Student("1aa","51","aaaa"));
        dao.add(new Student("1aa","52","bbb2"));
        dao.add(new Student("1aa","53","bbbb3"));
        dao.add(new Student("1aa","54","bbbb4"));
        System.out.println("dao.getCount()=" + dao.getCount());

    }

//    getCount

    @Test
    public void getOneStudent_Test(){
        StudentDAOMemoryImpl dao=new StudentDAOMemoryImpl();
        dao.add(new Student("1aa","51","aaaa"));
        dao.add(new Student("2bb","52","bbb2"));
        dao.add(new Student("3bb","53","bbbb"));
        Student s=dao.getOneStudent(1);
        System.out.println("s.name= "+ s.name);
        System.out.println("s.tel= "+ s.tel);
        assertEquals(s.name,"2bb");
        assertEquals(s.tel,"52");
        assertEquals(s.addr,"bbb2");
        System.out.println("getOneStudent 測試成");
//        Student[] atus=dao.getData();
    }
//    Student getOneStudent(int id);
//    Student[] searchByName(String name);功
    @Test
    public void searchByNameTest(){
        StudentDAOMemoryImpl dao=new StudentDAOMemoryImpl();
        dao.add(new Student("1aa","51","aaaa"));
        dao.add(new Student("2bb","52","bbb2"));
        dao.add(new Student("1aa","53","bbbb"));

        Student[] s=dao.searchByName("1aa");
        System.out.println("ss.length= "+ s.length);
        System.out.println("ss.name= "+ s[0].name);
        System.out.println("ss.tel= "+ s[0].tel);

        System.out.println("ss.length= "+ s.length);
        System.out.println("ss.name= "+ s[1].name);
        System.out.println("ss.tel= "+ s[1].tel);

        assertEquals(s[0].name,"1aa");
        assertEquals(s[0].tel,"51");
        assertEquals(s[0].addr,"aaaa");

        assertEquals(s[1].name,"1aa");
        assertEquals(s[1].tel,"53");
        assertEquals(s[1].addr,"bbbb");

        System.out.println("getOneStudent 測試成");


    }


}
