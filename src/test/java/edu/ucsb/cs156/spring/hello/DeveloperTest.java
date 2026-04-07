package edu.ucsb.cs156.spring.hello;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.lang.reflect.Constructor;
import java.lang.reflect.Modifier;

import org.junit.jupiter.api.Test;

public class DeveloperTest {

    @Test
    public void testPrivateConstructor() throws Exception {
        // this hack is from https://www.timomeinen.de/2013/10/test-for-private-constructor-to-get-full-code-coverage/
        Constructor<Developer> constructor = Developer.class.getDeclaredConstructor();
        assertTrue(Modifier.isPrivate(constructor.getModifiers()),"Constructor is not private");

        constructor.setAccessible(true);
        constructor.newInstance();
    }

    @Test
    public void getName_returns_correct_name() {
        // TODO: Replace Chris G. with your name as shown on
        // <https://bit.ly/cs156-s26-teams>
        assertEquals("David Chang", Developer.getName());
    }

    // TODO: Add additional tests as needed to get to 100% jacoco line coverage, and
    // 100% mutation coverage (all mutants timed out or killed)
    @Test // Checks Git Hub ID is correct
    public void getGithubId_returns_correct_github_id() {
        assertEquals("dcbang747", Developer.getGithubId());
    }
    @Test // Checks team is correct
    public void getTeam_returns_correct_team() {
        Team team = Developer.getTeam();
        assertEquals("s26-07", team.getName());
        assertTrue(team.getMembers().contains("EMERSON JIANYI"));
        assertTrue(team.getMembers().contains("RAYMOND"));
        assertTrue(team.getMembers().contains("WYATT"));
        assertTrue(team.getMembers().contains("DAVID HOING"));
        assertTrue(team.getMembers().contains("ALEXANDER"));
        assertTrue(team.getMembers().contains("ANDREW"));
        assertTrue(team.getMembers().contains("HANSON"));
    }
}
