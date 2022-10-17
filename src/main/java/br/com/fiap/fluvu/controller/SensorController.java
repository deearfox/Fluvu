package br.com.fiap.fluvu.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;


import br.com.fiap.fluvu.model.SensorBoeiro;
import br.com.fiap.fluvu.repository.SensorRepository;
import lombok.AllArgsConstructor;


@RestController
@RequestMapping("/api/sensores")
@AllArgsConstructor
public class SensorController {

    @Autowired
    private final SensorRepository SensorRepository;

    @GetMapping
    public List<SensorBoeiro> list() {
        
		var listaSensor  = SensorRepository.findAll();

		for(int i = 0; i < listaSensor.size(); i++)
		{
			volumetria(listaSensor.get(i));
		}
		
		return listaSensor;
    }

    @GetMapping("{id}")
	public SensorBoeiro buscar(@PathVariable Long id) {
		return volumetria (SensorRepository.findById(id).get());
	}

    @ResponseStatus(code = HttpStatus.CREATED)
	@PostMapping
	public SensorBoeiro cadastrar(@RequestBody SensorBoeiro sensorBoeiro) {
		return volumetria (SensorRepository.save(sensorBoeiro));
	}

    @PutMapping("{id}")
	public SensorBoeiro atualizar(@RequestBody SensorBoeiro sensorBoeiro, @PathVariable long id) {
		sensorBoeiro.setId(id);
		return volumetria(SensorRepository.save(sensorBoeiro));
	}

    @DeleteMapping("{id}")
	public void remover(@PathVariable long id) {
		SensorRepository.deleteById(id);
	}


	public SensorBoeiro volumetria(SensorBoeiro sensorBoeiro) {
		
		if (sensorBoeiro.volume <= 25) {
		  sensorBoeiro.status = "Normal";
		  sensorBoeiro.alerta = "NÃO";
		
		}
		if (sensorBoeiro.volume >= 26 && sensorBoeiro.volume <= 50) {
		  sensorBoeiro.status = "Moderado";
		  sensorBoeiro.alerta = "NÃO";
	
		}
		if (sensorBoeiro.volume >= 51 && sensorBoeiro.volume <= 75) {
		  sensorBoeiro.status = "Atenção";
		  sensorBoeiro.alerta = "SIM";
	
		}
		if (sensorBoeiro.volume >= 76) {
		  sensorBoeiro.status = "Crítico";
		  sensorBoeiro.alerta = "SIM";
		
		}

		return sensorBoeiro;
	  }

}
