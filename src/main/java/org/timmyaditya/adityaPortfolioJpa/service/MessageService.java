package org.timmyaditya.adityaPortfolioJpa.service;

import java.util.List;

import org.timmyaditya.adityaPortfolioJpa.exception.ResourceNotFoundException;
import org.timmyaditya.adityaPortfolioJpa.model.MessageModel;


public interface MessageService {
	  List<MessageModel> getMessages();
	  MessageModel getMessageById(int id) throws ResourceNotFoundException;
	  List<MessageModel> getMessagesByName(String name);
	  MessageModel insertMessage(MessageModel messageModel);
	  void deleteMessage(int id) throws ResourceNotFoundException;
}
