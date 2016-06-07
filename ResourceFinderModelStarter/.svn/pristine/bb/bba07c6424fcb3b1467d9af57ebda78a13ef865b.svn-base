package ca.ubc.cs.cpsc210.resourcefinder.tests.model;

import ca.ubc.cs.cpsc210.resourcefinder.model.Resource;
import ca.ubc.cs.cpsc210.resourcefinder.model.ResourceRegistry;
import ca.ubc.cs.cpsc210.resourcefinder.model.SelectionState;
import ca.ubc.cs.cpsc210.resourcefinder.model.Service;
import org.junit.Before;
import org.junit.Test;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

// unit tests for SelectionState class
public class SelectionStateTest {
    private SelectionState testSelectionState;
    private ResourceRegistry registry;
    private Resource r1;
    private Resource r2;
    private Resource r3;
    private Resource r4;

    @Before
    public void runBefore() {
        registry = new ResourceRegistry();
        loadResources();

        testSelectionState = new SelectionState(registry);
    }

    @Test
    public void testResourcesWithNoSelected() {
        testSelectionState.setSelectAny();
        Set<Resource> resources = testSelectionState.getResourcesWithSelectedServices();
        assertEquals(4, resources.size());
        assertTrue(resources.contains(r1));
        assertTrue(resources.contains(r2));
        assertTrue(resources.contains(r3));
        assertTrue(resources.contains(r4));
    }


    @Test
    public void testResourcesWithAnyServices() {
        testSelectionState.setSelectAny();
        testSelectionState.selectService(Service.FOOD);
        testSelectionState.selectService(Service.COUNSELLING);

        Set<Resource> resources = testSelectionState.getResourcesWithSelectedServices();
        assertEquals(4, resources.size());
        assertTrue(resources.contains(r1));
        assertTrue(resources.contains(r2));
        assertTrue(resources.contains(r3));
        assertTrue(resources.contains(r4));

        testSelectionState.deselectService(Service.FOOD);
        resources = testSelectionState.getResourcesWithSelectedServices();
        assertEquals(1, resources.size());
        assertTrue(resources.contains(r3));
    }

    @Test
    public void testResourcesWithAllServices() {
        testSelectionState.setSelectAll();
        Set<Service> services = new HashSet<Service>();
        services.add(Service.SHELTER);
        services.add(Service.LEGAL);
        testSelectionState.setSelectedServices(services);

        Set<Resource> resources = testSelectionState.getResourcesWithSelectedServices();
        assertEquals(1, resources.size());
        assertTrue(resources.contains(r4));

        testSelectionState.deselectService(Service.LEGAL);
        resources = testSelectionState.getResourcesWithSelectedServices();
        assertEquals(2, resources.size());
        assertTrue(resources.contains(r1));
        assertTrue(resources.contains(r4));
    }

    // MODIFIES: this
    // EFFECTS:  adds services to resources and resources to resource registry
    private void loadResources() {
        r1 = new Resource("Res 1", null);
        r2 = new Resource("Res 2", null);
        r3 = new Resource("Res 3", null);
        r4 = new Resource("Res 4", null);

        r1.addService(Service.FOOD);
        r1.addService(Service.SHELTER);
        r2.addService(Service.YOUTH);
        r2.addService(Service.FOOD);
        r3.addService(Service.SENIOR);
        r3.addService(Service.COUNSELLING);
        r4.addService(Service.SHELTER);
        r4.addService(Service.FOOD);
        r4.addService(Service.LEGAL);

        registry.addResource(r1);
        registry.addResource(r2);
        registry.addResource(r3);
        registry.addResource(r4);
    }
}