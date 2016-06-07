package ca.ubc.cs.cpsc210.invoicemanager.model;

/**
 * Created by JASON on 2/29/2016.
 */
public class DiscountServiceRecord extends AbstractServiceRecord {
    public static int DISC_CALLOUT = 0;
    public static int DISC_SERVICE_HOURLY = 80;
    public static int DISC_SERVICEPTS_BASE = 0;
    public static int DISC_SERVICEPTS_HOURLY = 0;

    public DiscountServiceRecord(int hours) {
        super(hours, ServiceType.DISCOUNT);
        this.recordID = ++nextRecordID;
        buildInvoice();
    }

    @Override
    public int getServicePoints() {
        int servicePoints = 0;
        servicePoints = DISC_SERVICEPTS_BASE + hours * DISC_SERVICEPTS_HOURLY;
        return servicePoints;
    }

    @Override
    public int getCalloutFee() {
        int calloutFee = 0;
        calloutFee = DISC_CALLOUT;
        return calloutFee;
    }

    @Override
    public int getServiceFee() {
        int serviceFee = 0;
        serviceFee = DISC_SERVICE_HOURLY * hours;
        return serviceFee;
    }
}
