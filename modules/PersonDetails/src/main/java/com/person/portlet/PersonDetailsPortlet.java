package com.person.portlet;

import com.person.constants.PersonDetailsPortletKeys;

import com.personservice.model.PersonDetails;
import com.personservice.service.PersonDetailsLocalServiceUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.WebKeys;

import java.io.IOException;
import java.util.Date;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.Portlet;
import javax.portlet.PortletException;
import javax.portlet.ProcessAction;


import com.liferay.counter.kernel.service.CounterLocalServiceUtil;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;

import org.osgi.service.component.annotations.Component;

/**
 * @author chris
 */
@Component(
	immediate = true,
	property = {
		"com.liferay.portlet.display-category=MyPortlets",
		"com.liferay.portlet.instanceable=true",
		"javax.portlet.display-name=PersonDetails Portlet",
		"javax.portlet.init-param.template-path=/",
		"javax.portlet.init-param.view-template=/detailsList.jsp",
		"javax.portlet.name=" + PersonDetailsPortletKeys.PersonDetails,
		"javax.portlet.resource-bundle=content.Language",
		"javax.portlet.security-role-ref=power-user,user"
	},
	service = Portlet.class
)
public class PersonDetailsPortlet extends MVCPortlet {
	
	private Log logger =  LogFactoryUtil.getLog(PersonDetailsPortlet.class);
	
	@ProcessAction(name = "personDetailsSubmit")
	public void autoDetailsSubmit(ActionRequest actionRequest, ActionResponse actionResponse) throws IOException, PortletException{
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








