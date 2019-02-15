package com.airbus.alten.cacau.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.airbus.alten.cacau.model.HLDocument;
import com.airbus.alten.cacau.model.Reference;
import com.airbus.alten.cacau.model.Release;
import com.airbus.alten.cacau.model.UseCaseConfiguration;
import com.airbus.alten.cacau.repository.HLDocumentRepository;
import com.airbus.alten.cacau.repository.ReferenceRepository;
import com.airbus.alten.cacau.repository.ReleaseRepository;
import com.airbus.alten.cacau.service.ManageUserInfoService;

@Service
public class ManageUserInfoServiceImpl implements ManageUserInfoService{

	@Autowired
	private ReferenceRepository referenceRepository;
	
	@Autowired
	private ReleaseRepository releaseRepository;
	
	@Autowired
	private HLDocumentRepository hlDocumentRepository;
	
	
	@Override
	public void saveReference(Reference reference, UseCaseConfiguration useCaseConfiguration) {
		
		Reference referenceSearch = referenceRepository.findByUseCaseConfiguration(useCaseConfiguration);
		reference.setUseCaseConfiguration(useCaseConfiguration);
		
		if(referenceSearch == null){
			referenceRepository.save(reference);			
		}
		else{
			reference.setId(referenceSearch.getId());
			referenceRepository.save(reference);
		}		
	}

	@Override
	public void saveRelease(Release release, UseCaseConfiguration useCaseConfiguration) {
		
		Release releaseSearch = releaseRepository.findByUseCaseConfiguration(useCaseConfiguration);
		release.setUseCaseConfiguration(useCaseConfiguration);
		
		if(releaseSearch == null){
			releaseRepository.save(release);			
		}
		else{
			release.setId(releaseSearch.getId());
			releaseRepository.save(release);
		}	
	}

	@Override
	public void saveHLDocument(HLDocument hlDocument, UseCaseConfiguration useCaseConfiguration) {
		
		HLDocument hlDocumentSearch = hlDocumentRepository.findByUseCaseConfiguration(useCaseConfiguration);
		hlDocument.setUseCaseConfiguration(useCaseConfiguration);
		
		if(hlDocumentSearch == null){
			hlDocumentRepository.save(hlDocument);			
		}
		else{
			hlDocument.setId(hlDocumentSearch.getId());
			hlDocumentRepository.save(hlDocument);
		}	
	}

	@Override
	public void saveReferences(List<Reference> reference) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void saveReleases(List<Release> release) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void saveHLDocuments(List<HLDocument> hlDocument) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteReference(Reference reference) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteRelease(Release release) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteHLDocument(HLDocument hlDocument) {
		// TODO Auto-generated method stub
		
	}

}
