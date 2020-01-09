package mockDao;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import model.item;

public class itemMockDao {
	
	private static int keyCounter = 1;
	private static int getNextKey() {
		return keyCounter = keyCounter + 1;
	}
	
	static LocalDateTime nowDate = LocalDateTime.now();
	
	private static List<item> items = new ArrayList<item>();

	public List<item> getItems() {
		List<item> mockItems = new ArrayList<item>();
		mockItems.addAll(items);
		return mockItems;
	}

	public List<item> getById(int itemId) {
		List<item> mockItems = new ArrayList<item>();
		for (item i : itemMockDao.items) {
			if (i.getItemId() == itemId) {
				mockItems.add(i);
			}
		}
		return mockItems;
	}

	public void deleteMovie(item item) {
		items.remove(item);
		
	}

	public List<item> insert(item newItem) {
		newItem.setItemId(getNextKey());
		newItem.setPostDate(nowDate);
		items.add(newItem);
		
		List<item> myItems = new ArrayList<item>();
		myItems.add(newItem);
		return myItems;
	}

	public List<item> updateItem(item updateItem) {
List<item> myItem = new ArrayList<item>();
		
		for (item i : items) {
			if (i.getItemId() == updateItem.getItemId()) {
				i.setItemName(updateItem.getItemName());
				i.setItemPrice(updateItem.getItemPrice());
				i.setContact(updateItem.getContact());
				i.setItemDesc(updateItem.getItemDesc());
				i.setItemCat(updateItem.getItemCat());
				i.setLocation(updateItem.getLocation());
				myItem.add(i);
			}
		}
		return myItem;
	}

	public List<item> getByCategory(String itemCat) {
		List<item> myItem = new ArrayList<item>();
		
		for (item i : itemMockDao.items) {
			if (i.getItemCat().equalsIgnoreCase(itemCat)) {
				myItem.add(i);
			}
		}
		return myItem;
	}

}
