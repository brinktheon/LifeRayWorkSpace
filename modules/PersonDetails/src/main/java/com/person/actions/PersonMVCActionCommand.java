package com.person.actions;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;

import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.WebKeys;

import java.util.Date;
import com.personservice.model.PersonDetails;
import com.personservice.service.PersonDetailsLocalServiceUtil;
import com.liferay.counter.kernel.service.CounterLocalServiceUtil;

import org.osgi.service.component.annotations.Component;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.BaseMVCActionCommand;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCActionCommand;
import com.person.constants.PersonDetailsPortletKeys;

@Component(
	    immediate = true,
	    property = {
	        "javax.portlet.name=" + PersonDetailsPortletKeys.PersonDetails,
	        "mvc.command.name=personDetailsSubmit"
	    },
	    service = MVCActionCommand.class
	)
	
public class PersonMVCActionCommand extends BaseMVCActionCommand{

	private Log logger =  LogFactoryUtil.getLog(PersonMVCActionCommand.class);
	
	@Override
	protected void doProcessAction(ActionRequest actionRequest, ActionResponse actionResponse) throws Exception {
		logger.info("FirstName: " + actionRequest.getParameter("firstName"));
		logger.info("SecondName: " + actionRequest.getParameter("secondName"));
		logger.info("Age: " +actionRequest.getParameter("age"));
		logger.info("Specialty: " +actionRequest.getParameter("specialty"));
		logger.info("Experience: " +actionRequest.getParameter("experience"));
		
		logger.info("It's Worked");
		
		try{
		PersonDetails personDetails = PersonDetailsLocalServiceUtil
				.createPersonDetails(CounterLocalServiceUtil.increment());
		ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest.getAttribute(WebKeys.THEME_DISPLAY);

		long userId = themeDisplay.getUserId();

		personDetails.setUserId(userId);
		personDetails.setUserName(themeDisplay.getUser().getScreenName());
		personDetails.setCreateDate(new Date());
		personDetails.setModifiedDate(new Date());

		String firstName = actionRequest.getParameter("firstName");
		personDetails.setFirstName(firstName);
		
		String secondName = actionRequest.getParameter("secondName");
		personDetails.setSecondName(secondName);
		
		int age = Integer.parseInt(actionRequest.getParameter("age"));
		personDetails.setAge(age);
		
		String specialty = actionRequest.getParameter("specialty");
		personDetails.setSpecialty(specialty);
		
		String experience = actionRequest.getParameter("experience");
		personDetails.setExperience(experience);
		
		PersonDetailsLocalServiceUtil.addPersonDetails(personDetails);
		logger.info("---------------------SUCCESS-------------------------");
		actionResponse.setRenderParameter("mvcPath", "/detailsList.jsp");
		
	} catch(Exception e){
		e.printStackTrace();
	}
		
	}

}
