package ca.ubc.cs.cpsc210.mindthegap.tests.model;

import ca.ubc.cs.cpsc210.mindthegap.model.Arrival;
import ca.ubc.cs.cpsc210.mindthegap.model.Line;
import ca.ubc.cs.cpsc210.mindthegap.model.LineResourceData;
import ca.ubc.cs.cpsc210.mindthegap.model.Station;
import ca.ubc.cs.cpsc210.mindthegap.model.exception.ArrivalException;
import ca.ubc.cs.cpsc210.mindthegap.util.LatLon;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * Unit tests for Station
 */
public class StationTest {

    @Test
    public void testAddArrivalOK() {
        LatLon location = new LatLon(1,1);
        Station stn = new Station("jason", "Jason", location);
        Line line1 = new Line(LineResourceData.CENTRAL, "central", "central");
        Line line2 = new Line(LineResourceData.PICCADILLY, "piccadilly", "piccadilly");
        Arrival arrival1 = new Arrival(50, "Oxford", "Westbound - Platform 1");
        Arrival arrival2 = new Arrival(50, "Oxford", "Eastbound - Platform 2");
        Arrival arrival3 = new Arrival(50, "London", "Westbound - Platform 3");

        stn.addLine(line1);
        assertTrue(stn.hasLine(line1));
        stn.addLine(line2);
        assertTrue(stn.hasLine(line2));
        try {
            stn.addArrival(line1, arrival1);
            assertEquals(stn.getNumArrivalBoards(), 1);
            stn.addArrival(line1, arrival2);
            assertEquals(stn.getNumArrivalBoards(), 2);
            stn.addArrival(line1, arrival3);
            assertEquals(stn.getNumArrivalBoards(), 2);
        } catch (ArrivalException e) {
            System.out.println("Arrival Exception caught");
        }
    }

    @Test (expected = ArrivalException.class)
    public void testAddArrivalException() throws ArrivalException {
        LatLon location = new LatLon(1,1);
        Station stn = new Station("jason", "Jason", location);
        Line line1 = new Line(LineResourceData.CENTRAL, "central", "central");
        Arrival arrival1 = new Arrival(50, "Oxford", "Westbound - Platform 1");
        stn.addArrival(line1, arrival1);
    }
}