package ro.msg.learning.shop.converter;

import org.springframework.stereotype.Component;
import ro.msg.learning.shop.dto.SupplierDto;
import ro.msg.learning.shop.entity.Supplier;

@Component
public class ConverterSupplier extends ConverterWrapper<Supplier, SupplierDto> {

    @Override
    public Supplier getEntity(SupplierDto supplierDto) {
        Supplier supp = new Supplier(supplierDto.getName());
        supp.setId(supplierDto.getSupplierId());

        return supp;
    }

    @Override
    public SupplierDto getDto(Supplier supplier) {
        return new SupplierDto(supplier.getId(), supplier.getName());
    }
}
