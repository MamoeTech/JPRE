package com.him188.jpre.event.qq;

import com.him188.jpre.QQ;
import com.him188.jpre.RobotQQ;
import com.him188.jpre.event.HandlerList;

/**
 * 他人请求添加机器人为好友
 *
 * @author Him188
 */
public class FriendAddRequestEvent extends QQEvent {
	private static final HandlerList handlers = new HandlerList();

	public static HandlerList getHandlers() {
		return handlers;
	}


	private final String reason;

	private boolean accepted;

	public FriendAddRequestEvent(RobotQQ robot, QQ qq, String reason) {
		super(robot, qq);
		this.reason = reason;
	}

	public String getReason() {
		return reason;
	}

	// TODO: 2017/4/19 接受请求
	public boolean isAccepted() {
		return accepted;
	}

	public void setAccepted(boolean accepted) {
		this.accepted = accepted;
	}
}
