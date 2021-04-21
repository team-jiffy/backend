package com.jiffydelivery.jiffy.Entity.FrontModelEntities;

import lombok.*;

@Getter
@Setter
@EqualsAndHashCode
//@AllArgsConstructor
@NoArgsConstructor
@ToString

public class BriefOrder {
    private String trackNumber;

    private String SenderName;
    private String RecipientName;
    private String OrderDate;
    private String ADVType;
    private String ETA;
    private String Status;

    private BriefOrder(BriefOrderBuilder builder) {
        this.trackNumber = builder.trackNumber;
        this.SenderName = builder.senderName;
        this.RecipientName = builder.recipientName;
        this.OrderDate = builder.orderDate;
        this.ADVType = builder.ADVType;
        this.ETA = builder.ETA;
        this.Status = builder.orderStatus;
    }

    public static class BriefOrderBuilder {
        private String trackNumber;

        private String senderName;
        private String recipientName;
        private String orderDate;
        private String ADVType;
        private String ETA;
        private String orderStatus;

        public BriefOrderBuilder trackNumber(String trackNumber) {
            this.trackNumber = trackNumber;
            return this;
        }

        public BriefOrderBuilder senderName(String senderName) {
            this.senderName = senderName;
            return this;
        }

        public BriefOrderBuilder recipientName(String recipientName) {
            this.recipientName = recipientName;
            return this;
        }

        public BriefOrderBuilder orderDate(String orderDate) {
            this.orderDate = orderDate;
            return this;
        }

        public BriefOrderBuilder ADVType(String ADVType) {
            this.ADVType = ADVType;
            return this;
        }

        public BriefOrderBuilder ETA(String ETA) {
            this.ETA = ETA;
            return this;
        }

        public BriefOrderBuilder orderStatus(String orderStatus) {
            this.orderStatus = orderStatus;
            return this;
        }

        public BriefOrder build() {
            return new BriefOrder(this);
        }
    }

}
