package com.oreva.simpleweb.mvc.controllers;

import com.oreva.simpleweb.mvc.controllers.HomeController;
import com.oreva.simpleweb.mvc.services.MessageService;
import org.junit.Test;

import java.lang.Exception;
import java.lang.String;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;

/**
 * Created with IntelliJ IDEA.
 * User: Olga
 * Date: 1/18/16
 * Time: 5:18 PM
 * To change this template use File | Settings | File Templates.
 */
public class HomeControllerTest {
    @Test
    public void testShowHomePage() throws Exception {
        MessageService messageService = mock(MessageService.class);
        HomeController homeController = new HomeController(messageService);
        String viewName = homeController.showHomePage();

        assertEquals(viewName, "home");
    }
}
