package my.websocket.chat.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

/**
 * @author Dmitry Stepanov, user Dmitry
 * @since 22.02.2024
 */
@Data
@AllArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class ChatMessage {
    private String sender;
    private String receiver;
    private String message;

    private LocalDateTime localDateTime;

    public ChatMessage() {
        this.localDateTime = LocalDateTime.now().truncatedTo(ChronoUnit.SECONDS);
    }

    public ChatMessage(String sender, String receiver, String message) {
        this.sender = sender;
        this.receiver = receiver;
        this.message = message;
    }
}

