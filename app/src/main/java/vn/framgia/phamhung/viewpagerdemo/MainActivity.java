package vn.framgia.phamhung.viewpagerdemo;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

import com.ToxicBakery.viewpager.transforms.CubeOutTransformer;

public class MainActivity extends AppCompatActivity {
    private static final int TAB = 0;
    private static final int TAB_ONE = 1;
    private static final int TAB_TWO = 2;
    private ViewPager mViewPager;
    private TabLayout mTabLayout;
    private ViewPagerAdapter mViewPagerAdapter;
    private int[] mTabIcons = {
            R.drawable.android,
            R.drawable.image_php,
            R.drawable.image_ruby
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().hide();
        mViewPager = findViewById(R.id.view_pager);
        mTabLayout = findViewById(R.id.tab_layout);
        mViewPagerAdapter = new ViewPagerAdapter(getSupportFragmentManager());
        mViewPagerAdapter.addFragment(new AndroidFragment(), getString(R.string.title_one));
        mViewPagerAdapter.addFragment(new PhpFragment(), getString(R.string.title_two));
        mViewPagerAdapter.addFragment(new RubyFragment(), getString(R.string.title_three));
        mViewPager.setAdapter(mViewPagerAdapter);
        mTabLayout.setupWithViewPager(mViewPager);
        mViewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(mTabLayout));
        mViewPager.setPageTransformer(true, new CubeOutTransformer());
        mTabLayout.getTabAt(TAB).setIcon(mTabIcons[TAB]);
        mTabLayout.getTabAt(TAB_ONE).setIcon(mTabIcons[TAB_ONE]);
        mTabLayout.getTabAt(TAB_TWO).setIcon(mTabIcons[TAB_TWO]);
    }
}


