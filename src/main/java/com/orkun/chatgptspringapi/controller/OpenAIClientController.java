package com.orkun.chatgptspringapi.controller;

import com.orkun.chatgptspringapi.model.request.ChatRequest;
import com.orkun.chatgptspringapi.model.request.TranscriptionRequest;
import com.orkun.chatgptspringapi.model.response.ChatGPTResponse;
import com.orkun.chatgptspringapi.model.response.WhisperTranscriptionResponse;
import com.orkun.chatgptspringapi.service.OpenAIClientService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/api/v1")
public class OpenAIClientController {

    private final OpenAIClientService openAIClientService;

    @PostMapping(value = "/chat", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ChatGPTResponse chat(@RequestBody ChatRequest chatRequest){
        return openAIClientService.chat(chatRequest);
    }

    @PostMapping(value = "/transcription", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public WhisperTranscriptionResponse createTranscription(
            @ModelAttribute TranscriptionRequest transcriptionRequest){

        return openAIClientService.createTranscription(transcriptionRequest);
    }
}
