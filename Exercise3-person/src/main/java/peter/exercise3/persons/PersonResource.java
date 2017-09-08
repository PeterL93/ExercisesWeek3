 package peter.exercise3.persons;

import peter.exercise3.jsonmappers.Person;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.util.HashMap;
import java.util.Map;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;

@Path("person")
public class PersonResource {

    @Context
    private UriInfo context;

    private static Gson gson = new GsonBuilder().setPrettyPrinting().create();
    private static Map<Integer, Person> persons = new HashMap();
    private static int nextId = 0;

    public PersonResource() {
        if (persons.isEmpty()) {
            persons.put(nextId, new Person("Kurt", "Wonnegut", 2345, nextId));
            nextId++;
        }
    }

    @GET
    @Path("all")
    @Produces(MediaType.APPLICATION_JSON)
    public String getAll() {
        return gson.toJson(persons.values());
    }

    @GET
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public String getPerson(@PathParam("id") int id) {
        if (id < 0) {
            Response.status(Response.Status.NOT_FOUND);
        }
        Person p = persons.get(id);
        return gson.toJson(p);
    }

    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public String updatePerson(String personAsJson) {
        Person p = gson.fromJson(personAsJson, Person.class);
        persons.put(p.getId(), p);
        return gson.toJson(p);
    }

    @DELETE
    @Produces(MediaType.APPLICATION_JSON)
    @Path("{id}")
    public String deletePerson(@PathParam("id") int id) {
        return gson.toJson(persons.remove(id));
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public String putPerson(String personAsJson) {
        Person p = gson.fromJson(personAsJson, Person.class);
        p.setId(nextId);

        persons.put(nextId, p);
        nextId++;
        return gson.toJson(p);
    }
}
