package ca.ubc.cs.cpsc210.resourcefinder.model;


import java.util.*;

// Registry of available resources
        public class ResourceRegistry {
            private List<Resource> resources;

            // EFFECTS: constructs empty resource registry
            public ResourceRegistry() {
                resources = new LinkedList<>();
            }

            // MODIFIES: this
            // EFFECTS: add resource to registry, maintains resources in the order added to registry
            public void addResource(Resource resource) {
                resources.add (resource);
            }

            // EFFECTS: returns resources in registry as unmodifiable list (in order that they were added
            // to registry)
            public List<Resource> getResources() {
        return resources;
    }

    // EFFECTS: returns set of resources in registry that offer the given service
    public Set<Resource> getResourcesOfferingService(Service service) {
        Set<Resource> s = new HashSet <Resource>();
        for (Resource r : resources) {
            if (r.offersService(service)) {
                s.add (r);
            }
        }
        return s;
    }

    // EFFECTS: returns set of resources in registry that offer all the services in requestedServices set
    public Set<Resource> getResourcesOfferingAllServicesInSet(Set<Service> requestedServices) {
        Set<Resource> s = new HashSet <Resource>();
        for (Resource r : resources) {
            if (r.offersAllServicesInSet(requestedServices)) {
                s.add (r);
            }
        }
        return s;
    }

    // EFFECTS: returns set of resources in registry that off any of the services in requestedServices set
    public Set<Resource> getResourcesOfferingAnyServicesInSet(Set<Service> requestedServices) {
        Set<Resource> s = new HashSet <Resource>();
        for (Resource r : resources) {
            if (r.offersAnyServicesInSet(requestedServices)) {
                s.add (r);
            }
        }
        return s;
    }
}
