package ca.ubc.cs.cpsc210.mindthegap.parsers;


import ca.ubc.cs.cpsc210.mindthegap.util.LatLon;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

/**
 * Parser for branch strings in TfL line data
 */
public class BranchStringParser {

    /**
     * Parse a branch string obtained from TFL
     *
     * @param branch  branch string
     * @return       list of lat/lon points parsed from branch string
     */
        public static List<LatLon> parseBranch(String branch) {
            String[] lonLatArray = branch.split("\\],\\[");
            List<LatLon> latLonArray = new ArrayList<LatLon>();
            for (String s : lonLatArray) {
                s = s.replace("[", "");
                s = s.replace("]", "");
                if (s.contains(",")) {
                    LatLon latLon = new LatLon(Double.parseDouble(s.split(",")[1]), Double.parseDouble(s.split(",")[0]));
                    latLonArray.add(latLon);
                }
            }
            return latLonArray;
    }
}
