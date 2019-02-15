package com.airbus.alten.cacau.logic;

public class SearchLogicEngine {

	private boolean nameIsNull;
	private boolean descriptionIsNull;
	private boolean labelIsNull;
	private boolean emitterIsNull;
	private boolean sourceIsNull;
	private EnumSearchLogic searchLogic;
	private ParameterToSearch parameterToSearch;
	
	public SearchLogicEngine() {
		this.nameIsNull = true;
		this.descriptionIsNull = true;
		this.labelIsNull = true;
		this.emitterIsNull = true;
		this.sourceIsNull = true;
	}

	public SearchLogicEngine(ParameterToSearch parameterToSearch) {
		
		this.nameIsNull = true;
		this.descriptionIsNull = true;
		this.labelIsNull = true;
		this.emitterIsNull = true;
		this.sourceIsNull = true;
		
    	if(parameterToSearch.getName() != null)
    		this.nameIsNull = false;
    	if(parameterToSearch.getDescription() != null)
    		this.descriptionIsNull = false;
    	if(parameterToSearch.getLabel() != null)
    		this.labelIsNull = false;
    	if(parameterToSearch.getEmitter() != null)
    		this.emitterIsNull = false;
    	if(parameterToSearch.getSource() != null)
    		this.sourceIsNull = false;

		this.parameterToSearch = parameterToSearch;
		generateSearchLogic(this.parameterToSearch);
	}
	
