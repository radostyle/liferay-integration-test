package com.codebauhaus.portlet;

import java.util.Date;
import java.util.List;

import javax.sql.DataSource;

import com.commsen.liferay.examples.portlet.servicebuilder.model.Player;
import com.commsen.liferay.examples.portlet.servicebuilder.service.PlayerLocalServiceUtil;
import com.liferay.portal.kernel.bean.PortalBeanLocatorUtil;
import com.liferay.portal.service.persistence.BasePersistenceTestCase;

public class PlayerLocalServiceIntegrationTest extends BasePersistenceTestCase {
	
	protected void setUp() throws Exception {
		super.setUp();

		DataSource ds = (DataSource)PortalBeanLocatorUtil.locate("liferayDataSource");	
		ds.getConnection().createStatement().execute(
				"CREATE TABLE counter (name varchar(75) NOT NULL,currentId integer DEFAULT NULL,"
						+ "  PRIMARY KEY (name) );");
				ds.getConnection().createStatement().execute(
					"create table SB_Player ( " +
					"	playerId integer , " +
					"	name VARCHAR(75) , " +
					"	active_ BOOLEAN, " +
					"	score INTEGER, " +
					"	birthday DATE , " +
					"	description VARCHAR(75)) "
					);
		
		
	}

	public void testCreate() throws Exception {
		PlayerLocalServiceUtil.addPlayer("my player", true , 3, new Date(), "this player");
		
		List<Player> players = PlayerLocalServiceUtil.getAllPlayers();
		
		assertTrue(players.size() > 0);
	}

}