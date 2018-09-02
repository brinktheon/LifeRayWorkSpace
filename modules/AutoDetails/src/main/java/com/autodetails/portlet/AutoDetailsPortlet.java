package com.autodetails.portlet;

import com.autodetails.constants.AutoDetailsPortletKeys;

import com.autodetservice.model.AutoDetails;
import com.autodetservice.service.AutoDetailsLocalServiceUtil;
import com.liferay.counter.kernel.service.CounterLocalServiceUtil;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
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

import org.osgi.service.component.annotations.Component;

/**
 * @author chris
 */
@Component(
	immediate = true,
	property = {
		"com.liferay.portlet.display-category=MyPortlets",
		"com.liferay.portlet.instanceable=true",
		"javax.portlet.display-name=AutoDetails Portlet",
		"javax.portlet.init-param.template-path=/",
		"javax.portlet.init-param.view-template=/addModel.jsp",
		"javax.portlet.name=" + AutoDetailsPortletKeys.AutoDetails,
		"javax.portlet.resource-bundle=content.Language",
		"javax.portlet.security-role-ref=power-user,user"
	},
	service = Portlet.class
)
public class AutoDetailsPortlet extends MVCPortlet {
	
	private Log logger =  LogFactoryUtil.getLog(AutoDetailsPortlet.class);
	 
	
	@ProcessAction(name = "autoDetailsSubmit")
	public void autoDetailsSubmit(ActionRequest actionRequest, ActionResponse actionResponse) throws IOException, PortletException{
		
		logger.info("Manufacturer: " + actionRequest.getParameter("manufacturer"));
		logger.info("Year: " + actionRequest.getParameter("year"));
		logger.info("VIN: " +actionRequest.getParameter("vin"));
		logger.info("Bodystyle: " +actionRequest.getParameter("bodystyle"));
		logger.info("Model: " +actionRequest.getParameter("model"));
		
		logger.info("IT Worked");
		
		try{
			AutoDetails autoDetails = AutoDetailsLocalServiceUtil
					.createAutoDetails(CounterLocalServiceUtil.increment());
			ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest.getAttribute(WebKeys.THEME_DISPLAY);

			long userId = themeDisplay.getUserId();

			autoDetails.setUserId(userId);
			autoDetails.setUserName(themeDisplay.getUser().getScreenName());
			autoDetails.setCreateDate(new Date());
			autoDetails.setModifiedDate(new Date());

			String manufacturer = actionRequest.getParameter("manufacturer");
			autoDetails.setManufacturer(manufacturer);
			
			String year = actionRequest.getParameter("year");
			autoDetails.setYear(Integer.parseInt(year));
			
			String vin = actionRequest.getParameter("vin");
			autoDetails.setVIN(vin);
			
			String bodystyle = actionRequest.getParameter("bodystyle");
			autoDetails.setBodystyle(bodystyle);
			
			String model = actionRequest.getParameter("model");
			autoDetails.setModel(model);
			
			AutoDetailsLocalServiceUtil.addAutoDetails(autoDetails);
			logger.info("---------------------SUCCESS-------------------------");
			//actionResponse.setRenderParameter("mvcPath", "/details.jsp");
			
		} catch(Exception e){
			e.printStackTrace();
		}
		
	}
}






