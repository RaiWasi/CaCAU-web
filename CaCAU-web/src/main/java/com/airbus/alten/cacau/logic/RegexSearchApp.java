package com.airbus.alten.cacau.logic;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.airbus.alten.cacau.model.json.Parameter;

public class RegexSearchApp {
 
    public static List<Parameter>  searchParameters(ParameterToSearch parameterToSearch, List<Parameter> parameterList){
    	
    	SearchLogicEngine searchLogicEngine = new SearchLogicEngine();
    	searchLogicEngine.setParameterToSearch(parameterToSearch);
    	EnumSearchLogic searchLogic = searchLogicEngine.getSearchLogic();
    	
    	List<Parameter> parameterListResponse = new ArrayList<Parameter>();
    	
    	String labelResult = null;
    		
    	if(parameterToSearch.getLabel() != null && !parameterToSearch.getLabel().isEmpty())
    		labelResult = String.format("%03d", Integer.valueOf(parameterToSearch.getLabel()));
    	
    	
    	Pattern namePattern = null;
    	Pattern descriptionPattern = null;
    	Pattern labelPattern = null;
    	Pattern emitterPattern = null;
    	Pattern sourcePattern = null;
    	

    	if(parameterToSearch.getName() != null && !parameterToSearch.getName().isEmpty())
    		namePattern = Pattern.compile(".*" + parameterToSearch.getName() +".*", Pattern.CASE_INSENSITIVE);
    	
    	if(parameterToSearch.getDescription() != null && !parameterToSearch.getDescription().isEmpty())
    		descriptionPattern = Pattern.compile(".*" + parameterToSearch.getDescription() + ".*", Pattern.CASE_INSENSITIVE);
    	
    	if(parameterToSearch.getEmitter() != null && !parameterToSearch.getEmitter().isEmpty())
    		emitterPattern = Pattern.compile(".*" + parameterToSearch.getEmitter() + ".*", Pattern.CASE_INSENSITIVE);
    	
    	if(parameterToSearch.getSource() != null && !parameterToSearch.getSource().isEmpty())
    		sourcePattern = Pattern.compile(".*" + parameterToSearch.getSource() + ".*", Pattern.CASE_INSENSITIVE);
    	
    	if(labelResult != null)
    		labelPattern = Pattern.compile(labelResult, Pattern.CASE_INSENSITIVE);
    	

    	for(Parameter p : parameterList){
        	
        	Matcher nameMatcher = null;
        	Matcher descriptionMatcher = null;
        	Matcher labelMatcher = null;
        	Matcher emitterMatcher = null;
        	Matcher sourceMatcher = null;
        	
        	if(parameterToSearch.getName() != null && !parameterToSearch.getName().isEmpty())
        		nameMatcher = namePattern.matcher(p.getParameterName().toString());
        	
        	if(parameterToSearch.getDescription() != null && !parameterToSearch.getDescription().isEmpty())
        		descriptionMatcher = descriptionPattern.matcher(p.getDescription().toString());
        	
        	if(labelResult != null  && !labelResult.isEmpty())
        		labelMatcher = labelPattern.matcher(p.getLabel().toString());
        	
        	if(parameterToSearch.getEmitter() != null  && !parameterToSearch.getEmitter().isEmpty())  
        		emitterMatcher = emitterPattern.matcher(p.getEmitter().toString());
        	
        	if(parameterToSearch.getSource() != null  && !parameterToSearch.getSource().isEmpty())  
        		sourceMatcher = sourcePattern.matcher(p.getSource().toString());
        	
        	
        	// Single search       	
        	if(EnumSearchLogic.NAME.equals(searchLogic)){ //working - new SearchLogic
            	if(nameMatcher.find()){
            		parameterListResponse.add(p); //working - added all Elements to List
            	}
        	}
        	else  if(EnumSearchLogic.DESCRIPTION.equals(searchLogic)){
            	if(descriptionMatcher.find()){
            		parameterListResponse.add(p);
            	}
        	}
        	else  if(EnumSearchLogic.EMITTER.equals(searchLogic)){
            	if(emitterMatcher.find()){
            		parameterListResponse.add(p);
            	}
        	}
        	else  if(EnumSearchLogic.SOURCE.equals(searchLogic)){
            	if(sourceMatcher.find()){
            		parameterListResponse.add(p);
            	}
        	}
        	else  if(EnumSearchLogic.LABEL.equals(searchLogic)){
            	if(labelMatcher.find()){
            		parameterListResponse.add(p);
            	}
        	}
        	
        	// 2X search NAME
        	else if(EnumSearchLogic.NAME_DESCRIPTION.equals(searchLogic)){
            	if(nameMatcher.find() && descriptionMatcher.find()){
            		parameterListResponse.add(p);
            	}
        	}
        	else if(EnumSearchLogic.NAME_EMITTER.equals(searchLogic)){
            	if(nameMatcher.find() && emitterMatcher.find()){
            		parameterListResponse.add(p);
            	}
        	}
        	else if(EnumSearchLogic.NAME_SOURCE.equals(searchLogic)){
            	if(nameMatcher.find() && sourceMatcher.find()){
            		parameterListResponse.add(p);
            	}
        	}
        	else if(EnumSearchLogic.NAME_LABEL.equals(searchLogic)){
            	if(nameMatcher.find() && labelMatcher.find()){
            		parameterListResponse.add(p);
            	}
        	}
        	
        	// 2X search DESCRIPTION
        	else if(EnumSearchLogic.DESCRIPTION_EMITTER.equals(searchLogic)){
            	if(descriptionMatcher.find() && emitterMatcher.find()){
            		parameterListResponse.add(p);
            	}
        	}
        	else if(EnumSearchLogic.DESCRIPTION_SOURCE.equals(searchLogic)){
            	if(descriptionMatcher.find() && sourceMatcher.find()){
            		parameterListResponse.add(p);
            	}
        	}
        	else if(EnumSearchLogic.DESCRIPTION_LABEL.equals(searchLogic)){
            	if(descriptionMatcher.find() && labelMatcher.find()){
            		parameterListResponse.add(p);
            	}
        	}
        	
        	// 2X search EMITTER
        	else if(EnumSearchLogic.EMITTER_SOURCE.equals(searchLogic)){
            	if(emitterMatcher.find() && sourceMatcher.find()){
            		parameterListResponse.add(p);
            	}
        	}
        	else if(EnumSearchLogic.EMITTER_LABEL.equals(searchLogic)){
            	if(emitterMatcher.find() && labelMatcher.find()){
            		parameterListResponse.add(p);
            	}
        	}
        	
        	// 2X search SOURCE
        	else if(EnumSearchLogic.SOURCE_LABEL.equals(searchLogic)){
            	if(sourceMatcher.find() && labelMatcher.find()){
            		parameterListResponse.add(p);
            	}
        	}
        	
        	// 3X search NAME
        	else if(EnumSearchLogic.NAME_DESCRIPTION_EMITTER.equals(searchLogic)){
            	if(nameMatcher.find() && descriptionMatcher.find() && emitterMatcher.find()){
            		parameterListResponse.add(p);
            	}
        	}
        	else if(EnumSearchLogic.NAME_DESCRIPTION_SOURCE.equals(searchLogic)){
            	if(nameMatcher.find() && descriptionMatcher.find() && sourceMatcher.find()){
            		parameterListResponse.add(p);
            	}
        	}
        	else if(EnumSearchLogic.NAME_DESCRIPTION_LABEL.equals(searchLogic)){
            	if(nameMatcher.find() && descriptionMatcher.find() && labelMatcher.find()){
            		parameterListResponse.add(p);
            	}
        	}
        	
        	// 3X search DESCRIPTION
        	else if(EnumSearchLogic.DESCRIPTION_EMITTER_SOURCE.equals(searchLogic)){
            	if(descriptionMatcher.find() && emitterMatcher.find() && sourceMatcher.find()){
            		parameterListResponse.add(p);
            	}
        	}
        	else if(EnumSearchLogic.DESCRIPTION_EMITTER_LABEL.equals(searchLogic)){
            	if(descriptionMatcher.find() && emitterMatcher.find() && labelMatcher.find()){
            		parameterListResponse.add(p);
            	}
        	}
        	
        	// 3X search EMITTER
        	else if(EnumSearchLogic.EMITTER_SOURCE_LABEL.equals(searchLogic)){
            	if(emitterMatcher.find() && sourceMatcher.find() && labelMatcher.find()){
            		parameterListResponse.add(p);
            	}
        	}
        	else if(EnumSearchLogic.EMITTER_SOURCE_NAME.equals(searchLogic)){
            	if(emitterMatcher.find() && sourceMatcher.find() && nameMatcher.find()){
            		parameterListResponse.add(p);
            	}
        	}
        	else if(EnumSearchLogic.EMITTER_LABEL_NAME.equals(searchLogic)){
            	if(emitterMatcher.find() && labelMatcher.find() && nameMatcher.find()){
            		parameterListResponse.add(p);
            	}
        	}
        	
        	// 3X search SOURCE
        	else if(EnumSearchLogic.SOURCE_LABEL_NAME.equals(searchLogic)){
            	if(sourceMatcher.find() && labelMatcher.find() && nameMatcher.find()){
            		parameterListResponse.add(p);
            	}
        	}
        	else if(EnumSearchLogic.SOURCE_LABEL_DESCRIPTION.equals(searchLogic)){
            	if(sourceMatcher.find() && labelMatcher.find() && descriptionMatcher.find()){
            		parameterListResponse.add(p);
            	}
        	}
        	    		
        	// 4X search NAME
        	else if(EnumSearchLogic.NAME_DESCRIPTION_EMITTER_LABEL.equals(searchLogic)){
        		if(nameMatcher.find() && descriptionMatcher.find() && emitterMatcher.find() && labelMatcher.find()){
            		parameterListResponse.add(p);
            	}
        	}
          	else if(EnumSearchLogic.NAME_DESCRIPTION_EMITTER_SOURCE.equals(searchLogic)){
            	if(nameMatcher.find() && descriptionMatcher.find() && emitterMatcher.find() && sourceMatcher.find()){
            		parameterListResponse.add(p);
            	}
        	}
          	else if(EnumSearchLogic.NAME_DESCRIPTION_SOURCE_LABEL.equals(searchLogic)){
          		if(nameMatcher.find() && descriptionMatcher.find() && sourceMatcher.find() && labelMatcher.find()){
            		parameterListResponse.add(p);
            	}
        	}
        	
        	// 4X search DESCRIPTION
        	else if(EnumSearchLogic.DESCRIPTION_EMITTER_SOURCE_LABEL.equals(searchLogic)){
        		if(descriptionMatcher.find() && emitterMatcher.find() && sourceMatcher.find() && labelMatcher.find()){
            		parameterListResponse.add(p);
            	}
        	}
        	
        	//4X search EMITTER
          	else if(EnumSearchLogic.EMITTER_SOURCE_LABEL_NAME.equals(searchLogic)){
            	if(emitterMatcher.find() && sourceMatcher.find() && labelMatcher.find() && nameMatcher.find()){
            		parameterListResponse.add(p);
            	}
        	}
        	
        	//5X search 
          	else if(EnumSearchLogic.NAME_DESCRIPTION_EMITTER_SOURCE_LABEL.equals(searchLogic)){
            	if(nameMatcher.find() && descriptionMatcher.find() && emitterMatcher.find() && sourceMatcher.find() && labelMatcher.find()){
            		parameterListResponse.add(p);
            	}
        	}
        }
        
        return parameterListResponse;
    }  
}

