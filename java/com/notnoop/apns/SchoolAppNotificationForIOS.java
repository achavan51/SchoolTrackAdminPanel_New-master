package com.notnoop.apns;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Date;
import java.util.Map;
import java.util.Map.Entry;
import com.notnoop.exceptions.InvalidSSLConfig;

public class SchoolAppNotificationForIOS {

    /**
     * @param args Program arguments
     * @throws FileNotFoundException
     * @throws InvalidSSLConfig
     */
    public static void sendNotification(String goodToken, String strMessage) throws InvalidSSLConfig, FileNotFoundException {
         

        final ApnsDelegate delegate = new ApnsDelegate() {
            public void messageSent(final ApnsNotification message, final boolean resent) {
                System.out.println("Sent message " + message + " Resent: " + resent);
            }

            public void messageSendFailed(final ApnsNotification message, final Throwable e) {
                System.out.println("Failed message " + message);

            }

            public void connectionClosed(final DeliveryError e, final int messageIdentifier) {
                System.out.println("Closed connection: " + messageIdentifier + "\n   deliveryError " + e.toString());
            }

            public void cacheLengthExceeded(final int newCacheLength) {
                System.out.println("cacheLengthExceeded " + newCacheLength);

            }

            public void notificationsResent(final int resendCount) {
                System.out.println("notificationResent " + resendCount);
            }
        };

        final ApnsService svc = APNS.newService()
                .withCert("/media/mujib/Educational/IOSCertificate/Certificates.p12", "apple")
                .withDelegate(delegate)
                .build();

     

        final String payload = APNS.newPayload().alertBody(strMessage).build();

        svc.start();
        System.out.println("Sending message");
        final ApnsNotification goodMsg = svc.push(goodToken, payload);
        System.out.println("Message id: " + goodMsg.getIdentifier());

        System.out.println("Getting inactive devices");

        final Map<String, Date> inactiveDevices = svc.getInactiveDevices();
        System.out.println("Map----"+inactiveDevices);
        for (final Entry<String, Date> ent : inactiveDevices.entrySet()) {
            System.out.println("Inactive " + ent.getKey() + " at date " + ent.getValue());
        }
        System.out.println("Stopping service");
        svc.stop();
    }
}
