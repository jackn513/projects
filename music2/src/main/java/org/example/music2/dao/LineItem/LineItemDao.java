package org.example.music2.dao.LineItem;

import org.example.music2.model.LineItem;

import java.util.List;

public interface LineItemDao {

    List<LineItem> getLineItemsBySaleId(int saleId);
}
