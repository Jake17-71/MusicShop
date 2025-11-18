package ru.randomplay.musicshop.model;

public enum PaymentStatus {
    PAID,      // Оплачено
    PENDING,   // Ожидает оплаты
    REFUNDED,  // Возврат средств
    FAILED     // Оплата не удалась
}
