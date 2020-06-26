package Aula7.service;

import Aula7.model.Funcionario;
import Aula7.rabbit.FuncionarioProducer;
import Aula7.repository.FuncionarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FuncionarioService {

    @Autowired
    private FuncionarioRepository funcionarioRepository;

    @Autowired
    private FuncionarioProducer funcionarioProducer;

    public void sendFuncionarioRabbit(Funcionario funcionario){
        funcionarioProducer.send(funcionario);
    }

    public Funcionario save(Funcionario funcionario){
        return funcionarioRepository.save(funcionario);
    }
    public List<Funcionario> findAll(){
        return funcionarioRepository.findAll();
    }
    public Optional<Funcionario> findById(String id){
        return funcionarioRepository.findById(id);
    }
    public void delete(String id){
        funcionarioRepository.deleteById(id);
    }

    public void deleteAll(){
        funcionarioRepository.deleteAll();
    }
}
