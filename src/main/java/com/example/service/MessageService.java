package com.example.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.example.entity.Message;
import com.example.repository.MessageRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service
public class MessageService {

    private final MessageRepository messageRepository;
    private final AccountService accountService;

    @Autowired
    public MessageService(MessageRepository messageRepository, AccountService accountService) {
        this.messageRepository = messageRepository;
        this.accountService = accountService;
    }

    public Optional<Message> findById(Integer messageId){
        return messageRepository.findById(messageId);
    }

    public List<Message> findAll(){
        return messageRepository.findAll();
    }

    public ResponseEntity<Message> createMessage(Message message) {
        // Validate the message before creating
        validateMessageForCreation(message);
    
        // Ensure that the posted_by refers to a real, existing user
        if (accountService.findById(message.getPosted_by()).isEmpty()) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Invalid user (posted_by) specified in the message");
        }
    
        // Save the new message to the database
        Message createdMessage = messageRepository.save(message);
    
        // Return the created message with a status code of 200
        return ResponseEntity.ok(createdMessage);
    }

    public ResponseEntity<Integer> updateMessageText(Integer messageId, String newMessageText) {
        // Find the existing message by ID
        Optional<Message> optionalMessage = messageRepository.findById(messageId);

        if (optionalMessage.isPresent()) {
            Message existingMessage = optionalMessage.get();

            // Validate the new message text
            validateMessageText(newMessageText);

            // Update the message text
            existingMessage.setMessage_text(newMessageText);
            messageRepository.save(existingMessage);

            // Return the number of rows updated (1)
            return ResponseEntity.ok(1);
        } else {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Invalid message ID");
        }
    }

    private void validateMessageForCreation(Message message) {
        // Check if the message_text is not blank and is under 255 characters
        if (message.getMessage_text() == null || message.getMessage_text().trim().isEmpty()) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Message text cannot be blank");
        }

        if (message.getMessage_text().length() > 255) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Message text must be under 255 characters");
        }
    }

    private void validateMessageText(String newMessageText) {
        // Check if the new message text is not blank and is not over 255 characters
        if (newMessageText == null || newMessageText.trim().isEmpty()) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "New message text cannot be blank");
        }

        if (newMessageText.length() > 255) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "New message text must be under 255 characters");
        }
    }

        // Response class to represent the result of the delete operation
    public class DeleteResponse {
        private int rowsUpdated;

        public DeleteResponse(int rowsUpdated) {
            this.rowsUpdated = rowsUpdated;
        }

        public int getRowsUpdated() {
            return rowsUpdated;
        }
    }

    public Integer deleteById(Integer messageId) {
        try {
            // Attempt to delete the message
            messageRepository.deleteById(messageId);
            // If successful, return 1 to indicate 1 row updated
            return 1;
        } catch (EmptyResultDataAccessException e) {
            // If the message did not exist, return 0 to indicate 0 rows updated
            return 0;
        }
    }
    
    
    
    
    
    
    
    


    public List<Message> findAllMessagesByUser(Integer userId){
        if(accountService.findById(userId).isEmpty()){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "User not found");
        }
        //Retrieve messages by user ID
        return messageRepository.findByPostedBy(userId);
    }


}
