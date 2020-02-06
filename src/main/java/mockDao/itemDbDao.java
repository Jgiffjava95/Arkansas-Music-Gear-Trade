package mockDao;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;

import javax.xml.bind.DatatypeConverter;

import model.item;

public class itemDbDao {

	private final static String selectAllItems = "SELECT itemId, itemName, itemCat, itemPrice, itemDesc, contact, location, postDate, thumbnail "
			+ " FROM item";

	private final static String selectItemsById = "SELECT itemId, itemName, itemCat, itemPrice, itemDesc, contact, location, postDate, thumbnail "
			+ " FROM item" + " Where itemId = ?";

	private final static String deleteItemsById = " DELETE FROM item " + " Where itemId = ? ";

	private final static String addItems = "INSERT INTO item "
			+ "(itemName, itemCat, itemPrice, itemDesc, contact, location, thumbnail) VALUES "
			+ "(?, ?, ?, ?, ?, ?, ?);";

	private final static String updateItems = "UPDATE item "
			+ "set itemName = ?, itemCat = ?, itemPrice = ?, itemDesc = ?, contact = ?, location = ?, thumbnail = ? "
			+ "WHERE itemId = ?;";

	public List<item> getAllItems() {
		List<item> items = new ArrayList<item>();

		ResultSet result = null;
		Statement statement = null;

		Connection conn = MariaDbUtil.getConnection();

		try {
			statement = conn.createStatement();
			result = statement.executeQuery(selectAllItems);
			while (result.next()) {
				item item = makeItem(result);
				items.add(item);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (conn != null) {
					result.close();
					statement.close();
					conn.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return items;
	}

	private item makeItem(ResultSet result) throws SQLException {
		item item = new item();
		item.setItemId(result.getInt("itemId"));
		item.setItemName(result.getString("itemName"));
		item.setItemCat(result.getString("itemCat"));
		item.setItemPrice(result.getInt("itemPrice"));
		item.setItemDesc(result.getString("itemDesc"));
		item.setContact(result.getString("contact"));
		item.setLocation(result.getString("location"));
		item.setPostDate(result.getObject("postDate", LocalDateTime.class));

		byte[] picture = result.getBytes("thumbnail");
		if (picture != null) {
			String pictureString = DatatypeConverter.printBase64Binary(picture);
			item.setThumbnail(pictureString);
		} else {
			item.setThumbnail(null);
		}

		return item;

	}

	public List<item> getItemsById(int itemId) {
		List<item> items = new ArrayList<item>();

		ResultSet result = null;
		PreparedStatement prepStatement = null;

		Connection conn = MariaDbUtil.getConnection();

		try {
			System.out.println("time to delete item");
			prepStatement = conn.prepareStatement(selectItemsById);
			prepStatement.setInt(1, itemId);
			result = prepStatement.executeQuery();
			while (result.next()) {
				item item = makeItem(result);
				items.add(item);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (conn != null) {
					result.close();
					prepStatement.close();
					conn.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return items;
	}

	public void deleteItem(item item) {

		PreparedStatement prepStatement = null;

		Connection conn = MariaDbUtil.getConnection();

		try {
			prepStatement = conn.prepareStatement(deleteItemsById);
			prepStatement.setInt(1, item.getItemId());
			int rowCount = prepStatement.executeUpdate();
			System.out.println("Rows Deleted: " + rowCount);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (conn != null) {
					prepStatement.close();
					conn.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	public List<item> updateItem(item itemUpdate) {
		List<item> items = new ArrayList<item>();

		PreparedStatement prepStatement = null;

		Connection conn = MariaDbUtil.getConnection();

		try {
			prepStatement = conn.prepareStatement(updateItems);
			prepStatement.setString(1, itemUpdate.getItemName());
			prepStatement.setString(2, itemUpdate.getItemCat());
			prepStatement.setInt(3, itemUpdate.getItemPrice());
			prepStatement.setString(4, itemUpdate.getItemDesc());
			prepStatement.setString(5, itemUpdate.getContact());
			prepStatement.setString(6, itemUpdate.getLocation());
			if (itemUpdate.getThumbnail() != null) {
				InputStream stream = new ByteArrayInputStream(Base64.getDecoder().decode(itemUpdate.getThumbnail()));
				prepStatement.setBlob(7, stream);
			} else {
				prepStatement.setBinaryStream(7, null);
			}
			prepStatement.setInt(8, itemUpdate.getItemId());

			prepStatement.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (conn != null) {
					prepStatement.close();
					conn.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		items.add(itemUpdate);
		return items;
	}

	public List<item> insert(item newItem) {
		List<item> items = new ArrayList<item>();
		PreparedStatement prepStatement = null;
		Connection conn = MariaDbUtil.getConnection();

		try {
			prepStatement = conn.prepareStatement(addItems);
			prepStatement.setString(1, newItem.getItemName());
			prepStatement.setString(2, newItem.getItemCat());
			prepStatement.setInt(3, newItem.getItemPrice());
			prepStatement.setString(4, newItem.getItemDesc());
			prepStatement.setString(5, newItem.getContact());
			prepStatement.setString(6, newItem.getLocation());

			if (newItem.getThumbnail() != null) {
				InputStream stream = new ByteArrayInputStream(Base64.getDecoder().decode(newItem.getThumbnail()));
				prepStatement.setBlob(7, stream);
			} else {
				prepStatement.setBinaryStream(7, null);
			}

			prepStatement.executeUpdate();
			System.out.println("Row Added " + newItem.getItemName());

			newItem.setItemId(getLastKey(conn));
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (conn != null) {
					conn.close();
					prepStatement.close();
					conn.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		items.add(newItem);
		return items;
	}

	private Integer getLastKey(Connection conn) throws SQLException {
		Integer key = 0;
		Statement statement = conn.createStatement();
		ResultSet result = statement.executeQuery(" SELECT_LAST_INSERT_ID() ");

		while (result.next()) {
			key = result.getInt("LAST_INSERT_ID()");
		}
		return key;
	}
}