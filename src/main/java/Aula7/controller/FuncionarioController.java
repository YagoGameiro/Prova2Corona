package Aula7.controller;

import Aula7.model.Funcionario;
import Aula7.constant.Constants;
import Aula7.service.FuncionarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
public class FuncionarioController {

    @Autowired
    private FuncionarioService funcionarioService;

    @PostMapping(Constants.API_FUNCIONARIO)
    public Funcionario save(@RequestBody Funcionario funcionario){
        return funcionarioService.save(funcionario);
    }

    @GetMapping(Constants.API_FUNCIONARIO)
    public List<Funcionario> findAll(){
        return funcionarioService.findAll();
    }

    @PutMapping(Constants.API_FUNCIONARIO)
    public void update(@RequestBody Funcionario funcionario){
        funcionarioService.save(funcionario);
    }

    @DeleteMapping(Constants.API_FUNCIONARIO + "/{id}")
    public void delete(@PathVariable("id") String id){
        funcionarioService.delete(id);
    }

    @GetMapping(Constants.API_FUNCIONARIO + "/{id}")
    public Optional<Funcionario> findById(@PathVariable("id") String id){
        return funcionarioService.findById(id);
    }
}

