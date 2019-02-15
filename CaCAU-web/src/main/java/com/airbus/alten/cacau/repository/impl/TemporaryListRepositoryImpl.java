package com.airbus.alten.cacau.repository.impl;

import java.util.List;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import com.airbus.alten.cacau.model.UserParameter;
import com.airbus.alten.cacau.repository.TemporaryListDAO;

@Service
@Repository
public class TemporaryListRepositoryImpl {

	@Autowired
	private  TemporaryListDAO temporaryListDAO;

	@Transactional
	public void saveTemporaryList(UserParameter temporaryList){

		UserParameter serachTemporaryList = temporaryListDAO.findByParameterId(temporaryList.getParameterId());
		
		if(serachTemporaryList == null){
			temporaryListDAO.save(temporaryList);
		}
		else{
			int tempListID = serachTemporaryList.getTempListID();
			serachTemporaryList = temporaryList;
			serachTemporaryList.setTempListID(tempListID);
			temporaryListDAO.save(serachTemporaryList);
		}
		
		
	}

	@Transactional
	public List<UserParameter> getAllTemporaryList(){
		return temporaryListDAO.findAll();
	}


	@Transactional
	public List<UserParameter> getTemporaryListByUser(String username){

		return temporaryListDAO.findByUser(username);	
	}
	
	@Transactional
	public void deleteParameterFromTempList(int parameterId){

		temporaryListDAO.deleteUserParameterByParameterId(parameterId);;	
	}
	
	@Transactional
	public void deleteAllParameterFromTempList(){

		temporaryListDAO.deleteAll();	
	}
	
}

