package kwan.org.database.portlet.render;

import com.liferay.portal.kernel.portlet.bridges.mvc.MVCRenderCommand;

import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.osgi.service.component.annotations.Component;

import kwan.org.database.constants.StudentAdminPortletKeys;

@Component(immediate = true, property = { "javax.portlet.name=" + StudentAdminPortletKeys.STUDENT_ADMIN,
		"mvc.command.name=/studentadminportlet/view" }, service = MVCRenderCommand.class)
public class ViewStudentMVCRenderCommand implements MVCRenderCommand {

	@Override
	public String render(RenderRequest renderRequest, RenderResponse renderResponse) throws PortletException {
		System.out.println("vao mvc render commnad");
		return "/studentadminportlet/view.jsp";
	}
}