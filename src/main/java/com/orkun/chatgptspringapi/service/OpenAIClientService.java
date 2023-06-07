package com.orkun.chatgptspringapi.service;

import com.orkun.chatgptspringapi.model.request.*;
import com.orkun.chatgptspringapi.model.response.ChatGPTResponse;
import com.orkun.chatgptspringapi.model.response.WhisperTranscriptionResponse;
import com.orkun.chatgptspringapi.openaiclient.OpenAIClient;
import com.orkun.chatgptspringapi.openaiclient.OpenAIClientConfig;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Collections;

@Service
@RequiredArgsConstructor
public class OpenAIClientService {

    private final OpenAIClient openAIClient;
    private final OpenAIClientConfig openAIClientConfig;

    private final static String ROLE_USER = "user";

    public ChatGPTResponse chat(ChatRequest chatRequest){
        Message message = Message.builder()
                .role(ROLE_USER)
                .content(chatRequest.getQuestion())
                .build();
        ChatGPTRequest chatGPTRequest = ChatGPTRequest.builder()
                .model(openAIClientConfig.getModel())
                .messages(Collections.singletonList(message))
                .build();
        return openAIClient.chat(chatGPTRequest);
    }

    public WhisperTranscriptionResponse createTranscription(TranscriptionRequest transcriptionRequest){
        WhisperTranscriptionRequest whisperTranscriptionRequest = WhisperTranscriptionRequest.builder()
                .model(openAIClientConfig.getAudioModel())
                .file(transcriptionRequest.getFile())
                .build();
        return openAIClient.createTranscription(whisperTranscriptionRequest);
    }

}
