package com.rms.entity.viewEntity;

import com.rms.entity.entityEnum.MessageType;

public class MessageView {
    private MessageType messageType;
    private String content;

    public MessageView() {
    }

    public MessageView(MessageType messageType, String content) {
        this.messageType = messageType;
        this.content = content;
    }

    public MessageType getMessageType() {
        return messageType;
    }

    public void setMessageType(MessageType messageType) {
        this.messageType = messageType;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

}
