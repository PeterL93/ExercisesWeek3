/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package peter.exercise1.quotes;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.util.HashMap;
import java.util.Map;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.MediaType;
import peter.exercise1.jsonmappers.Quote;

/**
 * REST Web Service
 *
 * @author Peter
 */
@Path("quote")
public class QuoteResource {

    @Context
    private UriInfo context;

    private static Gson gson = new GsonBuilder().setPrettyPrinting().create();
    private static int nextId = 0;

    // Map has to be static so it can be implemented on it's own
    private static Map<Integer, Quote> quotes = new HashMap() {
        {
            put(1, "Friends are kisses blown to us by angels");
            put(2, "Do not take life too seriously. You will never get out of it alive");
            put(3, "Behind every great man, is a woman rolling her eyes");
        }
    };

    /**
     * Creates a new instance of Quote
     */
    public QuoteResource() {
    }

    /**
     * Retrieves representation of an instance of
     * peter.exercise1.quotes.QuoteResource
     *
     * @return an instance of java.lang.String
     */
    @GET
    @Path("all")
    @Produces(MediaType.APPLICATION_JSON)
    public String getAll() {
        return gson.toJson(quotes.values());
    }

    @GET
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public String getQuote(@PathParam("id") int id) {
        Quote q = quotes.get(id);
        return gson.toJson(q);
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public String postQuote(String quoteAsJson) {
        Quote q = gson.fromJson(quoteAsJson, Quote.class);
        q.setId(nextId);

        quotes.put(nextId, q);
        nextId++;
        return gson.toJson(q);
    }

    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public String updateJson(String quoteAsJson) {
        Quote q = gson.fromJson(quoteAsJson, Quote.class);
        quotes.put(q.getId(), q);
        return gson.toJson(q);
    }

    @DELETE
    @Produces(MediaType.APPLICATION_JSON)
    @Path("{id}")
    public String deleteQuote(@PathParam("id") int id) {
        return gson.toJson(quotes.remove(id));
    }
}
