package com.him188.jpre.event.group;

import com.him188.jpre.Group;
import com.him188.jpre.QQ;
import com.him188.jpre.RobotQQ;
import com.him188.jpre.event.HandlerList;

/**
 * 管理员关闭了匿名聊天
 *
 * @author Him188
 */
public class GroupAnonymousDisableEvent extends GroupEvent {
	private static final HandlerList handlers = new HandlerList();

	public static HandlerList getHandlers() {
		return handlers;
	}


	public GroupAnonymousDisableEvent(RobotQQ robot, Group group, QQ qq) {
		super(robot, group, qq);
	}
}