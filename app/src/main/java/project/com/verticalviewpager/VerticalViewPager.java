package project.com.verticalviewpager;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

import java.util.List;

/**
 * Created by Ramim on 3/14/2017.
 */

public class VerticalViewPager extends ViewPager {



    public VerticalViewPager(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }


    public void init(){
        setPageTransformer(true,new VerticaPageTransformer());

        setOverScrollMode(OVER_SCROLL_NEVER);
    }

    @Override
    public boolean onInterceptTouchEvent(MotionEvent ev) {
        boolean intercepted=super.onInterceptTouchEvent(swapXY(ev));
        swapXY(ev);
        return intercepted;
    }

    @Override
    public boolean onTouchEvent(MotionEvent ev) {
        return super.onTouchEvent(swapXY(ev));
    }

    private MotionEvent swapXY(MotionEvent ev){
        float width=getWidth();
        float height=getHeight();

        float newX=(ev.getY()/height)* width;
        float newY=(ev.getX()/width)* height;

        ev.setLocation(newX,newY);
        return ev;
    }

    private class VerticaPageTransformer implements ViewPager.PageTransformer{

        @Override
        public void transformPage(View page, float position) {
            if(position< -1){
                // This page is way off-screen to the left.
                page.setAlpha(0);
            }else if(position<=1){
                page.setAlpha(1);
                // Counteract the default slide transition
                page.setTranslationX(page.getWidth() * -position);

                //set Y position to swipe in from top
                float yPosition = position * page.getHeight();
                page.setTranslationY(yPosition);

            }else{
                page.setAlpha(0);
            }

        }
    }

}
