package net.mamoe.jpre.network.packet;

/**
 * @author Him188 @ JPRE Project
 */
public class ClientPingPacket extends Packet{
	public static final byte NETWORK_ID = Protocol.CLIENT_PING;

	@Override
	public void encode() {

	}

	@Override
	public void decode() {

	}

	@Override
	public byte getNetworkId() {
		return NETWORK_ID;
	}
}
