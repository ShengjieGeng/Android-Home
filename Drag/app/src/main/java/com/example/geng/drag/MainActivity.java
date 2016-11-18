package com.example.geng.drag;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

import android.app.ActionBar;
import android.app.ListActivity;
import android.content.Context;
import android.graphics.Color;
import android.graphics.PointF;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.print.PrintAttributes;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutCompat;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.Scroller;
import android.widget.SimpleAdapter;
import android.widget.TextClock;
import android.widget.TextView;
import com.example.geng.drag.domain.Cheeses;
import com.example.geng.drag.ui.GooViewListener;
import com.example.geng.drag.util.Utils;

import static java.security.AccessController.getContext;

public class MainActivity extends AppCompatActivity {
    private MediaPlayer mPlayer;
    public String [] names={"melon","adam","eve"};
    public int [] images={R.mipmap.head,R.mipmap.head2,R.mipmap.head3};
    public String [] numbers={"19","17","123"};
    public final String [] messages={"好久不见 ","有时间出来吃饭啊",
                        "浪啊啦拉拉到了那里嘎朗啊咖喱拉拉呱辣咖喱块蛋糕卡拉的概率拉个啦"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_touch_screen);
        ListView listAdapter = (ListView) findViewById(R.id.list);
        listAdapter.setAdapter(baseAdapter);

//        listAdapter.setAdapter(new MyAdapter(this, R.layout.layout_list_item,
//                android.R.id.text1, Cheeses.sCheeseStrings));

