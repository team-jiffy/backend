package com.jiffydelivery.jiffy.Entity.FrontModelEntities;

import lombok.*;

@Getter
@Setter
@EqualsAndHashCode
//@AllArgsConstructor
//@NoArgsConstructor
@ToString

public class BriefOrder {
    private long trackNumber;

    private String senderName;
    private String recipientName;
    private String orderDate;
    private String ADVType;
    private String ETA;
    private String orderStatus;

    private BriefOrder(BriefOrderBuilder builder) {
        this.trackNumber = builder.trackNumber;
        this.senderName = builder.senderName;
        this.recipientName = builder.recipientName;
        this.orderDate = builder.orderDate;
        this.ADVType = builder.ADVType;
        this.ETA = builder.ETA;
        this.orderStatus = builder.orderStatus;
    }

    public static class BriefOrderBuilder {
        private long trackNumber;

        private String senderName;
        private String recipientName;
        private String orderDate;
        private String ADVType;
        private String ETA;
        private String orderStatus;

        public BriefOrderBuilder trackNumber(long trackNumber) {
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
