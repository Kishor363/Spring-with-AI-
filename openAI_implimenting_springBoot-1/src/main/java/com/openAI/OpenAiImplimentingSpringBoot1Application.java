package com.openAI;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.openai.OpenAiChatModel;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class OpenAiImplimentingSpringBoot1Application {
	
	 @Bean
	    public ChatClient chatClient(OpenAiChatModel chatModel) {
	        return ChatClient.create(chatModel);
	    }

	public static void main(String[] args) {
		SpringApplication.run(OpenAiImplimentingSpringBoot1Application.class, args);
	}

}
