package com.example.imageslidertestandroid;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
// import android.widget.LinearLayout; // slider.xml의 루트가 LinearLayout이 아니므로 불필요
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;

public class Adapter extends PagerAdapter {

    private int[] images = {R.drawable.image1, R.drawable.image2, R.drawable.image3};
    private LayoutInflater inflater; // 생성자에서 초기화
    // private Context context; // 생성자에서 inflater를 얻는 용도로만 사용한다면 멤버 변수로 유지할 필요 없음

    public Adapter(Context context) {
        // this.context = context; // inflater를 얻는 데만 사용
        this.inflater = LayoutInflater.from(context); // 생성자에서 한 번만 초기화
    }

    @Override
    public int getCount() {
        return images.length;
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        // instantiateItem에서 반환된 객체가 View 그 자체이므로 직접 비교
        return view == object;
    }

    @NonNull // PagerAdapter의 instantiateItem은 @NonNull을 반환하도록 오버라이드
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        // inflater는 생성자에서 초기화됨
        View v = inflater.inflate(R.layout.slider, container, false); // container와 attachToRoot를 false로 전달
        ImageView imageView = v.findViewById(R.id.imageView);
        TextView textView = v.findViewById(R.id.textView);

        // 이미지 설정 (주석 해제)
        imageView.setImageResource(images[position]);

        // 텍스트 설정 (오류 수정)
        textView.setText((position + 1) + "번째 이미지입니다."); // 문자열로 바로 설정

        container.addView(v);
        return v;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        // instantiateItem에서 추가한 뷰를 제거
        container.removeView((View) object);
    }
}
