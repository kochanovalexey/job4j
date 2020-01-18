package ru.job4j.socket;

import com.google.common.base.Joiner;
import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.net.Socket;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 * Class Класс
 *
 * @author akochanov
 * @version 1
 * @since 20.01.2020
 */
public class ServerTest {
    private static final String LN = System.getProperty("line.separator");

    @Test
    public void whenAskAnswerThenChooseRandom() throws IOException {
        testServer("exit", "");
    }

    @Test
    public void whenAskHelloThenBackGreatOracle() throws IOException {
        testServer(
                Joiner.on(LN).join("hello", "exit"),
                Joiner.on(LN).join("Hello, dear friend, I'm a oracle.", "", ""));
    }

    @Test
    public void whenUnsupportedAskThenDontUnderstand() throws IOException {
        testServer(
                Joiner.on(LN).join("unsupported ask", "exit"),
                Joiner.on(LN).join("Sorry, I don`t understand you.", "", "")
        );
    }

    public void testServer(String input, String expected) throws IOException {
        Socket socket = mock(Socket.class);
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        ByteArrayInputStream in = new ByteArrayInputStream(
                input.getBytes()
        );
        when(socket.getInputStream()).thenReturn(in);
        when(socket.getOutputStream()).thenReturn(out);
        Server server = new Server(socket);
        server.start();
        assertThat(out.toString(), is(expected)
        );
    }
}
