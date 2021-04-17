package com.jiffydelivery.jiffy.Entity.Response.PaymentsResponse;
import lombok.*;

@Getter
@Setter
@ToString
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
public class DeletePaymentResponse {
    private String status;
    private String message;
}
