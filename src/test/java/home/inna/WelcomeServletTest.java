package home.inna;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletResponseWrapper;

import java.io.PrintWriter;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class WelcomeServletTest {

    @Mock
    private HttpServletResponse response;

    @Test
    public void testDoGet() throws Exception {
        WelcomeServlet welcomeServlet = new WelcomeServlet();

        PrintWriter writer = mock(PrintWriter.class);
        when(response.getWriter()).thenReturn(writer);

        welcomeServlet.doGet(null, response);

        ArgumentCaptor<String> captor = ArgumentCaptor.forClass(String.class);
        verify(writer).print(captor.capture());
        String value = captor.getValue();
        assertEquals("Welcome to Earthquake-task application!", value);
    }
}