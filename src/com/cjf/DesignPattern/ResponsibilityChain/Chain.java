package com.cjf.DesignPattern.ResponsibilityChain;

/**
 * @Descpription 责任链模式
 * @Author CJF
 * @Date 2018/12/18 14:35
 **/
public class Chain {
    static private Leader First;
    static {
        First=new TeamLeader("张三",10);
        Leader l2=new DivisionManager("李四",20);
        Leader l3=new GeneralManager("王五",30);
        First.nextLeader=l2;
        l2.nextLeader=l3;
    }
    static void HandlerRequest(LeaveRequest request){
        First.handlerRequest(request);
    }
}
