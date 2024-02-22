package my.websocket.chat.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import my.websocket.chat.model.ChatMessage;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author Dmitry Stepanov, user Dmitry
 * @since 22.02.2024
 */
@Controller
@RequiredArgsConstructor
@Slf4j
public class ChatController {
    private final SimpMessagingTemplate template;

    @GetMapping("/")
    public String indexPage() {
        return "index";
    }

    @MessageMapping("/send_message")
    public void messageReceiver(@Payload ChatMessage chatMessage) {
        log.info("New message: " + chatMessage);
        template.convertAndSendToUser(chatMessage.getReceiver(), "/chat_out/receive_message", chatMessage);
    }
}