	private void generateSearchLogic(ParameterToSearch parameterToSearch){
		
    	if(parameterToSearch.getName() != null && !parameterToSearch.getName().isEmpty())
    		nameIsNull = false;
    	if(parameterToSearch.getDescription() != null && !parameterToSearch.getDescription().isEmpty())
    		descriptionIsNull = false;
    	if(parameterToSearch.getLabel() != null && !parameterToSearch.getLabel().isEmpty())
    		labelIsNull = false;
    	if(parameterToSearch.getEmitter() != null && !parameterToSearch.getEmitter().isEmpty())
    		emitterIsNull = false;
    	if(parameterToSearch.getSource() != null && !parameterToSearch.getSource().isEmpty())
    		sourceIsNull = false;
    	
    	
    	// Single search logic
    	if(!nameIsNull && descriptionIsNull && labelIsNull && emitterIsNull && sourceIsNull){
    		this.searchLogic = EnumSearchLogic.NAME;
    		return;
    	}
    	else if(nameIsNull && !descriptionIsNull && labelIsNull && emitterIsNull && sourceIsNull){
    		this.searchLogic = EnumSearchLogic.DESCRIPTION;
    		return;
    	}
    	else if(nameIsNull && descriptionIsNull && !labelIsNull && emitterIsNull && sourceIsNull){
    		this.searchLogic = EnumSearchLogic.LABEL;
    		return;
    	}
    	else if(nameIsNull && descriptionIsNull && labelIsNull && !emitterIsNull && sourceIsNull){
    		this.searchLogic = EnumSearchLogic.EMITTER;
    		return;
    	}
    	else if(nameIsNull && descriptionIsNull && labelIsNull && emitterIsNull && !sourceIsNull){
    		this.searchLogic = EnumSearchLogic.SOURCE;
    		return;
    	}
    	
    	
    	// 2X search logic with NAME
    	else if(!nameIsNull && !descriptionIsNull && labelIsNull && emitterIsNull && sourceIsNull){
    		this.searchLogic = EnumSearchLogic.NAME_DESCRIPTION;
    		return;
    	}
    	else if(!nameIsNull && descriptionIsNull && !labelIsNull && emitterIsNull && sourceIsNull){
    		this.searchLogic = EnumSearchLogic.NAME_LABEL;
    		return;
    	}
    	else if(!nameIsNull && descriptionIsNull && labelIsNull && !emitterIsNull && sourceIsNull){
    		this.searchLogic = EnumSearchLogic.NAME_EMITTER;
    		return;
    	}
    	else if(!nameIsNull && descriptionIsNull && labelIsNull && emitterIsNull && !sourceIsNull){
    		this.searchLogic = EnumSearchLogic.NAME_SOURCE;
    	}
    	
    	// 2X search logic with DESCRIPTION
    	else if(nameIsNull && !descriptionIsNull && !labelIsNull && emitterIsNull && sourceIsNull){
    		this.searchLogic = EnumSearchLogic.DESCRIPTION_LABEL;
    	}
    	else if(nameIsNull && !descriptionIsNull && labelIsNull && !emitterIsNull && sourceIsNull){
    		this.searchLogic = EnumSearchLogic.DESCRIPTION_EMITTER;
    	}
    	else if(nameIsNull && !descriptionIsNull && labelIsNull && emitterIsNull && !sourceIsNull){
    		this.searchLogic = EnumSearchLogic.DESCRIPTION_SOURCE;
    	}
    	
    	
    	// 2X search logic with EMITTER
    	else if(nameIsNull && descriptionIsNull && !labelIsNull && !emitterIsNull && sourceIsNull){
    		this.searchLogic = EnumSearchLogic.EMITTER_LABEL;
    	}
    	else if(nameIsNull && descriptionIsNull && labelIsNull && !emitterIsNull && !sourceIsNull){
    		this.searchLogic = EnumSearchLogic.EMITTER_SOURCE;
    	}
    	
    	// 2X search logic with SOURCE
    	else if(nameIsNull && descriptionIsNull && !labelIsNull && emitterIsNull && !sourceIsNull){
    		this.searchLogic = EnumSearchLogic.SOURCE_LABEL;
    	}
    	
    	// 3X search logic with NAME
    	else if(!nameIsNull && !descriptionIsNull && labelIsNull && !emitterIsNull && sourceIsNull){
    		this.searchLogic = EnumSearchLogic.NAME_DESCRIPTION_EMITTER;
    	}
    	else if(!nameIsNull && !descriptionIsNull && labelIsNull && emitterIsNull && !sourceIsNull){
    		this.searchLogic = EnumSearchLogic.NAME_DESCRIPTION_SOURCE;
    	}
    	else if(!nameIsNull && !descriptionIsNull && !labelIsNull && emitterIsNull && sourceIsNull){
    		this.searchLogic = EnumSearchLogic.NAME_DESCRIPTION_LABEL;
    	}
    	
    	// 3X search logic with DESCRIPTION
    	else if(nameIsNull && !descriptionIsNull && labelIsNull && !emitterIsNull && !sourceIsNull){
    		this.searchLogic = EnumSearchLogic.DESCRIPTION_EMITTER_SOURCE;
    	}
    	else if(nameIsNull && !descriptionIsNull && !labelIsNull && !emitterIsNull && sourceIsNull){
    		this.searchLogic = EnumSearchLogic.DESCRIPTION_EMITTER_LABEL;
    	}
    	
    	// 3X search logic with EMITTER
    	else if(nameIsNull && descriptionIsNull && !labelIsNull && !emitterIsNull && !sourceIsNull){
    		this.searchLogic = EnumSearchLogic.EMITTER_SOURCE_LABEL;
    	}
    	else if(!nameIsNull && descriptionIsNull && labelIsNull && !emitterIsNull && !sourceIsNull){
    		this.searchLogic = EnumSearchLogic.EMITTER_SOURCE_NAME;
    	}
    	else if(!nameIsNull && descriptionIsNull && !labelIsNull && !emitterIsNull && sourceIsNull){
    		this.searchLogic = EnumSearchLogic.EMITTER_LABEL_NAME;
    	}
    	
    	// 3X search logic with SOURCE
    	else if(!nameIsNull && descriptionIsNull && !labelIsNull && emitterIsNull && !sourceIsNull){
    		this.searchLogic = EnumSearchLogic.SOURCE_LABEL_NAME;
    	}
    	else if(nameIsNull && !descriptionIsNull && !labelIsNull && emitterIsNull && !sourceIsNull){
    		this.searchLogic = EnumSearchLogic.SOURCE_LABEL_DESCRIPTION;
    	}
    	
    	// 4X search logic with NAME
    	else if(!nameIsNull && !descriptionIsNull && labelIsNull && !emitterIsNull && !sourceIsNull){
    		this.searchLogic = EnumSearchLogic.NAME_DESCRIPTION_EMITTER_SOURCE;
    	}
    	else if(!nameIsNull && !descriptionIsNull && !labelIsNull && !emitterIsNull && sourceIsNull){
    		this.searchLogic = EnumSearchLogic.NAME_DESCRIPTION_EMITTER_LABEL;
    	}
    	else if(!nameIsNull && !descriptionIsNull && !labelIsNull && emitterIsNull && !sourceIsNull){
    		this.searchLogic = EnumSearchLogic.NAME_DESCRIPTION_SOURCE_LABEL;
    	}
    	
    	// 4X search logic with DESCRIPTION
    	else if(nameIsNull && !descriptionIsNull && !labelIsNull && !emitterIsNull && !sourceIsNull){
    		this.searchLogic = EnumSearchLogic.DESCRIPTION_EMITTER_SOURCE_LABEL;
    	}
    	
    	// 4X search logic with EMITTER
    	else if(!nameIsNull && descriptionIsNull && !labelIsNull && !emitterIsNull && !sourceIsNull){
    		this.searchLogic = EnumSearchLogic.EMITTER_SOURCE_LABEL_NAME;
    	}
    	
    	//5X search
    	else if(!nameIsNull && !descriptionIsNull && !labelIsNull && !emitterIsNull && !sourceIsNull){
    		this.searchLogic = EnumSearchLogic.NAME_DESCRIPTION_EMITTER_SOURCE_LABEL;
    	}

	}
	
	public boolean isNameIsNull() {
		return nameIsNull;
	}
	public boolean isDescriptionIsNull() {
		return descriptionIsNull;
	}
	public boolean isLabelIsNull() {
		return labelIsNull;
	}
	public boolean isEmitterIsNull() {
		return emitterIsNull;
	}
	public boolean isSourceIsNull() {
		return sourceIsNull;
	}
	
	public EnumSearchLogic getSearchLogic() {
		
		if(this.parameterToSearch == null){
			throw new java.lang.Error("parameterToSe arch is NULL ----> CANNOT BE NULL");
		}
		else
			return searchLogic;
	}
	public ParameterToSearch getParameterToSearch() {
		return parameterToSearch;
	}
	public void setParameterToSearch(ParameterToSearch parameterToSearch) {
		this.parameterToSearch = parameterToSearch;
		generateSearchLogic(this.parameterToSearch);
	}
}
