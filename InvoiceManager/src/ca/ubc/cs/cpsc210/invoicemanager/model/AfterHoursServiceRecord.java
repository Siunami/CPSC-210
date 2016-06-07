package ca.ubc.cs.cpsc210.invoicemanager.model;

/**
 * Created by JASON on 2/29/2016.
 */
public class AfterHoursServiceRecord extends AbstractServiceRecord {
    public static int AFTER_HOURS_CALLOUT = 120;
    public static int AFTER_HOURS_SERVICE_HOURLY = 100;
    public static int AFTER_HOURS_SERVICEPTS_BASE = 5;
    public static int AFTER_HOURS_SERVICEPTS_HOURLY = 1;

    public AfterHoursServiceRecord (int hours) {
        super(hours, ServiceType.AFTER_HOURS);
        this.recordID = ++nextRecordID;
        buildInvoice();
    }

    @Override
    public int getServicePoints() {
        int servicePoints = 0;
        servicePoints = AFTER_HOURS_SERVICEPTS_BASE + hours * AFTER_HOURS_SERVICEPTS_HOURLY;
        return servicePoints;
    }

    @Override
    public int getCalloutFee() {
        int calloutFee = 0;
        calloutFee = AFTER_HOURS_CALLOUT;
        return calloutFee;
    }

    @Override
    public int getServiceFee() {
        int serviceFee = 0;
        serviceFee = AFTER_HOURS_SERVICE_HOURLY * hours;
        return serviceFee;
    }
}
