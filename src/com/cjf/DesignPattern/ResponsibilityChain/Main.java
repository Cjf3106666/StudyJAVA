package com.cjf.DesignPattern.ResponsibilityChain;

/**
 * @Descpription 责任链模式
 * @Author CJF
 * @Date 2018/12/18 14:51
 **/
public class Main {
    public static void main(String[] args) {

        LeaveRequest request=new LeaveRequest("小陈同学","参加同学婚礼",24);
        Chain.HandlerRequest(request);


    }
}
