package ro.msg.learning.shop.converter;

import org.springframework.stereotype.Component;
import ro.msg.learning.shop.dto.AddressDto;
import ro.msg.learning.shop.entity.Address;

@Component
public class ConverterAddress extends ConverterWrapper<Address, AddressDto>{

    @Override
    public Address getEntity(AddressDto addressDto) {

        Address address = Address.builder()
                .streetAddress(addressDto.getAddressStreet())
                .city(addressDto.getAddressCity())
                .country(addressDto.getAddressCountry())
                .county(addressDto.getAddressCounty())
                .build();
        address.setId(addressDto.getAddressId());

        return address;
    }

    @Override
    public AddressDto getDto(Address address) {

        return AddressDto.builder()
                .addressCity(address.getStreetAddress())
                .addressCountry(address.getCountry())
                .addressStreet(address.getStreetAddress())
                .addressCounty(address.getCounty())
                .addressId(address.getId())
                .build();
    }
}
