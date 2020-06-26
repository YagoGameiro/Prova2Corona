package Aula7.rabbit;

import Aula7.model.Cliente;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ClienteProducer {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @Autowired
    private Queue queue2;

    public void send(Cliente cliente){
        rabbitTemplate.convertAndSend(this.queue2.getName(), cliente);
    }
}
