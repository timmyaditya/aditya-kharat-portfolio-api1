package org.timmyaditya.adityaPortfolioJpa.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.timmyaditya.adityaPortfolioJpa.exception.ResourceNotFoundException;
import org.timmyaditya.adityaPortfolioJpa.model.MessageModel;
import org.timmyaditya.adityaPortfolioJpa.repository.MessageRepository;
import org.timmyaditya.adityaPortfolioJpa.service.MessageService;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class MessageServiceImpl implements MessageService {
	
	@Autowired
	private MessageRepository messageRepository;

	@Override
	public List<MessageModel> getMessages() {
		// TODO Auto-generated method stub
		List<MessageModel> messageModelList = this.messageRepository.selectAllData();
		return messageModelList;
	}

	@Override
	public MessageModel getMessageById(int id) throws ResourceNotFoundException {
		// TODO Auto-generated method stub
		try {
			MessageModel mm = this.messageRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Student not found for this id"));
			return mm;
		}
		catch(ResourceNotFoundException re) {
			throw re;
		}
	}

	@Override
	public List<MessageModel> getMessagesByName(String name) {
		// TODO Auto-generated method stub
			List<MessageModel> mm = this.messageRepository.selectAllDataByName(name);
			return mm;
	}

	@Override
	public MessageModel insertMessage(MessageModel messageModel) {
		// TODO Auto-generated method stub
		MessageModel me = this.messageRepository.save(messageModel);
		return me;
	}

	@Override
	public void deleteMessage(int id) throws ResourceNotFoundException {
		// TODO Auto-generated method stub
		try {
			this.getMessageById(id);
			this.messageRepository.deleteById(id);
		}
		catch(ResourceNotFoundException re) {
			throw re;
		}
	}
}
