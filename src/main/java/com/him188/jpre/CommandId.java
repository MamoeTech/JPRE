package com.him188.jpre;

/**
 * @author Him188
 */
public enum CommandId {
	SEND_PRIVATE_MESSAGE(1),
	SEND_GROUP_MESSAGE(2),
	SEND_DISCUSS_MESSAGE(3),
	SEND_LIKE(4),
	SEND_LIKE_V2(5),
	GET_COOKIES(6),
	GET_RECORD(7),
	GET_CSRF_TOKEN(8),
	GET_APP_DIRECTORY(9),
	GET_LOGIN_QQ(10),
	GET_LOGIN_NICK(11),
	SET_GROUP_KICK(12),
	SET_GROUP_BAN(13),
	SET_GROUP_SPECIAL_TITLE(14),
	SET_GROUP_WHOLE_BAN(15),
	SET_GROUP_ANONYMOUS_BAN(16),
	SET_GROUP_CARD(17),
	SET_GROUP_LEAVE(18),
	SET_DISCUSS_LEAVE(19),
	SET_FRIEND_ADD_REQUEST(20),
	SET_GROUP_ADD_REQUEST(21),
	SET_GROUP_ADD_REQUEST_V2(22),
	ADD_LOG(23),
	SET_FATAL(24),
	GET_GROUP_MEMBER_INFO(25),
	GET_GROUP_MEMBER_INFO_V2(26),
	GET_STRANGER_INFO(27),

	SET_GROUP_ADMIN(28),
	SET_GROUP_ANONYMOUS(29);

	private final byte id;

	CommandId(int id) {
		this.id = (byte) id;
	}

	public byte getId() {
		return id;
	}
}
