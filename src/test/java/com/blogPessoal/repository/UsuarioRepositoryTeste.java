package com.blogPessoal.repository;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;

import com.blogPessoal.model.Usuario;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class UsuarioRepositoryTeste {

	@Autowired
	private UsuarioRepository usuarioRepository;

	@BeforeAll
	void start() {
		usuarioRepository.deleteAll();

		usuarioRepository.save(new Usuario(0L, "João Silva", "joao@email.com", "12335", ""));

		usuarioRepository.save(new Usuario(0L, "Manuel Silva", "manuel@email.com", "1233345", ""));

		usuarioRepository.save(new Usuario(0L, "Adriana Silva", "adriana@email.com", "1233556", ""));

		usuarioRepository.save(new Usuario(0L, "Paulo Silva", "paulo@email.com", "1233578", ""));

	}

	@Test
	@DisplayName("Retorna 1 usuario")
	public void deveRetornarUmUsuario() {

		Optional<Usuario> usuario = usuarioRepository.findByUsuario("joao@email.com");
		assertTrue(usuario.get().getUsuario().equals("joao@email.com"));
	}

	@Test
	@DisplayName("Retorna 3 Usuarios")
	public void deveRetornarTresUsuarios() {
		List<Usuario> listaDeUsuarios = usuarioRepository.findAllByNomeContainingIgnoreCase("Silva");
		assertEquals(3, listaDeUsuarios.size());
		assertTrue(listaDeUsuarios.get(0).getNome().equals("Joao Silva"));
		assertTrue(listaDeUsuarios.get(1).getNome().equals("Manuela Silva"));
		assertTrue(listaDeUsuarios.get(2).getNome().equals("Adriana Silva"));
	}

	@AfterAll
	public void end() {
		usuarioRepository.deleteAll();
	}

}
