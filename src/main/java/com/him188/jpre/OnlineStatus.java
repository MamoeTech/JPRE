
package com.him188.jpre;

/**
 * @author XianD
 */
public enum OnlineStatus {
	// TODO: 2017/4/19
    STATUS_ONLINE(1),                       //我在线上
    STATUS_Q_ME(2),                            //Q 我吧
    STATUS_LEAVE(3),                            //离开
    STATUS_WORKING(4),                          //忙碌
    STATUS_DO_NOT_DISTURB(5),               //请勿打扰
    STATUS_HIDE(6);                             //隐身

    private int id;
    OnlineStatus(int id) {
        this.id = id;
    }
    public int getId() {
        return id; }
    public void setId(int id) {
        this.id = id; }
}