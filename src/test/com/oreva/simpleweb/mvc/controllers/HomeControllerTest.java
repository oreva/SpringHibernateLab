package com.oreva.simpleweb.mvc.controllers;

import com.oreva.simpleweb.mvc.controllers.HomeController;
import com.oreva.simpleweb.mvc.services.MessageService;
import org.junit.Test;
import org.mockito.Mock;
import org.springframework.ui.Model;

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
        HomeController homeController = new HomeController();
        String viewName = homeController.showHomePage(mock(Model.class));

        assertEquals(viewName, "home");
    }


    //Question 2
    // We can use Mockito library to mock DB call
    /*@Test
    public void testShowHomePage() throws Exception {
        ComplexObject object = mock(ComplexObject.class);
        Object resultMock = new Object();
        // Mock our complex method to callDB and return resultMock as a result
        when(object.accessDB()).thenReturn(resultMock);
        // Other method of our object we can call as it is without mocking
        when(object.otherMethod()).thenCallRealMethod();
    }*/
}
