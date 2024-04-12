package com.tarefa.monitor.controller;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.tarefa.monitor.DTO.UsuarioRequestDTO;
import com.tarefa.monitor.DTO.UsuarioResponseDTO;
import com.tarefa.monitor.config.UploadFiles;
import com.tarefa.monitor.model.Usuario;
import com.tarefa.monitor.security.TokenUtil;
import com.tarefa.monitor.service.CadastraAdmin;
import com.tarefa.monitor.service.UsuarioService;

@RestController
@RequestMapping("/usuario")
public class UsuarioController {

    @Autowired
    private AuthenticationManager authenticationManager;
    

    private final Path caminho;

    

    public UsuarioController(UploadFiles diretorio) {
       this.caminho = Paths.get(diretorio.getUploadDir()).toAbsolutePath();
    }

    @Autowired
    private UsuarioService usuarioService;
   
    @PostMapping(value = "/login", consumes = "application/json")
    public ResponseEntity<UsuarioResponseDTO> login(@RequestBody UsuarioRequestDTO user){
       try {
           UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken = 
          new UsernamePasswordAuthenticationToken(user.getUsername(), user.getPassword());
          Authentication auth = this.authenticationManager.authenticate(usernamePasswordAuthenticationToken);
          var usuario = (Usuario) auth.getPrincipal();
          UsuarioResponseDTO usuarioResponseDTO = new UsuarioResponseDTO();
          usuarioResponseDTO.setToken(TokenUtil.encode(usuario));
          usuarioResponseDTO.setUsuario(usuario);
          return ResponseEntity.status(200).body(usuarioResponseDTO);
       } catch (Exception e) {
        return ResponseEntity.badRequest().build();
       }
    }
    
    @PostMapping("/criarUser")
    public ResponseEntity<Usuario> CriarUsuario(@RequestBody Usuario usuario,@RequestParam(value = "imagem",required = false) MultipartFile file
    ,@RequestParam(value = "cod_Admin",required = false) Integer cod){
        try {
            if (cod!=null) {
                usuario.setAdmin(CadastraAdmin.Verify(cod));
            } 
            var user = this.usuarioService.CriarUsuario(usuario, file);
            return ResponseEntity.status(200).body(user); 
        } catch (Exception e) {
            // TODO: handle exception
            return ResponseEntity.badRequest().build();
        }
    }

    @GetMapping("/image")
    public ResponseEntity<byte[]> PegarImagem(@RequestParam("id") UUID id){
        try {
            Usuario usuario = this.usuarioService.PegarporId(id);
            Path path = this.caminho.resolve(usuario.getImg_perfil()).toAbsolutePath();
            return ResponseEntity.status(200).body(Files.readAllBytes(path));
        } catch (Exception e) {
            // TODO: handle exception
            return ResponseEntity.badRequest().build();
        }
    }
   
}
