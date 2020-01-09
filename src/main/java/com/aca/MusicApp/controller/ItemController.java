package com.aca.MusicApp.controller;

import java.util.List;

import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import itemService.itemService;
import model.item;

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
	
	@PUT
	@Produces(MediaType.APPLICATION_JSON)
	public List<item> update(item updateItem) {
		return service.updateItem(updateItem);

	}

}
