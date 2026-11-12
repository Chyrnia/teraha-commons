package com.teraha.commons.entities.settings;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.MapsId;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

import lombok.Getter;
import lombok.Setter;

import com.teraha.commons.entities.User;
import com.teraha.commons.entities.settings.enums.AccentColor;
import com.teraha.commons.entities.settings.enums.SidebarBehavior;
import com.teraha.commons.entities.settings.enums.TableDensity;

@Getter
@Setter
@Entity
@Table(name = "user_appearance_settings")
public class UserAppearanceSettings {

    @Id
    @Column(name = "user_id")
    private Long userId;

    @MapsId
    @OneToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @Enumerated(EnumType.STRING)
    @Column(name = "accent_color", nullable = false, length = 40)
    private AccentColor accentColor = AccentColor.EMERALD_NEON;

    @Enumerated(EnumType.STRING)
    @Column(name = "table_density", nullable = false, length = 40)
    private TableDensity tableDensity = TableDensity.NORMAL;

    @Enumerated(EnumType.STRING)
    @Column(name = "sidebar_behavior", nullable = false, length = 40)
    private SidebarBehavior sidebarBehavior = SidebarBehavior.EXPANDED;

    protected UserAppearanceSettings() {}

    public UserAppearanceSettings(User user) {
        this.user = user;
    }
}
