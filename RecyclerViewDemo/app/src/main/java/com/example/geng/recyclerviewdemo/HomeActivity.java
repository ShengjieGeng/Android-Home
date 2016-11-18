package com.example.geng.recyclerviewdemo;

import android.content.DialogInterface;
import android.os.SystemClock;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.example.geng.recyclerviewdemo.adapter.AlphaAnimatorAdapter;
import com.example.geng.recyclerviewdemo.animator.BaseItemAnimator;
import com.example.geng.recyclerviewdemo.animator.ScaleInOutItemAnimator;
import com.example.geng.recyclerviewdemo.animator.SlideInOutBottomItemAnimator;

import java.util.ArrayList;
import java.util.List;

public class HomeActivity extends AppCompatActivity {
    private RecyclerView mRecyclerView;
    private static List<String> mDatas;
    private int images[]={R.drawable.photo,R.drawable.photo2,R.drawable.photo3};
    private HomeAdapter mAdapter;
    private RelativeLayout home;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initData();
        //跟LISTVIEW很像，找到对应点
        mRecyclerView = (RecyclerView) findViewById(R.id.id_recyclerview);
//  //判断当前是竖屏还是横屏：1竖屏，0横屏
//  if(getResources().getConfiguration().orientation==1){
//      // setLayoutManager：设置线性布局管理
//       mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
//      //LinearItemDecoration：线性布局管理器添加分割条
//       mRecyclerView.addItemDecoration(new LinearItemDecoration(this, LinearItemDecoration.VERTICAL_LIST));
//  }else {
//      //setLayoutManager：设置网格布局管理
//      mRecyclerView.setLayoutManager(new GridLayoutManager(this, 3));
//      //为网格布局管理器添加分隔条
//      mRecyclerView.addItemDecoration(new DividerGridItemDecoration(this));
//  }

        //setLayoutManager：设置网格布局管理
        //StaggeredGridLayoutManager.HORIZONTAL时代表多少行，StaggeredGridLayoutManager.VERTICAL代表列数
        //设置动画效果
//        mRecyclerView.setItemAnimator(new DefaultItemAnimator());
        //设置动画效果
        mRecyclerView.setItemAnimator(new SlideInOutBottomItemAnimator(mRecyclerView));
        //为网格布局添加管理器
        mRecyclerView.setLayoutManager(new StaggeredGridLayoutManager(3, StaggeredGridLayoutManager.VERTICAL));
        //为网格布局管理器添加分隔条
        mRecyclerView.addItemDecoration(new DividerGridItemDecoration(this));
        //创建自定义适配器和listAdapter差不多
        mAdapter = new HomeAdapter();

        MyItemClickListener myItemClickListener=new MyItemClickListener() {
            @Override
            public void onItemClick(View view, int postion) {
                    Toast.makeText(HomeActivity.this, mDatas.get(postion)+"被点击了，在CLICK方法里", Toast.LENGTH_SHORT).show();
            }
        };
        MyItemLongClickListener myItemLongClickListener=new MyItemLongClickListener() {
            @Override
            public void onItemLongClick(View view, final int postion) {
                AlertDialog.Builder builder = new AlertDialog.Builder(HomeActivity.this);
                builder.setTitle("删除");
                builder.setMessage("是否删除当前卡片");
                builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        mAdapter.removeData(postion);
                        Toast.makeText(HomeActivity.this,"删除成功", Toast.LENGTH_SHORT).show();
                    }
                });
                builder.setNegativeButton("CANCLE", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(HomeActivity.this,"取消", Toast.LENGTH_SHORT).show();
                    }
                });
                builder.show();
            }
        };
        mAdapter.setOnItemClickListener(myItemClickListener);
        mAdapter.setOnItemLongClickListener(myItemLongClickListener);

        //setAdapter：设置适配器
        mRecyclerView.setAdapter(mAdapter);
//        AlphaAnimatorAdapter alphaAnimatorAdapter = new AlphaAnimatorAdapter(mAdapter,mRecyclerView);
//        mRecyclerView.setAdapter(alphaAnimatorAdapter);
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId())
        {
            case R.id.add:
                mAdapter.addData(1);
                break;
            case R.id.delete:
                mAdapter.removeData(1);
                break;
        }
        return true;
    }
    protected void initData() {
        mDatas = new ArrayList<String>();
        for (int i = 'A'; i <= 'z'; i++)
        {
            mDatas.add("" + (char) i);
        }
    }

    //<com.example.geng.recyclerviewdemo.MyViewHolder>：类作为泛型
    class HomeAdapter extends RecyclerView.Adapter<MyViewHolder> {
        int i=0;
        private MyItemClickListener mItemClickListener;
        private MyItemLongClickListener mItemLongClickListener;
        @Override
        public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            MyViewHolder holder = new MyViewHolder(LayoutInflater.from(HomeActivity.this).inflate(
                    R.layout.item_home,parent, false),mItemClickListener,mItemLongClickListener);
            return holder;
        }

        public void setOnItemClickListener(MyItemClickListener listener){
            this.mItemClickListener = listener;
        }
        public void setOnItemLongClickListener(MyItemLongClickListener listener){
            this.mItemLongClickListener = listener;
        }

        @Override
        public void onBindViewHolder(MyViewHolder holder, int position) {
            int height = (int)(Math.random()*200)+200;
            holder.tvName.setHeight(height);
            holder.tvName.setText(mDatas.get(position));
            holder.circleImageView.setImageResource(images[i++%3]);
            System.out.println("onBindViewHolder");
        }

        @Override
        public int getItemCount() {
            return mDatas.size();
        }

        public void addData(int position) {
            mDatas.add(position, "Insert One");
            notifyItemInserted(position);
        }

        public void removeData(int position) {
            mDatas.remove(position);
            notifyItemRemoved(position);
        }
    }
//    @Override
//    public boolean onTouchEvent(MotionEvent event) {
//        View view = getCurrentFocus();
//            if(view==null) {
//                AlertDialog.Builder builder = new AlertDialog.Builder(HomeActivity.this);
//                builder.setTitle("添加");
//                builder.setMessage("是否添加卡片");
//                builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
//                    @Override
//                    public void onClick(DialogInterface dialog, int which) {
//                        mAdapter.addData(mDatas.size());
//                        Toast.makeText(HomeActivity.this, "添加成功", Toast.LENGTH_SHORT).show();
//                    }
//                });
//                builder.setNegativeButton("CANCLE", new DialogInterface.OnClickListener() {
//                    @Override
//                    public void onClick(DialogInterface dialog, int which) {
//                        Toast.makeText(HomeActivity.this, "取消", Toast.LENGTH_SHORT).show();
//                    }
//                });
//                builder.show();
//            }
//        return true;
//    }
}
