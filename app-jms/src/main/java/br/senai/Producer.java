package br.senai;

import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.*;

public class Producer {
    public static void main(String[] args) {
        ConnectionFactory factory = new ActiveMQConnectionFactory("admin", "admin", "tcp://localhost:61616");

        try {
            Connection connection = factory.createConnection();
            Session session = connection.createSession(false, Session.CLIENT_ACKNOWLEDGE);
            Destination destination = session.createQueue("fila");

            String[] messages = {
                    "Primeira mensagem",
                    "segunda",
                    "help"
            };

            MessageProducer producer = session.createProducer(destination);

            for (String message : messages) {
                TextMessage textMessage = session.createTextMessage(message);
                producer.send(textMessage);
            }

            System.out.println("Mensagem publicada!");

        } catch (JMSException e) {
            e.printStackTrace();
        }
    }

}
