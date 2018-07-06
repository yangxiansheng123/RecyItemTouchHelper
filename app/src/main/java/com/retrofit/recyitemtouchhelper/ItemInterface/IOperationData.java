package com.retrofit.recyitemtouchhelper.ItemInterface;

/**
 * @author :created by ${yangpf}
 * 时间:2018/7/6 15
 * 邮箱：xxx@.qq.com
 */
public interface IOperationData {
    /**
     * 数据交换
     * @param fromPosition
     * @param toPosition
     */
    void onItemMove(int fromPosition,int toPosition);

    /**
     * 数据删除
     * @param position
     */
    void onItemDissmiss(int position);
}
