package ca.ubc.cs.cpsc210.resourcefinder.tests.model;

import ca.ubc.cs.cpsc210.resourcefinder.model.Resource;
import ca.ubc.cs.cpsc210.resourcefinder.model.ResourceRegistry;
import ca.ubc.cs.cpsc210.resourcefinder.model.Service;
import org.junit.Before;
import org.junit.Test;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

// unit tests for ResourceRegistry class
public class ResourceRegistryTest {
    private ResourceRegistry testRegistry;
    private Resource r1;
    private Resource r2;
    private Resource r3;
    private Resource r4;

    @Before
    public void runBefore() {
        testRegistry = new ResourceRegistry();
        r1 = new Resource("Res 1", null);
        r2 = new Resource("Res 2", null);
        r3 = new Resource("Res 3", null);
        r4 = new Resource("Res 4", null);
    }

    @Test
    public void testXXXXXX() {
        // template for unit tests
    }

    @Test
    public void testAddOneResource() {
        testRegistry.addResource(r1);
        List<Resource> resources = testRegistry.getResources();
        assertEquals(1, resources.size());
        assertTrue(resources.contains(r1));
    }

    @Test
    public void testAddManyResources() {
        loadResources();
        List<Resource> resources = testRegistry.getResources();
        assertEquals(4, resources.size());
        assertTrue(resources.contains(r1));
        assertTrue(resources.contains(r2));
        assertTrue(resources.contains(r3));
        assertTrue(resources.contains(r4));
    }

    @Test
    public void testGetResourcesOfferingFood() {
        loadResources();
        Set<Resource> resources = testRegistry.getResourcesOfferingService(Service.FOOD);
        assertEquals(3, resources.size());
        assertTrue(resources.contains(r1));
        assertTrue(resources.contains(r2));
        assertTrue(resources.contains(r4));
    }

    @Test
    public void testGetResourcesOfferingSenior() {
        loadResources();
        Set<Resource> resources = testRegistry.getResourcesOfferingService(Service.SENIOR);
        assertEquals(1, resources.size());
        assertTrue(resources.contains(r3));
    }

    @Test
    public void testGetResourcesOfferingAllServices() {
        loadResources();
        Set<Service> services = new HashSet<Service>();
        services.add(Service.FOOD);
        services.add(Service.SHELTER);


        Set<Resource> resources = testRegistry.getResourcesOfferingAllServicesInSet(services);
        assertEquals(2, resources.size());
        assertTrue(resources.contains(r1));
        assertTrue(resources.contains(r4));
    }

    @Test
    public void testGetResourcesOfferingAnyServices() {
        loadResources();
        Set<Service> services = new HashSet<Service>();
        services.add(Service.FOOD);
        services.add(Service.SENIOR);


        Set<Resource> resources = testRegistry.getResourcesOfferingAnyServicesInSet(services);
        assertEquals(4, resources.size());
        assertTrue(resources.contains(r1));
        assertTrue(resources.contains(r2));
        assertTrue(resources.contains(r3));
        assertTrue(resources.contains(r4));
    }

    // MODIFIES: this
    // EFFECTS:  adds services to resources and resources to registry
    private void loadResources() {
        r1.addService(Service.FOOD);
        r1.addService(Service.SHELTER);
        r2.addService(Service.YOUTH);
        r2.addService(Service.FOOD);
        r3.addService(Service.SENIOR);
        r4.addService(Service.SHELTER);
        r4.addService(Service.FOOD);
        r4.addService(Service.LEGAL);

        testRegistry.addResource(r1);
        testRegistry.addResource(r2);
        testRegistry.addResource(r3);
        testRegistry.addResource(r4);
    }
}