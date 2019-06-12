package kwan.org.database.portlet;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.ServiceContextFactory;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.util.ParamUtil;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.Portlet;
import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import kwan.org.database.constants.StudentAdminPortletKeys;
import kwan.org.database.model.Bike;
import kwan.org.database.model.Student;
import kwan.org.database.service.BikeLocalService;
import kwan.org.database.service.StudentLocalService;

/**
 * @author TTM Dev
 */
@Component(immediate = true, property = { "com.liferay.portlet.display-category=category.sample",
		"com.liferay.portlet.instanceable=true", "javax.portlet.init-param.template-path=/",
		"javax.portlet.init-param.view-template=/studentadminportlet/view.jsp",
		"javax.portlet.name=" + StudentAdminPortletKeys.STUDENT_ADMIN, "javax.portlet.resource-bundle=content.Language",
		"javax.portlet.security-role-ref=power-user,user" }, service = Portlet.class)
public class StudentAdminPortlet extends MVCPortlet {

	private StudentLocalService _studentLocalService;

	@Reference(unbind = "-")
	protected void setStudentService(StudentLocalService studentLocalService) {
		_studentLocalService = studentLocalService;
	}

	public void addStudent(ActionRequest actionRequest, ActionResponse actionResponse) throws PortalException {

		ServiceContext serviceContext = ServiceContextFactory.getInstance(Student.class.getName(), actionRequest);

		String code = ParamUtil.getString(actionRequest, "code");
		String fullName = ParamUtil.getString(actionRequest, "fullName");

		Date birthday = ParamUtil.getDate(actionRequest, "birthday", new SimpleDateFormat("yyyy-MM-dd"));
		boolean gender = ParamUtil.getBoolean(actionRequest, "gender");
		String address = ParamUtil.getString(actionRequest, "address");

		try {
			_studentLocalService.addStudent(serviceContext.getUserId(), code, fullName, birthday, gender, address,
					serviceContext);
		} catch (Exception e) {
			SessionErrors.add(actionRequest, e.getClass().getName());
			actionResponse.setRenderParameter("mvcPath", "/studentadminportlet/view.jsp");

		}

	}

	public void deleteStudent(ActionRequest request, ActionResponse response) throws PortalException {
		ServiceContext serviceContext = ServiceContextFactory.getInstance(Student.class.getName(), request);
		long studentId = ParamUtil.getLong(request, "studentId");
		try {
			_studentLocalService.deleteStudent(studentId, serviceContext);
		} catch (PortalException e) {
			Logger.getLogger(StudentAdminPortlet.class.getName()).log(Level.SEVERE, null, e);
		}
	}

	public void updateStudent(ActionRequest actionRequest, ActionResponse actionResponse) throws PortalException {

		ServiceContext serviceContext = ServiceContextFactory.getInstance(Student.class.getName(), actionRequest);

		String code = ParamUtil.getString(actionRequest, "code");
		String fullName = ParamUtil.getString(actionRequest, "fullName");

		Date birthday = ParamUtil.getDate(actionRequest, "birthday", new SimpleDateFormat("yyyy-MM-dd"));
		boolean gender = ParamUtil.getBoolean(actionRequest, "gender");
		String address = ParamUtil.getString(actionRequest, "address");
		long studentId = ParamUtil.getLong(actionRequest, "studentId");

		_studentLocalService.updateStudent(serviceContext.getUserId(), studentId, code, fullName, birthday, gender,
				address, serviceContext);

	}

//	public void searchNameStudent(ActionRequest actionRequest, ActionResponse actionResponse) throws PortalException {
//		String keywords = ParamUtil.getString(actionRequest, "keywords");
//		System.out.println("search code " + keywords);
//		List<Student> result = _studentLocalService.findByFullName(keywords);
//		System.out.println(result.get(0).toString());
//		PortletRequestDispatcher rDispatcher = null;
//		rDispatcher = getPortletContext().getRequestDispatcher("/studentadminportlet/view_search.jsp");
//		actionRequest.setAttribute("result", result);
//		actionRequest.setAttribute("mvcPath", "");
//		
//		actionResponse.setRenderParameter("jspPage", "/studentadminportlet/view_search.jsp");
//		actionResponseresponse.setRenderParameter("mvcPath",
//	            "/html/guestbook/edit_guestbook.jsp");
//
//	}

	private BikeLocalService _bikeLocalService;

	@Reference(unbind = "-")
	protected void setBikeService(BikeLocalService bikeLocalService) {
		_bikeLocalService = bikeLocalService;
	}

//	public void addBike(ActionRequest actionRequest, ActionResponse actionResponse) throws PortalException {
//
//		ServiceContext serviceContext = ServiceContextFactory.getInstance(Bike.class.getName(), actionRequest);
//
//		String bikeName = ParamUtil.getString(actionRequest, "bikeName");
//		String brand = ParamUtil.getString(actionRequest, "brand");
//		long studentId = ParamUtil.getLong(actionRequest, "studentId");
//
//		_bikeLocalService.addBike(serviceContext.getUserId(), bikeName, brand, studentId, serviceContext);
//	}

	public void updateBike(ActionRequest actionRequest, ActionResponse actionResponse) throws PortalException {

		ServiceContext serviceContext = ServiceContextFactory.getInstance(Bike.class.getName(), actionRequest);

		String bikeName = ParamUtil.getString(actionRequest, "bikeName");
		String brand = ParamUtil.getString(actionRequest, "brand");
		long studentId = ParamUtil.getLong(actionRequest, "studentId");
		long bikeId = ParamUtil.getLong(actionRequest, "bikeId");

		_bikeLocalService.updateBike(serviceContext.getUserId(), bikeId, bikeName, brand, studentId, serviceContext);
	}

	public void deleteBike(ActionRequest actionRequest, ActionResponse actionResponse) throws PortalException {

		ServiceContext serviceContext = ServiceContextFactory.getInstance(Bike.class.getName(), actionRequest);

		long bikeId = ParamUtil.getLong(actionRequest, "bikeId");

		_bikeLocalService.deleteBike(bikeId, serviceContext);
	}

	@Override
	public void render(RenderRequest renderRequest, RenderResponse renderResponse)
			throws IOException, PortletException {
		renderRequest.setAttribute("StudentLocalService", _studentLocalService);
		super.render(renderRequest, renderResponse);
	}

}