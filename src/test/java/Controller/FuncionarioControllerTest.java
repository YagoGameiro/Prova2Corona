package Controller;


import Aula7.MyApplication;
import Aula7.model.Funcionario;
import Aula7.service.FuncionarioService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = MyApplication.class)
@WebAppConfiguration
public class FuncionarioControllerTest {

    @Autowired
    private FuncionarioService funcionarioService;

    @Test
    public void save() throws Exception {

        long qtd = 30;

        funcionarioService.deleteAll();

        for ( int i = 1 ; i <= qtd ; i++){
            funcionarioService.sendFuncionarioRabbit(new Funcionario("teste"+i));
        }

        Thread.sleep(5000);
        List<Funcionario> lst = funcionarioService.findAll();

        System.out.println("Qtd:" + lst.size());
        Assert.assertEquals(lst.size(), qtd);
    }

}