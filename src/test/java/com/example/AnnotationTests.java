package com.example;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;

import org.junit.jupiter.api.Test;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.account.AccountRepository;
import com.example.account.AccountService;
import com.example.controller.SocialMediaController;
import com.example.message.MessageRepository;
import com.example.message.MessageService;

@SpringBootTest
class AnnotationTests {
	/* SOCIAL MEDIA APP CLASS */
	@Test
	void socialMediaAppClassAnnotationsTest() {
		Class<SocialMediaApp> sma = SocialMediaApp.class;
		assertTrue(sma.isAnnotationPresent(SpringBootApplication.class), "@SpringBootApplication annotation is missing from Social Media App class");
	}
	
	/* SOCIAL MEDIA CONTROLLER CLASS */
	@Test
	void socialMediaControllerClassAnnotationsTest() {
		Class<SocialMediaController> smc = SocialMediaController.class;
		assertTrue(smc.isAnnotationPresent(RestController.class), "@SpringBootApplication annotation is missing from Social Media Controller class");
	}
	
	@Test
	void controllerGetAllMessagesMethodAnnotationsTest () throws SecurityException {
		Class<SocialMediaController> smc = SocialMediaController.class;
		Method m;
		boolean annotationIsPresent = false;
		
		try {
			m = smc.getDeclaredMethod("getAllMessages");
			for (Annotation an : m.getDeclaredAnnotations()) {
				if (an instanceof GetMapping) annotationIsPresent = true;
			}
		} catch (NoSuchMethodException e) {
			fail("getAllMessages() method not found in SocialMediaController class. Review your method spelling. Refer back to your instructions for more details");
		}
		
		assertTrue(annotationIsPresent, "SocialMediaController - getAllMessages() method missing @GetMapping annotation.");
	}
	
	@Test
	void controllerGetMessageByIDMethodAnnotationsTest () throws SecurityException {
		Class<SocialMediaController> smc = SocialMediaController.class;
		Method m;
		boolean annotationIsPresent = false;
		
		try {
			m = smc.getDeclaredMethod("getMessageByID", int.class);
			for (Annotation an : m.getDeclaredAnnotations()) {
				if (an instanceof GetMapping) annotationIsPresent = true;
			}
		} catch (NoSuchMethodException e) {
			fail("getMessageByID() method not found in SocialMediaController class. Review your method spelling and parameter list. Refer back to your instructions for more details.");
		}
		
		assertTrue(annotationIsPresent, "SocialMediaController - getMessageByID() method missing @GetMapping annotation.");
	}
	
	@Test
	void controllerGetMessageByAccountMethodAnnotationsTest () throws SecurityException {
		Class<SocialMediaController> smc = SocialMediaController.class;
		Method m;
		boolean annotationIsPresent = false;
		
		try {
			m = smc.getDeclaredMethod("getMessageByAccount", int.class);
			for (Annotation an : m.getDeclaredAnnotations()) {
				if (an instanceof GetMapping) annotationIsPresent = true;
			}
		} catch (NoSuchMethodException e) {
			fail("getMessageByAccount() method not found in SocialMediaController class. Review your method spelling and parameter list. Refer back to your instructions for more details.");
		}
		
		assertTrue(annotationIsPresent, "SocialMediaController - getMessageByAccount() method missing @GetMapping annotation.");
	}
	
	@Test
	void controllerRegisterAccountMethodAnnotationsTest () throws SecurityException {
		Class<SocialMediaController> smc = SocialMediaController.class;
		Method m;
		boolean annotationIsPresent = false;
		
		try {
			m = smc.getDeclaredMethod("registerAccount", String.class, String.class);
			for (Annotation an : m.getDeclaredAnnotations()) {
				if (an instanceof PostMapping) annotationIsPresent = true;
			}
		} catch (NoSuchMethodException e) {
			fail("registerAccount() method not found in SocialMediaController class. Review your method spelling and parameter list. Refer back to your instructions for more details.");
		}
		
		assertTrue(annotationIsPresent, "SocialMediaController - registerAccount() method missing @PostMapping annotation.");
	}
	
	@Test
	void controllerNewMessageMethodAnnotationsTest () throws SecurityException {
		Class<SocialMediaController> smc = SocialMediaController.class;
		Method m;
		boolean annotationIsPresent = false;
		
		try {
			m = smc.getDeclaredMethod("newMessage", int.class, String.class, long.class);
			for (Annotation an : m.getDeclaredAnnotations()) {
				if (an instanceof PostMapping) annotationIsPresent = true;
			}
		} catch (NoSuchMethodException e) {
			fail("newMessage() method not found in SocialMediaController class. Review your method spelling and parameter list. Refer back to your instructions for more details.");
		}
		
		assertTrue(annotationIsPresent, "SocialMediaController - newMessage() method missing @PostMapping annotation.");
	}
	
