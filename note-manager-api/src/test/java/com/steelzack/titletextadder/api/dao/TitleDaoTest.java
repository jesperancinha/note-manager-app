package com.steelzack.titletextadder.api.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.jmock.Expectations;
import org.jmock.Mockery;
import org.junit.Assert;
import org.junit.Test;

public class TitleDaoTest {

	final Mockery mock = new Mockery();

	@Test
	public void testOpenCurrentSession() throws Exception {
		final SessionFactory mockCurrentSession = mock.mock(SessionFactory.class);
		final Session mockSession = mock.mock(Session.class);
		final TitleDao titleDao = new TitleDao(){
			@Override
			protected SessionFactory getSessionFactory() {
				return mockCurrentSession;
			}
		};

		mock.checking(new Expectations(){{
			oneOf(mockCurrentSession).openSession();
			will(returnValue(mockSession));
		}});
		
		final Session currentSession = titleDao.openCurrentSession();
	
		Assert.assertSame(mockSession, currentSession);
	}

}
