package com.cjf.DesignPattern.ResponsibilityChain;

/**
 * @Descpription 责任链模式
 * @Author CJF
 * @Date 2018/12/18 14:35
 **/
public abstract class Leader {

    protected String name;

    public Leader nextLeader;

    protected int max_leave_day;

    public Leader(String name, int max_leave_day) {
        this.name = name;
        this.max_leave_day = max_leave_day;
    }

    public Leader getNextLeader() {
        return nextLeader;
    }

    public void setNextLeader(Leader nextLeader) {
        this.nextLeader = nextLeader;
    }

    public int getMax_leave_day() {
        return max_leave_day;
    }

    public void setMax_leave_day(int max_leave_day) {
        this.max_leave_day = max_leave_day;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    abstract void handlerRequest(LeaveRequest request);
}
