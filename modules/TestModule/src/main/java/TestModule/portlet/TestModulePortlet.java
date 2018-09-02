package TestModule.portlet;

import TestModule.constants.TestModulePortletKeys;


import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;

import javax.portlet.Portlet;

import org.osgi.service.component.annotations.Component;

/**
 * @author chris
 */
@Component(
	immediate = true,
	property = {
		"com.liferay.portlet.display-category=MyPortlets",
		"com.liferay.portlet.instanceable=true",
		"javax.portlet.display-name=TestModule Portlet",
		"javax.portlet.init-param.template-path=/",
		"javax.portlet.init-param.view-template=/view.jsp",
		"javax.portlet.name=" + TestModulePortletKeys.TestModule,
		"javax.portlet.resource-bundle=content.Language",
		"javax.portlet.security-role-ref=power-user,user"
	},
	service = Portlet.class
)
public class TestModulePortlet extends MVCPortlet {
	public void todo(){
		
		
	}
}