package com.orkun.chatgptspringapi.openaiclient;

import com.orkun.chatgptspringapi.model.request.ChatGPTRequest;
import com.orkun.chatgptspringapi.model.request.WhisperTranscriptionRequest;
import com.orkun.chatgptspringapi.model.response.ChatGPTResponse;
import com.orkun.chatgptspringapi.model.response.WhisperTranscriptionResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(
        name = "openai-service",
        url = "${openai-service.urls.base-url}",
        configuration = OpenAIClientConfig.class
)
public interface OpenAIClient {

    @PostMapping(value = "${openai-service.urls.chat-url}",
            headers = {"Content-Type=application/json"})
    ChatGPTResponse chat(@RequestBody ChatGPTRequest chatGPTRequest);

    @PostMapping(value = "${openai-service.urls.create-transcription-url}",
            headers = {"Content-Type=multipart/form-data"})
    WhisperTranscriptionResponse createTranscription(
            @ModelAttribute WhisperTranscriptionRequest whisperTranscriptionRequest);

}
