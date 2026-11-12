package com.teraha.commons.entities.settings;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

import lombok.Getter;
import lombok.Setter;

import com.teraha.commons.entities.BaseEntity;

@Getter
@Setter
@Entity
@Table(name = "email_recipients")
public class EmailRecipient extends BaseEntity {

    @Column(nullable = false, length = 320)
    private String email;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "email_settings_id", nullable = false)
    private EmailSettings emailSettings;

    protected EmailRecipient() {}

    EmailRecipient(String email) {
        this.email = email;
    }
}
