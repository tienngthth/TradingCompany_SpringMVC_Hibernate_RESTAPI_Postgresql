package model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import javax.persistence.*;

/*
    No REST API is created to directly create, update, display, delete any records from this entity.
    When a record from this entity is displayed via inventoryDeliveryNote's records, only id, product and quantity are displayed.
    This entity's records are created, updated via inventoryDeliveryNote's record.
    This entity's records won't be deleted by any cases when working with other APIs.
*/
@Entity
@Table(name = "inventoryReceivingNoteDetail")
public class InventoryReceivingNoteDetail {
    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;

    @Column (nullable = false)
    private Integer quantity;

    @ManyToOne
    @JsonIgnore
    @JoinColumn(name = "receiving_note_id")
    private InventoryReceivingNote note;

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public InventoryReceivingNote getNote() {
        return note;
    }

    public void setNote(InventoryReceivingNote note) {
        this.note = note;
    }

}
