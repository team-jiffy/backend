package com.jiffydelivery.jiffy.Entity.Response.PaymentsResponse;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@EqualsAndHashCode
@ToString

public class DeletePaymentResponse {
    private String status;
    private String message;
}
