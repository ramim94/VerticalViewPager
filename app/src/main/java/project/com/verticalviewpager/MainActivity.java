package project.com.verticalviewpager;

import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    VerticalViewPager myVP;
    VPagerAdapter myPagerAdapter;
    List<Fragment> fragments;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        myVP=(VerticalViewPager) findViewById(R.id.vp_flipper);
        fragments=new ArrayList<>();
        fragments.add(new SecondFloor());
        fragments.add(new FirstFloor());
        fragments.add(new GroundFloor());

        myPagerAdapter=new VPagerAdapter(getSupportFragmentManager(),fragments);

        myVP.setAdapter(myPagerAdapter);
        myVP.setCurrentItem(fragments.size(),true);

    }
}
