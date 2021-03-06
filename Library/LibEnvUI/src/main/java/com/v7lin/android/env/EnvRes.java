package com.v7lin.android.env;

import android.content.Context;
import android.content.res.Resources;
import android.text.TextUtils;

/**
 * @author v7lin E-mail:v7lin@qq.com
 */
public class EnvRes {

	private final int mResid;

	public EnvRes(int resid) {
		super();
		mResid = resid;
	}

	public int getResid() {
		return mResid;
	}

	/**
	 * 判断资源映射结果是否有效
	 */
	public boolean isValid() {
		return mResid > 0;
	}

	public boolean isValid(Context context, Resources originalRes, boolean allowSysRes) {
		if (isValid()) {
			String packageName = originalRes.getResourcePackageName(getResid());
			// MIUI上替换EditText的菜单Drawable会出问题，故而这里将替换系统Drawable资源排除
			if (allowSysRes || TextUtils.equals(packageName, context.getPackageName())) {
				return true;
			}
		}
		return false;
	}
}
