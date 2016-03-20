package com.oreva.simpleweb.mvc.controllers;

import com.oreva.simpleweb.mvc.dao.MessageDAO;
import com.oreva.simpleweb.mvc.services.MessageService;
import org.junit.Test;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.mockito.Mockito.mock;
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
        MessageService service = new MessageService(mock(MessageDAO.class));
        MessageController controller = new MessageController(service);

        MockMvc mockMvc = standaloneSetup(controller).build();
        mockMvc.perform(MockMvcRequestBuilders.get("/messages?new=")).
                andExpect(view().name("messages/edit"));
    }

    @Test
    public void testAddMessageFromForm() throws Exception {
        MessageService service = new MessageService(mock(MessageDAO.class));
        MessageController controller = new MessageController(service);

        MockMvc mockMvc = standaloneSetup(controller).build();
        mockMvc.perform(MockMvcRequestBuilders.post("/messages?new=")).
                andExpect(view().name("redirect:messages/result"));
    }
}
