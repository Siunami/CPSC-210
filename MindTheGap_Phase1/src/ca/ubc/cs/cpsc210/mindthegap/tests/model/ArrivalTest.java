package ca.ubc.cs.cpsc210.mindthegap.tests.model;

import ca.ubc.cs.cpsc210.mindthegap.model.Arrival;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Unit tests for Arrival
 */
public class ArrivalTest {

    @Test
    public void testTravelDirectionWest () {
        Arrival a = new Arrival(120, "Ealing Broadway Underground Station", "Westbound - Platform 1");
        assertEquals(a.getTravelDirn(), "Westbound");
    }

    @Test
    public void testTravelDirectionUnknown () {
        Arrival a = new Arrival(120, "Ealing Broadway Underground Station", "Platform 1");
        assertEquals(a.getTravelDirn(), "Unknown direction");
    }

    @Test
    public void testPlatformNameWithDirection () {
        Arrival a = new Arrival(120, "Ealing Broadway Underground Station", "Westbound - Platform 1");
        assertEquals(a.getPlatformName(), "Platform 1");
    }

    @Test
    public void testPlatformNameNoDirection () {
        Arrival a = new Arrival(120, "Ealing Broadway Underground Station", "Platform 1");
        assertEquals(a.getPlatformName(), "Platform 1");
    }

    @Test
    public void testTimeinMinsExact () {
        Arrival a = new Arrival(120, "Ealing Broadway Underground Station", "Platform 1");
        assertEquals(a.getTimeToStationInMins(), 2);
    }

    @Test
    public void testTimeinMinsRoundUp () {
        Arrival a = new Arrival(121, "Ealing Broadway Underground Station", "Platform 1");
        assertEquals(a.getTimeToStationInMins(), 3);
    }
}