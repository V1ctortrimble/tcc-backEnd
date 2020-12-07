package com.unicesumar.ads.tcc.converter;

import java.util.ArrayList;
import java.util.List;

public abstract class DTOEntityConverter<D, E> {

    public D toDTO(E entity) {
        if (entity == null) {
            return null;
        }
        return toDTOImp(entity);
    }

    public E toEntity(D dto) {
        if (dto == null) {
            return null;
        }
        return toEntityImp(dto);
    }

    protected abstract D toDTOImp(E entity);

    protected abstract E toEntityImp(D dto);

    public List<D> toDTOList(List<E> entities) {
        List<D> dto = new ArrayList<>();

        if (entities != null) {
            for (E e : entities) {
                dto.add(toDTO(e));
            }
        }
        return dto;
    }

    public List<E> toEntityList(List<D> dto) {
        List<E> entities = new ArrayList<>();

        if (dto != null) {
            for (D d : dto) {
                entities.add(toEntity(d));
            }
        }
        return entities;
    }

}
