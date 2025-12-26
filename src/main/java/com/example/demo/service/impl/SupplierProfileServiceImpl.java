@Service
public class SupplierProfileServiceImpl implements SupplierProfileService {

    @Autowired
    private SupplierProfileRepository supplierRepo;

    @Override
    public SupplierProfile createSupplier(SupplierProfile supplier) {
        return supplierRepo.save(supplier);
    }

    @Override
    public SupplierProfile getSupplierById(Long id) {
        return supplierRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("Supplier not found"));
    }

    @Override
    public Optional<SupplierProfile> getBySupplierCode(String supplierCode) {
        return supplierRepo.findBySupplierCode(supplierCode);
    }

    @Override
    public List<SupplierProfile> getAllSuppliers() {
        return supplierRepo.findAll();
    }

    @Override
    public SupplierProfile updateSupplierStatus(Long id, Boolean active) {
        SupplierProfile supplier = getSupplierById(id);
        supplier.setActive(active);
        return supplierRepo.save(supplier);
    }
}
