package com.openAI.controller;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.image.ImagePrompt;
import org.springframework.ai.image.ImageResponse;
import org.springframework.ai.openai.OpenAiChatModel;
import org.springframework.ai.openai.OpenAiImageModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.util.MimeTypeUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
public class OpenAiController {
	
	@Autowired
	private ChatClient chatClient;
	@Autowired
	private OpenAiChatModel chatModel;
	@Autowired
	private OpenAiImageModel imageModel;
	
	
	//prompt to text generation
	@GetMapping("/ai/text/{prompt}")
	public ResponseEntity<String> getTextResponse(@PathVariable String prompt){
		
		String response=chatClient.prompt(prompt).call().content();
		return ResponseEntity.ok(response);
		
	}
	
	//prompt to image generation
	@GetMapping("/ai/image/{prompt}")
	public ResponseEntity<String> getImageResponse(@PathVariable String prompt){
		
		ImagePrompt promt1=new ImagePrompt(prompt);
		ImageResponse response=imageModel.call(promt1);
		String url=response.getResult().getOutput().getUrl();
		return ResponseEntity.ok(url);
		
	}
	
	
	//image to details about image 
	
	@PostMapping("/ai/imagetotext/{prompt}")
	public ResponseEntity<String> getDetailsAboutImage(@PathVariable String prompt,@RequestParam MultipartFile file){
		String content=chatClient.prompt().user(usr->usr.text(prompt).media(MimeTypeUtils.IMAGE_JPEG,file.getResource())).call().content();
		
		return ResponseEntity.ok(content);
		
	}

}
