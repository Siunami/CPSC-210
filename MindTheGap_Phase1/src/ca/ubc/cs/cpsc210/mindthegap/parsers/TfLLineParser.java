package ca.ubc.cs.cpsc210.mindthegap.parsers;

import ca.ubc.cs.cpsc210.mindthegap.model.*;
import ca.ubc.cs.cpsc210.mindthegap.parsers.exception.TfLLineDataMissingException;
import ca.ubc.cs.cpsc210.mindthegap.util.LatLon;

import javax.json.*;
import javax.xml.bind.util.JAXBSource;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.List;

/**
 * A parser for the data returned by TFL line route query
 */
public class TfLLineParser extends TfLAbstractParser {

    /**
     * Parse line from JSON response produced by TfL.
     *
     * @param lmd              line meta-data
     * @return                 line parsed from TfL data
     * @throws JsonException   when JSON data does not have expected format
     * @throws TfLLineDataMissingException when
     * <ul>
     *  <li> JSON data is missing lineName, lineId or stopPointSequences elements </li>
     *  <li> or, for a given sequence: </li>
     *    <ul>
     *      <li> the stopPoint array is missing, or </li>
     *      <li> all station elements are missing one of name, lat, lon or stationId elements </li>
     *    </ul>
     * </ul>
     */
    public static Line parseLine(LineResourceData lmd, String jsonResponse)
            throws JsonException, TfLLineDataMissingException {

        JsonReader reader = Json.createReader(new StringReader(jsonResponse));
        JsonObject rootJSON = reader.readObject();
        reader.close();

        StationManager.getInstance();

        if (!rootJSON.containsKey("lineId") || !rootJSON.containsKey("lineName") || !rootJSON.containsKey("stopPointSequences")) {
            throw new TfLLineDataMissingException();
        }

        String lineId, lineName;

            lineId = rootJSON.getString("lineId");
            lineName = rootJSON.getString("lineName");


        Line line = new Line(lmd, lineId, lineName);

        line = parseLineString(rootJSON, line);

        line = parseStopPointSequences(rootJSON, line);

        StationManager.getInstance().addStationsOnLine(line);
        return line;
    }

    private static Line parseStopPointSequences(JsonObject rootJSON, Line line) throws TfLLineDataMissingException {

        JsonArray stopPointSequences;

            stopPointSequences = rootJSON.getJsonArray("stopPointSequences");


        for (int indexSPS = 0; indexSPS < stopPointSequences.size(); indexSPS++) {
            JsonObject stopPointSequence;

                stopPointSequence = stopPointSequences.getJsonObject(indexSPS);


            if (!stopPointSequence.containsKey("stopPoint")) {
                throw new TfLLineDataMissingException();
            }

            JsonArray stopPoints;

                stopPoints = stopPointSequence.getJsonArray("stopPoint");


            for (int indexSP = 0; indexSP < stopPoints.size(); indexSP++) {
                int stationCounter = 0;

                JsonObject stopPoint;
                stopPoint = stopPoints.getJsonObject(indexSP);

                if (stopPoint.containsKey("stationId") && stopPoint.containsKey("name") &&
                        stopPoint.containsKey("lat") && stopPoint.containsKey("lon")) {

                    stationCounter ++;
                    String stationId = stopPoint.getString("stationId");
                    String name = TfLAbstractParser.parseName(stopPoint.getString("name"));
                    Double lat = stopPoint.getJsonNumber("lat").doubleValue();
                    Double lon = stopPoint.getJsonNumber("lon").doubleValue();
                    LatLon locn = new LatLon(lat, lon);
                    Station station = new Station(stationId, name, locn);

                    if (StationManager.getInstance().getStationWithId(stationId) == null) {
                        line.addStation(station);
                    } else {
                        StationManager.getInstance().getStationWithId(stationId).addLine(line);
                    }

                }

                if (stationCounter == 0) {
                    throw new TfLLineDataMissingException();
                }
            }
        }
        return line;
    }

    private static Line parseLineString(JsonObject rootJSON, Line line) {

            JsonArray lineStrings = rootJSON.getJsonArray("lineStrings");
            for (int index = 0; index < lineStrings.size(); index++) {
                Branch branch = new Branch(lineStrings.getString(index));
                line.addBranch(branch);
            }
            return line;

    }
}
