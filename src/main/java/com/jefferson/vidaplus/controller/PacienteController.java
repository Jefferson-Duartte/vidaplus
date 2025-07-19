package com.jefferson.vidaplus.controller;

import com.jefferson.vidaplus.dto.request.PacienteRequest;
import com.jefferson.vidaplus.dto.response.PacienteResponse;
import com.jefferson.vidaplus.service.PacienteService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/paciente")
public class PacienteController {

    private final PacienteService service;

    public PacienteController(PacienteService service) {
        this.service = service;
    }

//    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
//    @Operation(summary = "Buscar todos os pacientes",
//            description = "Buscar todos os pacientes",
//            tags = {"Pacientes"},
//            responses = {
//                    @ApiResponse(
//                            description = "Success",
//                            responseCode = "200",
//                            content = {
//                                    @Content(
//                                            mediaType = MediaType.APPLICATION_JSON_VALUE,
//                                            array = @ArraySchema(schema = @Schema(implementation = PacienteResponse.class))
//                                    )
//                            }),
//                    @ApiResponse(description = "No Content", responseCode = "204", content = @Content),
//                    @ApiResponse(description = "BadRequest", responseCode = "400", content = @Content),
//                    @ApiResponse(description = "Unauthorized", responseCode = "401", content = @Content),
//                    @ApiResponse(description = "Not Found", responseCode = "404", content = @Content),
//                    @ApiResponse(description = "Internal Server Error", responseCode = "500", content = @Content)
//            }
//    )
//    public ResponseEntity<List<PacienteResponse>> findAll() {
//        return ResponseEntity.ok(service.findAll());
//    }

    @Operation(summary = "Procurar um Paciente",
            description = "Procurar um Paciente especifico",
            tags = {"Paciente"},
            responses = {
                    @ApiResponse(
                            description = "Success",
                            responseCode = "200",
                            content = @Content(schema = @Schema(implementation = PacienteResponse.class))),
                    @ApiResponse(description = "No Content", responseCode = "204", content = @Content),
                    @ApiResponse(description = "BadRequest", responseCode = "400", content = @Content),
                    @ApiResponse(description = "Unauthorized", responseCode = "401", content = @Content),
                    @ApiResponse(description = "Not Found", responseCode = "404", content = @Content),
                    @ApiResponse(description = "Internal Server Error", responseCode = "500", content = @Content)
            }
    )
    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<PacienteResponse> findById(@PathVariable("id") Long id) {
        return ResponseEntity.ok(service.findById(id));
    }

    @Operation(summary = "Creates a Person",
            description = "Create a person",
            tags = {"Person"},
            responses = {
                    @ApiResponse(
                            description = "Success",
                            responseCode = "200",
                            content = @Content(schema = @Schema(implementation = PacienteResponse.class))),
                    @ApiResponse(description = "No Content", responseCode = "204", content = @Content),
                    @ApiResponse(description = "Bad Request", responseCode = "400", content = @Content),
                    @ApiResponse(description = "Unauthorized", responseCode = "401", content = @Content),
                    @ApiResponse(description = "Not Found", responseCode = "404", content = @Content),
                    @ApiResponse(description = "Internal Server Error", responseCode = "500", content = @Content)
            }
    )
    @PostMapping(produces = {MediaType.APPLICATION_JSON_VALUE,
            MediaType.APPLICATION_XML_VALUE,
            MediaType.APPLICATION_YAML_VALUE},
            consumes = {MediaType.APPLICATION_JSON_VALUE,
                    MediaType.APPLICATION_XML_VALUE,
                    MediaType.APPLICATION_YAML_VALUE})
    public ResponseEntity<PacienteResponse> create(@RequestBody PacienteRequest pacienteDTO) {
        return ResponseEntity.ok().body(service.create(pacienteDTO));
    }

//    @Operation(summary = "Updates a Person",
//            description = "Update a person",
//            tags = {"Person"},
//            responses = {
//                    @ApiResponse(
//                            description = "Success",
//                            responseCode = "200",
//                            content = @Content(schema = @Schema(implementation = PacienteResponse.class))),
//                    @ApiResponse(description = "No Content", responseCode = "204", content = @Content),
//                    @ApiResponse(description = "Bad Request", responseCode = "400", content = @Content),
//                    @ApiResponse(description = "Unauthorized", responseCode = "401", content = @Content),
//                    @ApiResponse(description = "Not Found", responseCode = "404", content = @Content),
//                    @ApiResponse(description = "Internal Server Error", responseCode = "500", content = @Content)
//            }
//    )

//    @PutMapping(value = "/{id}", produces = {
//            MediaType.APPLICATION_JSON_VALUE,
//            MediaType.APPLICATION_XML_VALUE,
//            MediaType.APPLICATION_YAML_VALUE},
//            consumes = {MediaType.APPLICATION_JSON_VALUE,
//                    MediaType.APPLICATION_XML_VALUE,
//                    MediaType.APPLICATION_YAML_VALUE})
//    public ResponseEntity<EntityModel<PacienteResponse>> update(@PathVariable Long id, @RequestBody PersonRequestDTO personDTO) {
//        return ResponseEntity.ok().body(assembler.toModel(personService.update(id, personDTO)));
//    }
//
//    @Operation(summary = "Delete a Person",
//            description = "Delete a person",
//            tags = {"Person"},
//            responses = {
//                    @ApiResponse(
//                            description = "Success",
//                            responseCode = "200"),
//                    @ApiResponse(description = "No Content", responseCode = "204", content = @Content),
//                    @ApiResponse(description = "Bad Request", responseCode = "400", content = @Content),
//                    @ApiResponse(description = "Unauthorized", responseCode = "401", content = @Content),
//                    @ApiResponse(description = "Not Found", responseCode = "404", content = @Content),
//                    @ApiResponse(description = "Internal Server Error", responseCode = "500", content = @Content)
//            }
//    )
//    @DeleteMapping("/{id}")
//    public ResponseEntity<Void> delete(@PathVariable("id") Long id) {
//        personService.delete(id);
//        return ResponseEntity.noContent().build();
//    }

}
