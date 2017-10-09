package com.happiestMinds.daoImpl;

import java.lang.reflect.InvocationTargetException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.transaction.annotation.Transactional;

import com.happiestMinds.dao.UserDao;
import com.happiestMinds.entity.Address;
import com.happiestMinds.entity.City;
import com.happiestMinds.entity.Country;
import com.happiestMinds.entity.State;
import com.happiestMinds.entity.User;
import com.happiestMinds.utils.ApiResponse;
import com.happiestMinds.utils.Constants;
import com.happiestMinds.utils.GenerateUniqueIds;
import com.happiestMinds.utils.ResponseUtil;
import com.happiestMinds.vo.AddressVo;
import com.happiestMinds.vo.CityVo;
import com.happiestMinds.vo.CountryVo;
import com.happiestMinds.vo.StateVo;
import com.happiestMinds.vo.UserVo;

/**
 * @author Mahesh Chouhan
 *
 */
@Transactional
public class UserDaoImpl implements UserDao {

	private static Logger log = Logger.getLogger(UserDaoImpl.class);

	@Autowired
	HibernateTemplate hibernateTemplate;

	@Override
	public ApiResponse addUser(UserVo user) {

		if (user == null || user.getAddressVo() == null || user.getAddressVo().getCity() == null)
			return ResponseUtil.inputNotProper();

		log.info("Inside addUser method of UserDaoImpl with user mobile no -- " + user.getMobileNumber());
		User userEntity = new User();
		Address addressEntity = new Address();

		try {

			String dob = user.getDob();
			DateFormat formatter = new SimpleDateFormat(Constants.datepickerFormat);
			Date dobDate = formatter.parse(dob);
			SimpleDateFormat sdf = new SimpleDateFormat(Constants.requiredDateFormate);
			user.setDob(sdf.format(dobDate));
			BeanUtils.copyProperties(userEntity, user);
			// BeanUtils.copyProperties(addressEntity, user.getAddressVo());
			addressEntity.setDoorNo(user.getAddressVo().getDoorNo());
			addressEntity.setPinCode(user.getAddressVo().getPinCode());
			addressEntity.setStreet(user.getAddressVo().getStreet());
			userEntity.setStatus(Constants.active);
			userEntity.setId(GenerateUniqueIds.getUniqueLongId());
			user.setId(userEntity.getId());
			addressEntity.setId(GenerateUniqueIds.getUniqueLongId());
			City cityEntity = hibernateTemplate.load(City.class, user.getAddressVo().getCity().getId());
			user.getAddressVo().getCity().setName(cityEntity.getName());
			;
			// hibernateTemplate.persist(cityEntity);
			addressEntity.setCity(cityEntity);
			hibernateTemplate.persist(addressEntity);
			userEntity.setAddress(addressEntity);
			hibernateTemplate.persist(userEntity);
		} catch (DataAccessException e) {
			log.info("Not able to add user to db for user -- " + user);
			log.info(e.getMessage());
			e.printStackTrace();
			return ResponseUtil.additionFailed();
		} catch (IllegalAccessException e) {
			log.info("Not able to add user to db for user -- " + user);
			log.info(e.getMessage());
			e.printStackTrace();
			return ResponseUtil.additionFailed();
		} catch (InvocationTargetException e) {
			log.info("Not able to add user to db for user -- " + user);
			log.info(e.getMessage());
			e.printStackTrace();
			return ResponseUtil.additionFailed();
		} catch (Exception e) {
			log.info("Not able to add user to db for user -- " + user);
			log.info(e.getMessage());
			e.printStackTrace();
			return ResponseUtil.additionFailed();
		}

		log.info("User added successfully for user vo -- " + user);
		return ResponseUtil.successfullyAdded(user);
	}

