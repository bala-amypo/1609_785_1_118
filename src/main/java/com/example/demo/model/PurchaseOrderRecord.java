@Entity
public class PurchaseOrderRecord {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String poNumber;
    private Long supplierId;
    private Integer quantity;

    // ✅ Default constructor
    public PurchaseOrderRecord() {
    }

    // ✅ Parameterized constructor
    public PurchaseOrderRecord(String poNumber, Long supplierId, Integer quantity) {
        this.poNumber = poNumber;
        this.supplierId = supplierId;
        this.quantity = quantity;
    }
}
