package entities;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = Order.TABLE_NAME)
public class Order extends EntityClass {

    public final static String TABLE_NAME = "Orders";

    private interface Columns {
        String CLIENT = "client_ID";
        String STATUS = "status";
        String COST = "cost";
        String ORDER_DATE = "orderDate";
        String DELIVERY_DATE = "deliveryDate";
    }

    public Order() {

    }

    public Order(Client client, String status, int cost, Date deliveryDate, Date orderDate) {
        setClient(client);
        setStatus(status);
        setCost(cost);
        setDeliveryDate(deliveryDate);
        setOrderDate(orderDate);
    }

    @NotNull
    @ManyToOne(cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.REFRESH})
    @JoinColumn(name = Columns.CLIENT)
    private Client client;


    @OneToMany(mappedBy = "order", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
    List<Element> elements;

    @NotNull
    @Column(name = Columns.STATUS)
    private String status;

    @NotNull
    @Column(name = Columns.COST)
    private int cost;

    @NotNull
    @Column(name = Columns.ORDER_DATE)
    private Date orderDate;

    @NotNull
    @Column(name = Columns.DELIVERY_DATE)
    private Date deliveryDate;

    public Client getClient() {
        return client;
    }

    public void setClient(Client user) {
        this.client = user;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    public Date getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }

    public Date getDeliveryDate() {
        return deliveryDate;
    }

    public void setDeliveryDate(Date deliveryDate) {
        this.deliveryDate = deliveryDate;
    }

    public void addElement(Element element) {
        if (elements == null) {
            elements = new ArrayList<>();
        }
        elements.add(element);
    }

    public List<Element> getElements() {
        return elements;
    }

    @Override
    public String toString() {
        return "Order{" +
                super.toString() +
                "client=" + client +
                ", status='" + status + '\'' +
                ", cost=" + cost +
                ", orderDate=" + orderDate +
                ", deliveryDate=" + deliveryDate +
                '}';
    }
}
