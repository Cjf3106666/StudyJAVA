package com.cjf.DesignPattern.Observer.Pub_Sub;

/**
 * @Descpription
 * @Author CJF
 * @Date 2018/12/18 12:16
 **/
public class Main {
    public static void main(String[] args) {

        Observer o1 = new Observer();
        Observer o2 = new Observer();
        Observer o3 = new Observer();
        Observer o4 = new Observer();
        Observer o5 = new Observer();
        Observer o6 = new Observer();
        Topic topic = new Topic();
        topic.register(o1);
        topic.register(o2);
        topic.register(o3);
        topic.register(o4);
        topic.register(o5);
        topic.register(o6);
        Server server = new Server(topic);
        server.SetContent("新闻热点事件*********");
        System.out.println("发布新闻");
        System.out.println("o1"+o1.getContent());
        System.out.println(o2.getContent());
        System.out.println(o3.getContent());
        System.out.println(o4.getContent());
        System.out.println(o5.getContent());
        System.out.println(o6.getContent());
        System.out.println("发布娱乐头条");
        server.SetContent("娱乐头条事件**********");
        System.out.println(o1.getContent());
        System.out.println(o2.getContent());
        System.out.println(o3.getContent());
        System.out.println(o4.getContent());
        System.out.println(o5.getContent());
        System.out.println(o6.getContent());
    }
}
