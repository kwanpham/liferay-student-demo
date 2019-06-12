package kwan.org.database.service.persistence.impl;

import com.liferay.portal.dao.orm.custom.sql.CustomSQL;
import com.liferay.portal.kernel.dao.orm.QueryPos;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.SQLQuery;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.spring.extender.service.ServiceReference;

import java.util.List;

import kwan.org.database.model.Student;
import kwan.org.database.model.impl.StudentImpl;
import kwan.org.database.service.persistence.StudentFinder;

public class StudentFinderImpl extends StudentFinderBaseImpl implements StudentFinder {

	@Override
	public List<Student> findByFullName(String fullName) {

		Session session = null;
		try {
			session = openSession();

			String sql = _customSQL.get(getClass(), FIND_BY_FULL_NAME);
			
			SQLQuery q = session.createSQLQuery(sql);
			q.setCacheable(false);
			q.addEntity("Student", StudentImpl.class);

			QueryPos qPos = QueryPos.getInstance(q);
			qPos.add("%"+ fullName + "%");
			
		
			return (List<Student>) QueryUtil.list(q, getDialect(), QueryUtil.ALL_POS, QueryUtil.ALL_POS);
		} catch (Exception e) {
			try {
				throw new SystemException(e);
			} catch (SystemException se) {
				se.printStackTrace();
			}
		} finally {
			closeSession(session);
		}

		return null;
	}

	public static final String FIND_BY_FULL_NAME = StudentFinder.class.getName() + ".findByFullName";

	@ServiceReference(type = CustomSQL.class)
	private CustomSQL _customSQL;
}
