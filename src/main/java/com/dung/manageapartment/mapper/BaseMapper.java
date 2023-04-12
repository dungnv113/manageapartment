package com.dung.manageapartment.mapper;

import java.util.List;

public interface BaseMapper<E, D> {
    E convertToEntity(D dto);

    D convertToDto(E entity);

    List<E> convertToListEntity(List<D> dtos);

    List<D> convertToListDto(List<E> entities);
}
