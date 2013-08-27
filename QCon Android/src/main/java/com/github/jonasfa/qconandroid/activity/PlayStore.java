package com.github.jonasfa.qconandroid.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;
import com.github.jonasfa.qconandroid.R;

public class PlayStore extends FragmentActivity {
    private static final String EXTRA_THEME = "theme";

    protected void onCreate(Bundle savedInstanceState) {
        setTheme(getIntent().getIntExtra(EXTRA_THEME, R.style.Theme_QConAndroid_PlayStore_Blue));

        super.onCreate(savedInstanceState);
        setContentView(R.layout.play_store);

        ViewPager mViewPager = (ViewPager) findViewById(R.id.pager);
        mViewPager.setAdapter(new SectionsPagerAdapter(getSupportFragmentManager()));
    }

    public void launchRed(View view) {
        relaunchWithTheme(R.style.Theme_QConAndroid_PlayStore_Red);
    }

    public void launchGreen(View view) {
        relaunchWithTheme(R.style.Theme_QConAndroid_PlayStore_Green);
    }

    public void launchBlue(View view) {
        relaunchWithTheme(R.style.Theme_QConAndroid_PlayStore_Blue);
    }

    private void relaunchWithTheme(int theme) {
        finish();
        Intent intent = new Intent(this, getClass());
        intent.putExtra(EXTRA_THEME, theme);
        startActivity(intent);
    }

    public class SectionsPagerAdapter extends FragmentPagerAdapter {
        public SectionsPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        public Fragment getItem(int position) {
            return new Fragment();
        }

        public int getCount() {
            return 1;
        }

        public CharSequence getPageTitle(int position) {
            return "Color";
        }
    }
}
