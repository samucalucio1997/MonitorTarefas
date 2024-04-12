package com.tarefa.monitor.service;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.tarefa.monitor.config.UploadFiles;
import com.tarefa.monitor.model.Usuario;
import com.tarefa.monitor.repository.UsuarioRepository;
@Service
public class UsuarioService implements UserDetailsService{
    
    private final Path caminho;
    
    


    public UsuarioService(UploadFiles ref) {
        this.caminho = Paths.get(ref.getUploadDir())
        .toAbsolutePath().normalize();;
    }

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        // TODO Auto-generated method stub
        return this.usuarioRepository.findByNome(username);
    }

    public Usuario CriarUsuario(Usuario usuario, MultipartFile file) throws IllegalStateException, IOException{
        if (file!=null) {
            String path = file.getOriginalFilename();
            Path caminho = this.caminho.resolve(path)
            .toAbsolutePath().normalize();
            file.transferTo(caminho);
            usuario.setImg_perfil(path);
        }
        usuario.setSenha(new BCryptPasswordEncoder().encode(usuario.getSenha()));
        return this.usuarioRepository.save(usuario);
    }

    public Usuario PegarporId(UUID id){
        return this.usuarioRepository.findById(id).get();
    }

}
