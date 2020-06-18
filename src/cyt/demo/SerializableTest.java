package cyt.demo;

import java.io.*;
import java.util.*;
class User implements Serializable {
    private static final long serialVersionUID=1L;
    private String userId;
    private String userName;
    private int age;

    public User(String userId, String userName, int age) {
        this.userId = userId;
        this.userName = userName;
        this.age = age;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "TextUser{" +
                "userId='" + userId + '\'' +
                ", userName='" + userName + '\'' +
                ", age=" + age +
                '}';
    }
}
public class SerializableTest{
    public static void main(String[] srgs) {
        writeUser();
        readUser();
    }
    public static void writeUser(){
        try {
            User user = new User("1","张三",30);
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(("SerializableTest.txt")));
            objectOutputStream.writeObject(user);
            System.out.println("序列化成功！");
            objectOutputStream.close();
        }catch (Exception ex){
            System.out.printf("writeUser:"+ex.getMessage());
        }
    }
    public static void readUser(){
        User user =null;
        try {
            ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream("SerializableTest.txt"));
            user = (User)objectInputStream.readObject();
            System.out.println("反序列化成功！");
            System.out.println(user.toString());
        }catch (Exception ex){
            System.out.printf("readUser:"+ex.getMessage());
        }
    }
}
