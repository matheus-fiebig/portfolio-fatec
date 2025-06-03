package br.gov.sp.cps.api.pixel.inbound.rest;

import br.gov.sp.cps.api.pixel.core.domain.dto.FazendaDTO;
import br.gov.sp.cps.api.pixel.core.domain.dto.command.CadastrarFazendaCommand;
import br.gov.sp.cps.api.pixel.core.usecase.CadastrarFazendaUC;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("/api/fazendas")
@RequiredArgsConstructor
@CrossOrigin(origins = "*")
public class FazendaController {

    private final CadastrarFazendaUC cadastrarFazendaUC;

    @PostMapping
    public ResponseEntity<FazendaDTO> cadastrarFazenda(@RequestBody CadastrarFazendaCommand command){
        FazendaDTO fazenda = cadastrarFazendaUC.executar(command);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(fazenda.id())
                .toUri();
        return ResponseEntity.created(location).body(fazenda);
    }
}
