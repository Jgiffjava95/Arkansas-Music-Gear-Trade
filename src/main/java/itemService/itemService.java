package itemService;

import java.util.List;

import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Response;

import mockDao.itemDbDao;
import mockDao.itemMockDao;
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
		validatePrice(newItem.getItemPrice());
		validateDesc(newItem.getItemDesc());
		validateLocation(newItem.getLocation());
		validateContact(newItem.getContact());
		validateImage(newItem.getThumbnail());
		List<item> itemToAdd = dao.insert(newItem);
		return itemToAdd;
	}

	private void validateImage(String thumbnail) {
		if (thumbnail == null) {
			ErrorResponse.invalidImg();
		}
		return;
	}

	public List<item> updateItem(item updateItem) {
		validateName(updateItem.getItemName());
		validatePrice(updateItem.getItemPrice());
		validateDesc(updateItem.getItemDesc());
		validateLocation(updateItem.getLocation());
		validateContact(updateItem.getContact());
		validateImage(updateItem.getThumbnail());
		List<item> itemToAdd = dao.updateItem(updateItem);
		return itemToAdd;
	}

	/*
	 * public List<item> getByCategory(String itemCat) { return
	 * dao.getByCategory(itemCat); }
	 */
	private void validateContact(String contact) {
		if (contact.length() > 100) {
			ErrorResponse.invalidContact();
		}
		return;
	}	
	
	private void validateLocation(String location) {
		if (location.length() > 50) {
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

}