	@Test
	void controllerLoginMethodAnnotationsTest () throws SecurityException {
		Class<SocialMediaController> smc = SocialMediaController.class;
		Method m;
		boolean annotationIsPresent = false;
		
		try {
			m = smc.getDeclaredMethod("login", String.class, String.class);
			for (Annotation an : m.getDeclaredAnnotations()) {
				if (an instanceof GetMapping) annotationIsPresent = true;
			}
		} catch (NoSuchMethodException e) {
			fail("login() method not found in SocialMediaController class. Review your method spelling and parameter list. Refer back to your instructions for more details.");
		}
		
		assertTrue(annotationIsPresent, "SocialMediaController - login() method missing @GetMapping annotation.");
	}
	
	@Test
	void controllerDeleteMessageMethodAnnotationsTest () throws SecurityException {
		Class<SocialMediaController> smc = SocialMediaController.class;
		Method m;
		boolean annotationIsPresent = false;
		
		try {
			m = smc.getDeclaredMethod("deleteMessage", int.class);
			for (Annotation an : m.getDeclaredAnnotations()) {
				if (an instanceof DeleteMapping) annotationIsPresent = true;
			}
		} catch (NoSuchMethodException e) {
			fail("deleteMessage() method not found in SocialMediaController class. Review your method spelling and parameter list. Refer back to your instructions for more details.");
		}
		
		assertTrue(annotationIsPresent, "SocialMediaController - deleteMessage() method missing @DeleteMapping annotation.");
	}
	
	/* ACCOUNT REPOSITORY INTERFACE */
	@Test
	void accountRepositoryInterfaceAnnotationsTest() {
		Class<AccountRepository> smc = AccountRepository.class;
		assertTrue(smc.isAnnotationPresent(Repository.class), "@Repository annotation is missing from Account Repository interface");
	}
	
	@Test
	void accountRepositoryLoginMethodAnnotationsTest () throws SecurityException {
		Class<AccountRepository> ar = AccountRepository.class;
		Method m;
		boolean annotationIsPresent = false;
		
		try {
			m = ar.getDeclaredMethod("login", String.class, String.class);
			for (Annotation an : m.getDeclaredAnnotations()) {
				if (an instanceof Query) annotationIsPresent = true;
			}
		} catch (NoSuchMethodException e) {
			fail("login() method not found in AccountRepository interface. Review your method spelling and parameter list. Refer back to your instructions for more details.");
		}
		
		assertTrue(annotationIsPresent, "AccountRepository - login() method missing @Query annotation.");
	}
	
	@Test
	void accountRepositoryRegisterAccountMethodAnnotationsTest () throws SecurityException {
		Class<AccountRepository> ar = AccountRepository.class;
		Method m;
		boolean annotationIsPresent = false;
		
		try {
			m = ar.getDeclaredMethod("registerAccount", String.class, String.class);
			for (Annotation an : m.getDeclaredAnnotations()) {
				if (an instanceof Query) annotationIsPresent = true;
			}
		} catch (NoSuchMethodException e) {
			fail("registerAccount() method not found in AccountRepository interface. Review your method spelling and parameter list. Refer back to your instructions for more details.");
		}
		
		assertTrue(annotationIsPresent, "AccountRepository - registerAccount() method missing @Query annotation.");
	}
	
	/* ACCOUNT SERVICE CLASS */
	@Test
	void accountServiceClassAnnotationsTest() {
		Class<AccountService> as = AccountService.class;
		assertTrue(as.isAnnotationPresent(Service.class), "@Service annotation is missing from Account Repository interface");
	}
	
	/* MESSAGE REPOSITORY INTERFACE */
	@Test
	void messageRespositoryInterfaceAnnotationsTest() {
		Class<MessageRepository> mr = MessageRepository.class;
		assertTrue(mr.isAnnotationPresent(Repository.class), "@Repository annotation is missing from Message Repository interface");
	}
	
