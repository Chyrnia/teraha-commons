package com.teraha.commons.entities.settings;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OrderBy;
import jakarta.persistence.Table;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;

import com.teraha.commons.entities.BaseEntity;
import com.teraha.commons.entities.settings.enums.EmailFrequency;

@Getter
@Setter
@Entity
@Table(name = "email_settings")
public class EmailSettings extends BaseEntity {

    @Column(name = "sender_email", nullable = false, length = 320)
    private String senderEmail;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false, length = 40)
    private EmailFrequency frequency = EmailFrequency.DAILY_AT_CLOSE;

    @Column(name = "default_message", nullable = false, columnDefinition = "TEXT")
    private String defaultMessage;

    @Column(name = "include_low_stock", nullable = false)
    private boolean includeLowStock = true;

    @Column(name = "include_sales_metrics", nullable = false)
    private boolean includeSalesMetrics = true;

    @OneToMany(
        mappedBy = "emailSettings",
        cascade = CascadeType.ALL,
        orphanRemoval = true
    )
    @OrderBy("id ASC")
    @Setter(AccessLevel.NONE)
    private List<EmailRecipient> recipients = new ArrayList<>();

    protected EmailSettings() {}

    public void addRecipient(String email) {
        EmailRecipient recipient = new EmailRecipient(email);
        recipient.setEmailSettings(this);
        recipients.add(recipient);
    }

    public void removeRecipient(EmailRecipient recipient) {
        if (recipients.remove(recipient)) {
            recipient.setEmailSettings(null);
        }
    }

    public void replaceRecipients(List<String> emails) {
        Objects.requireNonNull(emails);

        recipients.clear();

        for (String email : emails) {
            addRecipient(email);
        }
    }
}
