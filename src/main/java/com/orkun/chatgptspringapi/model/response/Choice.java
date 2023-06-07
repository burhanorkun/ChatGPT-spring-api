package com.orkun.chatgptspringapi.model.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.orkun.chatgptspringapi.model.request.Message;
import lombok.Data;

import java.io.Serializable;

@Data
public class Choice implements Serializable {
    private Integer index;
    private Message message;
    @JsonProperty("finish_reason")
    private String finishReason;
}
