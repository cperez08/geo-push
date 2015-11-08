package com.edu.itm.push.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.edu.itm.push.beans.Device;
import com.edu.itm.push.beans.PushGoogleBean;
import com.edu.itm.push.beans.RegisterBean;
import com.edu.itm.push.beans.ResponseStatus;
import com.edu.itm.push.beans.ResponseStatusAuth;
import com.edu.itm.push.beans.SenderAlertMessage;
import com.edu.itm.push.beans.User;
import com.edu.itm.push.services.ErrorsDefines;
import com.edu.itm.push.services.PushDaoAction;
import com.edu.itm.push.services.PushServices;

@Controller
@RequestMapping(value = "/services")
public class PushMessageController {

	@Autowired
	private PushDaoAction pusDaoAction;
	@Autowired
	private PushServices pushServices;

	@RequestMapping(value = "/sendMessage", method= RequestMethod.POST, produces=MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody ResponseStatus sendMessage(
			@RequestBody SenderAlertMessage senderAlertMessage,@RequestHeader HttpHeaders headers) {
		
		ResponseStatus response = new ResponseStatus();
		
		response.setDesciption(ErrorsDefines.DESC_UNDEFINED_ERROR);
		response.setStatusCode(ErrorsDefines.STATUS_NO_PROCESS);

		if (senderAlertMessage != null){
			
			List<Device> devicesToPush = pusDaoAction.getEmployesToPush(senderAlertMessage);
			
			if(devicesToPush != null){
				
				List <String> devices = new ArrayList<String>();
				
				short i = 0;
				
				while (i < devicesToPush.size()){
					
					devices.add(devicesToPush.get(i).getPushId());
					i++;
					
				}
				
				PushGoogleBean googleBean = new PushGoogleBean();
				
				googleBean.setRegistration_ids(devices); 
				googleBean.getData().setLatitud(senderAlertMessage.getLatitude());
				googleBean.getData().setLongitude(senderAlertMessage.getLongitude());
				googleBean.getData().setMessage(senderAlertMessage.getMessage());
				
				try{
				pushServices.sendMessage(googleBean);
				response.setDesciption(ErrorsDefines.DESC_NO_ERROR_MESSAGE);
				response.setStatusCode(ErrorsDefines.STATUS_MESSAGE_SEND);
				}catch (RuntimeException rex){
					
					response.setDesciption(ErrorsDefines.DESC_NO_ERROR_MESSAGE);
					response.setStatusCode(ErrorsDefines.STATUS_MESSAGE_SEND);
				}
				
				
			}else{
				
				response.setDesciption(ErrorsDefines.DESC_GENERAL_ERROR);
				response.setStatusCode(ErrorsDefines.STATUS_GENERAL_ERROR);
			}	
				
			
		}
		
		
		return response;
	}

	@RequestMapping(value = "/auth", method= RequestMethod.POST, produces=MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody ResponseStatusAuth authentication(
			@RequestBody User user, @RequestHeader HttpHeaders headers) {

		ResponseStatusAuth response = new ResponseStatusAuth();

		response.setDesciption(ErrorsDefines.DESC_UNDEFINED_ERROR);
		response.setStatusCode(ErrorsDefines.STATUS_NO_PROCESS);

		if (user != null && user.getUserNickname() != null) {

			if (user.getUserPassword() == null) {

				System.out.println("User identified like regular user");

				User userAuth = pusDaoAction.authWithOutPass(user
						.getUserNickname());

				if (userAuth != null && userAuth.getUserProfile() != 0) {

					response.setDesciption(ErrorsDefines.DESC_OK);
					response.setStatusCode(ErrorsDefines.STATUS_OK);
					response.setUser(userAuth);



				} else {

					response.setDesciption(ErrorsDefines.DESC_ERROR_AUTH);
					response.setDesciption(ErrorsDefines.STATUS_ERROR_AUTH);


				}

			} else {

				System.out.println("User identified like regular user");

				User userAuth = pusDaoAction.authWithPass(user.getUserNickname(), user.getUserPassword());

				if (userAuth != null) {

					response.setDesciption(ErrorsDefines.DESC_OK);
					response.setDesciption(ErrorsDefines.STATUS_OK);
					response.setUser(userAuth);


				} else {

					response.setDesciption(ErrorsDefines.DESC_ERROR_AUTH);
					response.setDesciption(ErrorsDefines.STATUS_ERROR_AUTH);


				}

			}

		} else {

			response.setDesciption("Error sendig paramaters");
			response.setStatusCode(ErrorsDefines.STATUS_ERROR_USER_AND_PROFILE);
			
		}
		
		return response;

	}

	
	@RequestMapping(value = "/register", method= RequestMethod.POST, produces=MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody ResponseStatus registerPush(
			@RequestBody RegisterBean registerBean,@RequestHeader HttpHeaders headers) {
		
	   ResponseStatus response = new ResponseStatus();
		
		response.setDesciption(ErrorsDefines.DESC_UNDEFINED_ERROR);
		response.setStatusCode(ErrorsDefines.STATUS_NO_PROCESS);
		
		if(registerBean != null){
			
			
			if (pusDaoAction.registerPush(registerBean)){
				
				response.setDesciption(ErrorsDefines.DESC_NO_ERROR_MESSAGE);
				response.setStatusCode(ErrorsDefines.STATUS_OK);
			}else{
				
				response.setDesciption(ErrorsDefines.DESC_NO_UPDATED_ROWS);
				response.setStatusCode(ErrorsDefines.STATUS_UPDATE_SEND);
			}
			
		}
		
		return response;
	
	}
}