package ca.ubc.cs.cpsc210.mindthegap.tests.model;

import ca.ubc.cs.cpsc210.mindthegap.model.*;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * Unit tests for ArrivalBoard
 */
public class ArrivalBoardTest {

    @Test
    public void testGeneral() {
        Arrival a1 = new Arrival(100, "London", "Eastbound - Platform 1");
        Arrival a2 = new Arrival(200, "London", "Eastbound - Platform 1");
        Arrival a3 = new Arrival(300, "Oxford", "Eastbound - Platform 1");
        Arrival a4 = new Arrival(400, "Oxford", "Eastbound - Platform 1");
        Line line = new Line (LineResourceData.BAKERLOO, "01", "Central");
        ArrivalBoard ab = new ArrivalBoard(line, "Eastbound");

        ab.addArrival(a2);
        ab.addArrival(a1);
        ab.addArrival(a4);
        ab.addArrival(a3);
        assertEquals(4, ab.getNumArrivals());
        Iterator i = ab.iterator();

        ab.clearArrivals();
        assertEquals(0, ab.getNumArrivals());
    }

    @Test
    public void testEquals() {
        Line line1 = new Line (LineResourceData.BAKERLOO, "01", "BakerLoo");
        Line line2 = new Line (LineResourceData.CENTRAL, "02", "Central");
        ArrivalBoard ab1 = new ArrivalBoard(line1, "Eastbound");
        ArrivalBoard ab2 = new ArrivalBoard(line1, "Eastbound");
        ArrivalBoard ab3 = new ArrivalBoard(line1, "Westbound");
        ArrivalBoard ab4 = new ArrivalBoard(line2, "Westbound");

        assertTrue(ab1.equals(ab2));
        assertFalse(ab1.equals(ab3));
        assertFalse(ab3.equals(ab4));
    }
}