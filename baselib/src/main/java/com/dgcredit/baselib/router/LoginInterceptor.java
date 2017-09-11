package com.dgcredit.baselib.router;

import android.content.Context;
import android.content.DialogInterface;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;
import android.util.Log;

import com.alibaba.android.arouter.facade.Postcard;
import com.alibaba.android.arouter.facade.annotation.Interceptor;
import com.alibaba.android.arouter.facade.callback.InterceptorCallback;
import com.alibaba.android.arouter.facade.template.IInterceptor;
import com.alibaba.android.arouter.facade.template.IProvider;
import com.alibaba.android.arouter.launcher.ARouter;
import com.dgcredit.baselib.BaseApplication;
import com.dgcredit.baselib.R;
import com.dgcredit.baselib.router.MainLooper;

/**
 * 类描述:
 * 创建人:aBen
 * 创建时间:2017/8/29
 * 备注:
 */
// 比较经典的应用就是在跳转过程中处理登陆事件，这样就不需要在目标页重复做登陆检查
// 拦截器会在跳转之间执行，多个拦截器会按优先级顺序依次执行
@Interceptor(priority = 90, name = "测试用拦截器")
public class LoginInterceptor implements IInterceptor {
    private boolean flag = false;

    @Override
    public void process(Postcard postcard, InterceptorCallback callback) {
        Log.i("TAG", postcard.toString());
//        ARouter.getInstance().build("/moduleb/b").navigation();
//        callback.onInterrupt(null);
        callback.onContinue(postcard);// 处理完成，交还控制权
    }

    @Override
    public void init(Context context) {
        Log.i("TAG", "初始化ARouter---》LoginInterceptor");

    }
}
