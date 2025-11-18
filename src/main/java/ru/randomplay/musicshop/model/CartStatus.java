package ru.randomplay.musicshop.model;

public enum CartStatus {
    ACTIVE,    // Принадлежит клиенту, в процессе заполнения
    COMPLETED  // Заказ оформлен, корзина сохранена в order
}