	@Override
	public ApiResponse getAllUser() {

		log.info("Inside getUser method of UserDaoImpl");
		List<UserVo> userlist = new ArrayList<UserVo>();

		try {
			List<User> userEntityList = hibernateTemplate.loadAll(User.class);
			if (userEntityList != null && userEntityList.size() > 0) {
				for (User userEntity : userEntityList) {
					UserVo user = new UserVo();
					BeanUtils.copyProperties(user, userEntity);
					if (userEntity.getAddress() != null) {
						AddressVo address = new AddressVo();
						// BeanUtils.copyProperties(address,
						// userEntity.getAddress());
						address.setDoorNo(userEntity.getAddress().getDoorNo());
						address.setId(userEntity.getAddress().getId());
						address.setPinCode(userEntity.getAddress().getPinCode());
						address.setStreet(userEntity.getAddress().getStreet());
						if (userEntity.getAddress().getCity() != null) {
							City cityEntity = userEntity.getAddress().getCity();
							CityVo cityVo = new CityVo();
							BeanUtils.copyProperties(cityVo, cityEntity);
							/*
							 * cityVo.setDescription(cityEntity.getDescription()
							 * ); cityVo.setId(cityEntity.getId());
							 * cityVo.setName(cityEntity.getName());
							 * cityVo.setStatus(cityEntity.getStatus());
							 */
							address.setCity(cityVo);
							if (userEntity.getAddress().getCity().getState() != null) {
								State stateEntity = userEntity.getAddress().getCity().getState();
								StateVo stateVo = new StateVo();
								BeanUtils.copyProperties(stateVo, stateEntity);
								address.setState(stateVo);
								if (userEntity.getAddress().getCity().getState().getCountry() != null) {
									Country countryEntity = userEntity.getAddress().getCity().getState().getCountry();
									CountryVo countryVo = new CountryVo();
									BeanUtils.copyProperties(countryEntity, countryEntity);
								} else {
									log.debug("Country is null for user with mobile number ->"
											+ userEntity.getMobileNumber());
								}
							} else {
								log.debug(
										"State is null for user with mobile number ->" + userEntity.getMobileNumber());
							}
						} else {
							log.debug("City is null for user with mobile number ->" + userEntity.getMobileNumber());
						}
						user.setAddressVo(address);
					} else {
						log.debug("Address is null for user with mobile number ->" + userEntity.getMobileNumber());
					}
					userlist.add(user);
				}
			}
		} catch (DataAccessException e) {
			log.info("not able to access list of users with error message -- " + e.getMessage());
			e.printStackTrace();
			return ResponseUtil.notAbleToRetriveFromDB();
		} catch (IllegalAccessException e) {
			log.info("not able to access list of users with error message -- " + e.getMessage());
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			log.info("not able to access list of users with error message -- " + e.getMessage());
			e.printStackTrace();
		}
		log.info("User retrived successfully");
		return ResponseUtil.successfullyRetrived(userlist);
	}

	@Override
	public ApiResponse editUser(UserVo user) {
		if (user == null || user.getAddressVo() == null)
			return ResponseUtil.inputNotProper();

		log.info("Inside editUser method of UserDaoImpl with user vo -- " + user);

		try {
			User userEntity = new User();
			Address addressEntity = new Address();

			BeanUtils.copyProperties(userEntity, user);
			BeanUtils.copyProperties(addressEntity, user.getAddressVo());
			City cityEntity = hibernateTemplate.load(City.class, user.getAddressVo().getCity().getId());
			addressEntity.setCity(cityEntity);
			hibernateTemplate.update(addressEntity);
			userEntity.setAddress(addressEntity);
			hibernateTemplate.update(userEntity);
		} catch (DataAccessException e) {
			log.info("Not able to edit user to db for user -- " + user);
			log.info(e.getMessage());
			e.printStackTrace();
			return ResponseUtil.editFailed();
		} catch (IllegalAccessException e) {
			log.info("Not able to edit user to db for user -- " + user);
			log.info(e.getMessage());
			e.printStackTrace();
			return ResponseUtil.editFailed();
		} catch (InvocationTargetException e) {
			log.info("Not able to edit user to db for user -- " + user);
			log.info(e.getMessage());
			e.printStackTrace();
			return ResponseUtil.editFailed();
		} catch (Exception e) {
			log.info("Not able to edit user to db for user -- " + user);
			log.info(e.getMessage());
			e.printStackTrace();
			return ResponseUtil.editFailed();
		}

		log.info("User edited successfully for user vo -- " + user);
		return ResponseUtil.successfullyEdited();
	}

	@Override
	public ApiResponse deleteUser(Long id) {
		log.info("Inside deleteUser method of UserDaoImpl with user id -- " + id);

		try {
			User userEntity = hibernateTemplate.load(User.class, id);
			if (userEntity == null)
				return ResponseUtil.dataNotFoundInDb();
			userEntity.setStatus(Constants.inActive);
			hibernateTemplate.update(userEntity);
		} catch (DataAccessException e) {
			log.info("Delete failed for user id -- " + id);
			log.info(e.getMessage());
			e.printStackTrace();
			return ResponseUtil.deletionFailed();
		}
		log.info("Deletion successful for user id -- " + id);
		return ResponseUtil.deletedSuccesfully();
	}
}