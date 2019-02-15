package com.airbus.alten.cacau.service;

import java.util.List;

import com.airbus.alten.cacau.model.HLDocument;
import com.airbus.alten.cacau.model.Reference;
import com.airbus.alten.cacau.model.Release;
import com.airbus.alten.cacau.model.UseCaseConfiguration;

public interface ManageUserInfoService {

	public void saveReference(Reference reference, UseCaseConfiguration useCaseConfiguration);
	
	public void saveRelease(Release release, UseCaseConfiguration useCaseConfiguration);
	
	public void saveHLDocument(HLDocument hlDocument, UseCaseConfiguration useCaseConfiguration);
	
	public void saveReferences(List<Reference> reference);
	
	public void saveReleases(List<Release> release);
	
	public void saveHLDocuments(List<HLDocument> hlDocument);
	
	public void deleteReference(Reference reference);
	
	public void deleteRelease(Release release);
	
	public void deleteHLDocument(HLDocument hlDocument);
	
}
