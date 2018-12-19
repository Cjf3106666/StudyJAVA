package com.cjf.DesignPattern.Observer.Pub_Sub;

/**
 * @Descpription
 * @Author CJF
 * @Date 2018/12/18 12:15
 **/
public class Server {
    private Topic topic;

    public Server(Topic topic) {
        this.topic = topic;
    }

    public void SetContent(String content) {
        topic.setContent(content);
        topic.updateContent();
    }
}
