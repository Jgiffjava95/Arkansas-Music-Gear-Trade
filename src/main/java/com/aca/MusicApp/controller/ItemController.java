package com.aca.MusicApp.controller;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import itemService.itemService;
import model.EmailMessage;
import model.item;
import model.Message;

@Path("/item")
public class ItemController {
	
	private itemService service = new itemService();
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<item> getAllItems() {
		return service.getAllItems();
	}
/*	
	@GET
	@Path("/getById/{value}")
	@Produces(MediaType.APPLICATION_JSON)
	public List<item> getById(@PathParam("value") int itemId) {
		return service.getById(itemId);
	}
	
	@GET
	@Path("/getByCategory/{value}")
	@Produces(MediaType.APPLICATION_JSON)
	public List<item> getByCategory(@PathParam("value") String itemCat) {
		return service.getByCategory(itemCat);
	}
*/	
	@DELETE
	@Path("/removeItem/{value}")
	@Produces(MediaType.APPLICATION_JSON)
	public List<item> deleteItem(@PathParam("value") int itemId) {
		System.out.println("Item Deleted: " + itemId);
		return service.deleteItem(itemId);		
	}

	@POST
	@Produces(MediaType.APPLICATION_JSON) 
	public List<item> insert(item newItem) { 
		return service.insert(newItem);		
	}
	
	@POST	
	@Path("/email")
	@Consumes({MediaType.APPLICATION_JSON})
	@Produces({MediaType.APPLICATION_JSON})
	public Response sendEmail(EmailMessage emailMessage) {		
		itemService service = new itemService();
		String result = service.sendEmail(emailMessage);
		
		Message message = new Message();
		message.setMessage(result);
		
		return Response.status(200).entity(message).build();
	}
	
	@PUT
	@Produces(MediaType.APPLICATION_JSON)
	public List<item> update(item updateItem) {
		return service.updateItem(updateItem);

	}

}
