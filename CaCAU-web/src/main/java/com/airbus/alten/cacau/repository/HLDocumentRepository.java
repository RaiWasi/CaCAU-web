package com.airbus.alten.cacau.repository;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.airbus.alten.cacau.model.HLDocument;
import com.airbus.alten.cacau.model.UseCaseConfiguration;

public interface HLDocumentRepository extends JpaRepository<HLDocument, Long> {

	@Transactional
	public HLDocument findByUseCaseConfiguration(UseCaseConfiguration useCaseConfiguration);
}