        mPlayer = MediaPlayer.create(this, R.raw.burst);
        mPlayer.setVolume(0.4f, 0.4f);
    }
    BaseAdapter baseAdapter = new BaseAdapter() {
        HashSet<Integer> mRemoved = new HashSet<Integer>();

        @Override
        public int getCount() {
            return names.length;
        }

        @Override
        public Object getItem(int position) {
            return null;
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(final int position, View convertView, ViewGroup parent) {
            RelativeLayout rl=new RelativeLayout(MainActivity.this);
            rl.setLayoutParams(new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.WRAP_CONTENT,
                                                                RelativeLayout.LayoutParams.WRAP_CONTENT));
            //头像
            CircleImageView circleImageView=new CircleImageView(MainActivity.this);
            circleImageView.setImageResource(images[position]);
            circleImageView.setId(R.id.head);
            RelativeLayout.LayoutParams ivLp = new RelativeLayout.LayoutParams(
                                            RelativeLayout.LayoutParams.WRAP_CONTENT, RelativeLayout.LayoutParams.WRAP_CONTENT);
            ivLp.addRule(RelativeLayout.ALIGN_PARENT_LEFT,RelativeLayout.TRUE);
            ivLp.addRule(RelativeLayout.CENTER_VERTICAL,RelativeLayout.TRUE);
            rl.addView(circleImageView,ivLp);
            //姓名
            TextView tvName = new TextView(MainActivity.this);
            tvName.setText(names[position]);
            tvName.setTextSize(20);
            tvName.setTextColor(Color.BLACK);
            tvName.setId(R.id.name);
            RelativeLayout.LayoutParams nameLp = new RelativeLayout.LayoutParams(
                    RelativeLayout.LayoutParams.WRAP_CONTENT, RelativeLayout.LayoutParams.WRAP_CONTENT);
            nameLp.addRule(RelativeLayout.ALIGN_TOP,circleImageView.getId());
            nameLp.addRule(RelativeLayout.RIGHT_OF,circleImageView.getId());
            rl.addView(tvName,nameLp);
            //消息
            TextView tvMessage = new TextView(MainActivity.this);
            tvMessage.setText(messages[position]);
            tvMessage.setTextSize(15);
            tvMessage.setTextColor(Color.GRAY);
            tvMessage.setId(R.id.message);
            tvMessage.setSingleLine(true);
            tvMessage.setWidth(getWindowManager().getDefaultDisplay().getWidth()*3/4);
            RelativeLayout.LayoutParams messageLp = new RelativeLayout.LayoutParams(
                    RelativeLayout.LayoutParams.WRAP_CONTENT, RelativeLayout.LayoutParams.WRAP_CONTENT);
            messageLp.addRule(RelativeLayout.RIGHT_OF,circleImageView.getId());
            messageLp.addRule(RelativeLayout.BELOW,tvName.getId());
            rl.addView(tvMessage,messageLp);
            //时间
            TextClock tvClock = new TextClock(MainActivity.this);
            RelativeLayout.LayoutParams clockLp = new RelativeLayout.LayoutParams(
                    RelativeLayout.LayoutParams.WRAP_CONTENT, RelativeLayout.LayoutParams.WRAP_CONTENT);
            clockLp.addRule(RelativeLayout.ALIGN_PARENT_TOP,RelativeLayout.TRUE);
            clockLp.addRule(RelativeLayout.ALIGN_PARENT_RIGHT,RelativeLayout.TRUE);
            rl.addView(tvClock,clockLp);

            //消息数量
            TextView tvNum = new TextView(MainActivity.this);
            tvNum.setText(Integer.parseInt(numbers[position])>99 ? "99+":numbers[position]);
            tvNum.setId(R.id.num);
            tvNum.setTextColor(Color.WHITE);
            tvNum.setGravity(Gravity.CENTER);
            tvNum.setBackground(getResources().getDrawable(R.drawable.red_bg));
            RelativeLayout.LayoutParams numLp = new RelativeLayout.LayoutParams(
                    RelativeLayout.LayoutParams.WRAP_CONTENT, RelativeLayout.LayoutParams.WRAP_CONTENT);
            numLp.addRule(RelativeLayout.ALIGN_PARENT_RIGHT);
            numLp.addRule(RelativeLayout.CENTER_VERTICAL);
            numLp.setMargins(0,20,30,0);
            rl.addView(tvNum,numLp);


            boolean visiable = !mRemoved.contains(position);
            tvNum.setVisibility(visiable ? View.VISIBLE : View.GONE);
            if (visiable) {
                tvNum.setTag(position);
                GooViewListener mGooListener = new GooViewListener(MainActivity.this, tvNum) {
                    @Override
                    public void onDisappear(PointF mDragCenter) {
                        super.onDisappear(mDragCenter);

                        mPlayer.start();
                        mRemoved.add(position);
                        notifyDataSetChanged();
                        Utils.showToast(MainActivity.this,
                                "Cheers! We have get rid of it!");
                    }

                    @Override
                    public void onReset(boolean isOutOfRange) {
                        super.onReset(isOutOfRange);

                        notifyDataSetChanged();
                        Utils.showToast(MainActivity.this,
                                isOutOfRange ? "Are you regret?" : "Try again!");
                    }
                };
                tvNum.setOnTouchListener(mGooListener);
            }
            return rl;
        }
    };
    class MyAdapter extends ArrayAdapter<String> {

        HashSet<Integer> mRemoved = new HashSet<Integer>();

        public MyAdapter(Context context, int resource, int textViewResourceId,
                         String[] objects) {
            super(context, resource, textViewResourceId, objects);

        }
        @Override
        public View getView(final int position, View convertView,
                            ViewGroup parent) {
            View view = super.getView(position, convertView, parent);

            TextView mUnreadView = (TextView) view.findViewById(R.id.point);
            boolean visiable = !mRemoved.contains(position);
            mUnreadView.setVisibility(visiable ? View.VISIBLE : View.GONE);

            if (visiable) {
                mUnreadView.setText(String.valueOf(position));
                mUnreadView.setTag(position);
                GooViewListener mGooListener = new GooViewListener(
                        getContext(), mUnreadView) {
                    @Override
                    public void onDisappear(PointF mDragCenter) {
                        super.onDisappear(mDragCenter);

                        mPlayer.start();
                        mRemoved.add(position);
                        notifyDataSetChanged();
                        Utils.showToast(getContext(),
                                "Cheers! We have get rid of it!");
                    }

                    @Override
                    public void onReset(boolean isOutOfRange) {
                        super.onReset(isOutOfRange);

                        notifyDataSetChanged();
                        Utils.showToast(getContext(),
                                isOutOfRange ? "Are you regret?" : "Try again!");
                    }
                };
                mUnreadView.setOnTouchListener(mGooListener);
            }
            return view;
        }

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (mPlayer != null) {
            mPlayer.release();
        }
    }

}

