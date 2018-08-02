package com.login.demo.Dao;
import com.login.demo.modelo.Rol;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RepositorioRol extends JpaRepository<Rol, Long> {

	@SuppressWarnings("unchecked")
	Rol save(Rol rol);
}
