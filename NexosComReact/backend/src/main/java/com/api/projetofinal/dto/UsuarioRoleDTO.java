package com.api.projetofinal.dto;

import java.util.List;
import java.util.UUID;

import lombok.Data;

@Data
public class UsuarioRoleDTO {

    private UUID idUsuarios;

    private List<UUID> idsRoles;

}