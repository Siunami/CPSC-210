package ca.ubc.cs.cpsc210.mindthegap.tests.model;

import ca.ubc.cs.cpsc210.mindthegap.model.Branch;
import ca.ubc.cs.cpsc210.mindthegap.util.LatLon;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * Unit tests for Branch
 */
public class BranchTest {

    @Test
    public void testBranch() {
        String lineString = "[[[0.093493,51.6037],[0.092077,51.6134],[0.075051,51.6179],[0.043657,51.6172],[0.03398,51.6069],[0.027347,51.5919],[0.021449,51.5807],[0.008202,51.5683],[-0.005515,51.5566],[-0.00345,51.5418],[-0.033633,51.5251],[-0.0555,51.5272],[-0.083176,51.5174],[-0.088948,51.5134],[-0.097562,51.5149],[-0.111578,51.5183],[-0.12047,51.5176],[-0.130406,51.5164],[-0.141899,51.5152],[-0.149719,51.5143],[-0.15895,51.5134],[-0.175491,51.5117],[-0.187149,51.5103],[-0.196102,51.5091],[-0.205677,51.5071],[-0.218812,51.5044],[-0.224295,51.512],[-0.247248,51.5166],[-0.259754,51.5235],[-0.28098,51.518],[-0.301457,51.515]]]";
        Branch b = new Branch(lineString);
        List<LatLon> listLatLon = new ArrayList<>(b.getPoints());
        for (LatLon ll: listLatLon) {
            System.out.println(ll.getLatitude());
            System.out.println(ll.getLongitude());
        }
    }

    @Test
    public void testEquals() {
        String lineString1 = "[[[1,1],[2,2],[3,3],[4,4]]]";
        String lineString2 = "[1,2],[3,5]";
        Branch b1 = new Branch(lineString1);
        Branch b2 = new Branch(lineString1);
        Branch b3 = new Branch(lineString2);

        assertTrue(b1.equals(b2));
        assertFalse(b1.equals(b3));
    }
}