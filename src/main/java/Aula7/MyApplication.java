package Aula7;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class MyApplication {
    @Value("${queue.funcionario.name}")
    private String funcionarioQueue;
    @Value("${queue2.cliente.name}")
    private String clienteQueue;

    public static void main(String[] args) {
        SpringApplication.run(MyApplication.class, args);
    }

    @Bean
    public Queue queue(){
        return new Queue(funcionarioQueue, true);
    }

    @Bean
    public Queue queue2(){
        return new Queue(clienteQueue, true);
    }
}