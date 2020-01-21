package itemService;

import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Response;

public class ErrorResponse {

	public static void invalidDesc() {

		itemError error = new itemError();
		error.setId(100);
		error.setMessage("Description must not exceed 500 characters.");
		Response response = Response.status(400).entity(error).build();

		throw new WebApplicationException(response);

	}

	public static void invalidContact() {

		itemError error = new itemError();
		error.setId(101);
		error.setMessage("Contact Info must not exceed 100 characters.");
		Response response = Response.status(400).entity(error).build();

		throw new WebApplicationException(response);
	}

	public static void invalidName() {

		itemError error = new itemError();
		error.setId(102);
		error.setMessage("Item name must not exceed 75 characters.");
		Response response = Response.status(400).entity(error).build();

		throw new WebApplicationException(response);
	}
	
	public static void invalidCat() {
		itemError error = new itemError();
		error.setId(112);
		error.setMessage("Invalid item category.");
		Response response = Response.status(400).entity(error).build();

		throw new WebApplicationException(response);
		
	}

	public static void invalidPrice() {

		itemError error = new itemError();
		error.setId(103);
		error.setMessage("Price must not exceed 6 digits.");
		Response response = Response.status(400).entity(error).build();

		throw new WebApplicationException(response);
	}
	
	public static void invalidLocation() {

		itemError error = new itemError();
		error.setId(104);
		error.setMessage("You must select a Location.");
		Response response = Response.status(400).entity(error).build();

		throw new WebApplicationException(response);
	}
	
	public static void invalidImg() {
		
		itemError error = new itemError();
		error.setId(105);
		error.setMessage("Post must have a thumbnail image.");
		Response response = Response.status(400).entity(error).build();

		throw new WebApplicationException(response);
		
	}

	public static void invalidUpdate() {
		itemError error = new itemError();
		error.setId(106);
		error.setMessage("Invalid update. Some fields are blank.");

		Response response = Response.status(400).entity(error).build();

		throw new WebApplicationException(response);
	}

	public static void noConError() {
		itemError error = new itemError();
		error.setId(107);
		error.setMessage("You must have contact information!");
		Response response = Response.status(400).entity(error).build();

		throw new WebApplicationException(response);
		
	}

	public static void noLocError() {
		itemError error = new itemError();
		error.setId(108);
		error.setMessage("You must give a seller location!");
		Response response = Response.status(400).entity(error).build();

		throw new WebApplicationException(response);
		
	}

	public static void noDescError() {
		itemError error = new itemError();
		error.setId(109);
		error.setMessage("You must give an item description!");
		Response response = Response.status(400).entity(error).build();

		throw new WebApplicationException(response);
		
	}

	public static void noPriceError() {
		itemError error = new itemError();
		error.setId(110);
		error.setMessage("You must have a price value!");
		Response response = Response.status(400).entity(error).build();

		throw new WebApplicationException(response);
		
	}

	public static void noNameError() {
		itemError error = new itemError();
		error.setId(111);
		error.setMessage("You must insert an item name!");
		Response response = Response.status(400).entity(error).build();

		throw new WebApplicationException(response);
		
	}


}
