package br.senai.appjmsspring.consumer;

import br.senai.appjmsspring.entity.MessageEntity;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

@Component
public class Consumer {

    @JmsListener(destination = "fila-spring")
    public void messageListener(MessageEntity message) {
        System.out.println("Mensagem recebida!" + message);
    }
}
