/**
 * 
 */
package com.happiestMinds.daoImpl;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.transaction.annotation.Transactional;

import com.happiestMinds.dao.GioDao;
import com.happiestMinds.utils.ApiResponse;
import com.happiestMinds.utils.Constants;
import com.happiestMinds.utils.ResponseUtil;
import com.happiestMinds.vo.SelectVo;

/**
 * @author Mahesh Chouhan
 *
 */
@Transactional
public class GioDaoImpl implements GioDao {

	private static Logger log = Logger.getLogger(UserDaoImpl.class);

	@Autowired
	HibernateTemplate hibernateTemplate;

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.happiestMinds.dao.GioDao#getCountries()
	 */
	@Override
	public ApiResponse getCountries() {

		log.info("inside getCountries of GioDaoImpl");
		List<SelectVo> finalCountryList = new ArrayList<SelectVo>();
		try {
			List<Object[]> countryList = (List<Object[]>) hibernateTemplate
					.find("select id,name from Country where status=?", new Object[] { Constants.active });
			for (Object[] country : countryList) {
				SelectVo countryFinal = new SelectVo();
				countryFinal.setId((long) country[0]);
				countryFinal.setName((String) country[1]);
				finalCountryList.add(countryFinal);
			}
		} catch (DataAccessException e) {
			e.printStackTrace();
			log.info("Countries not able to retrive with error message -->"+e);
			return ResponseUtil.notAbleToRetriveFromDB();
		}
		log.info("Countries successfully retrived");
		return ResponseUtil.successfullyRetrived(finalCountryList);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.happiestMinds.dao.GioDao#getStates(long)
	 */
	@Override
	public ApiResponse getStates(long country) {
		// TODO Auto-generated method stub
		log.info("inside getStates of GioDaoImpl with country id -" + country);
		List<SelectVo> finalStateList = new ArrayList<SelectVo>();
		try {
			List<Object[]> stateList = (List<Object[]>) hibernateTemplate
					.find("select id,name from State where country.id=? and status=?", new Object[] {country, Constants.active });
			for (Object[] state : stateList) {
				SelectVo countryFinal = new SelectVo();
				countryFinal.setId((long) state[0]);
				countryFinal.setName((String) state[1]);
				finalStateList.add(countryFinal);
			}
		} catch (DataAccessException e) {
			e.printStackTrace();
			log.info("States not able to retrive with error message -->"+e);
			return ResponseUtil.notAbleToRetriveFromDB();
		}
		log.info("States successfully retrived");
		return ResponseUtil.successfullyRetrived(finalStateList);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.happiestMinds.dao.GioDao#getCities(long)
	 */
	@Override
	public ApiResponse getCities(long state) {
		log.info("inside getCities of GioDaoImpl with state id -" + state);

		List<SelectVo> finalCitiesList = new ArrayList<SelectVo>();
		try {
			List<Object[]> citiesList = (List<Object[]>) hibernateTemplate
					.find("select id,name from City where state.id=? and status=?", new Object[] {state, Constants.active });
			for (Object[] city : citiesList) {
				SelectVo countryFinal = new SelectVo();
				countryFinal.setId((long) city[0]);
				countryFinal.setName((String) city[1]);
				finalCitiesList.add(countryFinal);
			}
		} catch (DataAccessException e) {
			e.printStackTrace();
			log.info("Cities not able to retrive with error message -->"+e);
			return ResponseUtil.notAbleToRetriveFromDB();
		}
		log.info("Cities successfully retrived");
		return ResponseUtil.successfullyRetrived(finalCitiesList);
	}

}
