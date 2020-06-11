package com.cinema.model.mapper;

public interface ItemMapper<E, Q, S> {
    E toEntity(Q dto);

    S toDto(E entity);
}
