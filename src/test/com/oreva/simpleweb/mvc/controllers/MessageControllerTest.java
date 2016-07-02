package com.oreva.simpleweb.mvc.controllers;

import com.oreva.simpleweb.mvc.repositories.MessageRepository;
import com.oreva.simpleweb.mvc.services.MessageService;
import org.junit.Test;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.mockito.Mockito.mock;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.redirectedUrl;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.standaloneSetup;

/**
 * Created with IntelliJ IDEA.
 * User: Olga
 * Date: 3/20/16
 * Time: 4:50 PM
 * To change this template use File | Settings | File Templates.
 */
public class MessageControllerTest {
    @Test
    public void testStoreMessage() throws Exception {
        MessageService service = mock(MessageService.class);
        MessageController controller = mock(MessageController.class);

        MockMvc mockMvc = standaloneSetup(controller).build();
        mockMvc.perform(MockMvcRequestBuilders.get("/messages?new=")).
                andExpect(view().name("messages/edit"));
    }

    @Test
    public void testAddMessageFromForm() throws Exception {
        MessageService service = mock(MessageService.class);
        MessageController controller = mock(MessageController.class);

        MockMvc mockMvc = standaloneSetup(controller).build();
        mockMvc.perform(MockMvcRequestBuilders.post("/messages?new=")).
                andExpect(redirectedUrl("messages/result"));
    }
}