	@Test
	void messageRepositoryNewMessageMethodAnnotationsTest () throws SecurityException {
		Class<MessageRepository> mr = MessageRepository.class;
		Method m;
		boolean annotationIsPresent = false;
		
		try {
			m = mr.getDeclaredMethod("newMessage", int.class, String.class, long.class);
			for (Annotation an : m.getDeclaredAnnotations()) {
				if (an instanceof Query) annotationIsPresent = true;
			}
		} catch (NoSuchMethodException e) {
			fail("newMessage() method not found in MessageRepository interface. Review your method spelling and parameter list. Refer back to your instructions for more details.");
		}
		
		assertTrue(annotationIsPresent, "MessageRepository - newMessage() method is missing @Query annotation.");
	}
	
	@Test
	void messageRepositoryGetAllMessagesMethodAnnotationsTest () throws SecurityException {
		Class<MessageRepository> mr = MessageRepository.class;
		Method m;
		boolean annotationIsPresent = false;
		
		try {
			m = mr.getDeclaredMethod("getAllMessages");
			for (Annotation an : m.getDeclaredAnnotations()) {
				if (an instanceof Query) annotationIsPresent = true;
			}
		} catch (NoSuchMethodException e) {
			fail("getAllMessages() method not found in MessageRepository interface. Review your method spelling and parameter list. Refer back to your instructions for more details.");
		}
		
		assertTrue(annotationIsPresent, "MessageRepository - getAllMessages() method is missing @Query annotation.");
	}
	
	@Test
	void messageRepositoryGetMessageByIDMethodAnnotationsTest () throws SecurityException {
		Class<MessageRepository> mr = MessageRepository.class;
		Method m;
		boolean annotationIsPresent = false;
		
		try {
			m = mr.getDeclaredMethod("getMessageByID", int.class);
			for (Annotation an : m.getDeclaredAnnotations()) {
				if (an instanceof Query) annotationIsPresent = true;
			}
		} catch (NoSuchMethodException e) {
			fail("getMessageByID() method not found in MessageRepository interface. Review your method spelling and parameter list. Refer back to your instructions for more details.");
		}
		
		assertTrue(annotationIsPresent, "MessageRepository - getMessageByID() method is missing @Query annotation.");
	}
	
	@Test
	void messageRepositoryGetMessageByAccountMethodAnnotationsTest () throws SecurityException {
		Class<MessageRepository> mr = MessageRepository.class;
		Method m;
		boolean annotationIsPresent = false;
		
		try {
			m = mr.getDeclaredMethod("getMessageByAccount", int.class);
			for (Annotation an : m.getDeclaredAnnotations()) {
				if (an instanceof Query) annotationIsPresent = true;
			}
		} catch (NoSuchMethodException e) {
			fail("getMessageByAccount() method not found in MessageRepository interface. Review your method spelling and parameter list. Refer back to your instructions for more details.");
		}
		
		assertTrue(annotationIsPresent, "MessageRepository - getMessageByAccount() method is missing @Query annotation.");
	}
	
	@Test
	void messageRepositoryUpdateMessageByAccountMethodAnnotationsTest () throws SecurityException {
		Class<MessageRepository> mr = MessageRepository.class;
		Method m;
		boolean annotationIsPresent = false;
		
		try {
			m = mr.getDeclaredMethod("updateMessage", String.class, int.class);
			for (Annotation an : m.getDeclaredAnnotations()) {
				if (an instanceof Query) annotationIsPresent = true;
			}
		} catch (NoSuchMethodException e) {
			fail("updateMessage() method not found in MessageRepository interface. Review your method spelling and parameter list. Refer back to your instructions for more details.");
		}
		
		assertTrue(annotationIsPresent, "MessageRepository - updateMessage() method is missing @Query annotation.");
	}
	
	@Test
	void messageRepositoryDeleteMessageByAccountMethodAnnotationsTest () throws SecurityException {
		Class<MessageRepository> mr = MessageRepository.class;
		Method m;
		boolean annotationIsPresent = false;
		
		try {
			m = mr.getDeclaredMethod("deleteMessage", int.class);
			for (Annotation an : m.getDeclaredAnnotations()) {
				if (an instanceof Query) annotationIsPresent = true;
			}
		} catch (NoSuchMethodException e) {
			fail("deleteMessage() method not found in MessageRepository interface. Review your method spelling and parameter list. Refer back to your instructions for more details.");
		}
		
		assertTrue(annotationIsPresent, "MessageRepository - deleteMessage() method is missing @Query annotation.");
	}
	
	/* MESSAGE REPOSITORY INTERFACE */
	@Test
	void messageServiceClassAnnotationsTest() {
		Class<MessageService> ms = MessageService.class;
		assertTrue(ms.isAnnotationPresent(Service.class), "@Service annotation is missing from Message Service interface");
	}
}
