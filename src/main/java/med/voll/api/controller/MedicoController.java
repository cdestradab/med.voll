package med.voll.api.controller;

import jakarta.validation.Valid;
import med.voll.api.medico.DatosListadoMedico;
import med.voll.api.medico.DatosRegistroMedico;
import med.voll.api.medico.Medico;
import med.voll.api.medico.MedicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/medicos")
public class MedicoController {

    //Hacer una anotacion autowired a nivel de una declaración del parámetro
    //ya que será dificil hacer un test, lo ideal sería hacerlo con autowired y setter.
    @Autowired
    private MedicoRepository medicoRepository;
    @PostMapping
    public void registrarMedico(@RequestBody @Valid DatosRegistroMedico datosRegistroMedico){
        medicoRepository.save(new Medico(datosRegistroMedico));
    }

    @GetMapping
    public List<DatosListadoMedico> listadoMedicos(){
        return medicoRepository.findAll().stream().map(DatosListadoMedico::new).toList();
    }
}
