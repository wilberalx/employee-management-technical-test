package com.wilber.adventureworks.employeemanagement.domain.entities.sales

enum class OrderStatus(val id: Int, val description: String) {
    IN_PROCESS(1, "In Process"),
    APPROVED(2, "Approved"),
    BACKORDERED(3, "Backordered"),
    REJECTED(4, "Rejected"),
    SHIPPED(5, "Shipped"),
    CANCELLED(6, "Cancelled");

    companion object {
        fun fromId(id: Int): OrderStatus? = entries.find { it.id == id }
    }
}
