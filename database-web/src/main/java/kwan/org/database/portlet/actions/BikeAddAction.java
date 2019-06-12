package kwan.org.database.portlet.actions;

import com.liferay.portal.kernel.portlet.bridges.mvc.BaseMVCActionCommand;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCActionCommand;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.ServiceContextFactory;
import com.liferay.portal.kernel.util.ParamUtil;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import kwan.org.database.constants.StudentAdminPortletKeys;
import kwan.org.database.model.Bike;
import kwan.org.database.service.BikeLocalService;

@Component(
	    immediate = true,
	    property = {
	        "javax.portlet.name="+StudentAdminPortletKeys.STUDENT_ADMIN,
	        "mvc.command.name=/addBike"
	    },
	    service = MVCActionCommand.class
	)
public class BikeAddAction  extends BaseMVCActionCommand {
	
	private BikeLocalService _bikeLocalService;

	@Reference(unbind = "-")
	protected void setBikeService(BikeLocalService bikeLocalService) {
		_bikeLocalService = bikeLocalService;
	}


	@Override
	protected void doProcessAction(ActionRequest actionRequest, ActionResponse actionResponse) throws Exception {
		// TODO Auto-generated method stub
		ServiceContext serviceContext = ServiceContextFactory.getInstance(Bike.class.getName(), actionRequest);

		String bikeName = ParamUtil.getString(actionRequest, "bikeName");
		String brand = ParamUtil.getString(actionRequest, "brand");
		long studentId = ParamUtil.getLong(actionRequest, "studentId");

		_bikeLocalService.addBike(serviceContext.getUserId(), bikeName, brand, studentId, serviceContext);
	}

}
