package com.retrofit.recyitemtouchhelper.adapter;


import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.retrofit.recyitemtouchhelper.ItemInterface.IOperationData;
import com.retrofit.recyitemtouchhelper.R;

import java.util.Collections;
import java.util.List;

public class MoveAdapter extends RecyclerView.Adapter<MoveAdapter.MoveHolder> implements IOperationData {

	private List<String> mDataList;
	private LayoutInflater mInflater;
	private Context mContext;

	public MoveAdapter(Context context) {
		this.mContext = context;
		mInflater =LayoutInflater.from(mContext);
	}

	MoveAdapter(List<String> dataList) {
		mDataList = dataList;
	}

	public void setData(List<String> dataList) {
		mDataList = dataList;
		notifyDataSetChanged();
	}

	@Override
	public MoveHolder onCreateViewHolder(ViewGroup parent, int viewType) {

		return new MoveHolder(mInflater.inflate(R.layout.item_move, parent, false));
	}

	@Override
	public void onBindViewHolder(MoveHolder holder, int position) {
		holder.mTextTitle.setText(mDataList.get(position));
	}

	@Override
	public int getItemCount() {
		return mDataList == null ? 0 : mDataList.size();
	}

	@Override
	public void onItemMove(int fromPosition, int toPosition) {
		//交换位置
		Collections.swap(mDataList,fromPosition,toPosition);
		notifyItemMoved(fromPosition,toPosition);

	}

	@Override
	public void onItemDissmiss(int position) {
		//移除数据
		mDataList.remove(position);
		notifyItemRemoved(position);
	}

	static class MoveHolder extends RecyclerView.ViewHolder {

		TextView mTextTitle;

		MoveHolder(View itemView) {
			super(itemView);
			mTextTitle = itemView.findViewById(R.id.tv_move);
		}
	}

}
