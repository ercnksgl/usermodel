package com.ek.email.usermodel.base;

/**
 * Created by ASUSNB on 7.11.2017.
 */

public interface IBasePresenter<V extends BaseView> {
    void onAttach(BaseView v);
    void onDettach();
}
