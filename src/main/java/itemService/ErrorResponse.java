package itemService;

import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Response;

public class ErrorResponse {

	public static void invalidDesc() {

		itemError error = new itemError();
		error.setId(100);
		error.setMessage("Description must not excede 500 characters.");
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
		error.setMessage("Location must not exceed 50 characters.");
		Response response = Response.status(400).entity(error).build();

		throw new WebApplicationException(response);
	}
	
	public static void invalidImg() {
		
		itemError error = new itemError();
		error.setId(105);
		error.setMessage("Posting must have a thumbnail image.");
		Response response = Response.status(400).entity(error).build();

		throw new WebApplicationException(response);
		
	}


	public static void invalidUpdate() {
		itemError error = new itemError();
		error.setId(106);
		error.setMessage("Invalid update request.");

		Response response = Response.status(400).entity(error).build();

		throw new WebApplicationException(response);
	}

}
