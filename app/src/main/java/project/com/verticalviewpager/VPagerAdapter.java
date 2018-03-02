package project.com.verticalviewpager;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.List;

/**
 * Created by Ramim on 3/14/2017.
 */

public class VPagerAdapter extends FragmentPagerAdapter {

    List<Fragment> fragments;

    public VPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    public VPagerAdapter(FragmentManager fm, List<Fragment> fragments) {
        super(fm);
        this.fragments=fragments;
    }

    @Override
    public Fragment getItem(int position) {
        return fragments.get(position);
    }

    @Override
    public int getCount() {
        return fragments.size();
    }
}
