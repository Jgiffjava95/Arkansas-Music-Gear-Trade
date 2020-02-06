package itemService;

import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Response;

public class ErrorResponse {
	
	

	public static void invalidDesc() {

		itemError error = new itemError();
		error.setId(100);
		error.setMessage("Description must be between 1 and 500 characters.");
		Response response = Response.status(400).entity(error).build();

		throw new WebApplicationException(response);

	}

	public static void invalidContact() {

		itemError error = new itemError();
		error.setId(101);
		error.setMessage("Contact Info must be between 1 and 100 characters.");
		Response response = Response.status(400).entity(error).build();

		throw new WebApplicationException(response);
	}

	public static void invalidName() {

		itemError error = new itemError();
		error.setId(102);
		error.setMessage("Item name must be between 1 and 75 characters");
		Response response = Response.status(400).entity(error).build();

		throw new WebApplicationException(response);
	}

	public static void invalidPrice() {
		itemError error = new itemError();
		error.setId(103);
		error.setMessage("Price must be between 1 and 6 digits.");
		Response response = Response.status(400).entity(error).build();

		throw new WebApplicationException(response);
	}
	
	public static void invalidLocation() {

		itemError error = new itemError();
		error.setId(104);
		error.setMessage("Invalid location. Please be sure to select a location from the drop down list.");
		Response response = Response.status(400).entity(error).build();

		throw new WebApplicationException(response);
	}
	
	public static void invalidImg() {
		
		itemError error = new itemError();
		error.setId(105);
		error.setMessage("Invalid image. Empty or invalid image type.");
		Response response = Response.status(400).entity(error).build();

		throw new WebApplicationException(response);
		
	}

	public static void invalidUpdate() {
		itemError error = new itemError();
		error.setId(106);
		error.setMessage("Invalid update. Some fields may be blank or incorrect.");

		Response response = Response.status(400).entity(error).build();

		throw new WebApplicationException(response);
	}
	
	public static void invalidCat() {
		itemError error = new itemError();
		error.setId(107);
		error.setMessage("Invalid item category. Please make sure the field is not blank.");
		Response response = Response.status(400).entity(error).build();

		throw new WebApplicationException(response);
		
	}
	
}
