package com.jiffydelivery.jiffy.Entity.Singletons;
import com.jiffydelivery.jiffy.Entity.DBDAO.Trip;

import java.util.ArrayDeque;
import java.util.Queue;

public enum ADVFamily {
    Robot0(0), Robot1(1), Robot2(2), Robot3(3), Robot4(4),
    Robot5(5), Robot6(6), Robot7(7), Robot8(8), Robot9(9),
    Robot10(10), Robot11(11), Robot12(12), Robot13(13), Robot14(14),
    Robot15(15), Robot16(16), Robot17(17), Robot18(18), Robot19(19),
    Robot20(20), Robot21(21), Robot22(22), Robot23(23), Robot24(24),
    Robot25(25), Robot26(26), Robot27(27), Robot28(28), Robot29(29),
    Robot30(30), Robot31(31), Robot32(32), Robot33(33), Robot34(34),
    Robot35(35), Robot36(36), Robot37(37), Robot38(38), Robot39(39),
    Robot40(40), Robot41(41), Robot42(42), Robot43(43), Robot44(44),
    Robot45(45), Robot46(46), Robot47(47), Robot48(48), Robot49(49),

    Drone0(50), Drone1(51), Drone2(52), Drone3(53), Drone4(54),
    Drone5(55), Drone6(56), Drone7(57), Drone8(58), Drone9(59),
    Drone10(60), Drone11(61), Drone12(62), Drone13(63), Drone14(64),
    Drone15(65), Drone16(66), Drone17(67), Drone18(68), Drone19(69);

    private final int id;
    private Queue<Trip> queue;

    ADVFamily(int id) {
        this.id = id;
        this.queue = new ArrayDeque<>();
    }

    public int getId() { return id; }
    public Queue<Trip> getQueue() {return queue;}

    public void setQueue(Queue<Trip> queue) {
        this.queue = queue;
    }
}