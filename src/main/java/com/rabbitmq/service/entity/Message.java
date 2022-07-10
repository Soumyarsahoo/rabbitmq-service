package com.rabbitmq.service.entity;

public class Message {
	
	private Long dataId;
	private String cifNo;
	private String routingKey;
	
	public Message() {
	}
	
	public Message(Long dataId, String cifNo, String routingKey) {
		this.dataId = dataId;
		this.cifNo = cifNo;
		this.routingKey = routingKey;
	}



	public Long getDataId() {
		return dataId;
	}
	public void setDataId(Long dataId) {
		this.dataId = dataId;
	}
	public String getCifNo() {
		return cifNo;
	}
	public void setCifNo(String cifNo) {
		this.cifNo = cifNo;
	}
	
	public String getRoutingKey() {
		return routingKey;
	}

	public void setRoutingKey(String routingKey) {
		this.routingKey = routingKey;
	}

	@Override
	public String toString() {
		return "Message [dataId=" + dataId + ", cifNo=" + cifNo + ", routingKey=" + routingKey + "]";
	}

	

}
