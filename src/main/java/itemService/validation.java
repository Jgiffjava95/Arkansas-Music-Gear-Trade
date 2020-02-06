package itemService;

import java.util.Arrays;

import model.item;

public class validation {

	public void validateAll(item itemToValidate) {
		validateName(itemToValidate.getItemName());
		validateCat(itemToValidate.getItemCat());
		validatePrice(itemToValidate.getItemPrice());
		validateDesc(itemToValidate.getItemDesc());
		validateLocation(itemToValidate.getLocation());
		validateContact(itemToValidate.getContact());
		validateImage(itemToValidate.getThumbnail());
		
	}

	private void validateImage(String thumbnail) {
		if (thumbnail.equals("")) {
			ErrorResponse.invalidImg();
		} 
		return;
	}

	public void validateCat(String itemCat) {
		if (Arrays.asList("Guitar", "Bass", "Drums", "Piano", "Keyboard", "Synth", "Microphone", "Classical", "Wind",
				"Recording", "Software", "Amp/Speaker", "Misc").contains(itemCat)) {
		} else {
			ErrorResponse.invalidCat();
		}
		return;
	}

	public void validateContact(String contact) {
		if (contact.length() > 100 || contact.length() < 1) {
			ErrorResponse.invalidContact();
		}
		return;
	}

	public void validateLocation(String location) {
		if (Arrays.asList("Little Rock", "North Little Rock", "Fort Smith", "Feyetteville", "Springdale", "Jonesboro",
				"Conway", "Rogers", "Pine Bluff", "Bentonville").contains(location)) {
		} else {
			ErrorResponse.invalidLocation();
		}
		return;
	}

	public void validateDesc(String itemDesc) {
		if (itemDesc.length() > 500 || itemDesc.length() < 1) {
			ErrorResponse.invalidDesc();
		}
		return;
	}

	public void validatePrice(int itemPrice) {
		String numInPrice = String.valueOf(itemPrice);
		if (numInPrice.length() > 6 || numInPrice.length() < 1) {
			ErrorResponse.invalidPrice();
		}
		return;
	}

	public void validateName(String itemName) {
		if (itemName.length() > 75 || itemName.length() < 1) {
			ErrorResponse.invalidName();
		}
		return;
	}

}
