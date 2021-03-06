/*
 * Copyright (C) 2017 The Dirty Unicorns Project
 * Copyright (C) 2018 AquariOS
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.aquarios.coralreef.tabs;

import android.os.Bundle;
import android.support.v7.preference.Preference;
import android.support.v7.preference.PreferenceCategory;
import android.support.v7.preference.PreferenceScreen;
import android.support.v14.preference.PreferenceFragment;
import android.preference.Preference.OnPreferenceChangeListener;

import com.android.settings.applications.LayoutPreference;
import com.android.settings.R;
import com.android.settings.SettingsPreferenceFragment;
import com.android.internal.logging.nano.MetricsProto;

public class ButtonsTab extends SettingsPreferenceFragment implements Preference.OnPreferenceChangeListener {

    private static final String POWERMENU_CATEGORY = "powermenu_category";
    private static final String NAVIGATION_CATEGORY = "navigationbar_settings";
    private static final String VOLUME_ROCKER_CATEGORY = "volume_rocker_category";
    private static final String HWKEY_CATEGORY = "hw_keys_category";

    private LayoutPreference mPowerMenu;
    private LayoutPreference mNavigation;
    private LayoutPreference mVolumeRocker;
    private LayoutPreference mHwKeys;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        addPreferencesFromResource(R.xml.buttons_tab);

        mPowerMenu = (LayoutPreference) findPreference(POWERMENU_CATEGORY);
        mPowerMenu.setTitle(R.string.powermenu_title);

        mNavigation = (LayoutPreference) findPreference(NAVIGATION_CATEGORY);
        mNavigation.setTitle(R.string.navigationbar_title);

        mVolumeRocker = (LayoutPreference) findPreference(VOLUME_ROCKER_CATEGORY);
        mVolumeRocker.setTitle(R.string.volume_rocker_title);

        mHwKeys = (LayoutPreference) findPreference(HWKEY_CATEGORY);

        if (getResources().getInteger(com.android.internal.R.integer.config_deviceHardwareKeys) == 0) {
            PreferenceScreen prefScreen = getPreferenceScreen();
            prefScreen.removePreference(mHwKeys);
        } else {
            mHwKeys.setTitle(R.string.hw_keys_title);
        }
    }

    @Override
    public void onResume() {
        super.onResume();
    }

    @Override
    public void onPause() {
        super.onPause();
    }

    public boolean onPreferenceChange(Preference preference, Object objValue) {
        final String key = preference.getKey();
        return false;
    }

    @Override
    public int getMetricsCategory() {
        return MetricsProto.MetricsEvent.AQUA;
    }
}
