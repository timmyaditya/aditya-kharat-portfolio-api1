package org.timmyaditya.adityaPortfolioJpa.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.timmyaditya.adityaPortfolioJpa.exception.ResourceNotFoundException;
import org.timmyaditya.adityaPortfolioJpa.model.MessageModel;
import org.timmyaditya.adityaPortfolioJpa.service.MessageService;

import java.sql.Timestamp;
import java.util.Date;

@RestController
@RequestMapping("/aditya/v1/")
@CrossOrigin
public class MessageController {
	@Autowired
	private MessageService messageService;
	
	//get all the messages
	@GetMapping("/messages/getallthemessages")
	public List<MessageModel> getAllMessages(){
		List<MessageModel> messageModelList = messageService.getMessages();
		return messageModelList;
	}
	//get message by id
	@GetMapping("/messages/id/{id}")
	public ResponseEntity<MessageModel> getMessageById(@PathVariable(value = "id") int id) throws ResourceNotFoundException{
		MessageModel mm = messageService.getMessageById(id);
		return ResponseEntity.ok().body(mm);
	}
	//get message by name
	@GetMapping("/messages/name/{name}")
	public List<MessageModel> getMessagesByName(@PathVariable(value = "name") String name){
		System.out.println(name);
		List<MessageModel> list = messageService.getMessagesByName(name);
		return list;
	}
	//insert message
//	@PostMapping("/messages")
//	public MessageModel insert(@RequestBody MessageModel messageModel) {
//		MessageModel mm = messageService.insertMessage(messageModel);
//		return mm;
//	}
	
	@PostMapping("/messages")
	public MessageModel insert(@RequestParam("name") String name,@RequestParam("email") String email, @RequestParam("subject") String subject, @RequestParam("message") String message) {
		Date date = new Date();
		Timestamp ts = new Timestamp(date.getTime());
		MessageModel messageModel = new MessageModel(name, email, subject, message, ts.toString());
		MessageModel mm = messageService.insertMessage(messageModel);
		return mm;
	}
	
	//delete message
	@DeleteMapping("/messages/deletecertainmessagebyid/{id}")
	public Map<String, Boolean> deleteMessage(@PathVariable(value = "id") int id) throws ResourceNotFoundException{
		messageService.deleteMessage(id);
		
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		
		return response;
	}
}
