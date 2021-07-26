package com.gdplabs.payment.model;


import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;

import java.io.Serializable;

public class Payment implements Serializable {

    @Id
    public String id;

    @Indexed(unique = true)
    public String orderId;

    public String status;

    public Payment() {

    }

    public Payment(String orderId, String status) {
        this.orderId = orderId;
        this.status = status;
    }

}
