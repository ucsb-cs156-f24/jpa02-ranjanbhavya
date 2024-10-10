package edu.ucsb.cs156.spring.hello;

import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TeamTest {

    Team team;

    @BeforeEach
    public void setup() {
        team = new Team("test-team");    
    }

    @Test
    public void getName_returns_correct_name() {
       assert(team.getName().equals("test-team"));
    }

    @Test
    public void toString_returns_correct_string() {
        assertEquals("Team(name=test-team, members=[])", team.toString());
    }

    @Test
    public void test_hashcode() {
        Team t = new Team("test15-team");
        int result = t.hashCode();
        int expectedResult = 43214741;
        assertEquals(expectedResult, result);
    }

    // case 1 test
    @Test
    public void testEqualsSameObject() {
        Team t = new Team("test-team");
        t.addMember("Alice");
        t.addMember("Bob");
        assert(t.equals(t));  
    }
    
    
    // case 2 test
    @Test
    public void testEqualsDifferentClass() {
        Team t = new Team("test-team");
        t.addMember("Alice");
        t.addMember("Bob");
        String falseTeam = "false team";
        assertNotEquals(team, falseTeam);  
    }


    // case 3 test (T,T)
    @Test
    public void testEqualsBothFieldsEqual() {
        Team t1 = new Team("test-team");
        t1.addMember("Alice");
        t1.addMember("Bob");
        Team t2 = new Team("test-team");
        t2.addMember("Alice");
        t2.addMember("Bob");
        assert(t1.equals(t2));  
    }


    // case 3 test (T,F)
    @Test
    public void testEqualsNameEqualMembersDifferent() {
        Team t1 = new Team("test-team");
        t1.addMember("Alice");
        t1.addMember("Bob");
        Team t2 = new Team("test-team");
        t2.addMember("Alice");
        t2.addMember("Jake");
        assertNotEquals(t1, t2);  
    }

    // case 3 test (F,T)
    @Test
    public void testEqualsNameDifferentMembersEqual() {
        Team t1 = new Team("test-team1");
        t1.addMember("Alice");
        t1.addMember("Bob");
        Team t2 = new Team("test-team2");
        t2.addMember("Alice");
        t2.addMember("Bob");
        assertNotEquals(t1, t2);  
    }

    // case 4 test (F,F)
    @Test
    public void testEqualsBothFieldsDifferent() {
        Team t1 = new Team("test-team1");
        t1.addMember("Alice");
        t1.addMember("Bob");
        Team t2 = new Team("test-team2");
        t2.addMember("Alice");
        t2.addMember("Jake");
        assertNotEquals(t1, t2);  
    }
   
   // test hash code equals
    @Test
    public void testHashCodeConsistency() {
        Team t1 = new Team("test-team");
        t1.addMember("Alice");
        t1.addMember("Bob");
        Team t2 = new Team("test-team");
        t2.addMember("Alice");
        t2.addMember("Bob");
        assertEquals(t1.hashCode(), t2.hashCode()); 
    }

    // test hash code not equal
    @Test
    public void testHashCodeUnequalObjects() {
        Team t1 = new Team("test-team");
        t1.addMember("Alice");
        t1.addMember("Bob");
        Team t2 = new Team("test-team");
        t2.addMember("Alice");
        t2.addMember("Jake");
        assertNotEquals(t1.hashCode(), t2.hashCode()); 
    }

}
