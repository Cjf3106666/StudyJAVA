package com.cjf.DesignPattern.ResponsibilityChain;

/**
 * @Descpription 责任链模式
 * @Author CJF
 * @Date 2018/12/18 14:38
 **/
public class LeaveRequest {
    private String name;
    private String reason;
    private int leaveDay;

    public LeaveRequest(String name, String reason, int leaveDay) {
        this.name = name;
        this.reason = reason;
        this.leaveDay = leaveDay;
    }

    public LeaveRequest() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public int getLeaveDay() {
        return leaveDay;
    }

    public void setLeaveDay(int leaveDay) {
        this.leaveDay = leaveDay;
    }

    @Override
    public String toString() {
        return "姓名='" + name + '\'' +
                ", 请假原因='" + reason + '\'' +
                ", 请假天数=" + leaveDay;
    }
}
