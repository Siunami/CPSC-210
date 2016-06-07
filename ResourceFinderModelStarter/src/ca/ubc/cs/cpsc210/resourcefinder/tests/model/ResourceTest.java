package ca.ubc.cs.cpsc210.resourcefinder.tests.model;

import ca.ubc.cs.cpsc210.resourcefinder.model.Resource;
import ca.ubc.cs.cpsc210.resourcefinder.model.Service;
import org.junit.Before;
import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

import static org.junit.Assert.*;

// unit tests for Resource class
public class ResourceTest {
    private Resource testResource;

    @Before
    public void runBefore() {
        testResource = new Resource("Family Services", null);
    }

    @Test
    public void testXXXXXX() {
        // template for unit tests
    }

    @Test
    public void testConstructor() {
        Set<Service> services = new HashSet<Service>();
        assertEquals(testResource.getName(), "Family Services");
        assertEquals(testResource.getContactInfo(), null);
        assertEquals(testResource.getServices(), services);
    }

    @Test
    public void testOffersService() {
        testResource.addService(Service.COUNSELLING);
        assertFalse(testResource.offersService(Service.FOOD));
        assertTrue(testResource.offersService(Service.COUNSELLING));
    }

    @Test
    public void testOffersAllService() {
        Set<Service> requestedServices = new HashSet<Service>();

        testResource.addService(Service.COUNSELLING);
        testResource.addService(Service.FOOD);

        assertTrue(testResource.offersAllServicesInSet(requestedServices));

        requestedServices.add(Service.FOOD);
        assertTrue(testResource.offersAllServicesInSet(requestedServices));

        requestedServices.add(Service.LEGAL);
        assertFalse(testResource.offersAllServicesInSet(requestedServices));
    }

    @Test
    public void testOffersAnyService() {
        Set<Service> requestedServices = new HashSet<Service>();

        testResource.addService(Service.COUNSELLING);
        testResource.addService(Service.FOOD);

        assertFalse(testResource.offersAnyServicesInSet(requestedServices));

        requestedServices.add(Service.FOOD);
        assertTrue(testResource.offersAnyServicesInSet(requestedServices));

        requestedServices.add(Service.LEGAL);
        assertTrue(testResource.offersAnyServicesInSet(requestedServices));

        requestedServices.remove(Service.FOOD);
        assertFalse(testResource.offersAnyServicesInSet(requestedServices));
    }

    @Test
    public void testAddService() {
        assertFalse(testResource.offersService(Service.FOOD));
        testResource.addService(Service.FOOD);
        assertTrue(testResource.offersService(Service.FOOD));
    }

    @Test
    public void testRemoveService() {
        testResource.addService(Service.FOOD);
        assertTrue(testResource.offersService(Service.FOOD));
        testResource.removeService(Service.FOOD);
        assertFalse(testResource.offersService(Service.FOOD));
    }
}