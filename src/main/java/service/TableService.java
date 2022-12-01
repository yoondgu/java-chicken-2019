package service;

import domain.PayType;
import domain.Table;
import domain.TableRepository;
import domain.order.OrderedMenus;
import dto.PayTypeDTO;

import java.util.List;

public class TableService {

    public List<Table> getAllTables() {
        return TableRepository.tables();
    }

    public void addTableOrder(int tableNumber, int menuNumber, int quantity) {
        Table tableForOrder = TableRepository.getTableByNumber(tableNumber);
        tableForOrder.updateOrder(menuNumber, quantity);
    }

    public OrderedMenus getOrderByTable(int tableNumber) {
        Table table = TableRepository.getTableByNumber(tableNumber);
        return table.getOrderMenus();
    }

    public int payOrderByTable(int tableNumber, PayTypeDTO payTypeDTO) {
        Table table = TableRepository.getTableByNumber(tableNumber);
        int totalPrice = table.getTotalPrice();
        table.completeOrder();
        return getTotalPaymentByPayType(payTypeDTO.getPayType(),totalPrice);
    }

    private int getTotalPaymentByPayType(PayType payType, int totalPrice) {
        return PayType.calculatePayment(payType, totalPrice);
    }
}
