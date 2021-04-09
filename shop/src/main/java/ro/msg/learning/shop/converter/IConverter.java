package ro.msg.learning.shop.converter;

public interface IConverter<Entity, Dto> {
    Entity getEntity(Dto dto);

    Dto getDto(Entity entity);
}
