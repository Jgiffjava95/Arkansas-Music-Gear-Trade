package itemService;

import java.util.Arrays;
import java.util.List;
import mockDao.itemDbDao;
import model.EmailMessage;
import model.item;

public class itemService {

	private itemDbDao dao = new itemDbDao();

	public List<item> getAllItems() {
		return dao.getItems();
	}

	public List<item> getById(int itemId) {
		return dao.getItemsById(itemId);
	}

	public List<item> deleteItem(int itemId) {
		List<item> itemToDelete = dao.getItemsById(itemId);

		if (itemToDelete.size() == 1) {

			dao.deleteItem(itemToDelete.get(0));
		}

		return itemToDelete;

	}

	public List<item> insert(item newItem) {
		validateName(newItem.getItemName());
		validateCat(newItem.getItemCat());
		validatePrice(newItem.getItemPrice());
		validateDesc(newItem.getItemDesc());
		validateLocation(newItem.getLocation());
		validateContact(newItem.getContact());
		List<item> itemToAdd = dao.insert(newItem);
		SnsPub.publishNewItem(newItem);
		return itemToAdd;
	}

	public List<item> updateItem(item updateItem) {
		validateName(updateItem.getItemName());
		validateCat(updateItem.getItemCat());
		validatePrice(updateItem.getItemPrice());
		validateDesc(updateItem.getItemDesc());
		validateLocation(updateItem.getLocation());
		validateContact(updateItem.getContact());
		List<item> itemToUpdate = dao.updateItem(updateItem);
		return itemToUpdate;
	}

	/*
	 * public List<item> getByCategory(String itemCat) { return
	 * dao.getByCategory(itemCat); }
	 */

	private void validateImage(String thumbnail) {
		if (thumbnail == null) {
			ErrorResponse.invalidImg();
		}
		return;
	}

	private void validateCat(String itemCat) {
		if (Arrays.asList("Guitar", "Bass", "Drums", "Piano", "Keyboard", "Synth", "Microphone", "Classical", "Wind",
				"Recording", "Software", "Amp/Speaker", "Misc").contains(itemCat)) {
		} else {
			ErrorResponse.invalidCat();
		}
		return;
	}

	private void validateContact(String contact) {
		if (contact.length() > 100) {
			ErrorResponse.invalidContact();
		}
		return;
	}

	private void validateLocation(String location) {
		if (location.length() == 0) {
			ErrorResponse.invalidLocation();
		}
		return;
	}

	private void validateDesc(String itemDesc) {
		if (itemDesc.length() > 500) {
			ErrorResponse.invalidDesc();
		}
		return;
	}

	private void validatePrice(int itemPrice) {
		String numInPrice = String.valueOf(itemPrice);
		if (numInPrice.length() > 6) {
			ErrorResponse.invalidPrice();
		}
		return;
	}

	private void validateName(String itemName) {
		if (itemName.length() > 75) {
			ErrorResponse.invalidName();
		}
		return;
	}
	
	public String sendEmail(EmailMessage emailMessage) {
		SnsPub service = new SnsPub();
		String messageId = service.sendEmail(emailMessage);		
		return messageId;
	}

}
