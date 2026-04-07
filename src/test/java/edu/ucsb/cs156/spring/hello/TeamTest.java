package edu.ucsb.cs156.spring.hello;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TeamTest {

    Team team;
    Team teamcompare;
    Team t; // for hash code test

    @BeforeEach
    public void setup() {
        team = new Team("test-team");    
        teamcompare = new Team("teamcompare");
        t = new Team("hashteam");
    }

    @Test
    public void getName_returns_correct_name() {
       assert(team.getName().equals("test-team"));
    }

   
    // TODO: Add additional tests as needed to get to 100% jacoco line coverage, and
    // 100% mutation coverage (all mutants timed out or killed)
    @Test // Checks ToString is correct
    public void toString_returns_correct_string() { 
        String expected = "Team(name=test-team, members=[])";
        assertEquals(expected, team.toString());
    }

    @Test // checks equals override is correct
    public void equals_returns_true_for_equal_teams() { 
        // Case 1: same object
        assertEquals(team, team);
        // Case 2: different class
        assert(!team.equals("not a team"));
        // Case 3: different name same members
        assert(!team.equals(teamcompare));
        // Case 4: different name, different members
        teamcompare.addMember("member1");
        assert(!team.equals(teamcompare));
        // Case 5: same name, different members
        teamcompare.setName("test-team");
        assert(!team.equals(teamcompare));
        // Case 6: same name, same members
        team.addMember("member1");
        assertEquals(team, teamcompare);
    }
    @Test // checks hash code function is correct
    public void hashCode_returns_same_hash_code_for_equal_teams() {
        Team t1 = new Team();
        t1.setName("foo");
        t1.addMember("bar");
        Team t2 = new Team();
        t2.setName("foo");
        t2.addMember("bar");
        assertEquals(t1.hashCode(), t2.hashCode());
        
        int result = t.hashCode();
        int expectedResult = 149146731;
        assertEquals(expectedResult, result);
    }
}
