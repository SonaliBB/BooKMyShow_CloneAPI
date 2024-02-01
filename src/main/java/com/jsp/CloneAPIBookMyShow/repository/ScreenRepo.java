package com.jsp.CloneAPIBookMyShow.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jsp.CloneAPIBookMyShow.entity.Screen;

public interface ScreenRepo extends JpaRepository<Screen,Long>{

	Optional<Screen> findById(long screenId);

}
