package com.codebauhaus.portlet;

import java.util.Date;
import java.util.List;

import com.commsen.liferay.examples.portlet.servicebuilder.model.Player;
import com.commsen.liferay.examples.portlet.servicebuilder.service.PlayerLocalServiceUtil;
import com.liferay.portal.service.persistence.BasePersistenceTestCase;

public class PlayerLocalServiceIntegrationTest extends BasePersistenceTestCase {
	
	protected void setUp() throws Exception {
		super.setUp();

	}

	public void testCreate() throws Exception {
		PlayerLocalServiceUtil.addPlayer("my player", true , 3, new Date(), "this player");
		
		List<Player> players = PlayerLocalServiceUtil.getAllPlayers();
		
		assertTrue(players.size() > 0);
	}

}