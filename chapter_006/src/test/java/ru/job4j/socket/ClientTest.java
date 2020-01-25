package ru.job4j.socket;

import com.google.common.base.Joiner;
import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintStream;
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
 * @since 25.01.2020
 */
public class ClientTest {

    private static final String LN = System.getProperty("line.separator");

    @Test
    public void whenAskExitThenAnswerExit() throws IOException {
        testClient("exit", "exit", "exit\r\n");
    }

        @Test
    public void whenAskAnswerThenChooseRandom() throws IOException {
        testClient(
                Joiner.on(LN).join("hello", LN, "exit"),
                Joiner.on(LN).join("hello", "exit"),
                Joiner.on(LN).join("hello", "exit", ""));
    }

    public void testClient(String input, String answer, String expected) throws IOException {
        Socket socket = mock(Socket.class);
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        ByteArrayInputStream in = new ByteArrayInputStream(
                input.getBytes()
        );
        ByteArrayInputStream inAnswer = new ByteArrayInputStream(
                answer.getBytes()
        );
        System.setIn(inAnswer);
        when(socket.getInputStream()).thenReturn(in);
        when(socket.getOutputStream()).thenReturn(out);
        Client client = new Client(socket);
        client.start();
        assertThat(out.toString(), is(expected));
    }
}
