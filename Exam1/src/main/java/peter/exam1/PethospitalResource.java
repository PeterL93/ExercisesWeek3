package peter.exam1;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.util.HashMap;
import java.util.Map;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Consumes;
import javax.ws.rs.Produces;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.core.MediaType;
import peter.exam1.Entity.Pet;

/**
 * REST Web Service
 *
 * @author Peter
 */
@Path("pethospital")
public class PethospitalResource {

    @Context
    private UriInfo context;

    private Pet pet = new Pet();
    private static Gson gson = new GsonBuilder().setPrettyPrinting().create();
    private static Map<Integer, Pet> pets = new HashMap();
    private static int nextId = 0;

    /**
     * Creates a new instance of GenericResource
     */
    public PethospitalResource() {

    }

    /**
     * Retrieves representation of an instance of
     * peter.exam1.PethospitalResource
     *
     * @return an instance of java.lang.String
     */
    @GET
    @Path("all")
    @Produces(MediaType.APPLICATION_JSON)
    public String getAll() {
        return gson.toJson(pets.values());
    }

    /**
     * PUT method for updating or creating an instance of PethospitalResource
     *
     * @param content representation for the resource
     */
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public void putJson(String content) {
    }
}
