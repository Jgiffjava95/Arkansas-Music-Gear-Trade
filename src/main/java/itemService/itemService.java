package itemService;

import java.util.List;

import mockDao.itemDbDao;
import model.EmailMessage;
import model.item;

public class itemService {

	private itemDbDao dao = new itemDbDao();
	private validation validate = new validation();

	public List<item> getAllItems() {
		return dao.getAllItems();
	}

	public List<item> deleteItem(int itemId) {
		List<item> itemToDelete = dao.getItemsById(itemId);

		if (itemToDelete.size() == 1) {

			dao.deleteItem(itemToDelete.get(0));
		}

		return itemToDelete;

	}

	public List<item> insert(item newItem) {
		validate.validateAll(newItem);
		List<item> itemToAdd = dao.insert(newItem);
		//SnsPub.publishNewItem(newItem);
		return itemToAdd;
	}

	public List<item> updateItem(item updateItem) {
		validate.validateAll(updateItem);
		List<item> itemToUpdate = dao.updateItem(updateItem);
		return itemToUpdate;
	}

	public List<item> getById(int itemId) {
		return dao.getItemsById(itemId);
	}

	public String sendEmail(EmailMessage emailMessage) {
		SnsPub service = new SnsPub();
		String messageId = service.sendEmail(emailMessage);
		return messageId;
	}

}
